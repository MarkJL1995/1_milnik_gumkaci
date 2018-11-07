package sk.euba.fhi.tajj.jdbc.domain;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Igor Banduric.
 */

public class Vyuzitie_sluzieb {

	private Timestamp aktualny_datum;
	private String aktualny_datum_format;
	private String datum_format;
	private Date datum_poskytnutia_sluzby;
	private String datum_poskytnutia_sluzby_format;
	private String cislo_clena_posk;
	private String meno_clen;
	private String cislo_poskytovatela_posk;
	private String meno_poskytovatel;
	private String kod_sluzby_posk;
	private String nazov_sluzba;
	private Double poplatok;
	private String komentar;


	public Vyuzitie_sluzieb(Timestamp aktualny_datum, String aktualny_datum_format, String datum_format, Date datum_poskytnutia_sluzby, String datum_poskytnutia_sluzby_format, String cislo_clena_posk, String meno_clen, String cislo_poskytovatela_posk, String meno_poskytovatel, String kod_sluzby_posk, String nazov_sluzba, Double poplatok, String komentar) {
		this.aktualny_datum = aktualny_datum;
		this.aktualny_datum_format = aktualny_datum_format;
		this.datum_format = datum_format;
		this.datum_poskytnutia_sluzby = datum_poskytnutia_sluzby;
		this.datum_poskytnutia_sluzby_format = datum_poskytnutia_sluzby_format;
		this.cislo_clena_posk = cislo_clena_posk;
		this.meno_clen = meno_clen;
		this.cislo_poskytovatela_posk = cislo_poskytovatela_posk;
		this.meno_poskytovatel = meno_poskytovatel;
		this.kod_sluzby_posk = kod_sluzby_posk;
		this.nazov_sluzba = nazov_sluzba;
		this.poplatok = poplatok;
		this.komentar = komentar;
	}

	public Timestamp getAktualny_datum() {
		return aktualny_datum;
	}

	public String getAktualny_datum_format() {
		return aktualny_datum_format;
	}

	public String getDatum_format() {
		return datum_format;
	}

	public Date getDatum_poskytnutia_sluzby() {
		return datum_poskytnutia_sluzby;
	}

	public String getDatum_poskytnutia_sluzby_format() {
		return datum_poskytnutia_sluzby_format;
	}

	public String getCislo_clena_posk() {
		return cislo_clena_posk;
	}

	public String getMeno_clen() {
		return meno_clen;
	}

	public String getCislo_poskytovatela_posk() {
		return cislo_poskytovatela_posk;
	}

	public String getMeno_poskytovatel() {
		return meno_poskytovatel;
	}

	public String getKod_sluzby_posk() {
		return kod_sluzby_posk;
	}

	public String getNazov_sluzba() {
		return nazov_sluzba;
	}

	public Double getPoplatok() {
		return poplatok;
	}

	public String getKomentar() {
		return komentar;
	}


	public static boolean jeDatumValidny(String datum_format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(datum_format.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}
}