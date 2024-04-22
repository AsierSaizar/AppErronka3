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

import Administratzailea.Administratzailea;
import Conexioa.Conexioa;
import Erabiltzaileak.Erabiltzaileak;
import Langileak.Langileak;

public class ControlAdminakEgin {

	
	public void erabiltzaileZerrendaErakutsi(JTable taula) throws SQLException {
        // Hemen exekutatu SELECT kontsulta datu basean
        // Erabiltzaile zerrenda datu baseatik lortu eta erakutsi
		DefaultTableModel table = new DefaultTableModel();
		

  	   	table.addColumn("nan");
  	   	table.addColumn("pasahitza");
  	   	table.addColumn("izena");
  	   	table.addColumn("abizena");
  	   	table.addColumn("lanPostua");
  	   	table.addColumn("proiektua");
		try (Connection conexioa = (Connection) DriverManager.getConnection(Conexioa.DB_URL, Conexioa.DB_USER, Conexioa.DB_PASSWORD)) {

	    	
	    		if (conexioa != null) {
		        	ArrayList<Langileak> erabiltzaileak = Erabiltzaileak.langileakLortu(conexioa); 
		        	taula.setModel(table);
			    	  
			    		   for (Langileak erabiltzailea : erabiltzaileak){
			    			   
			    		   String array[] = new String[6];
			    		
			    			    array[0] = erabiltzailea.getNan();
			    			    array[1] = erabiltzailea.getPasahitza();
			    			    array[2] = erabiltzailea.getIzena();
			    			    array[3] = erabiltzailea.getAbizena();
			    			    array[4] = erabiltzailea.getLanPostua();
			    			    array[5] = String.valueOf(erabiltzailea.getProiektua());
			    			   
			    				table.addRow(array);
			    			}
	    		}
		      
	    	 
	    	
	    	    
	    	   
	    		
	    	    taula.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	         
		}
	}

	public void adminBihurtu() {
		// TODO Auto-generated method stub
		
	}

	public void adminLangileBihurtu( String rowNan,String rowPasahitza, String rowIzena,
			String rowAbizena, String rowLanPostua, int proiektua) throws SQLException {
		// TODO Auto-generated method stub
		if(rowLanPostua.equals("Admin")) {
			System.out.println("admiiiin");
			Administratzailea a = new Administratzailea(rowNan,rowPasahitza,proiektua,rowLanPostua,rowIzena,rowAbizena);
			a.langileBihurtu();
			a.update();
			
		}else if(rowLanPostua.equals("Langilea")) {
			System.out.println("Langileeeea");
			Langileak l = new Langileak(rowNan,rowPasahitza,proiektua,rowLanPostua,rowIzena,rowAbizena);
			l.adminBihurtu();
			l.update();
		}
		
	}

	public void retrieveAndProcessRowData(int row, JTable table) throws SQLException {
		// TODO Auto-generated method stub
		
		    String rowNan = table.getModel().getValueAt(row, 0).toString();
		    String rowPasahitza = table.getModel().getValueAt(row, 1).toString();
		    String rowIzena = table.getModel().getValueAt(row, 2).toString();
		    String rowAbizena = table.getModel().getValueAt(row, 3).toString();
		    String rowLanPostua = table.getModel().getValueAt(row, 4).toString();
		    String rowProiektua = table.getModel().getValueAt(row, 5).toString();
		    int proiektua = Integer.valueOf(rowProiektua);
		    
		    this.adminLangileBihurtu(rowNan,rowPasahitza,rowIzena,rowAbizena,rowLanPostua,proiektua);
		
	}
}
