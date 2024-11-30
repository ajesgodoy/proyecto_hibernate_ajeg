package dao;

import modelos.Sala;
import utiles.AbstractDao;

/**
 * DAO específico para la entidad Sala.
 */
public class SalaDao extends AbstractDao<Sala> {

	/**
	 * Constructor
	 */
	public SalaDao() {
		// Configuramos la clase Sala para este DAO
		setClase(Sala.class);
	}

}
