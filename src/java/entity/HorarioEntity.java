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
import escuela.Horario;

/**
 *
 * @author Paula
 */
public class HorarioEntity {
        //METODOS DE HORARIO
    private Conectar conexion = new Conectar();
    
     public void listarHorario() throws SQLException{
         
         try{
             
         Connection listar = conexion.conectar_db();
         
         //creamos un objeto statement para consultar
         Statement consulta= listar.createStatement();
         
         /*creamos un objeto result set que es como una tabla virtual en memoria
         con el resultado de la consulta*/
         
         ResultSet resultado = consulta.executeQuery("SELECT * FROM horario");

        while (resultado.next()) {
                System.out.println(resultado.getLong("id")+ " "
                        +resultado.getString("dia")+ " "
                        +resultado.getString("horaInicio") +" "
                        +resultado.getString("horaFinal")); 
            }
        }catch(SQLException e){
            System.out.println("Error al intentar listar db" + e.getMessage());
        }
         
     }
     
     public void insertarHorario(Horario horario){

            String sql=  "INSERT INTO horario(dia,horaInicio,horaFinal)"
                    + "VALUES(?,?,?)";
          try{
             
         Connection insertar = conexion.conectar_db();
         
            PreparedStatement statement = insertar.prepareStatement(sql);
            statement.setString(1, horario.getDia());
            statement.setString(2, horario.getHoraInicio());
            statement.setString(3, horario.getHoraFinal());
            statement.executeUpdate();
         //creamos un objeto statement para consultar
         
         /*creamos un objeto result set que es como una tabla virtual en memoria
         con el resultado de la consulta*/
         
         ResultSet resultado = statement.executeQuery("SELECT * FROM horario");

        while (resultado.next()) {
                System.out.println(resultado.getLong("id")+ " "
                        +resultado.getString("dia")+ " "
                        +resultado.getString("horaInicio") +" "
                        +resultado.getString("horaFinal"));
            }
        }catch(Exception e){
            System.out.println("Error al intentar insertar db" + e.getMessage());
        }
     }
     
     public void actualizarHorario(){
         
         String sql=  "UPDATE horario SET horaInicio='14:30' WHERE id=2";

          try{
             
         Connection actualizar = conexion.conectar_db();
         
         //creamos un objeto statement para consultar
         Statement consulta= actualizar.createStatement();
         
         /*creamos un objeto result set que es como una tabla virtual en memoria
         con el resultado de la consulta*/
         
         consulta.executeUpdate(sql);
         
         ResultSet resultado = consulta.executeQuery("SELECT * FROM horario");

        while (resultado.next()) {
                System.out.println(resultado.getLong("id")+ " "
                        +resultado.getString("dia")+ " "
                        +resultado.getString("horaInicio") +" "
                        +resultado.getString("horaFinal"));
            }
        }catch(Exception e){
            System.out.println("Error al intentar actualizar db" + e.getMessage());
        }
     }
     
     public void borrarHorario(){
         
         String sql=  "DELETE FROM horario WHERE id=1";

          try{
             
         Connection borrar = conexion.conectar_db();
         
         //creamos un objeto statement para consultar
         Statement consulta= borrar.createStatement();
         
         /*creamos un objeto result set que es como una tabla virtual en memoria
         con el resultado de la consulta*/
         
         consulta.executeUpdate(sql);
         
         ResultSet resultado = consulta.executeQuery("SELECT * FROM horario");

        while (resultado.next()) {
                System.out.println(resultado.getLong("id")+ " "
                        +resultado.getString("dia")+ " "
                        +resultado.getString("horaInicio") +" "
                        +resultado.getString("horaFinal"));
            }
        }catch(Exception e){
            System.out.println("Error al intentar borrar db" + e.getMessage());
        }
     }  
    
}
