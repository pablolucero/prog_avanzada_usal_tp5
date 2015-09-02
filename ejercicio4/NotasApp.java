package ejercicio4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.*;

@SuppressWarnings("serial")
public class NotasApp extends JFrame implements ActionListener {

	private JTextArea texto;

	public NotasApp() {
		super("Notas");

		JMenuBar barra = new JMenuBar();

		JMenu archivo = new JMenu("Archivo");
		archivo.setMnemonic(KeyEvent.VK_A);

		JMenuItem nuevo = new JMenuItem("Nuevo");
		nuevo.setMnemonic(KeyEvent.VK_C);
		JMenuItem guardar = new JMenuItem("Guardar");
		guardar.setMnemonic(KeyEvent.VK_G);
		guardar.addActionListener(new Guardar());
		JMenuItem salir = new JMenuItem("Salir");
		salir.setMnemonic(KeyEvent.VK_S);

		archivo.add(nuevo);
		archivo.add(guardar);
		archivo.add(salir);

		JMenu ayuda = new JMenu("Ayuda");
		ayuda.setMnemonic(KeyEvent.VK_Y);

		JMenuItem acercaDe = new JMenuItem("Acerca de...");
		acercaDe.setMnemonic(KeyEvent.VK_D);
		acercaDe.addActionListener(this);

		ayuda.add(acercaDe);

		barra.add(archivo);
		barra.add(ayuda);
		setJMenuBar(barra);

		texto = new JTextArea();
		add(texto);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new NotasApp();
	}

	public void actionPerformed(ActionEvent e) {
		if ("Acerca de...".equals(e.getActionCommand())) {
			JOptionPane.showMessageDialog(this, "Programa de notas",
					"Acerca de Notas", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	class Guardar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser c = new JFileChooser();
			// Demonstrate "Open" dialog:
			int rVal = c.showSaveDialog(NotasApp.this);
			if (rVal == JFileChooser.APPROVE_OPTION) {
				guardarArchivo(c.getCurrentDirectory().toString() + "\\"
						+ c.getSelectedFile().getName());
			}
		}

		public void guardarArchivo(String nombre) {
			FileWriter fichero = null;
			PrintWriter pw = null;
			try {
				fichero = new FileWriter(new File(nombre));
				pw = new PrintWriter(fichero);

				pw.println(texto.getText());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (null != fichero)
						fichero.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
}
