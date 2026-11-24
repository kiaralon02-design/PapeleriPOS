/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ejecucion;

import java.util.Scanner;
import modelo.*;
import logica.*;

/**
 *
 * @author kiara
 */

import java.util.Scanner;
import modelo.*;
import logica.*;

/**
 * Clase principal del sistema de punto de venta de la papelería.
 * Permite administrar productos, clientes y ventas desde un menú.
 */
public class PapeleriaPOS {

    /**
     * Inicia el sistema y muestra el menú principal.
     *
     * @param args argumentos de ejecución
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Catalogo catalogo = new Catalogo();
        GestorVentas gestor = new GestorVentas();

        cargarDatosIniciales(catalogo);

        int opcion;

        do {

            System.out.println("\n===== PAPELERIA ESCOLAR =====");
            System.out.println("1. Listar productos");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar producto");
            System.out.println("4. Realizar venta");
            System.out.println("5. Reporte de ventas");
            System.out.println("6. Buscar cliente");
            System.out.println("7. Registrar producto");
            System.out.println("8. Registrar cliente");
            System.out.println("9. Actualizar precio");
            System.out.println("10. Actualizar existencias");
            System.out.println("11. Productos con pocas existencias");
            System.out.println("12. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = leerEntero(teclado);

            switch (opcion) {

                case 1:
                    listarProductos(catalogo);
                    break;

                case 2:
                    listarClientes(catalogo);
                    break;

                case 3:
                    buscarProducto(teclado, catalogo);
                    break;

                case 4:
                    realizarVenta(teclado, catalogo, gestor);
                    break;

                case 5:
                    gestor.mostrarReporte();
                    break;

                case 6:
                    buscarCliente(teclado, catalogo);
                    break;

                case 7:
                    registrarProducto(teclado, catalogo);
                    break;

                case 8:
                    registrarCliente(teclado, catalogo);
                    break;

                case 9:
                    actualizarPrecio(teclado, catalogo);
                    break;

                case 10:
                    actualizarExistencias(teclado, catalogo);
                    break;

                case 11:
                    mostrarProductosBajos(catalogo);
                    break;

                case 12:
                    System.out.println("Gracias por utilizar el sistema.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 12);

        teclado.close();
    }

    /**
     * Carga los productos y clientes iniciales del sistema.
     *
     * @param catalogo catálogo donde se guardan los datos
     */
    public static void cargarDatosIniciales(Catalogo catalogo) {

        catalogo.agregarProducto(
            new ProductoUnidad("Cuaderno", 101, 20, 5000)
        );

        catalogo.agregarProducto(
            new ProductoUnidad("Lapiz", 102, 50, 1500)
        );

        catalogo.agregarProducto(
            new ProductoUnidad("Borrador", 103, 30, 1000)
        );

        catalogo.agregarProducto(
            new ProductoPeso("Cartulina por kilo", 201, 10000, 8000)
        );

        catalogo.agregarProducto(
            new ProductoPeso("Fomi por kilo", 202, 5000, 12000)
        );

        catalogo.agregarCliente(
            new Cliente("Maria Lopez", "12345", "3001234567")
        );

        catalogo.agregarCliente(
            new Cliente("Carlos Perez", "67890", "3101234567")
        );
    }

    /**
     * Muestra todos los productos registrados.
     *
     * @param catalogo catálogo de productos
     */
    public static void listarProductos(Catalogo catalogo) {

        System.out.println("\n===== PRODUCTOS =====");

        for (Producto producto : catalogo.getProductos()) {

            System.out.println(
                "Codigo: " + producto.getCodigo()
                + " | Nombre: " + producto.getNombre()
                + " | Precio: $" + producto.getPrecioBase()
                + " | Existencias: " + producto.getExistencias()
            );
        }
    }

    /**
     * Muestra todos los clientes registrados.
     *
     * @param catalogo catálogo de clientes
     */
    public static void listarClientes(Catalogo catalogo) {

        System.out.println("\n===== CLIENTES =====");

        for (Cliente cliente : catalogo.getClientes()) {

            System.out.println(
                "Documento: " + cliente.getDocumento()
                + " | Nombre: " + cliente.getNombre()
                + " | Telefono: " + cliente.getTelefono()
            );
        }
    }

