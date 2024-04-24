package Erabiltzaileak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import Langileak.Langileak;
import Administratzailea.Administratzailea;

public abstract class Erabiltzaileak  {
	private String nan;
	private String pasahitza;
	private String izena;
	private String abizena;
	int proiektua;
	
	public String getNan() {
		return nan;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getAbizena() {
		return abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
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

	public int getProiektua() {
		return proiektua;
	}

	public void setProiektua(int proiektua) {
		this.proiektua = proiektua;
	}

	public Erabiltzaileak(String nan, String pasahitza, int proiektua, String izena, String abizena) {
		super();
		this.nan = nan;
		this.pasahitza = pasahitza;
		this.proiektua = proiektua;
		this.izena = izena;
		this.abizena = abizena;
	}

	public static ArrayList<Langileak> langileakLortu(Connection conexioa) throws SQLException {
		ArrayList<Langileak> erabiltzialeak = new ArrayList<>();
		
		
		Statement stat=conexioa.createStatement();   
        ResultSet res=stat.executeQuery("select * from erronka3.langileak;");
 
       
       
       
            while(res.next()) {
            	 String nan = res.getString(2); //nan
                 String pasahitza = res.getString(3); //pasahitza
                 String izena = res.getString(4); //izena
                 String abizena = res.getString(5); //abizena
                 String lanPostua = res.getString(6); //lanPostua
                 int proiektua = res.getInt(7); //proiektua
                 
                Langileak langilea = new Langileak(nan, pasahitza, proiektua, lanPostua, izena, abizena);
                erabiltzialeak.add(langilea);
  
            }
        
		return erabiltzialeak;
	}

	public static Erabiltzaileak zerDa(ArrayList<Langileak> erabiltzaileak, String nan, String pasahitza, int proiektua) {
		// TODO Auto-generated method stub
		for (Langileak erabiltzailea : erabiltzaileak) {
            if(erabiltzailea.getNan().equals(nan)&& erabiltzailea.getPasahitza().equals(pasahitza) && erabiltzailea.getLanPostua().equals("Admin") && erabiltzailea.getProiektua() == proiektua) {
            	Administratzailea admin = new Administratzailea(nan, pasahitza, proiektua, "Admin", erabiltzailea.getIzena(), erabiltzailea.getAbizena());
            	System.out.println("Administratzailea");
    			return admin;
            } else if(erabiltzailea.getNan().equals(nan)&& erabiltzailea.getPasahitza().equals(pasahitza) && erabiltzailea.getLanPostua().equals("Langilea") && erabiltzailea.getProiektua() == proiektua) {
            	Langileak langilea = new Langileak(nan, pasahitza, proiektua, "Langilea", erabiltzailea.getIzena(), erabiltzailea.getAbizena());
            	System.out.println("Langilea");
                return langilea;
            }
          
		}
		return null;  
	}
}


