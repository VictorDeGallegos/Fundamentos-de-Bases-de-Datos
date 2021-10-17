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
	 *
	public void addNewCategoria(){
		
		/**
		 * Declaracion de variables para el metodo
		 *

		String nombreCategoria = " ";
		String descripcionCategoria = " ";
		int numeroProductos = 0;
		int id = id;
		String confirm = " ";


		/**
		 * Declaracion de estructura de control que le pedirá al usuario que ingrese datos de Clientes
		 *

		do {

			/**
			 * Lanzamos excepcion para atrapar errores del usuario
			 *
			try {
				
				// flag
				boolean flag = false;
				
				/**
				 * Bucle que validará el nombre y comprobará si ya existe, si es asi lanzara mensaje al usuario
				 *
				do {}
				*/

}