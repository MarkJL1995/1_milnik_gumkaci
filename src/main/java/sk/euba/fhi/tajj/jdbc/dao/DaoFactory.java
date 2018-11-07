package sk.euba.fhi.tajj.jdbc.dao;

import sk.euba.fhi.tajj.jdbc.dao.mysql.CokoholiciDaoMySQL;

/**
 * Created by Igor Banduric.
 */
public class DaoFactory {

	public static CokoholiciDao createDao() {
		return new CokoholiciDaoMySQL();
	}

    }
