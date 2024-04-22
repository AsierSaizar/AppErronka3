package LangileakGehitu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ControlLangileakKontratatu.ControlLangileakKontratatu;

public class LangileakGehitu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nan;
	private JTextField pasahitza;
	private JTextField izena;
	private JTextField abizena;
	private JTextField proiektua;
	private JLabel lblPasahitza;
	private JLabel lblIzena;
	private JLabel lblAbizena;
	private JLabel lblLanpostua;
	private JLabel lblProiektua;

	/**
	 * Create the frame.
	 */
	public LangileakGehitu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nan = new JTextField();
		nan.setBounds(133, 40, 180, 19);
		contentPane.add(nan);
		nan.setColumns(10);
		
		pasahitza = new JTextField();
		pasahitza.setBounds(133, 69, 180, 19);
		contentPane.add(pasahitza);
		pasahitza.setColumns(10);
		
		izena = new JTextField();
		izena.setColumns(10);
		izena.setBounds(133, 98, 180, 19);
		contentPane.add(izena);
		
		abizena = new JTextField();
		abizena.setColumns(10);
		abizena.setBounds(133, 127, 180, 19);
		contentPane.add(abizena);
		
		proiektua = new JTextField();
		proiektua.setColumns(10);
		proiektua.setBounds(133, 185, 180, 19);
		contentPane.add(proiektua);
		
		JLabel lblNan = new JLabel("NAN");
		lblNan.setBounds(77, 43, 45, 13);
		contentPane.add(lblNan);
		
		lblPasahitza = new JLabel("Pasahitza");
		lblPasahitza.setBounds(77, 72, 45, 13);
		contentPane.add(lblPasahitza);
		
		lblIzena = new JLabel("Izena");
		lblIzena.setBounds(77, 101, 45, 13);
		contentPane.add(lblIzena);
		
		lblAbizena = new JLabel("Abizena");
		lblAbizena.setBounds(77, 130, 45, 13);
		contentPane.add(lblAbizena);
		
		lblLanpostua = new JLabel("Lan postua");
		lblLanpostua.setBounds(77, 159, 68, 13);
		contentPane.add(lblLanpostua);
		
		lblProiektua = new JLabel("Proiektua");
		lblProiektua.setBounds(77, 188, 45, 13);
		contentPane.add(lblProiektua);
		
		JRadioButton admin = new JRadioButton("Admin");
		admin.setActionCommand("Admin");
		admin.setBounds(133, 160, 77, 19);
		contentPane.add(admin);
		
		JRadioButton langilea = new JRadioButton("Langilea");
		admin.setActionCommand("Langilea");
		langilea.setBounds(212, 158, 103, 21);
		contentPane.add(langilea);
		
		JButton btnNewButton = new JButton("Langilea Kontratatu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlLangileakKontratatu.kontratatu(nan.getText(),izena.getText(),abizena.getText(),admin.getActionCommand(),langilea.getActionCommand(),proiektua.getText());
			}
		});
		btnNewButton.setBounds(133, 232, 180, 21);
		contentPane.add(btnNewButton);
	}
}
