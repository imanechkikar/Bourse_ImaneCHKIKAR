package glsid.org.Entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("Achat")
@XmlType(name="Achat")
public class OrdreAchat extends Ordre {

	public OrdreAchat(Date dateOrd, long nbAction, double prixAction) {
		super( dateOrd, nbAction, prixAction);
		// TODO Auto-generated constructor stub
	}

	public OrdreAchat(Date dateOrd, long nbAction, double prixAction, Societe societe) {
		super( dateOrd, nbAction, prixAction, societe);
		// TODO Auto-generated constructor stub
	}

	public OrdreAchat() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
