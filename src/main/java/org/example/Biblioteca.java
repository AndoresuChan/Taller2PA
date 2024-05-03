package org.example;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> inventario;
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.inventario = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    // Métodos para gestionar libros
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
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getEjemplaresDisponibles() > 0) {
                System.out.println(i + ". " + inventario.get(i).getTitulo());
            }
        }
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

    // Métodos para gestionar usuarios
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void eliminarUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public Usuario getUsuarioPorNombre(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    // Métodos para prestar y devolver libros
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
