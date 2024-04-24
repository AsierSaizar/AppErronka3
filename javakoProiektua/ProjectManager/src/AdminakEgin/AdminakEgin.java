package AdminakEgin;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Menua.Menua;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import ControlAdminakEgin.ControlAdminakEgin;


public class AdminakEgin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton adminLangile;
	private ControlAdminakEgin controlAdminEgin = new ControlAdminakEgin();
	private JButton btnNewButton;
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
        
        adminLangile = new JButton("Admin/Langile bihurtu");
        adminLangile.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int row = table.getSelectedRow();
        		try {
					controlAdminEgin.retrieveAndProcessRowData(row, table);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
        	}
        });
        adminLangile.setBounds(304, 87, 180, 38);
        contentPane.add(adminLangile);
        
        btnNewButton = new JButton("Atzera");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

				menua.setVisible(true);
				AdminakEgin.this.setVisible(false);
        	}
        });
        btnNewButton.setBounds(89, 305, 112, 26);
        contentPane.add(btnNewButton);

        // Mostrar la ventana
        AdminakEgin.this.setVisible(true);
	}
}
