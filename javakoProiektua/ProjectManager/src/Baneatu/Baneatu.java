package Baneatu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ControlBaneatu.ControlBaneatu;
import Menua.Menua;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
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
	    taulaIkusiBtn.setBounds(26, 304, 176, 48);
	    contentPane.add(taulaIkusiBtn);
	    
	    JButton BaneatzekoBtn = new JButton("Baneatu/Desbaneatu");
	    BaneatzekoBtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int row = table.getSelectedRow();
	    		retrieveAndProcessRowData(row);
	    		
	    	}
	    });
	    BaneatzekoBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
	    BaneatzekoBtn.setBounds(261, 304, 176, 48);
	    contentPane.add(BaneatzekoBtn);
	}

	private void retrieveAndProcessRowData(int row) {
	    String rowId = table.getModel().getValueAt(row, 0).toString();
	    String rowEzizena = table.getModel().getValueAt(row, 1).toString();
	    String rowEmaila = table.getModel().getValueAt(row, 2).toString();
	    String rowPasahitza = table.getModel().getValueAt(row, 3).toString();
	    String rowDirua = table.getModel().getValueAt(row, 4).toString();
	    String rowBan = table.getModel().getValueAt(row, 5).toString();
	    int dirua = Integer.valueOf(rowDirua);
	    boolean ban = Boolean.parseBoolean(rowBan);
	    
	    controlBaneatu.baneatu(rowId,rowEzizena,rowEmaila,rowPasahitza,dirua,ban);
	}

}
