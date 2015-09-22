package model;

import model.Catalogo;
import model.Producto;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CatalogoModel extends AbstractTableModel {

    private final String[] encabezados = {"Producto", "Precio", "Cantidad"};

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
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        final Producto producto = productosList.get(rowIndex);
        if (columnIndex == 2) {
            // si me ingresan un numero menor a cero (o algo que no sea un numero) dejo la cantidad en cero
            try {
                final int cantidad = Integer.parseInt(String.valueOf(aValue));
                if (cantidad >= 0) producto.setCantidad(cantidad);
            } catch (NumberFormatException e) {
                producto.setCantidad(0);
            }

        }

        fireTableCellUpdated(rowIndex, columnIndex);
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
                return producto.getPrecio();
            case 2:
                return producto.getCantidad();
        }

        return "";
    }
}