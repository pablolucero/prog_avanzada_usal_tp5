package ejercicio1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelesApp extends JFrame implements ActionListener{

	private static String OPCION_UNO = "Ver panel 1";
	private static String OPCION_DOS = "Ver panel 2";
	
	private JPanel panel1, panel2;
	
	private JLabel statusLabel;
	
	public PanelesApp() {
		setPaneles();
		setMenu();
		
		statusLabel = new JLabel("",JLabel.CENTER);
		add(statusLabel);
		
		setSize(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setVisible(true);
	}
	
	private void setMenu() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu = new JMenu("Mostrar");

		JMenuItem opPanel1 = new JMenuItem(OPCION_UNO);
		opPanel1.addActionListener(this);
		menu.add(opPanel1);
		
		JMenuItem opPanel2 = new JMenuItem(OPCION_DOS);
		opPanel2.addActionListener(this);
		menu.add(opPanel2);
		
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}

	private void setPaneles() {
		panel1 = new JPanel();
		panel1.add(new JLabel("Panel 1"));
		
		panel2 = new JPanel();
		panel2.add(new JLabel("Panel 2"));
	}

	public void actionPerformed(ActionEvent arg0) {
		if (OPCION_UNO.equals(arg0.getActionCommand())) {
            setContentPane(panel1);
            repaint();
            printAll(getGraphics());
		} else {
            setContentPane(panel2);
            repaint();
            printAll(getGraphics());
		}
	}

	public static void main(String[] args) {
		new PanelesApp();
	}
	
}
