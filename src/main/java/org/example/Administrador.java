package org.example;

public class Administrador {
    private Biblioteca biblioteca;

    public Administrador(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void agregarLibro(String titulo, String autor, String categoria, int ejemplaresDisponibles) {
        Libro nuevoLibro = new Libro(titulo, autor, categoria, ejemplaresDisponibles);
        biblioteca.agregarLibro(nuevoLibro);
        System.out.println("Libro agregado correctamente: " + nuevoLibro.getTitulo());
    }
}
