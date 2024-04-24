package ControlLangileakKontratatu;


import java.sql.SQLException;




import Administratzailea.Administratzailea;

import Langileak.Langileak;

public class ControlLangileakKontratatu {

	public static void kontratatu(String nan, String pasahitza, String izena, String abizena, String lanPostua, int proiektua) throws SQLException {
		// TODO Auto-generated method stub
		if(lanPostua == "Admin") {
			Administratzailea a = new Administratzailea(nan, pasahitza, proiektua,lanPostua, izena, abizena);
			a.save();
		}else {
			Langileak l = new Langileak(nan, pasahitza, proiektua, lanPostua, izena, abizena);
			l.save();
		}
		
	}

}
