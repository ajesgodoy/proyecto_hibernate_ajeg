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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Esta clase representa un cine. Es una entidad que se mapeará a una tabla en
 * la base de datos.
 */
@Entity
@Table(name = "Cine") // Especifica que esta clase se mapeará a la tabla "cine".
public class Cine {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * 
	 */
	@Column(nullable = false, length = 100)
	private String nombre;

	/**
	 * 
	 */
	private String ubicacion;

	/**
	 * Relación 1:N unidireccional con Sala
	 */
	@OneToMany(mappedBy = "cine", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Sala> salas;

	/**
	 * 
	 */
	@OneToOne(mappedBy = "cine", cascade = CascadeType.ALL, orphanRemoval = true)
	private TiendaBar tiendaBar;

	/**
	 * Constructor sin parámetros, necesario para JPA.
	 */
	public Cine() {
		super();
	}

	/**
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
	 * @return the tiendaBar
	 */
	public TiendaBar getTiendaBar() {
		return tiendaBar;
	}

	/**
	 * @param tiendaBar the tiendaBar to set
	 */
	public void setTiendaBar(TiendaBar tiendaBar) {
		this.tiendaBar = tiendaBar;
		if (tiendaBar != null) {
			tiendaBar.setCine(this);
		}
	}

	/**
	 * @param sala
	 */
	public void addSala(Sala sala) {
		this.salas.add(sala);
		sala.setCine(this);
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
		return "Cine [id=" + id + ", nombre=" + nombre + ", ubicacion=" + ubicacion + ", salas=" + salas
				+ ", tiendaBar=" + tiendaBar + "]";
	}

}
