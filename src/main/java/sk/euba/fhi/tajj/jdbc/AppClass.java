package sk.euba.fhi.tajj.jdbc;

import ro.pippo.core.Pippo;
import sk.euba.fhi.tajj.jdbc.dao.BookDao;
import sk.euba.fhi.tajj.jdbc.dao.DaoFactory;
import sk.euba.fhi.tajj.jdbc.domain.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Igor Banduric.
 */
public class AppClass {

	public static void main(String[] args) {
		Pippo pippo = new Pippo();

		pippo.GET( "/", routeContext -> {
			Map<String, Object> model = getModelMap();
			routeContext.render( "books", model );
		} );

		pippo.GET( "/add", routeContext -> {
			routeContext.render( "addbook" );
		} );

		pippo.POST( "/add", routeContext -> {
			BookDao bookDao = DaoFactory.createDao();
			String name = routeContext.getParameter( "bookname" ).toString();
			Book book = new Book( name, 0 );//FIXME: Rok nacitat z formulara

			bookDao.addBook( book );
			routeContext.redirect( "/" );
		} );
		pippo.start();
	}

	private static Map<String, Object> getModelMap() {
		BookDao bookDao = DaoFactory.createDao();
		List<Book> books = bookDao.allBooks();
		Map<String, Object> model = new HashMap<>();
		model.put( "books", books );
		return model;
	}
}
