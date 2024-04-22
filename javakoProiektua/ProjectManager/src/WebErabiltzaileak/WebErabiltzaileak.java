package WebErabiltzaileak;

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
	
	
	
}
