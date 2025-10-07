package GestorEstudiantes;

import java.util.InputMismatchException;
import java.util.Scanner;
import models.Alumnos;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Alumnos> listaEstudiantes = new ArrayList<>();  //Array para guardar alumnos

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printMainMenu(sc);
    }

    private static void printMainMenu(Scanner sc) {
        int opcion;
        do {
            System.out.println("=== Gestor de Estudiantes ===");
            System.out.println("1. Añadir estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Buscar por nombre");
            System.out.println("4. Calcular nota media general");
            System.out.println("5. Mostrar mejor estudiante");
            System.out.println("6. Salir");
            System.out.print("Seleccione opción: ");

                opcion = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1:
                        añadirEstudiante(sc);  // Añadir estudiante
                        break;
                    case 2:
                        listarEstudiantes(); // Listar estudiantes
                        break;
                    case 3:
                        buscarPorNombre(sc); // Buscar por nombre
                        break;
                    case 4:
                        calcularMediaGeneral(); // Calcular media
                        break;
                    case 5:
                        mostrarMejorEstudiante(); // Mejor estudiante
                        break;
                    case 6:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida, inténtelo de nuevo. (Debe ser 1-6)");
                }
        } while (opcion != 6);
    }

    //Añadir Alumno
    private static void añadirEstudiante(Scanner sc) {
        try {
            System.out.print("Introduce el nombre del alumno: ");
            String nombre = sc.nextLine();


            if (nombre.equals("") || nombre.replace(" ", "").equals("")) {
                System.out.println("El nombre no puede estar vacío.");
                return;
            }

            if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                System.out.println("El nombre solo puede contener letras y espacios (sin números ni símbolos).");
                return;
            }

            for (Alumnos alumno : listaEstudiantes) {
                if (alumno.getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println("Ya existe un estudiante con ese nombre.");
                    return;
                }
            }

            System.out.print("Introduce edad: ");
            int edad = sc.nextInt();

            // 3) Edad negativa
            if (edad < 0) {
                System.out.println("La edad no puede ser negativa.");
                sc.nextLine();
                return;
            }

            System.out.print("Introduce nota media: ");
            double notaMedia = sc.nextDouble();

            if (notaMedia < 0) {
                System.out.println("La nota no puede ser negativa.");
                sc.nextLine();
                return;
            }

            sc.nextLine();


            System.out.print("¿Está matriculado? (true/false): ");
            String matriculadoStr = sc.nextLine();
            boolean matriculado;
            if (matriculadoStr.equalsIgnoreCase("true")) {
                matriculado = true;
            } else if (matriculadoStr.equalsIgnoreCase("false")) {
                matriculado = false;
            } else {
                System.out.println("Debe escribir 'true' o 'false' solamente.");
                return;
            }

            // crear y añadir
            Alumnos nuevo = new Alumnos(nombre, edad, notaMedia, matriculado);
            listaEstudiantes.add(nuevo);
            System.out.println("Estudiante añadido correctamente. ");

        } catch (InputMismatchException e) {
            // Cuando el usuario mete texto donde se espera numero
            System.out.println("Asegúrate de introducir números para edad/nota.");
            sc.nextLine();
        }
    }

    //Listar Alumnado
    private static void listarEstudiantes(){
        if (listaEstudiantes.isEmpty()){
            System.out.println("No hay estudiantes registrados.");
        } else{
            System.out.println("Lista de estudiantes: ");
            for (Alumnos alumno : listaEstudiantes){
                System.out.println(alumno);
            }
        }
    }

    //Buscar por nombre de alumnado
    private static void buscarPorNombre(Scanner sc) {
        System.out.print("Introduce el nombre del alumnado que estas buscando: ");
        String nombreBuscado = sc.nextLine();

        if (nombreBuscado.equals("") || nombreBuscado.replace(" ", "").equals("")) {
            System.out.println("El texto de búsqueda no puede estar vacío.");
            return;
        }

        boolean encontrado = false;
        for (Alumnos alumno : listaEstudiantes) {
            if (alumno.getNombre().toLowerCase().contains(nombreBuscado.toLowerCase())) {
                System.out.println("Estudiante encontrado: " + alumno);
                encontrado = true;
                // no hago break para mostrar todas las coincidencias (si quieres que pare en la primera, descomenta el break)
                // break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningun alumno con el nombre: " + nombreBuscado);
        }
    }

    //Calculando media
    private static void calcularMediaGeneral() {
        if (listaEstudiantes.isEmpty()) {
            System.out.println("No hay alumnos registrados para calcular la nota media.");
            return;
        }

        double suma = 0;
        for (Alumnos alumno : listaEstudiantes) {
            suma += alumno.getNotaMedia();
        }

        double media = suma / (double)listaEstudiantes.size();
        System.out.println("La nota media general de todos los estudiantes es : " + media);
    }

    //Mejor alumno segun su nota
    private static void mostrarMejorEstudiante() {
        if (listaEstudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados aun para poder comparar sus notas.");
            return;
        }

        Alumnos mejor = listaEstudiantes.get(0); //referencia para empezar desde el primero
        for (Alumnos alumno : listaEstudiantes){
            if (alumno.getNotaMedia() > mejor.getNotaMedia()) {
                mejor = alumno;
            }
        }
        System.out.println("\nEl estudiante con la mejor nota es: ");
        System.out.println(mejor);
    }
}
