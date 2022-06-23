package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Vproductos extends JInternalFrame {
	public JTextField Tcodigo;
	public JTextField Tproducto;
	public JTextField Tdescripcion;
	public JTextField Tprecio;
	public JButton Bagregar,Beditar,Beliminar,Bsalir,Barchivo;
	public JTable Tproductos;
	public JLabel Limagen;

	
	/**
	 * Create the frame.
	 */
	public Vproductos() {
		setBounds(100, 100, 741, 379);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(62, 20, 68, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(62, 47, 68, 14);
		getContentPane().add(lblProducto);
		
		JLabel lblDescripcion = new JLabel("Imagen");
		lblDescripcion.setBounds(62, 72, 68, 14);
		getContentPane().add(lblDescripcion);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(62, 97, 68, 14);
		getContentPane().add(lblPrecio);
		
		Tcodigo = new JTextField();
		Tcodigo.setEditable(false);
		Tcodigo.setBounds(131, 17, 124, 20);
		getContentPane().add(Tcodigo);
		Tcodigo.setColumns(10);
		
		Tproducto = new JTextField();
		Tproducto.setEditable(false);
		Tproducto.setColumns(10);
		Tproducto.setBounds(131, 45, 124, 20);
		getContentPane().add(Tproducto);
		
		Tdescripcion = new JTextField();
		Tdescripcion.setEditable(false);
		Tdescripcion.setColumns(10);
		Tdescripcion.setBounds(131, 72, 124, 20);
		getContentPane().add(Tdescripcion);
		
		Tprecio = new JTextField();
		Tprecio.setEditable(false);
		Tprecio.setColumns(10);
		Tprecio.setBounds(131, 97, 124, 20);
		getContentPane().add(Tprecio);
		
		Bagregar = new JButton("Agregar");
		Bagregar.setBounds(279, 11, 146, 23);
		getContentPane().add(Bagregar);
		
		Beliminar = new JButton("Eliminar");
		Beliminar.setBounds(279, 91, 146, 23);
		getContentPane().add(Beliminar);
		
		Beditar = new JButton("Editar");
		Beditar.setBounds(279, 38, 146, 23);
		getContentPane().add(Beditar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 128, 584, 169);
		getContentPane().add(scrollPane);
		
		Tproductos = new JTable();
		Tproductos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Producto", "Descripcion", "Precio"
			}
		));
		scrollPane.setViewportView(Tproductos);
		
		 Bsalir = new JButton("Salir");
		Bsalir.setBounds(301, 308, 146, 23);
		getContentPane().add(Bsalir);
		
		 Barchivo = new JButton("Archivo");
		Barchivo.setBounds(279, 63, 146, 23);
		getContentPane().add(Barchivo);
		
		Limagen = new JLabel("New label");
		Limagen.setBounds(479, 20, 108, 94);
		getContentPane().add(Limagen);

	}
}
