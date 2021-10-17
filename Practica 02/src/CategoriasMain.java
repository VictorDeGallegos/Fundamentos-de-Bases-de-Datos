import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
* MAIN CATEGORIAS,getters and setters.
* @author JAVATAR. 
* @version 1.0, Octubre 2021.
* @since Fundamentos de bases de datos, Prática 2.
*/

public class CategoriasMain {
	/**
	 * Variables globales
	 */
	static String archivoCategorias = "Categorias.csv"; //Variable para archivo
	static ArrayList<Categorias> list = new ArrayList<Categorias>(); //Estructura de datos para Categorias.csv
	static File file = new File (archivoCategorias); //Objeto File y recibe archivoCategorias como parametro
	static FileReader fileReader = null; //declaracion de FileReader
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); //Creacion de BufferedReader para entrada de usuario



	public static void main(String[] args){
		new CategoriasMain(); //Creacion del objeto
	}


	/**
	 * Metodo Principal
	 */
	public CategoriasMain() {
		
		/**
		 * Invocacion de metodos
		 */
		
		readFile();
		showMenu();
	}

	/**
	 * Metodo para leer Categorias.csv
	 */
	public void readFile(){

		FileReader fileReader = null;

		/**
		 * Lanzamos excepcion para atrapar algun error al leer el archivo
		 */
		try{

			fileReader = new FileReader(file);
		}catch(FileNotFoundException e){

			//Se lanza mensaje al usuario si la excepcion atrapa algo
			System.out.println(" 〷 --> No se encontro el archivo con extencion \".csv\" el cual contiene la base de datos <-- 〷");
		}

		/**
		 * Creacion de BufferedReader el cual recibe fileReader
		 * Declaramos un String que servira para guardar cada linea en Categorias.csv
		 */

		BufferedReader bufferedReader= new BufferedReader (fileReader);

		String line;

		/**
		 * Lanzamos excepcion si hay error al leer el archivo
		 * Inicializamos lectura del archivo
		 */

		try{

			line = bufferedReader.readLine(); //Lectura de primera linea

			/**
			 *Declaro estructura de control, asi seguira leyendo mientras no sea nula
			 */
			
			while(line != null){

				/**
				 * 1.- Se dividira con ";" para una lectura mas rapida y eficiente.
				 * 2.- Crearemos un objeto Categoria con sus atributos como: nombre de la categoria, descripcion de la categoria, numero de productos en la categoria. 
				 * 3.- Estos atributos se agregan al ArrayList y despues sigue leyendo las lineas
				 */
				String[] data = line.split(";"); 

				Categorias s = new Categorias(Integer.parseInt(data[0]), data[1], data[2], data[3]);

				lista.add(s);
				line = bufferedReader.readLine();
			}
			bufferedReader.close(); //Se cierra BufferedReader
		}catch(IOException ioe){

			//Se lanza mensaje al usuario si la excepcion atrapo algo
			System.out.println("〷 ☛ Error al leer el archivo ☚ 〷"+
								"\n");
		}
	}
	
	/**
	 * Menu lanzado en terminal para gestionar categorias
	 */
	public void showMenu(){

		//Variables para ejecucion de menu

		String entradaUsuario = "";


		/**
		 * Estructura de control para ejecucion de menu y actualizacion de archivo Categorias.csv
		 */

		do{
			//Menu mostrado en terminal
			System.out.println("♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕  N I X U T® ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ");
			System.out.println("\n         SISTEMA DE GESTION DE CATEGORIAS         \n");
			System.out.println("| a - Agregar una nueva categoria                |");
			System.out.println("| b - Buscar una categoria                       |");
			System.out.println("| c - Mostrar una categoria                      |");
			System.out.println("| d - Editar categoria                           |");
			System.out.println("| e - Borrar una categoria                       |");
			System.out.println("| x - Salir/Guardar Cambios                      |");
			System.out.println("\n♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ");

			System.out.println("\n♔ ♔ ♔ ESCRIBE LA LETRA DE TU OPCION LEGIDA ♔ ♔ ♔\n");

			/**
			 * Lanzamos excepcion si el usuario da como entrada un caracter diferente a las opciones
			 */
			 try{

			 	entradaUsuario = bufferedReader.readLine(); //Guardamos opcion del usuario

			 }catch(IOException e){

			 	//Mensaje lanzado en terminal para avisar al usuario de un error
			 	System.out.println(" Algo salio mal...! ");
			 }
			 
			 /**
			  * Menu hecho por casos segun la necesidad del usuario
			  */

			switch (entradaUsuario) {

				// métodos de llamada según la opción elegida por el usuario

				//Caso donde se entra en la opcion 'a'
				case "a":
					addNewCategoria();
					break;
				
				// condición donde se entra en la opcion 'b'
				
				case "b":
					searchCategoria();
					break;
				// condición para mostrar la entrada de la eleccion  'c'
				
				case "c":
					displayCategoria();
					break;
				// caso  donde se entra en la opcion 'd'
				
				case "d":
					modifyCategoria();
					break;

				// caso donde se ejecuta la opcion 'e'
				
				case "e":
					deleteCategoria();
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
					// muestra un mensaje de error y le pide al usuario que ingrese una nueva opción
					System.out.println("\n*** Opcion invalida ! Intentalo de nuevo ! *** \n");
					break;
			}
		} while (!entradaUsuario.equalsIgnoreCase("x"));
	}



	/**
	 * Metodo para escribir en el archivo Categorias.csv
	 */
	public void writeFile() {
		
		//Creacion de Objeto tipo File

		File file = new File(archivoCategorias);
		FileWriter fileWriter = null;
		

		/**
		 * Se lanza excepcion y se crea ArchivoCategorias
		 */

		try {

			// escribir en el archivo
			fileWriter = new FileWriter(archivoCategorias);
			
		} catch (IOException e) {

			// mostrar mensaje si hay un error al crear el archivo
			System.out.println("*** Error al crear el archivo *** ");
		}

		// crea un nuevo BufferedWriter

		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		// Intente escribir datos en el archivo línea por línea
		try {
			// El bucle que ejecutará la lista de matrices "lista"
			for (int x = 0; x < list.size(); x++) {
				// writes variables(values) to the file
				bufferedWriter.write(list.get(x).getNombreCategoria() + ";");
				bufferedWriter.write(list.get(x).getNumeroProductos() + ";");
				bufferedWriter.write(list.get(x).getDescripcionCategoria() + ";");

				bufferedWriter.write(System.getProperty("line.separator"));
			}
			
		} catch (IOException ioe) {

			// mostrar mensaje en caso de que haya un error al escribir en el búfer
			System.out.println("*** Error al escribir en el búfer***");
		}
		

		/**
		 * Excepcion lanzada para el cierre de BufferedReader.
		 */

		try {
			bufferedReader.close();
		} catch (IOException e) {

			// mostrar mensaje en caso de que haya un error al cerrar BufferedWriter
			System.out.println("*** Error al cerrar BufferedWriter ***");
		}
		
		/**
		 * Excepcion lanzada para el cierre de FileReader.
		 */

		try {
			fileWriter.close();
		} catch (IOException e) {
			// mostrar mensaje en caso de que haya un error al cerrar FileWriter
			System.out.println("*** Error al cerrar FileWriter ***");
		}
	}

	/**
	 * Metodo para agregar categorias, con sus respectivos atributos
	 */
	public void addNewCategoria(){
		
		/**
		 * Declaracion de variables para el metodo
		 */

		String nombreCategoria = " ";
		String descripcionCategoria = " ";
		String numeroProductos = "";
		int id = 0;
		String confirm = " ";


		/**
		 * Declaracion de estructura de control que le pedirá al usuario que ingrese datos de Clientes
		 */

		do {

			/**
			 * Lanzamos excepcion para atrapar errores del usuario
			 */
			try {
				
				// flag
				boolean flag = false;
				

				/**
				 * Bucle que validará el nombre de la categoria y comprobará 
				 * si ya existe, si es asi lanzara mensaje al usuario
				 */
				do {

					System.out.println("Ingresa ID de la categoria, solo numeros \n")

					id = Integer.parseInt(bufferedReader.readLine());
					flag = ValidarMetodosCategorias.checkID(id, list);
					

					// condición si bandera == verdadero mostrar ID de mensaje ya existe
					if (flag == true) {
						
						System.out.println("\n***** El ID ya fue registrado, ingresa un ID nuevo *****\n");
					}

				} while (flag == true);// el bucle se ejecuta mientras la bandera == verdadero


				/** 
				 * El bucle que solicita la entrada del usuario, comprueba si la entrada son letras y si el
				 * el campo no está en blanco
				 */
				do {
					nombreCategoria = ValidarMetodosCategorias.getOnlyLetters("Ingrese el Nombre de la categoria (solo letras): ");
					ValidarMetodosCategorias.emptyField(nombreCategoria);

					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (nombreCategoria.isEmpty());



				/** bucle que solicita la entrada del usuario, comprueba
				 *  si la entrada son letras y si el campo no está vacio
				 */
				do {
					descripcionCategoria = ValidarMetodosCategorias
							.getOnlyLetters("Ingresa de la categroia (solo letras): ");
					ValidarMetodosCategorias.emptyField(descripcionCategoria);
					
					// Mientras el campo está vacío, solicite a la usuario que ingrese nuevamente
				} while (descripcionCategoria.isEmpty());



				/** bucle que solicita la entrada del usuario, comprueba 
				 * si la entrada es un número válido y si el campo no esta vacio
				 */
				do {
					// System.out.println("Please enter Clientes telefono number (numbers only): ");
					numeroProductos = ValidarMetodosCategorias.getNumeroProductos("Ingresa el numero de productos (solo numeros): ");
					ValidarMetodosCategorias.emptyField(numeroProductos);
					
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (numeroProductos.isEmpty());
				do {
					try {
						// Mostrar mensaje pidiendo al usuario que confirme la entrada para los Clientes
						System.out.println("Confirmas que es correcta la informacion de este cliente? Y/N");
						// confirmar recibir la entrada del usuario
						confirm = bufferedReader.readLine();
						// captura la excepción y muestra el mensaje en caso de que haya un error
					} catch (IOException e) {
						System.out.println("*** Algo salio mal *** ");
					}
					// condición en caso de que la entrada del usuario sea Y, elimine los Clientes
					// de la lista
					if (confirm.equalsIgnoreCase("Y")) {

						// Crea un objeto Clientes y establece el valor de los atributos
						Categorias s = new Categorias(id, nombreCategoria, numeroProductos, descripcionCategoria,);
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
				System.out.println("***** Entrada invalida..! Por favor ingresa el formato correcto *****\n");
			}
			// mientras la condición es verdadera imprime una línea vacía y llama al método
			// pressEnter ()
		} while (true);
		System.out.println();
		pressEnter();
	}// end of method addNewClientes
		// Método para buscar Clientes


	/*
	* El programa debe buscar por número de Categorias por nombre 
	* buscar debe mostrar todos los Clientes que cumplen con la búsqueda
	*/
	public void searchClientes() {


		// declarando variables
		String nombreCategoria = " ";
		String input = " ";
	
		/** Intente obtener información del usuario para refinar 
		 * la búsqueda por Id de cliente, nombre o apellido paterno
		 */
		try {
			System.out.println("Te gustaria buscar por: ");
			System.out.println("***********************************");
			System.out.println("\n 1.- Buscar categorias por nombre \n");
			System.out.println("***********************************");
			input = bufferedReader.readLine();
			// flag
			boolean found = false;

			// caso de interruptor de condición para agregar la entrada de caso de Clientes
			// es 'a'
			switch (input) {
				// pedirle al usuario que ingrese los detalles de Clientes por id

				case "1":
					do {
						nombreCategoria = ValidarMetodosCategorias.getOnlyLetters("Ingresa el nombre del cliente: ");
						ValidarMetodosCategorias.emptyField(nombreCategoria);
						// Si el campo está vacío, solicite al usuario que ingrese nuevamente
					} while (nombre.isEmpty());
					found = false;
					// bucle que ejecuta la lista
					for (Categorias s : list) {
						
						/** si encuentra los Clientes que coinciden con el nombre 
						 * lo muestra en la pantalla y cambiar la bandera a verdadero
						 */
						if (s.getNombreCategoria().contains(nombre)) {
							System.out.println(s);
							found = true;
						}
					}

					/** si no se encuentra la ID muestra el mensaje 
					 * "nombre no encontrado" y una línea vacía
					 */
					if (found == false) {
						
						System.out.println("***** Nombre no encontrado :( *****\n");
						
					}
					
					break;
				
				// Caso que mostrará un mensaje de error en caso de que la entrada del usuario no sea válida
				
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
		 * El programa debe cambiar los detalles (apellidoPaterno, apellidoMaterno
		 * nombre, email, telefono) excepto Los cambios de número de cliente deben
		 * guardarse en la lista y el archivo
		 */
		// declarar variables y darles valores
		int input = 0;
		String data = " ";
		String nombre = " ";
		String apellidoPaterno = " ";
		String apellidoMaterno = " ";
		String email = " ";
		String telefono = " ";
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
				// email or numero de telefono
				// or regresa al menu principal
				// información de nombre, apellido paterno, email o numero de telefono será
				// guardada
				// in "case 6"

				nombre = cli.getNombre();
				apellidoPaterno = cli.getApellidoPaterno();
				apellidoMaterno = cli.getApellidoMaterno();
				email = cli.getEmail();
				telefono = cli.getTelefono();
				do {
					System.out.println("ID del cliente: " + cli.getId() + "\n" + "Nombre: " + nombre + "\n" + "Apellido Paterno: "
							+ apellidoPaterno + "\n" + "Apellido Materno: " + apellidoMaterno + "\n" + "E-mail: " + email + "\n"
							+ "Telefono: " + telefono + "\n");
					System.out.println("*****************************************");
					System.out.println("Selecciona la opcion que desea editar del Cliente:    ");
					System.out.println("| 1 - Nombre del Cliente                        |");
					System.out.println("| 2 - Apellido Paterno del Cliente              |");
					System.out.println("| 3 - Apellido Materno del Cliente              |");
					System.out.println("| 4 - Email del cliente                         |");
					System.out.println("| 5 - Numero de telefono del cliente            |");
					System.out.println("| 6 - Guardar cambios y volver a Menu principal |");
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
								nombre = ValidarMetodosClientes.getOnlyLetters("Ingresa el nuevo Nombre del cliente (solo letras): ");
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
							} while (apellidoPaterno.isEmpty());
							System.out.println();
							break;
						// Pedirle al usuario que ingrese el correo electrónico del Cliente si la opción
						// es 4
						case "4":
							do {
								email = ValidarMetodosClientes.getEmail("Ingresa el nuevo email del cliente: ");
								ValidarMetodosClientes.emptyField(email);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (email.isEmpty());
							System.out.println();
							break;
						// Pedirle al usuario que ingrese el telefono del Cliente si la opcion es 5
						case "5":
							do {
								telefono = ValidarMetodosClientes.getPhone("Ingresa el nuevo telefono del cliente: ");
								ValidarMetodosClientes.emptyField(telefono);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (telefono.isEmpty());
							System.out.println();
							break;
						case "6":
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
									cli.setApellidoPaterno(apellidoMaterno);
									cli.setEmail(email);
									cli.setTelefono(telefono);
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
				} while (!data.equals("0") && !data.equals("6"));
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
				

}