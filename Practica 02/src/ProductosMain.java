
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

// Class Productos Main
public class ProductosMain {
	// Declarando variables Globales

	// cadena que recibirá el archivo
	static String fileproductos = "Productos.csv";
	// lista de matriz que recibirá los datos del archivo Productos.csv
	static ArrayList<Producto> list = new ArrayList<Producto>();
	// declarar un nuevo objeto Archivo y pasarle el nombre del archivo como
	// parametro
	static File f = new File(fileproductos);
	// declarar un nuevo FileReader
	static FileReader fr = null;
	// crear un nuevo BufferedReader para leer la entrada del usuario
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// Create an object if itself
	public static void main(String[] args) {
		new ProductosMain();
	}

	// Programa o metodo principal
	public ProductosMain() {
		// llamada a los metodos
		readFile();
		showMenu();
	}// fin

	// Método para leer el archivo (Productos.csv)
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
		// declarar una cadena para guardar cada línea del archivo (Productos.csv)
		String line;

		try {
			// Leer la primera línea
			line = br.readLine();
			// Mientras no es nula, sigue leyendo
			while (line != null) {
				// Matriz de cadenas que dividirán los datos en partes más pequeñas para leer
				String[] data = line.split(";");
				// Cree un objeto Productos y establezca el valor de los atributos (Id, apellido
				// paterno,materno
				// nombre, email, telefono)
				Producto p = new Producto(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]);
				// Agregar a ArrayList
				list.add(p);
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

	// Method para mostrar el menu principal de Sistema para la Gestion de Productos
	public void showMenu() {
		// Cadena que recibirá información del usuario
		String input = " ";
		// bucle que imprimirá el menú principal en la pantalla hasta que el usuario
		// presione "x" para
		// salir del programa y actualizar el csv
		do {
			// print the menu on the screen
			System.out.println("█║▌║█-- NIXUT - Sistema para la Gestion de Productos --█║▌║█");
			System.out.println("| a - Agregar un nuevo Producto                |");
			System.out.println("| b - Buscar un Producto                       |");
			System.out.println("| c - Mostrar un Producto                      |");
			System.out.println("| d - Editar Producto                          |");
			System.out.println("| e - Borrar un Producto                       |");
			System.out.println("| x - Salir/Guardar Cambios                    |");
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

			// condición de cambio de caso para agregar Productos en caso de que la entrada
			// sea 'a'
			switch (input) {
				// métodos de llamada según la opción elegida por el usuario
				case "a":
					addNewProducto();
					break;
				// condición de cambio de caso para buscar la entrada de caso de Productos es
				// 'b'
				case "b":
					searchProducto();
					break;
				// condición de la caja del interruptor para mostrar la entrada de la caja de
				// Productos es 'c'
				case "c":
					displayProducto();
					break;
				// caso de interruptor de condición para modificar la entrada de caso de
				// Productos es 'd'
				case "d":
					modifyProducto();
					break;
				// caso de interruptor de condición para eliminar la entrada de caso de
				// Productos
				// es 'e'
				case "e":
					deleteProducto();
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

	// Método que escribirá datos en el archivo (Productos.csv)
	public void writeFile() {
		// crea un nuevo archivo f
		File f = new File(fileproductos);
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
				bw.write(list.get(x).getNoDeSerie() + ";");
				bw.write(list.get(x).getNombre() + ";");
				bw.write(list.get(x).getPrecio() + ";");
				bw.write(list.get(x).getStock() + ";");
				bw.write(list.get(x).getDescripcion() + ";");
				bw.write(list.get(x).getDescuento() + ";");

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

	// Método para agregar nuevos Productos
	public void addNewProducto() {
		/*
		 * Method should get input from user add details to the list add details to the
		 * file
		 */
		// declarar variables
		int noDeSerie = 0;
		String nombre = " ";
		String precio = "";
		String stock = " ";
		String descripcion = " ";
		String descuento = " ";
		String confirm = " ";
		// bucle que le pedirá al usuario que ingrese datos de Productos
		do {
			// Try para obtener la entrada del usuario
			try {
				// flag
				boolean flag = false;

				do {
					// muestre el mensaje pidiendo al usuario que ingrese el numero de serie del
					// producto
					System.out.println("Ingresa el Numero de serie del producto (solo numeros): ");
					System.out.println();
					// precio recibe la entrada del usuario y la bandera usa el método
					// checknoDeSerie
					// para
					// verificar si
					// ya existe
					noDeSerie = Integer.parseInt(br.readLine());
					flag = ValidarMetodosProducto.checknoDeSerie(noDeSerie, list);
					// condición si bandera == verdadero mostrar ID de mensaje ya existe
					if (flag == true) {
						System.out.println();
						System.out.println("***** El precio ya fue asignado, ingresa un  nuevo *****");
						System.out.println();
					}
					// el bucle se ejecuta mientras la bandera == verdadero
				} while (flag == true);

				// bucle que solicita la entrada del usuario, comprueba si la entrada son letras
				// y si el
				// el campo no está en blanco
				do {
					nombre = ValidarMetodosProducto.getOnlyLettersSpaceNumber("Ingrese el Nombre del Producto: ");
					ValidarMetodosProducto.emptyField(nombre);
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (nombre.isEmpty());

				// bucle que validará el precio y comprobará que ya existe.
				// si existe, muestre el mensaje y solicite al usuario que ingrese un nuevo
				// precio

				// bucle que solicita la entrada del usuario, comprueba si la entrada es un
				// número válido y si
				// el campo no esta vacio
				do {
					// System.out.println("Please enter Producto precio nuevo (numbers only): ");
					precio = ValidarMetodosProducto.getPrice("Ingresa el precio del producto (solo numeros): ");
					ValidarMetodosProducto.emptyField(precio);
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (precio.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada son letras
				// y si el
				// el campo no está vacio
				do {
					stock = ValidarMetodosProducto
							.getOnlyNumber("Ingresa la cantidad de unidades disponibles en el inventario (solo numeros): ");
					ValidarMetodosProducto.emptyField(stock);
					// Mientras el campo está vacío, solicite a la usuario que ingrese nuevamente
				} while (stock.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada son letras
				// y si el
				// no esta vacio
				do {
					descripcion = ValidarMetodosProducto
							.getOnlyLettersSpaceNumber("Ingresa una pequeña descripcion del articulo: ");
					ValidarMetodosProducto.emptyField(descripcion);
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (descripcion.isEmpty());

				// bucle que solicita la entrada del usuario, comprueba si la entrada es un
				// número válido y si
				// el campo no esta vacio
				do {
					// System.out.println("Please enter Productos telefono number (numbers only):
					// ");
					descuento = ValidarMetodosProducto
							.getDiscount("Ingresa el porcentaje del descuento  (solo numeros dos digitos): ");
					ValidarMetodosProducto.emptyField(descuento);
					System.out.println();
					// Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
				} while (descuento.isEmpty());
				do {
					try {
						// Mostrar mensaje pidiendo al usuario que confirme la entrada para los
						// Productos
						System.out.println("Confirmas que es correcta la informacion de este Producto? Y/N");
						// confirmar recibir la entrada del usuario
						confirm = br.readLine();
						// captura la excepción y muestra el mensaje en caso de que haya un error
					} catch (IOException e) {
						System.out.println("*** Algo salio mal *** ");
					}
					// condición en caso de que la entrada del usuario sea Y, elimine los Productos
					// de la lista
					if (confirm.equalsIgnoreCase("Y")) {
						// Crea un objeto Producto y establece el valor de los atributos
						Producto p = new Producto(noDeSerie, nombre, precio, stock, descripcion, descuento);
						// Agregar a ArrayList (lista)
						list.add(p); // mostrar mensaje de que Producto se eliminó con éxito y una línea vacía
						System.out.println("****** Producto Agregado exitosamente !!! ******");
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
	}// end of method addNewProductos
		// Método para buscar Productos

	public void searchProducto() {
		/*
		 * El programa debe buscar por nombre , precio o descripcion buscar debe mostrar
		 * todos los Productos que cumplen con la búsqueda
		 */
		// declarando variables
		int noDeSerie = 0;
		String nombre = " ";
		String precio = " ";
		String input = " ";
		// Intente obtener información del usuario para refinar la búsqueda por Id de
		// Producto, nombre o
		// apellido paterno
		try {
			System.out.println("Te gustaria buscar por: ");
			System.out.println("****************************");
			System.out.println("| 1 - Productos (NUMERO DE SERIE)|");
			System.out.println("| 2 - Productos (NOMBRE)         |");
			System.out.println("| 3 - Productos (PRECIO)         |");
			System.out.println("****************************");
			input = br.readLine();
			// flag
			boolean found = false;

			// caso de interruptor de condición para agregar la entrada de caso de Productos
			// es 'a'
			switch (input) {
				// pedirle al usuario que ingrese los detalles de un Producto por numero de
				// serie
				case "1":
					// pedir información al usuario
					System.out.println("Por favor ingresa el Numero de serie del Producto (solo numeros): ");
					System.out.println();
					try {
						noDeSerie = Integer.parseInt(br.readLine());
						found = false;
						// pedirle al usuario que ingrese los detalles de Clientes por ID
						for (Producto s : list) {
							// si encuentra los Clientes que coinciden con el id lo muestra en la pantalla y
							// cambia
							// flag a true
							if (String.valueOf(s.getNoDeSerie()).contains(String.valueOf(noDeSerie))) {
								System.out.println(s);
								found = true;
							}
						}
						// si no se encuentra el ID muestra el mensaje "ID no encontrado :( " y una
						// línea vacía
						if (found == false) {
							System.out.println("***** Numero de serie no encontrado :( *****");
							System.out.println();
						}
						// en caso de que haya excepciones, mostrar mensaje de error
					} catch (IOException | NumberFormatException nf) {
						System.out.println("***** No valido, Intenta de nuevo *****");
						System.out.println();
					}

					// Pídale al usuario que ingrese los datos de Producto por nombre
				case "2":
					do {
						nombre = ValidarMetodosProducto.getOnlyLettersSpaceNumber("Ingresa el nombre del Producto: ");
						ValidarMetodosProducto.emptyField(nombre);
						// Si el campo está vacío, solicite al usuario que ingrese nuevamente
					} while (nombre.isEmpty());
					found = false;
					// bucle que ejecuta la lista
					for (Producto s : list) {
						// si encuentra los Productos que coinciden con el nombre lo muestra en la
						// pantalla y
						// cambiar la bandera a verdadero
						if (s.getNombre().contains(nombre)) {
							System.out.println(s);
							found = true;
						}
					}
					// si no se encuentra la el nombre muestra el mensaje "nombre no
					// encontrado" y una línea vacía
					if (found == false) {
						System.out.println("***** Nombre no encontrado :( *****");
						System.out.println();
					}
					break;
				// pedirle al usuario que ingrese una pequeña descripcion del producto
				case "3":
					do {
						precio = ValidarMetodosProducto.getOnlyLettersSpaceNumber("Ingresa el precio del Producto: ");
						ValidarMetodosProducto.emptyField(precio);
						// Si el campo está vacío, solicite al usuario que ingrese nuevamente
					} while (precio.isEmpty());
					found = false;
					// bucle que ejecuta la lista
					for (Producto s : list) {
						// si encuentra los Productos que coinciden con el apellido paterno lo muestra
						// en
						// la pantalla y cambia la bandera a true
						if (s.getPrecio().contains(precio)) {
							System.out.println(s);
							found = true;
						}
					}
					// si no se encuentra la descripcion muestra el mensaje "Descripcion no
					// encontrada" y una línea vacía
					if (found == false) {
						System.out.println("***** Precio no encontrado :( *****");
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
	}// fin del metodo searchProductos

	// Método que mostrará un Producto
	public void displayProducto() {
		// declarar variables y darles valores
		int input = 0;
		boolean f = false;
		do {
			f = false;
			// mostrar detalles de Productos por precio de Productos
			System.out.println("Ingresa el Numero de serie del producto Solo numeros: ");
			try {
				// la entrada recibe el precio del usuario
				input = Integer.parseInt(br.readLine());
				// flag
				boolean found = false;
				// bucle que ejecuta la lista
				for (Producto s : list) {
					// si el precio está en la lista, la muestra en la pantalla y cambia la
					// bandera a verdadera
					if (String.valueOf(s.getNoDeSerie()).contains(String.valueOf(input))) {
						System.out.println(s);
						found = true;
					}
				}
				// si el ID no está en la lista, muestre el mensaje "ID no encontrado" y una
				// línea vacía
				if (found == false) {
					System.out.println("***** Numero de serie no encontrado :( *****");
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
	}// FIn del metodo displayProductos

	// Metodo modify Productos
	public void modifyProducto() {
		/*
		 * El programa debe cambiar los detalles (apellidoPaterno, apellidoMaterno
		 * nombre, email, telefono) excepto Los cambios de número de Producto deben
		 * guardarse en la lista y el archivo
		 */
		// declarar variables y darles valores
		int input = 0;
		String data = " ";
		String nombre = " ";
		String precio = " ";
		String stock = " ";
		String descripcion = " ";
		String descuento = " ";
		String confirm = " ";

		// mostrar detalles de Productos por número de Productos
		System.out.println("Ingresa el numero de serie del Producto (solo numeros): ");
		// try para obtener el ID del usuario
		try {
			// La entrada recibe el id del usuario
			input = Integer.parseInt(br.readLine());
			// flag
			boolean found = false;
			// crea un objeto Productos cli como nulo
			Producto prod = null;
			// bucle que ejecuta la lista
			for (Producto s : list) {
				// si lID está en la lista, muestra los detalles de Productos y
				// cambia la bandera a verdadera
				if (String.valueOf(s.getNoDeSerie()).contains(String.valueOf(input))) {
					// System.out.println(s);
					prod = s;
					found = true;
				}
			}
			// si el ID no está en la lista, muestre el mensaje "ID no encontrado" y una
			// línea vacía
			if (found == false) {
				System.out.println("***** No de serie no encontrado*****");
				System.out.println();
				// si ID está en la lista
			} else {
				// bucle que le pedirá al usuario que actualice la información de Productos por:
				// nombre, apellido
				// paterno,
				// email or numero de telefono
				// or regresa al menu principal
				// información de nombre, apellido paterno, email o numero de telefono será
				// guardada
				// in "case 6"

				nombre = prod.getNombre();
				precio = prod.getPrecio();
				stock = prod.getStock();
				descripcion = prod.getDescripcion();
				descuento = prod.getDescuento();
				do {
					System.out.println("Nombre del producto: " + nombre + "\n" + "Precio: " + "$" + precio + "\n"
							+ "Disponibilidad " + stock + "\n" + "Descripcion: " + descripcion + "\n" + "Descuento disponible: "
							+ descuento + "%" + "\n" + "\n");
					System.out.println("*****************************************");
					System.out.println("Selecciona la opcion que desea editar del Producto:    ");
					System.out.println("| 1 - Nombre del Producto                       |");
					System.out.println("| 2 - Precio del Producto                       |");
					System.out.println("| 3 - Disponibilidad del producto               |");
					System.out.println("| 4 - Descripcion del producto                  |");
					System.out.println("| 5 - Descuento disponible                      |");
					System.out.println("| 6 - Guardar cambios y volver a Menu principal |");
					System.out.println("| 0 - Regresar al menu principal                |");
					System.out.println("*****************************************");
					data = br.readLine();
					found = false;

					// caso de switch de condición para agregar la entrada de caso de Productos es
					// 'a'
					switch (data) {
						// Pídale al usuario que ingrese el Nombre del Producto si la opción es 1
						case "1":
							do {
								nombre = ValidarMetodosProducto.getOnlyLettersSpaceNumber("Ingresa el nuevo nombre del producto: ");
								ValidarMetodosProducto.emptyField(nombre);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (nombre.isEmpty());
							System.out.println();
							break;
						// pedirle al usuario que ingrese la disponibilidad del producto si la opción
						// es 2
						case "2":
							do {
								precio = ValidarMetodosProducto.getPrice("Ingresa el nuevo precio del producto: ");
								ValidarMetodosProducto.emptyField(precio);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (precio.isEmpty());
							System.out.println();
							break;
						case "3":
							do {
								stock = ValidarMetodosProducto.getOnlyNumber(
										"Ingresa la nueva cantidad de unidades disponibles en el inventario (solo numeros): ");
								ValidarMetodosProducto.emptyField(stock);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (stock.isEmpty());
							System.out.println();
							break;
						// pedirle al usuario que ingrese una descripcion del producto si la opción
						// es 3
						case "4":
							do {
								descripcion = ValidarMetodosProducto.getOnlyLettersSpaceNumber("Ingresa la nueva descripcion: ");
								ValidarMetodosProducto.emptyField(descripcion);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (descripcion.isEmpty());
							System.out.println();
							break;
						// Pedirle al usuario que ingrese el correo electrónico del Producto si la
						// opción
						// es 4
						case "5":
							do {
								descuento = ValidarMetodosProducto.getDiscount("Ingresa el nuevo descuento del Producto: ");
								ValidarMetodosProducto.emptyField(descuento);
								// Si el campo está vacío, solicite al usuario que ingrese nuevamente
							} while (descuento.isEmpty());
							System.out.println();
							break;
						// Pedirle al usuario que ingrese el telefono del Producto si
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
								// condición en caso de que la entrada del usuario sea Y, elimine los Productos
								// de la lista
								if (confirm.equalsIgnoreCase("Y")) {
									/* si guarda (Y) */
									prod.setNombre(nombre);
									prod.setPrecio(precio);
									prod.setStock(stock);
									prod.setDescripcion(descripcion);
									prod.setDescuento(descuento);
									// muestra el mensaje de que Productos se eliminó correctamente y una línea
									// vacía
									System.out.println("Producto actualizado correctamente !!!");
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
	}// fin del metodo modifyProductos

	// Meotodo delete Productos
	public void deleteProducto() {
		/*
		 * El programa debe eliminar Productos por número de Productos eliminar de la
		 * lista y el archivo
		 */
		// declarar variables y darles valores
		int input = 0;
		String confirm = " ";

		// mostrar detalles de Productos por número de Productos
		System.out.println("Ingresa el numero de serie del producto (solo numeros) ");
		// tratar de obtener el precio de Productos
		try {
			// La entrada recibe el id del usuario
			input = Integer.parseInt(br.readLine());
			// captura la excepción y muestra el mensaje en caso de que haya un error
		} catch (IOException | NumberFormatException nfe) {
			System.out.println("***** ALgo salio mal..! Intentalo otra vez*****");
		}
		// flag
		boolean found = false;
		Producto cli = null;
		// bucle que ejecutará la lista. Si el precio coincide, muestra los
		// Productos y cambia
		// flag a true
		for (Producto s : list) {
			if (s.getNoDeSerie() == input) {
				System.out.println(s);
				cli = s;
				found = true;
			}
		}
		// si no se encuentra el precio, muestre el mensaje "No se encontró la
		// ID" y una línea vacía
		if (found == false) {
			System.out.println("***** ID no encontrado *****");
			System.out.println();
			// si Productos encontró, mostrar un mensaje pidiendo al usuario que confirme y
			// elimine el Producto
		} else {
			do {
				System.out.println("Deseas eliminar este Producto? Y/N");
				try {
					// confirmar recibir la entrada del usuario
					confirm = br.readLine();
					// captura la excepción y muestra el mensaje en caso de que haya un error
				} catch (IOException e) {
					System.out.println("***** Algo salio mal :( ..! *****");
				}
				// condición en caso de que la entrada del usuario sea Y, elimine los productos
				// de la lista
				if (confirm.equalsIgnoreCase("Y")) {
					list.remove(cli);
					// mostrar mensaje de que Productos se eliminó con éxito y una línea vacía
					System.out.println("***** Producto eliminado exitosamente !!! *****");
					System.out.println();
				}
				// El bucle se ejecuta mientras que la confirmación no es Y o N
			} while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));
		}
		// método de llamada pressEnter
		pressEnter();
	}// fin del metodo deleteProductos

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
}// Fin de la clase ProductosMain
