package view;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Utente;

public class RegistraV {

//	private JFrame frame;
	private JTextField textNomeRegistrazione;
	private JTextField textCognomeRegistrazione;
	private JTextField textDataNascitaRegistrazione;
	private JTextField textPatenteRegistrazione;
	private JTextField textScaPatenteRegistrazione;
	private JTextField textEmailRegistrazione;
	private JTextField textUsernameRegistrazione;
	private JTextField textCartaRegistrazione;
	private JButton btnIndietroRegistrazione;
	private JButton btnSalvaRegistrazione;
	private JTextField textNumeroTelRegistrazione;

	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegistraV window = new RegistraV();
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
//	public RegistraV() {
//		initialize();
//	}

	/**
	 * Initialize the contents of the frame.
	 */
//	protected void initialize() {
	public RegistraV(JFrame frame) {
//		frame = new JFrame();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().removeAll();
		frame.setBounds(100, 100, 313, 403);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbRegistrazioneRegistrazione = new JLabel("Registrazione");
		lbRegistrazioneRegistrazione.setHorizontalAlignment(SwingConstants.CENTER);
		lbRegistrazioneRegistrazione.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbRegistrazioneRegistrazione.setBounds(10, 11, 277, 42);
		frame.getContentPane().add(lbRegistrazioneRegistrazione);
		
		JLabel lbNomeRegistrazione = new JLabel("Nome");
		lbNomeRegistrazione.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNomeRegistrazione.setBounds(10, 97, 109, 14);
		frame.getContentPane().add(lbNomeRegistrazione);
		
		JLabel lbCognomeRegistrazione = new JLabel("Cognome");
		lbCognomeRegistrazione.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCognomeRegistrazione.setBounds(10, 122, 109, 14);
		frame.getContentPane().add(lbCognomeRegistrazione);
		
		JLabel lbPatenteRegistrazione = new JLabel("Seriale Patente");
		lbPatenteRegistrazione.setHorizontalAlignment(SwingConstants.RIGHT);
		lbPatenteRegistrazione.setBounds(10, 172, 109, 14);
		frame.getContentPane().add(lbPatenteRegistrazione);
		
		JLabel lbScaPatenteRegistrazione = new JLabel("Scadenza Patente");
		lbScaPatenteRegistrazione.setHorizontalAlignment(SwingConstants.RIGHT);
		lbScaPatenteRegistrazione.setBounds(10, 197, 109, 14);
		frame.getContentPane().add(lbScaPatenteRegistrazione);
		
		JLabel lbEmailRegistrazione = new JLabel("Email");
		lbEmailRegistrazione.setHorizontalAlignment(SwingConstants.RIGHT);
		lbEmailRegistrazione.setBounds(10, 222, 109, 14);
		frame.getContentPane().add(lbEmailRegistrazione);
		
		JLabel lbUsernamelRegistrazione = new JLabel("Username");
		lbUsernamelRegistrazione.setHorizontalAlignment(SwingConstants.RIGHT);
		lbUsernamelRegistrazione.setBounds(10, 247, 109, 14);
		frame.getContentPane().add(lbUsernamelRegistrazione);
		
		JLabel lbCartaRegistrazione = new JLabel("Carta Di Credito");
		lbCartaRegistrazione.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCartaRegistrazione.setBounds(10, 272, 109, 14);
		frame.getContentPane().add(lbCartaRegistrazione);
		
		JLabel lbDataNascitaRegistrazione = new JLabel("Data di Nascita");
		lbDataNascitaRegistrazione.setHorizontalAlignment(SwingConstants.RIGHT);
		lbDataNascitaRegistrazione.setBounds(10, 147, 109, 14);
		frame.getContentPane().add(lbDataNascitaRegistrazione);
		
		textNomeRegistrazione = new JTextField();
		textNomeRegistrazione.setBounds(168, 94, 119, 20);
		frame.getContentPane().add(textNomeRegistrazione);
		textNomeRegistrazione.setColumns(10);
		
		textCognomeRegistrazione = new JTextField();
		textCognomeRegistrazione.setBounds(168, 119, 119, 20);
		frame.getContentPane().add(textCognomeRegistrazione);
		textCognomeRegistrazione.setColumns(10);
		
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		 
		textDataNascitaRegistrazione = new JFormattedTextField(formatter);
		textDataNascitaRegistrazione.setBounds(168, 144, 119, 20);
		frame.getContentPane().add(textDataNascitaRegistrazione);
		textDataNascitaRegistrazione.setColumns(10);
		
		textPatenteRegistrazione = new JTextField();
		textPatenteRegistrazione.setBounds(168, 169, 119, 20);
		frame.getContentPane().add(textPatenteRegistrazione);
		textPatenteRegistrazione.setColumns(10);
		
		textScaPatenteRegistrazione =  new JFormattedTextField(formatter);
		textScaPatenteRegistrazione.setBounds(168, 194, 119, 20);
		frame.getContentPane().add(textScaPatenteRegistrazione);
		textScaPatenteRegistrazione.setColumns(10);
		
		textEmailRegistrazione = new JTextField();
		textEmailRegistrazione.setBounds(168, 219, 119, 20);
		frame.getContentPane().add(textEmailRegistrazione);
		textEmailRegistrazione.setColumns(10);
		
		textUsernameRegistrazione = new JTextField();
		textUsernameRegistrazione.setBounds(168, 244, 119, 20);
		frame.getContentPane().add(textUsernameRegistrazione);
		textUsernameRegistrazione.setColumns(10);
		
		textCartaRegistrazione = new JTextField();
		textCartaRegistrazione.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent ke) {
            String value = textCartaRegistrazione.getText();
            int l = value.length();
            if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') | ke.getKeyChar()==ke.VK_BACK_SPACE) {
            	textCartaRegistrazione.setEditable(true);
               //label.setText("");
            } else {
            	textCartaRegistrazione.setEditable(false);
              // label.setText("* Enter only numeric digits(0-9)");
            }
         }
      });
		textCartaRegistrazione.setBounds(168, 269, 119, 20);
		frame.getContentPane().add(textCartaRegistrazione);
		textCartaRegistrazione.setColumns(10);
		
		btnIndietroRegistrazione = new JButton("Indietro");
		btnIndietroRegistrazione.setBounds(10, 330, 89, 23);
		frame.getContentPane().add(btnIndietroRegistrazione);
		
		btnSalvaRegistrazione = new JButton("Salva");
		btnSalvaRegistrazione.setBounds(198, 330, 89, 23);
		frame.getContentPane().add(btnSalvaRegistrazione);
		
		textNumeroTelRegistrazione = new JTextField();
		textNumeroTelRegistrazione.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	             String value = textCartaRegistrazione.getText();
	             int l = value.length();
	             if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') | ke.getKeyChar()==ke.VK_BACK_SPACE) {
	             	textCartaRegistrazione.setEditable(true);
	                //label.setText("");
	             } else {
	             	textCartaRegistrazione.setEditable(false);
	               // label.setText("* Enter only numeric digits(0-9)");
	             }
	          }
	       });
		textNumeroTelRegistrazione.setBounds(168, 294, 119, 20);
		frame.getContentPane().add(textNumeroTelRegistrazione);
		textNumeroTelRegistrazione.setColumns(10);
		
		JLabel lbNumeroTelRegistrazione = new JLabel("Numero di telefono");
		lbNumeroTelRegistrazione.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNumeroTelRegistrazione.setBounds(10, 297, 109, 14);
		frame.getContentPane().add(lbNumeroTelRegistrazione);
		frame.repaint();
	}
	
