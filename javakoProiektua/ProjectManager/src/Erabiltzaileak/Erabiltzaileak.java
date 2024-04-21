package Erabiltzaileak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Conexioa.Conexioa;
import Langileak.Langileak;
import Administratzailea.Administratzailea;

public abstract class Erabiltzaileak  {
	private String nan;
	private String pasahitza;
	int proiektua;
	
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

	public int getProiektua() {
		return proiektua;
	}

	public void setProiektua(int proiektua) {
		this.proiektua = proiektua;
	}

	public Erabiltzaileak(String nan, String pasahitza, int proiektua) {
		super();
		this.nan = nan;
		this.pasahitza = pasahitza;
		this.proiektua = proiektua;
	}	
}

