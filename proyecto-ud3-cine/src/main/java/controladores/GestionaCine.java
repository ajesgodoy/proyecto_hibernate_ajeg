package controladores;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.CineDao;
import dao.EspectadorDao;
import dao.PedidoDao;
import dao.PeliculaDao;
import dao.ProductoDao;
import dao.SalaDao;
import dao.TiendaBarDao;
import modelos.Cine;
import modelos.Espectador;
import modelos.Pedido;
import modelos.Pelicula;
import modelos.Producto;
import modelos.Sala;
import modelos.TiendaBar;

/**
 * 
 */
public class GestionaCine {

	/**
	 * 
	 */
	private static final Logger LOGGER = LogManager.getLogger(GestionaCine.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// DAOs para interactuar con la base de datos
		CineDao cineDao = new CineDao();
		SalaDao salaDao = new SalaDao();
		EspectadorDao espectadorDao = new EspectadorDao();
		PedidoDao pedidoDao = new PedidoDao();
		ProductoDao productoDao = new ProductoDao();
		PeliculaDao peliculaDao = new PeliculaDao();
		TiendaBarDao tiendaBarDao = new TiendaBarDao();

		// Crear un cine
		Cine cine = new Cine("Cine Central", "Av. Principal 123");

		// Crear una tienda de bar asociada al cine
		TiendaBar tiendaBar = new TiendaBar("Snack Bar Central", cine);

		// Establecer relación 1:1
		cine.setTiendaBar(tiendaBar);

		// Persistir objetos
		cineDao.create(cine);

		// Verificar datos
		LOGGER.debug(cine);
		LOGGER.debug(tiendaBar);

		// Crear tres salas
		Sala sala1 = new Sala("Sala 1", 100);
		Sala sala2 = new Sala("Sala 2", 150);
		Sala sala3 = new Sala("Sala 3", 120);

		// Asignar las salas al Cine
		cine.addSala(sala1);
		cine.addSala(sala2);
		cine.addSala(sala3);

		// Establcer relación cine-salas
		sala1.setCine(cine);
		sala2.setCine(cine);
		sala3.setCine(cine);

		// Persistir objetos
		salaDao.create(sala1);
		salaDao.create(sala2);
		salaDao.create(sala3);

		// Verificar datos
		LOGGER.debug(cine);
		LOGGER.debug(sala1);
		LOGGER.debug(sala2);
		LOGGER.debug(sala3);

		// Crear y persistir tres películas asociadas a las salas
		Pelicula pelicula1 = new Pelicula("La vida de Brian", "Comedia", 94);
		Pelicula pelicula2 = new Pelicula("Deadpool y Lobezno", "Acción", 127);
		Pelicula pelicula3 = new Pelicula("Shutter Island", "Suspenso", 138);

		// Asignar las películas a las salas
		sala1.addPelicula(pelicula1);
		sala1.addPelicula(pelicula2);
		sala2.addPelicula(pelicula2);
		sala2.addPelicula(pelicula3);
		sala3.addPelicula(pelicula1);

		// Persistir las películas
		peliculaDao.create(pelicula1);
		peliculaDao.create(pelicula2);
		peliculaDao.create(pelicula3);

		// Verificar la relación
		LOGGER.debug(pelicula1);
		LOGGER.debug(pelicula2);
		LOGGER.debug(pelicula3);

		// Actualizar objetos
		salaDao.update(sala1);
		salaDao.update(sala2);
		salaDao.update(sala3);

		// Crear tres espectadores
		Espectador espectador1 = new Espectador("28753422G", "Pedro Navajas", 23);
		Espectador espectador2 = new Espectador("27635451A", "Raúl Chimenea", 30);
		Espectador espectador3 = new Espectador("28669803X", "Hugo Boss", 43);

		// Persistir los espectadores
		espectadorDao.create(espectador1);
		espectadorDao.create(espectador2);
		espectadorDao.create(espectador3);

		// Verificar los datos
		LOGGER.debug(espectador1);
		LOGGER.debug(espectador2);
		LOGGER.debug(espectador3);

		// Asociar películas a espectadores
		espectador1.setPelicula(pelicula1);
		espectador2.setPelicula(pelicula2);
		espectador3.setPelicula(pelicula2);

		// Actualizar espectadores con sus películas
		espectadorDao.update(espectador1);
		espectadorDao.update(espectador2);
		espectadorDao.update(espectador3);

		// Crear productos vendidos en la tienda del cine
		Producto producto1 = new Producto("Palomitas grandes", "Snack", 4.99);
		Producto producto2 = new Producto("Refresco mediano", "Bebida", 2.99);
		Producto producto3 = new Producto("Nachos con queso", "Snack", 6.99);
		Producto producto4 = new Producto("Nachos clásicos", "Snack", 5.99);
		Producto producto5 = new Producto("Nachos sabor barbacoa", "Snack", 6.99);

		// Crear y persistir tres pedidos realizados por los espectadores
		Pedido pedido1 = new Pedido(0.00, LocalDateTime.now(), espectador1);
		Pedido pedido2 = new Pedido(0.00, LocalDateTime.now(), espectador2);
		Pedido pedido3 = new Pedido(0.00, LocalDateTime.now(), espectador3);

		// Asociar productos al pedido
		pedido1.addProducto(producto1);
		pedido2.addProducto(producto2);
		pedido2.addProducto(producto3);
		pedido3.addProducto(producto4);
		pedido3.addProducto(producto5);

		// Persistir los pedidos
		pedidoDao.create(pedido1);
		pedidoDao.create(pedido2);
		pedidoDao.create(pedido3);

		// Verificar los datos
		LOGGER.debug(pedido1);
		LOGGER.debug(pedido2);
		LOGGER.debug(pedido3);

		// Asociar pedidos al espectador
		espectador1.addPedido(pedido1);
		espectador1.addPedido(pedido2);
		espectador2.addPedido(pedido3);

		// Actualizar los espectadores
		espectadorDao.update(espectador1);
		espectadorDao.update(espectador2);

		// Asociar productos a la tienda bar del cine
		tiendaBar.addProducto(producto1);
		tiendaBar.addProducto(producto2);
		tiendaBar.addProducto(producto3);
		tiendaBar.addProducto(producto4);
		tiendaBar.addProducto(producto5);

		// Actualizar la tienda bar
		tiendaBarDao.update(tiendaBar);

		// Mostrar todos los cines
		LOGGER.info("Cines:");
		for (Cine c : cineDao.getAll()) {
			LOGGER.info(c);
		}

		// Mostrar todas las salas
		LOGGER.info("Salas:");
		for (Sala s : salaDao.getAll()) {
			LOGGER.info(s);
		}

		// Mostrar todos los espectadores
		LOGGER.info("Espectadores:");
		for (Espectador e : espectadorDao.getAll()) {
			LOGGER.info(e);
		}

		// Mostrar todos los pedidos
		LOGGER.info("Pedidos:");
		for (Pedido p : pedidoDao.getAll()) {
			LOGGER.info(p);
		}

		// Mostrar todos los productos
		LOGGER.info("Productos:");
		for (Producto pr : productoDao.getAll()) {
			LOGGER.info(pr);
		}

		// Mostrar todas las películas
		LOGGER.info("Películas:");
		for (Pelicula pel : peliculaDao.getAll()) {
			LOGGER.info(pel);
		}

		// Mostrar todas las tiendas de bar
		LOGGER.info("Tiendas de Bar:");
		for (TiendaBar tb : tiendaBarDao.getAll()) {
			LOGGER.info(tb);
		}

	}
}
