package Controlador;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Librerias.CLibreria;
import Modelo.Cbasedatos;
import Modelo.Conexion;
import Modelo.ConsultasProducto;
import Modelo.Lproductos;
import Modelo.Producto;

public class Cproductos implements ActionListener, KeyListener, MouseListener{

	public Vista.Vproductos ventana;
	private Toolkit toolkit;
	private Image imagen;
	Cbasedatos bd;
	String codigo,producto,precio,narchivo;
	String sqlcodigo="select * from producto where codigo=?";
	String sqltodos="select * from producto";
	Lproductos listaproductos;
	ResultSet registros;
	
	public Cproductos()
	{
	 if (CLibreria.Existe("Bd.accdb"))
	 {
		this.ventana = new Vista.Vproductos();
		this.ventana.Bagregar.addActionListener(this);
		this.ventana.Beliminar.addActionListener(this);
		this.ventana.Beditar.addActionListener(this);
		this.ventana.Bsalir.addActionListener(this);
		this.ventana.Barchivo.addActionListener(this);
		this.ventana.Tproductos.addKeyListener( this);
		this.ventana.Tproductos.addMouseListener(this);
		this.incializar();
		this.ventana.setTitle("Productos "+LocalDate.now().toString());
		this.ventana.show();
		bd = new Cbasedatos("Bd.accdb");
		this.actualizarlista(); 
		 
	 } else
		 this.ventana.dispose();
	}
	
	
	public void incializar()
	{
		
		this.ventana.Tcodigo.setEditable(false);
		this.ventana.Tdescripcion.setEditable(false);
		this.ventana.Tprecio.setEditable(false);
		this.ventana.Tproducto.setEditable(false);
		this.ventana.Bagregar.setText("Agregar");
		this.ventana.Bsalir.setText("Salir");
		this.ventana.Beditar.setText("Editar");
		
		this.ventana.Beliminar.setEnabled(true);
		this.ventana.Beditar.setEnabled(true);
		this.ventana.Barchivo.setEnabled(false);
		toolkit= Toolkit.getDefaultToolkit();
		imagen = toolkit.createImage("src\\Imagenes\\vacio.png");
		this.ventana.Limagen.setIcon(new ImageIcon(imagen.getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
		
		
	}

	public void actualizarlista()
	{
		registros = this.consultar_bd();
		 if (registros!=null)
			{listaproductos = new Lproductos(registros);
			this.ventana.Tproductos.setModel(listaproductos.getTabla());
			}
		 else
			 listaproductos=new Lproductos();
		 if (!this.listaproductos.vacio())
			{
			 int posi = 0;
			 Producto nodo = this.listaproductos.getProducto(0);
			 this.rellenarinfo(nodo);
			 this.ventana.Tproductos.setRowSelectionInterval(0, 0);
			}
	}
	
	public void agregar()
	{
		this.ventana.Tcodigo.setEditable(true);
		this.ventana.Tdescripcion.setEditable(true);
		this.ventana.Tprecio.setEditable(true);
		this.ventana.Tproducto.setEditable(true);
		
		this.ventana.Tdescripcion.setText("");	
		this.ventana.Tprecio.setText("");
		this.ventana.Tproducto.setText("");
		this.ventana.Bagregar.setText("Salvar");
		this.ventana.Bsalir.setText("Cancelar");
		this.ventana.Beliminar.setEnabled(false);
		this.ventana.Beditar.setEnabled(false);
		this.ventana.Barchivo.setEnabled(true);
		
		
		
	}
	
	public void modificar()
	{
		this.ventana.Tprecio.setEditable(true);
		this.ventana.Tdescripcion.setEditable(true);
		
		this.ventana.Beditar.setText("Salvar");
		this.ventana.Bsalir.setText("Cancelar");
		this.ventana.Beliminar.setEnabled(false);
		this.ventana.Barchivo.setEnabled(true);
		
		this.ventana.Beliminar.setEnabled(false);
		this.ventana.Bagregar.setEnabled(false);
		
		
		
	}
	

	
	public ResultSet consultar_bd()
	{
		  String sqlcadena= "select * from producto";
		  return bd.consultar(sqlcadena);
		  	
	}
	
	public String insertar_bd(Producto info)
	{
		
		String sqlcadena = "insert into producto (codigo, producto, precio,narchivo) values ('";
					sqlcadena=sqlcadena+info.getCodigo()+"','"+info.getProducto()+"','"+info.getPrecio()+"','"+info.getNarchivo()+"')";     
		return sqlcadena;
	}

	public String eliminar_bd(String codigo)
	{
		
		String sqlcadena = "delete from producto where codigo=";
					sqlcadena=sqlcadena+"'"+codigo+"'";
		return sqlcadena;
	}

	public String modificar_bd(Producto info)
	{
		
		String sqlcadena = "update producto set  precio='";
		sqlcadena=sqlcadena+info.getPrecio()+"',narchivo='"+info.getNarchivo()+"' where codigo='"+info.getCodigo()+"'";
		return sqlcadena;
	}
	 
	public void inicio()
	{
		  this.incializar();
		  this.actualizarlista();
		  int pos = 0;
			String codigo = String.valueOf(this.ventana.Tproductos.getValueAt(pos,0)).trim();
			if (!codigo.isEmpty())
			{ 
				
				int posi = this.listaproductos.existe(codigo);
				Producto nodoaux = this.listaproductos.getProducto(posi);
				this.rellenarinfo(nodoaux);
			}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.ventana.Bagregar)
		{ if (this.ventana.Bagregar.getText().compareTo("Agregar")==0)
			{this.agregar();
			this.ventana.Tcodigo.setText(obtenercodigo());
			}
		else
			{ 
			  codigo=this.ventana.Tcodigo.getText().trim();
			  producto = this.ventana.Tproducto.getText().trim();
			  precio = this.ventana.Tprecio.getText().trim();
			  narchivo = this.ventana.Tdescripcion.getText().trim();
			  Producto nodo= new Producto(codigo,producto,precio,narchivo);
			  String cadenasql="select * from producto where codigo='"+codigo+"'";
			 if (!bd.buscar(cadenasql))
			 { String sqlinsertar;
			 	sqlinsertar=this.insertar_bd(nodo);
			 	bd.insertar(sqlinsertar);}
			  else	
				  JOptionPane.showMessageDialog(ventana, "el codigo ya existe , no se pudo insertar ");					
			  this.inicio();
			  
			  
			  
			}
		
		}
		else if (e.getSource()==this.ventana.Beditar)
		{ if (this.ventana.Beditar.getText().compareTo("Editar")==0)
			{//this.modificar()
			  JOptionPane.showMessageDialog(ventana,"Modificar");
			}
			
		else
			this.incializar();
		
		}
		else
			 if (e.getSource()==this.ventana.Barchivo)
			{
				 JFileChooser fc=new JFileChooser();    
				 fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.jpg", "png");
				fc.setFileFilter(filtro);
				System.out.println(fc.getCurrentDirectory());
			
				fc.setCurrentDirectory(new File("src\\Imagenes\\"));
				    int i= fc.showOpenDialog (this.ventana); 
				   
				    if(i==JFileChooser.APPROVE_OPTION)  
				    {   this.ventana.Tdescripcion.setText(fc.getSelectedFile().getName());    	
				    Image imagen = toolkit.createImage("src\\Imagenes\\"+this.ventana.Tdescripcion.getText());
					this.ventana.Limagen.setIcon(new ImageIcon(imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
				    }   
			}
		else 
			if (e.getSource()==this.ventana.Beliminar)
			{
				int pos = this.ventana.Tproductos.getSelectedRow();
				String codigo = String.valueOf(this.ventana.Tproductos.getValueAt(pos,0)).trim();
						
				if (!codigo.isEmpty())
				{ 	
					String mensaje ="esta seguro de eliminar a "+this.ventana.Tproducto.getText();
					int resp = JOptionPane.showConfirmDialog(null, mensaje, "Alerta!", JOptionPane.YES_NO_OPTION);
					if (resp==0)
					{	String	sqleliminar=this.eliminar_bd(codigo);	
				bd.eliminar(sqleliminar);}	
				}
				this.inicio();
				
			}
		else
			if (e.getSource()==this.ventana.Bsalir)
				{
				if (this.ventana.Bsalir.getText().compareTo("Salir")==0)
				this.ventana.dispose();
				else
					this.incializar();
				}
	}


	
	public void rellenarinfo(Producto info)
	{
		this.ventana.Tcodigo.setText(info.getCodigo());
		this.ventana.Tproducto.setText(info.getProducto());
		this.ventana.Tdescripcion.setText(info.getNarchivo());
		this.ventana.Tprecio.setText(info.getPrecio());
		toolkit= Toolkit.getDefaultToolkit();
		imagen = toolkit.createImage("src\\Imagenes\\"+info.getNarchivo());
		this.ventana.Limagen.setIcon(new ImageIcon(imagen.getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public String obtenercodigo()
	{
		int tam = this.ventana.Tproductos.getRowCount();
		int pos = tam-1;
		String codigo="001";
		if (pos>=0)
			{codigo = String.valueOf(this.ventana.Tproductos.getValueAt(pos,0)).trim();
			 codigo= CLibreria.getIdtecketsiguiente(codigo);
			}
		return codigo;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int tam = this.ventana.Tproductos.getRowCount();
		int pos = this.ventana.Tproductos.getSelectedRow();
		if (e.getKeyCode()==40)
		{
		if (pos<tam-1)
			pos++;
		}
		else
			if (e.getKeyCode()==38)
			{
			if (pos>0)
				pos--;
			}
			
		String codigo = String.valueOf(this.ventana.Tproductos.getValueAt(pos,0)).trim();
		if (!codigo.isEmpty())
		{ 
			
			int posi = this.listaproductos.existe(codigo);
			Producto nodo = this.listaproductos.getProducto(posi);
			this.rellenarinfo(nodo);
			System.out.println(codigo+" ......."+pos+e.getKeyCode());
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		int pos = this.ventana.Tproductos.getSelectedRow();
		String codigo = String.valueOf(this.ventana.Tproductos.getValueAt(pos,0)).trim();
		if (!codigo.isEmpty())
		{ 
			
			int posi = this.listaproductos.existe(codigo);
			Producto nodo = this.listaproductos.getProducto(posi);
			this.rellenarinfo(nodo);
			}
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
