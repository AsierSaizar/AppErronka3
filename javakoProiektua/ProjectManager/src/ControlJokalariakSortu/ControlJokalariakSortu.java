package ControlJokalariakSortu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Conexioa.Conexioa;

public class ControlJokalariakSortu {

	public static void taulaErakutsi(JTable taula) throws SQLException {
		// Hemen exekutatu SELECT kontsulta datu basean
        // Erabiltzaile zerrenda datu baseatik lortu eta erakutsi
		DefaultTableModel table = new DefaultTableModel();
		

  	   	table.addColumn("id");
  	   	table.addColumn("izen");
  	   	table.addColumn("abizen");
  	   	table.addColumn("posizioa");
  	   	table.addColumn("puntuazioa");
  	   	table.addColumn("taldea");
  	   	table.addColumn("herrialdea");
  	   	table.addColumn("prezioa");
		try (Connection conexioa = (Connection) DriverManager.getConnection(Conexioa.DB_URL, Conexioa.DB_USER, Conexioa.DB_PASSWORD)) {

	    	try 
	    	{
	    	    Statement stat= conexioa.createStatement(); 
	    	    ResultSet res=stat.executeQuery("select * from erronka3.jokalariak;");
	    	    ResultSetMetaData rsmd = res.getMetaData();
	     	    
	    	 
	    	   String[] array = new String[10];
	    	    
	    	   taula.setModel(table);
	    	   try {
	    			while(res.next())
	    			{
	    				int i=0;
	    				while(i < 8) {	
	    			    array[i] = res.getString(i + 1);
	    			    i++;
	    				}
	    				table.addRow(array);
	    			}
	    		} catch (SQLException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    	    taula.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    	    
	    	}
	    	catch(Exception ex)
	    	{       
	    	    System.out.println(ex);
	    	}
	   
    	    	
		}
		
	}
	
}
