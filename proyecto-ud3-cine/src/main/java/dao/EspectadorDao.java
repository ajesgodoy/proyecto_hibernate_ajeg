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
 * DAO específico para la entidad Espectador. Esta clase maneja las operaciones
 * de persistencia relacionadas con los objetos Espectador. Hereda de la clase
 * AbstractDao y proporciona funcionalidades específicas para el manejo de
 * Espectadores.
 */
public class EspectadorDao extends AbstractDao<Espectador> {

	/**
	 * Logger para registrar eventos relacionados con EspectadorDao.
	 */
	private static final Logger LOGGER = LogManager.getLogger(EspectadorDao.class);

	/**
	 * Constructor de EspectadorDao. Configura la clase Espectador para este DAO al
	 * inicializar el DAO.
	 */
	public EspectadorDao() {
		// Configuramos la clase Espectador para este DAO
		setClase(Espectador.class);
	}

	/**
	 * Recupera un espectador mediante su DNI.
	 * 
	 * @param dni El DNI del espectador que se desea recuperar.
	 * @return El objeto Espectador correspondiente al DNI, o null si no se
	 *         encuentra.
	 */
	public Espectador get(String dni) {
		// Abrir una nueva sesión para la consulta
		Session session = HibernateUtil.getFactoriaSession().openSession();
		// Buscar y retornar el espectador por su DNI
		return session.find(Espectador.class, dni);
	}

	/**
	 * Crea un nuevo espectador en la base de datos. Primero verifica si ya existe
	 * un espectador con el mismo DNI. Si el espectador ya existe, no realiza la
	 * inserción.
	 * 
	 * @param espectador El objeto Espectador a insertar en la base de datos.
	 */
	@Override
	public void create(Espectador espectador) {
		try {
			// Verificar si el DNI ya existe antes de insertar
			if (get(espectador.getDni()) != null) {
				LOGGER.warn("Espectador con DNI " + espectador.getDni() + " ya existe.");
			} else {
				// Si no existe, se realiza la inserción
				super.create(espectador);
			}
		} catch (PersistenceException e) {
			// Manejo de errores en caso de fallos de persistencia
			LOGGER.error("Error al insertar el espectador: " + e.getMessage());
		}
	}
}
