package servicios;

import java.util.List;

import dao.CineDao;
import dao.EspectadorDao;
import dao.PedidoDao;
import dao.PeliculaDao;
import dao.ProductoDao;
import dao.ProyectorDao;
import dao.SalaDao;
import dao.TiendaBarDao;
import jakarta.transaction.Transactional;
import modelos.Cine;
import modelos.Espectador;
import modelos.Pedido;
import modelos.Pelicula;
import modelos.Producto;
import modelos.Proyector;
import modelos.Sala;
import modelos.TiendaBar;

/**
 * Clase Servicio que actúa como capa de lógica de negocio. Gestiona operaciones
 * CRUD para las entidades del sistema.
 */
public class Servicio {

	/**
	 * Objeto de acceso a datos (DAO) para gestionar operaciones relacionadas con
	 * cines.
	 */
	private final CineDao cineDao = new CineDao();

	/**
	 * Objeto de acceso a datos (DAO) para gestionar operaciones relacionadas con
	 * espectadores.
	 */
	private final EspectadorDao espectadorDao = new EspectadorDao();

	/**
	 * Objeto de acceso a datos (DAO) para gestionar operaciones relacionadas con
	 * pedidos.
	 */
	private final PedidoDao pedidoDao = new PedidoDao();

	/**
	 * Objeto de acceso a datos (DAO) para gestionar operaciones relacionadas con
	 * películas.
	 */
	private final PeliculaDao peliculaDao = new PeliculaDao();

	/**
	 * Objeto de acceso a datos (DAO) para gestionar operaciones relacionadas con
	 * productos.
	 */
	private final ProductoDao productoDao = new ProductoDao();

	/**
	 * Objeto de acceso a datos (DAO) para gestionar operaciones relacionadas con
	 * salas.
	 */
	private final SalaDao salaDao = new SalaDao();

	/**
	 * Objeto de acceso a datos (DAO) para gestionar operaciones relacionadas con
	 * proyector.
	 */
	private final ProyectorDao proyectorDao = new ProyectorDao();

	/**
	 * Objeto de acceso a datos (DAO) para gestionar operaciones relacionadas con
	 * tiendasBar.
	 */
	private final TiendaBarDao tiendaBarDao = new TiendaBarDao();

	// Métodos CRUD para Cine

	/**
	 * Crea un nuevo cine en la base de datos.
	 *
	 * @param cine el cine a crear
	 */
	public void crearCine(Cine cine) {
		cineDao.create(cine);
	}

	/**
	 * Obtiene un cine por su identificador.
	 *
	 * @param id el identificador del cine
	 * @return el cine encontrado o null si no existe
	 */
	public Cine obtenerCine(int id) {
		return cineDao.get(id);
	}

	/**
	 * Obtiene una lista de todos los cines.
	 *
	 * @return lista de cines
	 */
	public List<Cine> obtenerTodosLosCines() {
		return cineDao.getAll();
	}

	/**
	 * Actualiza la información de un cine existente.
	 *
	 * @param cine el cine a actualizar
	 */
	public void actualizarCine(Cine cine) {
		cineDao.update(cine);
	}

	/**
	 * Elimina un cine de la base de datos.
	 *
	 * @param cine el cine a eliminar
	 */
	/**
	 * Elimina un Cine de la base de datos, junto con todas sus salas asociadas y
	 * sus relaciones.
	 *
	 * @param cine El Cine que se desea eliminar.
	 */
	public void eliminarCine(Cine cine) {
		cineDao.delete(cine);
	}

	/**
	 * Combina un objeto Cine en la base de datos. Actualiza los datos existentes o
	 * los inserta si no existe.
	 *
	 * @param cine el objeto {@link Cine} a combinar.
	 * @return el objeto {@link Cine} resultante tras la operación.
	 */
	public Cine combinarCine(Cine cine) {
		return cineDao.merge(cine);
	}

	// Métodos CRUD para Proyector

	/**
	 * Crea un nuevo proyector en la base de datos.
	 *
	 * @param proyector el proyector a crear
	 */
	public void crearProyector(Proyector proyector) {
		proyectorDao.create(proyector);
	}

