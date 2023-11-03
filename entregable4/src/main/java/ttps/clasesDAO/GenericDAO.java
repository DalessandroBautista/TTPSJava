package ttps.clasesDAO;

import java.util.List;

public interface GenericDAO<T> {
	public T recuperar(Long id);
	public List<T> recuperarTodos(String m);
	public void guardar(T entity);
	public void actualizar(T entity);
	public void borrar(T entity);
}