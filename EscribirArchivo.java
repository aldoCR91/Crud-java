import java.io.FileWriter;   // Importamos la clase que nos permite escribir
import java.io.IOException;  // Importamos la clase que maneja errores

public class EscribirArchivo {
  public static void main(String[] args) {
    try {
        // Creamos un objeto de la clase que nos permite escribir
      FileWriter escritor = new FileWriter("prueba.txt");

      // Con el metodo write escribimos en el archivo
      escritor.write("TI-121 - Programación I - Grupo 01-03");

      // Es importante cerrar el escritor
      escritor.close();

      System.out.println("El archivo ha sido editado");
    } catch (IOException e) {
      System.out.println("Ha ocurrido un error");
      e.printStackTrace();
    }
  }
}
