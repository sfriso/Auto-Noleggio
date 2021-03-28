package view;

import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InserisciAutoV {

	private JFrame frame;
	private JTextField textTargaInsAuto;
	private JTextField textMarcaInsAuto;
	private JTextField textModelloInsAuto;
	private JTextField textPostiInsAuto;
	private JTextField textCilindrataInsAuto;
	private JTextField textCavalliInsAuto;
	private JTextField textConsumiInsAuto;
	private JTextField textProsRevisioneInsAuto;
	private JTextField textProsBolloAuto;
	private JTextField textCamRuoteInsAuto;
	private JTextField textAssicurazioneInsAuto;
	private JTextField textDanniCarrInsAuto;
	private JTextField textDanniInsInsAuto;
	private JTextField textPuliziaInsAuto;
	private JButton btnSalvaInsAuto;
	private JButton btnIndietroInsAuto;
	private JTextField textPrezzo;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InserisciAutoV window = new InserisciAutoV();
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
//	public InserisciAutoV() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
	public InserisciAutoV(JFrame frame) {
//		frame = new JFrame();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().removeAll();
		frame.setBounds(100, 100, 389, 548);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inserisci Auto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(10, 11, 353, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTargaInsAuto = new JLabel("Targa");
		lblTargaInsAuto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTargaInsAuto.setBounds(20, 72, 107, 14);
		frame.getContentPane().add(lblTargaInsAuto);
		
		textTargaInsAuto = new JTextField();
		textTargaInsAuto.setBounds(184, 69, 157, 20);
		frame.getContentPane().add(textTargaInsAuto);
		textTargaInsAuto.setColumns(10);
		
		JLabel lblMarcaInsAuto = new JLabel("Marca");
		lblMarcaInsAuto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarcaInsAuto.setBounds(20, 97, 107, 14);
		frame.getContentPane().add(lblMarcaInsAuto);
		
		JLabel lblModelloInsAuto = new JLabel("Modello");
		lblModelloInsAuto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModelloInsAuto.setBounds(20, 122, 107, 14);
		frame.getContentPane().add(lblModelloInsAuto);
		
		JLabel lblPostiInsAuto = new JLabel("Posti");
		lblPostiInsAuto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPostiInsAuto.setBounds(20, 147, 107, 14);
		frame.getContentPane().add(lblPostiInsAuto);
		
		JLabel lblCilindrataInsAuto = new JLabel("Cililndrata");
		lblCilindrataInsAuto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCilindrataInsAuto.setBounds(20, 172, 107, 14);
		frame.getContentPane().add(lblCilindrataInsAuto);
		
		JLabel lblCavalliInsAuto = new JLabel("Cavalli");
		lblCavalliInsAuto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCavalliInsAuto.setBounds(20, 197, 107, 14);
		frame.getContentPane().add(lblCavalliInsAuto);
		
		JLabel lblConsumiInsAuto = new JLabel("Consumi");
		lblConsumiInsAuto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConsumiInsAuto.setBounds(20, 222, 107, 14);
		frame.getContentPane().add(lblConsumiInsAuto);
		 
		JLabel lblProsRevisioneInsAuto = new JLabel("Prossima Revisione");
		lblProsRevisioneInsAuto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProsRevisioneInsAuto.setBounds(20, 247, 107, 14);
		frame.getContentPane().add(lblProsRevisioneInsAuto);
		
		JLabel lblProsBolloAuto = new JLabel("Prossimo Bollo");
		lblProsBolloAuto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProsBolloAuto.setBounds(20, 272, 107, 14);
		frame.getContentPane().add(lblProsBolloAuto);
		
		JLabel lblCamRuoteInsAuto = new JLabel("Pros. Cambio Ruote");
		lblCamRuoteInsAuto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCamRuoteInsAuto.setBounds(20, 297, 107, 14);
		frame.getContentPane().add(lblCamRuoteInsAuto);
		
		JLabel lblAssicurazioneInsAuto = new JLabel("Pros. Assicurazione");
		lblAssicurazioneInsAuto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAssicurazioneInsAuto.setBounds(20, 322, 107, 14);
		frame.getContentPane().add(lblAssicurazioneInsAuto);
		
		JLabel lblDanniCarrInsAuto = new JLabel("Danni Carrozzeria");
		lblDanniCarrInsAuto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDanniCarrInsAuto.setBounds(20, 347, 107, 14);
		frame.getContentPane().add(lblDanniCarrInsAuto);
		
		JLabel lblDanniInsInsAuto = new JLabel("Danni Interno");
		lblDanniInsInsAuto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDanniInsInsAuto.setBounds(20, 372, 107, 14);
		frame.getContentPane().add(lblDanniInsInsAuto);
		
		JLabel lblPuliziaInsAuto = new JLabel("Pulizia");
		lblPuliziaInsAuto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPuliziaInsAuto.setBounds(20, 398, 107, 14);
		frame.getContentPane().add(lblPuliziaInsAuto);
		
		textMarcaInsAuto = new JTextField();
		textMarcaInsAuto.setBounds(184, 94, 157, 20);
		frame.getContentPane().add(textMarcaInsAuto);
		textMarcaInsAuto.setColumns(10);
		
		textModelloInsAuto = new JTextField();
		textModelloInsAuto.setColumns(10);
		textModelloInsAuto.setBounds(184, 119, 157, 20);
		frame.getContentPane().add(textModelloInsAuto);
		
		textPostiInsAuto = new JTextField();
		textPostiInsAuto.setColumns(10);
		textPostiInsAuto.setBounds(184, 144, 157, 20);
		frame.getContentPane().add(textPostiInsAuto);
		
		textCilindrataInsAuto = new JTextField();
		textCilindrataInsAuto.setColumns(10);
		textCilindrataInsAuto.setBounds(184, 169, 157, 20);
		frame.getContentPane().add(textCilindrataInsAuto);
		
		textCavalliInsAuto = new JTextField();
		textCavalliInsAuto.setColumns(10);
		textCavalliInsAuto.setBounds(184, 194, 157, 20);
		frame.getContentPane().add(textCavalliInsAuto);
		
		textConsumiInsAuto = new JTextField();
		textConsumiInsAuto.setColumns(10);
		textConsumiInsAuto.setBounds(184, 219, 157, 20);
		frame.getContentPane().add(textConsumiInsAuto);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		
		textProsRevisioneInsAuto = new JFormattedTextField(formatter);
		textProsRevisioneInsAuto.setColumns(10);
		textProsRevisioneInsAuto.setBounds(184, 244, 157, 20);
		frame.getContentPane().add(textProsRevisioneInsAuto);

		textProsBolloAuto = new JFormattedTextField(formatter);
		textProsBolloAuto.setColumns(10);
		textProsBolloAuto.setBounds(184, 269, 157, 20);
		frame.getContentPane().add(textProsBolloAuto);
		
		textCamRuoteInsAuto = new JFormattedTextField(formatter);
		textCamRuoteInsAuto.setColumns(10);
		textCamRuoteInsAuto.setBounds(184, 294, 157, 20);
		frame.getContentPane().add(textCamRuoteInsAuto);
		
		textAssicurazioneInsAuto = new JFormattedTextField(formatter);
		textAssicurazioneInsAuto.setColumns(10);
		textAssicurazioneInsAuto.setBounds(184, 319, 157, 20);
		frame.getContentPane().add(textAssicurazioneInsAuto);
		
		textDanniCarrInsAuto = new JTextField();
		textDanniCarrInsAuto.setColumns(10);
		textDanniCarrInsAuto.setBounds(184, 344, 157, 20);
		frame.getContentPane().add(textDanniCarrInsAuto);
		
		textDanniInsInsAuto = new JTextField();
		textDanniInsInsAuto.setColumns(10);
		textDanniInsInsAuto.setBounds(184, 369, 157, 20);
		frame.getContentPane().add(textDanniInsInsAuto);
		
		textPuliziaInsAuto = new JTextField();
		textPuliziaInsAuto.setColumns(10);
		textPuliziaInsAuto.setBounds(184, 395, 157, 20);
		frame.getContentPane().add(textPuliziaInsAuto);
		
		btnSalvaInsAuto = new JButton("Salva");
		btnSalvaInsAuto.setBounds(213, 457, 89, 23);
		frame.getContentPane().add(btnSalvaInsAuto);
		
		btnIndietroInsAuto = new JButton("Indietro");
		btnIndietroInsAuto.setBounds(10, 457, 89, 23);
		frame.getContentPane().add(btnIndietroInsAuto);
		
		textPrezzo = new JTextField();
		textPrezzo.setColumns(10);
		textPrezzo.setBounds(184, 420, 157, 20);
		frame.getContentPane().add(textPrezzo);
		
		JLabel lblPrezzo = new JLabel("Prezzo");
		lblPrezzo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezzo.setBounds(20, 423, 107, 14);
		frame.getContentPane().add(lblPrezzo);
		frame.repaint();
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTextTargaInsAuto() {
		return textTargaInsAuto;
	}

	public JTextField getTextMarcaInsAuto() {
		return textMarcaInsAuto;
	}

	public JTextField getTextModelloInsAuto() {
		return textModelloInsAuto;
	}

	public JTextField getTextPostiInsAuto() {
		return textPostiInsAuto;
	}

	public JTextField getTextCilindrataInsAuto() {
		return textCilindrataInsAuto;
	}

	public JTextField getTextCavalliInsAuto() {
		return textCavalliInsAuto;
	}

	public JTextField getTextConsumiInsAuto() {
		return textConsumiInsAuto;
	}

	public JTextField getTextProsRevisioneInsAuto() {
		return textProsRevisioneInsAuto;
	}

	public JTextField getTextProsBolloAuto() {
		return textProsBolloAuto;
	}

	public JTextField getTextCamRuoteInsAuto() {
		return textCamRuoteInsAuto;
	}

	public JTextField getTextAssicurazioneInsAuto() {
		return textAssicurazioneInsAuto;
	}

	public JTextField getTextDanniCarrInsAuto() {
		return textDanniCarrInsAuto;
	}

	public JTextField getTextDanniInsInsAuto() {
		return textDanniInsInsAuto;
	}

	public JTextField getTextPuliziaInsAuto() {
		return textPuliziaInsAuto;
	}

	public JButton getBtnSalvaInsAuto() {
		return btnSalvaInsAuto;
	}

	public JButton getBtnIndietroInsAuto() {
		return btnIndietroInsAuto;
	}

	public JTextField getTextPrezzo() {
		return textPrezzo;
	}
}
