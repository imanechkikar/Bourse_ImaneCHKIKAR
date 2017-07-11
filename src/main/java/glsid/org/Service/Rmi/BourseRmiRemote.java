package glsid.org.Service.Rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import glsid.org.Entities.Ordre;
import glsid.org.Entities.Societe;

public interface BourseRmiRemote extends Remote {

	public Ordre SaveOrdre(Ordre ordre)throws RemoteException;
	public Ordre getOrdre(long id)throws RemoteException;
	public double getTotaux()throws RemoteException;
	public Societe getSociete(String code)throws RemoteException;
	public double GetTotauxBySociete(String code) throws RemoteException;
	public double GetMoyenneBySociete(String code) throws RemoteException;
	public List<Ordre> getOrders(String code)throws RemoteException;
}
