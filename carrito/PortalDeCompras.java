package carrito;

import carrito.model.Catalogo;
import carrito.view.CatalogoPanel;
import carrito.view.ListadoDeComprasPanel;

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

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PortalDeCompras();
    }

    private void setPaneles() {
        panelListadoDeCompras = new ListadoDeComprasPanel();

        panelCategoria1 = new CatalogoPanel(Catalogo.UNO);
        panelCategoria2 = new CatalogoPanel(Catalogo.DOS);
    }

    private void setMenus() {
        JMenuBar barra = new JMenuBar();

        JMenu carrito = new JMenu("Carrito");
        JMenuItem listadoDeCompras = new JMenuItem(LISTADO_DE_COMPRAS);
        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener(this);
        listadoDeCompras.addActionListener(this);

        carrito.add(listadoDeCompras);
        carrito.add(salir);

        JMenu catalogo = new JMenu("Catalogo");
        JMenuItem categoria1 = new JMenuItem(CATEGORIA1);
        JMenuItem categoria2 = new JMenuItem(CATEGORIA2);

        categoria1.addActionListener(this);
        categoria2.addActionListener(this);

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
        final String actionCommand = e.getActionCommand();
        if ("Acerca de...".equals(actionCommand)) {
            JOptionPane.showMessageDialog(this, "Portal de compras \nby Pablo Lucero",
                    "Acerca de Portal de compras", JOptionPane.INFORMATION_MESSAGE);
        } else if ("Salir".equals(actionCommand)) {
            setVisible(false); // oculto el JFrame
            dispose(); // Destruyo el objecto JFrame
        } else if (CATEGORIA1.equals(actionCommand)) {
            setContentPane(panelCategoria1);
            repaint();
            printAll(getGraphics());
        } else if (CATEGORIA2.equals(actionCommand)) {
            setContentPane(panelCategoria2);
            repaint();
            printAll(getGraphics());
        } else if (LISTADO_DE_COMPRAS.equals(actionCommand)) {
            setContentPane(new ListadoDeComprasPanel());
            repaint();
            printAll(getGraphics());
        }
    }
}
