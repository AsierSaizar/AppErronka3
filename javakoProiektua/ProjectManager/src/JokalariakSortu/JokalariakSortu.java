package JokalariakSortu;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlJokalariakSortu.ControlJokalariakSortu;
import Menua.Menua;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
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
	private JTextField izena;
	private JTextField abizena;
	private JTextField posizioa;
	private JTextField puntuazioa;
	private JTextField herrialdea;
	private JTextField prezioa;
	private JTable table;



	/**
	 * Create the frame.
	 * @param menua 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		
		JLabel lblIzena_1 = new JLabel("Izena:");
		lblIzena_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIzena_1.setBounds(72, 311, 96, 14);
		contentPane.add(lblIzena_1);
		
		izena = new JTextField();
		izena.setColumns(10);
		izena.setBounds(72, 335, 96, 19);
		contentPane.add(izena);
		
		JLabel lblIzena_1_1 = new JLabel("Abizena:");
		lblIzena_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIzena_1_1.setBounds(190, 311, 96, 14);
		contentPane.add(lblIzena_1_1);
		
		abizena = new JTextField();
		abizena.setColumns(10);
		abizena.setBounds(190, 335, 96, 19);
		contentPane.add(abizena);
		
		JLabel lblIzena_1_1_1 = new JLabel("Posizioa:");
		lblIzena_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIzena_1_1_1.setBounds(302, 311, 96, 14);
		contentPane.add(lblIzena_1_1_1);
		
		posizioa = new JTextField();
		posizioa.setColumns(10);
		posizioa.setBounds(302, 335, 96, 19);
		contentPane.add(posizioa);
		
		JLabel lblIzena_1_1_2 = new JLabel("Puntuazioa:");
		lblIzena_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIzena_1_1_2.setBounds(412, 311, 96, 14);
		contentPane.add(lblIzena_1_1_2);
		
		puntuazioa = new JTextField();
		puntuazioa.setColumns(10);
		puntuazioa.setBounds(412, 335, 96, 19);
		contentPane.add(puntuazioa);
		
		JLabel lblIzena_1_1_3 = new JLabel("Taldea:");
		lblIzena_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIzena_1_1_3.setBounds(10, 379, 96, 14);
		contentPane.add(lblIzena_1_1_3);
		
		JComboBox taldea = new JComboBox();
		taldea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		taldea.setModel(new DefaultComboBoxModel(new String[] {"Ajax", "Fortuna", "Groningen", "Heracles", "Utrecht"}));
		taldea.setBounds(10, 403, 96, 26);
		contentPane.add(taldea);
		
		herrialdea = new JTextField();
		herrialdea.setColumns(10);
		herrialdea.setBounds(138, 410, 96, 19);
		contentPane.add(herrialdea);
		
		JLabel lblIzena_1_2 = new JLabel("Herrialdea:");
		lblIzena_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIzena_1_2.setBounds(138, 386, 96, 14);
		contentPane.add(lblIzena_1_2);
		
		prezioa = new JTextField();
		prezioa.setColumns(10);
		prezioa.setBounds(256, 410, 96, 19);
		contentPane.add(prezioa);
		
		JLabel lblIzena_1_3 = new JLabel("prezioa:");
		lblIzena_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIzena_1_3.setBounds(256, 383, 96, 21);
		contentPane.add(lblIzena_1_3);
		
		JButton jokalariaSortu = new JButton("Jokalaria Sortu");
		jokalariaSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControlJokalariakSortu.jokalariaSortu(izena.getText(), abizena.getText(), posizioa.getText(), puntuazioa.getText(), taldea.getSelectedItem().toString(), herrialdea.getText(), prezioa.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		jokalariaSortu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jokalariaSortu.setBounds(390, 379, 184, 50);
		contentPane.add(jokalariaSortu);
		
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
