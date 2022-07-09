package principal;


import baseDeDatos.Conectar;
import entity.DocenteEntity;
import entity.HorarioEntity;
import entity.MateriaEntity;
import escuela.Docente;
import escuela.Horario;
import escuela.Materia;
import java.sql.SQLException;

public class Principal {

   public static void main(String[] args) throws SQLException {

       HorarioEntity horario = new HorarioEntity();
       Horario hora = new Horario("Lunes","12:30","18:30"); 
       //horario.insertarHorario(hora);
       //horario.listarHorario();
       
       DocenteEntity conexionDocente = new DocenteEntity();
       //Docente docente = new Docente("Josefina","Perez",2333333,035346666,"josefina_perez56@gmail.com","P-3456");
       //conexionDocente.insertarDocente(docente);
       //conexionDocente.listarDocente();
       
       MateriaEntity conexionMateria = new MateriaEntity();
       Materia materia = new Materia("matematica","3°A","mañana","Ciclo Basico","titular");
       
       conexionMateria.insertarMateria(materia);
   }   
    }
    

