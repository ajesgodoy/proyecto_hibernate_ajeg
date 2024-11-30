package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Representa la tienda del bar del cine. Está asociada a un cine y contiene una
 * lista de productos.
 */
@Entity
@Table(name = "TiendaBar")
public class TiendaBar {

	/**
	 * Identificador único de la tienda (clave primaria).
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/**
	 * Nombre de la tienda bar (máximo 100 caracteres, obligatorio).
	 */
	@Column(nullable = false, length = 100)
	private String nombre;

	/**
	 * Cine asociado a la tienda. Relación OneToOne.
	 */
	@OneToOne
	@JoinColumn(name = "cine_id", nullable = false, unique = true)
	private Cine cine;

	/**
	 * Lista de productos que se venden en la tienda.
	 */
	@OneToMany(cascade = CascadeType.ALL)
	private List<Producto> productos;

	/**
	 * Constructor sin parámetros, necesario para JPA.
	 */
	public TiendaBar() {
		super();
		this.productos = new ArrayList<>();
	}

	/**
	 * @param nombre
	 * @param cine
	 */
	public TiendaBar(String nombre, Cine cine) {
		super();
		this.nombre = nombre;
		this.cine = cine;
		this.productos = new ArrayList<>();
	}

	/**
	 * @param nombre
	 * @param cine
	 * @param productos
	 */
	public TiendaBar(String nombre, Cine cine, List<Producto> productos) {
		super();
		this.nombre = nombre;
		this.cine = cine;
		this.productos = productos;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the cine
	 */
	public Cine getCine() {
		return cine;
	}

	/**
	 * @param cine the cine to set
	 */
	public void setCine(Cine cine) {
		this.cine = cine;
	}

	/**
	 * @return the productos
	 */
	public List<Producto> getProductos() {
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	/**
	 * Añadir producto a la tienda bar del cine
	 * 
	 * @param producto
	 */
	public void addProducto(Producto producto) {
		this.productos.add(producto);

	}

	/**
	 * Eliminar producto a la tienda bar del cine
	 * 
	 * @param producto
	 */
	public void removeProducto(Producto producto) {
		this.productos.remove(producto);

	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TiendaBar other = (TiendaBar) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "TiendaBar [id=" + id + ", nombre=" + nombre + ", cine=" + cine + ", productos=" + productos + "]";
	}

}