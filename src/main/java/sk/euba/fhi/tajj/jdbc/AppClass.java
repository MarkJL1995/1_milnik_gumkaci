package sk.euba.fhi.tajj.jdbc;

import ro.pippo.core.Pippo;
import sk.euba.fhi.tajj.jdbc.dao.CokoholiciDao;
import sk.euba.fhi.tajj.jdbc.dao.DaoFactory;
import sk.euba.fhi.tajj.jdbc.domain.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Igor Banduric.
 */
public class AppClass {

	public static void main(String[] args) {
		Pippo pippo = new Pippo();

			pippo.GET( "/", routeContext -> {
			Map<String, Object> model = getModelMapMenu();
			routeContext.render( "menu", model );
		} );

        pippo.GET( "/addclen", routeContext -> {
            String sprava = "";
            Map<String, Object> model = getModelMapForm(sprava);
            routeContext.render("addclen", model);

        } );

        pippo.GET( "/clen", routeContext -> {
            Map<String, Object> model = getModelMapClenovia();
            routeContext.render( "clenovia", model );
        } );

        pippo.GET( "/poskytovatel", routeContext -> {
            Map<String, Object> model = getModelMapPoskytovatelia();
            routeContext.render( "poskytovatelia", model );
        } );

              pippo.GET( "/sluzba", routeContext -> {
            Map<String, Object> model = getModelMapSluzby();
            routeContext.render( "sluzby", model );
        } );

        pippo.GET( "/zoznam_ukonov", routeContext -> {
            Map<String, Object> model = getModelMapZoznam();
            routeContext.render( "zoznam_ukonov", model );
        } );

        pippo.GET( "/vyuzitie_sluzieb", routeContext -> {
            Map<String, Object> model = getModelMapVyuzitieSluzieb();
            routeContext.render( "vyuzitie_sluzieb", model );
        } );

		pippo.POST( "/addclen", routeContext -> {
                    CokoholiciDao cokoholiciDao = DaoFactory.createDao();
                    String cislo_clena = routeContext.getParameter("cislo_clena").toString();
                    String meno_clena = routeContext.getParameter("meno_clena").toString();
                    String ulica_clena = routeContext.getParameter("ulica_clena").toString();
                    String mesto_clena = routeContext.getParameter("mesto_clena").toString();
                    String psc_clena = routeContext.getParameter("psc_clena").toString();
                    String mesacny_clensky_poplatok = routeContext.getParameter("mesacny_clensky_poplatok").toString();

            String sprava = "";

            if(cislo_clena.isEmpty() == true||meno_clena.isEmpty()==true||ulica_clena.isEmpty()==true||psc_clena.isEmpty()==true||mesto_clena.isEmpty()==true) {
                sprava = "Vyplňte všetky povinné údaje!";
            Map<String, Object> model = getModelMapForm(sprava);
            routeContext.render("addclen", model);
            return;
        }

                if(cislo_clena.length()!=9)
                {
                    sprava = sprava + "Číslo člena nezodpovedá stanovenej dĺžke! Vložte 9 číslic.";
                    Map<String, Object> model = getModelMapForm(sprava);
                    routeContext.render("addclen", model);
                    return;
                }
                if (cislo_clena.matches("[0-9]+")==false)
                {
                    sprava = sprava + "Číslo člena nesmie obsahovať iné znaky ako čísla.";
                    Map<String, Object> model = getModelMapForm(sprava);
                    routeContext.render("addclen", model);
                    return;
                }
                if(meno_clena.length()==0||meno_clena.length()>26)
                {
                    sprava = sprava + "Meno člena nezodpovedá stanovenej dĺžke!";
                    Map<String, Object> model = getModelMapForm(sprava);
                    routeContext.render("addclen", model);
                    return;
                }
                if (meno_clena.matches("[a-zA-Z]+")==false)
                {
                    sprava = sprava + "Meno člena nemôže obsahovať iné znaky ako písmená!";
                    Map<String, Object> model = getModelMapForm(sprava);
                    routeContext.render("addclen", model);
                    return;
                }
                if(ulica_clena.length()==0||mesto_clena.length()>26)
                {
                    sprava = sprava + "Ulica člena nezodpovedá stanovenej dĺžke!";
                    Map<String, Object> model = getModelMapForm(sprava);
                    routeContext.render("addclen", model);
                    return;
                }
                if(psc_clena.length()!=5)
               {
                   sprava = sprava + "PSČ nezodpovedá stanovenej dĺžke! Vložte 5 čísel.";
                   Map<String, Object> model = getModelMapForm(sprava);
                   routeContext.render("addclen", model);
                   return;
               }
                if (psc_clena.matches("[0-9]+")==false)
                {
                    sprava = sprava + "PSČ nesmie obsahovať iné znaky ako čísla.";
                    Map<String, Object> model = getModelMapForm(sprava);
                    routeContext.render("addclen", model);
                    return;
                }

                if(mesto_clena.length()==0||mesto_clena.length()>26)
                {
                    sprava = sprava + "Mesto člena nezodpovedá stanovenej dĺžke!";
                    Map<String, Object> model = getModelMapForm(sprava);
                    routeContext.render("addclen", model);
                    return;
                }

			Clen clen = new Clen( cislo_clena,meno_clena,ulica_clena, mesto_clena, psc_clena, mesacny_clensky_poplatok );
			cokoholiciDao.addClen( clen );
			routeContext.redirect( "/clen" );
		} );


        pippo.GET( "/addvyuzitie_sluzieb", routeContext -> {
            String sprava = "";
            Map<String, Object> model = getModelMapVypisAtributov(sprava);
            routeContext.render( "addvyuzitie_sluzieb", model);
        } );

        pippo.POST( "/addvyuzitie_sluzieb", routeContext -> {
            CokoholiciDao cokoholiciDao = DaoFactory.createDao();
            Timestamp aktualny_datum=routeContext.getParameter("aktualny_datum").toSqlTimestamp();
            String aktualny_datum_format = routeContext.getParameter("aktualny_datum_format").toString();
            String datum_format= routeContext.getParameter("datum_format").toString();
            Date datum_poskytnutia_sluzby=routeContext.getParameter("datum_poskytnutia_sluzby").toSqlDate();
            String datum_poskytnutia_sluzby_format = routeContext.getParameter("datum_poskytnutia_sluzby_format").toString();
            String cislo_clena_posk = routeContext.getParameter("cislo_clena_posk").toString();
            String meno_clen = routeContext.getParameter("meno_clen").toString();
            String cislo_poskytovatela_posk = routeContext.getParameter("cislo_poskytovatela_posk").toString();
            String meno_poskytovatel = routeContext.getParameter("meno_poskytovatel").toString();
            String kod_sluzby_posk = routeContext.getParameter("kod_sluzby_posk").toString();
            String nazov_sluzba = routeContext.getParameter("nazov_sluzba").toString();
            Double poplatok = routeContext.getParameter("poplatok").toDouble();
            String komentar = routeContext.getParameter("komentar").toString();
            String sprava = "";
            if(cislo_clena_posk.isEmpty() == true||cislo_poskytovatela_posk.isEmpty()==true||kod_sluzby_posk.isEmpty()==true||datum_format.isEmpty()==true)
            {
                sprava = "Vyplňte všetky povinné údaje!";
                Map<String, Object> model = getModelMapVypisAtributov(sprava);
                routeContext.render("addvyuzitie_sluzieb", model);
                return;
            }
            if(cislo_clena_posk.length()!=9)
            {
                sprava = sprava + "Číslo člena nezodpovedá stanovenej dĺžke!";
                Map<String, Object> model = getModelMapVypisAtributov(sprava);
                routeContext.render("addvyuzitie_sluzieb", model);
                return;
            }
            if(cislo_poskytovatela_posk.length()!=9)
            {
                sprava = sprava + "Číslo poskytovateľa nezodpovedá stanovenej dĺžke!";
                Map<String, Object> model = getModelMapVypisAtributov(sprava);
                routeContext.render("addvyuzitie_sluzieb", model);
                return;
            }
            if(kod_sluzby_posk.length()!=6)
            {
                sprava = sprava + "Kód služby nezodpovedá stanovenej dĺžke!";
                Map<String, Object> model = getModelMapVypisAtributov(sprava);
                routeContext.render("addvyuzitie_sluzieb", model);
                return;

            }
            if (Vyuzitie_sluzieb.jeDatumValidny(datum_format) == false ||datum_format.matches("([0-9]{2}).([0-9]{2}).([0-9]{4})")==false) {
                sprava = sprava + "Zadajte platný dátum v nasledujúcom formáte: <b><font color=\"blue\">dd.mm.rrrr</b></font>, napr. <b><font color=\"blue\">12.11.2018</b></font>";
                Map<String, Object> model = getModelMapVypisAtributov(sprava);
                routeContext.render("addvyuzitie_sluzieb", model);
                return;
            }

            Vyuzitie_sluzieb vyuzitie_sluzieb1 = new Vyuzitie_sluzieb(aktualny_datum, aktualny_datum_format, datum_format, datum_poskytnutia_sluzby, datum_poskytnutia_sluzby_format, cislo_clena_posk, meno_clen, cislo_poskytovatela_posk, meno_poskytovatel,kod_sluzby_posk,nazov_sluzba, poplatok, komentar);
            cokoholiciDao.addVyuzitie_sluzieb( vyuzitie_sluzieb1 );
            routeContext.redirect( "/vyuzitie_sluzieb" );
        } );

		pippo.start();
	}

