/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import modelo.Producto;
import modelo.Cliente;
/**
 *
 * @author kiara
 */

/**
 * Administra los productos y clientes de la papelería.
 * Permite registrar, buscar y actualizar su información.
 */
public class Catalogo {

    private ArrayList<Producto> productos;
    private ArrayList<Cliente> clientes;

    /**
     * Crea el catálogo con listas vacías.
     */
    public Catalogo() {
        this.productos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    /**
     * Agrega un producto si no está registrado.
     *
     * @param producto producto que se desea agregar
     * @return true si se agrega correctamente
     */
    public boolean agregarProducto(Producto producto) {
        if (producto == null) {
            return false;
        }

        if (buscarProducto(producto.getCodigo()) != null) {
            return false;
        }

        productos.add(producto);
        return true;
    }

    /**
     * Agrega un cliente si no está registrado.
     *
     * @param cliente cliente que se desea agregar
     * @return true si se agrega correctamente
     */
    public boolean agregarCliente(Cliente cliente) {
        if (cliente == null) {
            return false;
        }

        if (buscarCliente(cliente.getDocumento()) != null) {
            return false;
        }

        clientes.add(cliente);
        return true;
    }

    /**
     * Busca un producto por su código.
     *
     * @param codigo código del producto
     * @return producto encontrado o null si no existe
     */
    public Producto buscarProducto(int codigo) {

        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }

        return null;
    }

    /**
     * Busca un cliente por su documento.
     *
     * @param documento documento del cliente
     * @return cliente encontrado o null si no existe
     */
    public Cliente buscarCliente(String documento) {

        for (Cliente cliente : clientes) {
            if (cliente.getDocumento().equals(documento)) {
                return cliente;
            }
        }

        return null;
    }

    /**
     * Actualiza el precio de un producto.
     *
     * @param codigo código del producto
     * @param nuevoPrecio nuevo precio base
     * @return true si se actualiza correctamente
     */
    public boolean actualizarPrecio(int codigo, int nuevoPrecio) {

        Producto producto = buscarProducto(codigo);

        if (producto == null || nuevoPrecio <= 0) {
            return false;
        }

        producto.setPrecioBase(nuevoPrecio);
        return true;
    }

    /**
     * Actualiza las existencias de un producto.
     *
     * @param codigo código del producto
     * @param nuevasExistencias nueva cantidad disponible
     * @return true si se actualizan correctamente
     */
    public boolean actualizarExistencias(int codigo, int nuevasExistencias) {

        Producto producto = buscarProducto(codigo);

        if (producto == null || nuevasExistencias < 0) {
            return false;
        }

        producto.setExistencias(nuevasExistencias);
        return true;
    }

    /**
     * Muestra el precio calculado de cada producto para una cantidad.
     * Utiliza el polimorfismo de las clases ProductoUnidad y ProductoPeso.
     *
     * @param cantidad cantidad que se utiliza para el cálculo
     */
    public void mostrarPrecios(int cantidad) {

        for (Producto producto : productos) {

            System.out.println(
                producto.getNombre() + ": $"
                + producto.calcularPrecio(cantidad)
            );
        }
    }

    /**
     * Obtiene la lista de productos.
     *
     * @return lista de productos del catálogo
     */
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    /**
     * Obtiene la lista de clientes.
     *
     * @return lista de clientes del catálogo
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}


