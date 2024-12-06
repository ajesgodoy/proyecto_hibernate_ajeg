package dao;

import modelos.Proyector;
import utiles.AbstractDao;

/**
 * DAO específico para la entidad Cine.
 */
public class ProyectorDao extends AbstractDao<Proyector> {

	/**
	 * Constructor
	 */
	public ProyectorDao() {
		// Configuramos la clase Cine para este DAO
		setClase(Proyector.class);
	}

}