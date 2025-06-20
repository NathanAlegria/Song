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
    
    
    public static boolean validarTextoNoVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }
    
    
    public static int obtenerCodigo(String codigoTexto) {
        if (!validarTextoNoVacio(codigoTexto)) {
            return -1;
        }
        
        try {
            int codigo = Integer.parseInt(codigoTexto.trim());
            if (codigo < 0) {
                return -1; 
            }
            return codigo;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    
    public static String obtenerNombre(String nombreTexto) {
        if (!validarTextoNoVacio(nombreTexto)) {
            return null;
        }
        
        String nombre = nombreTexto.trim();
        if (nombre.length() < 2) {
            return null; 
        }
        
        return nombre;
    }
    
  
    public static double obtenerPrecio(String precioTexto) {
        if (!validarTextoNoVacio(precioTexto)) {
            return -1.0;
        }
        
        try {
            double precio = Double.parseDouble(precioTexto.trim());
            if (precio < 0) {
                return -1.0; 
            }
            return precio;
        } catch (NumberFormatException e) {
            return -1.0;
        }
    }
   
    public static boolean validarCamposCancion(String codigoTexto, String nombreTexto, String precioTexto) {
     
        if (!validarTextoNoVacio(codigoTexto) || 
            !validarTextoNoVacio(nombreTexto) || 
            !validarTextoNoVacio(precioTexto)) {
            return false;
        }
        
     
        if (obtenerCodigo(codigoTexto) == -1) {
            return false;
        }
        
       
        if (obtenerNombre(nombreTexto) == null) {
            return false;
        }
        
       
        if (obtenerPrecio(precioTexto) == -1.0) {
            return false;
        }
        
        return true;
    }
    
  
    public static void mostrarErrorCamposVacios() {
        JOptionPane.showMessageDialog(null, 
            "Todos los campos son obligatorios", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    
   
    public static void mostrarErrorCodigoInvalido() {
        JOptionPane.showMessageDialog(null, 
            "El código debe ser un número entero positivo", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    
 
    public static void mostrarErrorNombreInvalido() {
        JOptionPane.showMessageDialog(null, 
            "El nombre debe tener al menos 2 caracteres", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    
  
    public static void mostrarErrorPrecioInvalido() {
        JOptionPane.showMessageDialog(null, 
            "El precio debe ser un número mayor o igual a 0", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    
 
    public static void mostrarErrorFormatoNumerico() {
        JOptionPane.showMessageDialog(null, 
            "El código debe ser un número entero y el precio un número válido", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    
    
    public static void mostrarExitoCancionAgregada() {
        JOptionPane.showMessageDialog(null, 
            "Canción agregada exitosamente", 
            "Éxito", 
            JOptionPane.INFORMATION_MESSAGE);
    }
     
    
    public static void mostrarErrorCancionNoAgregada() {
        JOptionPane.showMessageDialog(null, 
            "No se pudo agregar la canción. " +
            "Verifique que el código no esté duplicado y que haya espacio disponible.", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}
