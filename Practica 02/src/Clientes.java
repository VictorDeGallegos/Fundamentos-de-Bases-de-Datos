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
	private String genero;
	private String fechadeNacimiento;
	private String edad;
	private String direccion;
	private String email;
	private String password;
	private String nombre;
	private String puntosdePromociones;

	public Clientes(int id, String apellidoPaterno, String apellidoMaterno, String nombre, String curp, String genero,
			String fechadeNacimiento, String edad, String direccion, String email, String password,
			String puntosdePromociones) {
		this.id = id;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombre = nombre;
		this.curp = curp;
		this.genero = genero;
		this.fechadeNacimiento = fechadeNacimiento;
		this.edad = edad;
		this.direccion = direccion;
		this.email = email;
		this.password = password;
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

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setFechaDeNacimiento(String fechadeNacimiento) {
		this.fechadeNacimiento = fechadeNacimiento;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getGenero() {
		return this.genero;
	}

	public String getFechaDeNacimiento() {
		return this.fechadeNacimiento;
	}

	public String getEdad() {
		return this.edad;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	public String getpuntosdePromociones() {
		return this.puntosdePromociones;
	}

	// class toString
	public String toString() {

		String s = "ID Cliente: " + this.id + "\n" + "Nombre: " + this.nombre + "\n" + "Apellido Paterno: "
				+ this.apellidoPaterno + "\n" + "Apellido Materno: " + this.apellidoMaterno + "\n" + "CURP:" + this.curp + "\n"
				+ "Genero: " + this.genero + "\n" + "Fecha de Nacimiento" + this.fechadeNacimiento + "\n" + "Edad: " + this.edad
				+ "\n" + "Direccion: " + this.direccion + "\n" + "E-mail: " + this.email + "\n" + "Password: " + this.password
				+ "\n" + "Puntos de promociones: " + this.puntosdePromociones + " puntos" + "\n";
		return s;
	}

}
