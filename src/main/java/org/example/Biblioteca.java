package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Biblioteca {
    private List<Libro> inventario;
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.inventario = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        inventario.add(libro);
    }

    public void eliminarLibro(Libro libro) {
        inventario.remove(libro);
    }

    public List<Libro> getInventario() {
        return inventario;
    }

    public void mostrarLibrosDisponibles() {
        System.out.println("Libros disponibles en la biblioteca:");
        IntStream.range(0, inventario.size())
                .filter(i -> inventario.get(i).getEjemplaresDisponibles() > 0)
                .forEach(i -> System.out.println(i + ". " + inventario.get(i).getTitulo()));
    }

    public int getNumeroLibros() {
        return inventario.size();
    }

    public Libro getLibroPorIndice(int indice) {
        if (indice >= 0 && indice < inventario.size()) {
            return inventario.get(indice);
        } else {
            return null;
        }
    }

    public void prestarLibro(Libro libro, Usuario usuario) {
        if (libro.getEjemplaresDisponibles() > 0) {
            libro.decrementarEjemplaresDisponibles();
            usuario.agregarPrestamo(libro);
            System.out.println("Libro prestado a " + usuario.getNombre() + ": " + libro.getTitulo());
        } else {
            System.out.println("Lo siento, no hay ejemplares disponibles de " + libro.getTitulo());
        }
    }

    public void devolverLibro(Libro libro, Usuario usuario) {
        libro.incrementarEjemplaresDisponibles();
        usuario.removerPrestamo(libro);
        System.out.println("Libro devuelto por " + usuario.getNombre() + ": " + libro.getTitulo());
    }
}
