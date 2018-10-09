package sk.euba.fhi.tajj.jdbc.dao.mysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.euba.fhi.tajj.jdbc.dao.ClenDao;
import sk.euba.fhi.tajj.jdbc.domain.Clen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor Banduric.
 */
public class ClenDaoMySQL implements ClenDao {

	private static final Logger logger = LoggerFactory.getLogger( ClenDaoMySQL.class );

	public List<Clen> allClenovia() {
		List<Clen> clenovia = new ArrayList<>();
		Connection connection = new ConnectionManager().createConnection();
		if( connection != null ) {
			try {
				PreparedStatement ps = connection.prepareStatement( "SELECT meno_clena, cislo_clena, ulica_clena, mesto_clena, psc_clena,clensky_poplatok FROM clen_ac_gumkaci" );
				ResultSet rs = ps.executeQuery();
				while( rs.next() ) {
					String meno_clena = rs.getString( "meno_clena" );
					Integer cislo_clena = rs.getInt( "cislo_clena" );
					String ulica_clena = rs.getString( "ulica_clena" );
					String mesto_clena = rs.getString( "mesto_clena" );
					Integer psc_clena = rs.getInt( "psc_clena" );
					Integer clensky_poplatok = rs.getInt("clensky_poplatok");
					logger.debug( "Name and year in resultSet {}, {}, {}, {}, {}", meno_clena,cislo_clena,ulica_clena, mesto_clena, psc_clena,clensky_poplatok );
					Clen clen = new Clen( meno_clena,cislo_clena,ulica_clena, mesto_clena, psc_clena, clensky_poplatok );
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
				PreparedStatement ps = connection.prepareStatement( "INSERT INTO clen_ac_gumkaci (meno_clena,cislo_clena,ulica_clena, mesto_clena, psc_clena,clensky_poplatok) VALUES (?, ?, ?, ?, ?, ?)" );
				ps.setString( 1, clen.getMeno_clena() );
				ps.setInt( 2, clen.getCislo_clena() );
				ps.setString( 3, clen.getUlica_clena() );
				ps.setString( 4, clen.getMesto_clena() );
				ps.setInt( 5, clen.getPsc_clena() );
				ps.setInt(6, clen.getClensky_poplatok());
				int rows = ps.executeUpdate();
				logger.debug( "Rows inserted: {}", rows );
			} catch (SQLException ex) {
				logger.error( ex.getMessage(), ex );
			}
		}
	}

}