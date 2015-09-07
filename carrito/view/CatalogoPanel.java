package carrito.view;

import carrito.model.Catalogo;
import carrito.model.CatalogoModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CatalogoPanel extends JPanel {

    private CatalogoModel model;

    public CatalogoPanel(Catalogo nroDeCatalogo) {
        super();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        switch (nroDeCatalogo) {

            case UNO:
                add(new JLabel("Catalogo 1"));
                break;
            case DOS:
                add(new JLabel("Catalogo 2"));
                break;
        }

        final JTable table = new JTable(new CatalogoModel(nroDeCatalogo));

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


        // metodo nico
//        Compra lp = new Compra();
//        List<Productos> productos = new ArrayList<Productos>();
//        for(int x = 0; x < tabla.getRowCount(); x++) {
//            if(!String.valueOf(tabla.getValueAt(x, 2)).isEmpty()) {
//                while (tabla.getValueAt(x, 2) != null) {
//                    int valor = Integer.parseInt(String.valueOf(tabla.getValueAt(x, 2)));
//                    if(valor > 0) {
//                        Productos p = new Productos(tabla.getValueAt(x, 0).toString(), Double.parseDouble(String.valueOf(tabla.getValueAt(x,1)).substring(1)), Integer.parseInt(String.valueOf(tabla.getValueAt(x, 2))));
//                        productos.add(p);
//                        lp.addElemento(p);
//                    }
//                    tabla.setValueAt(null, x, 2);
//                    break;
//                }
//            }
//        }
    }
}
