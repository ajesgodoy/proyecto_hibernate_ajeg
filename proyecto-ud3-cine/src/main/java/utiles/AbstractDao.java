/**
 * 
 */
package utiles;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.TypedQuery;

/**
 * @param <T>
 */
public abstract class AbstractDao<T> implements IDao<T> {
	/**
	 * 
	 */
	private Class<T> clase;

	@Override
	public void create(T t) {
		executeInsideTransaction(t);
	}

	@Override
	public T get(int id) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		return sesion.find(clase, id);
	}

	@Override
	public List<T> getAll() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String queryString = "FROM " + clase.getName();
		TypedQuery<T> query = sesion.createQuery(queryString, clase);
		List<T> resultados = query.getResultList();
		return resultados;
	}

	@Override
	public void update(T t) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		executeInsideTransaction(sesion, sesion.merge(t));
	}

	// Merge

	@Override
	public void delete(T t) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		// Registramos una transacción
		Transaction tx = sesion.beginTransaction();
		try {
			sesion.remove(t);
			tx.commit();

		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}

	}

	/**
	 * @param sesion
	 * @param objecto
	 */
	private void executeInsideTransaction(Session sesion, T objecto) {
		// Registramos una transacción
		Transaction tx = sesion.beginTransaction();
		try {
			sesion.persist(objecto);
			tx.commit();

		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}
	}

	/**
	 * @param objecto
	 */
	private void executeInsideTransaction(T objecto) {
		executeInsideTransaction(HibernateUtil.getFactoriaSession().openSession(), objecto);
	}

	/**
	 * @return the clase
	 */
	public Class<T> getClase() {
		return clase;
	}

	/**
	 * @param clase the clase to set
	 */
	public void setClase(Class<T> clase) {
		this.clase = clase;
	}

	/**
	 * @param t
	 * @return sesion.merge(t)
	 */
	public T merge(T t) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		return sesion.merge(t);
	}

}
