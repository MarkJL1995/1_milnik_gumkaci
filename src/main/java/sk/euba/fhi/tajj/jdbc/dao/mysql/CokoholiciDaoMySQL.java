package sk.euba.fhi.tajj.jdbc.dao.mysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.euba.fhi.tajj.jdbc.dao.CokoholiciDao;
import sk.euba.fhi.tajj.jdbc.domain.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor Banduric.
 */
public class CokoholiciDaoMySQL implements CokoholiciDao {

	private static final Logger logger = LoggerFactory.getLogger( CokoholiciDaoMySQL.class );

	public List<Clen> allClenovia() {
		List<Clen> clenovia = new ArrayList<>();
		Connection connection = new ConnectionManager().createConnection();
		if( connection != null ) {
			try {
				PreparedStatement ps = connection.prepareStatement( "SELECT cislo_clena,meno_clena,ulica_clena, psc_clena, mesto_clena, mesacny_clensky_poplatok FROM clen" );
				ResultSet rs = ps.executeQuery();
				while( rs.next() ) {
                    String cislo_clena = rs.getString( "cislo_clena" );
					String meno_clena = rs.getString( "meno_clena" );
					String ulica_clena = rs.getString( "ulica_clena" );
					String psc_clena = rs.getString( "psc_clena" );
					String mesto_clena = rs.getString( "mesto_clena" );
					String mesacny_clensky_poplatok = rs.getString("mesacny_clensky_poplatok");
					logger.debug( "Name and year in resultSet {}, {}, {}, {}, {}", cislo_clena, meno_clena, ulica_clena,  psc_clena, mesto_clena,mesacny_clensky_poplatok );
					Clen clen = new Clen( cislo_clena,meno_clena,ulica_clena, mesto_clena, psc_clena, mesacny_clensky_poplatok);
					clenovia.add( clen );
				}
			} catch (SQLException ex) {
				logger.error( ex.getMessage(), ex );
			}
		}
		return clenovia;
	}

	@Override
	public void addClen(Clen clen) {
		Connection connection = new ConnectionManager().createConnection();
		if( connection != null ) {
			try {
				PreparedStatement ps = connection.prepareStatement( "INSERT INTO clen (cislo_clena,meno_clena,ulica_clena, psc_clena, mesto_clena) VALUES (?, ?, ?, ?, ?)" );
				ps.setString( 1, clen.getCislo_clena() );
				ps.setString( 2, clen.getMeno_clena() );
				ps.setString( 3, clen.getUlica_clena() );
				ps.setString( 4, clen.getPsc_clena() );
				ps.setString( 5, clen.getMesto_clena() );
				int rows = ps.executeUpdate();
				logger.debug( "Rows inserted: {}", rows );
			} catch (SQLException ex) {
				logger.error( ex.getMessage(), ex );
			}
		}
	}

	public List<Poskytovatel> allPoskytovatelia() {
		List<Poskytovatel> poskytovatelia = new ArrayList<>();
		Connection connection = new ConnectionManager().createConnection();
		if( connection != null ) {
			try {
				PreparedStatement ps = connection.prepareStatement( "SELECT cislo_poskytovatela, meno_poskytovatela, ulica_poskytovatela, psc_poskytovatela, mesto_poskytovatela FROM poskytovatel" );
				ResultSet rs = ps.executeQuery();
				while( rs.next() ) {
                    String cislo_poskytovatela = rs.getString( "cislo_poskytovatela" );
					String meno_poskytovatela = rs.getString( "meno_poskytovatela" );
					String ulica_poskytovatela = rs.getString( "ulica_poskytovatela" );
					String psc_poskytovatela = rs.getString( "psc_poskytovatela" );
					String mesto_poskytovatela = rs.getString( "mesto_poskytovatela" );
					logger.debug( "Name and year in resultSet {}, {}, {}, {}, {}", cislo_poskytovatela, meno_poskytovatela, ulica_poskytovatela,  psc_poskytovatela, mesto_poskytovatela );
					Poskytovatel poskytovatel = new Poskytovatel( cislo_poskytovatela,meno_poskytovatela,ulica_poskytovatela,  psc_poskytovatela, mesto_poskytovatela);
					poskytovatelia.add( poskytovatel );
				}
			} catch (SQLException ex) {
				logger.error( ex.getMessage(), ex );
			}
		}
		return poskytovatelia;
	}

