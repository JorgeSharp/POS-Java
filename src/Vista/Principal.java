package Vista;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.CardLayout;
import java.awt.Color;

public class Principal  {

	public JFrame frame;
	public JDesktopPane desktopPane;
	private JMenuBar menuBar;
	private JMenu Menuventa,MenuConfiguracion,mnNewMenu_2;
	public JMenuItem Mventas ,Mproductos,Msalir,Mreportes;
	
	
	public Principal() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 839, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		frame.getContentPane().add(desktopPane, "name_81935578795300");
		 menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		 Menuventa = new JMenu("Ventas");
		 Menuventa.setMnemonic('P');
		menuBar.add(Menuventa);
		 Mventas = new JMenuItem("Punto de Venta");
		Menuventa.add(Mventas);
		
		 Mreportes = new JMenuItem("Reporte de Venta");
		Menuventa.add(Mreportes);
		 MenuConfiguracion = new JMenu("Configuracion");
		 MenuConfiguracion.setMnemonic('A');
		menuBar.add(MenuConfiguracion);
		Mproductos = new JMenuItem("Productos");
		MenuConfiguracion.add(Mproductos);
		mnNewMenu_2 = new JMenu("Salida");
		menuBar.add(mnNewMenu_2);
		 Msalir = new JMenuItem("Salir");
		 mnNewMenu_2.add(Msalir);
	}
}
