package JokalariakSortu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlJokalariakSortu.ControlJokalariakSortu;
import Menua.Menua;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JokalariakSortu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;



	/**
	 * Create the frame.
	 * @param menua 
	 */
	public JokalariakSortu(Menua menua) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 596, 219);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 336, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NAN:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(20, 312, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIzena_1 = new JLabel("Izena:");
		lblIzena_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIzena_1.setBounds(138, 312, 96, 14);
		contentPane.add(lblIzena_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(138, 336, 96, 19);
		contentPane.add(textField_2);
		
		JLabel lblIzena_1_1 = new JLabel("Abizena:");
		lblIzena_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIzena_1_1.setBounds(256, 312, 96, 14);
		contentPane.add(lblIzena_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(256, 336, 96, 19);
		contentPane.add(textField_3);
		
		JLabel lblIzena_1_1_1 = new JLabel("Posizioa:");
		lblIzena_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIzena_1_1_1.setBounds(368, 312, 96, 14);
		contentPane.add(lblIzena_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(368, 336, 96, 19);
		contentPane.add(textField_4);
		
		JLabel lblIzena_1_1_2 = new JLabel("Puntuazioa:");
		lblIzena_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIzena_1_1_2.setBounds(478, 312, 96, 14);
		contentPane.add(lblIzena_1_1_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(478, 336, 96, 19);
		contentPane.add(textField_5);
		
		JLabel lblIzena_1_1_3 = new JLabel("Taldea:");
		lblIzena_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIzena_1_1_3.setBounds(10, 379, 96, 14);
		contentPane.add(lblIzena_1_1_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ajax", "Fortuna", "Groningen", "Heracles", "Utrecht"}));
		comboBox.setBounds(10, 403, 96, 26);
		contentPane.add(comboBox);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(138, 410, 96, 19);
		contentPane.add(textField_6);
		
		JLabel lblIzena_1_2 = new JLabel("Herrialdea:");
		lblIzena_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIzena_1_2.setBounds(138, 386, 96, 14);
		contentPane.add(lblIzena_1_2);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(256, 410, 96, 19);
		contentPane.add(textField_7);
		
		JLabel lblIzena_1_3 = new JLabel("Izena:");
		lblIzena_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIzena_1_3.setBounds(256, 386, 96, 14);
		contentPane.add(lblIzena_1_3);
		
		JButton btnNewButton = new JButton("Jokalaria Sortu");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(390, 379, 184, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Jokalariak Ikusi");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControlJokalariakSortu.taulaErakutsi(table);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(218, 252, 184, 50);
		contentPane.add(btnNewButton_1);
	}
}
