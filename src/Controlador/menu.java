package Controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class menu implements ActionListener {
	
	public Vista.Principal ventana;
	JInternalFrame ventanahijo;
	DefaultTableModel tabladatos; 

	
	
	public menu()
	{ // se instancia el objeto ventana 
		this.ventana = new Vista.Principal();
		this.ventana.Mventas.addActionListener(this);
		this.ventana.Mreportes.addActionListener(this);
		this.ventana.Mproductos.addActionListener(this);
		this.ventana.Msalir.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.ventana.Mventas)
		{ 
			Cpuntoventa ventanahijo = new Cpuntoventa();
			this.ventana.desktopPane.add(ventanahijo.ventana);
						
		}
		else 
			if(e.getSource() == this.ventana.Mreportes)
		{ 
			JOptionPane.showMessageDialog(this.ventana.frame,"Reportes del sistema");
		}
		else 
			if(e.getSource()==this.ventana.Mproductos)
			{
				Cproductos ventanahijo = new Cproductos();
				this.ventana.desktopPane.add(ventanahijo.ventana);
				
			} 				else  
					if(e.getSource()==this.ventana.Msalir)
						this.ventana.frame.dispose();
	}

}
