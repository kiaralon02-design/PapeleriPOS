/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
/**
 *
 * @author kiara
 */

/**
 * Representa una venta realizada en la papelería.
 * Guarda el cliente, los productos, el medio de pago y los valores.
 */
public class Venta {

    private static int consecutivo = 1;
    public static final int IVA = 19;

    private int numeroRecibo;
    private Cliente cliente;
    private ArrayList<ItemVenta> items;
    private MetodoPago metodoPago;
    private boolean confirmada;

    /**
     * Crea una venta y asigna un número de recibo.
     *
     * @param cliente cliente que realiza la compra
     * @param metodoPago medio de pago seleccionado
     */
    public Venta(Cliente cliente, MetodoPago metodoPago) {
        this.numeroRecibo = consecutivo++;
        this.cliente = cliente;
        this.metodoPago = metodoPago;
        this.items = new ArrayList<>();
        this.confirmada = false;
    }

    /**
     * Obtiene el número del recibo.
     *
     * @return número del recibo
     */
    public int getNumeroRecibo() {
        return numeroRecibo;
    }

    /**
     * Obtiene el cliente de la venta.
     *
     * @return cliente asociado
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Obtiene los productos de la venta.
     *
     * @return lista de elementos de venta
     */
    public ArrayList<ItemVenta> getItems() {
        return items;
    }

    /**
     * Obtiene el medio de pago seleccionado.
     *
     * @return medio de pago
     */
    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    /**
     * Agrega un producto a la venta si hay existencias suficientes.
     *
     * @param producto producto que se desea agregar
     * @param cantidad cantidad solicitada
     * @return true si el producto se agrega correctamente
     */
    public boolean agregarItem(Producto producto, int cantidad) {

        if (producto == null || cantidad <= 0) {
            return false;
        }

        for (ItemVenta item : items) {

            if (item.getProducto() == producto) {

                if (item.getCantidad() + cantidad > producto.getExistencias()) {
                    return false;
                }

                item.agregarCantidad(cantidad);
                return true;
            }
        }

        if (cantidad > producto.getExistencias()) {
            return false;
        }

        items.add(new ItemVenta(producto, cantidad));
        return true;
    }

    /**
     * Calcula el subtotal de todos los productos.
     *
     * @return subtotal de la venta
     */
    public int calcularSubtotal() {
        int subtotal = 0;

        for (ItemVenta item : items) {
            subtotal += item.calcularSubtotal();
        }

        return subtotal;
    }

    /**
     * Calcula el IVA del 19 por ciento.
     *
     * @return valor del IVA
     */
    public int calcularIVA() {
        return calcularSubtotal() * IVA / 100;
    }

    /**
     * Calcula el total de la venta incluyendo el IVA.
     *
     * @return total que debe pagar el cliente
     */
    public int calcularTotal() {
        return calcularSubtotal() + calcularIVA();
    }

    /**
     * Confirma la venta, realiza el pago y descuenta las existencias.
     *
     * @return true si la venta se confirma correctamente
     */
    public boolean confirmarVenta() {

        if (confirmada || items.isEmpty() || metodoPago == null) {
            return false;
        }

        for (ItemVenta item : items) {
            if (item.getCantidad() > item.getProducto().getExistencias()) {
                return false;
            }
        }

        if (!metodoPago.realizarPago(calcularTotal())) {
            return false;
        }

        for (ItemVenta item : items) {
            Producto producto = item.getProducto();

            producto.setExistencias(
                producto.getExistencias() - item.getCantidad()
            );
        }

        confirmada = true;
        return true;
    }

    /**
     * Consulta si la venta ya fue confirmada.
     *
     * @return true si la venta está confirmada
     */
    public boolean isConfirmada() {
        return confirmada;
    }
}

