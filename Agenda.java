package controlador;

import java.io.File;
import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contacto> contactos;

    public Agenda() {
        this.contactos = new ArrayList<>();
        cargarContactos();
    }

    public void agregarContacto(String nombre, String apellido, String telefono) {
        if (!contactos.contains(nombre)){
            Contacto contacto = new Contacto(nombre, apellido, telefono);
            contactos.add(contacto);
            System.out.println("Contacto agregado");
        }

    }
    public void eliminarContacto(String nombre) {

                for (Contacto contacto : contactos) {
                    if (contacto.getNombre().equals(nombre) && !contactos.isEmpty()) {
                        contactos.remove(contacto);
                        System.out.println("Contacto eliminado");
                        break;
                    }
                }
            }

    public void mostrarContactos() {
        for (Contacto contacto : contactos) {
            System.out.println(contacto.toString());

        }
    }
    public void buscarContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre)) {
                System.out.println(contacto.toString());
            }
        }
    }
    public void guardarContactos() {
        File archivo = new File("C:\\Users\\Vespertino\\IdeaProjects\\EjerciciosAccDat\\src\\main\\java\\org\\example\\contactos");
        if (archivo.exists()) {
            archivo.delete();
        }
        for (Contacto contacto : contactos) {
            Archivo.escribirArchivo(archivo, contacto.toString());
        }

    }
    public void cargarContactos() {
        File archivo = new File("C:\\Users\\Vespertino\\IdeaProjects\\EjerciciosAccDat\\src\\main\\java\\org\\example\\contactos");
        ArrayList<String> lineas = Archivo.leerArchivo(archivo);
        for (String linea : lineas) {
            String[] partes = linea.split(",");
            String nombre = partes[0];
            String apellido = partes[1];
            String telefono = partes[2];
            Contacto contacto = new Contacto(nombre, apellido, telefono);
            contactos.add(contacto);
        }
    }

    public void modificarContacto(String nombre, String nuevoTelefono) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre)) {
                contacto.setTelefono(nuevoTelefono);
            }
        }
    }

}
