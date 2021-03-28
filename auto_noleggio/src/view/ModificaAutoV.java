package view;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.Auto;

public class ModificaAutoV {

	private JFrame frame;
	private JTable table;
	private JButton btnIndietroModAuto;
	private JButton btnSalvaModAuto;
	private JButton btnEliminaAuto;
	private DefaultTableModel model;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ModificaAuto window = new ModificaAuto();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public ModificaAutoV() {
//		try {
//			initialize();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 * @throws ParseException 
//	 * @throws SQLException 
//	 */
	public ModificaAutoV(JFrame frame, ArrayList<Auto> list) {
//		frame = new JFrame();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().removeAll();
		frame.setVisible(true);
		frame.setBounds(0, 0, 1198, 543);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblModificaAuto = new JLabel("Modifica Auto");
		lblModificaAuto.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificaAuto.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblModificaAuto.setBounds(10, 11, 1162, 57);
		frame.getContentPane().add(lblModificaAuto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 1162, 342);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		Object[] row = new Object[15];
		model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Targa", "Marca", "Modello", "Posti", "Cilindrata", "Cavalli", "Consumi", "Prossima Revisione",
				"Prossimo Bollo", "Data Cambio Ruote", "Rinnovo Assicurazione", "Danni Carrozzeria",
				"Danni Interni", "Pulizia" , "Prezzo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class,
				String.class, String.class, String.class, String.class, String.class, String.class,
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		table.setModel(model);
		System.out.print("sono Qui!!");
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int index = 0;
		System.out.print("sono Qui!!");
		if (list != null) {
		while(index < list.size()) {
			row[0] = list.get(index).getTarga();
			row[1] =list.get(index).getMarca();
			row[2] =list.get(index).getModello();
			row[3] =list.get(index).getPosti();
			row[4] =list.get(index).getCilindrata();
			row[5] =list.get(index).getCavalli();
			row[6] =list.get(index).getConsumi();
			row[7] = new SimpleDateFormat("dd/MM/yy").format(list.get(index).getProssimaRevisione());
			row[8] = new SimpleDateFormat("dd/MM/yy").format(list.get(index).getProssimoBollo());
			row[9] = new SimpleDateFormat("dd/MM/yy").format(list.get(index).getCambioRuote());
			row[10] = new SimpleDateFormat("dd/MM/yy").format(list.get(index).getRinnovoAssicurazione());
			row[11] =list.get(index).getDanniCarrozzeria();
			row[12] =list.get(index).getDanniInterno();
			row[13] =list.get(index).getPulizia();
			row[14] =list.get(index).getPrezzo();
			model.addRow(row);
			index++;
		}
		}
		System.out.print("sono Qui!!");
		
//		table.row
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		btnIndietroModAuto = new JButton("Indietro");
		btnIndietroModAuto.setBounds(10, 462, 89, 23);
		frame.getContentPane().add(btnIndietroModAuto);
		
		btnSalvaModAuto = new JButton("Salva");
		btnSalvaModAuto.setBounds(1083, 462, 89, 23);
		frame.getContentPane().add(btnSalvaModAuto);
		
		btnEliminaAuto = new JButton("Elimina");
		btnEliminaAuto.setBounds(900, 462, 89, 23);
		frame.getContentPane().add(btnEliminaAuto);
		
		frame.repaint();
		listaAuto();
	}
	
	public DefaultTableModel getModel() {
		return model;
	}

	public JButton getBtnEliminaAuto() {
		return btnEliminaAuto;
	}

	public void setBtnEliminaAuto(JButton btnEliminaAuto) {
		this.btnEliminaAuto = btnEliminaAuto;
	}

	public void setBtnSalvaModAuto(JButton btnSalvaModAuto) {
		this.btnSalvaModAuto = btnSalvaModAuto;
	}

	public ArrayList<Auto> listaAuto() {
		ArrayList<Auto> lista = new ArrayList<Auto>();
		int row = 0;
		while(row < table.getRowCount()) {
			Auto a = null;
			try {
				a = new Auto( (String) table.getValueAt(row, 0),(String) table.getValueAt(row, 1),(String) table.getValueAt(row, 2),(String) table.getValueAt(row, 3),(String) table.getValueAt(row, 4),(String) table.getValueAt(row, 5),
						(String) table.getValueAt(row, 6),new SimpleDateFormat("dd/MM/yy").parse((String) table.getValueAt(row, 7)), new SimpleDateFormat("dd/MM/yy").parse((String) table.getValueAt(row, 8)),
						new SimpleDateFormat("dd/MM/yy").parse((String) table.getValueAt(row, 9)),
						new SimpleDateFormat("dd/MM/yy").parse((String) table.getValueAt(row, 10)) ,(String) table.getValueAt(row, 11),
						(String) table.getValueAt(row, 12),(String) table.getValueAt(row, 13), (String) table.getValueAt(row, 14));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lista.add(a);
		row++;
		}
		return lista;
	}
	
	public void addBtnIndietroModAutoListener(ActionListener a) {
		btnIndietroModAuto.addActionListener(a);
	}
	
	public void addBtnSalvaModAutoListener(ActionListener a) {
		btnSalvaModAuto.addActionListener(a);
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnIndietroModAuto() {
		return btnIndietroModAuto;
	}

	public JButton getBtnSalvaModAuto() {
		return btnSalvaModAuto;
	}
	
}