    /**
     * Registra un producto nuevo por unidad o por peso.
     *
     * @param teclado permite leer los datos ingresados
     * @param catalogo catálogo donde se registra el producto
     */
    public static void registrarProducto(Scanner teclado, Catalogo catalogo) {

        System.out.println("\n===== REGISTRAR PRODUCTO =====");

        System.out.println("1. Producto por unidad");
        System.out.println("2. Producto por peso");
        System.out.print("Seleccione el tipo de producto: ");

        int tipo = leerEntero(teclado);

        if (tipo != 1 && tipo != 2) {
            System.out.println("Tipo de producto no valido.");
            return;
        }

        System.out.print("Ingrese el codigo: ");
        int codigo = leerEntero(teclado);

        if (codigo <= 0) {
            System.out.println("El codigo debe ser mayor que cero.");
            return;
        }

        if (catalogo.buscarProducto(codigo) != null) {
            System.out.println("Ya existe un producto con ese codigo.");
            return;
        }

        System.out.print("Ingrese el nombre: ");
        String nombre = teclado.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacio.");
            return;
        }

        System.out.print("Ingrese las existencias: ");
        int existencias = leerEntero(teclado);

        if (existencias <= 0) {
            System.out.println("Las existencias deben ser mayores que cero.");
            return;
        }

        if (tipo == 1) {
            System.out.print("Ingrese el precio por unidad: ");
        } else {
            System.out.print("Ingrese el precio por kilo: ");
        }

        int precio = leerEntero(teclado);

        if (precio <= 0) {
            System.out.println("El precio debe ser mayor que cero.");
            return;
        }

        Producto producto;

        if (tipo == 1) {
            producto = new ProductoUnidad(
                nombre, codigo, existencias, precio
            );
        } else {
            producto = new ProductoPeso(
                nombre, codigo, existencias, precio
            );
        }

