package controlador;

import java.util.Scanner;

public class Menu {
    Agenda agenda = new Agenda();
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Mostrar contactos");
            System.out.println("5. modificar contacto");
            System.out.println("6. Salir");
            System.out.println("Ingrese una opcion");
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Agregar contacto");
                    String[] partes = pedirDatos().split(",");
                    agenda.agregarContacto(partes[0], partes[1], partes[2]);
                    break;
                case 2:
                    System.out.println("Buscar contacto");
                    agenda.buscarContacto(pedirDatos());
                    break;
                case 3:
                    System.out.println("Eliminar contacto");

                    agenda.eliminarContacto(pedirDatos());
                    break;
                case 4:
                    System.out.println("Mostrar contactos");
                    agenda.mostrarContactos();
                    break;
                case 5:
                    System.out.println("Modificar contacto");
                    System.out.println("Ingrese el nombre del contacto a modificar y el nuevo telefono");
                    String nombre = pedirDatos();
                    String telefono = pedirDatos();
                    agenda.modificarContacto(nombre, telefono);
                    break;
                case 6:
                    System.out.println("Salir");
                    agenda.guardarContactos();
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(opcion != 6);
    }
    public String pedirDatos() {
        Scanner sc = new Scanner(System.in);
        String datos = sc.nextLine();
        return datos;
    }

}
