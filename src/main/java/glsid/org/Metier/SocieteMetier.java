package glsid.org.Metier;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import glsid.org.Entities.Societe;

public interface SocieteMetier {
	
	public Societe findByNom(String soc);

	public Societe ajouterSociete(Societe societe);
	
	public Societe updateSociete(Societe societe);
		
	public List<Societe> getSocietes();
	
	public Page<Societe> getSocietes(Pageable p );

}
