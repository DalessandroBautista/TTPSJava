package ttps.clasesDAOImplJPA;

import ttps.clasesDAO.UsuarioDAO;

public class FactoryDAO {

	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOHibernateJPA();
	}

}