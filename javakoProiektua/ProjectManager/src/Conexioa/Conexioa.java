package Conexioa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexioa {
	
	public static final String DB_URL = "jdbc:mysql://192.168.15.35:3306/erronka3";
    public static final String DB_USER = "2taldea";
    public static final String DB_PASSWORD = "2taldea@";
    
    //public static final String DB_URL = "jdbc:mysql://localhost:3306/erronka3";
    //public static final String DB_USER = "root";
    //public static final String DB_PASSWORD = "1WMG2023";

    
	public static Connection dbConexioa() throws SQLException {
	   
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}
}
