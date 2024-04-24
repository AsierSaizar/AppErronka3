package ControlBaneatu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Conexioa.Conexioa;
import WebErabiltzaileak.WebErabiltzaileak;

public class ControlBaneatu {

	public void taulaErakutsi(JTable taula) throws SQLException {
        // Hemen exekutatu SELECT kontsulta datu basean
        // Erabiltzaile zerrenda datu baseatik lortu eta erakutsi
		DefaultTableModel table = new DefaultTableModel();
		

  	   	table.addColumn("id");
  	   	table.addColumn("ezizena");
  	   	table.addColumn("emaila");
  	   	table.addColumn("pasahitza");
  	   	table.addColumn("dirua");
  	   	table.addColumn("baneado");
		try (Connection conexioa = (Connection) DriverManager.getConnection(Conexioa.DB_URL, Conexioa.DB_USER, Conexioa.DB_PASSWORD)) {

	    	try 
	    	{
	    	    Statement stat= conexioa.createStatement(); 
	    	    ResultSet res=stat.executeQuery("select * from erronka3.weberabiltzaileak;");
	     	    
	    	 
	    	   String[] array = new String[10];
	    	    
	    	   taula.setModel(table);
	    	   try {
	    			while(res.next())
	    			{
	    				int i=0;
	    				while(i < 6) {	
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

	public void baneatu(String id, String ezizena, String emaila, String pasahitza, int dirua, boolean ban) throws SQLException {
		System.out.println(ban);
		if (ban==false) {
			System.out.println("baneatu gabeee");
			WebErabiltzaileak e0 = new WebErabiltzaileak(ezizena, emaila, pasahitza, dirua, ban);
			e0.baneatu();
			e0.update();
			
			
		}else{
			System.out.println("baneatutaaaaaaa");
			WebErabiltzaileak e1 = new WebErabiltzaileak(ezizena, emaila, pasahitza, dirua, ban);
			e1.desBaneatu();
			e1.update();
			
		}
		
	}
	
	public void retrieveAndProcessRowData(int row, JTable table) throws SQLException {
	    String rowId = table.getModel().getValueAt(row, 0).toString();
	    String rowEzizena = table.getModel().getValueAt(row, 1).toString();
	    String rowEmaila = table.getModel().getValueAt(row, 2).toString();
	    String rowPasahitza = table.getModel().getValueAt(row, 3).toString();
	    String rowDirua = table.getModel().getValueAt(row, 4).toString();
	    String rowBan = table.getModel().getValueAt(row, 5).toString();
	    
	    System.out.println(rowBan);
	    
	    int dirua = Integer.valueOf(rowDirua);
	    boolean ban = false;
	    if (rowBan.equals("1")) {
	    	System.out.println("aaaaaaaaaaaaaaaaa");
	    	ban = true;
	    	this.baneatu(rowId,rowEzizena,rowEmaila,rowPasahitza,dirua,ban);
	    }else if (rowBan.equals("0")){
	    	System.out.println("bbbbbbbbbbbbbbbbb");
	    	ban = false;
	    	this.baneatu(rowId,rowEzizena,rowEmaila,rowPasahitza,dirua,ban);
	    }
	    
	    
	    
	    
	    }
	}
	

