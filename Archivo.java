package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {
    public static ArrayList<String> leerArchivo(File archivo) {
        ArrayList<String> lineas = new ArrayList<>();
        try {
            Scanner sc = new Scanner(archivo);
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                lineas.add(linea);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo leer el archivo");
        }
        return lineas;
    }
    public static void escribirArchivo(File archivo, String linea) {
        try {
            FileWriter escritor = new FileWriter(archivo, true);
            escritor.write(linea + "\n");
            escritor.close();
        } catch (IOException e) {
            System.out.println("No se pudo escribir el archivo");
        }
    }
}
