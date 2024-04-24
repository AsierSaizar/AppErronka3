package Menua;
import ControlMenua.ControlMenua;
import Erabiltzaileak.Erabiltzaileak;
import JokalariakSortu.JokalariakSortu;
import LangileakGehitu.LangileakGehitu;
import Nomina.Nomina;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AdminakEgin.AdminakEgin;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Baneatu.Baneatu;
public class Menua extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 * @param erabiltzailea2 
	 */
	public Menua(Erabiltzaileak erabiltzailea) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Baneatu = new JButton("Baneatu");
		Baneatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Baneatu baneatu = new Baneatu(Menua.this);
					baneatu.setVisible(true);
					Menua.this.setVisible(false);
				
			}
		});
		Baneatu.setBounds(174, 62, 187, 21);
		contentPane.add(Baneatu);
		
		JButton btnNewButton_3 = new JButton("Langileak kontratatu");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ControlMenua.adminDa(erabiltzailea) == 1) {
					JOptionPane.showMessageDialog(null, "Admin zara, oso ondo");
					LangileakGehitu langileakGehitu = new LangileakGehitu(Menua.this);
					langileakGehitu.setVisible(true);
					Menua.this.setVisible(false);	
				}
				else {
					JOptionPane.showMessageDialog(null, "Opzio hau bakarrik adminentza da");
				}
			}
		});
		btnNewButton_3.setBounds(174, 183, 187, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("Administratzaileak sortu");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ControlMenua.adminDa(erabiltzailea) == 1) {
					JOptionPane.showMessageDialog(null, "Admin zara, oso ondo");
					AdminakEgin adminakEgin = new AdminakEgin(Menua.this);
					adminakEgin.setVisible(true);
					Menua.this.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Opzio hau bakarrik adminentza da");
				}
			}
		});
		btnNewButton_5.setBounds(174, 245, 187, 21);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("Administratzaileak");
		lblNewLabel.setBounds(174, 148, 187, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Langileak");
		lblNewLabel_1.setBounds(174, 39, 187, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2_1 = new JButton("Jokalariak sartu");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JokalariakSortu jokalariaSortu = new JokalariakSortu(Menua.this);
				jokalariaSortu.setVisible(true);
				Menua.this.setVisible(false);
			}
		});
		btnNewButton_2_1.setBounds(174, 94, 187, 21);
		contentPane.add(btnNewButton_2_1);
		
		
		
		
		
		JButton btnNewButton = new JButton("Nomina egin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        System.out.println("Button clicked!"); // Añadir esta línea para depuración

				if(ControlMenua.adminDa(erabiltzailea) == 1) {
					JOptionPane.showMessageDialog(null, "Admin zara, oso ondo");
					Nomina nomina = new Nomina(Menua.this);
					nomina.setVisible(true);
					Menua.this.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Opzio hau bakarrik adminentza da");
				}
			}
		});
		btnNewButton.setBounds(174, 214, 187, 21);
		contentPane.add(btnNewButton);
	}
}
