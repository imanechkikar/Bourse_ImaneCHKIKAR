package glsid.org.Service.Rest;

import glsid.org.Entities.Ordre;
import glsid.org.Entities.OrdreAchat;
import glsid.org.Entities.OrdreVente;
import glsid.org.Metier.OrdreMetier;
import glsid.org.Metier.SocieteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class OrdreServerRest {
	
	@Autowired
	private OrdreMetier ordermetier;


	@RequestMapping(value="/ordre",method=RequestMethod.POST)
	public Ordre AjouterOrdre(@RequestBody Ordre ordre) {
		return ordermetier.AjouterOrdre(ordre);
	}
	
	@RequestMapping(value="/ordre",method=RequestMethod.PUT)
	public Ordre UpdateOrdre(@RequestBody Ordre ordre) {
		return ordermetier.updateOrdre(ordre);
	}

	@RequestMapping(value="/ordre",method=RequestMethod.DELETE)
	public void DeleteOrdre(@RequestParam  long id) {
		 ordermetier.deleteOrdre(id);
	}
	
	@RequestMapping(value="/ordre",method=RequestMethod.GET)
	public Ordre GetOrdre(@RequestParam  long id) {
		return ordermetier.GetOrdre(id);
	}
	
	@RequestMapping(value="/ordreAchats",method=RequestMethod.POST)
	public Ordre AjouterOrdreAchat(@RequestBody OrdreAchat achat) {
		return ordermetier.AjouterOrdreAchat(achat);
	}
	
	@RequestMapping(value="/ordreAchats",method=RequestMethod.GET)
	public Page<OrdreAchat> getAchats(Pageable p) {
		return ordermetier.getAchats(p);
	}

	@RequestMapping(value="/ordreVentes",method=RequestMethod.POST)
	public Ordre AjouterOrdreVente(@RequestBody OrdreVente vente) {
		return ordermetier.AjouterOrdreVente(vente);
	}

	@RequestMapping(value="/ordreVentes",method=RequestMethod.GET)
	public Page<OrdreVente> getVentes(Pageable p) {
		return ordermetier.getVentes(p);
	}

	@RequestMapping(value="/totaux",method=RequestMethod.GET)
	public double getTotauxAction() {
		return ordermetier.getTotauxAction();
	}

	@RequestMapping(value="/moyenne",method=RequestMethod.GET)
	public double getMoyAction() {
		return ordermetier.getMoyAction();
	}

	
	@RequestMapping(value="/societes/{soc}/Orders",method=RequestMethod.GET)
	public Page<Ordre> GetOrdresBySociete(@PathVariable(name="soc") String soc, Pageable p) {
		return ordermetier.GetOrdresBySociete(soc, p);
	}
	
	@RequestMapping(value="/societes/{soc}/Orders",method=RequestMethod.DELETE)
	public Page<Ordre> DeleteOrder(@PathVariable(name="soc") String soc, int page,int size) {
		return ordermetier.GetOrdresBySociete(soc, new PageRequest(page,size));
	}
    
	@RequestMapping(value="/societes/{soc}/Totaux",method=RequestMethod.GET)
	public double getTotauxActionBySociete(@PathVariable(name="soc") String soc) {
		return ordermetier.getTotauxActionBySociete(soc);
	}

	@RequestMapping(value="/societes/{soc}/Moyenne",method=RequestMethod.GET)
	public double getMoyActionBySociete(@PathVariable(name="soc") String soc) {
		return ordermetier.getMoyActionBySociete(soc);
	}
	
	@RequestMapping(value="/LastOrdres",method=RequestMethod.GET)
	public Page<Ordre> getLastOrdres(int page,int size) {
		return ordermetier.getLastOrdres(new PageRequest(page,size));
	}
}
