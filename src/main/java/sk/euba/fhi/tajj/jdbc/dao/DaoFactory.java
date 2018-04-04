package sk.euba.fhi.tajj.jdbc.dao;

import sk.euba.fhi.tajj.jdbc.dao.mysql.BookDaoMySQL;

/**
 * Created by Igor Banduric.
 */
public class DaoFactory {

	public static BookDao createDao() {
		return new BookDaoMySQL();
	}
}
