package ttps.clasesDAOImplJPA;

import ttps.clasesDAO.SolicitudDAO;
import ttps.clasesDeObjetosDelSistema.Solicitud;

public class SolicitudDAOHibernateJPA extends GenericDAOHibernateJPA<Solicitud> implements SolicitudDAO{

	public SolicitudDAOHibernateJPA() {
		super(Solicitud.class);
	}

}