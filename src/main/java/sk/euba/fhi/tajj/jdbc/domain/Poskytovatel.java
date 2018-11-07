package sk.euba.fhi.tajj.jdbc.domain;

/**
 * Created by Igor Banduric.
 */

public class Poskytovatel {

	private String cislo_poskytovatela;
	private String meno_poskytovatela;
	private String ulica_poskytovatela;
	private String psc_poskytovatela;
	private String mesto_poskytovatela;

	public Poskytovatel(String cislo_poskytovatela, String meno_poskytovatela, String ulica_poskytovatela, String psc_poskytovatela, String mesto_poskytovatela) {
		this.cislo_poskytovatela = cislo_poskytovatela;
		this.meno_poskytovatela = meno_poskytovatela;
		this.ulica_poskytovatela = ulica_poskytovatela;
		this.psc_poskytovatela = psc_poskytovatela;
		this.mesto_poskytovatela = mesto_poskytovatela;
	}

	public String getCislo_poskytovatela() {
		return cislo_poskytovatela;
	}
	public String getMeno_poskytovatela() {
		return meno_poskytovatela;
	}
	public String getUlica_poskytovatela() {
		return ulica_poskytovatela;
	}
	public String getPsc_poskytovatela() {
		return psc_poskytovatela;
	}
	public String getMesto_poskytovatela() { return mesto_poskytovatela; }
}