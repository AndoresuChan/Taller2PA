package org.example;


public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Usuario usuario = new Usuario("Juan", "Estudiante");

        // Crear algunos libros
        Libro libro1 = new Libro("El nombre del viento", "Patrick Rothfuss", "Fantasía", 5);
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Realismo mágico", 3);

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        Menu menu = new Menu(biblioteca);
        menu.mostrarMenu();
    }
}
