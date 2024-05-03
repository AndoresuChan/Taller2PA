package org.example;

import java.util.Scanner;

public class Menu {
    private Biblioteca biblioteca;
    private Scanner scanner;

    public Menu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Usuario");
            System.out.println("2. Administrador");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuUsuario();
                    break;
                case 2:
                    menuAdministrador();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }

        } while (opcion != 3);
    }

    private void menuUsuario() {
        // Lógica del menú para usuario
    }

    private void menuAdministrador() {
        Administrador administrador = new Administrador(biblioteca);
        int opcion;
        do {
            System.out.println("\n--- Menú Administrador ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Modificar libro");
            System.out.println("3. Eliminar libro");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Volver al menú principal");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarLibro(administrador);
                    break;
                case 2:
                    // Lógica para modificar libro
                    break;
                case 3:
                    // Lógica para eliminar libro
                    break;
                case 4:
                    // Lógica para eliminar usuario
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }

        } while (opcion != 5);
    }

    private void agregarLibro(Administrador administrador) {
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese la categoría del libro: ");
        String categoria = scanner.nextLine();
        System.out.print("Ingrese la cantidad de ejemplares disponibles del libro: ");
        int ejemplaresDisponibles = scanner.nextInt();

        administrador.agregarLibro(titulo, autor, categoria, ejemplaresDisponibles);
    }
}
