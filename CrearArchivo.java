import java.io.File;  // Importamos la clase file
import java.io.IOException;  // Importamos la clase para manejar errores

public class CrearArchivo {
  public static void main(String[] args) {
    try {
      File archivo = new File("prueba.txt");
      if (archivo.createNewFile()) {
        System.out.println("Archivo creado: " + archivo.getName());
      } else {
        System.out.println("El archivo ya existe");
      }
    } catch (IOException e) {
      System.out.println("Ha ocurrido un error");
      e.printStackTrace();
    }
  }
}
