/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import baseDeDatos.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import baseDeDatos.Conectar;
import escuela.Docente;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Paula
 */
public class DocenteEntity {

    private Conectar conectar = new Conectar();

    public ArrayList<Docente> listarDocente() throws SQLException {
        ArrayList<Docente> docentes = new ArrayList<Docente>();
        
        try {
            Connection listar = conectar.conectar_db();
            //creamos un objeto statement para consultar
            Statement consulta = listar.createStatement();

            /*creamos un objeto result set que es como una tabla virtual en memoria
         con el resultado de la consulta*/
            ResultSet resultado = consulta.executeQuery("SELECT * FROM docente");

            while (resultado.next()) {
                Docente docente = new Docente(resultado.getString("nombre"),
                        resultado.getString("apellido"),
                        resultado.getInt("dni"),
                        resultado.getInt("telefono"),
                        resultado.getString("email"),
                        resultado.getString("legajo"));
                docentes.add(docente);
            }
        } catch (SQLException e) {
            System.out.println("Error al intentar listar db" + e.getMessage());
        }
        return docentes;
    }

    public void insertarDocente(Docente docente) {

        String sql = "INSERT INTO docente(nombre,apellido,"
                + "dni,telefono,email,legajo)VALUES(?,?,?,?,?,?)";

        try {

            Connection insertar = conectar.conectar_db();

            //creamos un objeto statement para consultar
            PreparedStatement statement = insertar.prepareStatement(sql);
            statement.setString(1, docente.getNombre());
            statement.setString(2, docente.getApellido());
            statement.setInt(3, docente.getDni());
            statement.setInt(4, docente.getTelefono());
            statement.setString(5, docente.getEmail());
            statement.setString(6, docente.getLegajo());

            statement.executeUpdate();

            /*creamos un objeto result set que es como una tabla virtual en memoria
         con el resultado de la consulta*/
            ResultSet resultado = statement.executeQuery("SELECT * FROM docente");

            while (resultado.next()) {
                System.out.println(resultado.getLong("id") + " "
                        + resultado.getString("nombre") + " "
                        + resultado.getString("apellido") + " "
                        + resultado.getInt("dni") + " "
                        + resultado.getInt("telefono") + " "
                        + resultado.getString("email") + " "
                        + resultado.getString("legajo"));
            }
        } catch (Exception e) {
            System.out.println("Error al intentar insertar db" + e.getMessage());
        }
    }

    public void actualizarDocente() {

        String sql = "UPDATE docente SET nombre ='Pepe' WHERE id=1";

        try {

            Connection actualizar = conectar.conectar_db();

            //creamos un objeto statement para consultar
            Statement consulta = actualizar.createStatement();

            /*creamos un objeto result set que es como una tabla virtual en memoria
         con el resultado de la consulta*/
            //consulta.executeUpdate(sql);
            ResultSet resultado = consulta.executeQuery("SELECT * FROM docente");

            while (resultado.next()) {
                System.out.println(resultado.getLong("id") + " "
                        + resultado.getString("nombre") + " "
                        + resultado.getString("apellido") + " "
                        + resultado.getInt("dni") + " "
                        + resultado.getInt("telefono") + " "
                        + resultado.getString("email") + " "
                        + resultado.getString("legajo"));
            }
        } catch (Exception e) {
            System.out.println("Error al intentar listar db" + e.getMessage());
        }
    }

    public void borrarDocente() {

        String sql = "DELETE FROM docente WHERE id=1";

        try {

            Connection borrar = conectar.conectar_db();

            //creamos un objeto statement para consultar
            Statement consulta = borrar.createStatement();

            /*creamos un objeto result set que es como una tabla virtual en memoria
         con el resultado de la consulta*/
            consulta.executeUpdate(sql);

            ResultSet resultado = consulta.executeQuery("SELECT * FROM docente");

            while (resultado.next()) {
                System.out.println(resultado.getLong("id") + " "
                        + resultado.getString("nombre") + " "
                        + resultado.getString("apellido") + " "
                        + resultado.getInt("dni") + " "
                        + resultado.getInt("telefono") + " "
                        + resultado.getString("email") + " "
                        + resultado.getString("legajo"));
            }
        } catch (Exception e) {
            System.out.println("Error al intentar listar db" + e.getMessage());
        }
    }

}
