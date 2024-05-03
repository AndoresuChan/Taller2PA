package org.example;

import java.util.Scanner;

public class MenuAdministrador {
    private Biblioteca biblioteca;
    private Administrador administrador;
    private Scanner scanner;

    public MenuAdministrador(Biblioteca biblioteca, Administrador administrador) {
        this.biblioteca = biblioteca;
        this.administrador = administrador;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menu Administrador ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Modificar libro");
            System.out.println("3. Eliminar libro");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    modificarLibro();
                    break;
                case 3:
                    eliminarLibro();
                    break;
                case 4:
                    eliminarUsuario();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }

        } while (opcion != 5);
    }

    private void agregarLibro() {
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el titulo del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese la categoria del libro: ");
        String categoria = scanner.nextLine();
        System.out.print("Ingrese la cantidad de ejemplares del libro: ");
        int ejemplaresDisponibles = scanner.nextInt();

        administrador.agregarLibro(titulo, autor, categoria, ejemplaresDisponibles);
    }

    private void modificarLibro() {
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el titulo que desea modificar: ");
        String titulo = scanner.nextLine();
        Libro libro = buscarLibroPorTitulo(titulo);
        if (libro != null) {
            System.out.println("¿Qué desea modificar?");
            System.out.println("1. Titulo");
            System.out.println("2. Autor");
            System.out.println("3. Categoria");
            System.out.println("4. Ejemplares disponibles");
            System.out.print("Selecciona una opcion: ");
            int opcionModificacion = scanner.nextInt();
            scanner.nextLine();
            switch (opcionModificacion) {

                case 1:
                    System.out.print("Nuevo titulo: ");
                    String nuevoTitulo = scanner.nextLine();
                    libro.setTitulo(nuevoTitulo);
                    break;

                case 2:
                    System.out.print("Nuevo autor: ");
                    String nuevoAutor = scanner.nextLine();
                    libro.setAutor(nuevoAutor);
                    break;

                case 3:
                    System.out.print("Nueva categoria: ");
                    String nuevaCategoria = scanner.nextLine();
                    libro.setCategoria(nuevaCategoria);
                    break;

                case 4:
                    System.out.print("Nuevo número de ejemplares disponibles: ");
                    int nuevosEjemplares = scanner.nextInt();
                    libro.setEjemplaresDisponibles(nuevosEjemplares);
                    break;

                default:
                    System.out.println("Opción invalida");
                    break;
            }
        } else {
            System.out.println("El libro no existe");
        }
    }

    private void eliminarLibro() {
        scanner.nextLine();
        System.out.print("Ingrese el titulo del libro que desea eliminar: ");
        String titulo = scanner.nextLine();
        Libro libro = buscarLibroPorTitulo(titulo);
        if (libro != null) {
            biblioteca.eliminarLibro(libro);
            System.out.println("Libro eliminado exitosamente");
        } else {
            System.out.println("El libro no existe");
        }
    }

    private void eliminarUsuario() {
        scanner.nextLine();
        System.out.print("Ingrese el nombre del usuario que desea eliminar: ");
        String nombreUsuario = scanner.nextLine();
        Usuario usuario = biblioteca.getUsuarioPorNombre(nombreUsuario);
        if (usuario != null) {
            biblioteca.eliminarUsuario(usuario);
            System.out.println("Usuario eliminado exitosamente");
        } else {
            System.out.println("El usuario no existe");
        }
    }

    private Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : biblioteca.getInventario()) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }
}
