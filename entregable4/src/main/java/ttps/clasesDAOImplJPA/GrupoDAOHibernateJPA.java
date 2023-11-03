package ttps.clasesDAOImplJPA;

import ttps.clasesDAO.GrupoDAO;
import ttps.clasesDeObjetosDelSistema.Grupo;

public class GrupoDAOHibernateJPA extends GenericDAOHibernateJPA<Grupo> implements GrupoDAO {

	public GrupoDAOHibernateJPA() {
		super(Grupo.class);
	}
	
	

}