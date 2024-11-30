package dao;

import modelos.Pelicula;
import utiles.AbstractDao;

/**
 * DAO específico para la entidad Pelicula.
 */
public class PeliculaDao extends AbstractDao<Pelicula> {

	/**
	 * Constructor
	 */
	public PeliculaDao() {
		// Configuramos la clase Pelicula para este DAO
		setClase(Pelicula.class);
	}

}
