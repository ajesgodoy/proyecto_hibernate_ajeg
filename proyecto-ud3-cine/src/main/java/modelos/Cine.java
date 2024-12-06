package modelos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Esta clase representa un cine. Es una entidad que se mapeará a una tabla en
 * la base de datos.
 */
@Entity
@Table(name = "cine") // Especifica que esta clase se mapeará a la tabla "cine".
public class Cine {

	/**
	 * Id del cine
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * Nombre del cine
	 */
	@Column(nullable = false, length = 100)
	private String nombre;

	/**
	 * Ubicación del cine
	 */
	private String ubicacion;

	/**
	 * Salas del cine Relación 1:N unidireccional con Sala
	 */
	@OneToMany(mappedBy = "cine", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Sala> salas;

	/**
	 * Constructor sin parámetros, necesario para JPA.
	 */
	public Cine() {
		super();
	}

	/**
	 * Constructor con parámetros.
	 * 
	 * @param nombre
	 * @param ubicacion
	 */
	public Cine(String nombre, String ubicacion) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.salas = new HashSet<>();
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
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * @return the salas
	 */
	public Set<Sala> getSalas() {
		return salas;
	}

	/**
	 * @param salas the salas to set
	 */
	public void setSalas(Set<Sala> salas) {
		this.salas = salas;
	}

	/**
	 * Añade una Sala del Cine y añade la referencia al Cine en la Sala.
	 * 
	 * @param sala
	 */
	public void addSala(Sala sala) {
		this.salas.add(sala);
		sala.setCine(this);
	}

	/**
	 * Elimina una Sala del Cine y elimina la referencia al Cine en la Sala.
	 * 
	 * @param sala La Sala que se desea eliminar.
	 */
	public void removeSala(Sala sala) {
		if (this.salas.remove(sala)) { // Si la Sala estaba en la lista y se eliminó
			sala.setCine(null); // Eliminamos la referencia al Cine en la Sala
		}
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
		Cine other = (Cine) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Cine [id=" + id + ", nombre=" + nombre + ", ubicacion=" + ubicacion + ", salas=" + salas + "]";
	}

}
