package view;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.Utente;

public class ModificaProfiloUtenteV {

	private JFrame frame;
	private JTable table;
	private JPasswordField vecchiaPsw;
	private JPasswordField nuovaPsw;
	private JPasswordField ripetiPsw;
	private JButton btnSalva;
	private JButton btnCambiaPsw;
	private JLabel lblMessaggio;
	private JButton btnIndietro;
	private JButton btnCancellaProf;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ModificaProfiloUtenteV window = new ModificaProfiloUtenteV();
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
//	public ModificaProfiloUtenteV() {
//		initialize(frame, (Utente) new Object());
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
	public ModificaProfiloUtenteV(JFrame frame, Utente u) {
//		frame = new JFrame();
		frame.getContentPane().removeAll();
		frame.setResizable(false);
		frame.setBounds(frame.getX(), frame.getY(), 1016, 418);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 110, 980, 61);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Cognome", "Patente", "Ratio", "email" , "AccountVerificato", "Username", "Data Scadenza Patente", "Data Di Nascita", "Numero di Cell", "Carta Di Credito"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, Object.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, true, false, true, false, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		System.out.print("sono Qui!!");
		Object[] row = new Object[11];
		row[0] = u.getNome();
		row[1] = u.getCognome();
		row[2] = u.getPatente();
		row[3] = u.getRatio();
		row[4] = u.getEmail();
		row[5] = u.getAccountVerificato();
		row[6] = u.getUsername();
		row[7] = new SimpleDateFormat("dd/MM/yy").format(u.getDataScadenzaPatente());
		row[8] = new SimpleDateFormat("dd/MM/yy").format(u.getDataDiNascita());
		row[9] = u.getNumeroDiCellulare();
		row[10] = u.getCartaDiCredito();
		model.addRow(row);;
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Modifica Profilo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 980, 41);
		frame.getContentPane().add(lblNewLabel);
		
		btnSalva = new JButton("Salva");
		btnSalva.setBounds(443, 192, 89, 23);
		frame.getContentPane().add(btnSalva);
		
		JLabel lblNewLabel_1 = new JLabel("Modifica Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 221, 631, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Inserisci vecchia password");
		lblNewLabel_2.setBounds(10, 263, 157, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nuova Password");
		lblNewLabel_3.setBounds(177, 263, 118, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ripeti Password");
		lblNewLabel_3_1.setBounds(341, 263, 118, 14);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		vecchiaPsw = new JPasswordField();
		vecchiaPsw.setBounds(10, 288, 118, 20);
		frame.getContentPane().add(vecchiaPsw);
		
		nuovaPsw = new JPasswordField();
		nuovaPsw.setBounds(177, 288, 118, 20);
		frame.getContentPane().add(nuovaPsw);
		
		ripetiPsw = new JPasswordField();
		ripetiPsw.setBounds(341, 288, 118, 20);
		frame.getContentPane().add(ripetiPsw);
		
		btnCambiaPsw = new JButton("Cambia Password");
		btnCambiaPsw.setBounds(509, 263, 127, 23);
		frame.getContentPane().add(btnCambiaPsw);
		
		lblMessaggio = new JLabel("");
		lblMessaggio.setBounds(57, 335, 434, 14);
		frame.getContentPane().add(lblMessaggio);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.setBounds(797, 259, 89, 23);
		frame.getContentPane().add(btnIndietro);
		
		btnCancellaProf = new JButton("Cancella Profilo");
		btnCancellaProf.setBounds(797, 289, 89, 23);
		frame.getContentPane().add(btnCancellaProf);
		frame.getContentPane().repaint();
	}
	
	public void setLblMessaggio(String lblMessaggio) {
		this.lblMessaggio.setText(lblMessaggio);
	}

	public void addBtnSalvaListener(ActionListener a) {
		btnSalva.addActionListener(a);
	}
	
	public void addBtnCambiaPswListener(ActionListener a) {
		btnCambiaPsw.addActionListener(a);
	}
	
	public void addBtnIndietroListener(ActionListener a) {
		btnIndietro.addActionListener(a);
	}
	
	public void addBtnCancellaProf(ActionListener a) {
		btnCancellaProf.addActionListener(a);
	}

	
	
	public Utente ritornaCliente() {
		try {
			return new Utente( (String) table.getValueAt(0, 0), (String) table.getValueAt(0, 1), (String) table.getValueAt(0, 2), Float.valueOf(String.valueOf(table.getValueAt(0, 3))), 
					(String) table.getValueAt(0, 4), Boolean.valueOf(String.valueOf(table.getValueAt(0, 5))), (String) table.getValueAt(0, 6), new SimpleDateFormat("dd/MM/yy").parse( (String) table.getValueAt(0, 7)), 
					new SimpleDateFormat("dd/MM/yy").parse( (String) table.getValueAt(0, 8)), (String) table.getValueAt(0, 9), (String) table.getValueAt(0, 10));
		} catch (NumberFormatException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getVecchiaPsw() {
		return new String(vecchiaPsw.getPassword());
	}

	public String getNuovaPsw() {
		return new String(nuovaPsw.getPassword());
	}

	public String getRipetiPsw() {
		return new String(ripetiPsw.getPassword());
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnSalva() {
		return btnSalva;
	}

	public JButton getBtnCambiaPsw() {
		return btnCambiaPsw;
	}

	public JLabel getLblMessaggio() {
		return lblMessaggio;
	}

	public JButton getBtnIndietro() {
		return btnIndietro;
	}

	public JButton getBtnCancellaProf() {
		return btnCancellaProf;
	}
}
