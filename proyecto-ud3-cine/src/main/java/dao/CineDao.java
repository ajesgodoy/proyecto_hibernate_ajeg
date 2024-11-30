package dao;

import modelos.Cine;
import utiles.AbstractDao;

/**
 * DAO específico para la entidad Cine.
 */
public class CineDao extends AbstractDao<Cine> {

	/**
	 * Constructor
	 */
	public CineDao() {
		// Configuramos la clase Cine para este DAO
		setClase(Cine.class);
	}

}