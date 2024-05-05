package org.example;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String tipo;
    private List<Libro> historialPrestamos;
    private List<Libro> librosReservados;
    private List<Integer> calificaciones;

    public Usuario(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.historialPrestamos = new ArrayList<>();
        this.librosReservados = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
    }

    public void agregarPrestamo(Libro libro) {
        historialPrestamos.add(libro);
    }

    public void realizarReserva(Libro libro, Biblioteca biblioteca) {
        if (!historialPrestamos.contains(libro)) {
            librosReservados.add(libro);
            System.out.println("Reserva realizada para " + libro.getTitulo());
        } else {
            System.out.println("El libro ya esta disponible o fue prestado. No se puede reservar.");
        }
    }

    public void removerPrestamo(Libro libro) {
        historialPrestamos.remove(libro);
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarHistorialPrestamos() {
        if (historialPrestamos.isEmpty()) {
            System.out.println("No hay libros prestados.");
        } else {
            for (int i = 0; i < historialPrestamos.size(); i++) {
                System.out.println(i + ". " + historialPrestamos.get(i).getTitulo());
            }
        }
    }

    public int getNumeroPrestamos() {
        return historialPrestamos.size();
    }

    public Libro getLibroPrestadoPorIndice(int indice) {
        if (indice >= 0 && indice < historialPrestamos.size()) {
            return historialPrestamos.get(indice);
        } else {
            return null;
        }
    }
}
