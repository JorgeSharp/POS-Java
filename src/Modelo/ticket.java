package Modelo;


public class ticket  extends Producto{
	String idticket ;
	String fecha;
	
	public ticket( String idticket, String fecha ,Producto info) {
		super(info.getCodigo(), info.getProducto(), info.getPrecio(), info.getNarchivo());
		this.idticket = idticket;
		this.fecha = fecha;
	}
	public String getIdticket() {
		return idticket;
	}
	public void setIdticket(String idticket) {
		this.idticket = idticket;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	

}
