package carrito.model;

import java.util.ArrayList;
import java.util.List;

public class Producto {

    private final String nombre;
    private int cantidad;
    private final double precio;

    public Producto(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public static List<Producto> getProductosCat1() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Producto A", 0, 20));
        productos.add(new Producto("Producto B", 0, 30.50));
        productos.add(new Producto("Producto C", 0, 40.90));

        return productos;
    }

    public static List<Producto> getProductosCat2() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Producto X", 0, 20));
        productos.add(new Producto("Producto Y", 0, 30.50));
        productos.add(new Producto("Producto Z", 0, 40.90));

        return productos;
    }

    @Override
    public String toString() {
        return getNombre() + " - $" + getPrecio() + " - " + getCantidad() + " unidades";
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }
}
