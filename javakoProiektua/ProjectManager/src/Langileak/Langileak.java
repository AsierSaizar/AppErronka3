package Langileak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


import Conexioa.Conexioa;

public class Langileak {
	private String nan;
	private String pasahitza;
	int proiektua;
	private String lanPostua;
	
	public Langileak(String nan, String pasahitza, int proiektua, String lanPostua) {
		super();
		this.setNan(nan);
		this.setPasahitza(pasahitza);
		this.proiektua = proiektua;
		this.setLanPostua(lanPostua);
	}

	public String getNan() {
		return nan;
	}

	public void setNan(String nan) {
		this.nan = nan;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public String getLanPostua() {
		return lanPostua;
	}

	public int getProiektua() {
		return proiektua;
	}

	public void setProiektua(int proiektua) {
		this.proiektua = proiektua;
	}

	public void setLanPostua(String lanPostua) {
		this.lanPostua = lanPostua;
	}

	public static int existitzenDa(String nan, String pasahitza, int proiektua) {
		// TODO Auto-generated method stub
		
		try (Connection conexioa = (Connection) DriverManager.getConnection(Conexioa.DB_URL, Conexioa.DB_USER, Conexioa.DB_PASSWORD)) {
			        
			        if (conexioa != null) {
			           
			            Statement stat=conexioa.createStatement();   
			            ResultSet res=stat.executeQuery("select * from langileak;");
			     
			            String[] array = new String[4];
			           
			            try {
			                while(res.next()) {
			                    array[0] = res.getString(1 + 1);
			                    array[1] = res.getString(2 + 1);
			                    array[2] = res.getString(5 + 1);
			                    array[3] = res.getString(6 + 1);
			                    int proiektu = Integer.parseInt(array[3]);
			                
			                    if(nan.equals(array[0]) && pasahitza.equals(array[1]) && array[2].equals("Administratzailea") && proiektu == proiektua) {
			                        System.out.println("Baimena");                  
			                        return 1;  
			                    } else if(nan.equals(array[0]) && pasahitza.equals(array[1]) && array[2].equals("Langilea") && proiektu == proiektua) {
			                        System.out.println("Baimen gabea");
			                        return 0;
			                    }
			                    else {
			                    	JOptionPane.showMessageDialog(null, "Berriro saiatu, gaizki sartu duzu informazioa");
			                    }
			                }
			                return 2;
			            } catch (SQLException e) {
			            	JOptionPane.showMessageDialog(null, "Berriro saiatu, gaizki sartu duzu informazioa");
			                
			            }
			        }
			    } catch (SQLException e) {
			    	JOptionPane.showMessageDialog(null, "Berriro saiatu, gaizki sartu duzu informazioa");
			    }
		return 2;
			}	
    }

