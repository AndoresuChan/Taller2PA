package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        //
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel Márquez", "Realismo magico", 5);
        Libro libro2 = new Libro("El nombre del viento", "Patrick Rothfuss", "Fantasia", 3);
        Libro libro3 = new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", "Fantasia", 7);

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            try{
            System.out.println("--- Biblioteca ---");
            System.out.println("¿Quién eres?");
            System.out.println("1. Usuario");
            System.out.println("2. Administrador");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    scanner.nextLine();
                    System.out.print("Ingrese su nombre: ");
                    String nombreUsuario = scanner.nextLine();
                    Usuario usuario = new Usuario(nombreUsuario, "Estudiante");
                    MenuUsuario menuUsuario = new MenuUsuario(biblioteca, usuario);
                    menuUsuario.mostrarMenu();
                    break;

                case 2:
                    MenuAdministrador menuAdministrador = new MenuAdministrador(biblioteca, new Administrador(biblioteca));
                    menuAdministrador.mostrarMenu();
                    break;

                case 3:
                    System.out.println("Adios!");
                    break;

                default:
                    System.out.println("Opción invalida");
                    break;
            }
            } catch (InputMismatchException e) {
                System.out.println("Ingresa un número valido.");
                scanner.nextLine();
                opcion = 0;
            }
        } while (opcion != 3);
    }
}
