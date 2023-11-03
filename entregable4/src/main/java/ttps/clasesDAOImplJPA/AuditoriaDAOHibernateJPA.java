package ttps.clasesDAOImplJPA;

import ttps.clasesDAO.AuditoriaDAO;
import ttps.clasesDeObjetosDelSistema.Auditoria;

public class AuditoriaDAOHibernateJPA extends GenericDAOHibernateJPA<Auditoria> implements AuditoriaDAO{
	
	public AuditoriaDAOHibernateJPA() {
		super(Auditoria.class);
	}

}