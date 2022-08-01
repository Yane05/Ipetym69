package entity;

import baseDeDatos.Conectar;
import escuela.Docente;
import escuela.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginEntity {

    private Conectar conectar = new Conectar();

    public Usuario login(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE nombre = " + usuario.getNombre()
                + " AND contrasenia = " + usuario.getContrasenia();

        Usuario respuestaUsuario = new Usuario();
        try {
            Connection buscar = conectar.conectar_db();
            Statement consulta = buscar.createStatement();
            ResultSet resultado = consulta.executeQuery(sql);

            //while (resultado.next()) {
                respuestaUsuario = new Usuario(resultado.getString("nombre"),
                        resultado.getString("contrasenia"));
           // }
        } catch (SQLException e) {
            System.out.println("Error al intentar la conexión" + e.getMessage());
        }
        return respuestaUsuario;
    }
}
