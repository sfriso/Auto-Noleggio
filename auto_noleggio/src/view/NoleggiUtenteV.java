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

import controller.Noleggio;

public class NoleggiUtenteV {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnIndietro;
	private JButton btnCancellaNoleggio;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NoleggiUtenteV window = new NoleggiUtenteV();
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
//	public NoleggiUtenteV() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
	public NoleggiUtenteV(JFrame frame, ArrayList<Noleggio> list) {
//		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().removeAll();
		frame.setBounds(frame.getX(), frame.getY(), 883, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 847, 188);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Targa", "Username", "Inizio Nolo", "Fine Nolo", "Assicurazione", "Luogo Consegna", "prezzo"
			}
		) {
			Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		table.setFillsViewportHeight(true);
		
		Object[] row = new Object[7];
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getTarga();
			row[1] = list.get(i).getUsername();
			row[2] = new SimpleDateFormat("dd/MM/yy").format(list.get(i).getInizioNolo());
			row[3] = new SimpleDateFormat("dd/MM/yy").format(list.get(i).getFineNolo());
			row[4] = list.get(i).getAssicurazione();
			row[5] = list.get(i).getLuogoConsegna();			
			row[6] = list.get(i).getPrezzo();
			model.addRow(row);
		}
		
		
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("I miei Noleggi");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(10, 11, 847, 42);
		frame.getContentPane().add(lblNewLabel);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.setBounds(41, 327, 89, 23);
		frame.getContentPane().add(btnIndietro);
		
		btnCancellaNoleggio = new JButton("Cancella Prenotazione");
		btnCancellaNoleggio.setBounds(662, 327, 163, 23);
		frame.getContentPane().add(btnCancellaNoleggio);
		frame.getContentPane().repaint();
	}
	
	public void addBtnCancellaNoleggioListener(ActionListener a) {
		btnCancellaNoleggio.addActionListener(a);
	}
	
	public void addBtnIndietroListener(ActionListener a) {
		btnIndietro.addActionListener(a);
	}
	
	public Noleggio getNoleggioSelezionato() {
		
		int row = table.getSelectedRow();
		try {
		Noleggio n = new Noleggio((String) table.getValueAt(row, 0),(String) table.getValueAt(row, 1), new SimpleDateFormat("dd/MM/yy").parse(String.valueOf(table.getValueAt(row, 2))), 
				new SimpleDateFormat("dd/MM/yy").parse(String.valueOf(table.getValueAt(row, 3))),
				(String) table.getValueAt(row, 4), (String) table.getValueAt(row, 5),(String) table.getValueAt(row, 6));
		
			return n;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTable getTable() {
		return table;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public JButton getBtnIndietro() {
		return btnIndietro;
	}

	public JButton getBtnCancellaNoleggio() {
		return btnCancellaNoleggio;
	}
	
	
}
