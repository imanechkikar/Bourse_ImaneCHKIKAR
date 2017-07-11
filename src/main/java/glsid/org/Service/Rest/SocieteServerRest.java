package glsid.org.Service.Rest;

import java.util.List;


import glsid.org.Entities.*;
import glsid.org.Metier.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class SocieteServerRest {
		
	@Autowired
	private SocieteMetier societeMetier;

	
	@RequestMapping(value="/societes",method=RequestMethod.POST)
	public Societe AjouterSociete(@RequestBody Societe societe) {
		return societeMetier.ajouterSociete(societe);
	}
	
	@RequestMapping(value="/societes",method=RequestMethod.PUT)
	public Societe UpdateSociete(@RequestBody Societe societe) {
		return societeMetier.updateSociete(societe);
	}
	
	@RequestMapping(value="/societes",method=RequestMethod.GET)
	public Page<Societe> listeSocietes(int page, int size) {
		return societeMetier.getSocietes(new PageRequest(page, size));
	}
	
	@RequestMapping(value="/listesocietes",method=RequestMethod.GET)
	public List<Societe> Societes() {
		return societeMetier.getSocietes();
	}
	
	@RequestMapping(value="/societes/{soc}",method=RequestMethod.GET)
	public Societe getSos(@PathVariable(name="soc") String soc) {
     //   return new Societe(soc);
	 return societeMetier.findByNom("%"+soc+"%");
	}
	
	
	
	

	
	
	
	
}
