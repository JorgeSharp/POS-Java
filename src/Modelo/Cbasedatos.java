package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cbasedatos  extends Conexion{

	public Cbasedatos(String narchivo) {
		super(narchivo);
		// TODO Auto-generated constructor stub
	}

	public boolean buscar (String cadenasql){
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = cadenasql;
        Boolean existe;
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next())
                existe= true;
            else 
            	existe=false;
            
        }catch(SQLException e){
            System.err.println(e);
            existe= false;
        }
        return existe;
    } //------------ FIN BUSC
	
	public ResultSet consultar (String cadenasql){
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = cadenasql;
        Boolean existe;
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
        }catch(SQLException e){
            System.err.println(e);
        }
        return rs;
    } //------------ FIN BUSC
	
	public boolean insertar(String cadenasql)
	{
		boolean accion=true;
		PreparedStatement ps = null;
        Connection con = getConexion();
        
        try{
            ps = con.prepareStatement(cadenasql);
            ps.execute();
            accion= true;
        }catch(SQLException e){
            System.err.println(e);
            accion= false;
        }
		return accion;
	}
	

	public boolean modificar (String cadenasql){
        PreparedStatement ps = null;
        Connection con = getConexion();
        try{
            ps = con.prepareStatement(cadenasql);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
    } 
	
    
    public boolean eliminar (String cadenasql)
    {
        PreparedStatement ps = null;
        Connection con = getConexion();
        try{
            ps = con.prepareStatement(cadenasql);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
    }  
    
	
	
}
