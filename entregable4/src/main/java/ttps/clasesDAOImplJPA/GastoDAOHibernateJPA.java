package ttps.clasesDAOImplJPA;

import ttps.clasesDAO.GastoDAO;
import ttps.clasesDeObjetosDelSistema.Gasto;

public class GastoDAOHibernateJPA extends GenericDAOHibernateJPA<Gasto> implements GastoDAO {
	
	public GastoDAOHibernateJPA() {
		super(Gasto.class);
	}

}