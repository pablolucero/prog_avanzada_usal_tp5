package ejercicio3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuApp extends JFrame implements ActionListener{

	private JLabel estado;
	
	public MenuApp() {
		setMenu();
		
		estado = new JLabel("",JLabel.CENTER);
		add(estado);
		
		setSize(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setVisible(true);
	}
	
	private void setMenu() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu = new JMenu("Mostrar");
		menuBar.add(menu);
		
		JMenuItem opPanel1 = new JMenuItem("Opción 1");
		opPanel1.addActionListener(this);
		menu.add(opPanel1);
		
		JMenu subMenu = new JMenu("Otras opciones");
		menu.add(subMenu);
		
		JMenuItem opPanel2 = new JMenuItem("Opción 2");
		opPanel2.addActionListener(this);
		subMenu.add(opPanel2);
		
		JMenuItem opPanel3 = new JMenuItem("Opción 3"); 
		opPanel3.addActionListener(this);
		subMenu.add(opPanel3);
		
		setJMenuBar(menuBar);
	}

	public void actionPerformed(ActionEvent arg0) {
		estado.setText(arg0.getActionCommand() + " seleccionada");
	}

	public static void main(String[] args) {
		new MenuApp();
	}
	
}
