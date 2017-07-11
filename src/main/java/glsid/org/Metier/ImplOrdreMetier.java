package glsid.org.Metier;



import java.util.Date;
import java.util.List;

import glsid.org.DAO.OrdreJpaRepository;
import glsid.org.Entities.Ordre;
import glsid.org.Entities.OrdreAchat;
import glsid.org.Entities.OrdreVente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ImplOrdreMetier implements OrdreMetier {

	@Autowired
	OrdreJpaRepository ordreJpaRepository ;
	
	@Override
	public Ordre AjouterOrdreAchat(OrdreAchat achat) {
		// TODO Auto-generated method stub
		return ordreJpaRepository.save(achat);
	}

	@Override
	public Ordre AjouterOrdreVente(OrdreVente vente) {
		// TODO Auto-generated method stub
		return ordreJpaRepository.save(vente);
	}

	@Override
	public Page<Ordre> GetOrdresBySociete(String soc, Pageable p) {
		// TODO Auto-generated method stub
		return ordreJpaRepository.findBySociete(soc, p);
	}

	@Override
	public double getTotauxActionBySociete(String Soc) {
		// TODO Auto-generated method stub
		
		return ordreJpaRepository.GetTotauxBySociete(Soc);
	}

	@Override
	public double getMoyActionBySociete(String soc) {
		// TODO Auto-generated method stub
		return ordreJpaRepository.GetMoyBySociete(soc);
	}

	@Override
	public Page<OrdreAchat> getAchats(Pageable p) {
		// TODO Auto-generated method stub
		return ordreJpaRepository.findAchats(p);
	}

	@Override
	public Page<OrdreVente> getVentes(Pageable p) {
		// TODO Auto-generated method stub
		return ordreJpaRepository.findVentes(p);
	}

	@Override
	public double getTotauxAction() {
		// TODO Auto-generated method stub
		return ordreJpaRepository.GetTotaux();
	}

	@Override
	public double getMoyAction() {
		// TODO Auto-generated method stub
		return ordreJpaRepository.GetMoyenne();
	}

	@Override
	public Ordre AjouterOrdre(Ordre ordre) {
		// TODO Auto-generated method stub
		ordre.setDateOrd(new Date());
		return ordreJpaRepository.save(ordre);
	}

	@Override
	public Ordre GetOrdre(long id) {
		// TODO Auto-generated method stub
		return ordreJpaRepository.findOne(id);
	}

	@Override
	public void deleteOrdre(long id) {
		// TODO Auto-generated method stub
		 ordreJpaRepository.delete(id);
	}

	@Override
	public Ordre updateOrdre(Ordre ordre) {
		// TODO Auto-generated method stub
		return ordreJpaRepository.save(ordre);
	}

	@Override
	public List<Ordre> GetOrdresBySociete(String soc) {
		// TODO Auto-generated method stub
		return ordreJpaRepository.findBySociete(soc);
	}

	@Override
	public Page<Ordre> getLastOrdres(Pageable p) {
		// TODO Auto-generated method stub
		return ordreJpaRepository.lastOrdres(p);
	}
	
	

	
}
