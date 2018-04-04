package sk.euba.fhi.tajj.jdbc.dao.mysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.euba.fhi.tajj.jdbc.dao.BookDao;
import sk.euba.fhi.tajj.jdbc.domain.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor Banduric.
 */
public class BookDaoMySQL implements BookDao {

	private static final Logger logger = LoggerFactory.getLogger( BookDaoMySQL.class );

	public List<Book> allBooks() {
		List<Book> books = new ArrayList<>();
		Connection connection = new ConnectionManager().createConnection();
		if( connection != null ) {
			try {
				PreparedStatement ps = connection.prepareStatement( "SELECT name, year FROM book" );
				ResultSet rs = ps.executeQuery();
				while( rs.next() ) {
					String name = rs.getString( "name" );
					Integer year = rs.getInt( "year" );
					logger.debug( "Name and year in resultSet {}, {}", name, year );
					Book book = new Book( name, year );
					books.add( book );
				}
			} catch (SQLException ex) {
				logger.error( ex.getMessage(), ex );
			}
		}
		return books;
	}

	@Override
	public void addBook(Book book) {
		Connection connection = new ConnectionManager().createConnection();
		if( connection != null ) {
			try {
				PreparedStatement ps = connection.prepareStatement( "INSERT INTO book (name, year) VALUES (?, ?)" );
				ps.setString( 1, book.getName() );
				ps.setInt( 2, book.getYear() );
				int rows = ps.executeUpdate();
				logger.debug( "Rows inserted: {}", rows );
			} catch (SQLException ex) {
				logger.error( ex.getMessage(), ex );
			}
		}
	}
}


