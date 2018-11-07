package sk.euba.fhi.tajj.jdbc.domain;

/**
 * Created by Igor Banduric.
 */

public class Sluzba {

	private String kod_sluzby;
	private String nazov_sluzby;
	private Double poplatok_za_sluzbu;

	public Sluzba(String kod_sluzby, String nazov_sluzby, Double poplatok_za_sluzbu) {
		this.kod_sluzby = kod_sluzby;
		this.nazov_sluzby = nazov_sluzby;
		this.poplatok_za_sluzbu = poplatok_za_sluzbu;
	}

	public String getKod_sluzby() {
		return kod_sluzby;
	}
	public String getNazov_sluzby() {
		return nazov_sluzby;
	}
	public Double getPoplatok_za_sluzbu() {
		return poplatok_za_sluzbu;
	}

}