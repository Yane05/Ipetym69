package servlet;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.LoginEntity;
import escuela.Usuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {

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
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin,"
                + "X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
        //response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");
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
        String contrasenia = "";
        
        for (JsonElement obj : gsonArr) {
            JsonObject gsonObj = obj.getAsJsonObject();
            nombre = gsonObj.get("nombreUsuario").getAsString();
            contrasenia = gsonObj.get("contraseniaUsuario").getAsString();
        }

        Usuario usuarioALoguear = new Usuario(nombre, contrasenia);
        LoginEntity login = new LoginEntity();
        Usuario usuario = new Usuario();

        try {
            usuario = login.login(usuarioALoguear);

            if (usuarioALoguear.getNombre().equals(usuario.getNombre())
                    && usuarioALoguear.getContrasenia().equals(usuario.getContrasenia())) {
                response.setStatus(HttpServletResponse.SC_OK);
                //response.sendRedirect("/docentes");
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                //  response.sendRedirect("/");
            }
        } catch (SQLException ex) {
            Logger.getLogger(docenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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