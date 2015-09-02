package carrito;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PortalDeCompras extends JFrame implements ActionListener {

    public PortalDeCompras() {
        super("Portal de compras");

        JMenuBar barra = new JMenuBar();

        JMenu carrito = new JMenu("Carrito");
        JMenuItem salir = new JMenuItem("Salir");


        JMenu catalogo = new JMenu("Catalogo");



        JMenu ayuda = new JMenu("Ayuda");



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 200);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }


    public static void main(String[] args) {
        new PortalDeCompras();
    }
}
