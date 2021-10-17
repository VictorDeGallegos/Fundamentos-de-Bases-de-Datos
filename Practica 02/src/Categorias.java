/**
* CATEGORIAS,getters and setters.
* @author JAVATAR.
* @version 1.0, Octubre 2021.
* @since Fundamentos de bases de datos, Prática 2.
*/

public class Categorias {

	/**
	 * Atributos de la clase Categoria
	 */

	private String nombreCategoria;
	private String descripcionCategoria; //paterno
	private int numeroProductos; // podria funcionar como telefono
	private int id;

	public Categorias (String nombreCategoria, String descripcionCategoria, int numeroProductos) {
		
		this.nombreCategoria = nombreCategoria;
		this.descripcionCategoria = descripcionCategoria;
		this.numeroProductos = numeroProductos;
		this.id = id;
	}

	/**
	 * Setters de Categorias.
	 */
	
	// Nombre de la categoria

	public void setNombreCategoria(String nombreCategoria){
		this.nombreCategoria = nombreCategoria;
	}

	public String getNombreCategoria(){
		return this.nombreCategoria;
	}

	//Descripcion de la categoria 

	public void setDescripcionCategoria(String descripcionCategoria){
		this.descripcionCategoria = descripcionCategoria;
	}

	public String getDescripcionCategoria(){
		return this.descripcionCategoria;
	}

	//Numero de productos en la categoria

	public void setNumeroProductos(int numeroProductos){
		this.numeroProductos = numeroProductos;
	}

	public int getNumeroProductos(){
		return this.numeroProductos;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return this.id;
	}


	// ToString
	public String toString() {

		String s ="ID: "+this.id+
				  "\n"+"Nombre de la categoria: " + this.nombreCategoria + 
				  "\n"+"Numero de proctos en esta categoria: " + this.numeroProductos + 
				  "\n"+"Descripcion de la categoria:  "+ this.descripcionCategoria+ "\n";
		return s;
	}

}
