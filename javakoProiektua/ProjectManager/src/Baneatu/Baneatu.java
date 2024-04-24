package Baneatu;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlBaneatu.ControlBaneatu;
import Menua.Menua;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Baneatu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ControlBaneatu controlBaneatu = new ControlBaneatu();

	

	/**
	 * Create the frame.
	 * @param menua 
	 */
	public Baneatu(Menua menua) {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 599, 416);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(26, 25, 536, 269);
	    contentPane.add(scrollPane);
	    
	    table = new JTable();
	    scrollPane.setViewportView(table);
	    
	    
	    
	    JButton taulaIkusiBtn = new JButton("Taula ikusi");
	    taulaIkusiBtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
					controlBaneatu.taulaErakutsi(table);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
	    	}
	    });
	    taulaIkusiBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    taulaIkusiBtn.setBounds(150, 304, 176, 48);
	    contentPane.add(taulaIkusiBtn);
	    
	    JButton BaneatzekoBtn = new JButton("Baneatu/Desbaneatu");
	    BaneatzekoBtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int row = table.getSelectedRow();
				try {
					controlBaneatu.retrieveAndProcessRowData(row, table);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		
	    	}
	    });
	    BaneatzekoBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
	    BaneatzekoBtn.setBounds(371, 304, 176, 48);
	    contentPane.add(BaneatzekoBtn);
	    
	    JButton btnNewButton = new JButton("Atzera");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				menua.setVisible(true);
				Baneatu.this.setVisible(false);
	    	}
	    });
	    btnNewButton.setBounds(26, 320, 85, 21);
	    contentPane.add(btnNewButton);
	}
}
