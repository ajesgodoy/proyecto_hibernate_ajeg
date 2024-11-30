package dao;

import modelos.Pedido;
import utiles.AbstractDao;

/**
 * DAO específico para la entidad Pedido.
 */
public class PedidoDao extends AbstractDao<Pedido> {

	/**
	 * Constructor
	 */
	public PedidoDao() {
		// Configuramos la clase Pedido para este DAO
		setClase(Pedido.class);
	}
}
