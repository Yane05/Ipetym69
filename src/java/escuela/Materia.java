
package escuela;

import java.util.List;


public class Materia {
    private Long id;
    private String nombre;
    private String cursoDivision;
    private String turno;
    private String especialidad;
    private String situacionRevista;
    private List <Horario> horarios;

    public Materia(String nombre, String cursoDivision, String turno, String especialidad, String situacionRevista) {
        
        this.nombre = nombre;
        this.cursoDivision = cursoDivision;
        this.turno = turno;
        this.especialidad = especialidad;
        this.situacionRevista = situacionRevista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCursoDivision() {
        return cursoDivision;
    }

    public void setCursoDivision(String cursoDivision) {
        this.cursoDivision = cursoDivision;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getSituacionRevista() {
        return situacionRevista;
    }

    public void setSituacionRevista(String situacionRevista) {
        this.situacionRevista = situacionRevista;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    
   
}


    

