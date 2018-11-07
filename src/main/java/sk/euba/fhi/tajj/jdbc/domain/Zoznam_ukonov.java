package sk.euba.fhi.tajj.jdbc.domain;

/**
 * Created by Igor Banduric.
 */

public class Zoznam_ukonov {

	private String nazov_sluzby;
	private String kod_sluzby;
	private Double poplatok_za_sluzbu;

	public Zoznam_ukonov( String nazov_sluzby, String kod_sluzby, Double poplatok_za_sluzbu) {
		this.nazov_sluzby = nazov_sluzby;
		this.kod_sluzby = kod_sluzby;
		this.poplatok_za_sluzbu = poplatok_za_sluzbu;
	}

	public String getNazov_sluzby() {
		return nazov_sluzby;
	}
	public String getKod_sluzby() {
		return kod_sluzby;
	}
	public Double getPoplatok_za_sluzbu() {
		return poplatok_za_sluzbu;
	}
}