	/**
	 * Obtiene un proyector por su identificador.
	 *
	 * @param id el identificador del proyector
	 * @return el proyector encontrado o null si no existe
	 */
	public Proyector obtenerProyector(int id) {
		return proyectorDao.get(id);
	}

	/**
	 * Obtiene una lista de todos los proyectores.
	 *
	 * @return lista de proyectores
	 */
	public List<Proyector> obtenerTodosLosProyectores() {
		return proyectorDao.getAll();
	}

	/**
	 * Actualiza la información de un proyector existente.
	 *
	 * @param proyector el proyector a actualizar
	 */
	public void actualizarProyector(Proyector proyector) {
		proyectorDao.update(proyector);
	}

	/**
	 * Elimina un proyector de la base de datos.
	 *
	 * @param proyector el proyector a eliminar
	 */
	public void eliminarProyector(Proyector proyector) {
		proyectorDao.delete(proyector);
	}

	/**
	 * Combina un objeto Proyector en la base de datos. Actualiza los datos
	 * existentes o los inserta si no existe.
	 *
	 * @param proyector el objeto {@link Proyector} a combinar.
	 * @return el objeto {@link Proyector} resultante tras la operación.
	 */
	public Proyector combinarProyector(Proyector proyector) {
		return proyectorDao.merge(proyector);
	}

	// Métodos CRUD para Espectador

	/**
	 * Crea un nuevo espectador en la base de datos.
	 *
	 * @param espectador el espectador a crear
	 */
	public void crearEspectador(Espectador espectador) {
		espectadorDao.create(espectador);
	}

	/**
	 * Obtiene un espectador por su DNI.
	 *
	 * @param dni el DNI del espectador
	 * @return el espectador encontrado o null si no existe
	 */
	public Espectador obtenerEspectador(String dni) {
		return espectadorDao.get(dni);
	}

	/**
	 * Obtiene una lista de todos los espectadores.
	 *
	 * @return lista de espectadores
	 */
	public List<Espectador> obtenerTodosLosEspectadores() {
		return espectadorDao.getAll();
	}

	/**
	 * Actualiza la información de un espectador existente.
	 *
	 * @param espectador el espectador a actualizar
	 */
	public void actualizarEspectador(Espectador espectador) {
		espectadorDao.update(espectador);
	}

	/**
	 * Elimina un espectador de la base de datos.
	 *
	 * @param espectador el espectador a eliminar
	 */
	public void eliminarEspectador(Espectador espectador) {
		espectadorDao.delete(espectador);
	}

	/**
	 * Combina un objeto Espectador en la base de datos. Actualiza los datos
	 * existentes o los inserta si no existe.
	 *
	 * @param espectador el objeto {@link Espectador} a combinar.
	 * @return el objeto {@link Espectador} resultante tras la operación.
	 */
	public Espectador combinarEspectador(Espectador espectador) {
		return espectadorDao.merge(espectador);
	}

	// Métodos CRUD para Pedido

	/**
	 * Crea un nuevo pedido en la base de datos.
	 *
	 * @param pedido el pedido a crear
	 */
	public void crearPedido(Pedido pedido) {
		pedidoDao.create(pedido);
	}

	/**
	 * Obtiene un pedido por su identificador.
	 *
	 * @param id el identificador del pedido
	 * @return el pedido encontrado o null si no existe
	 */
	public Pedido obtenerPedido(int id) {
		return pedidoDao.get(id);
	}

	/**
	 * Obtiene una lista de todos los pedidos.
	 *
	 * @return lista de pedidos
	 */
	public List<Pedido> obtenerTodosLosPedidos() {
		return pedidoDao.getAll();
	}

	/**
	 * Actualiza la información de un pedido existente.
	 *
	 * @param pedido el pedido a actualizar
	 */
	public void actualizarPedido(Pedido pedido) {
		pedidoDao.update(pedido);
	}

