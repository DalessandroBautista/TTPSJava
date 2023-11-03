package ttps.clasesDAOImplJPA;

import ttps.clasesDAO.PagoDAO;
import ttps.clasesDeObjetosDelSistema.Pago;

public class PagoDAOHibernateJPA extends GenericDAOHibernateJPA<Pago> implements PagoDAO{

	public PagoDAOHibernateJPA() {
		super(Pago.class);
	}

}