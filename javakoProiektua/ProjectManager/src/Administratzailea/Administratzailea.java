package Administratzailea;
import Erabiltzaileak.Erabiltzaileak;
public class Administratzailea extends Erabiltzaileak {
	


	public Administratzailea(String nan, String pasahitza, int proiektua, String lanPostua) {
		super(nan, pasahitza, proiektua);
		this.lanPostua = lanPostua;
	}

	public String getLanPostua() {
		return lanPostua;
	}
	
	public void setLanPostua(String lanPostua) {
		this.lanPostua = lanPostua;
	}

	private String lanPostua;

}
