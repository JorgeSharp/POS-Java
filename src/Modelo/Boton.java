package Modelo;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Image;
import java.awt.Toolkit;

public class Boton extends JButton {
private String idproducto;
private String nomarchivo;
private String producto;
private String precio;


public Boton(Producto info)
{
 Toolkit toolkit;
 Image imagen;
this.idproducto=info.getCodigo();
this.nomarchivo=info.getNarchivo();
this.producto=info.getProducto();
this.precio=info.getPrecio();
toolkit= Toolkit.getDefaultToolkit();
 imagen = toolkit.createImage("src\\Imagenes\\"+nomarchivo);

this.setIcon(new ImageIcon(imagen.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
this.setText(producto+"\n"+ precio);
}


@Override
public String toString() {
	return this.idproducto.trim();
}

}
