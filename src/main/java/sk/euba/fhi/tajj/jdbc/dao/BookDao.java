package sk.euba.fhi.tajj.jdbc.dao;

import sk.euba.fhi.tajj.jdbc.domain.Book;

import java.util.List;

/**
 * Created by Igor Banduric.
 */
public interface BookDao {

	List<Book> allBooks();

	void addBook(Book book);
}
