package ttps.clasesDAOImplJPA;

import ttps.clasesDAO.UsuarioDAO;
import ttps.clasesDeObjetosDelSistema.Usuario;

public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {

	public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	}

}