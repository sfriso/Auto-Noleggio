package view;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.Auto;

public class RicercaNoleggioV {

	private JFrame frame;
	private JTextField textUsername;
	private JTextField textPatente;
	private JTable table;
	private JComboBox comboBox;
	private JButton btnNoleggia;
	private JButton btnIndietro;
	private JButton btnPreventivo;
	private JLabel lblData;
	private JLabel lblprezzo;
	private JTable table_1;
	private DefaultTableModel modello;

	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RicercaNoleggio window = new RicercaNoleggio();
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
//	public RicercaNoleggio() {
////		initialize();
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	public RicercaNoleggioV(JFrame frame, ArrayList<Auto> list, ArrayList<Auto> nonList, String dataInizio, String dataFine, String luogo) {
//		frame = new JFrame();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().removeAll();
		frame.setBounds(100, 100, 1078, 584);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Noleggia Auto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(10, 11, 1044, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 113, 740, 241);
		frame.getContentPane().add(scrollPane);
		
		
		DefaultTableModel dataModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Targa", "Data Inizio", "Data Fine", "Marca", "Modello", "Posti", "Cilindrata", "Cavalli", "Consumi", "Prezzo al giorno", "Luogo"
			}
		){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		Object[] row = new Object[11];
		for(int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getTarga();
			row[1] = dataInizio;
			row[2] = dataFine;
			row[3] = list.get(i).getMarca();
			row[4] = list.get(i).getModello();
			row[5] = list.get(i).getPosti();
			row[6] = list.get(i).getCilindrata();
			row[7] = list.get(i).getCavalli();
			row[8] = list.get(i).getConsumi();
			row[9] = list.get(i).getPrezzo();
			row[10] = luogo;
			dataModel.addRow(row);
		}
		table.setModel(dataModel);
		JLabel lblNewLabel_1 = new JLabel("Seleziona Auto");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 64, 740, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		textUsername = new JTextField();
		textUsername.setBounds(760, 169, 86, 20);
		frame.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		textPatente = new JTextField();
		textPatente.setBounds(905, 169, 86, 20);
		frame.getContentPane().add(textPatente);
		textPatente.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Assicurazione Normale", "Assicurazione Casco"}));
		comboBox.setBounds(760, 200, 231, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(760, 144, 86, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Patente");
		lblNewLabel_3.setBounds(905, 144, 83, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Prezzo Preventivo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(760, 233, 228, 34);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblprezzo = new JLabel("00.00 €");
		lblprezzo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblprezzo.setBounds(760, 278, 231, 14);
		frame.getContentPane().add(lblprezzo);
		
		btnNoleggia = new JButton("Noleggia");
		btnNoleggia.setBounds(760, 331, 89, 23);
		frame.getContentPane().add(btnNoleggia);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.setBounds(866, 331, 89, 23);
		frame.getContentPane().add(btnIndietro);
		
		btnPreventivo = new JButton("Preventivo");
		btnPreventivo.setBounds(965, 331, 89, 23);
		frame.getContentPane().add(btnPreventivo);
		
		JLabel lblNewLabel_5 = new JLabel("Auto Non Disponibili");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 365, 1044, 20);
		frame.getContentPane().add(lblNewLabel_5);
		
		table_1 = new JTable();
		table_1.setBounds(179, 468, 1, 1);
		table_1.setFillsViewportHeight(true);
		modello = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Targa", "Data Inizio", "Data Fine", "Marca", "Modello", "Posti", "Cilindrata", "Cavalli", "Consumi", "Prezzo al giorno"
				}
			){
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
		};
		row = null;
		row = new Object[10];
//		System.out.println(nonList.get(0).getTarga());
		for(int i = 0; i < nonList.size(); i++) {
			row[0] = nonList.get(i).getTarga();
			row[1] = dataInizio;
			row[2] = dataFine;
			row[3] = nonList.get(i).getMarca();
			row[4] = nonList.get(i).getModello();
			row[5] = nonList.get(i).getPosti();
			row[6] = nonList.get(i).getCilindrata();
			row[7] = nonList.get(i).getCavalli();
			row[8] = nonList.get(i).getConsumi();
			row[9] = nonList.get(i).getPrezzo();
			modello.addRow(row);
		}
		row = null;
		
		table_1.setModel(modello);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 396, 1044, 138);
		scrollPane_1.setViewportView(table_1);
		frame.getContentPane().add(scrollPane_1);

		frame.getContentPane().repaint();
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTextUsername() {
		return textUsername;
	}

	public void setTextUsername(JTextField textUsername) {
		this.textUsername = textUsername;
	}

	public JTextField getTextPatente() {
		return textPatente;
	}

	public void setTextPatente(JTextField textPatente) {
		this.textPatente = textPatente;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JButton getBtnNoleggia() {
		return btnNoleggia;
	}

	public void setBtnNoleggia(JButton btnNoleggia) {
		this.btnNoleggia = btnNoleggia;
	}

	public JButton getBtnIndietro() {
		return btnIndietro;
	}

	public void setBtnIndietro(JButton btnIndietro) {
		this.btnIndietro = btnIndietro;
	}

	public JButton getBtnPreventivo() {
		return btnPreventivo;
	}

	public JLabel getLblData() {
		return lblData;
	}


	public JLabel getLblprezzo() {
		return lblprezzo;
	}

	public void setLblprezzo(String string) {
		this.lblprezzo.setText(string + " €");
	}

	public void setBtnPreventivo(JButton btnPreventivo) {
		this.btnPreventivo = btnPreventivo;
	}

	public void addBtnNoleggiaListener(ActionListener a){
		btnNoleggia.addActionListener(a);
	}
	
	public void addBtnIndietroListener(ActionListener a) {
		btnIndietro.addActionListener(a);
	}
	public void addBtnPreventivo(ActionListener a) {
		btnPreventivo.addActionListener(a);
	}
}
