package sk.euba.fhi.tajj.jdbc.domain;

/**
 * Created by Igor Banduric.
 */

public class Clen {

	private String cislo_clena;
	private String meno_clena;
	private String ulica_clena;
	private String mesto_clena;
	private String psc_clena;
	private String mesacny_clensky_poplatok;

	public Clen( String cislo_clena, String meno_clena,String ulica_clena, String mesto_clena, String psc_clena, String mesacny_clensky_poplatok) {
		this.cislo_clena = cislo_clena;
		this.meno_clena = meno_clena;
		this.ulica_clena = ulica_clena;
		this.mesto_clena = mesto_clena;
		this.psc_clena = psc_clena;
        this.mesacny_clensky_poplatok = mesacny_clensky_poplatok;
	}

	public String getCislo_clena() {
		return cislo_clena;
	}
	public String getMeno_clena() {
		return meno_clena;
	}
	public String getUlica_clena() {
		return ulica_clena;
	}
	public String getPsc_clena() {
		return psc_clena;
	}
	public String getMesto_clena() {
		return mesto_clena;
	}
    public String getMesacny_clensky_poplatok() { return mesacny_clensky_poplatok; }
}