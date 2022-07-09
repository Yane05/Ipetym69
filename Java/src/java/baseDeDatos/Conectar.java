package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar{
    
    //declaro las variables que voy a usar de esta
    //forma las hago globales
    public static final String URL = "jdbc:mysql://localhost:3306/ipetym69";
           // + "?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    public static final String USER = "root";
    public static final String CLAVE = "123456";
    
     public Connection conectar_db() throws SQLException{
         
          Connection conexion = null;
         
                  // Intento cargar el driver primeramente
                  try {
                      
	            Class.forName("com.mysql.jdbc.Driver");
	            System.out.println ("Cargado con éxito");
                    
                    } catch (Exception ex) {
	        	 System.out.println ("Error de carga en el driver");
	            // handle the error
                    }
                  
                  
                //luego de cargar el driver , intento la conexion
                try{
            
                    conexion =  DriverManager.getConnection(URL, USER, CLAVE);
                    //JOptionPane.showMessageDialog(null, "Conexión establecida con "
                           // + "éxito a ipetym69");

                }catch(Exception e){
                    System.out.println("Error no se pudo establecer conexión a "
                            + "ipetym69" + e.getMessage());
                }
                
                return conexion;
     }
     
        
     
     
  
}