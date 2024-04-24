package ControlSarrera;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


import Conexioa.Conexioa;
import Erabiltzaileak.Erabiltzaileak;
import Langileak.Langileak;

public class ControlSarrera {
	
	public Erabiltzaileak erabiltzaileaSartu(String nan, String pasahitza, int proiektua) throws SQLException {

		// TODO Auto-generated method stub	
			try (Connection conexioa = (Connection) DriverManager.getConnection(Conexioa.DB_URL, Conexioa.DB_USER, Conexioa.DB_PASSWORD)) {
		        
		        if (conexioa != null) {
		        	ArrayList<Langileak> erabiltzaileak = Erabiltzaileak.langileakLortu(conexioa); 
		        	return Erabiltzaileak.zerDa(erabiltzaileak, nan, pasahitza, proiektua);   
		        }else {
		        	return null;
		        }
			} 
	}
}


