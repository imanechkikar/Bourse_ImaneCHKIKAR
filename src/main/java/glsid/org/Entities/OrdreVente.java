package glsid.org.Entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("Vente")
@XmlType(name="Vente")
public class OrdreVente extends Ordre {
	
	public OrdreVente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdreVente( Date dateOrd, long nbAction, double prixAction) {
		super( dateOrd, nbAction, prixAction);
		// TODO Auto-generated constructor stub
	}

	public OrdreVente( Date dateOrd, long nbAction, double prixAction, Societe societe) {
		super(dateOrd, nbAction, prixAction, societe);
		// TODO Auto-generated constructor stub
	}

}
