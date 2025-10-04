package GestorEstudiantes;

import java.util.Scanner;

public class Main {
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
                        // Añadir estudiante
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
    }