	@Override
	public void addPoskytovatel(Poskytovatel poskytovatel) {
		Connection connection = new ConnectionManager().createConnection();
		if( connection != null ) {
			try {
				PreparedStatement ps = connection.prepareStatement( "INSERT INTO poskytovatel (cislo_poskytovatela, meno_poskytovatela, ulica_poskytovatela, psc_poskytovatela, mesto_poskytovatela) VALUES (?, ?, ?, ?, ?)" );
				ps.setString( 1, poskytovatel.getCislo_poskytovatela() );
				ps.setString( 2, poskytovatel.getMeno_poskytovatela() );
				ps.setString( 3, poskytovatel.getUlica_poskytovatela() );
				ps.setString( 4, poskytovatel.getPsc_poskytovatela() );
				ps.setString( 5, poskytovatel.getMesto_poskytovatela() );
				int rows = ps.executeUpdate();
				logger.debug( "Rows inserted: {}", rows );
			} catch (SQLException ex) {
				logger.error( ex.getMessage(), ex );
			}
	}

	}

	public List<Sluzba> allSluzby() {
		List<Sluzba> sluzby = new ArrayList<>();
		Connection connection = new ConnectionManager().createConnection();
		if( connection != null ) {
			try {
				PreparedStatement ps = connection.prepareStatement( "SELECT kod_sluzby, nazov_sluzby, poplatok_za_sluzbu FROM sluzba" );
				ResultSet rs = ps.executeQuery();
				while( rs.next() ) {
					String kod_sluzby= rs.getString( "kod_sluzby" );
					String  nazov_sluzby= rs.getString( "nazov_sluzby" );
					Double poplatok_za_sluzbu= rs.getDouble( "poplatok_za_sluzbu" );
					logger.debug( "Name and year in resultSet {}, {}, {}, {}, {}", kod_sluzby, nazov_sluzby, poplatok_za_sluzbu );
					Sluzba sluzba = new Sluzba(kod_sluzby, nazov_sluzby, poplatok_za_sluzbu );
					sluzby.add( sluzba );
				}
			} catch (SQLException ex) {
				logger.error( ex.getMessage(), ex );
			}
		}
		return sluzby;
	}

	@Override
	public void addSluzba(Sluzba sluzba) {
		Connection connection = new ConnectionManager().createConnection();
		if( connection != null ) {
			try {
				PreparedStatement ps = connection.prepareStatement( "INSERT INTO sluzba (kod_sluzby, nazov_sluzby, poplatok_za_sluzbu) VALUES (?, ?, ?)" );
				ps.setString( 1, sluzba.getKod_sluzby() );
				ps.setString( 2, sluzba.getNazov_sluzby() );
				ps.setDouble( 3, sluzba.getPoplatok_za_sluzbu() );

				int rows = ps.executeUpdate();
				logger.debug( "Rows inserted: {}", rows );
			} catch (SQLException ex) {
				logger.error( ex.getMessage(), ex );
			}
		}
	}

    public List<Zoznam_ukonov> allZoznam_ukonov() {
        List<Zoznam_ukonov> zoznam_ukonov = new ArrayList<>();
        Connection connection = new ConnectionManager().createConnection();
        if( connection != null ) {
            try {
                PreparedStatement ps = connection.prepareStatement( "SELECT  nazov_sluzby, kod_sluzby, poplatok_za_sluzbu FROM sluzba order by nazov_sluzby asc" );
                ResultSet rs = ps.executeQuery();
                while( rs.next() ) {

                    String  nazov_sluzby= rs.getString( "nazov_sluzby" );
                    String kod_sluzby= rs.getString( "kod_sluzby" );
                    Double poplatok_za_sluzbu= rs.getDouble( "poplatok_za_sluzbu" );
                    logger.debug( "Name and year in resultSet {}, {}, {}, {}, {}", nazov_sluzby, kod_sluzby, poplatok_za_sluzbu );
                    Zoznam_ukonov zoznam = new Zoznam_ukonov( nazov_sluzby, kod_sluzby, poplatok_za_sluzbu );
                    zoznam_ukonov.add( zoznam );
                }
            } catch (SQLException ex) {
                logger.error( ex.getMessage(), ex );
            }
        }
        return zoznam_ukonov;
    }

