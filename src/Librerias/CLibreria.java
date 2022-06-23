package Librerias;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CLibreria {

	public static String Fecha()
	{
		  Date fecha = new Date(); 
	        SimpleDateFormat formatodia = new SimpleDateFormat("dd-MM-yyyy"); 
	        return formatodia.format(fecha);

	}

	
	public static boolean registrovacio(ResultSet registros)
	{
		ResultSet aux=registros;
		int filas=0;
		try {
			while(aux.next())
				filas++;
			aux.first();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		if (filas==0)
			return true;
		else
			return false;
		
	}
	
	public static String ultimoid(ResultSet registros)
	{
		String id=null;
		try {
			while(registros.next())
				id=registros.getString(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return id;
		
	}
	
	
	static public boolean Existe(String nombrearchivo)
	{ boolean enc;
	    enc=false;
	         nombrearchivo=nombrearchivo;
	    File archivo = new File(nombrearchivo);
	    if (archivo.exists()) 
	        enc=true;   
	    else
	        enc=false;
	    return enc;
	}
	
	
	public static String getIdtecketsiguiente(String idticket)
	{String idticketnext="";
		int num= Integer.parseInt(idticket)+1;
			if (num<10)
				idticketnext= "00"+String.valueOf(num).trim();
			else
			if ((num>9)&&(num<100))
				idticketnext= "0"+String.valueOf(num).trim();
			else
				idticketnext= String.valueOf(num).trim();
	return idticketnext;
	}
	
	
}
