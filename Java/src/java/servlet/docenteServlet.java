package servlet;

import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.DocenteEntity;
import escuela.Docente;
import java.io.BufferedReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class docenteServlet extends HttpServlet {

    /*
    try{
            String str = "{\"name\":\"John\", \"age\":21 , \"place\":\"Nevada\"}";
          
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            User user = gson.fromJson(str,User.class);
          
            System.out.println(user.ShowAsString());

            str= gson.toJson(user);
            System.out.println("User Object as string : "+str);

        }catch(JsonIOException err){
     */
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /* try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
 /*       out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet docenteServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet docenteServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS,HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, "
                + "X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
        response.setContentType("text/html;charset=UTF-8");
        //    processRequest(request, response);

        try (PrintWriter out = response.getWriter()) {
            String json = "";
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            DocenteEntity conexionDocente = new DocenteEntity();
            ArrayList<Docente> docentes = conexionDocente.listarDocente();
            json = gson.toJson(docentes);
            out.print(json);
        } catch (SQLException ex) {
            Logger.getLogger(docenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonIOException err) {
            System.out.println("Exception : " + err.toString());
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS,HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin,"
                + "X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
        //response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");

        String json = "[" + readJSONStringFromRequest(request) + "]";

        JsonParser parser = new JsonParser();
        JsonArray gsonArr = parser.parse(json).getAsJsonArray();

        String nombre = "";
        String apellido = "";
        int dni = 0 ;
        int telefono = 0 ;
        String email = "";
        String legajo = "";
        
        for (JsonElement obj : gsonArr) {
            JsonObject gsonObj = obj.getAsJsonObject();
            nombre = gsonObj.get("nombre").getAsString();
            apellido = gsonObj.get("apellido").getAsString();
            dni = gsonObj.get("dni").getAsInt();
            telefono = gsonObj.get("telefono").getAsInt();
            email = gsonObj.get("email").getAsString();
            legajo = gsonObj.get("legajo").getAsString();
        }

        Docente nuevoDocente = new Docente(nombre, apellido,dni,telefono,email,legajo);
        DocenteEntity conexionDocente = new DocenteEntity();
        conexionDocente.insertarDocente(nuevoDocente);
    }
    private String readJSONStringFromRequest(HttpServletRequest request) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            sb.append(line + "\n");
            line = reader.readLine();
        }
        reader.close();
        String data = sb.toString();

        return data;
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
