package modelos;

import java.time.LocalDateTime;
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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Representa un pedido
 */
@Entity
@Table(name = "pedido")
public class Pedido {

	/**
	 * id del pedido
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pedido")
	private int id;

	/**
	 * Importe del pedido
	 */
	@Column(nullable = false)
	private double importe;

	/**
	 * Fecha del pedido
	 */
	private LocalDateTime fecha;

	/**
	 * Conjunto de productos de un pedido. Relación ManyToMany.
	 */
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "pedido_producto", // Nombre de la tabla intermedia
			joinColumns = @JoinColumn(name = "pedido_id"), // Clave foránea de 'Pedido'
			inverseJoinColumns = @JoinColumn(name = "producto_id") // Clave foránea de 'Producto'
	)
	private List<Producto> productos;

	/**
	 * Espectador
	 */
	@ManyToOne
	private Espectador espectador;

	/**
	 * Constructor sin parámetros, necesario para JPA.
	 */
	public Pedido() {
		super();
		this.productos = new ArrayList<>();
		this.importe = 0.0;
	}

	/**
	 * Constructor con parámetros.
	 * 
	 * @param importe
	 * @param fecha
	 */
	public Pedido(double importe, LocalDateTime fecha) {
		super();
		this.importe = importe;
		this.fecha = fecha;
		this.productos = new ArrayList<>();
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
	 * @return the importe
	 */
	public double getImporte() {
		return importe;
	}

	/**
	 * @param importe the importe to set
	 */
	public void setImporte(double importe) {
		this.importe = importe;
	}

	/**
	 * @return the fecha
	 */
	public LocalDateTime getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
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
	 * @return the espectador
	 */
	public Espectador getEspectador() {
		return espectador;
	}

	/**
	 * @param espectador the espectador to set
	 */
	public void setEspectador(Espectador espectador) {
		this.espectador = espectador;
	}

	/**
	 * Añadir un producto al pedido y ajustar el importe total
	 * 
	 * @param producto
	 */
	public void addProducto(Producto producto) {
		this.productos.add(producto);
		this.importe += producto.getPrecio(); // Suma el precio del producto al importe total del pedido
	}

	/**
	 * Eliminar un producto del pedido y ajustar el importe total
	 * 
	 * @param producto
	 */
	public void removeProducto(Producto producto) {
		this.productos.remove(producto);
		this.importe -= producto.getPrecio();
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
		Pedido other = (Pedido) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", titulo=" + importe + ", fecha=" + fecha + ", productos=" + productos
				+ ", espectador=" + espectador + "]";
	}

}
