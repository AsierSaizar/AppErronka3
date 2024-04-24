package LangileakGehitu;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import ControlLangileakKontratatu.ControlLangileakKontratatu;
import Menua.Menua;

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
	private ButtonGroup group;
	private JButton atzera;

	/**
	 * Create the frame.
	 */
	public LangileakGehitu(Menua menua) {
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
		langilea.setActionCommand("Langilea");
		langilea.setBounds(212, 158, 103, 21);
		contentPane.add(langilea);
		
		group = new ButtonGroup();
        group.add(admin);
        group.add(langilea);
		
		JButton btnNewButton = new JButton("Langilea Kontratatu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedRole = null;
                if (group.getSelection() != null) {
                    selectedRole = group.getSelection().getActionCommand();
    				try {
						ControlLangileakKontratatu.kontratatu(nan.getText(),pasahitza.getText(),izena.getText(),abizena.getText(),selectedRole,Integer.valueOf(proiektua.getText()));
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

                }
			}
		});
		btnNewButton.setBounds(133, 232, 180, 21);
		contentPane.add(btnNewButton);
		
		atzera = new JButton("Atzera");
		atzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					JOptionPane.showMessageDialog(null, "Admin zara, oso ondo");
					menua.setVisible(true);
					LangileakGehitu.this.setVisible(false);
			
			
			}
		});
		atzera.setBounds(10, 232, 85, 21);
		contentPane.add(atzera);
	}
}
