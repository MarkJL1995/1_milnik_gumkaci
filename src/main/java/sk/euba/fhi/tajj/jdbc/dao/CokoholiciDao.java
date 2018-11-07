package sk.euba.fhi.tajj.jdbc.dao;

import sk.euba.fhi.tajj.jdbc.domain.*;

import java.util.List;

/**
 * Created by Igor Banduric.
 */
public interface CokoholiciDao {

	List<Clen> allClenovia();

    void addClen(Clen clen);

    List<Poskytovatel> allPoskytovatelia();

    void addPoskytovatel(Poskytovatel poskytovatel);

    List<Sluzba> allSluzby();

    void addSluzba(Sluzba sluzba);

    List<Zoznam_ukonov> allZoznam_ukonov();

    List<Vyuzitie_sluzieb> allVyuzitie_sluzieb();
    void addVyuzitie_sluzieb(Vyuzitie_sluzieb vyuzitie_sluzieb);




}