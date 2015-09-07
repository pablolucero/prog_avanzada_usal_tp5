package carrito.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carrito {

    private static List<Producto> productos;
    private static Map<Producto, Integer> productosMapa;

    private Carrito() {
    }

    public static List<Producto> getProductos() {
        if (productos == null) {
            productos = new ArrayList<>();
        }

        return productos;
    }

    public static Map<Producto, Integer> getProductosMapa() {
        if (productosMapa == null) {
            productosMapa = new HashMap<>();
        }
        return productosMapa;
    }

}
