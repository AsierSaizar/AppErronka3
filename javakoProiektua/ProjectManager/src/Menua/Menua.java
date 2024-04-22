package Menua;
import ControlMenua.ControlMenua;
import Erabiltzaileak.Erabiltzaileak;
import LangileakGehitu.LangileakGehitu;
import Sarrera.Sarrera;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menua extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 * @param erabiltzailea2 
	 */
	public Menua(Erabiltzaileak erabiltzailea) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Baneatu = new JButton("Baneatu");
		Baneatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Baneatu.setBounds(126, 44, 187, 21);
		contentPane.add(Baneatu);
		
		JButton btnErosketenHistorialaIkusi = new JButton("Erosketen historiala ikusi");
		btnErosketenHistorialaIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnErosketenHistorialaIkusi.setBounds(126, 75, 187, 21);
		contentPane.add(btnErosketenHistorialaIkusi);
		
		JButton btnNewButton_2 = new JButton("Erabiltzaileak ikusi");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(126, 106, 187, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Langileak kontratatu");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ControlMenua.adminDa(erabiltzailea) == 1) {
					JOptionPane.showMessageDialog(null, "Admin zara, oso ondo");
					LangileakGehitu langileakGehitu = new LangileakGehitu();
					langileakGehitu.setVisible(true);
					Menua.this.setVisible(false);	
				}
				else {
					JOptionPane.showMessageDialog(null, "Opzio hau bakarrik adminentza da");
				}
			}
		});
		btnNewButton_3.setBounds(126, 183, 187, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Nominak egin");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(126, 214, 187, 21);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Administratzaileak sortu");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBounds(126, 242, 187, 21);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("Administratzaileak");
		lblNewLabel.setBounds(126, 160, 187, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Langileak");
		lblNewLabel_1.setBounds(126, 21, 187, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2_1 = new JButton("Jokalariak sartu");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1.setBounds(126, 137, 187, 21);
		contentPane.add(btnNewButton_2_1);
	}
}
