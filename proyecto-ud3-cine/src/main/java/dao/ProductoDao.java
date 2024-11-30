package dao;

import modelos.Producto;
import utiles.AbstractDao;

/**
 * DAO específico para la entidad Producto.
 */
public class ProductoDao extends AbstractDao<Producto> {
	/**
	 * Constructor
	 */
	public ProductoDao() {
		// Configuramos la clase Producto para este DAO
		setClase(Producto.class);
	}

}
