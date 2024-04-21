package Langileak;


import Erabiltzaileak.Erabiltzaileak;

public class Langileak extends Erabiltzaileak {
	private String lanPostua;

	public Langileak(String nan, String pasahitza, int proiektua, String lanPostua) {
		super(nan, pasahitza, proiektua);
		this.lanPostua = lanPostua;
	}

	public String getLanPostua() {
		return lanPostua;
	}

	public void setLanPostua(String lanPostua) {
		this.lanPostua = lanPostua;
	}
	
	

	
	
	
 }

