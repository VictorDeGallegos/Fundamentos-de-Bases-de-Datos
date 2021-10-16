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
	private String curp;
	private String nombre;
	private String email;
	private String puntosdePromociones;

	public Clientes(int id, String apellidoPaterno, String apellidoMaterno, String nombre, String curp, String email,
			String puntosdePromociones) {
		this.id = id;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombre = nombre;
		this.curp = curp;
		this.email = email;
		this.puntosdePromociones = puntosdePromociones;
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

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setpuntosdePromociones(String puntosdePromociones) {
		this.puntosdePromociones = puntosdePromociones;
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

	public String getCurp() {
		return this.curp;
	}

	public String getEmail() {
		return this.email;
	}

	public String getpuntosdePromociones() {
		return this.puntosdePromociones;
	}

	// class toString
	public String toString() {

		String s = "ID Cliente: " + this.id + "\n" + "Nombre: " + this.nombre + "\n" + "Apellido Paterno: "
				+ this.apellidoPaterno + "\n" + "Apellido Materno: " + this.apellidoMaterno + "\n" + "CURP:" + this.curp + "\n"
				+ "E-mail: " + this.email + "\n" + "Puntos de promociones: " + this.puntosdePromociones + "\n";
		return s;
	}

}
