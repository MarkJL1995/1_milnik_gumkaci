package sk.euba.fhi.tajj.jdbc;

import ro.pippo.core.Pippo;
import sk.euba.fhi.tajj.jdbc.dao.ClenDao;
import sk.euba.fhi.tajj.jdbc.dao.DaoFactory;
import sk.euba.fhi.tajj.jdbc.domain.Clen;

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
			routeContext.render( "menu", model );
		} );

        pippo.GET( "/addclen", routeContext -> {
            routeContext.render( "addclen" );
        } );

        pippo.GET( "/clen", routeContext -> {
            Map<String, Object> model = getModelMap1();
            routeContext.render( "clenovia", model );
        } );

		pippo.POST( "/addclen", routeContext -> {
			ClenDao clenDao = DaoFactory.createDao();
			String meno_clena = routeContext.getParameter( "meno_clena" ).toString();
			Integer cislo_clena = routeContext.getParameter("cislo_clena").toInt();
			String ulica_clena = routeContext.getParameter( "ulica_clena" ).toString();
			String mesto_clena = routeContext.getParameter( "mesto_clena" ).toString();
			Integer psc_clena = routeContext.getParameter("psc_clena").toInt();
			Integer clensky_poplatok= routeContext.getParameter("clensky_poplatok").toInt();
			Clen clen = new Clen( meno_clena,cislo_clena,ulica_clena, mesto_clena, psc_clena, clensky_poplatok );

			clenDao.addClen( clen );
			routeContext.redirect( "/clen" );
		} );

		pippo.start();
	}

	private static Map<String, Object> getModelMap() {
		ClenDao clenDao = DaoFactory.createDao();
		List<Clen> menu = clenDao.allClenovia();
		Map<String, Object> model = new HashMap<>();
		model.put( "menu", menu );
		return model;
	}

    private static Map<String, Object> getModelMap1() {
        ClenDao clenDao = DaoFactory.createDao();
        List<Clen> clenovia = clenDao.allClenovia();
        Map<String, Object> model = new HashMap<>();
        model.put( "clenovia", clenovia );
        return model;
    }

}