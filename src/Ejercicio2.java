import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException {
        
        String dir = "directorio2/archivo2.txt";
        String file = "archivo2.txt";

        crearArchivo(dir, file);
        escribirArchivo(dir + "/" + file);
        System.out.println("Ingrese la palabra que desea buscar en el texto: ");
        Scanner sc = new Scanner(System.in);
        String buscar = sc.nextLine();
        buscarTexto(dir + "/" + file, buscar);
    }

    public static void crearArchivo(String nombreDirectorio, String nombreArchivo) throws IOException {
        File directorio = new File(nombreDirectorio);

        if (!directorio.exists()) {
            directorio.mkdirs();
            System.out.println("Directorio creado");
        }else {
            System.out.println("El directorio ya existe");
        }

        File archivo = new File(directorio.getAbsoluteFile() + "/" + nombreArchivo);
    }

    public static void escribirArchivo(String nombreArchivo) {

        File f = new File(nombreArchivo);
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            ArrayList<String> lista = new ArrayList<String>();
            lista.add("Perro");
            lista.add("Gato");
            lista.add("Juan");
            lista.add("Daniel");
            lista.add("Juan");
            lista.add("Gato");
            lista.add("Perro");
            lista.add("Camila");
            lista.add("Daniel");
            lista.add("Camila");

            for (Iterator iterator = lista.iterator(); iterator.hasNext();) {

                String elemento = (String) iterator.next();

                bw.write(elemento + "\n");
            }

            bw.close();

        } catch (IOException e) {
            System.out.println("Error escribiendoArchivo");
            e.printStackTrace();
        }
    }

    public static void buscarTexto(String nombreArchivo, String buscar) {
        File f = new File(nombreArchivo);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);



            String linea;
            ArrayList<String> busqueda = new ArrayList<String>();

            while ((linea = br.readLine()) != null) {

                if (linea.equals(buscar)){
                    busqueda.add(linea);

                }
            }
            System.out.println("Cantidad de repeticiones del texto: " + busqueda.size());

            br.close();

        } catch (IOException e) {
            System.out.println("Error al leer archivo");
            e.printStackTrace();
        }
    }

}