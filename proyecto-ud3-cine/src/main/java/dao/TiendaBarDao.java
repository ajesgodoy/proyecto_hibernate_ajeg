package dao;

import modelos.TiendaBar;
import utiles.AbstractDao;

/**
 * DAO específico para la entidad TiendaBar.
 */
public class TiendaBarDao extends AbstractDao<TiendaBar> {

	/**
	 * Constructor
	 */
	public TiendaBarDao() {
		// Configuramos la clase TiendaBar para este DAO
		setClase(TiendaBar.class);
	}
}
