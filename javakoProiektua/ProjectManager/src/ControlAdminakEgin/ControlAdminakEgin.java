package ControlAdminakEgin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Conexioa.Conexioa;
import Erabiltzaileak.Erabiltzaileak;
import Langileak.Langileak;

public class ControlAdminakEgin {

	
	public void erabiltzaileZerrendaErakutsi(JTable taula) throws SQLException {
        // Hemen exekutatu SELECT kontsulta datu basean
        // Erabiltzaile zerrenda datu baseatik lortu eta erakutsi
		DefaultTableModel table = new DefaultTableModel();
		

  	   	table.addColumn("nan");
  	   	table.addColumn("izena");
  	   	table.addColumn("abizena");
  	   	table.addColumn("lanPostua");
  	   	table.addColumn("proiektua");
		try (Connection conexioa = (Connection) DriverManager.getConnection(Conexioa.DB_URL, Conexioa.DB_USER, Conexioa.DB_PASSWORD)) {

	    	
	    		if (conexioa != null) {
		        	ArrayList<Langileak> erabiltzaileak = Erabiltzaileak.langileakLortu(conexioa); 
		        	taula.setModel(table);
			    	  
			    		   for (Langileak erabiltzailea : erabiltzaileak){
			    			   
			    		   String array[] = new String[5];
			    		
			    			    array[0] = erabiltzailea.getNan();
			    			    array[1] = erabiltzailea.getIzena();
			    			    array[2] = erabiltzailea.getAbizena();
			    			    array[3] = erabiltzailea.getLanPostua();
			    			    array[4] = String.valueOf(erabiltzailea.getProiektua());
			    			   
			    				table.addRow(array);
			    			}
	    		}
		      
	    	 
	    	
	    	    
	    	   
	    		
	    	    taula.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	         
		}
	}

	public void adminBihurtu() {
		// TODO Auto-generated method stub
		
	}
}
