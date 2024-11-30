/**
 * 
 */
package dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import jakarta.persistence.PersistenceException;
import modelos.Espectador;
import utiles.AbstractDao;
import utiles.HibernateUtil;

/**
 * DAO específico para la entidad Espectador.
 */
public class EspectadorDao extends AbstractDao<Espectador> {

	/**
	 * 
	 */
	private static final Logger LOGGER = LogManager.getLogger(EspectadorDao.class);

	/**
	 * Constructor
	 */
	public EspectadorDao() {
		// Configuramos la clase Espectador para este DAO
		setClase(Espectador.class);
	}

	/**
	 * @param id
	 * @return session.find(Espectador.class, dni)
	 */
	public Espectador get(String dni) {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		return session.find(Espectador.class, dni);
	}

	@Override
	public void create(Espectador espectador) {
		try {
			// Verificar si el DNI ya existe antes de insertar
			if (get(espectador.getDni()) != null) {
				LOGGER.warn("Espectador con DNI " + espectador.getDni() + " ya existe.");
			} else {
				super.create(espectador);
			}
		} catch (PersistenceException e) {
			LOGGER.error("Error al insertar el espectador: " + e.getMessage());
		}
	}

}
