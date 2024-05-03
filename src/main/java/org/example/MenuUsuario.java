package org.example;

import java.util.Scanner;

public class MenuUsuario {
    private Biblioteca biblioteca;
    private Usuario usuario;
    private Scanner scanner;

    public MenuUsuario(Biblioteca biblioteca, Usuario usuario) {
        this.biblioteca = biblioteca;
        this.usuario = usuario;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menu Usuario ---");
            System.out.println("1. Mostrar libros disponibles");
            System.out.println("2. Prestar un libro");
            System.out.println("3. Devolver un libro");
            System.out.println("4. Realizar reserva");
            System.out.println("5. Mostrar historial de prestamos");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 2:
                    prestarLibro();
                    break;
                case 3:
                    devolverLibro();
                    break;
                case 4:
                    realizarReserva();
                    break;
                case 5:
                    usuario.mostrarHistorialPrestamos();
                    break;
                case 6:
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("Opcion inválida");
                    break;
            }

        } while (opcion != 6);
    }

    private void prestarLibro() {
        System.out.println("\nLibros disponibles:");
        biblioteca.mostrarLibrosDisponibles();
        System.out.print("Selecciona el indice del libro que quieres pedir prestado: ");
        int indicePrestamo = scanner.nextInt();
        if (indicePrestamo >= 0 && indicePrestamo < biblioteca.getNumeroLibros()) {
            biblioteca.prestarLibro(biblioteca.getLibroPorIndice(indicePrestamo), usuario);
        } else {
            System.out.println("Indice invalido");
        }
    }

    private void devolverLibro() {
        System.out.println("\nLibros prestados a " + usuario.getNombre() + ":");
        usuario.mostrarHistorialPrestamos();
        System.out.print("Selecciona el indice del libro que quieres devolver: ");
        int indiceDevolucion = scanner.nextInt();
        if (indiceDevolucion >= 0 && indiceDevolucion < usuario.getNumeroPrestamos()) {
            biblioteca.devolverLibro(usuario.getLibroPrestadoPorIndice(indiceDevolucion), usuario);
        } else {
            System.out.println("Índice invalido");
        }
    }

    private void realizarReserva() {
        System.out.println("\nLibros disponibles:");
        biblioteca.mostrarLibrosDisponibles();
        System.out.print("Selecciona el indice del libro que quieres reservar: ");
        int indiceReserva = scanner.nextInt();
        if (indiceReserva >= 0 && indiceReserva < biblioteca.getNumeroLibros()) {
            usuario.realizarReserva(biblioteca.getLibroPorIndice(indiceReserva), biblioteca);
        } else {
            System.out.println("Índice invalido");
        }
    }
}
