/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosNegocio;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Jaime Valdez
 */
public class Post {
    private LocalDateTime fechaHoraCreacion;
    private String titulo;
    private ArrayList<Comentario> contenido;
    private LocalDateTime fechaHoraEdicion;
    private String tipo;

    public Post() {
    }

    public Post(String titulo) {
        this.titulo = titulo;
    }

    public Post(String titulo, ArrayList<Comentario> contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public Post(String titulo, ArrayList<Comentario> contenido, LocalDateTime fechaHoraEdicion) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    public Post(String titulo, ArrayList<Comentario> contenido, LocalDateTime fechaHoraEdicion, String tipo) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHoraEdicion = fechaHoraEdicion;
        this.tipo = tipo;
    }

    public Post(LocalDateTime fechaHoraCreacion, String titulo, ArrayList<Comentario> contenido, LocalDateTime fechaHoraEdicion, String tipo) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHoraEdicion = fechaHoraEdicion;
        this.tipo = tipo;
    }

    

    public LocalDateTime getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(LocalDateTime fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Comentario> getContenido() {
        return contenido;
    }

    public void setContenido(ArrayList<Comentario> contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaHoraEdicion() {
        return fechaHoraEdicion;
    }

    public void setFechaHoraEdicion(LocalDateTime fechaHoraEdicion) {
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Post{" + "fechaHoraCreacion=" + fechaHoraCreacion + ", titulo=" + titulo + ", contenido=" + contenido + ", fechaHoraEdicion=" + fechaHoraEdicion + ", tipo=" + tipo + '}';
    }
    
    
    
    
}
