/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package song;

import javax.swing.ImageIcon;

/**
 *
 * @author Nathan
 */
public class Song {
    
    // Atributos privados
    private int codigo;
    private String nombre;
    private double precio;
    private int sumaEstrellas;
    private int totalReviews;
    private ImageIcon imagenDisco;
    private Comentario[] comentarios; // Array para comentarios
    private int totalComentarios; // Contador de comentarios
    
    // Constructor
    public Song(int codigo, String nombre, double precio, ImageIcon imagenDisco) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.imagenDisco = imagenDisco;
        this.sumaEstrellas = 0;
        this.totalReviews = 0;
        this.comentarios = new Comentario[50]; // Array fijo de 50 comentarios
        this.totalComentarios = 0;
    }
    
    // Getters
    public int getCodigo() {
        return codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public ImageIcon getImagenDisco() {
        return imagenDisco;
    }
    
    public Comentario[] getComentarios() {
        return comentarios;
    }
    
    public int getTotalComentarios() {
        return totalComentarios;
    }
    
    // Método para agregar estrellas (mantiene compatibilidad)
    public void addStars(int stars) {
        if (stars >= 0 && stars <= 5) {
            sumaEstrellas += stars;
            totalReviews++;
        }
    }
    
    // Método para agregar comentario con rating
    public void addComentario(String texto, int rating) {
        if (rating >= 1 && rating <= 5 && texto != null && !texto.trim().isEmpty() && totalComentarios < comentarios.length) {
            Comentario comentario = new Comentario(texto.trim(), rating);
            comentarios[totalComentarios] = comentario;
            totalComentarios++;
            // También actualizar el sistema de estrellas existente
            sumaEstrellas += rating;
            totalReviews++;
        }
    }
    
    // Método para calcular el rating promedio
    public double songRating() {
        if (totalReviews == 0) {
            return 0.0;
        }
        return (double) sumaEstrellas / totalReviews;
    }
    

    
    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
    
    // Clase interna para representar un comentario
    public static class Comentario {
        private String texto;
        private int rating;
        private String fecha;
        
        public Comentario(String texto, int rating) {
            this.texto = texto;
            this.rating = rating;
            this.fecha = java.time.LocalDateTime.now().format(
                java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        }
        
        public String getTexto() {
            return texto;
        }
        
        public int getRating() {
            return rating;
        }
        
        public String getFecha() {
            return fecha;
        }
        
        @Override
        public String toString() {
            return "[" + fecha + "] " + rating + "⭐ - " + texto;
        }
    }
}