	/**
	 * Elimina un pedido de la base de datos.
	 *
	 * @param pedido el pedido a eliminar
	 */
	public void eliminarPedido(Pedido pedido) {
		pedidoDao.delete(pedido);
	}

	/**
	 * Combina un objeto Pedido en la base de datos. Actualiza los datos existentes
	 * o los inserta si no existe.
	 *
	 * @param pedido el objeto {@link Pedido} a combinar.
	 * @return el objeto {@link Pedido} resultante tras la operación.
	 */
	public Pedido combinarPedido(Pedido pedido) {
		return pedidoDao.merge(pedido);
	}

	// Métodos CRUD para Pelicula

	/**
	 * Crea una nueva película en la base de datos.
	 *
	 * @param pelicula la película a crear
	 */
	public void crearPelicula(Pelicula pelicula) {
		peliculaDao.create(pelicula);
	}

	/**
	 * Obtiene una película por su identificador.
	 *
	 * @param id el identificador de la película
	 * @return la película encontrada o null si no existe
	 */
	public Pelicula obtenerPelicula(int id) {
		return peliculaDao.get(id);
	}

	/**
	 * Obtiene una lista de todas las películas.
	 *
	 * @return lista de películas
	 */
	public List<Pelicula> obtenerTodasLasPeliculas() {
		return peliculaDao.getAll();
	}

	/**
	 * Actualiza la información de una película existente.
	 *
	 * @param pelicula la película a actualizar
	 */
	public void actualizarPelicula(Pelicula pelicula) {
		peliculaDao.update(pelicula);
	}

	/**
	 * Elimina una película de la base de datos.
	 *
	 * @param pelicula la película a eliminar
	 */
	@Transactional
	public void eliminarPelicula(Pelicula pelicula) {
		peliculaDao.delete(pelicula);
	}

	/**
	 * Combina un objeto Pelicula en la base de datos. Actualiza los datos
	 * existentes o los inserta si no existe.
	 *
	 * @param pelicula el objeto {@link Pelicula} a combinar.
	 * @return el objeto {@link Pelicula} resultante tras la operación.
	 */
	public Pelicula combinarPelicula(Pelicula pelicula) {
		return peliculaDao.merge(pelicula);
	}

	// Métodos CRUD para Producto

	/**
	 * Crea un nuevo producto en el sistema.
	 *
	 * @param producto el objeto Producto a crear
	 */
	public void crearProducto(Producto producto) {
		productoDao.create(producto);
	}

	/**
	 * Obtiene un producto por su ID.
	 *
	 * @param id el ID del producto
	 * @return el objeto Producto correspondiente, o null si no existe
	 */
	public Producto obtenerProducto(int id) {
		return productoDao.get(id);
	}

	/**
	 * Obtiene una lista de todos los productos registrados.
	 *
	 * @return una lista de objetos Producto
	 */
	public List<Producto> obtenerTodosLosProductos() {
		return productoDao.getAll();
	}

	/**
	 * Actualiza la información de un producto existente.
	 *
	 * @param producto el objeto Producto con la información actualizada
	 */
	public void actualizarProducto(Producto producto) {
		productoDao.update(producto);
	}

	/**
	 * Elimina un producto del sistema.
	 *
	 * @param producto el objeto Producto a eliminar
	 */
	public void eliminarProducto(Producto producto) {
		productoDao.delete(producto);
	}

	/**
	 * Combina un objeto Producto en la base de datos. Actualiza los datos
	 * existentes o los inserta si no existe.
	 *
	 * @param producto el objeto {@link Producto} a combinar.
	 * @return el objeto {@link Producto} resultante tras la operación.
	 */
	public Producto combinarProducto(Producto producto) {
		return productoDao.merge(producto);
	}

	// Métodos CRUD para Sala

	/**
	 * Crea una nueva sala en el sistema.
	 *
	 * @param sala el objeto Sala a crear
	 */
	public void crearSala(Sala sala) {
		salaDao.create(sala);
	}

