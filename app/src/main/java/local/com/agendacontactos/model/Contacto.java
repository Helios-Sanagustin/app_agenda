package local.com.agendacontactos.model;

/**
 * Created by user on 01/03/2018.
 */
import java.io.Serializable;
public class Contacto implements Serializable{

    String nombre;
    String email;
    int edad;

    public Contacto(String nombre, String email, int edad) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
