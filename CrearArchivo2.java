import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class CrearArchivo2 {

    public static ArrayList<String> citas = new ArrayList<String>();

    // Metodo main
    public static void main(String[] args) {

        
        leer("Citas.txt");

        menu();

        System.out.println("<<<<<<<<<<<<<>>>>>>>>>>>>>>");
        System.out.println("Fin del main");

        

    }

    // aldo.burgos@uned.cr
    // 526371175@U

    // Menu principal
    public static void menu() {

        // Variables
        Scanner scanner = new Scanner(System.in);
        int opc = 0;

        do {
            System.out.println("<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");
            System.out.println("0. Salir");
            System.out.println("1. Crear documento");
            System.out.println("2. Agregar cita");
            System.out.println("3. Ver citas");
            System.out.println("4. Editar cita");
            System.out.println("5. Eliminar registro");
            System.out.println("<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");
            System.out.println("");

            System.out.print("Digite la opcion de su preferencia: ");
            opc = scanner.nextInt();

            switch (opc) {

                case 0:
                    System.out.println("Saliendo del programa");
                break;

                case 1:
                    crear();
                    break;

                case 2:
                    agregar();
                    break;

                case 3:
                    verCitas();
                    break;

                case 4:
                    editar();
                break;

            

                default:
                    System.out.println("Opcion no valida");
            }
        } while (opc != 0);
    }

    // Metodo para crear un archivo
    public static void crear() {
        try {
            // Primer paso
            File file = new File("Citas.txt");

            // Si existe
            if (file.exists()) {
                System.out.println("El archivo " + file.getName() + " ya existe!!");
            } else {
                file.createNewFile();
                System.out.println("El archivo " + file.getName() + " creado exitosamente!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Agregar cita
    public static void agregar() {

        // Variables a utilizar
        Scanner scanner = new Scanner(System.in);
        String cita, cedula, nombreYapellido, fecha, hora;

        // Solicitando datos al usuario
        System.out.println("Digite la cedula");
        cedula = scanner.nextLine();

        System.out.println("Digite el nombre y apellido");
        nombreYapellido = scanner.nextLine();

        System.out.println("Digite la fecha (ejemplo: 24-8-2020)");
        fecha = scanner.nextLine();

        String _fecha[] = fecha.split("-");
        fecha = _fecha[0] + "," + _fecha[1] + "," + _fecha[2];

        System.out.println("Digite la hora");
        hora = scanner.nextLine();

        String _hora[] = hora.split(":");
        fecha = _hora[0] + "," + _hora[1];

        cita = cedula + "," + nombreYapellido + "," + fecha + "," + hora;

        CrearArchivo2.citas.add(cita);

        escribir("Citas.txt");
    }

    // Metodo para ver citas
    public static void verCitas() {
        int n = CrearArchivo2.citas.size();

        for (int i = 0; i < n; i++) {
            System.out.println(CrearArchivo2.citas.get(i));
        }
    }

    // Metodo para escribir
    private static void escribir(String fileName) {

        int n = CrearArchivo2.citas.size();

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (int i = 0; i < n; i++) {
                printWriter.println(CrearArchivo2.citas.get(i));
            }

            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo para leer el archivo
    public static void leer(String filename) {

        // Variable
        String row;

        try {
            File file = new File(filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            if (!file.exists()) {
                System.out.println("El archivo no existe (163)");
            } else {
                while ((row = bufferedReader.readLine()) != null) {
                    CrearArchivo2.citas.add(row);
                }
                System.out.println("Recuperando registros desde " + file.getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo para editar archivos
    public static void editar() {

        // Variables
        Scanner scanner = new Scanner(System.in);
        int n = CrearArchivo2.citas.size();
        String cedula, nombreYapellido, fecha, hora, cita;

        System.out.println("Digite el numero de cedula de la cita que desea editar");
        cedula = scanner.next();

        for (int i = 0; i < n; i++) {


            if (CrearArchivo2.citas.get(i).contains(cedula)) {

                System.out.println("Digite la cedula");
                cedula = scanner.nextLine();
                cedula = scanner.nextLine();

                System.out.println("Digite el nombre y apellido");
                nombreYapellido = scanner.nextLine();

                System.out.println("Digite la fecha (ejemplo: 24-8-2020)");
                fecha = scanner.nextLine();

                String _fecha[] = fecha.split("-");
                fecha = _fecha[0] + "," + _fecha[1] + "," + _fecha[2];

                System.out.println("Digite la hora");
                hora = scanner.nextLine();

                String _hora[] = hora.split(":");
                fecha = _hora[0] + "," + _hora[1];

                cita = cedula + "," + nombreYapellido + "," + fecha + "," + hora;

                CrearArchivo2.citas.set(i, cita);

                escribir("Citas.txt");

                System.out.println("El archivo ha sido editado!!");
            }
        }
    }
}