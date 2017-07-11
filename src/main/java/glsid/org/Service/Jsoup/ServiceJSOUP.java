package glsid.org.Service.Jsoup;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import glsid.org.Entities.OrdreAchat;
import glsid.org.Entities.OrdreVente;
import glsid.org.Entities.Societe;
import glsid.org.Metier.OrdreMetier;
import glsid.org.Metier.SocieteMetier;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceJSOUP {
       
    @Autowired
    private OrdreMetier ordermetier;
    
    @Autowired
    private SocieteMetier societeMetier;
    
    
     public void listeSociete(){ 
	   try {
			Document doc = Jsoup.connect("https://www.wafabourse.com/marches/actions/r").get();
            for (Element table : doc.select("#gridrequestwafa table")) {
			    for (Element row : table.select("tr")) {
			        Elements tds = row.select("td");
			        if (tds.size() > 6) {
			        	String code=tds.get(0).select("a").attr("href").split("/")[3];
			           societeMetier.ajouterSociete(new Societe(code, tds.get(0).text()));
			            System.out.println("Code : "+code +" \t  **** \t Nom " + tds.get(0).text());
			        }
			    }
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
     
     public void listeOrdre(){
    	 
    	 List<Societe> listeSociete= societeMetier.getSocietes();
    	 
    	 for (Societe societe : listeSociete) {
    		 try {
    			    System.out.println("----------------" + societe.getCodeSociete());
    				Document doc = Jsoup.connect("https://www.wafabourse.com/trader/market/"+societe.getCodeSociete()+"/XCAS/ISIN").get();
    	            
    				NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);
    				for (Element table : doc.select("table.tab_ordres.tab_trades #pulldatagrid .t-data-grid   ")) {
    					
    				    for (Element row : table.select("tr")) {
    				        Elements tds = row.select("td");
    				      
    				        if (tds.size() > 2  && !tds.get(0).text().equals("-") ) { 
    				        	ordermetier.AjouterOrdre(new OrdreAchat(new Date(),nf.parse(tds.get(1).text()).longValue(),nf.parse(tds.get(2).text()).doubleValue(),societe));
    				        }
    				    }
    				}
                   for (Element table : doc.select("table.tab_ordres.tab_trades #pulldatagrid_0 .t-data-grid   ")) {
    				     for (Element row : table.select("tr")) {
    				        Elements tds = row.select("td");
    				      
    				        if (tds.size() > 2  && !tds.get(0).text().equals("-") ) { 
    				        	ordermetier.AjouterOrdre(new OrdreVente(new Date(),nf.parse(tds.get(1).text()).longValue(),nf.parse(tds.get(0).text()).doubleValue(),societe));
    				        }
    				    }
    				}

    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
		}
     }
    
}
