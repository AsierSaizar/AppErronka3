package Sarrera;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlSarrera.ControlSarrera;
import Erabiltzaileak.Erabiltzaileak;
import Menua.Menua;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sarrera extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField erabiltzailea;
	private JTextField pasahitza;
	private JTextField proiektua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sarrera frame = new Sarrera();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sarrera() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Sartu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    ControlSarrera controla = new ControlSarrera();
				    Erabiltzaileak erabiltzailea2 = controla.erabiltzaileaSartu(erabiltzailea.getText(),pasahitza.getText(),Integer.parseInt(proiektua.getText()));
					if(null != erabiltzailea2) {
						Menua menua = new Menua(erabiltzailea2);
						menua.setVisible(true);
						Sarrera.this.setVisible(false);	
					}
					
			}
		});
		
		
		btnNewButton.setBounds(89, 166, 257, 21);
		contentPane.add(btnNewButton);
		
		erabiltzailea = new JTextField();
		erabiltzailea.setBounds(89, 106, 96, 19);
		contentPane.add(erabiltzailea);
		erabiltzailea.setColumns(10);
		
		pasahitza = new JTextField();
		pasahitza.setBounds(195, 106, 96, 19);
		contentPane.add(pasahitza);
		pasahitza.setColumns(10);
		
		proiektua = new JTextField();
		proiektua.setBounds(301, 105, 45, 21);
		contentPane.add(proiektua);
		proiektua.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Erabiltzailea");
		lblNewLabel.setBounds(89, 83, 96, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pasahitza");
		lblNewLabel_1.setBounds(198, 83, 96, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Proiektua");
		lblNewLabel_2.setBounds(304, 82, 45, 13);
		contentPane.add(lblNewLabel_2);
	}
}
