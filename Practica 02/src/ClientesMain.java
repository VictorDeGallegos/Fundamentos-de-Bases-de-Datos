
/*
 * author JAVATAR
 * 
 * Clase principal que ejecuta el Sistema para la Gestion de Usuarios
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

// Class Clientes Main
public class ClientesMain {
	// Declarando variables Globales

	// cadena que recibirá el archivo
	static String fileclientes = "Clientes.csv";
	// lista de matriz que recibirá los datos del archivo Clientes.csv
	static ArrayList<Clientes> list = new ArrayList<Clientes>();
	// declarar un nuevo objeto Archivo y pasarle el nombre del archivo como
	// parametro
	static File f = new File(fileclientes);
	// declarar un nuevo FileReader
	static FileReader fr = null;
	// crear un nuevo BufferedReader para leer la entrada del usuario
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// Create an object if itself
	public static void main(String[] args) {
		new ClientesMain();
	}

	// Programa o metodo principal
	public ClientesMain() {
		// llamada a los metodos
		readFile();
		showMenuClientes();
	}// fin

	// Método para leer el archivo (Clientes.csv)
	public void readFile() {

		FileReader fr = null;

		// Intente detectar para encontrar excepciones o errores al intentar leer el
		// archivo
		try {
			fr = new FileReader(f);
		} catch (FileNotFoundException e) {
			// Mensaje de error en caso de que falte el archivo
			System.out.println("No encontramos la base de datos del el archivo csv");
		}
		// Declare y cree un objeto BufferedReader y pase el objeto FileReader
		// fr.
		BufferedReader br = new BufferedReader(fr);
		// declarar una cadena para guardar cada línea del archivo (Clientes.csv)
		String line;

		try {
			// Leer la primera línea
			line = br.readLine();
			// Mientras no es nula, sigue leyendo
			while (line != null) {
				// Matriz de cadenas que dividirán los datos en partes más pequeñas para leer
				String[] data = line.split(";");
				// Cree un objeto Clientes y establezca el valor de los atributos (Id, apellido
				// paterno,materno
				// nombre, email, puntosdePromociones)
				Clientes s = new Clientes(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6],
						data[7], data[8], data[9]);
				// Agregar a ArrayList
				list.add(s);
				// Sigue leyendo líneas
				line = br.readLine();
			}
			// Cerramos BufferedReader
			br.close();
			// Mostrar mensaje de error si hay un error al leer el archivo
		} catch (IOException ioe) {
			System.out.println("*** Error al leer el archivo*** ");
		}
		// IMprimir linea vacia
		System.out.println();
	}// Fin del metodo readFile

	// Method para mostrar el menu principal de Sistema para la Gestion de Usuarios
	public void showMenuClientes() {
		// Cadena que recibirá información del usuario
		String input = " ";
		// bucle que imprimirá el menú principal en la pantalla hasta que el usuario
		// presione "x" para
		// salir del programa y actualizar el csv
		do {
			// print the menu on the screen
			System.out.println("█║▌║█-- NIXUT - Sistema para la Gestion de Usuarios --█║▌║█");
			System.out.println("| a - Agregar un nuevo cliente                |");
			System.out.println("| b - Buscar un Cliente                       |");
			System.out.println("| c - Mostrar un Cliente                      |");
			System.out.println("| d - Editar Cliente                          |");
			System.out.println("| e - Borrar un cliente                       |");
			System.out.println("| x - Salir/Guardar Cambios                   |");
			System.out.println("**********************************************");

			// imprimir el menú en la pantalla
			System.out.print("Elegir una opcion: ");
			System.out.println();
			// Try obtiene errores / excepciones
			try {
				// String recibe la entrada del usuario
				input = br.readLine();
				// Mensaje de error en caso de algo inesperado
			} catch (IOException e) {
				System.out.println("Algo salio mal..! ");
			}

			// condición de cambio de caso para agregar Clientes en caso de que la entrada
			// sea 'a'
			switch (input) {
				// métodos de llamada según la opción elegida por el usuario
				case "a":
					addNewClientes();
					break;
				// condición de cambio de caso para buscar la entrada de caso de Clientes es 'b'
				case "b":
					searchClientes();
					break;
				// condición de la caja del interruptor para mostrar la entrada de la caja de
				// Clientes es 'c'
				case "c":
					displayClientes();
					break;
				// caso de interruptor de condición para modificar la entrada de caso de
				// Clientes es 'd'
				case "d":
					modifyClientes();
					break;
				// caso de interruptor de condición para eliminar la entrada de caso de Clientes
				// es 'e'
				case "e":
					deleteClientes();
					break;
				// condición del caso del interruptor para salir del programa, la entrada del
				// caso es 'x'
				// mostrar mensaje en la pantalla y escribir la información de en el archivo
				case "x":
					System.out.println("*** Gracias por confiar en JAVATAR - Grupo Fundamentos de Bases de Datos ***");
					writeFile();
					break;
				// si la opción no es válida muestra un mensaje de error
				default:
					// Linea vacia
					System.out.println();

					// muestra un mensaje de error y le pide al usuario que ingrese una nueva opción
					System.out.println();
					System.out.println("*** Opcion invalida ! Intentalo de nuevo ! ***");

					// Linea vacia
					System.out.println();
					break;
			}// Fin del switch

			// el programa se ejecuta hasta que el usuario presione la "x"
		} while (!input.equalsIgnoreCase("x"));
	}// fin del método mostrar menú

	// Método que escribirá datos en el archivo (Clientes.csv)
	public void writeFile() {
		// crea un nuevo archivo f
		File f = new File(fileclientes);
		FileWriter fw = null;
		// crea un nuevo archivo f
		try {
			// escribir en el archivo
			fw = new FileWriter(f);
			// mostrar mensaje si hay un error al crear el archivo
		} catch (IOException e) {
			System.out.println("*** Error al crear el archivo *** ");
		}
		// crea un nuevo BufferedWriter bw
		BufferedWriter bw = new BufferedWriter(fw);
		// Intente escribir datos en el archivo línea por línea
		try {
			// El bucle que ejecutará la lista de matrices "lista"
			for (int x = 0; x < list.size(); x++) {
				// writes variables(values) to the file
				bw.write(list.get(x).getId() + ";");
				bw.write(list.get(x).getApellidoPaterno() + ";");
				bw.write(list.get(x).getApellidoMaterno() + ";");
				bw.write(list.get(x).getNombre() + ";");
				bw.write(list.get(x).getCurp() + ";");
				bw.write(list.get(x).getGenero() + ";");
				bw.write(list.get(x).getFechaDeNacimiento() + ";");
				bw.write(list.get(x).getDireccion() + ";");
				bw.write(list.get(x).getEmail() + ";");
				bw.write(list.get(x).getpuntosdePromociones() + ";");

				bw.write(System.getProperty("line.separator"));
			}
			// mostrar mensaje en caso de que haya un error al escribir en el búfer
		} catch (IOException ioe) {
			System.out.println("*** Error al escribir en el búfer***");
		}
		// Try para cerrar el BufferedWritter
		try {
			bw.close();
			// mostrar mensaje en caso de que haya un error al cerrar BufferedWriter
		} catch (IOException e) {
			System.out.println("*** Error al cerrar BufferedWriter ***");
		}
		// Try para cerrar el FileWriter
		try {
			fw.close();
			// mostrar mensaje en caso de que haya un error al cerrar FileWriter
		} catch (IOException e) {
			System.out.println("*** Error al cerrar FileWriter ***");
		}
	}// fin del método writeFile

	// Método para agregar nuevos clientes
	public void addNewClientes() {
		/*
		 * Method should get input from user add details to the list add details to the
		 * file
		 */
		// declarar variables
		int id = 0;
		String nombre = " ";
		String apellidoPaterno = " ";
		String apellidoMaterno = " ";
		String curp = " ";
		String genero = " ";
		String fechadeNacimiento = " ";
		String direccion = " ";
		String email = " ";
		String puntosdePromociones = " ";
		String confirm = " ";
		// bucle que le pedirá al usuario que ingrese datos de Clientes
		do {
			// Try para obtener la entrada del usuario
			try {
				// flag
				boolean flag = false;
				// bucle que validará el ID y comprobará que ya existe.
				// si existe, muestre el mensaje y solicite al usuario que ingrese una nueva
				// ID
				do {
					// muestre el mensaje pidiendo al usuario que ingrese Su ID
					System.out.println("Ingresa el ID del cliente (solo numeros): ");
					System.out.println();
					// id recibe la entrada del usuario y la bandera usa el método checkID para
					// verificar si
					// ya existe
					id = Integer.parseInt(br.readLine());
					flag = ValidarMetodosClientes.checkID(id, list);
					// condición si bandera == verdadero mostrar ID de mensaje ya existe
					if (flag == true) {
						System.out.println();
						System.out.println("***** El ID ya fue registrado, ingresa un ID nuevo *****");
						System.out.println();
					}
					// el bucle se ejecuta mientras la bandera == verdadero
				} while (flag == true);

				// bucle que solicita la entrada del usuario, comprueba si la entrada son letras
				// y si el
				// el campo no está en blanco
				do {
					nombre = ValidarMetodosClientes
							.getOnlyLettersSpace("Ingrese el o los Nombres(s) del cliente (solo letras): ");
					ValidarMetodosClientes.emptyField(nombre);
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (nombre.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada son letras
				// y si el
				// el campo no está vacio
				do {
					apellidoPaterno = ValidarMetodosClientes
							.getOnlyLetters("Ingresa el Apellido Paterno del cliente (solo letras): ");
					ValidarMetodosClientes.emptyField(apellidoPaterno);
					// Mientras el campo está vacío, solicite a la usuario que ingrese nuevamente
				} while (apellidoPaterno.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada son letras
				// y si el
				// no esta vacio
				do {
					apellidoMaterno = ValidarMetodosClientes
							.getOnlyLetters("Ingresa el Apellido Materno del cliente (solo letras): ");
					ValidarMetodosClientes.emptyField(apellidoMaterno);
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (apellidoMaterno.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada son letras
				// y numeros
				// y si el
				// no esta vacio
				do {
					curp = ValidarMetodosClientes.getCurp("Ingresa el CURP del cliente (solo letras): ");
					ValidarMetodosClientes.emptyField(curp);
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (curp.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada son letras
				// y si el
				// no esta vacio
				do {
					genero = ValidarMetodosClientes.getGenero("Ingresa el Genero del cliente (M o F): ");
					ValidarMetodosClientes.emptyField(genero);
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (genero.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada son
				// numeros
				// y si el
				// no esta vacio
				do {
					fechadeNacimiento = ValidarMetodosClientes
							.getFechaDeNacimiento("Ingresa tu fecha de nacimiento (DD/MM/YY): ");
					ValidarMetodosClientes.emptyField(fechadeNacimiento);
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (fechadeNacimiento.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada son letras
				// y numeros
				// y si el
				// no esta vacio
				do {
					direccion = ValidarMetodosClientes.getOnlyLettersSpaceNumber("Ingresa la Direccion del cliente: ");
					ValidarMetodosClientes.emptyField(direccion);
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (direccion.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada es un
				// correo electrónico válido y si
				// el campo no esta en vacio
				do {
					email = ValidarMetodosClientes.getEmail("Ingresa el Email del cliente: ");
					// ValidationMethods.emptyField(email);
					if (ValidarMetodosClientes.emptyField(email))
						email = "";
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (email.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada es un
				// número válido y si
				// el campo no esta vacio
				do {
					// System.out.println("Please enter Clientes puntosdePromociones number (numbers
					// only): ");
					puntosdePromociones = ValidarMetodosClientes
							.getPromo("Ingresa los puntos de Promociones del cliente (solo numeros): ");
					ValidarMetodosClientes.emptyField(puntosdePromociones);
					System.out.println();
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (puntosdePromociones.isEmpty());
				do {
					try {
						// Mostrar mensaje pidiendo al usuario que confirme la entrada para los Clientes
						System.out.println("Confirmas que es correcta la informacion de este cliente? Y/N");
						// confirmar recibir la entrada del usuario
						confirm = br.readLine();
						// captura la excepción y muestra el mensaje en caso de que haya un error
					} catch (IOException e) {
						System.out.println("*** Algo salio mal *** ");
					}
					// condición en caso de que la entrada del usuario sea Y, elimine los Clientes
					// de la lista
					if (confirm.equalsIgnoreCase("Y")) {
						// Crea un objeto Clientes y establece el valor de los atributos
						Clientes s = new Clientes(id, apellidoPaterno, apellidoMaterno, nombre, curp, genero, fechadeNacimiento,
								direccion, email, puntosdePromociones);
						// Agregar a ArrayList (lista)
						list.add(s); // mostrar mensaje de que Clientes se eliminó con éxito y una línea vacía
						System.out.println("****** Cliente Agregado exitosamente !!! ******");
						System.out.println();
					}
					// El bucle se ejecuta mientras la entrada del usuario no es Y o N
				} while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));
				break;
				// Catch errores / excepciones
			} catch (IOException | NumberFormatException | StringIndexOutOfBoundsException e) {
				// mostrar mensaje si hay un error y pedirle al usuario que ingrese datos
				// nuevamente
				System.out.println("***** Entrada invalida..! Por favor ingresa el formato correcto *****");
				System.out.println();
			}
			// mientras la condición es verdadera imprime una línea vacía y llama al método
			// pressEnter ()
		} while (true);
		System.out.println();
		pressEnter();
	}// end of method addNewClientes
		// Método para buscar Clientes

	public void searchClientes() {
		/*
		 * El programa debe buscar por número de Clientes o por nombre, apellido o curp
		 * paterno buscar debe mostrar todos los Clientes que cumplen con la búsqueda
		 */
		// declarando variables
		int id = 0;
		String nombre = " ";
		String apellidoPaterno = " ";
		String curp = " ";
		String input = " ";
		// Intente obtener información del usuario para refinar la búsqueda por Id de
		// cliente, nombre o
		// apellido paterno
		try {
			System.out.println("Te gustaria buscar por: ");
			System.out.println("****************************");
			System.out.println("| 1 - Clientes (ID)                |");
			System.out.println("| 2 - Clientes (NOMBRE)            |");
			System.out.println("| 3 - Clientes (APELLIDO PATERNO)  |");
			System.out.println("| 4 - Clientes (CURP)              |");
			System.out.println("****************************");
			input = br.readLine();
			// flag
			boolean found = false;

			// caso de interruptor de condición para agregar la entrada de caso de Clientes
			// es 'a'
			switch (input) {
				// pedirle al usuario que ingrese los detalles de Clientes por id
				case "1":
					// pedir información al usuario
					System.out.println("Por favor ingresa el ID del cliente: ");
					System.out.println();
					try {
						id = Integer.parseInt(br.readLine());
						found = false;
						// pedirle al usuario que ingrese los detalles de Clientes por ID
						for (Clientes s : list) {
							// si encuentra los Clientes que coinciden con el id lo muestra en la pantalla y
							// cambia
							// flag a true
							if (String.valueOf(s.getId()).contains(String.valueOf(id))) {
								System.out.println(s);
								found = true;
							}
						}
						// si no se encuentra el ID muestra el mensaje "ID no encontrado :( " y una
						// línea vacía
						if (found == false) {
							System.out.println("***** ID no encontrado :( *****");
							System.out.println();
						}
						// en caso de que haya excepciones, mostrar mensaje de error
					} catch (IOException | NumberFormatException nf) {
						System.out.println("***** No valido, Intenta de nuevo *****");
						System.out.println();
					}
					break;
				// Pídale al usuario que ingrese los datos de Cliente por nombre
				case "2":
					do {
						nombre = ValidarMetodosClientes.getOnlyLettersSpace("Ingresa el nombre del cliente: ");
						ValidarMetodosClientes.emptyField(nombre);
						// Si el campo está vacío, solicite al usuario que ingrese nuevamente
					} while (nombre.isEmpty());
					found = false;
					// bucle que ejecuta la lista
					for (Clientes s : list) {
						// si encuentra los Clientes que coinciden con el nombre lo muestra en la
						// pantalla y
						// cambiar la bandera a verdadero
						if (s.getNombre().contains(nombre)) {
							System.out.println(s);
							found = true;
						}
					}
					// si no se encuentra la ID muestra el mensaje "nombre no
					// encontrado" y una línea vacía
					if (found == false) {
						System.out.println("***** Nombre no encontrado :( *****");
						System.out.println();
					}
					break;
				// pedirle al usuario que ingrese los detalles de Clientes por apellido paterno
				case "3":
					do {
						apellidoPaterno = ValidarMetodosClientes.getOnlyLetters("Ingresa el Apellido paterno del cliente: ");
						ValidarMetodosClientes.emptyField(apellidoPaterno);
						// Si el campo está vacío, solicite al usuario que ingrese nuevamente
					} while (apellidoPaterno.isEmpty());
					found = false;
					// bucle que ejecuta la lista
					for (Clientes s : list) {
						// si encuentra los Clientes que coinciden con el apellido paterno lo muestra en
						// la pantalla y cambia la bandera a true
						if (s.getApellidoPaterno().contains(apellidoPaterno)) {
							System.out.println(s);
							found = true;
						}
					}
					// si no se encuentra la ID muestra el mensaje "apellido paterno no
					// encontrado" y una línea vacía
					if (found == false) {
						System.out.println("***** Apellido paterno no encontrados :( *****");
						System.out.println();
					}
					break;
				// pedirle al usuario que ingrese los detalles de Clientes por curp
				case "4":
					do {
						curp = ValidarMetodosClientes.getCurp("Ingresa el CURP del cliente: ");
						ValidarMetodosClientes.emptyField(curp);
						// Si el campo está vacío, solicite al usuario que ingrese nuevamente
					} while (curp.isEmpty());
					found = false;
					// bucle que ejecuta la lista
					for (Clientes s : list) {
						// si encuentra los Clientes que coinciden con el apellido paterno lo muestra en
						// la pantalla y cambia la bandera a true
						if (s.getCurp().contains(curp)) {
							System.out.println(s);
							found = true;
						}
					}
					// si no se encuentra la ID muestra el mensaje "apellido paterno no
					// encontrado" y una línea vacía
					if (found == false) {
						System.out.println("***** CURP no encontrado :( *****");
						System.out.println();
					}
					break;
				// caso que mostrará un mensaje de error en caso de que la entrada del usuario
				// no sea válida
				default:
					// linea vacia
					System.out.println();
					// muestra un mensaje de error y le pide al usuario que ingrese una nueva opción
					System.out.println("***** No valido ! Intenta de nuevo ! *****");
					// linea vacia
					System.out.println();
					break;
			}
			// captura la excepción y muestra el mensaje en caso de que haya un error
		} catch (IOException e) {
			System.out.println("*** Algo salio mal ERROR 404 o algo asi xd..! ***");
		}
	}// fin del metodo searchClientes

	// Método que mostrará un Cliente
	public void displayClientes() {
		// declarar variables y darles valores
		int input = 0;
		boolean f = false;
		do {
			f = false;
			// mostrar detalles de Clientes por número de Clientes
			System.out.println("Ingresa el ID del cliente: ");
			try {
				// la entrada recibe la ID del usuario
				input = Integer.parseInt(br.readLine());
				// flag
				boolean found = false;
				// bucle que ejecuta la lista
				for (Clientes s : list) {
					// si la ID está en la lista, la muestra en la pantalla y cambia la
					// bandera a verdadera
					if (String.valueOf(s.getId()).contains(String.valueOf(input))) {
						System.out.println(s);
						found = true;
					}
				}
				// si el ID no está en la lista, muestre el mensaje "ID no encontrado" y una
				// línea vacía
				if (found == false) {
					System.out.println("***** ID no encontrado :( *****");
					System.out.println();
				}
				// captura la excepción y muestra el mensaje en caso de que haya un error
			} catch (IOException | NumberFormatException nf) {
				// mostrar mensaje si hay un error y pedirle al usuario que ingrese datos
				// nuevamente
				System.out.println("***** Ooops! Algo salio mal, intenta otra vez, no seas timido! *****");
				System.out.println();
				f = true;
			}
		} while (f);
	}// FIn del metodo displayClientes

	// Metodo modify Clientes
	public void modifyClientes() {
		/*
		 * El programa debe cambiar los detalles (apellidoPaterno, apellidoMaterno,
		 * curp, genero, direccion, nombre, email, puntosdePromociones) excepto Los
		 * cambios de número de cliente deben guardarse en la lista y el archivo
		 */
		// declarar variables y darles valores
		int input = 0;
		String data = " ";
		String nombre = " ";
		String apellidoPaterno = " ";
		String apellidoMaterno = " ";
		String curp = " ";
		String genero = " ";
		String fechadeNacimiento = " ";
		String direccion = " ";
		String email = " ";
		String puntosdePromociones = " ";
		String confirm = " ";

		// mostrar detalles de Clientes por número de Clientes
		System.out.println("Ingresa el ID del cliente: ");
		// try para obtener el ID del usuario
		try {
			// La entrada recibe el id del usuario
			input = Integer.parseInt(br.readLine());
			// flag
			boolean found = false;
			// crea un objeto Clientes cli como nulo
			Clientes cli = null;
			// bucle que ejecuta la lista
			for (Clientes s : list) {
				// si lID está en la lista, muestra los detalles de Clientes y
				// cambia la bandera a verdadera
				if (String.valueOf(s.getId()).contains(String.valueOf(input))) {
					// System.out.println(s);
					cli = s;
					found = true;
				}
			}
			// si el ID no está en la lista, muestre el mensaje "ID no encontrado" y una
			// línea vacía
			if (found == false) {
				System.out.println("***** ID no encontrado*****");
				System.out.println();
				// si ID está en la lista
			} else {
				// bucle que le pedirá al usuario que actualice la información de Clientes por:
				// nombre, apellido
				// paterno,
				// email or numero de puntosdePromociones
				// or regresa al menu principal
				// información de nombre, apellido paterno, email o numero de
				// puntosdePromociones será
				// guardada
				// in "case 9"

				nombre = cli.getNombre();
				apellidoPaterno = cli.getApellidoPaterno();
				apellidoMaterno = cli.getApellidoMaterno();
				curp = cli.getCurp();
				genero = cli.getGenero();
				fechadeNacimiento = cli.getFechaDeNacimiento();
				direccion = cli.getDireccion();
				email = cli.getEmail();
				puntosdePromociones = cli.getpuntosdePromociones();
				do {
					System.out.println("Vista previa" + "\n");
					System.out.println("ID del cliente: " + cli.getId() + "\n" + "Nombre: " + nombre + "\n" + "Apellido Paterno: "
							+ apellidoPaterno + "\n" + "Apellido Materno: " + apellidoMaterno + "\n" + "Curp: " + curp + "\n"
							+ "Genero: " + genero + "\n" + "Fecha de nacimiento: " + fechadeNacimiento + "\n" + "Direccion: "
							+ direccion + "\n" + "E-mail: " + email + "\n" + "Puntos de promociones: " + puntosdePromociones
							+ " puntos" + "\n");
					System.out.println("*****************************************");
					System.out.println("Selecciona la opcion que desea editar del Cliente:    ");
					System.out.println("| 1 - Nombre del Cliente                        |");
					System.out.println("| 2 - Apellido Paterno del Cliente              |");
					System.out.println("| 3 - Apellido Materno del Cliente              |");
					System.out.println("| 4 - CURP del Cliente                          |");
					System.out.println("| 5 - Genero del Cliente                        |");
					System.out.println("| 6 - Fecha de nacimiento                       |");
					System.out.println("| 7 - Direccion del Cliente                     |");
					System.out.println("| 8 - Email del cliente                         |");
					System.out.println("| 9 - Puntos de promociones del cliente         |");
					System.out.println("| 10 - GUARDAR CAMBIOS y volver a Menu principal |");
					System.out.println("| 0 - Regresar al menu principal                |");
					System.out.println("*****************************************");
					data = br.readLine();
					found = false;

					// caso de switch de condición para agregar la entrada de caso de Clientes es
					// 'a'
					switch (data) {
						// Pídale al usuario que ingrese el Nombre del Cliente si la opción es 1
						case "1":
							do {
								nombre = ValidarMetodosClientes
										.getOnlyLettersSpace("Ingresa el o los nuevos nombre(s) del cliente (solo letras): ");
								ValidarMetodosClientes.emptyField(nombre);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (nombre.isEmpty());
							System.out.println();
							break;
						// pedirle al usuario que ingrese El apellido paterno del Cliente si la opción
						// es 2
						case "2":
							do {
								apellidoPaterno = ValidarMetodosClientes
										.getOnlyLetters("Ingresa el nuevo Apellido paterno del cliente (solo letras): ");
								ValidarMetodosClientes.emptyField(apellidoPaterno);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (apellidoPaterno.isEmpty());
							System.out.println();
							break;
						// pedirle al usuario que ingrese El apellido materno del Cliente si la opción
						// es 3
						case "3":
							do {
								apellidoMaterno = ValidarMetodosClientes
										.getOnlyLetters("Ingresa el nuevo apellido materno del cliente (solo letras): ");
								ValidarMetodosClientes.emptyField(apellidoMaterno);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (apellidoMaterno.isEmpty());
							System.out.println();
							break;
						// pedirle al usuario que ingrese curp del Cliente si la opción
						// es 4
						case "4":
							do {
								curp = ValidarMetodosClientes.getCurp("Ingresa el nuevo CURP del cliente (solo letras): ");
								ValidarMetodosClientes.emptyField(curp);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (curp.isEmpty());
							System.out.println();
							break;
						// pedirle al usuario que ingrese el genero del Cliente si la opción
						// es 5
						case "5":
							do {
								genero = ValidarMetodosClientes.getGenero("Ingrese el nuevo Genero (M o F): ");
								ValidarMetodosClientes.emptyField(genero);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (genero.isEmpty());
							System.out.println();
							break;
						// pedirle al usuario que ingrese la fecha de nacimiento del Cliente si la
						// opción
						// es 6
						case "6":
							do {
								fechadeNacimiento = ValidarMetodosClientes.getFechaDeNacimiento(
										"Ingresa la nueva fecha de nacimiento con el siguiente formato de ejemplo (DD/MM/YY): ");
								ValidarMetodosClientes.emptyField(fechadeNacimiento);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (fechadeNacimiento.isEmpty());
							System.out.println();
							break;
						// pedirle al usuario que ingrese la direccion Cliente si la opción
						// es 7
						case "7":
							do {
								direccion = ValidarMetodosClientes
										.getOnlyLettersSpaceNumber("Ingresa la nueva Direccion del cliente: ");
								ValidarMetodosClientes.emptyField(direccion);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (direccion.isEmpty());
							System.out.println();
							break;
						// Pedirle al usuario que ingrese el correo electrónico del Cliente si la opción
						// es 8
						case "8":
							do {
								email = ValidarMetodosClientes.getEmail("Ingresa el nuevo email del cliente: ");
								ValidarMetodosClientes.emptyField(email);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (email.isEmpty());
							System.out.println();
							break;
						// Pedirle al usuario que ingrese el puntosdePromociones del Cliente si la
						// opcion es 9
						case "9":
							do {
								puntosdePromociones = ValidarMetodosClientes
										.getPromo("Ingresa los nuevos puntos de promocion del cliente: ");
								ValidarMetodosClientes.emptyField(puntosdePromociones);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (puntosdePromociones.isEmpty());
							System.out.println();
							break;
						case "10":
							do {
								System.out.println("Confirmas los cambios realizados? Y/N");
								try {
									// confirmar recibir la entrada del usuario
									confirm = br.readLine();
									// captura la excepción y muestra el mensaje en caso de que haya un error
								} catch (IOException e) {
									System.out.println("***** Algo salio mal :( ..! ***** ");
								}
								// condición en caso de que la entrada del usuario sea Y, elimine los Clientes
								// de la lista
								if (confirm.equalsIgnoreCase("Y")) {
									/* si guarda (Y) */
									cli.setNombre(nombre);
									cli.setApellidoPaterno(apellidoPaterno);
									cli.setApellidoMaterno(apellidoMaterno);
									cli.setCurp(curp);
									cli.setGenero(genero);
									cli.setFechaDeNacimiento(fechadeNacimiento);
									cli.setDireccion(direccion);
									cli.setEmail(email);
									cli.setpuntosdePromociones(puntosdePromociones);
									// muestra el mensaje de que Clientes se eliminó correctamente y una línea vacía
									System.out.println("Clientes actualizado correctamente !!!");
									System.out.println();
								}
								// El bucle se ejecuta mientras que la confirmación no es Y o N
							} while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));
							break;
						// si el caso es 0 vuelve al menú principal
						case "0":
							break;
						// caso que mostrará un mensaje de error en caso de que la entrada del usuario
						// no sea válida
						default:
							// linea vacia
							System.out.println();
							// muestra un mensaje de error y le pide al usuario que ingrese una nueva opción
							System.out.println("***** Opcion no valida ! Intenta de nuevo ! *****");
							// linea en blanco
							System.out.println();
							break;
					}
					// run el bucle hasta que el caso sea 0
				} while (!data.equals("0") && !data.equals("10"));
			}
			// catch exception and show message in case there's an error
		} catch (IOException | NumberFormatException nfe) {
			System.out.println("***** Entrada invalida..! Vuelve a intentarlo *****");
			System.out.println();
		}
	}// fin del metodo modifyClientes

	// Meotodo delete Clientes
	public void deleteClientes() {
		/*
		 * El programa debe eliminar Clientes por número de Clientes eliminar de la
		 * lista y el archivo
		 */
		// declarar variables y darles valores
		int input = 0;
		String confirm = " ";

		// mostrar detalles de Clientes por número de Clientes
		System.out.println("Ingresa el ID del cliente ");
		// tratar de obtener la ID de Clientes
		try {
			// La entrada recibe el id del usuario
			input = Integer.parseInt(br.readLine());
			// captura la excepción y muestra el mensaje en caso de que haya un error
		} catch (IOException | NumberFormatException nfe) {
			System.out.println("***** ALgo salio mal..! Intentalo otra vez*****");
		}
		// flag
		boolean found = false;
		Clientes cli = null;
		// bucle que ejecutará la lista. Si la ID coincide, muestra los
		// Clientes y cambia
		// flag a true
		for (Clientes s : list) {
			if (s.getId() == input) {
				System.out.println(s);
				cli = s;
				found = true;
			}
		}
		// si no se encuentra la ID, muestre el mensaje "No se encontró la
		// ID" y una línea vacía
		if (found == false) {
			System.out.println("***** ID no encontrado *****");
			System.out.println();
			// si Clientes encontró, mostrar un mensaje pidiendo al usuario que confirme y
			// elimine el Cliente
		} else {
			do {
				System.out.println("Deseas eliminar este Cliente? Y/N");
				try {
					// confirmar recibir la entrada del usuario
					confirm = br.readLine();
					// captura la excepción y muestra el mensaje en caso de que haya un error
				} catch (IOException e) {
					System.out.println("***** Algo salio mal :( ..! *****");
				}
				// condición en caso de que la entrada del usuario sea Y, elimine los Clientes
				// de la lista
				if (confirm.equalsIgnoreCase("Y")) {
					list.remove(cli);
					// mostrar mensaje de que Clientes se eliminó con éxito y una línea vacía
					System.out.println("***** Cliente eliminado exitosamente !!! *****");
					System.out.println();
				}
				// El bucle se ejecuta mientras que la confirmación no es Y o N
			} while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));
		}
		// método de llamada pressEnter
		pressEnter();
	}// fin del metodo deleteClientes

	// Metodo pressEnter
	public void pressEnter() {
		// intente presionar enter para continuar
		try {
			System.out.print("Presiona <Enter> para continuar ... ");
			br.readLine();
			System.out.println();
			// captura la excepción si hay un error
		} catch (IOException ioe) {
		}
	}// fin del método presione Entrar
}// Fin de la clase ClientesMain
