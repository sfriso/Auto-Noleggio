package view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LoggatoClienteV {

private JButton btnModificaProfilo;
private JButton btnLogout;
private JButton btnNoleggiaAuto;
private JLabel lblUser;
private JButton btnCancellaNolo;

//	private JFrame frame;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Loggato_Cliente window = new Loggato_Cliente();
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
//	public Loggato_Cliente() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
	public LoggatoClienteV(JFrame frame) {
//		frame = new JFrame();
		frame.setResizable(false);
		
		frame.getContentPane().removeAll();
		frame.setBounds(frame.getX(), frame.getY(), 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Loggato");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(10, 11, 414, 32);
		frame.getContentPane().add(lblNewLabel);
		
		btnModificaProfilo = new JButton("Modifica Profilo");
		btnModificaProfilo.setBounds(10, 131, 132, 23);
		frame.getContentPane().add(btnModificaProfilo);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(10, 186, 132, 23);
		frame.getContentPane().add(btnLogout);
		
		btnNoleggiaAuto = new JButton("Noleggia Auto");
		btnNoleggiaAuto.setBounds(292, 131, 132, 23);
		frame.getContentPane().add(btnNoleggiaAuto);
		
		lblUser = new JLabel("New label");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUser.setBounds(10, 69, 414, 23);
		frame.getContentPane().add(lblUser);
		
		btnCancellaNolo = new JButton("Cancella Nolo");
		btnCancellaNolo.setBounds(292, 186, 132, 23);
		frame.getContentPane().add(btnCancellaNolo);
		frame.getContentPane().repaint();
	}

	public void setLblUser(String lblUser) {
		this.lblUser.setText(lblUser); 
	}
	
	public void addBtnModificaProfilo(ActionListener a) {
		btnModificaProfilo.addActionListener(a);
	}
	
	public void addBtnLogout(ActionListener a) {
		btnLogout.addActionListener(a);
	}
	
	public void addBtnNoleggiaAuto(ActionListener a) {
		btnNoleggiaAuto.addActionListener(a);
	}
	
	public void addBtnCancellaNolo(ActionListener a) {
		btnCancellaNolo.addActionListener(a);
	}

	public JButton getBtnModificaProfilo() {
		return btnModificaProfilo;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public JButton getBtnNoleggiaAuto() {
		return btnNoleggiaAuto;
	}

	public JLabel getLblUser() {
		return lblUser;
	}

	public JButton getBtnCancellaNolo() {
		return btnCancellaNolo;
	}
	
	
	
}
