package sk.euba.fhi.tajj.jdbc.dao;

import sk.euba.fhi.tajj.jdbc.domain.Clen;

import java.util.List;

/**
 * Created by Igor Banduric.
 */
public interface ClenDao {

	List<Clen> allClenovia();

    void addClen(Clen clen);

}