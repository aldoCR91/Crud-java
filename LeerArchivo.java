import java.io.File;  // Importamos la clase file
import java.io.FileNotFoundException; 
import java.util.Scanner; 

public class LeerArchivo {
  public static void main(String[] args) {
    try {
        // Creamos un objeto de tipo file y le indicamos el nombre del archivo que queremos leer
      File archivo = new File("prueba.txt");

      // La clase Scanner la vamos a usar para leer el archivo
      // Le pasamos por parametros el archivo que acabamos de crear
      Scanner scanner = new Scanner(archivo);

      // El metodo hasNextLine() va a leer una a una las lineas del archivo
      // hasta que el archivo no tenga mas lineas
      while (scanner.hasNextLine()) {
        String info = scanner.nextLine();
        System.out.println(info);
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Ha ocurrido un error");
      e.printStackTrace();
    }
  }
}
