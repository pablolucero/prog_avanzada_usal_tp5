package carrito.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ListadoComprasModel extends AbstractTableModel {

    private final String[] encabezados = {"Producto", "Cantidad", "Precio"};

    private final List<Producto> productosList;

    public ListadoComprasModel() {

        productosList = Carrito.getInstance().getProductos();
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
        final int COLUMNA_PRECIO = 2;

        for (int i = 0; i < this.getRowCount(); i++) {
            total += (double) getValueAt(i, COLUMNA_PRECIO);
        }
        return total;
    }

    public void vaciar() {
        // check that the table is not already empty
        if (getRowCount() > 0) {
            final int lastRow = getRowCount() - 1;
            for (int i = lastRow; i >= 0; i--) productosList.remove(i);
            fireTableRowsDeleted(0, lastRow);
        }
    }
}
