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
 * Representa el pago realizado con tarjeta.
 * Implementa los métodos de la interfaz MetodoPago.
 */
public class PagoTarjeta implements MetodoPago {

    /**
     * Simula la realización de un pago con tarjeta.
     *
     * @param valor valor que se debe pagar
     * @return true si el pago se realiza correctamente
     */
    @Override
    public boolean realizarPago(int valor) {
        return true;
    }

    /**
     * Devuelve el nombre del medio de pago.
     *
     * @return nombre del medio de pago
     */
    @Override
    public String obtenerNombre() {
        return "Tarjeta";
    }
}
