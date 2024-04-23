package WebErabiltzaileak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Conexioa.Conexioa;

public class WebErabiltzaileak {
	private String ezizena;
	private String emaila;
	private String pasahitza;
	private int dirua;
	private boolean baneado;
	
	
	
	public WebErabiltzaileak(String ezizena, String emaila, String pasahitza, int dirua, boolean baneado) {
		super();
		this.ezizena = ezizena;
		this.emaila = emaila;
		this.pasahitza = pasahitza;
		this.dirua = dirua;
		this.baneado = baneado;
	}
	
	
	public String getEzizena() {
		return ezizena;
	}
	public void setEzizena(String ezizena) {
		this.ezizena = ezizena;
	}
	public String getEmaila() {
		return emaila;
	}
	public void setEmaila(String emaila) {
		this.emaila = emaila;
	}
	public String getPasahitza() {
		return pasahitza;
	}
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}
	public int getDirua() {
		return dirua;
	}
	public void setDirua(int dirua) {
		this.dirua = dirua;
	}
	public boolean isBaneado() {
		return baneado;
	}
	public void setBaneado(boolean baneado) {
		this.baneado = baneado;
	}


	public void baneatu() {
		// TODO Auto-generated method stub
		this.baneado = true;
	}


	public void desBaneatu() {
		// TODO Auto-generated method stub
		this.baneado = false;
		
	}


	public void update() throws SQLException {
		// TODO Auto-generated method stub
				String sql = "UPDATE erronka3.weberabiltzaileak SET baneado = ? WHERE ezizena = ?";

				try (Connection conexion = DriverManager.getConnection(Conexioa.DB_URL, Conexioa.DB_USER, Conexioa.DB_PASSWORD);
				     PreparedStatement stmt = conexion.prepareStatement(sql)) {
				    
				    // Establecer los parámetros del PreparedStatement
				    stmt.setBoolean(1, this.baneado); // Asume que 'nan' es un campo de texto, ajusta si es numérico
				    stmt.setString(2, this.ezizena); // Asume que 'lanPostua' es un campo de texto

				    // Ejecutar la actualización
				    int affectedRows = stmt.executeUpdate();
				    System.out.println("Filas afectadas: " + affectedRows);
				    conexion.close();
				    
				} catch (SQLException e) {
				    System.out.println("Errore bat dago");
				    e.printStackTrace();
				    throw e; // Re-lanzar la excepción puede estar bien dependiendo del contexto de manejo de errores
				}
		
	}
	
	
	
}
