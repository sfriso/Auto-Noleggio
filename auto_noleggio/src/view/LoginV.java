package view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public final class LoginV {

	private JFrame frame;
	private JLabel labelPaginaLoginLogin;
	private JTextField texfieldUsernameLogin;
	private JTextField textfieldPasswordLogin;
	private JLabel labelUsernameLogin;
	private JLabel labelPasswordLogin;
	private JButton buttonLoginLogin;
	private JButton btnCliente;
	private JButton btnRicercaAuto;
	private JButton btnRegistrati;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginV window = new LoginV();
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
//	public LoginV() {
//		initialize(frame);
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
	public LoginV(JFrame frame) {
//		frame = new JFrame();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().removeAll();
		frame.setBounds(frame.getX(), frame.getY(), 450, 327);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		labelPaginaLoginLogin = new JLabel("Gestionale Autonoleggio ");
		labelPaginaLoginLogin.setHorizontalAlignment(SwingConstants.CENTER);
		labelPaginaLoginLogin.setFont(new Font("Tahoma", Font.PLAIN, 26));
		labelPaginaLoginLogin.setBounds(10, 11, 414, 36);
		frame.getContentPane().add(labelPaginaLoginLogin);
		
		texfieldUsernameLogin = new JTextField();
		texfieldUsernameLogin.setBounds(167, 110, 172, 20);
		frame.getContentPane().add(texfieldUsernameLogin);
		texfieldUsernameLogin.setColumns(10);
		
		textfieldPasswordLogin = new JPasswordField();
		textfieldPasswordLogin.setBounds(167, 157, 172, 20);
		frame.getContentPane().add(textfieldPasswordLogin);
		textfieldPasswordLogin.setColumns(10);
		
		labelUsernameLogin = new JLabel("UserName");
		labelUsernameLogin.setBounds(78, 113, 79, 14);
		frame.getContentPane().add(labelUsernameLogin);
		
		labelPasswordLogin = new JLabel("Password");
		labelPasswordLogin.setBounds(78, 160, 79, 14);
		frame.getContentPane().add(labelPasswordLogin);
		
		buttonLoginLogin = new JButton("Impiegato");
		buttonLoginLogin.setBounds(293, 194, 131, 29);
		frame.getContentPane().add(buttonLoginLogin);
		
		btnCliente = new JButton("Cliente");
		btnCliente.setBounds(152, 197, 131, 29);
		frame.getContentPane().add(btnCliente);
		
		btnRicercaAuto = new JButton("Ricerca Auto");
		btnRicercaAuto.setBounds(10, 197, 131, 29);
		frame.getContentPane().add(btnRicercaAuto);
		
		btnRegistrati = new JButton("Registrati");
		btnRegistrati.setBounds(152, 237, 131, 29);
		frame.getContentPane().add(btnRegistrati);
		frame.repaint();
	}
	
	void addBtnClienteListener(ActionListener a) {
		btnCliente.addActionListener(a);
	}
	
	void addBtnRegistratiListener(ActionListener a) {
		btnRegistrati.addActionListener(a);
	}
	
	void addBtnRicercaAutoListener(ActionListener a) {
		btnRicercaAuto.addActionListener(a);
	}
	
	void buttonLoginLoginListener(ActionListener a) {
		buttonLoginLogin.addActionListener(a);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public JLabel getLabelPaginaLoginLogin() {
		return labelPaginaLoginLogin;
	}

	public JLabel getLabelUsernameLogin() {
		return labelUsernameLogin;
	}

	public JLabel getLabelPasswordLogin() {
		return labelPasswordLogin;
	}

	public JButton getButtonLoginLogin() {
		return buttonLoginLogin;
	}

	public JButton getBtnCliente() {
		return btnCliente;
	}

	public JButton getBtnRicercaAuto() {
		return btnRicercaAuto;
	}

	public JButton getBtnRegistrati() {
		return btnRegistrati;
	}

	public String getTexfieldUsernameLogin() {
		return texfieldUsernameLogin.getText();
	}
	
	public String getTextfieldPasswordLogin() {
		return textfieldPasswordLogin.getText();
	}
}
