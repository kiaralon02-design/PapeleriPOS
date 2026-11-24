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
 * Define los métodos que deben tener las formas de pago.
 */
public interface MetodoPago {

    /**
     * Realiza el pago de una venta.
     *
     * @param valor valor que se debe pagar
     * @return true si el pago se realiza correctamente
     */
    boolean realizarPago(int valor);

    /**
     * Obtiene el nombre del medio de pago.
     *
     * @return nombre del medio de pago
     */
    String obtenerNombre();
}
