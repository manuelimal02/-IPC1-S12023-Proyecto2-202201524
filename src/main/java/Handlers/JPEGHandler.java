package Handlers;
/**
 *
 * @author manuel
 */
public class JPEGHandler {
    public static void runHandler(ImageHandler imgh) throws Exception {
    System.out.println("--------------------------------------");
    System.out.println(imgh.getClass().getTypeName().toUpperCase() + ": ");
    System.out.println("\nLeyendo Imagen: " + imgh.getFileName());
    imgh.readFile();
    System.out.println("Proceso de lectura de imagen terminado.");
    System.out.println("\nGenerando Imagenes: ");
    imgh.generateFiles();
    System.out.println("Proceso de generacion de archivos terminado.");
    System.out.println("\n--------------------------------------");
    }
}
