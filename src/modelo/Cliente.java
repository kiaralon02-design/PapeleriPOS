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
 * Representa un cliente de la papelería.
 * Guarda su nombre, documento y teléfono.
 */
public class Cliente {

    private String nombre;
    private String documento;
    private String telefono;

    /**
     * Crea un cliente con sus datos personales.
     *
     * @param nombre nombre del cliente
     * @param documento documento de identidad
     * @param telefono número de teléfono
     */
    public Cliente(String nombre, String documento, String telefono) {
        setNombre(nombre);
        setDocumento(documento);
        setTelefono(telefono);
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el documento del cliente.
     *
     * @return documento del cliente
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * Obtiene el teléfono del cliente.
     *
     * @return teléfono del cliente
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Cambia el nombre si no está vacío ni es nulo.
     *
     * @param nombre nuevo nombre del cliente
     */
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    /**
     * Cambia el documento si no está vacío ni es nulo.
     *
     * @param documento nuevo documento del cliente
     */
    public void setDocumento(String documento) {
        if (documento != null && !documento.trim().isEmpty()) {
            this.documento = documento;
        }
    }

    /**
     * Cambia el teléfono si no está vacío ni es nulo.
     *
     * @param telefono nuevo teléfono del cliente
     */
    public void setTelefono(String telefono) {
        if (telefono != null && !telefono.trim().isEmpty()) {
            this.telefono = telefono;
        }
    }
}

