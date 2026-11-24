/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import modelo.Venta;
import modelo.ItemVenta;

/**
 *
 * @author kiara
 */

/**
 * Se encarga de mostrar el comprobante de una venta.
 */
public class Comprobante {

    /**
     * Muestra los datos de la venta, los productos,
     * el subtotal, el IVA y el total a pagar.
     *
     * @param venta venta de la cual se genera el comprobante
     */
    public static void mostrar(Venta venta) {

        if (venta == null) {
            System.out.println("No se puede mostrar el comprobante.");
            return;
        }

        System.out.println("===== COMPROBANTE DE VENTA =====");
        System.out.println("Numero de recibo: " + venta.getNumeroRecibo());
        System.out.println("Cliente: " + venta.getCliente().getNombre());
        System.out.println("Documento: " + venta.getCliente().getDocumento());

        System.out.println("Productos:");

        for (ItemVenta item : venta.getItems()) {
            System.out.println(
                item.getProducto().getNombre()
                + " - Cantidad: " + item.getCantidad()
                + " - Subtotal: $" + item.calcularSubtotal()
            );
        }

        System.out.println("Subtotal: $" + venta.calcularSubtotal());
        System.out.println("IVA: $" + venta.calcularIVA());
        System.out.println("Total: $" + venta.calcularTotal());
        System.out.println("Metodo de pago: " + venta.getMetodoPago().obtenerNombre());
    }
}

