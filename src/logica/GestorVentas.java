/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import modelo.Venta;
/**
 *
 * @author kiara
 */

/**
 * Administra las ventas realizadas en la papelería.
 * Permite registrarlas y generar reportes.
 */
public class GestorVentas {

    private ArrayList<Venta> ventas;

    /**
     * Crea el gestor con una lista de ventas vacía.
     */
    public GestorVentas() {
        this.ventas = new ArrayList<>();
    }

    /**
     * Registra una venta si está confirmada.
     *
     * @param venta venta que se desea registrar
     */
    public void registrarVenta(Venta venta) {
        if (venta != null && venta.isConfirmada()) {
            ventas.add(venta);
        }
    }

    /**
     * Obtiene la lista de ventas registradas.
     *
     * @return lista de ventas
     */
    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    /**
     * Calcula la suma de todas las ventas registradas.
     *
     * @return total de dinero vendido
     */
    public int calcularTotalVentas() {

        int total = 0;

        for (Venta venta : ventas) {
            total += venta.calcularTotal();
        }

        return total;
    }

    /**
     * Muestra un reporte con las ventas realizadas,
     * la cantidad de ventas y el total vendido.
     */
    public void mostrarReporte() {

        System.out.println("===== REPORTE DE VENTAS =====");

        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }

        for (Venta venta : ventas) {
            System.out.println("Recibo: " + venta.getNumeroRecibo());
            System.out.println("Cliente: " + venta.getCliente().getNombre());
            System.out.println("Total: $" + venta.calcularTotal());
            System.out.println("----------------------------");
        }

        System.out.println("Total vendido: $" + calcularTotalVentas());
        System.out.println("Cantidad de ventas realizadas: " + ventas.size());
    }
}
