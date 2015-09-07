package carrito.model;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ListadoComprasModel extends DefaultTableModel {
//public class ListadoComprasModel extends AbstractTableModel {

    private String[] encabezados = {"Producto", "Cantidad", "Precio"};

    // TODO: productosList deberia tener la mezcla de los productos seleccionados en los 2 Catalogos
    private List<Producto> productosList;

    public ListadoComprasModel() {

        productosList = Producto.getProductosCat1();
    }

    @Override
    public String getColumnName(int x) {
        return encabezados[x];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public int getRowCount() {
        if (productosList != null)
            return productosList.size();
        else
            return 0;
    }

    @Override
    public int getColumnCount() {
        return encabezados.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        final Producto producto = productosList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return producto.getNombre();
            case 1:
                return producto.getCantidad();
            case 2:
                return producto.getPrecio();
        }

        return "";
    }

    public double sumarTotal() {

        double total = 0;
        int COLUMNA_PRECIO = 2;

        for (int i = 0; i < this.getRowCount(); i++) {
            total += (double) getValueAt(i, COLUMNA_PRECIO);
        }
        return total;
    }

    public void vaciar() {
        final int lastRow = getRowCount() - 1;
        // check that the table is not already empty
        if (lastRow > 0) {
            for (int i = (lastRow); i >= 0; i--) productosList.remove(i);
            fireTableRowsDeleted(0, lastRow);
        }
    }
}
