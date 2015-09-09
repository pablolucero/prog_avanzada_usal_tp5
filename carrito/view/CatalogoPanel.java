package carrito.view;

import carrito.model.Carrito;
import carrito.model.Catalogo;
import carrito.model.CatalogoModel;
import carrito.model.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CatalogoPanel extends JPanel {

    private JTable table;

    public CatalogoPanel(Catalogo nroDeCatalogo) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        switch (nroDeCatalogo) {

            case UNO:
                add(new JLabel("Catalogo 1"));
                break;
            case DOS:
                add(new JLabel("Catalogo 2"));
                break;
        }

        table = new JTable(new CatalogoModel(nroDeCatalogo));

        add(table.getTableHeader());
        add(table);

        final JButton comprarButton = new JButton("Comprar");
        comprarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprarButtonPressed();
            }
        });
        add(comprarButton);

    }

    private void comprarButtonPressed() {

        final List<Producto> productosEnCarrito = Carrito.getInstance().getProductos();

        for (int rowIndex = 0; rowIndex < table.getRowCount(); rowIndex++) {
            if (table.getValueAt(rowIndex, 2) != null) {
                int cantidadASumar = (!String.valueOf(table.getValueAt(rowIndex, 2)).isEmpty()) ? Integer.parseInt(String.valueOf(table.getValueAt(rowIndex, 2))) : 0;
                if (cantidadASumar > 0) {
                    final String productName = table.getValueAt(rowIndex, 0).toString();

                    final int indexByProductName = Carrito.getIndexByProductName(productName);
                    if (indexByProductName > -1) { // si el producto ya existe en el carrito se suma al total
                        final Producto producto = productosEnCarrito.get(indexByProductName);
                        final int cantidadTotal = producto.getCantidad() + cantidadASumar;
                        producto.setCantidad(cantidadTotal);
                    } else { // y si el producto no ya existe en el carrito se agrega
                        double precio = Double.valueOf(String.valueOf(table.getValueAt(rowIndex, 1)));
                        productosEnCarrito.add(new Producto(productName, cantidadASumar, precio));
                    }
                }
                // despues de comprar hay que reiniciar en cero el campo cantidad
                table.setValueAt("0", rowIndex, 2);
            }
        }

        // TOOD: delete this. Only used for debugging
        System.out.println("***************************");
        System.out.println(Carrito.getInstance().getProductos());
        System.out.println("***************************");

    }
}
