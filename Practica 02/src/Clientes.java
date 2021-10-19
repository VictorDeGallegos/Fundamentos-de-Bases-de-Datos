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
	private String metododePago;
	private String nombre;
	private String puntosdePromociones;

	public Clientes(int id, String apellidoPaterno, String apellidoMaterno, String nombre, String curp, String genero,
			String fechadeNacimiento, String edad, String direccion, String email, String password, String metododePago,
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
		this.metododePago = metododePago;
		this.puntosdePromociones = puntosdePromociones;
	}

	/**
	 * @param id
	 */
	// setters y getters
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param apellidoPaterno
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @param apellidoMaterno
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param curp
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @param genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @param fechadeNacimiento
	 */
	public void setFechaDeNacimiento(String fechadeNacimiento) {
		this.fechadeNacimiento = fechadeNacimiento;
	}

	/**
	 * @param edad
	 */
	public void setEdad(String edad) {
		this.edad = edad;
	}

	/**
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param metododePago
	 */
	public void setMetodoDePago(String metododePago) {
		this.metododePago = metododePago;
	}

	/**
	 * @param puntosdePromociones
	 */
	public void setpuntosdePromociones(String puntosdePromociones) {
		this.puntosdePromociones = puntosdePromociones;
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
	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	/**
	 * @return String
	 */
	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	/**
	 * @return String
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * @return String
	 */
	public String getCurp() {
		return this.curp;
	}

	/**
	 * @return String
	 */
	public String getGenero() {
		return this.genero;
	}

	/**
	 * @return String
	 */
	public String getFechaDeNacimiento() {
		return this.fechadeNacimiento;
	}

	/**
	 * @return String
	 */
	public String getEdad() {
		return this.edad;
	}

	/**
	 * @return String
	 */
	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * @return String
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * @return String
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @return String
	 */
	public String getMetodoDePago() {
		return this.metododePago;
	}

	/**
	 * @return String
	 */
	public String getpuntosdePromociones() {
		return this.puntosdePromociones;
	}

	/**
	 * @return String
	 */
	// class toString
	public String toString() {

		String s = "ID Cliente: " + this.id + "\n" + "Nombre: " + this.nombre + "\n" + "Apellido Paterno: "
				+ this.apellidoPaterno + "\n" + "Apellido Materno: " + this.apellidoMaterno + "\n" + "CURP:" + this.curp + "\n"
				+ "Genero: " + this.genero + "\n" + "Fecha de Nacimiento" + this.fechadeNacimiento + "\n" + "Edad: " + this.edad
				+ "\n" + "Direccion: " + this.direccion + "\n" + "E-mail: " + this.email + "\n" + "Password: " + this.password
				+ "\n" + "Metodo de pago: " + this.metododePago + "\n" + "Puntos de promociones: " + this.puntosdePromociones
				+ " puntos" + "\n";
		return s;
	}

}
