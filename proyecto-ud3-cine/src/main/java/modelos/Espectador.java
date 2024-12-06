/**
 * 
 */
package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Representa un espectador
 */
@Entity
@Table(name = "espectador")
public class Espectador {

	/**
	 * DNI
	 */
	@Id
	private String dni;

	/**
	 * Nombre
	 */
	@Column(length = 100)
	private String nombre;

	/**
	 * Edad
	 */
	private int edad;

	/**
	 * Pedidos
	 */
	@OneToMany(mappedBy = "espectador", cascade = CascadeType.MERGE)
	private List<Pedido> pedidos;

	/**
	 * Película
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pelicula_id") // Clave foránea en la tabla Pelicula
	private Pelicula pelicula;

	/**
	 * Constructor sin parámetros, necesario para JPA.
	 */
	public Espectador() {
		super();
		this.pedidos = new ArrayList<>();
	}

	/**
	 * Constructor con parámetros.
	 * 
	 * @param dni
	 * @param nombre
	 * @param edad
	 */
	public Espectador(String dni, String nombre, int edad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.pedidos = new ArrayList<>();

	}

	/**
	 * Constructor con parámetros.
	 * 
	 * @param dni
	 * @param nombre
	 * @param edad
	 * @param pelicula
	 */
	public Espectador(String dni, String nombre, int edad, Pelicula pelicula) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.pedidos = new ArrayList<>();
		this.pelicula = pelicula;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
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
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
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

	/**
	 * @return the pelicula
	 */
	public Pelicula getPelicula() {
		return pelicula;
	}

	/**
	 * @param pelicula the pelicula to set
	 */
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	/**
	 * @param pedido
	 */
	public void addPedido(Pedido pedido) {
		this.pedidos.add(pedido);
		pedido.setEspectador(this); // Establecer la relación bidireccional
	}

	/**
	 * @param pedido
	 */
	public void removePedido(Pedido pedido) {
		this.pedidos.remove(pedido);
		pedido.setEspectador(this); // Establecer la relación bidireccional
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Espectador other = (Espectador) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Espectador [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", pedidos=" + pedidos
				+ ", pelicula=" + pelicula + "]";
	}

}
