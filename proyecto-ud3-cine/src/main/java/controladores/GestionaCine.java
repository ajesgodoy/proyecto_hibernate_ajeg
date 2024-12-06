package controladores;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelos.Cine;
import modelos.Espectador;
import modelos.Pedido;
import modelos.Pelicula;
import modelos.Producto;
import modelos.Proyector;
import modelos.Sala;
import modelos.TiendaBar;
import servicios.Servicio;

/**
 * Clase principal para gestionar la aplicación de gestión de cines. Permite
 * realizar operaciones sobre cines, salas y otros elementos relacionados.
 */
public class GestionaCine {

	/**
	 * Logger para registrar mensajes informativos, de depuración y errores.
	 */
	private static final Logger LOGGER = LogManager.getLogger(GestionaCine.class);

	/**
	 * Método principal de la aplicación. Permite realizar pruebas o ejecutar
	 * funcionalidades relacionadas con la gestión de cines.
	 *
	 * @param args Los argumentos de línea de comandos. Actualmente, no se utilizan.
	 */
	public static void main(String[] args) {

		// Servicio para interactuar con la base de datos
		Servicio servicio = new Servicio();

		// Crear cines
		Cine cine = new Cine("Multicine Central", "Av. Principal 123");
		Cine cineXL = new Cine("Multicine Megalópolis", "Av. Gran Vía 456");

		// Crear una tienda de bar asociada a cada cine
		TiendaBar tiendaBar = new TiendaBar("Snack Bar Central");
		TiendaBar tiendaBarXL = new TiendaBar("Snack Bar Megalópolis");

		// Persistir objetos
		servicio.crearCine(cine);
		servicio.crearCine(cineXL);

		// Verificar datos
		LOGGER.debug(cine);
		LOGGER.debug(cineXL);

		// Crear salas de cine
		Sala sala1 = new Sala("Sala 1", 200);
		Sala sala2 = new Sala("Sala 2", 150);
		Sala sala3 = new Sala("Sala 3", 150);
		Sala sala4 = new Sala("Sala 4", 100);
		Sala sala5 = new Sala("Sala 5", 100);
		Sala sala6 = new Sala("Sala 6", 100);
		Sala salaI = new Sala("Sala I", 300);
		Sala salaII = new Sala("Sala II", 150);
		Sala salaIII = new Sala("Sala III", 100);

		// Asignar las salas a los Cine
		cine.addSala(sala1);
		cine.addSala(sala2);
		cine.addSala(sala3);
		cine.addSala(sala4);
		cine.addSala(sala5);
		cine.addSala(sala6);
		cineXL.addSala(salaI);
		cineXL.addSala(salaII);
		cineXL.addSala(salaIII);

		// Establecer relación cine-salas
		sala1.setCine(cine);
		sala2.setCine(cine);
		sala3.setCine(cine);
		sala4.setCine(cine);
		sala5.setCine(cine);
		sala6.setCine(cine);
		salaI.setCine(cineXL);
		salaII.setCine(cineXL);
		salaIII.setCine(cineXL);

		// Persistir objetos
		servicio.crearSala(sala1);
		servicio.crearSala(sala2);
		servicio.crearSala(sala3);
		servicio.crearSala(sala4);
		servicio.crearSala(sala5);
		servicio.crearSala(sala6);
		servicio.crearSala(salaI);
		servicio.crearSala(salaII);
		servicio.crearSala(salaIII);

		// Verificar datos
		LOGGER.debug(cine);
		LOGGER.debug(cineXL);
		LOGGER.debug(sala1);
		LOGGER.debug(sala2);
		LOGGER.debug(sala3);
		LOGGER.debug(sala4);
		LOGGER.debug(sala5);
		LOGGER.debug(sala6);
		LOGGER.debug(salaI);
		LOGGER.debug(salaII);
		LOGGER.debug(salaIII);

		// Crear proyectores de las salas
		Proyector proyector1 = new Proyector("Proyector Sony 4K", "Sony", "VPL-VW295ES");
		Proyector proyector2 = new Proyector("Proyector LG CineBeam", "LG", "HU810PW");
		Proyector proyector3 = new Proyector("Proyector Epson Full HD", "Epson", "HC 2250");
		Proyector proyector4 = new Proyector("Proyector Panasonic Laser", "Panasonic", "PT-VMZ60U");
		Proyector proyector5 = new Proyector("Proyector BenQ HDR", "BenQ", "TK850i");
		Proyector proyector6 = new Proyector("Proyector JVC D-ILA", "JVC", "DLA-NX7");
		Proyector proyectorI = new Proyector("Proyector Samsung Smart", "Samsung", "The Premiere LSP9T");
		Proyector proyectorII = new Proyector("Proyector Optoma UHD", "Optoma", "UHZ50");
		Proyector proyectorIII = new Proyector("Proyector Vivitek Ultra HD", "Vivitek", "HK2288");

		// Establecer relación sala-proyector
		sala1.setProyector(proyector1);
		sala2.setProyector(proyector2);
		sala3.setProyector(proyector3);
		sala4.setProyector(proyector4);
		sala5.setProyector(proyector5);
		sala6.setProyector(proyector6);
		salaI.setProyector(proyectorI);
		salaII.setProyector(proyectorII);
		salaIII.setProyector(proyectorIII);

		// Persistir proyectores
		servicio.crearProyector(proyector1);
		servicio.crearProyector(proyector2);
		servicio.crearProyector(proyector3);
		servicio.crearProyector(proyector4);
		servicio.crearProyector(proyector5);
		servicio.crearProyector(proyector6);
		servicio.crearProyector(proyectorI);
		servicio.crearProyector(proyectorII);
		servicio.crearProyector(proyectorIII);

		// Verificar datos
		LOGGER.debug(proyector1);
		LOGGER.debug(proyector2);
		LOGGER.debug(proyector3);
		LOGGER.debug(proyector4);
		LOGGER.debug(proyector5);
		LOGGER.debug(proyector6);
		LOGGER.debug(proyectorI);
		LOGGER.debug(proyectorII);
		LOGGER.debug(proyectorIII);

		// Crear películas
		Pelicula pelicula1 = new Pelicula("La vida de Brian", "Comedia", 94);
		Pelicula pelicula2 = new Pelicula("Deadpool y Lobezno", "Acción", 127);
		Pelicula pelicula3 = new Pelicula("Shutter Island", "Suspense", 138);
		Pelicula pelicula4 = new Pelicula("El Padrino", "Drama", 175);
		Pelicula pelicula5 = new Pelicula("Jurassic Park", "Ciencia Ficción", 127);
		Pelicula pelicula6 = new Pelicula("Titanic", "Romántico", 195);
		Pelicula pelicula7 = new Pelicula("El regreso del rey", "Aventura", 201);
		Pelicula pelicula8 = new Pelicula("Forrest Gump", "Drama", 142);
		Pelicula pelicula9 = new Pelicula("Inception", "Ciencia Ficción", 148);
		Pelicula pelicula10 = new Pelicula("Gladiator", "Épico", 155);

		// Asignar las películas a las salas
		sala1.addPelicula(pelicula1);
		sala1.addPelicula(pelicula2);
		sala2.addPelicula(pelicula2);
		sala2.addPelicula(pelicula3);
		sala3.addPelicula(pelicula4);
		sala3.addPelicula(pelicula5);
		sala4.addPelicula(pelicula6);
		sala5.addPelicula(pelicula7);
		sala6.addPelicula(pelicula8);
		salaI.addPelicula(pelicula9);
		salaI.addPelicula(pelicula10);
		salaII.addPelicula(pelicula2);
		salaII.addPelicula(pelicula10);
		salaIII.addPelicula(pelicula5);
		salaIII.addPelicula(pelicula6);

		// Persistir las películas
		servicio.crearPelicula(pelicula1);
		servicio.crearPelicula(pelicula2);
		servicio.crearPelicula(pelicula3);
		servicio.crearPelicula(pelicula4);
		servicio.crearPelicula(pelicula5);
		servicio.crearPelicula(pelicula6);
		servicio.crearPelicula(pelicula7);
		servicio.crearPelicula(pelicula8);
		servicio.crearPelicula(pelicula9);
		servicio.crearPelicula(pelicula10);

		// Verificar la relación
		LOGGER.debug(pelicula1);
		LOGGER.debug(pelicula2);
		LOGGER.debug(pelicula3);
		LOGGER.debug(pelicula4);
		LOGGER.debug(pelicula5);
		LOGGER.debug(pelicula6);
		LOGGER.debug(pelicula7);
		LOGGER.debug(pelicula8);
		LOGGER.debug(pelicula9);
		LOGGER.debug(pelicula10);

		// Actualizar objetos
		servicio.actualizarSala(sala1);
		servicio.actualizarSala(sala2);
		servicio.actualizarSala(sala3);
		servicio.actualizarSala(sala4);
		servicio.actualizarSala(sala5);
		servicio.actualizarSala(sala6);
		servicio.actualizarSala(salaI);
		servicio.actualizarSala(salaII);
		servicio.actualizarSala(salaIII);

		// Crear espectadores
		Espectador espectador1 = new Espectador("28753422G", "Pedro Navajas", 23);
		Espectador espectador2 = new Espectador("27635451A", "Raúl Chimenea", 30);
		Espectador espectador3 = new Espectador("28669803X", "Hugo Boss", 43);
		Espectador espectador4 = new Espectador("27346824B", "Pepe Matemático", 35);
		Espectador espectador5 = new Espectador("27646238Z", "Asun Delegada", 25);
		Espectador espectador6 = new Espectador("29342172D", "Jesús ILoveOdoo", 54);

		// Persistir los espectadores
		servicio.crearEspectador(espectador1);
		servicio.crearEspectador(espectador2);
		servicio.crearEspectador(espectador3);
		servicio.crearEspectador(espectador4);
		servicio.crearEspectador(espectador5);
		servicio.crearEspectador(espectador6);

		// Verificar los datos
		LOGGER.debug(espectador1);
		LOGGER.debug(espectador2);
		LOGGER.debug(espectador3);
		LOGGER.debug(espectador4);
		LOGGER.debug(espectador5);
		LOGGER.debug(espectador6);

		// Asociar películas a espectadores
		espectador1.setPelicula(pelicula1);
		espectador2.setPelicula(pelicula2);
		espectador3.setPelicula(pelicula2);
		espectador4.setPelicula(pelicula3);
		espectador5.setPelicula(pelicula6);
		espectador6.setPelicula(pelicula8);

		// Actualizar espectadores con sus películas
		servicio.actualizarEspectador(espectador1);
		servicio.actualizarEspectador(espectador2);
		servicio.actualizarEspectador(espectador3);
		servicio.actualizarEspectador(espectador4);
		servicio.actualizarEspectador(espectador5);
		servicio.actualizarEspectador(espectador6);

		// Crear productos vendidos en la tienda del cine
		Producto producto1 = new Producto("Palomitas grandes", "Snack", 4.99);
		Producto producto2 = new Producto("Refresco mediano", "Bebida", 2.99);
		Producto producto3 = new Producto("Nachos con queso", "Snack", 6.99);
		Producto producto4 = new Producto("Nachos clásicos", "Snack", 5.99);
		Producto producto5 = new Producto("Nachos sabor barbacoa", "Snack", 6.99);
		Producto producto6 = new Producto("Chocolate con leche", "Dulce", 3.49);
		Producto producto7 = new Producto("Agua mineral", "Bebida", 1.99);
		Producto producto8 = new Producto("Gominolas surtidas", "Dulce", 2.49);
		Producto producto9 = new Producto("Hot dog clásico", "Comida", 4.49);
		Producto producto10 = new Producto("Refresco clásico", "Bebida", 2.19);

		// Persistir productos
		servicio.crearProducto(producto1);
		servicio.crearProducto(producto2);
		servicio.crearProducto(producto3);
		servicio.crearProducto(producto4);
		servicio.crearProducto(producto5);
		servicio.crearProducto(producto6);
		servicio.crearProducto(producto7);
		servicio.crearProducto(producto8);
		servicio.crearProducto(producto9);
		servicio.crearProducto(producto10);

		// Crear pedidos realizados por los espectadores
		Pedido pedido1 = new Pedido(0.00, LocalDateTime.now());
		Pedido pedido2 = new Pedido(0.00, LocalDateTime.now());
		Pedido pedido3 = new Pedido(0.00, LocalDateTime.now());
		Pedido pedido4 = new Pedido(0.00, LocalDateTime.now());
		Pedido pedido5 = new Pedido(0.00, LocalDateTime.now());
		Pedido pedido6 = new Pedido(0.00, LocalDateTime.now());

		// Asociar productos al pedido
		pedido1.addProducto(producto1);
		pedido2.addProducto(producto2);
		pedido2.addProducto(producto3);
		pedido3.addProducto(producto4);
		pedido3.addProducto(producto5);
		pedido4.addProducto(producto6);
		pedido4.addProducto(producto7);
		pedido4.addProducto(producto1);
		pedido5.addProducto(producto8);
		pedido5.addProducto(producto9);
		pedido6.addProducto(producto8);
		pedido6.addProducto(producto9);
		pedido6.addProducto(producto10);

		// Verificar los datos
		LOGGER.debug(pedido1);
		LOGGER.debug(pedido2);
		LOGGER.debug(pedido3);
		LOGGER.debug(pedido4);
		LOGGER.debug(pedido5);
		LOGGER.debug(pedido6);

		// Asociar pedidos al espectador
		espectador1.addPedido(pedido1);
		espectador2.addPedido(pedido2);
		espectador3.addPedido(pedido3);
		espectador4.addPedido(pedido4);
		espectador5.addPedido(pedido5);
		espectador5.addPedido(pedido6);

		// Actualizar los espectadores
		servicio.actualizarEspectador(espectador1);
		servicio.actualizarEspectador(espectador2);
		servicio.actualizarEspectador(espectador3);
		servicio.actualizarEspectador(espectador4);
		servicio.actualizarEspectador(espectador5);
		servicio.actualizarEspectador(espectador6);

		// Asociar productos a la tienda bar del cine
		tiendaBar.addProducto(producto1);
		tiendaBar.addProducto(producto2);
		tiendaBar.addProducto(producto3);
		tiendaBar.addProducto(producto4);
		tiendaBar.addProducto(producto5);
		tiendaBar.addProducto(producto6);
		tiendaBar.addProducto(producto7);
		tiendaBarXL.addProducto(producto8);
		tiendaBarXL.addProducto(producto9);
		tiendaBarXL.addProducto(producto10);

		// Actualizar tienda bar
		servicio.actualizarTiendaBar(tiendaBar);
		servicio.actualizarTiendaBar(tiendaBarXL);

		// Mostrar todos los cines
		LOGGER.info("Cines:");
		for (Cine c : servicio.obtenerTodosLosCines()) {
			LOGGER.info(c);
		}

		// Mostrar todas las salas
		LOGGER.info("Salas:");
		for (Sala s : servicio.obtenerTodasLasSalas()) {
			LOGGER.info(s);
		}

		// Mostrar todas las salas
		LOGGER.info("Proyectores:");
		for (Proyector proy : servicio.obtenerTodosLosProyectores()) {
			LOGGER.info(proy);
		}

		// Mostrar todos los espectadores
		LOGGER.info("Espectadores:");
		for (Espectador e : servicio.obtenerTodosLosEspectadores()) {
			LOGGER.info(e);
		}

		// Mostrar todos los pedidos
		LOGGER.info("Pedidos:");
		for (Pedido p : servicio.obtenerTodosLosPedidos()) {
			LOGGER.info(p);
		}

		// Mostrar todos los productos
		LOGGER.info("Productos:");
		for (Producto pr : servicio.obtenerTodosLosProductos()) {
			LOGGER.info(pr);
		}

		// Mostrar todas las películas
		LOGGER.info("Películas:");
		for (Pelicula pel : servicio.obtenerTodasLasPeliculas()) {
			LOGGER.info(pel);
		}

		// Mostrar todas las tiendas de bar
		LOGGER.info("Tiendas de Bar:");
		for (TiendaBar tb : servicio.obtenerTodasLasTiendasBar()) {
			LOGGER.info(tb);
		}

		// Eliminar sala 6
		servicio.eliminarSala(sala6);
		// Eliminar proyector 6
		servicio.eliminarProyector(proyector6);

	}
}
