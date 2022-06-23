
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    
    private String basededatos ="jdbc:ucanaccess://";//tienda.accdb";
    private Connection con = null;
    
    public Conexion(String narchivo)
    {
    	this.basededatos=this.basededatos+narchivo;
    }
    
    public Connection getConexion(){
        try{
        	System.out.println(this.basededatos);
        	con = DriverManager.getConnection(this.basededatos);
        }catch (SQLException e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "error");
        } 
        return con;
    }
    
}
