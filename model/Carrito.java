package model;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private static Carrito instance = null;
    private List<Producto> productos;

    private Carrito() {
    }

    public static Carrito getInstance() {
        if (instance == null) {
            instance = new Carrito();
        }
        return instance;
    }

    /**
     * @return -1 si no encuentra un Producto con el nombre en el Carrito
     */
    public static int getIndexByProductName(String nombre) {
        List<Producto> productos1 = getInstance().getProductos();
        for (int i = 0; i < productos1.size(); i++) {
            Producto producto = productos1.get(i);
            if (producto.getNombre().equals(nombre)) return i;
        }
        return -1;
    }

    public List<Producto> getProductos() {
        if (productos == null) {
            productos = new ArrayList<>();
        }

        return productos;
    }

}
