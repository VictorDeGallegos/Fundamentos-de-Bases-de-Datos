/*
 * author JAVATAR
 *
 * Clase que contiene los datos de los CLientes junto con sus getters y setters
 */
// Clase clientes
public class Clientes {

	// Datos de los clientes

	// Declaracion de variables
	private int id;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombre;
	private String email;
	private String telefono;

	public Clientes(int id, String apellidoPaterno, String apellidoMaterno, String nombre, String email,
			String telefono) {
		this.id = id;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}

	// setters y getters
	public void setId(int id) {
		this.id = id;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getId() {
		return this.id;
	}

	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getEmail() {
		return this.email;
	}

	public String getTelefono() {
		return this.telefono;
	}

	// class toString
	public String toString() {

		String s = "ID Cliente: " + this.id + "\n" + "Nombre: " + this.nombre + "\n" + "Apellido Paterno: "
				+ this.apellidoPaterno + "\n" + "Apellido Materno: " + this.apellidoMaterno + "\n" + "E-mail: " + this.email
				+ "\n" + "Telefono: " + this.telefono + "\n";
		return s;
	}

}
