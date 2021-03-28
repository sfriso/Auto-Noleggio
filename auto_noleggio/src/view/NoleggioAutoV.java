package view;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NoleggioAutoV {

	private JFrame frame;
	private JTextField textDataInizio;
	private JTextField textDataFine;
	private JTextField textPosti;
	private JTextField textModello;
	private JTextField textMarca;
	private JTextField textCilindrata;
	private JTextField textCavalli;
	private JTextField textConsumi;
	private JButton btnIndietro;
	private JButton btnCerca;
	private JComboBox luogo;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NoleggioUtentiV window = new NoleggioUtentiV();
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
//	public NoleggioUtentiV() {
//		initialize();
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	public NoleggioAutoV(JFrame frame) {
//		frame = new JFrame();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().removeAll();
		frame.setBounds(frame.getX(), frame.getY(), 485, 356);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		luogo = new JComboBox();
		luogo.setToolTipText("");
		luogo.setModel(new DefaultComboBoxModel(new String[] {"Sede di Roma", "Sede di Bergamo", "Sede di Milano", "Sede di Crema", "Sede di Brescia"}));
		luogo.setSelectedIndex(0);
		luogo.setBounds(57, 93, 92, 22);
		frame.getContentPane().add(luogo);
		
		JLabel lblNewLabel = new JLabel("Luogo");
		lblNewLabel.setBounds(57, 68, 92, 14);
		frame.getContentPane().add(lblNewLabel);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		
		textDataInizio = new JFormattedTextField(formatter);
		textDataInizio.setBounds(216, 94, 86, 20);
		frame.getContentPane().add(textDataInizio);
		textDataInizio.setColumns(10);
		
		textDataFine = new JFormattedTextField(formatter);
		textDataFine.setBounds(336, 94, 86, 20);
		frame.getContentPane().add(textDataFine);
		textDataFine.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Seleziona Data Inizio e Fine Noleggio");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(196, 68, 247, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textPosti = new JTextField();
		textPosti.setBounds(57, 172, 86, 20);
		frame.getContentPane().add(textPosti);
		textPosti.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Posti");
		lblNewLabel_2.setBounds(57, 147, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Modello");
		lblNewLabel_3.setBounds(216, 147, 69, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textModello = new JTextField();
		textModello.setBounds(216, 172, 86, 20);
		frame.getContentPane().add(textModello);
		textModello.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Marca");
		lblNewLabel_4.setBounds(336, 147, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textMarca = new JTextField();
		textMarca.setBounds(336, 172, 86, 20);
		frame.getContentPane().add(textMarca);
		textMarca.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Cilindrata");
		lblNewLabel_5.setBounds(57, 203, 92, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textCilindrata = new JTextField();
		textCilindrata.setBounds(57, 228, 86, 20);
		frame.getContentPane().add(textCilindrata);
		textCilindrata.setColumns(10);
		
		btnCerca = new JButton("Cerca");
		btnCerca.setBounds(273, 276, 89, 23);
		frame.getContentPane().add(btnCerca);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.setBounds(57, 276, 89, 23);
		frame.getContentPane().add(btnIndietro);
		
		JLabel lblNewLabel_6 = new JLabel("Cavalli");
		lblNewLabel_6.setBounds(216, 203, 86, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		textCavalli = new JTextField();
		textCavalli.setBounds(216, 228, 86, 20);
		frame.getContentPane().add(textCavalli);
		textCavalli.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Consumi");
		lblNewLabel_7.setBounds(336, 203, 69, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		textConsumi = new JTextField();
		textConsumi.setBounds(336, 228, 86, 20);
		frame.getContentPane().add(textConsumi);
		textConsumi.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Cerca Auto Noleggio");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_8.setBounds(10, 11, 449, 32);
		frame.getContentPane().add(lblNewLabel_8);
		frame.repaint();
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTextDataInizio() {
		return textDataInizio;
	}

	public JTextField getTextDataFine() {
		return textDataFine;
	}

	public JTextField getTextPosti() {
		return textPosti;
	}

	public JTextField getTextModello() {
		return textModello;
	}

	public JTextField getTextMarca() {
		return textMarca;
	}

	public JTextField getTextCilindrata() {
		return textCilindrata;
	}

	public JTextField getTextCavalli() {
		return textCavalli;
	}

	public JTextField getTextConsumi() {
		return textConsumi;
	}

	public JButton getBtnIndietro() {
		return btnIndietro;
	}

	public JButton getBtnCerca() {
		return btnCerca;
	}
	
	public JComboBox getLuogo() {
		return luogo;
	}

	public void addBtnIndietroListener(ActionListener a) {
		btnIndietro.addActionListener(a);
	}
	public void addBtnCercaListener(ActionListener a) {
		btnCerca.addActionListener(a);
	}
	
}