	private static Map<String, Object> getModelMapMenu() {
		CokoholiciDao cokoholiciDao = DaoFactory.createDao();
		List<Clen> menu = cokoholiciDao.allClenovia();
		Map<String, Object> model = new HashMap<>();
		model.put( "menu", menu );
		return model;
	}

    private static Map<String, Object> getModelMapClenovia() {
        CokoholiciDao cokoholiciDao = DaoFactory.createDao();
        List<Clen> clenovia = cokoholiciDao.allClenovia();
        Map<String, Object> model = new HashMap<>();
        model.put( "clenovia", clenovia );
        return model;
    }

    private static Map<String, Object> getModelMapPoskytovatelia() {
        CokoholiciDao cokoholiciDao = DaoFactory.createDao();
        List<Poskytovatel> poskytovatelia = cokoholiciDao.allPoskytovatelia();
        Map<String, Object> model = new HashMap<>();
        model.put( "poskytovatelia", poskytovatelia );
        return model;
    }

    private static Map<String, Object> getModelMapSluzby() {
        CokoholiciDao cokoholiciDao = DaoFactory.createDao();
        List<Sluzba> sluzby = cokoholiciDao.allSluzby();
        Map<String, Object> model = new HashMap<>();
        model.put( "sluzby", sluzby );
        return model;
    }

