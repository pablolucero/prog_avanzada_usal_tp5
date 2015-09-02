package carrito;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PortalDeCompras extends JFrame implements ActionListener {

    private static String LISTADO_DE_COMPRAS = "Listado de compras";
    private static String CATEGORIA1 = "Categoria I";
    private static String CATEGORIA2 = "Categoria II";
    private JPanel panelCategoria1, panelCategoria2, panelListadoDeCompras;


    public PortalDeCompras() {
        super("Portal de compras");

        setMenus();
        setPaneles();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PortalDeCompras();
    }

    private void setPaneles() {
        panelListadoDeCompras = new JPanel();
        panelListadoDeCompras.add(new JLabel("panel Listado De Compras"));

        panelCategoria1 = new JPanel();
        panelCategoria1.add(new JLabel("panel Categoria 1"));

        panelCategoria2 = new JPanel();
        panelCategoria2.add(new JLabel("panel Categoria 2"));
    }

    private void setMenus() {
        JMenuBar barra = new JMenuBar();

        JMenu carrito = new JMenu("Carrito");
        JMenuItem listadoDeCompras = new JMenuItem(LISTADO_DE_COMPRAS);
        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener(this);

        carrito.add(listadoDeCompras);
        carrito.add(salir);

        JMenu catalogo = new JMenu("Catalogo");
        JMenuItem categoria1 = new JMenuItem(CATEGORIA1);
        JMenuItem categoria2 = new JMenuItem(CATEGORIA2);

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
