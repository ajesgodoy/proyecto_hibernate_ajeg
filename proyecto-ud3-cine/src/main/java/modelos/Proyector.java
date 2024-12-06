package modelos;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Clase que representa un proyector en el sistema. Un proyector tiene un
 * nombre, un modelo, una marca y una relación con una sala.
 */
@Entity
@Table(name = "proyector")
public class Proyector {

	/**
	 * Identificador único del proyector. Este campo se genera automáticamente
	 * mediante la estrategia AUTO.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_proyector")
	private int id;

	/**
	 * Nombre del proyector (máximo 100 caracteres, obligatorio). Este campo no
	 * puede ser nulo.
	 */
	@Column(nullable = false, length = 100)
	private String nombre;

	/**
	 * Modelo del proyector. Este campo es opcional.
	 */
	private String modelo;

	/**
	 * Marca del proyector. Este campo es opcional.
	 */
	private String marca;

	/**
	 * Sala asociada al proyector. Relación OneToOne. El proyector está relacionado
	 * con una única sala.
	 */
	@OneToOne(mappedBy = "proyector")
	private Sala sala;

	/**
	 * Constructor por defecto. Crea un objeto de la clase Proyector sin inicializar
	 * los atributos.
	 */
	public Proyector() {
		super();
	}

	/**
	 * Constructor con parámetros. Crea un objeto de la clase Proyector con los
	 * atributos inicializados.
	 * 
	 * @param nombre El nombre del proyector.
	 * @param modelo El modelo del proyector.
	 * @param marca  La marca del proyector.
	 */
	public Proyector(String nombre, String modelo, String marca) {
		super();
		this.nombre = nombre;
		this.modelo = modelo;
		this.marca = marca;
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
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the sala
	 */
	public Sala getSala() {
		return sala;
	}

	/**
	 * @param sala the sala to set
	 */
	public void setSala(Sala sala) {
		this.sala = sala;
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
		Proyector other = (Proyector) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Proyector [id=" + id + ", nombre=" + nombre + ", modelo=" + modelo + ", marca=" + marca + ", sala="
				+ sala + "]";
	}

}
