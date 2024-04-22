package Langileak;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Conexioa.Conexioa;
import Erabiltzaileak.Erabiltzaileak;

public class Langileak extends Erabiltzaileak {
	private String lanPostua;

	public Langileak(String nan, String pasahitza, int proiektua, String lanPostua, String izena, String abizena) {
		super(nan, pasahitza, proiektua, izena, abizena);
		this.lanPostua = lanPostua;
	}

	public String getLanPostua() {
		return lanPostua;
	}

	public void setLanPostua(String lanPostua) {
		this.lanPostua = lanPostua;
	}

	public void save() throws SQLException{
		// TODO Auto-generated method stub
		String sql = "INSERT INTO erronka3.langileak (nan, pasahitza, izena, abizenak, lanPostua, proiektua) VALUES (?,?, ?, ?, ?, ?)";

	    try (Connection conexion = DriverManager.getConnection(Conexioa.DB_URL, Conexioa.DB_USER, Conexioa.DB_PASSWORD);
	         PreparedStatement stmt = conexion.prepareStatement(sql)) {

	        stmt.setString(1, this.getNan()); 
	        stmt.setString(2, this.getPasahitza());
	        stmt.setString(3, this.getIzena());  
	        stmt.setString(4, this.getAbizena());  
	        stmt.setString(5, "Langilea"); 
	        stmt.setInt(6, this.getProiektua());

	        // Ejecutar la inserción
	        int afected = stmt.executeUpdate();
	        if (afected > 0) {
	            System.out.println("Ondo sartu da!");
	        }
	    } catch (SQLException e) {
	        System.out.println("Errore bat dago");
	        e.printStackTrace();
	        throw e;
	    }
	}
	
	

	
	
	
 }

