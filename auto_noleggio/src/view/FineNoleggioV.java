package view;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.Noleggio;

public class FineNoleggioV {

//	private JFrame frame;
	private JTable tableNoleggio;
	private JTable tableAuto;
	private JTable tableUtente;
	private JButton btnCancNolo;
	private JButton btnPagaNoleggio;
	private JButton btnIndietro;
	private DefaultTableModel autoModel;
	private DefaultTableModel utenteModel;
	private JButton btnCerca;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FineNoleggioV window = new FineNoleggioV();
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
//	public FineNoleggioV() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
	public  FineNoleggioV(JFrame frame, ArrayList<Noleggio> list_n/*, ArrayList<Auto> list_a, ArrayList<Utente> list_u*/) {
//		frame = new JFrame();
		frame.setResizable(false);
		
		frame.getContentPane().removeAll();
		frame.setBounds(frame.getX(), frame.getY(), 1233, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 105, 663, 190);
		frame.getContentPane().add(scrollPane);
		
		tableNoleggio = new JTable();
		
		DefaultTableModel dataModel = (new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Targa", "Username", "Data Inizio", "Data Fine", "Luogo Consegna", "Preventivo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tableNoleggio);
		
		Object[] row = new Object[6];
		for(int i = 0; i < list_n.size(); i++) {
			row[0] = list_n.get(i).getTarga();
			row[1] = list_n.get(i).getUsername();
			row[2] = new SimpleDateFormat("dd/MM/yy").format(list_n.get(i).getInizioNolo());
			row[3] = new SimpleDateFormat("dd/MM/yy").format(list_n.get(i).getFineNolo());
			row[4] = list_n.get(i).getLuogoConsegna();
			row[5] = list_n.get(i).getPrezzo();
			dataModel.addRow(row);
		}
		
		
		tableNoleggio.setModel(dataModel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(683, 105, 524, 81);
		frame.getContentPane().add(scrollPane_1);
		
		tableAuto = new JTable();
		autoModel = (new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Targa", "Danni Carrozzeria", "Danni Interno", "Pulizia", "Prezzo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableAuto.setModel(autoModel);
		scrollPane_1.setViewportView(tableAuto);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(683, 219, 524, 76);
		frame.getContentPane().add(scrollPane_2);
		
		tableUtente = new JTable();
		utenteModel = (new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cellulare", "Ratio", "Email", "Username"
			}) {
					Class[] columnTypes = new Class[] {
							String.class, String.class, String.class, String.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
						boolean[] columnEditables = new boolean[] {
							true, true, true, true, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
		});
		tableUtente.setModel(utenteModel);
		scrollPane_2.setViewportView(tableUtente);
		
		JLabel lblNewLabel = new JLabel("Utente");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(621, 197, 586, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fine Noleggio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 1197, 58);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNoleggio = new JLabel("Noleggio");
		lblNoleggio.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoleggio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNoleggio.setBounds(10, 71, 601, 23);
		frame.getContentPane().add(lblNoleggio);
		
		JLabel lblStatoAuto = new JLabel("Stato Auto");
		lblStatoAuto.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatoAuto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatoAuto.setBounds(621, 71, 586, 23);
		frame.getContentPane().add(lblStatoAuto);
		
		btnCancNolo = new JButton("Cancella Noleggio");
		btnCancNolo.setBounds(10, 306, 138, 23);
		frame.getContentPane().add(btnCancNolo);
		
		btnPagaNoleggio = new JButton("Paga Noleggio");
		btnPagaNoleggio.setBounds(693, 306, 138, 23);
		frame.getContentPane().add(btnPagaNoleggio);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.setBounds(1069, 306, 138, 23);
		frame.getContentPane().add(btnIndietro);
		
		btnCerca = new JButton("Cerca");
		btnCerca.setBounds(535, 306, 138, 23);
		frame.getContentPane().add(btnCerca);
		frame.getContentPane().repaint();
	}
	
	public void addRowAuto(Object[] o) {
		if (autoModel.getRowCount() > 0) {
			autoModel.removeRow(0);
		}
		autoModel.addRow(o);
		tableAuto.setModel(autoModel);
	}

	public void addRowUtente(Object[] o) {
		if (utenteModel.getRowCount() > 0) {
			utenteModel.removeRow(0);
		}
		utenteModel.addRow(o);
		tableUtente.setModel(utenteModel);
	}
	

	public DefaultTableModel getAutoModel() {
		return autoModel;
	}

	public DefaultTableModel getUtenteModel() {
		return utenteModel;
	}

	public JButton getBtnCerca() {
		return btnCerca;
	}

	public JTable getTableNoleggio() {
		return tableNoleggio;
	}

	public JTable getTableAuto() {
		return tableAuto;
	}

	public JTable getTableUtente() {
		return tableUtente;
	}

	public JButton getBtnCancNolo() {
		return btnCancNolo;
	}

	public JButton getBtnPagaNoleggio() {
		return btnPagaNoleggio;
	}

	public JButton getBtnIndietro() {
		return btnIndietro;
	}
	public int getTableNoleggioRowSelected() {
		return tableNoleggio.getSelectedRow();
	}
}
