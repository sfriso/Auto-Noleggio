package view;

import java.awt.Component;
import java.awt.Font;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.Utente;

public class ModificaClientiV {

//	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable tableModificaClienti;
	private DefaultTableModel model;
	private JButton btnSalvaModclienti;
	private JButton btnHomePageModclienti;
	private JButton btnEliminaCliente;

	
////	private Controller c;
//	/**
//	 * Launch the application.
//	 */
////	public static void main(String[] args) {
////		EventQueue.invokeLater(new Runnable() {
////			public void run() {
////				try {
////					ModificaClientiV window = new ModificaClientiV();
////					window.frame.setVisible(true);
////				} catch (Exception e) {
////					e.printStackTrace();
////				}
////			}
////		});
////	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */


	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	public ModificaClientiV(JFrame frame, ArrayList<Utente> list) {
		frame.getContentPane().removeAll();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setBounds(frame.getX(), frame.getY(), 900, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setLocation(0, 82);
		scrollPane.setSize(frame.getWidth(), 300);
		frame.getContentPane().add(scrollPane);  // server per far vedere la scroll bar se necessario
		
		tableModificaClienti = new JTable();
		Object[] row = new Object[11];
		model = new DefaultTableModel(){
			Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				@Override
				public boolean isCellEditable(int row, int column) {
					return !(column == 6);
				}				
			};
		model.addColumn("Nome");
		model.addColumn("Cognome");
		model.addColumn("Patente");
		model.addColumn("Ratio");
		model.addColumn("Email");
		model.addColumn("accountVerificato");
		model.addColumn("Username");
		model.addColumn("dataScadenzaPatente");
		model.addColumn("dataDiNascita");
		model.addColumn("numeroDiCellulare");
		model.addColumn("cartaDiCredito");
		
		DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {

		    SimpleDateFormat f = new SimpleDateFormat("MM/dd/yy");

		    public Component getTableCellRendererComponent(JTable table,
		            Object value, boolean isSelected, boolean hasFocus,
		            int row, int column) {
		        if( value instanceof Date) {
		            value = f.format(value);
		        }
		       
		        return super.getTableCellRendererComponent(table, value, isSelected,
		                hasFocus, row, column);
		    }
		};
		
		
		for(int i = 0; i < list.size(); i++)
		    {
		      row[0] = list.get(i).getNome();
		      row[1] = list.get(i).getCognome();
		      row[2] = list.get(i).getPatente();
		      row[3] = list.get(i).getRatio();
		      row[4] = list.get(i).getEmail();
		      row[5] = list.get(i).getAccountVerificato();
		      row[6] = list.get(i).getUsername();
		      row[7] = new SimpleDateFormat("dd/MM/yy").format(list.get(i).getDataScadenzaPatente());
		      row[8] = new SimpleDateFormat("dd/MM/yy").format(list.get(i).getDataDiNascita());
		      row[9] = list.get(i).getNumeroDiCellulare();
		      row[10] = list.get(i).getCartaDiCredito();
		           
		      model.addRow(row);
		    }
//		TableColumn t = tableModificaClienti.getColumnModel().getColumn(8);
//		t.setCellRenderer(new JDateChooserRenderer());
//		t.setCellEditor(new JDateChooserCellEditor());
//		tableModificaClienti.prepareEditor(new JDateChooserCellEditor(), 0, 0);
		tableModificaClienti.setModel(model);
		tableModificaClienti.getColumnModel().getColumn(7).setCellRenderer(tableCellRenderer);
		tableModificaClienti.getColumnModel().getColumn(8).setCellRenderer(tableCellRenderer);
		scrollPane.setViewportView(tableModificaClienti);
		
		JLabel lbModificaClientiModificaClienti = new JLabel("Modifica Clienti");
		lbModificaClientiModificaClienti.setHorizontalAlignment(SwingConstants.CENTER);
		lbModificaClientiModificaClienti.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbModificaClientiModificaClienti.setBounds(0, 0, frame.getWidth(), 60);
		frame.getContentPane().add(lbModificaClientiModificaClienti);
		
		btnSalvaModclienti = new JButton("Salva Modifiche");
		btnSalvaModclienti.setBounds(10, 527, 139, 23);
		frame.getContentPane().add(btnSalvaModclienti);
		
		btnEliminaCliente = new  JButton("Elimina Cliente");
		btnEliminaCliente.setBounds(200, 527, 139, 23);
		frame.getContentPane().add(btnEliminaCliente);
		
		btnHomePageModclienti = new JButton("Indietro");
		btnHomePageModclienti.setBounds(457, 527, 139, 23);
		frame.getContentPane().add(btnHomePageModclienti);
		frame.repaint();
	}
	
	public ArrayList<Utente>	getTabellaModificaCliente() throws ParseException{
		int row = 0;
		ArrayList<Utente> list = new ArrayList<Utente>();
		//private static DecimalFormat df = new DecimalFormat("0.00");
		while(row < model.getRowCount()) {	
			Utente u = new Utente( (String) model.getValueAt(row, 0), (String) model.getValueAt(row, 1), (String) model.getValueAt(row, 2),
					 Float.valueOf(String.valueOf(model.getValueAt(row, 3))), (String)model.getValueAt(row, 4),(Boolean)model.getValueAt(row, 5),
					(String)model.getValueAt(row, 6),  new SimpleDateFormat("dd/MM/yy").parse((String)model.getValueAt(row, 7)),
					new SimpleDateFormat("dd/MM/yy").parse((String)model.getValueAt(row, 8)),
					(String)model.getValueAt(row, 9),
					(String)model.getValueAt(row, 10));
			row++;
			list.add(u);
			System.out.println(u.getNome());
		}
		
		return list;
	}
	
	protected Utente getUtenteSelected() {
		Utente u = null;
		int i = tableModificaClienti.getSelectedRow();
		try {
			u = new Utente((String) model.getValueAt(i, 0),(String) model.getValueAt(i, 1),(String) model.getValueAt(i, 2), Float.valueOf(String.valueOf(model.getValueAt(i, 3))), 
					(String) model.getValueAt(i, 4),(Boolean) model.getValueAt(i, 5),(String) model.getValueAt(i, 6), new SimpleDateFormat("dd/MM/yy").parse((String) model.getValueAt(i, 7)),
					new SimpleDateFormat("dd/MM/yy").parse((String) model.getValueAt(i, 8)), (String) model.getValueAt(i, 9),(String) model.getValueAt(i, 10));
		} catch (NumberFormatException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
		
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTable getTableModificaClienti() {
		return tableModificaClienti;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public JButton getBtnSalvaModclienti() {
		return btnSalvaModclienti;
	}

	public JButton getBtnHomePageModclienti() {
		return btnHomePageModclienti;
	}

	public JButton getBtnEliminaCliente() {
		return btnEliminaCliente;
	}
	
	
}
