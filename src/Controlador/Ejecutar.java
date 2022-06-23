package Controlador;

import java.awt.EventQueue;

public class Ejecutar {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu principal = new menu();
					principal.ventana.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	

	}
}
