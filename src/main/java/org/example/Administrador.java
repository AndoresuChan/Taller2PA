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

    public void modificarLibro(Libro libro, String nuevoTitulo, String nuevoAutor, String nuevaCategoria, int nuevosEjemplaresDisponibles) {
        libro.setTitulo(nuevoTitulo);
        libro.setAutor(nuevoAutor);
        libro.setCategoria(nuevaCategoria);
        libro.setEjemplaresDisponibles(nuevosEjemplaresDisponibles);
        System.out.println("Libro modificado correctamente: " + libro.getTitulo());
    }

    public void eliminarLibro(Libro libro) {
        biblioteca.eliminarLibro(libro);
        System.out.println("Libro eliminado correctamente: " + libro.getTitulo());
    }

    public void eliminarUsuario(Usuario usuario) {
        biblioteca.eliminarUsuario(usuario);
        System.out.println("Usuario eliminado correctamente: " + usuario.getNombre());
    }
}
