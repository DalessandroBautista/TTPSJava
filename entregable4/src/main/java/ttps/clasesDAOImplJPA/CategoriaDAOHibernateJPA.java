package ttps.clasesDAOImplJPA;

import ttps.clasesDAO.CategoriaDAO;
import ttps.clasesDeObjetosDelSistema.Categoria;

public class CategoriaDAOHibernateJPA extends GenericDAOHibernateJPA<Categoria> implements CategoriaDAO {
	
	public CategoriaDAOHibernateJPA() {
		super(Categoria.class);
	}

}