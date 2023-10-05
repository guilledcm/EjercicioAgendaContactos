package controlador;

public class Contacto {
    private String nombre;
    private String apellido;
    private String telefono;

    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setTelefono(String nuevoTelefono) {
        this.telefono = nuevoTelefono;

    }
    public String toString() {
        return this.nombre + "," + this.apellido + "," + this.telefono;
    }
}
