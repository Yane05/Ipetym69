
package escuela;

public class Usuario {
    private Long id;
    private String nombre;
    private String contrasenia;

    public Usuario() {
    }

    public Usuario(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasenia = contrasena;
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasena(String contrasena) {
        this.contrasenia = contrasena;
    }

}
