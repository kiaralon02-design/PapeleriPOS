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
 * Representa un producto dentro de una venta.
 * Guarda el producto y la cantidad solicitada.
 */
public class ItemVenta {

    private Producto producto;
    private int cantidad;

    /**
     * Crea un elemento de venta.
     *
     * @param producto producto que se va a vender
     * @param cantidad cantidad solicitada
     */
    public ItemVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el producto del elemento de venta.
     *
     * @return producto asociado
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Obtiene la cantidad del producto.
     *
     * @return cantidad solicitada
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Calcula el subtotal del producto.
     *
     * @return valor total del producto según su cantidad
     */
    public int calcularSubtotal() {
        return producto.calcularPrecio(cantidad);
    }

    /**
     * Aumenta la cantidad si el nuevo valor es positivo.
     *
     * @param cantidad cantidad que se desea agregar
     */
    public void agregarCantidad(int cantidad) {
        if (cantidad > 0) {
            this.cantidad += cantidad;
        }
    }
}
