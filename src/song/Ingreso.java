/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package song;

import javax.swing.JOptionPane;

/**
 * Clase Ingreso para validar y obtener datos de entrada
 * @author Nathan
 */
public class Ingreso {
    
    /**
     * Valida que un texto no esté vacío
     * @param texto Texto a validar
     * @return true si el texto no está vacío, false si está vacío
     */
    public static boolean validarTextoNoVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }
    
    /**
     * Obtiene y valida un código entero desde un texto
     * @param codigoTexto Texto que contiene el código
     * @return Código entero si es válido, -1 si hay error
     */
    public static int obtenerCodigo(String codigoTexto) {
        if (!validarTextoNoVacio(codigoTexto)) {
            return -1;
        }
        
        try {
            int codigo = Integer.parseInt(codigoTexto.trim());
            if (codigo < 0) {
                return -1; // Códigos negativos no son válidos
            }
            return codigo;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    /**
     * Obtiene y valida un nombre desde un texto
     * @param nombreTexto Texto que contiene el nombre
     * @return Nombre validado si es válido, null si hay error
     */
    public static String obtenerNombre(String nombreTexto) {
        if (!validarTextoNoVacio(nombreTexto)) {
            return null;
        }
        
        String nombre = nombreTexto.trim();
        if (nombre.length() < 2) {
            return null; // Nombres muy cortos no son válidos
        }
        
        return nombre;
    }
    
    /**
     * Obtiene y valida un precio desde un texto
     * @param precioTexto Texto que contiene el precio
     * @return Precio válido si es correcto, -1.0 si hay error
     */
    public static double obtenerPrecio(String precioTexto) {
        if (!validarTextoNoVacio(precioTexto)) {
            return -1.0;
        }
        
        try {
            double precio = Double.parseDouble(precioTexto.trim());
            if (precio < 0) {
                return -1.0; // Precios negativos no son válidos
            }
            return precio;
        } catch (NumberFormatException e) {
            return -1.0;
        }
    }
    
    /**
     * Valida todos los campos de entrada para una canción
     * @param codigoTexto Texto del código
     * @param nombreTexto Texto del nombre
     * @param precioTexto Texto del precio
     * @return true si todos los campos son válidos, false si alguno es inválido
     */
    public static boolean validarCamposCancion(String codigoTexto, String nombreTexto, String precioTexto) {
        // Verificar que ningún campo esté vacío
        if (!validarTextoNoVacio(codigoTexto) || 
            !validarTextoNoVacio(nombreTexto) || 
            !validarTextoNoVacio(precioTexto)) {
            return false;
        }
        
        // Validar formato del código
        if (obtenerCodigo(codigoTexto) == -1) {
            return false;
        }
        
        // Validar nombre
        if (obtenerNombre(nombreTexto) == null) {
            return false;
        }
        
        // Validar precio
        if (obtenerPrecio(precioTexto) == -1.0) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Muestra mensaje de error para campos vacíos
     */
    public static void mostrarErrorCamposVacios() {
        JOptionPane.showMessageDialog(null, 
            "Todos los campos son obligatorios", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Muestra mensaje de error para código inválido
     */
    public static void mostrarErrorCodigoInvalido() {
        JOptionPane.showMessageDialog(null, 
            "El código debe ser un número entero positivo", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Muestra mensaje de error para nombre inválido
     */
    public static void mostrarErrorNombreInvalido() {
        JOptionPane.showMessageDialog(null, 
            "El nombre debe tener al menos 2 caracteres", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Muestra mensaje de error para precio inválido
     */
    public static void mostrarErrorPrecioInvalido() {
        JOptionPane.showMessageDialog(null, 
            "El precio debe ser un número mayor o igual a 0", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Muestra mensaje de error genérico para formato numérico
     */
    public static void mostrarErrorFormatoNumerico() {
        JOptionPane.showMessageDialog(null, 
            "El código debe ser un número entero y el precio un número válido", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Muestra mensaje de éxito cuando se agrega una canción
     */
    public static void mostrarExitoCancionAgregada() {
        JOptionPane.showMessageDialog(null, 
            "Canción agregada exitosamente", 
            "Éxito", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Muestra mensaje de error cuando no se puede agregar una canción
     */
    public static void mostrarErrorCancionNoAgregada() {
        JOptionPane.showMessageDialog(null, 
            "No se pudo agregar la canción. " +
            "Verifique que el código no esté duplicado y que haya espacio disponible.", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}
