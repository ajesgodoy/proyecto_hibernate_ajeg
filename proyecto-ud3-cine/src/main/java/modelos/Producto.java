package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * Representa un producto de la tienda bar.
 */
@Entity
@Table(name = "producto")
public class Producto {

	/**
	 * Identificador único del producto (clave primaria).
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * Nombre del producto (máximo 100 caracteres).
	 */
	@Column(nullable = false, length = 100)
	private String nombre;

	/**
	 * Categoría del producto (opcional).
	 */
	@Column(length = 50)
	private String categoria;

	/**
	 * Precio del producto en euros.
	 */
	@Column(nullable = false)
	private double precio;

	/**
	 * Conjunto de pedidos que tienen un producto. Relación ManyToMany.
	 */
	@ManyToMany(mappedBy = "productos")
	private List<Pedido> pedidos;

	/**
	 * Constructor sin parámetros, requerido por JPA.
	 * 
	 */
	public Producto() {
		super();
		this.pedidos = new ArrayList<>();
	}

	/**
	 * Constructor para inicializar un producto con sus atributos.
	 *
	 * @param nombre    el nombre del producto.
	 * @param categoria la categoría del producto.
	 * @param precio    el precio del producto.
	 */
	public Producto(String nombre, String categoria, double precio) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.pedidos = new ArrayList<>();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the pedidos
	 */
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	/**
	 * @param pedidos the pedidos to set
	 */
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
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
		Producto other = (Producto) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", precio=" + precio + "]";
	}

}