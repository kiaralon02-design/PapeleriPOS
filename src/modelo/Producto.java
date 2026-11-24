/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author kiara
 */

/**
 * Representa un producto de la papelería.
 * Contiene la información básica de cada producto.
 */
public class Producto {

    private String nombre;
    private int codigo;
    private int existencias;
    private int precioBase;

    /**
     * Crea un producto con sus datos iniciales.
     *
     * @param nombre nombre del producto
     * @param codigo código del producto
     * @param existencias cantidad disponible
     * @param precioBase precio base del producto
     */
    public Producto(String nombre, int codigo, int existencias, int precioBase) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.existencias = existencias;
        this.precioBase = precioBase;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el código del producto.
     *
     * @return código del producto
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Obtiene las existencias del producto.
     *
     * @return cantidad disponible
     */
    public int getExistencias() {
        return existencias;
    }

    /**
     * Obtiene el precio base del producto.
     *
     * @return precio base
     */
    public int getPrecioBase() {
        return precioBase;
    }

    /**
     * Cambia el nombre si no está vacío ni es nulo.
     *
     * @param nombre nuevo nombre del producto
     */
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    /**
     * Actualiza las existencias si no son negativas.
     *
     * @param existencias nueva cantidad disponible
     */
    public void setExistencias(int existencias) {
        if (existencias >= 0) {
            this.existencias = existencias;
        }
    }

    /**
     * Cambia el precio si es mayor que cero.
     *
     * @param precioBase nuevo precio base
     */
    public void setPrecioBase(int precioBase) {
        if (precioBase > 0) {
            this.precioBase = precioBase;
        }
    }

    /**
     * Calcula el precio según la cantidad solicitada.
     *
     * @param cantidad cantidad del producto
     * @return precio total
     */
    public int calcularPrecio(int cantidad) {
        return precioBase * cantidad;
    }
}

    

