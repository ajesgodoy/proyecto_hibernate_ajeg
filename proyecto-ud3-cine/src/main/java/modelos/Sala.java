/**
 * 
 */
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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Representa una sala de cine. Cada sala tiene un nombre, una capacidad y un
 * conjunto de películas proyectadas.
 */
@Entity
@Table(name = "sala")
public class Sala {

	/**
	 * Identificador único de la sala (clave primaria).
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * Nombre de la sala (máximo 100 caracteres, obligatorio).
	 */
	@Column(nullable = false, length = 100)
	private String nombre;

	/**
	 * Capacidad máxima de la sala.
	 */
	@Column(nullable = false)
	private int capacidad;

	/**
	 * Conjunto de películas proyectadas en esta sala. Relación ManyToMany.
	 */
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "sala_pelicula", // Nombre de la tabla intermedia
			joinColumns = @JoinColumn(name = "sala_id"), // Clave foránea de 'Sala'
			inverseJoinColumns = @JoinColumn(name = "pelicula_id") // Clave foránea de 'Pelicula'
	)
	private Set<Pelicula> peliculas;

	/**
	 * Cine que tiene la sala
	 */
	@ManyToOne
	@JoinColumn(name = "cine_id")
	private Cine cine;

	/**
	 * Proyector de la sala de cine
	 */
	@OneToOne
	@JoinColumn(name = "proyector_id", nullable = true)
	private Proyector proyector;

	/**
	 * Constructor sin parámetros, requerido por JPA.
	 */
	public Sala() {
		super();
		this.peliculas = new HashSet<>();
	}

	/**
	 * Constructor para inicializar una sala con sus atributos.
	 *
	 * @param nombre    el nombre de la sala.
	 * @param capacidad la capacidad máxima de la sala.
	 */
	public Sala(String nombre, int capacidad) {
		super();
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.peliculas = new HashSet<>();
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
	 * @return the capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * @param capacidad the capacidad to set
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	/**
	 * @return the peliculas
	 */
	public Set<Pelicula> getPeliculas() {
		return peliculas;
	}

	/**
	 * @param peliculas the peliculas to set
	 */
	public void setPeliculas(Set<Pelicula> peliculas) {
		this.peliculas = peliculas;
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
		if (cine != null && !cine.getSalas().contains(this)) {
			cine.getSalas().add(this);
		}
	}

	/**
	 * @return the proyector
	 */
	public Proyector getProyector() {
		return proyector;
	}

	/**
	 * @param proyector the proyector to set
	 */
	public void setProyector(Proyector proyector) {
		this.proyector = proyector;
	}

	/**
	 * Añade una película a la sala y sincroniza la relación bidireccional.
	 *
	 * @param pelicula la película a añadir.
	 */
	public void addPelicula(Pelicula pelicula) {
		this.peliculas.add(pelicula);
		if (!pelicula.getSalas().contains(this)) {
			pelicula.getSalas().add(this);
		}
	}

	/**
	 * Elimina una película de la sala y sincroniza la relación bidireccional.
	 *
	 * @param pelicula la película a eliminar.
	 */
	public void removePelicula(Pelicula pelicula) {
		this.peliculas.remove(pelicula);
		if (!pelicula.getSalas().contains(this)) {
			pelicula.getSalas().add(this);
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
		Sala other = (Sala) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		String cadena = "Sala [id=" + id + ", nombre=" + nombre + ", capacidad=" + capacidad + ", proyector="
				+ proyector;

		// Evitar recursión infinita mostrando solo la cantidad de películas asociadas
		if (!peliculas.isEmpty()) {
			cadena += ", peliculas=" + peliculas.size(); // Mostrar solo la cantidad de películas
		}

		return cadena + "]";
	}
}
