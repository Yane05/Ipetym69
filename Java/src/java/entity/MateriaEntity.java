/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import baseDeDatos.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import escuela.Materia;
/**
 *
 * @author Paula
 */
public class MateriaEntity {
    //METODOS DE LA CLASE MATERIA
    
    private Conectar conexion = new Conectar();
     
     public void listarMateria() throws SQLException{
         
         try{
             
         Connection listar = conexion.conectar_db();
         
         //creamos un objeto statement para consultar
         Statement consulta= listar.createStatement();
         
         /*creamos un objeto result set que es como una tabla virtual en memoria
         con el resultado de la consulta*/
         
         ResultSet resultado = consulta.executeQuery("SELECT * FROM materia");

        while (resultado.next()) {
                System.out.println(resultado.getLong("id")+ " "
                        +resultado.getString("nombre")+ " "
                        +resultado.getString("cursoDivision") +" "
                        +resultado.getString("turno")+ " "
                        +resultado.getString("especialidad") + " "
                        +resultado.getString("situacionRevista")); 
            }
        }catch(SQLException e){
            System.out.println("Error al intentar listar db" + e.getMessage());
        }
         
     }
    
     public void insertarMateria(Materia materia){
         
         String sql=  "INSERT INTO materia(nombre,cursoDivision,turno,especialidad,"
                 + "situacionRevista)"
                 + "VALUES(?,?,?,?,?)";

          try{
             
         Connection insertar = conexion.conectar_db();
         
         PreparedStatement statement = insertar.prepareStatement(sql);
            
            statement.setString(1, materia.getNombre());
            statement.setString(2, materia.getCursoDivision());
            statement.setString(3, materia.getTurno());
            statement.setString(4, materia.getEspecialidad());
            statement.setString(5, materia.getSituacionRevista());
            
            statement.executeUpdate();
            
         //creamos un objeto statement para consulta
         
         /*creamos un objeto result set que es como una tabla virtual en memoria
         con el resultado de la consulta*/
         
         //consulta.executeUpdate(sql);
         
         ResultSet resultado = statement.executeQuery("SELECT * FROM materia");

        while (resultado.next()) {
            System.out.println(resultado.getString("Nombre")+ " "
                        +resultado.getString("cursoDivision")+ " "
                        +resultado.getString("turno") +" "
                        +resultado.getString("especialidad")+" "
                        +resultado.getString("situacionRevista"));
                
            }
        }catch(Exception e){
            System.out.println("Error al intentar insertar db" + e.getMessage());
        }
     }
     
     public void actualizarMateria(){
         
         String sql=  "UPDATE materia SET situacionRevista = 'suplente' WHERE id=1";

          try{
             
         Connection actualizar = conectar_db();
         
         //creamos un objeto statement para consultar
         Statement consulta= actualizar.createStatement();
         
         /*creamos un objeto result set que es como una tabla virtual en memoria
         con el resultado de la consulta*/
         
         consulta.executeUpdate(sql);
         
         ResultSet resultado = consulta.executeQuery("SELECT * FROM materia");

        while (resultado.next()) {
                System.out.println(resultado.getLong("id")+ " "
                        +resultado.getString("nombre")+ " "
                        +resultado.getString("cursoDivision") +" "
                        +resultado.getString("turno")+ " "
                        +resultado.getString("especialidad") + " "
                        +resultado.getString("situacionRevista")); 
            }
        }catch(Exception e){
            System.out.println("Error al intentar listar db" + e.getMessage());
        }
     }
     
     public void borrarMateria(){
         
         String sql=  "DELETE FROM materia WHERE id=1";

          try{
             
         Connection borrar = conectar_db();
         
         //creamos un objeto statement para consultar
         Statement consulta= borrar.createStatement();
         
         /*creamos un objeto result set que es como una tabla virtual en memoria
         con el resultado de la consulta*/
         
         consulta.executeUpdate(sql);
         
         ResultSet resultado = consulta.executeQuery("SELECT * FROM materia");

        while (resultado.next()) {
                System.out.println(resultado.getLong("id")+ " "
                        +resultado.getString("nombre")+ " "
                        +resultado.getString("cursoDivision") +" "
                        +resultado.getString("turno")+ " "
                        +resultado.getString("especialidad") + " "
                        +resultado.getString("situacionRevista")); 
            }
        }catch(Exception e){
            System.out.println("Error al intentar listar db" + e.getMessage());
        }
     }

    private Connection conectar_db() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}
