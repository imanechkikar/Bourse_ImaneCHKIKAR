package glsid.org.Service.Soap;


import javax.jws.WebMethod;
import javax.jws.WebService;

import glsid.org.Metier.OrdreMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebService
public class SocieteSOAPService {

	
	@Autowired
    private OrdreMetier ordermetier;

	@WebMethod(operationName="getTotaux")
	public double getTotauxAction() {
		return ordermetier.getTotauxAction();
	}

	public double getMoyAction() {
		return ordermetier.getMoyAction();
	}
 
	
	
}
