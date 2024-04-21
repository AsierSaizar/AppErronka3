package ControlMenua;

import Administratzailea.Administratzailea;
import Erabiltzaileak.Erabiltzaileak;

public class ControlMenua {

	public static int adminDa(Erabiltzaileak erabiltzailea) {
		// TODO Auto-generated method stub
		int erantzuna = 0; 
		if(erabiltzailea instanceof Administratzailea) {
			erantzuna = 1;
		}
		else {
			erantzuna = 0;
		}
		return erantzuna;
	}

}