	public List<Vyuzitie_sluzieb> allVyuzitie_sluzieb() {
		List<Vyuzitie_sluzieb> vyuzitie_sluzieb = new ArrayList<>();
		Connection connection = new ConnectionManager().createConnection();
		if( connection != null ) {
			try {
				PreparedStatement ps = connection.prepareStatement( "SELECT poskytnuta_sluzba.aktualny_datum,poskytnuta_sluzba.datum_format, poskytnuta_sluzba.datum_poskytnutia_sluzby, poskytnuta_sluzba.cislo_clena, clen.meno_clena, poskytnuta_sluzba.cislo_poskytovatela, poskytovatel.meno_poskytovatela, poskytnuta_sluzba.kod_sluzby, sluzba.nazov_sluzby, sluzba.poplatok_za_sluzbu, poskytnuta_sluzba.komentar from clen,poskytnuta_sluzba, poskytovatel, sluzba where poskytnuta_sluzba.cislo_clena=clen.cislo_clena and poskytnuta_sluzba.cislo_poskytovatela=poskytovatel.cislo_poskytovatela and poskytnuta_sluzba.kod_sluzby=sluzba.kod_sluzby  order by poskytnuta_sluzba.aktualny_datum" );
				ResultSet rs = ps.executeQuery();
				while( rs.next() ) {

					Timestamp aktualny_datum = rs.getTimestamp( "poskytnuta_sluzba.aktualny_datum" );
					String aktualny_datum_format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(aktualny_datum);
					String datum_format=rs.getString( "poskytnuta_sluzba.datum_format" );
					Date datum_poskytnutia_sluzby=rs.getDate( "poskytnuta_sluzba.datum_poskytnutia_sluzby" );
					String datum_poskytnutia_sluzby_format = new SimpleDateFormat("dd.MM.yyyy").format(datum_poskytnutia_sluzby);
                    String cislo_clena_posk = rs.getString( "poskytnuta_sluzba.cislo_clena" );
					String meno_clen = rs.getString( "clen.meno_clena" );
                    String cislo_poskytovatela_posk = rs.getString( "poskytnuta_sluzba.cislo_poskytovatela" );
					String meno_poskytovatel = rs.getString( "poskytovatel.meno_poskytovatela" );
                    String kod_sluzby_posk = rs.getString( "poskytnuta_sluzba.kod_sluzby" );
					String nazov_sluzba = rs.getString( "sluzba.nazov_sluzby" );
					Double poplatok = rs.getDouble( "sluzba.poplatok_za_sluzbu" );
					String komentar = rs.getString( "poskytnuta_sluzba.komentar" );
					logger.debug( "Name and year in resultSet {}, {}, {}, {}, {}",aktualny_datum, aktualny_datum_format, datum_format, datum_poskytnutia_sluzby, datum_poskytnutia_sluzby_format, cislo_clena_posk, meno_clen, cislo_poskytovatela_posk, meno_poskytovatel,kod_sluzby_posk,nazov_sluzba, poplatok, komentar);
					Vyuzitie_sluzieb vyuzitie = new Vyuzitie_sluzieb(aktualny_datum, aktualny_datum_format, datum_format, datum_poskytnutia_sluzby, datum_poskytnutia_sluzby_format, cislo_clena_posk, meno_clen, cislo_poskytovatela_posk, meno_poskytovatel,kod_sluzby_posk,nazov_sluzba, poplatok, komentar);
					vyuzitie_sluzieb.add( vyuzitie );
				}
			} catch (SQLException ex) {
				logger.error( ex.getMessage(), ex );
			}
		}
		return vyuzitie_sluzieb;
	}

	@Override
	public void addVyuzitie_sluzieb(Vyuzitie_sluzieb vyuzitie_sluzieb) {
		Connection connection = new ConnectionManager().createConnection();
		if (connection != null) {
			try {
				PreparedStatement ps = connection.prepareStatement("INSERT INTO poskytnuta_sluzba(cislo_clena, cislo_poskytovatela, kod_sluzby, datum_format, komentar) VALUES (?, ?, ?, ?, ?)");
				ps.setString(1, vyuzitie_sluzieb.getCislo_clena_posk());
				ps.setString(2, vyuzitie_sluzieb.getCislo_poskytovatela_posk());
				ps.setString(3, vyuzitie_sluzieb.getKod_sluzby_posk());
				ps.setString(4, vyuzitie_sluzieb.getDatum_format());
				ps.setString(5, vyuzitie_sluzieb.getKomentar());

				int rows = ps.executeUpdate();
				logger.debug("Rows inserted: {}", rows);
			} catch (SQLException ex) {
				logger.error(ex.getMessage(), ex);
			}
		}
	}
}