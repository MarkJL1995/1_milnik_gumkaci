package sk.euba.fhi.tajj.jdbc.dao;

import sk.euba.fhi.tajj.jdbc.dao.mysql.ClenDaoMySQL;

/**
 * Created by Igor Banduric.
 */
public class DaoFactory {

	public static ClenDao createDao() {
		return new ClenDaoMySQL();
	}

    }
