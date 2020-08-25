import java.io.File;  // Import the File class

public class BorrarArchivo {
  public static void main(String[] args) { 
    File archivo = new File("prueba.txt"); 
    if (archivo.delete()) { 
      System.out.println("El archivo: " + archivo.getName() + " ha sido borrado");
    } else {
      System.out.println("No se ha podido borrar el archivo");
    } 
  } 
}