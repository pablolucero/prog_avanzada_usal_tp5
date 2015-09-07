package carrito.view;

import carrito.model.ListadoComprasModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListadoDeComprasPanel extends JPanel {


    private JTable table;
    private ListadoComprasModel listadoComprasModel;
    private JLabel totalLabel;

    public ListadoDeComprasPanel() {
        super();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JLabel("Listado De Compras"));


        listadoComprasModel = new ListadoComprasModel();
        table = new JTable(listadoComprasModel);


        add(table.getTableHeader());
        add(table);

        final JButton vaciarButton = new JButton("Vaciar");

        vaciarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vaciarButtonPressed();
            }
        });

        add(vaciarButton);
        totalLabel = new JLabel("Total: $" + listadoComprasModel.sumarTotal());
        add(totalLabel);

    }

    private void vaciarButtonPressed() {
        listadoComprasModel.vaciar();
        setearTotalLabelText();
    }

    private void setearTotalLabelText() {
        totalLabel.setText("Total: $" + listadoComprasModel.sumarTotal());
    }
}
