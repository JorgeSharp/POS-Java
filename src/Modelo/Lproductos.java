package Modelo;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class Lproductos {
ArrayList<Producto> lista;


public Lproductos() {
	super();
	this.lista = new ArrayList<Producto>();
}
public Lproductos(ArrayList<String[]> datos) {
	super();
	this.lista = new ArrayList<Producto>();
	for(String[] info: datos)
	{
		 Producto nodo= new Producto(info[0],info[1],info[2],info[3]);
		lista.add(nodo);
	}
}

public boolean vacio()
{
if (this.lista.isEmpty())
	return true;
else return false;
}
public Lproductos(ResultSet datos) {
	super();
	this.lista = new ArrayList<Producto>();
	String codigo,producto,precio,narchivo;
	try {
	while (datos.next())
	{	
		 codigo=datos.getString("codigo");
         producto=datos.getString("producto");
         precio=datos.getString("precio"); 
         narchivo=datos.getString("narchivo");	
         Producto nodo= new Producto(codigo,producto,precio,narchivo);
 		 lista.add(nodo);
	}
	System.out.println(lista.size()+" este es el tamaño");
	}catch(SQLException e)
	{
    System.err.println(e);
	}
	
}



public int existe(String codigo)
{int enc=-1;
int pos=0;
	for(Producto info: this.lista)
	{if (info.getCodigo().compareTo(codigo.trim())==0)
		enc=pos;
	 pos++;
		}
return enc;
}

public int existe(Producto nodo)
{int enc=-1;
int pos=0;
	for(Producto info: this.lista)
	if (info.getCodigo().compareTo(nodo.getCodigo())==0)
		{enc=pos;
		pos++;
		}
return enc;
}

public  boolean insertar (Producto nodo)
{ 
	boolean exito=true;
	if (existe(nodo)==-1)
		lista.add(nodo);
	else exito =false;
return exito;

}

public void eliminar(int pos)
{
lista.remove(pos);
}

public void modificar(int pos,String precio)
{
	Producto info =lista.get(pos);
	info.setPrecio(precio);	
	lista.set(pos, info);
}

public Object[][] getDatos()
{ 	int filas=this.lista.size();
	Object[][] archivo = new Object[filas][3];
	int pos=0;
	for(Producto info: this.lista)
	{	archivo [pos][0] =  info.getCodigo();
		archivo [pos][1] =  info.getProducto();
		archivo [pos][2] =  info.getPrecio();
	pos++;
	}	
	return archivo;
}

public Object[] getObjeto()
{ 	int filas=this.lista.size();
	Object[] archivo = new Object[filas];
	int pos=0;
	for(Producto info: this.lista)
	archivo [pos] =  info;
	return archivo;
}

public Producto getProducto(int posicion)
{ 	
	return this.lista.get(posicion);
}

public ArrayList<Producto> getProductos()
{
ArrayList<Producto> temp = new ArrayList<Producto>();
for(Producto info:this.lista)
	temp.add(info);
return temp;	
}
public DefaultTableModel getTabla()
{
	String[] columnas= {"Codigo","Producto","Precio"};
	DefaultTableModel Tabla = new DefaultTableModel(this.getDatos(),columnas) ;
return Tabla;
}


public void removertodos()
{
this.lista.clear();
}

}