        if (catalogo.agregarProducto(producto)) {
            System.out.println("Producto registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el producto.");
        }
    }

    /**
     * Registra un cliente nuevo en el catálogo.
     *
     * @param teclado permite leer los datos ingresados
     * @param catalogo catálogo donde se registra el cliente
     */
    public static void registrarCliente(Scanner teclado, Catalogo catalogo) {

        System.out.println("\n===== REGISTRAR CLIENTE =====");

        System.out.print("Ingrese el documento: ");
        String documento = teclado.nextLine().trim();

        if (documento.isEmpty()) {
            System.out.println("El documento no puede estar vacio.");
            return;
        }

        if (catalogo.buscarCliente(documento) != null) {
            System.out.println("Ya existe un cliente con ese documento.");
            return;
        }

        System.out.print("Ingrese el nombre: ");
        String nombre = teclado.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacio.");
            return;
        }

        System.out.print("Ingrese el telefono: ");
        String telefono = teclado.nextLine().trim();

        if (telefono.isEmpty()) {
            System.out.println("El telefono no puede estar vacio.");
            return;
        }

        Cliente cliente = new Cliente(nombre, documento, telefono);

        if (catalogo.agregarCliente(cliente)) {
            System.out.println("Cliente registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el cliente.");
        }
    }

    /**
     * Busca un producto utilizando su código.
     *
     * @param teclado permite leer el código
     * @param catalogo catálogo donde se realiza la búsqueda
     */
    public static void buscarProducto(Scanner teclado, Catalogo catalogo) {

        System.out.print("Ingrese el codigo del producto: ");
        int codigo = leerEntero(teclado);

        Producto producto = catalogo.buscarProducto(codigo);

        if (producto != null) {

            System.out.println("Producto encontrado: " + producto.getNombre());
            System.out.println("Precio: $" + producto.getPrecioBase());
            System.out.println("Existencias: " + producto.getExistencias());

        } else {
            System.out.println("El producto no existe.");
        }
    }

    /**
     * Busca un cliente utilizando su documento.
     *
     * @param teclado permite leer el documento
     * @param catalogo catálogo donde se realiza la búsqueda
     */
    public static void buscarCliente(Scanner teclado, Catalogo catalogo) {

        System.out.print("Ingrese el documento del cliente: ");
        String documento = teclado.nextLine();

        Cliente cliente = catalogo.buscarCliente(documento);

        if (cliente != null) {

            System.out.println("Cliente: " + cliente.getNombre());
            System.out.println("Telefono: " + cliente.getTelefono());

        } else {
            System.out.println("El cliente no existe.");
        }
    }

    /**
     * Realiza una venta con productos y un medio de pago.
     *
     * @param teclado permite leer los datos de la venta
     * @param catalogo catálogo de productos y clientes
     * @param gestor administrador de las ventas
     */
    public static void realizarVenta(
        Scanner teclado,
        Catalogo catalogo,
        GestorVentas gestor
    ) {

        System.out.print("Documento del cliente: ");
        String documento = teclado.nextLine();

        Cliente cliente = catalogo.buscarCliente(documento);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta");
        System.out.print("Seleccione el medio de pago: ");

        int opcionPago = leerEntero(teclado);

        MetodoPago pago;

        if (opcionPago == 1) {
            pago = new PagoEfectivo();
        } else if (opcionPago == 2) {
            pago = new PagoTarjeta();
        } else {
            System.out.println("Medio de pago no valido.");
            return;
        }

        Venta venta = new Venta(cliente, pago);

        int codigo;

        do {

            listarProductos(catalogo);

            System.out.print("\nCodigo del producto (0 para terminar): ");
            codigo = leerEntero(teclado);

            if (codigo == 0) {
                break;
            }

            Producto producto = catalogo.buscarProducto(codigo);

            if (producto == null) {
                System.out.println("Producto no encontrado.");
                continue;
            }

            System.out.print(
                "Cantidad (unidades o gramos, segun el producto): "
            );

            int cantidad = leerEntero(teclado);

            if (venta.agregarItem(producto, cantidad)) {
                System.out.println("Producto agregado correctamente.");
            } else {
                System.out.println("No se pudo agregar. Revise la cantidad y las existencias.");
            }

        } while (true);

        if (venta.confirmarVenta()) {

            gestor.registrarVenta(venta);

            System.out.println("\nVenta realizada correctamente.");

            Comprobante.mostrar(venta);

        } else {
            System.out.println("No se pudo confirmar la venta.");
        }
    }

    /**
     * Lee un número entero desde el teclado.
     *
     * @param teclado permite leer el dato ingresado
     * @return número entero válido
     */
    public static int leerEntero(Scanner teclado) {

        while (true) {

            try {
                return Integer.parseInt(teclado.nextLine());

            } catch (NumberFormatException e) {

                System.out.print("Ingrese un numero valido: ");
            }
        }
    }

    /**
     * Actualiza el precio de un producto.
     *
     * @param teclado permite leer los datos
     * @param catalogo catálogo donde se actualiza el producto
     */
    public static void actualizarPrecio(Scanner teclado, Catalogo catalogo) {

        System.out.print("Ingrese el codigo del producto: ");
        int codigo = leerEntero(teclado);

        System.out.print("Ingrese el nuevo precio: ");
        int precio = leerEntero(teclado);

        if (catalogo.actualizarPrecio(codigo, precio)) {
            System.out.println("Precio actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar el precio.");
        }
    }

    /**
     * Actualiza las existencias de un producto.
     *
     * @param teclado permite leer los datos
     * @param catalogo catálogo donde se actualiza el producto
     */
    public static void actualizarExistencias(Scanner teclado, Catalogo catalogo) {

        System.out.print("Ingrese el codigo del producto: ");
        int codigo = leerEntero(teclado);

        System.out.print("Ingrese las nuevas existencias: ");
        int existencias = leerEntero(teclado);

        if (catalogo.actualizarExistencias(codigo, existencias)) {
            System.out.println("Existencias actualizadas correctamente.");
        } else {
            System.out.println("No se pudieron actualizar las existencias.");
        }
    }

    /**
     * Muestra los productos que tienen cinco existencias o menos.
     *
     * @param catalogo catálogo de productos que se revisa
     */
    public static void mostrarProductosBajos(Catalogo catalogo) {

        System.out.println("\n===== PRODUCTOS CON POCAS EXISTENCIAS =====");

        boolean encontrados = false;

        for (Producto producto : catalogo.getProductos()) {

            if (producto.getExistencias() <= 5) {

                System.out.println("Codigo: " + producto.getCodigo());
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Existencias: " + producto.getExistencias());

                encontrados = true;
            }
        }

        if (!encontrados) {
            System.out.println("No hay productos con pocas existencias.");
        }
    }
}
