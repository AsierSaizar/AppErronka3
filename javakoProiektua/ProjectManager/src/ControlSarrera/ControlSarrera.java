package ControlSarrera;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Administratzailea.Administratzailea;
import Conexioa.Conexioa;
import Erabiltzaileak.Erabiltzaileak;
import Langileak.Langileak;

public class ControlSarrera {
	
	public Erabiltzaileak erabiltzaileaSartu(String nan, String pasahitza, int proiektua) {
		// TODO Auto-generated method stub	
			try (Connection conexioa = (Connection) DriverManager.getConnection(Conexioa.DB_URL, Conexioa.DB_USER, Conexioa.DB_PASSWORD)) {
		        
		        if (conexioa != null) {
		           
		            Statement stat=conexioa.createStatement();   
		            ResultSet res=stat.executeQuery("select * from erronka3.langileak;");
		     
		            String[] array = new String[4];
		           
		            try {
		                while(res.next()) {
		                    array[0] = res.getString(2);
		                    array[1] = res.getString(3);
		                    array[2] = res.getString(6);
		                    array[3] = res.getString(7);
		                    int proiektu = Integer.parseInt(array[3]);
		                
		                    if(nan.equals(array[0]) && pasahitza.equals(array[1]) && array[2].equals("Admin") && proiektu == proiektua) {
		                    	Administratzailea admin = new Administratzailea(nan, pasahitza, proiektua, "Admin");
		                    	System.out.println("Administratzailea");
		            			return admin;
		                    } else if(nan.equals(array[0]) && pasahitza.equals(array[1]) && array[2].equals("Langilea") && proiektu == proiektua) {
		                    	Langileak langilea = new Langileak(nan, pasahitza, proiektua, "Langilea");
		                    	System.out.println("Langilea");
		                        return langilea;
		                    }
		                    else {
		                    	JOptionPane.showMessageDialog(null, "Gaizki sartu duzu informazioa");
		                    }
		                }
		              
		            } catch (SQLException e) {
		            	JOptionPane.showMessageDialog(null, "Berriro saiatu");
		                
		            }
		        }
		    } catch (SQLException e) {
		    	JOptionPane.showMessageDialog(null, "Conexio gaizki egin du");
		    }
			return null;

			}
}