    private static Map<String, Object> getModelMapZoznam() {
        CokoholiciDao cokoholiciDao = DaoFactory.createDao();
        List<Zoznam_ukonov> zoznam_ukonov = cokoholiciDao.allZoznam_ukonov();
        Map<String, Object> model = new HashMap<>();
        model.put( "zoznam_ukonov", zoznam_ukonov );
        return model;
    }

    private static Map<String, Object> getModelMapVyuzitieSluzieb() {
        CokoholiciDao cokoholiciDao = DaoFactory.createDao();
        List<Vyuzitie_sluzieb> vyuzitie = cokoholiciDao.allVyuzitie_sluzieb();
        Map<String, Object> model = new HashMap<>();
        model.put( "vyuzitie", vyuzitie );
        return model;
    }

    private static Map<String, Object> getModelMapVypisAtributov(String sprava) {
        CokoholiciDao cokoholiciDao = DaoFactory.createDao();
        List<Clen> vypis_clenov = cokoholiciDao.allClenovia();
        List<Poskytovatel> vypis_poskytovatelov = cokoholiciDao.allPoskytovatelia();
        List<Sluzba> vypis_sluzieb = cokoholiciDao.allSluzby();
        Map<String, Object> model = new HashMap<>();
        model.put( "vypis_clenov", vypis_clenov );
        model.put( "vypis_poskytovatelov", vypis_poskytovatelov );
        model.put( "vypis_sluzieb", vypis_sluzieb);
        model.put( "chyba", sprava);
        return model;
    }
    private static Map<String, Object> getModelMapForm(String sprava) {
        Map<String, Object> model = new HashMap<>();
        model.put( "chyba", sprava);
        return model;
    }

}