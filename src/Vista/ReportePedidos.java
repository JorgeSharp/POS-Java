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

public class ReportePedidos extends JInternalFrame {
	public List<JButton> listaBotones;
	private JTable Tpedidos;
	private JTable Tpedido;
	

	public ReportePedidos() {
		
		 listaBotones= new ArrayList<>();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1185, 527);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 2};
		gridBagLayout.rowHeights = new int[] {0, 2};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{382, 0};
		gbl_panel_1.rowHeights = new int[]{60, 99, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton Bsalir = new JButton("New button");
		GridBagConstraints gbc_Bsalir = new GridBagConstraints();
		gbc_Bsalir.fill = GridBagConstraints.BOTH;
		gbc_Bsalir.insets = new Insets(0, 0, 5, 0);
		gbc_Bsalir.gridx = 0;
		gbc_Bsalir.gridy = 0;
		panel_1.add(Bsalir, gbc_Bsalir);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);
		
		Tpedidos = new JTable();
		scrollPane_1.setViewportView(Tpedidos);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		Tpedido = new JTable();
		scrollPane.setViewportView(Tpedido);
	}
}
