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
}

