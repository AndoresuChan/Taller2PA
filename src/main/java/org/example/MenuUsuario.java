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
            System.out.println("6. Agregar comentario a un libro");
            System.out.println("7. Agregar calificación a un libro");
            System.out.println("8. Ver comentarios de un libro");
            System.out.println("9. Ver calificaciones de un libro");
            System.out.println("10. Salir");
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
                    agregarComentario();
                    break;
                case 7:
                    agregarCalificacion();
                    break;
                case 8:
                    verComentarios();
                    break;
                case 9:
                    verCalificaciones();
                    break;
                case 10:
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("Opcion inválida");
                    break;
            }

        } while (opcion != 10);
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
    private void agregarComentario() {
        System.out.println("\nLibros disponibles:");
        biblioteca.mostrarLibrosDisponibles();
        System.out.print("Selecciona el índice del libro al que quieres agregar un comentario: ");
        int indiceLibro = scanner.nextInt();
        if (indiceLibro >= 0 && indiceLibro < biblioteca.getNumeroLibros()) {
            Libro libro = biblioteca.getLibroPorIndice(indiceLibro);
            scanner.nextLine(); // Limpiar el buffer
            System.out.print("Ingrese el comentario: ");
            String comentario = scanner.nextLine();
            libro.agregarComentario(comentario);
            System.out.println("Comentario agregado con éxito al libro " + libro.getTitulo());
        } else {
            System.out.println("Índice inválido");
        }
    }

    private void agregarCalificacion() {
        System.out.println("\nLibros disponibles:");
        biblioteca.mostrarLibrosDisponibles();
        System.out.print("Selecciona el indice del libro al que quieres agregar una calificacion: ");
        int indiceLibro = scanner.nextInt();
        if (indiceLibro >= 0 && indiceLibro < biblioteca.getNumeroLibros()) {
            Libro libro = biblioteca.getLibroPorIndice(indiceLibro);
            System.out.print("Ingrese la calificacion (de 1 a 5): ");
            int calificacion = scanner.nextInt();
            if (calificacion >= 1 && calificacion <= 5) {
                libro.agregarCalificacion(calificacion);
                System.out.println("Calificación " + calificacion + " agregada con éxito al libro " + libro.getTitulo());
            } else {
                System.out.println("La calificación debe ser un valor entre 1 y 5");
            }
        } else {
            System.out.println("Índice inválido");
        }
    }
    private void verCalificaciones() {
        System.out.println("\nLibros disponibles:");
        biblioteca.mostrarLibrosDisponibles();
        System.out.print("Selecciona el índice del libro del que quieres ver las calificaciones: ");
        int indiceLibro = scanner.nextInt();
        if (indiceLibro >= 0 && indiceLibro < biblioteca.getNumeroLibros()) {
            Libro libro = biblioteca.getLibroPorIndice(indiceLibro);
            System.out.println("Calificaciones del libro \"" + libro.getTitulo() + "\":");
            for (int calificacion : libro.getCalificaciones()) {
                System.out.println("- " + calificacion);
            }
        } else {
            System.out.println("Índice inválido");
        }
    }

    private void verComentarios() {
        System.out.println("\nLibros disponibles:");
        biblioteca.mostrarLibrosDisponibles();
        System.out.print("Selecciona el indice del libro del que quieres ver los comentarios: ");
        int indiceLibro = scanner.nextInt();
        if (indiceLibro >= 0 && indiceLibro < biblioteca.getNumeroLibros()) {
            Libro libro = biblioteca.getLibroPorIndice(indiceLibro);
            System.out.println("Comentarios del libro \"" + libro.getTitulo() + "\":");
            for (String comentario : libro.getComentarios()) {
                System.out.println("- " + comentario);
            }
        } else {
            System.out.println("(Indice invalido");
        }
    }
}
