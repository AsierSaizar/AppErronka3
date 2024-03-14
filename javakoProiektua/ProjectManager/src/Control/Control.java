package Control;



import javax.swing.JOptionPane;

import Langileak.Langileak;

public class Control {

	public Control() {
		
	}
	
	public Langileak erabiltzaileaSortu(String nan, String pasahitza, int proiektua) {
		// TODO Auto-generated method stub
		int mota = Langileak.existitzenDa(nan, pasahitza, proiektua);
		if(mota == 1) {
			Langileak langilea = new Langileak(nan, pasahitza, proiektua, "administratzailea");
			return langilea;
		}
		else if(mota == 0) {
			Langileak langilea = new Langileak(nan, pasahitza, proiektua, "langilea");
			return langilea;
		} else{
			JOptionPane.showMessageDialog(null, "Berriro saiatu, gaizki sartu duzu informazioa");
			return null;
		}
		
	}
}