	/**
	 * Obtiene una sala por su ID.
	 *
	 * @param id el ID de la sala
	 * @return el objeto Sala correspondiente, o null si no existe
	 */
	public Sala obtenerSala(int id) {
		return salaDao.get(id);
	}

	/**
	 * Obtiene una lista de todas las salas registradas.
	 *
	 * @return una lista de objetos Sala
	 */
	public List<Sala> obtenerTodasLasSalas() {
		return salaDao.getAll();
	}

	/**
	 * Actualiza la información de una sala existente.
	 *
	 * @param sala el objeto Sala con la información actualizada
	 */
	public void actualizarSala(Sala sala) {
		salaDao.update(sala);
	}

//	/**
//	 * Elimina una sala del sistema.
//	 *
//	 * @param sala el objeto Sala a eliminar
//	 */
//	public void eliminarSala(Sala sala) {
//		salaDao.delete(sala);
//	}
//	
	/**
	 * Elimina una Sala de su Cine asociado, junto con todas sus asociaciones, y la
	 * elimina de la base de datos.
	 *
	 * @param sala La Sala que se desea eliminar.
	 */
	public void eliminarSala(Sala sala) {
		if (sala == null) {
			throw new IllegalArgumentException("La sala no puede ser nula.");
		}

		// Desvincular la sala de su cine, si existe
		if (sala.getCine() != null) {
			sala.getCine().getSalas().remove(sala);
			sala.setCine(null);
		}

		// Desvincular películas asociadas a la sala
		if (sala.getPeliculas() != null) {
			for (Pelicula pelicula : sala.getPeliculas()) {
				pelicula.removeSala(sala);
			}
			sala.setPeliculas(null);
		}

		// Desvincular el proyector asociado a la sala
		sala.setProyector(null);

		// Eliminar la sala de la base de datos
		salaDao.delete(sala);

	}

	/**
	 * Combina un objeto Sala en la base de datos. Actualiza los datos existentes o
	 * los inserta si no existe.
	 *
	 * @param sala el objeto {@link Sala} a combinar.
	 * @return el objeto {@link Sala} resultante tras la operación.
	 */
	public Sala combinarSala(Sala sala) {
		return salaDao.merge(sala);
	}

	// Métodos CRUD para TiendaBar

	/**
	 * Crea una nueva tienda-bar en el sistema.
	 *
	 * @param tiendaBar el objeto TiendaBar a crear
	 */
	public void crearTiendaBar(TiendaBar tiendaBar) {
		tiendaBarDao.create(tiendaBar);
	}

	/**
	 * Obtiene una tienda-bar por su ID.
	 *
	 * @param id el ID de la tienda-bar
	 * @return el objeto TiendaBar correspondiente, o null si no existe
	 */
	public TiendaBar obtenerTiendaBar(int id) {
		return tiendaBarDao.get(id);
	}

	/**
	 * Obtiene una lista de todas las tiendas-bar registradas.
	 *
	 * @return una lista de objetos TiendaBar
	 */
	public List<TiendaBar> obtenerTodasLasTiendasBar() {
		return tiendaBarDao.getAll();
	}

	/**
	 * Actualiza la información de una tienda-bar existente.
	 *
	 * @param tiendaBar el objeto TiendaBar con la información actualizada
	 */
	public void actualizarTiendaBar(TiendaBar tiendaBar) {
		tiendaBarDao.update(tiendaBar);
	}

	/**
	 * Elimina una tienda-bar del sistema.
	 *
	 * @param tiendaBar el objeto TiendaBar a eliminar
	 */
	public void eliminarTiendaBar(TiendaBar tiendaBar) {
		tiendaBarDao.delete(tiendaBar);
	}

	/**
	 * Combina un objeto TiendaBar en la base de datos. Actualiza los datos
	 * existentes o los inserta si no existe.
	 *
	 * @param tiendaBar el objeto {@link TiendaBar} a combinar.
	 * @return el objeto {@link TiendaBar} resultante tras la operación.
	 */
	public TiendaBar combinarTiendaBar(TiendaBar tiendaBar) {
		return tiendaBarDao.merge(tiendaBar);
	}

}
