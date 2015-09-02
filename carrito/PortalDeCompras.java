package carrito;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PortalDeCompras extends JFrame implements ActionListener {

    public PortalDeCompras() {
        super("Portal de compras");

        JMenuBar barra = new JMenuBar();

        JMenu carrito = new JMenu("Carrito");
        JMenuItem listadoDeCompras = new JMenuItem("Listado de compras");
        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener(this);

        carrito.add(listadoDeCompras);
        carrito.add(salir);

        JMenu catalogo = new JMenu("Catalogo");
        JMenuItem categoria1 = new JMenuItem("Categoria I");
        JMenuItem categoria2 = new JMenuItem("Categoria II");

        catalogo.add(categoria1);
        catalogo.add(categoria2);

        JMenu ayuda = new JMenu("Ayuda");

        JMenuItem acercaDe = new JMenuItem("Acerca de...");
        acercaDe.addActionListener(this);
        ayuda.add(acercaDe);

        barra.add(carrito);
        barra.add(catalogo);
        barra.add(ayuda);

        setJMenuBar(barra);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PortalDeCompras();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Acerca de...".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(this, "Portal de compras \nby Pablo Lucero",
                    "Acerca de Portal de compras", JOptionPane.INFORMATION_MESSAGE);
        } else if ("Salir".equals(e.getActionCommand())) {
            setVisible(false); //you can't see me!
            dispose(); //Destroy the JFrame object
        }
    }
}
