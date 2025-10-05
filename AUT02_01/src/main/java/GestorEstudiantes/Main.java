package GestorEstudiantes;

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
                sc.nextLine();

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
                        System.out.println("Opción no válida, inténtelo de nuevo.");
                }
            } while (opcion != 6);
        }

        //Añadir Alumno

        private static void añadirEstudiante(Scanner sc) {
            System.out.print("Introduce nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Introduce edad: ");
            int edad = sc.nextInt();

            System.out.print("Introduce nota media: ");
            double notaMedia = sc.nextDouble();

            System.out.print("¿Está matriculado? (true/false): ");
            boolean matriculado = sc.nextBoolean();

            sc.nextLine();

            Alumnos nuevo = new Alumnos(nombre, edad, notaMedia, matriculado);
            listaEstudiantes.add(nuevo);
            System.out.println("Estudiante añadido correctamente. ");
        }

        //Listar Alumnado

        private static void listarEstudiantes(){
            if (listaEstudiantes.isEmpty()){
                System.out.println("No hay estudiantes registrados.");
            } else{
                System.out.println("Lista de estudiantes: ");
                for (Alumnos alumno : listaEstudiantes){
                    System.out.print(alumno);
                }
            }
        }

        //Buscar por nombre de alumnado

        private static void buscarPorNombre(Scanner sc) {
        System.out.print("Introduce el nombre del alumnado que estas buscando: ");
        String nombreBuscado = sc.nextLine();

        boolean encontrado = false;
        for (Alumnos alumno : listaEstudiantes) {
            if (alumno.getNombre().equalsIgnoreCase(nombreBuscado)){
                System.out.println("Estudiante encontrado: " + alumno);
                encontrado = true;
                break;
            }
        }
        //if por fuera y no else porque si no cada vez que no encuentre imprimiria el error por cada alumno que recorra 10 alumnos = 10 no se encontro
            if (!encontrado) {
                System.out.println("No se encontró ningun alumno con el nombre de: " + nombreBuscado);
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

            double media = suma / listaEstudiantes.size(); //Como es nota media tenemos que hacer el calculo dividiendo entre la cantidad de alumnos por eso el uso del .size
            System.out.printf("La nota media general de todos los estudiantes es : %.2f%n", media); //% indica valor .2 limite de decimales a 2 y f numero con decimales.
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