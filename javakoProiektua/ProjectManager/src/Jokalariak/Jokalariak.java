package Jokalariak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Conexioa.Conexioa;

public class Jokalariak {

	private String izen;
	public String getIzen() {
		return izen;
	}

	public void setIzen(String izen) {
		this.izen = izen;
	}

	public String getAbizen() {
		return abizen;
	}

	public void setAbizen(String abizen) {
		this.abizen = abizen;
	}

	public String getPosizioa() {
		return posizioa;
	}

	public void setPosizioa(String posizioa) {
		this.posizioa = posizioa;
	}

	public String getPuntuazioa() {
		return puntuazioa;
	}

	public void setPuntuazioa(String puntuazioa) {
		this.puntuazioa = puntuazioa;
	}

	public String getTaldea() {
		return taldea;
	}

	public void setTaldea(String taldea) {
		this.taldea = taldea;
	}

	public String getHerrialdea() {
		return herrialdea;
	}

	public void setHerrialdea(String herrialdea) {
		this.herrialdea = herrialdea;
	}

	public String getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(String prezioa) {
		this.prezioa = prezioa;
	}

	private String abizen;
	private String posizioa;
	private String puntuazioa;
	private String taldea;
	private String herrialdea;
	private String prezioa;

	

	public Jokalariak(String izen, String abizen, String posizioa, String puntuazioa, String taldea, String herrialdea,
			String prezioa) {
		super();
		this.izen = izen;
		this.abizen = abizen;
		this.posizioa = posizioa;
		this.puntuazioa = puntuazioa;
		this.taldea = taldea;
		this.herrialdea = herrialdea;
		this.prezioa = prezioa;
	}

	public void save() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO erronka3.jokalariak (izen, abizen, posizioa, puntuazioa, taldea, herrialdea, prezioa) VALUES (?, ?, ?, ?, ?, ?, ?)";

	    try (Connection conexion = DriverManager.getConnection(Conexioa.DB_URL, Conexioa.DB_USER, Conexioa.DB_PASSWORD);
	         PreparedStatement stmt = conexion.prepareStatement(sql)) {

	        stmt.setString(1, this.getIzen()); 
	        stmt.setString(2, this.getAbizen());
	        stmt.setString(3, this.getPosizioa());  
	        stmt.setString(4, this.getPuntuazioa());  
	        stmt.setString(5, this.getTaldea()); 
	        stmt.setString(6, this.getHerrialdea());
	        stmt.setString(7, this.getPrezioa());
System.out.println(sql);
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
