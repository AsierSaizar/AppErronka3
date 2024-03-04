package Langileak;


import java.sql.Connection;
import Conexioa.Conexioa;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class Langileak {
	String nan;
	String pasahitza;
	int proiektua;
	String lanPostua;
	
	public Langileak(String nan, String pasahitza, int proiektua) {
		super();
		this.nan = nan;
		this.pasahitza = pasahitza;
		this.proiektua = proiektua;
		this.lanPostua = null;
	}
	
	
	
	public void existitzenDa(Langileak langilea) {
	    // TODO Auto-generated method stub
	    try (Connection conexioa = (Connection) DriverManager.getConnection(Conexioa.DB_URL, Conexioa.DB_USER, Conexioa.DB_PASSWORD)) {
	        
	        if (conexioa != null) {
	           
	            Statement stat=conexioa.createStatement();   
	            ResultSet res=stat.executeQuery("select * from langileak;");
	     
	            DefaultTableModel taula = new DefaultTableModel();
	            taula.addColumn("Id");
	            taula.addColumn("nan");
	            taula.addColumn("pasahitza");
	            taula.addColumn("izena");
	            taula.addColumn("abizenak");
	            taula.addColumn("lanPostua");
	            taula.addColumn("proiektua");
	    
	            String[] array = new String[3];
	            
	            try {
	                while(res.next()) {
	                    array[0] = res.getString(1 + 1);
	                    array[1] = res.getString(2 + 1);
	                    array[2] = res.getString(5 + 1);
	                
	                    if(langilea.nan.equals(array[0]) && langilea.pasahitza.equals(array[1]) && array[2].equals("Administratzailea")) {
	                        System.out.println("Baimena");
	                               
	                        langilea.lanPostua = "Administratzailea";
	                        break;  
	                    } else if(langilea.nan.equals(array[0]) && langilea.pasahitza.equals(array[1]) && array[2].equals("Langilea")) {
	                        System.out.println("Baimen gabea");
	                        break;
	                    }
	                    else {
	                    	JOptionPane.showMessageDialog(null, "Berriro saiatu, gaizki sartu duzu informazioa");
	                    }
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}

