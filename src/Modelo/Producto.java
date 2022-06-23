package Modelo;

public class Producto {
private String codigo;
private String producto;
private String precio;
private String narchivo;

public Producto(String codigo, String producto, String precio,String narchivo) {
	super();
	this.codigo = codigo;
	this.producto = producto;
	this.precio = precio;
	this.narchivo=narchivo;
}

public String getNarchivo() {
	return narchivo;
}

public void setNarchivo(String narchivo) {
	this.narchivo = narchivo;
}

public Producto(String[] datos) {
	super();
	this.codigo = datos[0];
	this.producto = datos[1];
	this.precio = datos[2];
	this.narchivo = datos[3];
	
}

public Producto() {
	super();
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public String getProducto() {
	return producto;
}

public void setProducto(String producto) {
	this.producto = producto;
}

public String getPrecio() {
	return precio;
}

public void setPrecio(String precio) {
	this.precio = precio;
}



public String getlineaarchivo()
{
	return this.getCodigo()+","+this.getProducto()+","+this.precio+","+this.narchivo;
}

public String[] getDatosProducto()
{
	String[] datos= new String[3];
		datos[0]=this.getCodigo();
		datos[1]=this.getProducto();
		datos[2]=this.getPrecio();
	return datos;
}

public Object[] getDatos()
{
	Object[] datos= new Object[3];
		datos[0]=this.getCodigo();
		datos[1]=this.getProducto();
		datos[2]=this.getPrecio();
	return datos;
}

}
