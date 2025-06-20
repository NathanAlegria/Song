/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package song;

import javax.swing.ImageIcon;


public class PlayList {
    
    private Song[] canciones;
    
    /**
     * Constructor que inicializa el arreglo con un tamaño definido por parámetro
     * @param tamaño Tamaño del arreglo de canciones
     */
    public PlayList(int tamaño) {
        this.canciones = new Song[tamaño];
    }
    
    /**
     * Método para agregar una canción al catálogo
     * Valida que el código sea único y que haya espacio libre en el arreglo
     * @param codigo Código único de la canción
     * @param nombre Nombre de la canción
     * @param precio Precio de la canción
     * @param imagenDisco Imagen del disco (puede ser null)
     * @return true si se agrega correctamente, false en caso contrario
     */
    public boolean addSong(int codigo, String nombre, double precio, ImageIcon imagenDisco) {
        // Validar que el código sea único
        for (Song cancion : canciones) {
            if (cancion != null && cancion.getCodigo() == codigo) {
                return false; // Código ya existe
            }
        }
        
        // Buscar espacio libre (null) en el arreglo
        for (int i = 0; i < canciones.length; i++) {
            if (canciones[i] == null) {
                canciones[i] = new Song(codigo, nombre, precio, imagenDisco);
                return true; // Canción agregada exitosamente
            }
        }
        
        return false; // No hay espacio disponible
    }
    
    /**
     * Busca una canción por su código
     * @param codigo Código de la canción a buscar
     * @return Objeto Song si existe, null si no se encuentra
     */
    public Song searchSong(int codigo) {
        for (Song cancion : canciones) {
            if (cancion != null && cancion.getCodigo() == codigo) {
                return cancion;
            }
        }
        return null; // No se encontró la canción
    }
    
    /**
     * Califica una canción añadiendo estrellas
     * Busca la canción y, si existe, añade estrellas mediante addStars
     * @param codigo Código de la canción a calificar
     * @param stars Número de estrellas (0-5)
     */
    public void rateSong(int codigo, int stars) {
        Song cancion = searchSong(codigo);
        if (cancion != null) {
            cancion.addStars(stars);
        }
    }
    
    /**
     * Agrega un comentario con rating a una canción
     * @param codigo Código de la canción
     * @param comentario Texto del comentario
     * @param rating Rating de 1 a 5 estrellas
     * @return true si se agregó correctamente, false si no se encontró la canción
     */
    public boolean addComentario(int codigo, String comentario, int rating) {
        Song cancion = searchSong(codigo);
        if (cancion != null) {
            cancion.addComentario(comentario, rating);
            return true;
        }
        return false;
    }
    
    /**
     * Obtiene todas las canciones existentes en el catálogo
     * @return Array con todas las canciones existentes (no nulas)
     */
    public Song[] getAllSongs() {
        // Primero contar cuántas canciones hay
        int count = getTotalSongs();
        
        // Crear array del tamaño exacto
        Song[] cancionesExistentes = new Song[count];
        int index = 0;
        
        // Llenar el array con las canciones no nulas
        for (Song cancion : canciones) {
            if (cancion != null) {
                cancionesExistentes[index] = cancion;
                index++;
            }
        }
        return cancionesExistentes;
    }
    
    /**
     * Obtiene el número total de canciones almacenadas
     * @return Número de canciones no nulas
     */
    public int getTotalSongs() {
        int count = 0;
        for (Song cancion : canciones) {
            if (cancion != null) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Obtiene la capacidad máxima del catálogo
     * @return Tamaño total del arreglo
     */
    public int getCapacity() {
        return canciones.length;
    }
}
