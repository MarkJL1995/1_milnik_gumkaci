package sk.euba.fhi.tajj.jdbc.domain;

/**
 * Created by Igor Banduric.
 */


public class Clen {

	private String meno_clena;
	private Integer cislo_clena;
	private String ulica_clena;
	private String mesto_clena;
	private Integer psc_clena;
	private Integer clensky_poplatok;


	public Clen(String meno_clena, Integer cislo_clena, String ulica_clena, String mesto_clena, Integer psc_clena, Integer clensky_poplatok) {
		this.meno_clena = meno_clena;
		this.cislo_clena = cislo_clena;
		this.ulica_clena = ulica_clena;
		this.mesto_clena = mesto_clena;
		this.psc_clena = psc_clena;
        this.clensky_poplatok = clensky_poplatok;

	}
	/*@Override
	public String toString() {
		return "Clen{" +
				"name='" + name + '\'' +
				", year=" + year +
				'}';
	}*/
	public String getMeno_clena() {
		return meno_clena;
	}

	public Integer getCislo_clena() {
		return cislo_clena;
	}

	public String getUlica_clena() {
		return ulica_clena;
	}

	public String getMesto_clena() {
		return mesto_clena;
	}

	public Integer getPsc_clena() {
		return psc_clena;
	}

    public Integer getClensky_poplatok() {
        return clensky_poplatok;
    }

}