//	public JFrame getFrame() {
//		return frame;
//	}

	public JTextField getTextNumeroTelRegistrazione() {
		return textNumeroTelRegistrazione;
	}

	public JTextField getTextNomeRegistrazione() {
		return textNomeRegistrazione;
	}

	public JTextField getTextCognomeRegistrazione() {
		return textCognomeRegistrazione;
	}

	public JTextField getTextDataNascitaRegistrazione() {
		return textDataNascitaRegistrazione;
	}

	public JTextField getTextPatenteRegistrazione() {
		return textPatenteRegistrazione;
	}

	public JTextField getTextScaPatenteRegistrazione() {
		return textScaPatenteRegistrazione;
	}

	public JTextField getTextEmailRegistrazione() {
		return textEmailRegistrazione;
	}

	public JTextField getTextUsernameRegistrazione() {
		return textUsernameRegistrazione;
	}

	public JTextField getTextCartaRegistrazione() {
		return textCartaRegistrazione;
	}

	public JButton getBtnIndietroRegistrazione() {
		return btnIndietroRegistrazione;
	}

	public JButton getBtnSalvaRegistrazione() {
		return btnSalvaRegistrazione;
	}

	public void addTextUsernameRegistrazioneListner(ActionListener a) {
		textUsernameRegistrazione.addActionListener(a);
	}
	
	public void addBtnSalvaRegistrazioneListener(ActionListener a){
		btnSalvaRegistrazione.addActionListener(a);
	}
	public void addBtnIndietroRegistrazioneListener(ActionListener a) {
		btnIndietroRegistrazione.addActionListener(a);
	}
	
	public Utente utente() throws ParseException {
		return new Utente(textNomeRegistrazione.getText(),textCognomeRegistrazione.getText(), textPatenteRegistrazione.getText(), 0, textEmailRegistrazione.getText(), false, textUsernameRegistrazione.getText(),
				new SimpleDateFormat("dd/MM/yy").parse(textScaPatenteRegistrazione.getText()), new SimpleDateFormat("dd/MM/yy").parse(textDataNascitaRegistrazione.getText()), textNumeroTelRegistrazione.getText(),
				textCartaRegistrazione.getText());
	}
}
