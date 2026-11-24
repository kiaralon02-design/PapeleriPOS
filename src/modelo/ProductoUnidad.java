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
 * Representa los productos que se venden por unidades.
 * Hereda los atributos y métodos de Producto.
 */
public class ProductoUnidad extends Producto {

    /**
     * Crea un producto que se vende por unidades.
     *
     * @param nombre nombre del producto
     * @param codigo código del producto
     * @param existencias cantidad disponible
     * @param precioBase precio de cada unidad
     */
    public ProductoUnidad(String nombre, int codigo, int existencias, int precioBase) {
        super(nombre, codigo, existencias, precioBase);
    }

    /**
     * Calcula el precio multiplicando el valor unitario
     * por la cantidad solicitada.
     *
     * @param cantidad cantidad de unidades
     * @return precio total
     */
    @Override
    public int calcularPrecio(int cantidad) {
        return getPrecioBase() * cantidad;
    }
}

