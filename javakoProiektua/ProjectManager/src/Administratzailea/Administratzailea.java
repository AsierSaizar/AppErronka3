package Administratzailea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;


import Conexioa.Conexioa;
import Erabiltzaileak.Erabiltzaileak;
public class Administratzailea extends Erabiltzaileak {
	


	public Administratzailea(String nan, String pasahitza, int proiektua, String lanPostua, String izena, String abizena) {
		super(nan, pasahitza, proiektua, izena, abizena);
		this.lanPostua = lanPostua;
	}

	public String getLanPostua() {
		return lanPostua;
	}
	
	public void setLanPostua(String lanPostua) {
		this.lanPostua = lanPostua;
	}

	private String lanPostua;

	public void save() throws SQLException {
	    String sql = "INSERT INTO erronka3.langileak (nan, pasahitza, izena, abizenak, lanPostua, proiektua) VALUES (?,?, ?, ?, ?, ?)";

	    try (Connection conexion = DriverManager.getConnection(Conexioa.DB_URL, Conexioa.DB_USER, Conexioa.DB_PASSWORD);
	         PreparedStatement stmt = conexion.prepareStatement(sql)) {

	        stmt.setString(1, this.getNan()); 
	        stmt.setString(2, this.getPasahitza());
	        stmt.setString(3, this.getIzena());  
	        stmt.setString(4, this.getAbizena());  
	        stmt.setString(5, "Admin"); 
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

	public void langileBihurtu() {
		// TODO Auto-generated method stub
		this.lanPostua = "Langilea";	
	}

	public void update() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE erronka3.langileak SET lanPostua = ? WHERE nan = ?";

		try (Connection conexion = DriverManager.getConnection(Conexioa.DB_URL, Conexioa.DB_USER, Conexioa.DB_PASSWORD);
		     PreparedStatement stmt = conexion.prepareStatement(sql)) {
		    
		    // Establecer los parámetros del PreparedStatement
		    stmt.setString(1, "Langilea"); // Asume que 'lanPostua' es un campo de texto
		    stmt.setString(2, this.getNan()); // Asume que 'nan' es un campo de texto, ajusta si es numérico

		    // Ejecutar la actualización
		    int affectedRows = stmt.executeUpdate();
		    System.out.println("Filas afectadas: " + affectedRows);
		    
		} catch (SQLException e) {
		    System.out.println("Errore bat dago");
		    e.printStackTrace();
		    throw e; // Re-lanzar la excepción puede estar bien dependiendo del contexto de manejo de errores
		}
	}

}
