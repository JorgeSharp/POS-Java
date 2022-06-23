package Modelo;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class Lventa {
	ArrayList<ticket> listaventa;

	public Lventa() {
		super();
		this.listaventa = new ArrayList<ticket>();

	}
	
	
	public void crearticket(String fecha,String idticket,Producto nodo)
	{
		ticket nodoinfo = new ticket(fecha,idticket,nodo);
		this.listaventa.add(nodoinfo);
	}
	public void insertar(ticket nodo)
	{
		this.listaventa.add(nodo);
	}
	
	public int buscar(String codigo)
	{int pos=-1;
	int ciclo=0;
		for (ticket info:this.listaventa)
	   if (codigo.compareTo(info.getCodigo())==0)
		   pos=ciclo;
		   else ciclo++;
		return pos;
	}
	
	public void eliminararticulo(ticket nodo)
	{
		int pos=buscar(nodo.getCodigo());
		if ( pos>-1 )
			this.listaventa.remove(pos);
	}
	
	public void eliminararticulo(String codigo)
	{
		int pos=buscar(codigo);
		if ( pos>-1 )
			this.listaventa.remove(pos);
	}
	
	
	public void limpiar()
	{
		this.listaventa.clear();
	}
	
	public String tam()
	{		return String.valueOf(this.listaventa.size());
	}
	
	public String getsubtotal()
	{
		double suma=0;
		for (ticket info:this.listaventa)
			suma=suma+Double.parseDouble(info.getPrecio());
	return String.valueOf(suma);	
	}
	
	public String getiva()
	{
		double iva=Double.parseDouble(this.getsubtotal())*0.16;
	return String.valueOf(iva);	
	}
	
	public String getTotal()
	{
		return String.valueOf(  Double.parseDouble(this.getsubtotal())+Double.parseDouble(this.getiva()) );
	}
	
	public Object[][] getDatos()
	{ 	int filas=this.listaventa.size();
		Object[][] archivo = new Object[filas][3];
		int pos=0;
		for(Producto info: this.listaventa)
		{	archivo [pos][0] =  info.getCodigo();
			archivo [pos][1] =  info.getProducto();
			archivo [pos][2] =  info.getPrecio();
		pos++;
		}	
		return archivo;
	}
	
	public ArrayList<String> getDatossql()
	{ 	ArrayList<String> listasql= new ArrayList<String>();
		for(ticket info: this.listaventa)
		{
			String sqlcadena = "insert into venta (idticket,fecha,codigo,producto, precio) values ('";
			sqlcadena=sqlcadena+info.getIdticket().trim()+"','"+info.getFecha().trim();
			sqlcadena=sqlcadena+"','"+info.getCodigo().trim()+"','"+info.getProducto().trim()+"','"+info.getPrecio().trim()+"')";     
			listasql.add(sqlcadena);
		}	
		return listasql;
	}
	
	
	
	public DefaultTableModel getTabla()
	{
		String[] columnas= {"Codigo","Producto","Precio"};
		DefaultTableModel Tabla = new DefaultTableModel(this.getDatos(),columnas) ;
	return Tabla;
	}
	
}
