/**
 * 
 */
package utiles;

import java.util.List;
// import java.util.Optional;

/**
 * Esta interfaz contiene las operaciones del CRUD Create a element T Retrieve a
 * element and all elements: get Update a element T Delete a element T
 * 
 * @param <T>
 */
public interface IDao<T> {

	/**
	 * @param t
	 */
	void create(T t);

	/**
	 * @param id
	 */
	T get(int id);
	// Optional<T> get(int id); Usamos Optional porque la consulta puede no devolver
	// nada

	/**
	 * 
	 */
	List<T> getAll();

	/**
	 * @param t
	 */
	void update(T t);

	/**
	 * @param t
	 */
	void delete(T t);
}