package view;

import java.awt.Component;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.Auto;

public class RicercaNoloNonRegistratoV {

	private JFrame frame;
	private JTable table;
	private Component list;
	private JComboBox comboBox;
	private JLabel lblprezzo;
	private JButton btnIndietro;
	private JButton btnPreventivo;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RicercaNoloClienteV window = new RicercaNoloClienteV();
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
//	public RicercaNoloClienteV() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
	public RicercaNoloNonRegistratoV(JFrame frame, ArrayList<Auto> list, String dataInizio, String dataFine, String luogo) {
//		frame = new JFrame();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().removeAll();
		frame.setBounds(frame.getX(), frame.getY(), 1078, 407);
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
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Assicurazione Normale", "Assicurazione Casco"}));
		comboBox.setBounds(760, 200, 231, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Prezzo Preventivo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(760, 233, 228, 34);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblprezzo = new JLabel("00.00 €");
		lblprezzo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblprezzo.setBounds(760, 278, 231, 14);
		frame.getContentPane().add(lblprezzo);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.setBounds(866, 331, 89, 23);
		frame.getContentPane().add(btnIndietro);
		
		btnPreventivo = new JButton("Preventivo");
		btnPreventivo.setBounds(965, 331, 89, 23);
		frame.getContentPane().add(btnPreventivo);
		
		frame.getContentPane().repaint();
	}
	
	public void addBtnIndietroListener(ActionListener a) {
		btnIndietro.addActionListener(a);
	}
	
	public void addBtnPreventivoListener(ActionListener a) {
		btnPreventivo.addActionListener(a);
	}

	public JLabel getLblprezzo() {
		return lblprezzo;
	}

	public void setLblprezzo(String lblprezzo) {
		this.lblprezzo.setText(lblprezzo);
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTable getTable() {
		return table;
	}

	public Component getList() {
		return list;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}


	public JButton getBtnIndietro() {
		return btnIndietro;
	}

	public JButton getBtnPreventivo() {
		return btnPreventivo;
	}

}
