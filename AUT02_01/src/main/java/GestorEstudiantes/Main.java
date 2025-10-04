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
                        // Listar estudiantes
                        break;
                    case 3:
                        // Buscar por nombre
                        break;
                    case 4:
                        // Calcular media
                        break;
                    case 5:
                        // Mejor estudiante
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
            System.out.println("Introduce nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Introduce edad: ");
            int edad = sc.nextInt();

            System.out.print("Introduce nota media: ");
            double notaMedia = sc.nextDouble();

            System.out.print("¿Está matriculado? (true/false): ");
            boolean matriculado = sc.nextBoolean();

            Alumnos nuevo = new Alumnos(nombre, edad, notaMedia, matriculado);
            listaEstudiantes.add(nuevo);
            System.out.println("Estudiante añadido correctamente. ");
        }
    }