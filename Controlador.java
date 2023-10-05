package controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Controlador {
    private Map<String, String> contactos;
    Scanner sc;

    public Controlador(Map<String, String> contactos) {
        this.contactos = contactos;
    }

    private Map cargarContactos(String ruta) {
        BufferedReader bf;
        String[] dats;
        String linea = "";
        try {
           do {
                bf = new BufferedReader(new FileReader(ruta));
                linea = bf.readLine();
                dats = linea.split(":");
                contactos.put(dats[0], dats[1]);
            } while (linea != null);

        } catch (FileNotFoundException e) {
            System.out.println("No se ha podido leer el archivo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contactos;
    }

    private boolean addContactos(Map<String, String> contactos) {
        sc = new Scanner(System.in);
        System.out.println("Dame el nombre del Contacto");
        String nombre = sc.nextLine();
        System.out.println("Dame el numero del contacto");
        String num = sc.nextLine();
        if (!contactos.containsKey(nombre)) {
            contactos.put(nombre, num);
        } else
            System.out.println("Ya exite un contacto con este nombre");
        return false;
    }

    private boolean removeContactos(Map<String, String> contactos) {
        sc = new Scanner(System.in);
        System.out.println("Dame el nombre del contacto que quieres borrar");
        String nombre = sc.nextLine();
        if (contactos.containsKey(nombre)) {
            contactos.remove(nombre);
            System.out.println("contacto eliminado" + " " + "(" + nombre + ")");
        } else
            System.out.println("no existe ningun contacto con ese nombre para borrar");
        return false;
    }

    private boolean actualizar(Map<String, String> contactos) {
        sc = new Scanner(System.in);
        System.out.println("Dame el nombre del contacto que quieras actualizar");

        for (Map.Entry<String, String> entry : contactos.entrySet()) {
            System.out.println("Nombre : " + entry.getKey() + " Numero : " + entry.getValue());
            String nombre = sc.nextLine();
            if (nombre.equals(entry.getKey())){
                System.out.println("Que desea modificar?");
                System.out.println("1.Nombre");
                System.out.println("2.Número");
                int numeroSeleccionar = sc.nextInt();
                if(numeroSeleccionar==1){
                    
                } else if (numeroSeleccionar==2) {

                }
            }
        }
        System.out.println("No has seleccionado ninguna de las dos opciones");
        return false;
    }

    public Map<String, String> getContactos() {
        return contactos;
    }
}
