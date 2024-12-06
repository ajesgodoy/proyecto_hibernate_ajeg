package modelos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * Representa una película en el sistema de cine. Cada película tiene un título,
 * género, duración y puede estar asignada a múltiples salas.
 */
@Entity
@Table(name = "pelicula")
public class Pelicula {

	/**
	 * Identificador único de la película (clave primaria).
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * Título de la película (máximo 100 caracteres, obligatorio).
	 */
	@Column(nullable = false, length = 100)
	private String titulo;

	/**
	 * Género de la película (opcional).
	 */
	@Column(length = 50)
	private String genero;

	/**
	 * Duración de la película en minutos.
	 */
	private int duracion;

	/**
	 * Conjunto de salas en las que se proyecta esta película. Relación ManyToMany.
	 */
	@ManyToMany(mappedBy = "peliculas")
	private Set<Sala> salas;

	/**
	 * Constructor sin parámetros, requerido por JPA.
	 */
	public Pelicula() {
		super();
		this.salas = new HashSet<>();
	}

	/**
	 * Constructor para inicializar una película con sus atributos.
	 *
	 * @param titulo   el título de la película.
	 * @param genero   el género de la película.
	 * @param duracion la duración en minutos de la película.
	 */
	public Pelicula(String titulo, String genero, int duracion) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.duracion = duracion;
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
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the duracion
	 */
	public int getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
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
	 * Añade una sala a la película y sincroniza la relación bidireccional.
	 * 
	 * @param sala
	 */
	public void addSala(Sala sala) {
		this.salas.add(sala);
		if (!sala.getPeliculas().contains(this)) {
			sala.getPeliculas().add(this);
		}
	}

	/**
	 * Elimina una sala de la película y sincroniza la relación bidireccional.
	 * 
	 * @param sala
	 */
	public void removeSala(Sala sala) {
		if (this.salas.contains(sala)) {
			this.salas.remove(sala);
			sala.getPeliculas().remove(this); // Eliminar la referencia en la Sala
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
		Pelicula other = (Pelicula) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		String cadena = "Pelicula [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", duracion=" + duracion;

		// Evitar recursión infinita al no mostrar las salas si la relación es recursiva
		if (!salas.isEmpty()) {
			cadena += ", salas=" + salas.size(); // Mostrar solo la cantidad de salas
		}

		return cadena + "]";
	}

}
