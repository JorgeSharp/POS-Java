package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.CardLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class puntoventa extends JInternalFrame {

	public JPanel Panelprincipal,PanelTeclado,Panelbotones, panelinferior,panelventa,panelventa_1,panelventa_2,panelinferiorvacio,panelticket;
	public JTextField Tsubtotal,Tiva,Ttotak,Tpago,Tcambio;
	public JButton B1,B2,B3,B4,B5,B6,B7,B8,B9,B0;
	public JButton Blimpiar,Bpunto;
	public JButton Bsalir,Brealizarpedido,Bcancelarpedido,Bpagar;
	public JSpinner Tipopago;
	public List<JButton> listaBotones;
	public JTextField Tidticket;

	public JTable Tticket;
	public JButton BcancelarProducto;
	

	public puntoventa() {
		
		 listaBotones= new ArrayList<>();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1107, 540);
		Panelprincipal = new JPanel();
		Panelprincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panelprincipal);
	    GridBagLayout gbl_Panelprincipal = new GridBagLayout();
	    gbl_Panelprincipal.columnWidths = new int[]{223, 350, 289, 0};
	    gbl_Panelprincipal.rowHeights = new int[]{308, 0, 0, 0};
	    gbl_Panelprincipal.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
	    gbl_Panelprincipal.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
	    Panelprincipal.setLayout(gbl_Panelprincipal);
	    
	    PanelTeclado = new JPanel();
	    PanelTeclado.setLayout(null);
	    GridBagConstraints gbc_PanelTeclado = new GridBagConstraints();
	    gbc_PanelTeclado.fill = GridBagConstraints.BOTH;
	    gbc_PanelTeclado.insets = new Insets(0, 0, 5, 5);
	    gbc_PanelTeclado.gridx = 0;
	    gbc_PanelTeclado.gridy = 0;
	    Panelprincipal.add(PanelTeclado, gbc_PanelTeclado);
	    
	    B7 = new JButton("7");
	    B7.setBounds(10, 107, 45, 23);
	    PanelTeclado.add(B7);
	    
	    B8 = new JButton("8");
	    B8.setBounds(83, 107, 45, 23);
	    PanelTeclado.add(B8);
	    
	    B9 = new JButton("9");
	    B9.setBounds(155, 107, 45, 23);
	    PanelTeclado.add(B9);
	    
	    B4 = new JButton("4");
	    B4.setBounds(10, 141, 45, 23);
	    PanelTeclado.add(B4);
	    
	    B5 = new JButton("5");
	    B5.setBounds(83, 141, 45, 23);
	    PanelTeclado.add(B5);
	    
	    B6 = new JButton("6");
	    B6.setBounds(155, 141,45, 23);
	    PanelTeclado.add(B6);
	    
	    B3 = new JButton("3");
	    B3.setBounds(10, 175, 45, 23);
	    PanelTeclado.add(B3);
	    
	    B2 = new JButton("2");
	    B2.setBounds(83, 175, 45, 23);
	    PanelTeclado.add(B2);
	    
	    B1 = new JButton("1");
	    B1.setBounds(155, 175, 45, 23);
	    PanelTeclado.add(B1);
	    
	    B0 = new JButton("0");
	    B0.setBounds(155, 201, 45, 23);
	    PanelTeclado.add(B0);
	    
	    Blimpiar = new JButton("Limpiar");
	    Blimpiar.setBounds(10, 201, 101, 23);
	    PanelTeclado.add(Blimpiar);
	    
	     Bpunto = new JButton(".");
	    Bpunto.setBounds(20, 235, 183, 23);
	    PanelTeclado.add(Bpunto);
	    
	    panelticket = new JPanel();
	    GridBagConstraints gbc_panel = new GridBagConstraints();
	    gbc_panel.anchor = GridBagConstraints.WEST;
	    gbc_panel.insets = new Insets(0, 0, 5, 5);
	    gbc_panel.fill = GridBagConstraints.VERTICAL;
	    gbc_panel.gridx = 1;
	    gbc_panel.gridy = 0;
	    Panelprincipal.add(panelticket, gbc_panel);
	    GridBagLayout gbl_panelticket = new GridBagLayout();
	    gbl_panelticket.columnWidths = new int[]{342, 0};
	    gbl_panelticket.rowHeights = new int[]{41, 41, 0};
	    gbl_panelticket.columnWeights = new double[]{0.0, Double.MIN_VALUE};
	    gbl_panelticket.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
	    panelticket.setLayout(gbl_panelticket);
	    
	    Tidticket = new JTextField();
	    GridBagConstraints gbc_textField = new GridBagConstraints();
	    gbc_textField.fill = GridBagConstraints.BOTH;
	    gbc_textField.insets = new Insets(0, 0, 5, 0);
	    gbc_textField.gridx = 0;
	    gbc_textField.gridy = 0;
	    panelticket.add(Tidticket, gbc_textField);
	    Tidticket.setColumns(10);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    GridBagConstraints gbc_scrollPane = new GridBagConstraints();
	    gbc_scrollPane.fill = GridBagConstraints.BOTH;
	    gbc_scrollPane.gridx = 0;
	    gbc_scrollPane.gridy = 1;
	    panelticket.add(scrollPane, gbc_scrollPane);
	    
	    Tticket = new JTable();
	    scrollPane.setViewportView(Tticket);
	    
	    JScrollPane PanelProductos = new JScrollPane();
	    PanelProductos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    PanelProductos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    GridBagConstraints gbc_PanelProductos = new GridBagConstraints();
	    gbc_PanelProductos.fill = GridBagConstraints.BOTH;
	    gbc_PanelProductos.insets = new Insets(0, 0, 5, 5);
	    gbc_PanelProductos.gridx = 2;
	    gbc_PanelProductos.gridy = 0;
	    Panelprincipal.add(PanelProductos, gbc_PanelProductos);
	    
	    Panelbotones = new JPanel();
	    PanelProductos.setViewportView(Panelbotones);
	    Panelbotones.setLayout(new GridLayout(0, 2, 0, 0));
	   
	    panelinferior = new JPanel();
	    GridBagConstraints gbc_panelinferior = new GridBagConstraints();
	    gbc_panelinferior.gridwidth = 3;
	    gbc_panelinferior.gridheight = 2;
	    gbc_panelinferior.insets = new Insets(0, 0, 0, 5);
	    gbc_panelinferior.fill = GridBagConstraints.BOTH;
	    gbc_panelinferior.gridx = 0;
	    gbc_panelinferior.gridy = 1;
	    Panelprincipal.add(panelinferior, gbc_panelinferior);
	    panelinferior.setLayout(new GridLayout(0, 3, 0, 0));
	    
	     panelventa = new JPanel();
	    panelventa.setBorder(new LineBorder(new Color(0, 0, 0)));
	    panelinferior.add(panelventa);
	    GridBagLayout gbl_panelventa = new GridBagLayout();
	    gbl_panelventa.columnWidths = new int[]{111, 111, 111, 0};
	    gbl_panelventa.rowHeights = new int[] {42, 42, 42, 42};
	    gbl_panelventa.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
	    gbl_panelventa.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
	    panelventa.setLayout(gbl_panelventa);
	    
	    JLabel lblNewLabel_1 = new JLabel("Sub Total");
	    GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
	    gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
	    gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
	    gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
	    gbc_lblNewLabel_1.gridx = 0;
	    gbc_lblNewLabel_1.gridy = 0;
	    panelventa.add(lblNewLabel_1, gbc_lblNewLabel_1);
	    
	    Tsubtotal = new JTextField();
	    Tsubtotal.setEditable(false);
	    GridBagConstraints gbc_Tsubtotal = new GridBagConstraints();
	    gbc_Tsubtotal.gridwidth = 2;
	    gbc_Tsubtotal.fill = GridBagConstraints.BOTH;
	    gbc_Tsubtotal.insets = new Insets(0, 0, 5, 5);
	    gbc_Tsubtotal.gridx = 1;
	    gbc_Tsubtotal.gridy = 0;
	    panelventa.add(Tsubtotal, gbc_Tsubtotal);
	    Tsubtotal.setColumns(10);
	    
	    JLabel lblNewLabel_2 = new JLabel("IVA");
	    GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
	    gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
	    gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
	    gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
	    gbc_lblNewLabel_2.gridx = 0;
	    gbc_lblNewLabel_2.gridy = 1;
	    panelventa.add(lblNewLabel_2, gbc_lblNewLabel_2);
	    
	    Tiva = new JTextField();
	    Tiva.setEditable(false);
	    GridBagConstraints gbc_Tiva = new GridBagConstraints();
	    gbc_Tiva.gridwidth = 2;
	    gbc_Tiva.fill = GridBagConstraints.BOTH;
	    gbc_Tiva.insets = new Insets(0, 0, 5, 5);
	    gbc_Tiva.gridx = 1;
	    gbc_Tiva.gridy = 1;
	    panelventa.add(Tiva, gbc_Tiva);
	    Tiva.setColumns(10);
	    
	    JLabel lblNewLabel_3 = new JLabel("Total");
	    GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
	    gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
	    gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
	    gbc_lblNewLabel_3.gridx = 0;
	    gbc_lblNewLabel_3.gridy = 2;
	    panelventa.add(lblNewLabel_3, gbc_lblNewLabel_3);
	    
	    Ttotak = new JTextField();
	    Ttotak.setEditable(false);
	    GridBagConstraints gbc_Ttotak = new GridBagConstraints();
	    gbc_Ttotak.gridwidth = 2;
	    gbc_Ttotak.insets = new Insets(0, 0, 0, 5);
	    gbc_Ttotak.fill = GridBagConstraints.BOTH;
	    gbc_Ttotak.gridx = 1;
	    gbc_Ttotak.gridy = 2;
	    panelventa.add(Ttotak, gbc_Ttotak);
	    Ttotak.setColumns(10);
	    
	    
	    
	   panelventa_1 = new JPanel();
	    panelventa_1.setBorder(new LineBorder(new Color(0, 0, 0)));
	    panelinferior.add(panelventa_1);
	    
	    GridBagLayout gbl_panelventa_1 = new GridBagLayout();
	    gbl_panelventa_1.columnWidths = new int[]{111, 111, 111, 0};
	    gbl_panelventa_1.rowHeights = new int[]{42, 42, 42, 0};
	    gbl_panelventa_1.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
	    gbl_panelventa_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
	    panelventa_1.setLayout(gbl_panelventa_1);
	    
	    JLabel lblNewLabel_1_1 = new JLabel("Forma de Pago");
	    GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
	    gbc_lblNewLabel_1_1.fill = GridBagConstraints.VERTICAL;
	    gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
	    gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
	    gbc_lblNewLabel_1_1.gridx = 0;
	    gbc_lblNewLabel_1_1.gridy = 0;
	    panelventa_1.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
	    
	     Tipopago = new JSpinner();
	    Tipopago.setModel(new SpinnerListModel(new String[] {"Efectivo", "Tarjeta Debito", "Tarjeta de Credito"}));
	    GridBagConstraints gbc_Tipopago = new GridBagConstraints();
	    gbc_Tipopago.fill = GridBagConstraints.BOTH;
	    gbc_Tipopago.gridwidth = 2;
	    gbc_Tipopago.insets = new Insets(0, 0, 5, 5);
	    gbc_Tipopago.gridx = 1;
	    gbc_Tipopago.gridy = 0;
	    panelventa_1.add(Tipopago, gbc_Tipopago);
	    
	    JLabel lblNewLabel_2_1 = new JLabel("Pago");
	    GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
	    gbc_lblNewLabel_2_1.fill = GridBagConstraints.VERTICAL;
	    gbc_lblNewLabel_2_1.anchor = GridBagConstraints.EAST;
	    gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 5);
	    gbc_lblNewLabel_2_1.gridx = 0;
	    gbc_lblNewLabel_2_1.gridy = 1;
	    panelventa_1.add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);
	    
	    Tpago = new JTextField();
	    Tpago.setEditable(false);
	    Tpago.setColumns(10);
	    GridBagConstraints gbc_Tpago = new GridBagConstraints();
	    gbc_Tpago.fill = GridBagConstraints.BOTH;
	    gbc_Tpago.gridwidth = 2;
	    gbc_Tpago.insets = new Insets(0, 0, 5, 0);
	    gbc_Tpago.gridx = 1;
	    gbc_Tpago.gridy = 1;
	    panelventa_1.add(Tpago, gbc_Tpago);
	    
	    JLabel lblNewLabel_3_1 = new JLabel("Cambio");
	    GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
	    gbc_lblNewLabel_3_1.anchor = GridBagConstraints.EAST;
	    gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 0, 5);
	    gbc_lblNewLabel_3_1.gridx = 0;
	    gbc_lblNewLabel_3_1.gridy = 2;
	    panelventa_1.add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);
	    
	    Tcambio = new JTextField();
	    Tcambio.setEditable(false);
	    Tcambio.setColumns(10);
	    GridBagConstraints gbc_Tcambio = new GridBagConstraints();
	    gbc_Tcambio.fill = GridBagConstraints.BOTH;
	    gbc_Tcambio.gridwidth = 2;
	    gbc_Tcambio.gridx = 1;
	    gbc_Tcambio.gridy = 2;
	    panelventa_1.add(Tcambio, gbc_Tcambio);
	    

	    
	     panelventa_2 = new JPanel();
	    panelventa_2.setBorder(new LineBorder(new Color(0, 0, 0)));
	    panelinferior.add(panelventa_2);
	    GridBagLayout gbl_panelventa_2 = new GridBagLayout();
	    gbl_panelventa_2.columnWidths = new int[]{111, 111, 111, 0};
	    gbl_panelventa_2.rowHeights = new int[] {42, 42, 42, 0, 0, 0, 42};
	    gbl_panelventa_2.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
	    gbl_panelventa_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	    panelventa_2.setLayout(gbl_panelventa_2);
	    
	    Bpagar = new JButton("Pagar");
	    GridBagConstraints gbc_Bpagar = new GridBagConstraints();
	    gbc_Bpagar.gridwidth = 3;
	    gbc_Bpagar.fill = GridBagConstraints.BOTH;
	    gbc_Bpagar.insets = new Insets(0, 0, 5, 0);
	    gbc_Bpagar.gridx = 0;
	    gbc_Bpagar.gridy = 0;
	    panelventa_2.add(Bpagar, gbc_Bpagar);
	    
	    
	    Bcancelarpedido = new JButton("Cancelar Pedido");
	    GridBagConstraints gbc_Bcancelarpedido = new GridBagConstraints();
	    gbc_Bcancelarpedido.fill = GridBagConstraints.BOTH;
	    gbc_Bcancelarpedido.gridwidth = 3;
	    gbc_Bcancelarpedido.insets = new Insets(0, 0, 5, 0);
	    gbc_Bcancelarpedido.gridx = 0;
	    gbc_Bcancelarpedido.gridy = 1;
	    panelventa_2.add(Bcancelarpedido, gbc_Bcancelarpedido);
	    
	    Brealizarpedido = new JButton("Realizar Pedido");
	    GridBagConstraints gbc_Brealizarpedido = new GridBagConstraints();
	    gbc_Brealizarpedido.insets = new Insets(0, 0, 5, 0);
	    gbc_Brealizarpedido.gridwidth = 3;
	    gbc_Brealizarpedido.fill = GridBagConstraints.BOTH;
	    gbc_Brealizarpedido.gridx = 0;
	    gbc_Brealizarpedido.gridy = 2;
	    panelventa_2.add(Brealizarpedido, gbc_Brealizarpedido);
	    
	    Bsalir = new JButton("Salir");
	    GridBagConstraints gbc_Bsalir = new GridBagConstraints();
	    gbc_Bsalir.insets = new Insets(0, 0, 5, 0);
	    gbc_Bsalir.gridwidth = 3;
	    gbc_Bsalir.fill = GridBagConstraints.BOTH;
	    gbc_Bsalir.gridx = 0;
	    gbc_Bsalir.gridy = 3;
	    panelventa_2.add(Bsalir, gbc_Bsalir);
	    
	    BcancelarProducto = new JButton("Cancelar Producto");
	    GridBagConstraints gbc_BcancelarProducto = new GridBagConstraints();
	    gbc_BcancelarProducto.fill = GridBagConstraints.HORIZONTAL;
	    gbc_BcancelarProducto.gridwidth = 3;
	    gbc_BcancelarProducto.insets = new Insets(0, 0, 0, 5);
	    gbc_BcancelarProducto.gridx = 0;
	    gbc_BcancelarProducto.gridy = 5;
	    panelventa_2.add(BcancelarProducto, gbc_BcancelarProducto);
	 
		
		
	     panelinferiorvacio = new JPanel();
	    GridBagConstraints gbc_panelinferiorvacio = new GridBagConstraints();
	    gbc_panelinferiorvacio.insets = new Insets(0, 0, 5, 0);
	    gbc_panelinferiorvacio.gridx = 3;
	    gbc_panelinferiorvacio.gridy = 0;
	    gbc_panelinferior.gridwidth = 3;
	    gbc_panelinferior.gridheight = 2;
	    gbc_panelinferior.insets = new Insets(0, 0, 0, 5);
	    gbc_panelinferior.fill = GridBagConstraints.BOTH;
	    gbc_panelinferior.gridx = 0;
	    gbc_panelinferior.gridy = 2;
	    Panelprincipal.add(panelinferiorvacio, gbc_panelinferiorvacio);
	}
	
	public void panelteclado(Boolean opcion)
	{
		if(opcion)
		{
		B1.setEnabled(true);
		B2.setEnabled(true);
		B3.setEnabled(true);
		B4.setEnabled(true);
		B5.setEnabled(true);
		B6.setEnabled(true);
		B7.setEnabled(true);
		B8.setEnabled(true);
		B9.setEnabled(true);
		Blimpiar.setEnabled(true);
		Bpunto.setEnabled(true);
		B0.setEnabled(true);

		}
		else
		{
			B1.setEnabled(false);
			B2.setEnabled(false);
			B3.setEnabled(false);
			B4.setEnabled(false);
			B5.setEnabled(false);
			B6.setEnabled(false);
			B7.setEnabled(false);
			B8.setEnabled(false);
			B9.setEnabled(false);
			Blimpiar.setEnabled(false);
			Bpunto.setEnabled(false);
			B0.setEnabled(false);
		}	
		
	}
	
	
	public void panelventa(Boolean opcion)
	{
		if(opcion)
		{   
		Tsubtotal.setEnabled(true);
	    Tiva.setEnabled(true);
	    Ttotak.setEnabled(true);
		}
		else
		{
			Tsubtotal.setEnabled(false);
		    Tiva.setEnabled(false);
		    Ttotak.setEnabled(false);
		    Tsubtotal.setText("0");
		    Tiva.setText("0");
		    Ttotak.setText("0");
		}	
		
	}
	
	
    public void panelventa1(Boolean opcion)
	{
    		if(opcion)
		{  Tipopago.setEnabled(true);
			Tpago.setText("");
	       Tpago.setEnabled(true);
	       Tcambio.setEnabled(true);
	       	Tcambio.setText("");
			
		}
		else
		{
			Tipopago.setEnabled(false);
			Tpago.setText("0");
	       Tpago.setEnabled(false);
	       Tcambio.setEnabled(false);
	       	Tcambio.setText("0");
					
		}	
		
	}
	
	
	
	public void panelventa2(Boolean opcion)
	{
		if(opcion)
		{   	Bpagar.setEnabled(true);
			 	Bcancelarpedido.setEnabled(true);
			    Brealizarpedido.setEnabled(false);
			    Bsalir.setEnabled(false);
			    BcancelarProducto.setEnabled(true);
			    Tidticket.setEnabled(true);
			    Tidticket.setText("");
				this.Tticket.setEnabled(true);
		
		}
		else
		{
			Bpagar.setEnabled(false);
		 	Bcancelarpedido.setEnabled(false);
		    Brealizarpedido.setEnabled(true);
		    Bsalir.setEnabled(true);
		    Tidticket.setEnabled(false);
		    Tidticket.setText("");
		    BcancelarProducto.setEnabled(false);
		}	
		
	}
}
