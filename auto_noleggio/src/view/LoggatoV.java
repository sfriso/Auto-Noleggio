package view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LoggatoV {

	private JFrame frame;
	private JLabel labelLoggatoLoggato;
	private JButton buttonModificaautoLoggato;
	private JButton buttonLogoutLoggato;
	private JButton buttonModificaClienteLoggato;
	private JLabel labelUsernameLoggato;
	private JButton buttonNoleggiaautoLoggato;
	private JButton btnRegistrazioneLoggato;
	private JButton btnInsAutoLoggato;
	private JButton btnFineNoleggio;
	private JButton btnListaAuto;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoggatoV window = new LoggatoV();
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
//	public LoggatoV() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	
	public LoggatoV(JFrame frame) {
//		frame = new JFrame();
		frame.setResizable(false);
		
		frame.getContentPane().removeAll();
		frame.setLocationRelativeTo(null);
		frame.setBounds(frame.getX(), frame.getY(), 450, 300);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		labelLoggatoLoggato = new JLabel("Ti Sei Loggato");
		labelLoggatoLoggato.setHorizontalAlignment(SwingConstants.CENTER);
		labelLoggatoLoggato.setFont(new Font("Tahoma", Font.PLAIN, 26));
		labelLoggatoLoggato.setBounds(10, 11, 414, 43);
		frame.getContentPane().add(labelLoggatoLoggato);
		
		buttonModificaautoLoggato = new JButton("Modifica Auto");
		buttonModificaautoLoggato.setBounds(42, 158, 147, 23);
		frame.getContentPane().add(buttonModificaautoLoggato);
		
		buttonLogoutLoggato = new JButton("Logout");
		buttonLogoutLoggato.setBounds(243, 227, 147, 23);
		frame.getContentPane().add(buttonLogoutLoggato);
		
		buttonModificaClienteLoggato = new JButton("Modifica Cliente");
		buttonModificaClienteLoggato.setBounds(243, 124, 147, 23);
		frame.getContentPane().add(buttonModificaClienteLoggato);
		
		labelUsernameLoggato = new JLabel("Username");
		labelUsernameLoggato.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsernameLoggato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelUsernameLoggato.setBounds(153, 65, 147, 23);
		frame.getContentPane().add(labelUsernameLoggato);
		
		buttonNoleggiaautoLoggato = new JButton("Noleggia Auto");
		buttonNoleggiaautoLoggato.setBounds(42, 192, 147, 23);
		frame.getContentPane().add(buttonNoleggiaautoLoggato);
		
		btnRegistrazioneLoggato = new JButton("Registrazione");
		btnRegistrazioneLoggato.setBounds(243, 158, 147, 23);
		frame.getContentPane().add(btnRegistrazioneLoggato);
		
		btnInsAutoLoggato = new JButton("Inserisci Auto");
		btnInsAutoLoggato.setBounds(42, 124, 147, 23);
		frame.getContentPane().add(btnInsAutoLoggato);
		
		btnFineNoleggio = new JButton("Fine Noleggio");
		btnFineNoleggio.setBounds(243, 192, 147, 23);
		frame.getContentPane().add(btnFineNoleggio);
		
		frame.repaint();
	}
	
	void addbtnRegistrazioneLoggatoListener(ActionListener a) {
		btnRegistrazioneLoggato.addActionListener(a);
	}
	
	public void setLabelUsernameLoggato(String Username) {
		this.labelUsernameLoggato.setText(Username);
	}

	void addbtnInsAutoLoggatoListner(ActionListener a) {
		btnInsAutoLoggato.addActionListener(a);
	}
	
	void addbuttonModificaautoLoggatoListener(ActionListener a) {
		buttonModificaautoLoggato.addActionListener(a);
	}

	void addbuttonLogoutLoggatoListener(ActionListener a) {
		buttonLogoutLoggato.addActionListener(a);
	}
	
	void addbuttonModificaClienteLoggatoListener(ActionListener a) {
		buttonModificaClienteLoggato.addActionListener(a);
	}
	void addBtnFineNoleggioListener(ActionListener a) {
		btnFineNoleggio.addActionListener(a);
	}
	
	void addbuttonNoleggiaautoLoggatoListener(ActionListener a) {
		buttonNoleggiaautoLoggato.addActionListener(a);
	}
	void setbuttonNoleggiaautoLoggato(String username) {
		buttonNoleggiaautoLoggato.setName(username);
	}
	void addBtnListaAutoListener(ActionListener a) {
		btnListaAuto.addActionListener(a);
	}

	public JFrame getFrame() {
		return frame;
	}

	public JLabel getLabelLoggatoLoggato() {
		return labelLoggatoLoggato;
	}

	public JButton getButtonModificaautoLoggato() {
		return buttonModificaautoLoggato;
	}

	public JButton getButtonLogoutLoggato() {
		return buttonLogoutLoggato;
	}

	public JButton getButtonModificaClienteLoggato() {
		return buttonModificaClienteLoggato;
	}

	public JLabel getLabelUsernameLoggato() {
		return labelUsernameLoggato;
	}

	public JButton getButtonNoleggiaautoLoggato() {
		return buttonNoleggiaautoLoggato;
	}

	public JButton getBtnRegistrazioneLoggato() {
		return btnRegistrazioneLoggato;
	}

	public JButton getBtnInsAutoLoggato() {
		return btnInsAutoLoggato;
	}

	public JButton getBtnFineNoleggio() {
		return btnFineNoleggio;
	}

	public JButton getBtnListaAuto() {
		return btnListaAuto;
	}
}
