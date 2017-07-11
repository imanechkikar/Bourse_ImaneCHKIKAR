package glsid.org.Service.Rmi;

import java.rmi.RemoteException;
import java.util.List;

import glsid.org.Entities.Ordre;
import glsid.org.Entities.Societe;
import glsid.org.Metier.OrdreMetier;
import glsid.org.Metier.SocieteMetier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myRmiService")
public class BourseRmiImpl implements BourseRmiRemote {

	@Autowired
	private OrdreMetier ordremetier;
	
	@Autowired
	private SocieteMetier societemetier;
	
	@Override
	public Ordre SaveOrdre(Ordre ordre) throws RemoteException {
		// TODO Auto-generated method stub
		return ordremetier.AjouterOrdre(ordre);
	}

	@Override
	public Ordre getOrdre(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return ordremetier.GetOrdre(id);
	}

	@Override
	public double getTotaux() throws RemoteException {
		// TODO Auto-generated method stub
		return ordremetier.getTotauxAction();
	}

	@Override
	public Societe getSociete(String soc) throws RemoteException {
		// TODO Auto-generated method stub
		return societemetier.findByNom(soc);
	}

	@Override
	public double GetTotauxBySociete(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return ordremetier.getTotauxActionBySociete(code);
	}

	@Override
	public double GetMoyenneBySociete(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return ordremetier.getMoyActionBySociete(code);
	}

	@Override
	public List<Ordre> getOrders(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return ordremetier.GetOrdresBySociete(code);
	}

}
