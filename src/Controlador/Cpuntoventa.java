package Controlador;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Librerias.CLibreria;

import Modelo.Boton;
import Modelo.Cbasedatos;
import Modelo.Lproductos;
import Modelo.Lventa;
import Modelo.Producto;
import Modelo.ticket;

public class Cpuntoventa implements ActionListener{

	public Vista.puntoventa ventana;
	ArrayList<JButton> listabotones;
	ArrayList<Producto> listaitems;
	Lproductos listaproductos;
	String sqltodos="select * from producto";
	
	Cbasedatos bd;
	ResultSet registrosproductos;
	String fechadia;
	Lventa Lticket;
	String Nopedido;
	boolean puntodecimal ;
	
	
	public Cpuntoventa()
	{
		puntodecimal=false;
		fechadia = CLibreria.Fecha();
		if (CLibreria.Existe("Bd.accdb"))
		 {
		this.ventana = new Vista.puntoventa();
		this.ventana.setTitle("Punto de Venta Cenaduria Los Elotes Huastecos "+LocalDate.now().toString());
		 Lticket= new Lventa();
		 bd = new Cbasedatos("Bd.accdb");
		 this.cargarproductos();
		 this.iniciarpuntoventa();
		 this.agregarlistener();
		 this.Nopedido="001";
		 this.ventana.show();
			
		 }
		else
			 this.ventana.dispose();
	}
	
	public void agregarlistener()
	{
		this.ventana.Brealizarpedido.addActionListener(this);
		this.ventana.Bsalir.addActionListener(this);
		this.ventana.Bcancelarpedido.addActionListener(this);
		this.ventana.Bpagar.addActionListener(this);
		this.ventana.B0.addActionListener(this);
		this.ventana.B1.addActionListener(this);
		this.ventana.B2.addActionListener(this);
		this.ventana.B3.addActionListener(this);
		this.ventana.B4.addActionListener(this);
		this.ventana.B5.addActionListener(this);
		this.ventana.B6.addActionListener(this);
		this.ventana.B7.addActionListener(this);
		this.ventana.B8.addActionListener(this);
		this.ventana.B9.addActionListener(this);
		this.ventana.Bpunto.addActionListener(this);
		this.ventana.Blimpiar.addActionListener(this);
		this.ventana.BcancelarProducto.addActionListener(this);
	}
	
	public void iniciarpuntoventa()
	{
		this.ventana.panelteclado(false);
		this.ventana.panelventa2(false);
		this.ventana.panelventa(false);
		this.ventana.panelventa1(false);
		this.botonesproductos(false);
	}
	
	public void activarpuntoventa()
	{
		this.ventana.panelteclado(false);
		this.ventana.panelventa2(true);
		this.ventana.panelventa(false);
		this.ventana.panelventa1(false);
		this.botonesproductos(true);
		this.ventana.Tticket.setModel(this.Lticket.getTabla());
		
	}
	
	
	public ResultSet consultar_bd_productos()
	{
		  String sqlcadena= "select * from producto";
		  return bd.consultar(sqlcadena);
		  	
	}
	
