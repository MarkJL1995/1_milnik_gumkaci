package sk.euba.fhi.tajj.jdbc;

import sk.euba.fhi.tajj.jdbc.dao.BookDao;
import sk.euba.fhi.tajj.jdbc.dao.DaoFactory;
import sk.euba.fhi.tajj.jdbc.dao.mysql.BookDaoMySQL;
import sk.euba.fhi.tajj.jdbc.domain.Book;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Igor Banduric.
 */
public class MainClass {

	public static void main(String[] args) {
		select();
		//insert();
	}

	private static void select() {
		BookDao bookDao = new BookDaoMySQL();
		List<Book> books = bookDao.allBooks();
		System.out.println( "Output: " + books );
	}

	private static void insert() {
		BookDao bookDao = DaoFactory.createDao();
		Book book = createBook();
		bookDao.addBook(book);
	}

	private static Book createBook() {
		Scanner scanner = new Scanner( System.in );
		System.out.println( "Zadaj nazov" );
		String name = scanner.nextLine();
		System.out.println( "Zadaj rok" );
		Integer year = scanner.nextInt();
		Book book = new Book( name, year );
		return book;
	}
}
