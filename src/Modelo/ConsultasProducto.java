
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConsultasProducto extends Conexion {
    
    public ConsultasProducto(String narchivo) {
		super(narchivo);
		// TODO Auto-generated constructor stub
	}

    
    
	
    
    /*
    // =========== METODO MODIFICAR
    public boolean modificar (Producto p){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "update producto set  precio=?, narchivo=? where codigo=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getPrecio());
            ps.setString(2, p.getNarchivo());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
    } //------------ FIN MODIFICAR 
    
    /*        // =========== METODO ELIMINAR
    public boolean eliminar (Producto p){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "delete from producto where codigo=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getCodigo());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
    } //------------ FIN eliminar 
    */
    
                // =========== METODO BUSCAR
    public boolean buscar (Producto p){
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = "select * from producto where codigo=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getCodigo());
            rs = ps.executeQuery();
            if(rs.next()){
                p.setCodigo(rs.getString("codigo"));
                p.setProducto(rs.getString("producto"));
                p.setPrecio(rs.getString("precio")); 
                p.setNarchivo(rs.getString("narchivo"));
                return true;
            }
            return false;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
    } //------------ FIN BUSCAR
    
}
