package AdminakEgin;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Menua.Menua;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import ControlAdminakEgin.ControlAdminakEgin;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class AdminakEgin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private ControlAdminakEgin controlAdminEgin = new ControlAdminakEgin();
	/**
	 * Create the frame.
	 * @param menua 
	 */
	public AdminakEgin(Menua menua) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(25, 29, 257, 193);
		contentPane.add(table);
		
		JButton taulaIkusi = new JButton("Taula ikusi");
		taulaIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					controlAdminEgin.erabiltzaileZerrendaErakutsi(table);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		taulaIkusi.setBounds(50, 228, 151, 21);
		contentPane.add(taulaIkusi);
		
		// Envolver el JTable en un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 25, 223, 188);

        // Configurar el JScrollPane (Opcional)
       
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Añadir el JScrollPane al JFrame
        getContentPane().add(scrollPane);
        
        textField = new JTextField();
        textField.setBounds(322, 47, 162, 19);
        contentPane.add(textField);
        textField.setColumns(10);
        
        lblNewLabel = new JLabel("NAN:");
        lblNewLabel.setBounds(283, 50, 45, 13);
        contentPane.add(lblNewLabel);
        
        btnNewButton = new JButton("Admin bihurtu");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controlAdminEgin.adminBihurtu();
        	}
        });
        btnNewButton.setBounds(304, 87, 151, 38);
        contentPane.add(btnNewButton);
        
        btnNewButton_1 = new JButton("Langile bihurtu");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_1.setBounds(304, 135, 151, 38);
        contentPane.add(btnNewButton_1);

        // Mostrar la ventana
        AdminakEgin.this.setVisible(true);
	}
}
