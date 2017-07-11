package glsid.org.Metier;

import java.util.List;

import glsid.org.DAO.SocieteJpaRepository;
import glsid.org.Entities.Ordre;
import glsid.org.Entities.Societe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ImplSocieteMetier implements SocieteMetier {
	
	@Autowired
	SocieteJpaRepository societeJpaRepository;
	
	@Override
	public Societe findByNom(String soc) {
		// TODO Auto-generated method stub
		return societeJpaRepository.findSocietebyCode(soc);
		
	}

	@Override
	public Societe ajouterSociete(Societe societe) {
		// TODO Auto-generated method stub
		return societeJpaRepository.save(societe);
	}

	@Override
	public List<Societe> getSocietes() {
		// TODO Auto-generated method stub
		return societeJpaRepository.findAll();
	}

	@Override
	public Page<Societe> getSocietes(Pageable p) {
		// TODO Auto-generated method stub
		return societeJpaRepository.findAll(p);
	}

	@Override
	public Societe updateSociete(Societe societe) {
		// TODO Auto-generated method stub
		return societeJpaRepository.save(societe);
	}

	

}
