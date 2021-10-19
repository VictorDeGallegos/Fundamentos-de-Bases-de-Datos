/**
 * CATEGORIAS,getters and setters.
 * 
 * @author JAVATAR.
 * @version 1.0, Octubre 2021.
 * @since Fundamentos de bases de datos, Prática 2.
 */

public class Categorias {

	/**
	 * Atributos de la clase Categoria
	 */

	private int id;
	private String nombreCategoria;
	private String descripcionCategoria; // paterno
	private String numeroProductos; // podria funcionar como telefono

	public Categorias(int id, String nombreCategoria, String descripcionCategoria, String numeroProductos) {

		this.nombreCategoria = nombreCategoria;
		this.descripcionCategoria = descripcionCategoria;
		this.numeroProductos = numeroProductos;
		this.id = id;
	}

	/**
	 * Setters de Categorias.
	 */

	// Nombre de la categoria

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	/**
	 * @return String
	 */
	public String getNombreCategoria() {
		return this.nombreCategoria;
	}

	/**
	 * @param descripcionCategoria
	 */
	// Descripcion de la categoria

	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}

	/**
	 * @return String
	 */
	public String getDescripcionCategoria() {
		return this.descripcionCategoria;
	}

	/**
	 * @param numeroProductos
	 */
	// Numero de productos en la categoria

	public void setNumeroProductos(String numeroProductos) {
		this.numeroProductos = numeroProductos;
	}

	/**
	 * @return String
	 */
	public String getNumeroProductos() {
		return this.numeroProductos;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return int
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @return String
	 */
	// ToString
	public String toString() {

		String s = "ID: " + this.id + "\n" + "Nombre de la categoria: " + this.nombreCategoria + "\n"
				+ "Numero de proctos en esta categoria: " + this.numeroProductos + "\n" + "Descripcion de la categoria:  "
				+ this.descripcionCategoria + "\n";
		return s;
	}

}
