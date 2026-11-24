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
 * Representa los productos que se venden por peso.
 * Hereda los atributos y métodos de Producto.
 */
public class ProductoPeso extends Producto {

    /**
     * Crea un producto que se vende por peso.
     *
     * @param nombre nombre del producto
     * @param codigo código del producto
     * @param existencias cantidad disponible en gramos
     * @param precioBase precio del producto por kilo
     */
    public ProductoPeso(String nombre, int codigo, int existencias, int precioBase) {
        super(nombre, codigo, existencias, precioBase);
    }

    /**
     * Calcula el precio según los gramos solicitados.
     *
     * @param cantidad cantidad en gramos
     * @return precio correspondiente al peso solicitado
     */
    @Override
    public int calcularPrecio(int cantidad) {
        return (getPrecioBase() * cantidad) / 1000;
    }
}