	public String consultar_bd_ventas()
	{
		  String sqlcadena= "select idticket from ventas where fecha='"+this.fechadia.trim()+"' order by idticket asc";
		  ResultSet registros=bd.consultar(sqlcadena);
		  String noticket="001";
		  try {
			while (registros.next())
				  noticket=registros.getString(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			noticket="000";
		}
		  return noticket;
		  	
	}
	
	
	public String siguienteidticket(String fecha)
	{
		  String sqlcadena= "select idticket from venta where (fecha = '"+fecha.trim()+"')";
		  System.out.println(sqlcadena+"................................");
		 
		  String nidticket ="001";
			  try {
				  ResultSet registro = bd.consultar(sqlcadena);
				 while(registro.next())
					 nidticket=registro.getString(1);
				  	System.out.println(nidticket+".............");
					   nidticket=CLibreria.getIdtecketsiguiente(nidticket);
					  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  return nidticket;	
	}
	
	public void cargarproductos()
	{
		registrosproductos = this.consultar_bd_productos();
		 if (registrosproductos!=null)
			listaproductos = new Lproductos(registrosproductos);
		 else
			 listaproductos=new Lproductos();
		 if (!this.listaproductos.vacio())
			{
			 
			 listaitems = listaproductos.getProductos();
			 listabotones = new ArrayList<JButton>();
			 for( Producto info:listaitems)
		        {	Boton objetoboton = new Boton(info);
		        	listabotones.add(objetoboton);
		        }
			 for(JButton boton:listabotones)
		        { 	boton.addActionListener(this);
		        	this.ventana.Panelbotones.add(boton);
		        }
		       
			}
	}
	
	public void botonesproductos(Boolean opcion)
	{
		if (opcion)
		 for(JButton boton:listabotones)
	         	boton.setEnabled(true);
		else
			for(JButton boton:listabotones)
	         	boton.setEnabled(false);
			
	
		
	}
	
	public void actualizarventa()
	{
		this.ventana.Tticket.setModel(Lticket.getTabla());
		   this.ventana.Tsubtotal.setText(Lticket.getsubtotal());
		   this.ventana.Tiva.setText(Lticket.getiva());
		   this.ventana.Ttotak.setText(Lticket.getTotal());
	}
	
	
	public String concatena(String numero)
	{if (this.puntodecimal)
	{	numero="."+numero;
	this.puntodecimal=false;
	}
		return numero;
	}
	
	public void getcambio(String numero)
	{
		
		double pagar,total,cambio;
		String cadena=ventana.Tpago.getText();
		
		switch (numero)
		{
		case "0" :cadena=cadena+this.concatena("0");break;
		case "1" :cadena=cadena+this.concatena("1");break;
		case "2" :cadena=cadena+this.concatena("2");break;
		case "3" :cadena=cadena+this.concatena("3");break;
		case "4" :cadena=cadena+this.concatena("4");break;
		case "5" :cadena=cadena+this.concatena("5");break;
		case "6" :cadena=cadena+this.concatena("6");break;
		case "7" :cadena=cadena+this.concatena("7");break;
		case "8" :cadena=cadena+this.concatena("8");break;
		case "9" :cadena=cadena+this.concatena("9");break;
		
			
		}
		
		this.ventana.Tpago.setText(cadena);
		
		total=Double.parseDouble(this.ventana.Ttotak.getText());
		pagar=Double.parseDouble(this.ventana.Tpago.getText());
		cambio = pagar-total;
		this.ventana.Tcambio.setText(String.valueOf(cambio));
	}
	
	
	public boolean guardarticket()
	{
		boolean accion=true;
		for(String cadenasql:this.Lticket.getDatossql())	
		{System.out.println(cadenasql);
			bd.insertar(cadenasql);
		}
		
		return accion;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.ventana.Brealizarpedido)
		{
			//String datoticket=consultar_bd_ventas();
			String idticket = this.siguienteidticket(fechadia);
			this.activarpuntoventa();
			this.Nopedido=idticket;
			this.ventana.Tidticket.setText("Numero de Pedido -->"+idticket);
			this.ventana.Tidticket.setEditable(false);
		}
		else 
			if (e.getSource()==this.ventana.Bpagar)
			{
				if (ventana.Bpagar.getText().compareTo("Pagar")==0)
				{JOptionPane.showMessageDialog(ventana, "el total a pagar fue "+this.ventana.Ttotak.getText());
				this.ventana.panelteclado(true);
				this.ventana.panelventa1(true);
				this.ventana.Bpagar.setText("Liquidar");
				this.ventana.Tpago.setText("");
				}
				else {
					double pagar,total;
					total=Double.parseDouble(this.ventana.Ttotak.getText());
					pagar=Double.parseDouble(this.ventana.Tpago.getText());
					if (pagar>=total)
					{
					double cambio=pagar-total;
					this.ventana.Bpagar.setText("Pagar");
					this.guardarticket();
					this.Lticket.limpiar();
					this.ventana.Tticket.setModel(this.Lticket.getTabla());
					this.iniciarpuntoventa();	
					}
					
				}
				

			}
			else if (e.getSource()==this.ventana.B0)
			{ 	
				this.getcambio("0");
			}
			else if (e.getSource()==this.ventana.B1)
			{ 	
				this.getcambio("1");
			}else if (e.getSource()==this.ventana.B2)
			{ 	
			this.getcambio("2");
			}
			else if (e.getSource()==this.ventana.B3)
			{ 				this.getcambio("3");
			}
			else if (e.getSource()==this.ventana.B4)
			{ 	
			this.getcambio("4");
			}
			else if (e.getSource()==this.ventana.B5)
			{ 	
			this.getcambio("5");
			}else if (e.getSource()==this.ventana.B6)
			{ 	
			this.getcambio("6");
			}
			else if (e.getSource()==this.ventana.B7)
			{ 
			this.getcambio("7");
			}
			else if (e.getSource()==this.ventana.B8)
			{ 
			this.getcambio("8");
			}
			else if (e.getSource()==this.ventana.B9)
			{ 
			this.getcambio("9");
			}
			else if (e.getSource()==this.ventana.Bpunto)
			{ 	this.puntodecimal=true;
				this.ventana.Bpunto.setEnabled(false);
			}
			else 
				if (e.getSource()==this.ventana.Blimpiar)
				{ 	this.puntodecimal=false;
					this.ventana.Bpunto.setEnabled(true);
					this.ventana.Tpago.setText("0");
				}
				else
					if (e.getSource()==this.ventana.Bcancelarpedido)
					{ 	
						this.ventana.Bpagar.setText("Pagar");
						this.Lticket.limpiar();
						this.ventana.Tticket.setModel(this.Lticket.getTabla());
						this.iniciarpuntoventa();
						
					}
					else 
						if (e.getSource()==this.ventana.BcancelarProducto)
					{ 	
							int pos=this.ventana.Tticket.getSelectedRow();
							String codigo=this.ventana.Tticket.getValueAt(pos, 0).toString();
						System.out.println(codigo);
						this.Lticket.eliminararticulo(codigo);
						this.actualizarventa();
						
					} else

				if (e.getSource()==this.ventana.Bsalir)
				{
				this.ventana.dispose();
				}
				else 
		{		Object objeto = e.getSource();
		
		if ( objeto instanceof JButton)
		{
			for (Producto info: listaitems)
			{ String datoboton=objeto.toString();
			   if (info.getCodigo().compareTo(datoboton)==0)
			   {    
			   		ticket nodo = new ticket(Nopedido,fechadia,info);
			   		Lticket.insertar(nodo);
				    this.actualizarventa();
			   }
		}
				   
			}
		}
	}

}
