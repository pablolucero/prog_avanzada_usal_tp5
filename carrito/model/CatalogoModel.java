package carrito.model;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CatalogoModel extends DefaultTableModel {

    private String[] encabezados = {"Producto", "Precio", "Cantidad"};

    private List<Producto> productosList;

    public CatalogoModel(Catalogo nroCatalogo) {
        switch (nroCatalogo) {
            case UNO:
                productosList = Producto.getProductosCat1();
                break;
            case DOS:
                productosList = Producto.getProductosCat2();
                break;
        }
    }

    @Override
    public String getColumnName(int x) {
        return encabezados[x];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // solo se puede editar la columna de Cantidad
        return columnIndex == 2;
    }

    @Override
    public int getRowCount() {
        return encabezados.length;
    }

    @Override
    public int getColumnCount() {
        return productosList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        final Producto producto = productosList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return producto.getNombre();
            case 1:
                return producto.getPrecio();
            case 2:
                return producto.getCantidad();
        }

        return "";
    }
}