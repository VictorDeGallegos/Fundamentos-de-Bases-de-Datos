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
 * MAIN ,getters and setters.
 * 
 * @author JAVATAR.
 * @version 1.0, Octubre 2021.
 * @since Fundamentos de bases de datos, Prática 2.
 */

public class ProveedoresMain {
  /**
   * Variables globales
   */
  static String archivo = "Proveedores.csv"; // Variable para archivo
  static ArrayList<Proveedores> list = new ArrayList<>(); // Estructura de datos para .csv
  static File file = new File(archivo); // Objeto File y recibe archivo como parametro
  static FileReader fileReader = null; // declaracion de FileReader
  static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); // Creacion de

  /**
   * @param args
   */
  // BufferedReader para
  // entrada de usuario

  public static void main(String[] args) {
    new ProveedoresMain(); // Creacion del objeto
  }

  /**
   * Metodo Principal
   */
  public ProveedoresMain() {

    /**
     * Invocacion de metodos
     */

    readFile();
    showMenu();
  }

  /**
   * Metodo para leer .csv
   */
  public void readFile() {

    FileReader fileReader = null;

    /**
     * Lanzamos excepcion para atrapar algun error al leer el archivo
     */
    try {

      fileReader = new FileReader(file);
    } catch (FileNotFoundException e) {

      // Se lanza mensaje al usuario si la excepcion atrapa algo
      System.out
          .println(" 〷 --> No se encontro el archivo con extencion \".csv\" el cual contiene la base de datos <-- 〷");
    }

    /**
     * Creacion de BufferedReader el cual recibe fileReader Declaramos un String que
     * servira para guardar cada linea en .csv
     */

    BufferedReader bufferedReader = new BufferedReader(fileReader);

    String line;

    /**
     * Lanzamos excepcion si hay error al leer el archivo Inicializamos lectura del
     * archivo
     */

    try {

      line = bufferedReader.readLine(); // Lectura de primera linea

      /**
       * Declaro estructura de control, asi seguira leyendo mientras no sea nula
       */

      while (line != null) {

        /**
         * 1.- Se dividira con ";" para una lectura mas rapida y eficiente. 2.-
         * Crearemos un objeto Proveedores con sus atributos como: nombre de la
         * Proveedores, descripcion de la Proveedores, numero de productos en la
         * Proveedores. 3.- Estos atributos se agregan al ArrayList y despues sigue
         * leyendo las lineas
         */
        String[] data = line.split(";");

        Proveedores s = new Proveedores(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]);

        list.add(s);
        line = bufferedReader.readLine();
      }
      bufferedReader.close(); // Se cierra BufferedReader
    } catch (IOException ioe) {

      // Se lanza mensaje al usuario si la excepcion atrapo algo
      System.out.println("〷 ☛ Error al leer el archivo ☚ 〷" + "\n");
    }
  }

  /**
   * Menu lanzado en terminal para gestionar
   */
  public void showMenu() {

    // Variables para ejecucion de menu

    String entradaUsuario = "";

    /**
     * Estructura de control para ejecucion de menu y actualizacion de archivo .csv
     */

    do {
      // Menu mostrado en terminal
      System.out.println("♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕  N I X U T® ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ");
      System.out.println("\n         SISTEMA DE GESTION DE          \n");
      System.out.println("| a - Agregar un nuevo proovedor                 |");
      System.out.println("| b - Buscar un proveedor                        |");
      System.out.println("| c - Mostrar un proveedor                       |");
      System.out.println("| d - Editar proveedor                           |");
      System.out.println("| e - Borrar un proveedor                        |");
      System.out.println("| x - Salir/Guardar Cambios                      |");
      System.out.println("\n♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ♕ ♔ ");

      System.out.println("\n♔ ♔ ♔ ESCRIBE LA LETRA DE TU OPCION LEGIDA ♔ ♔ ♔\n");

      /**
       * Lanzamos excepcion si el usuario da como entrada un caracter diferente a las
       * opciones
       */
      try {

        entradaUsuario = bufferedReader.readLine(); // Guardamos opcion del usuario

      } catch (IOException e) {

        // Mensaje lanzado en terminal para avisar al usuario de un error
        System.out.println(" Algo salio mal...! ");
      }

      /**
       * Menu hecho por casos segun la necesidad del usuario
       */

      switch (entradaUsuario) {

        // métodos de llamada según la opción elegida por el usuario

        // Caso donde se entra en la opcion 'a'
        case "a":
          addNewProveedor();
          break;

        // condición donde se entra en la opcion 'b'

        case "b":
          searchProveedor();
          break;
        // condición para mostrar la entrada de la eleccion 'c'

        case "c":
          displayProveedor();
          break;
        // caso donde se entra en la opcion 'd'

        case "d":
          modifyProveedor();
          break;

        // caso donde se ejecuta la opcion 'e'

        case "e":
          deleteProveedor();
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
   * Metodo para escribir en el archivo .csv
   */
  public void writeFile() {

    // Creacion de Objeto tipo File

    File file = new File(archivo);
    FileWriter fileWriter = null;

    /**
     * Se lanza excepcion y se crea Archivo
     */

    try {

      // escribir en el archivo
      fileWriter = new FileWriter(file);

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
        bufferedWriter.write(list.get(x).getId() + ";");
        bufferedWriter.write(list.get(x).getRazonSocial() + ";");
        bufferedWriter.write(list.get(x).getTelefono() + ";");
        bufferedWriter.write(list.get(x).getDireccion() + ";");

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
      bufferedWriter.close();
    } catch (IOException e) {

      // mostrar mensaje en caso de que haya un error al cerrar BufferedWriter
      System.out.println("*** Error al cerrar BufferedWriter ***");
    }

    /**
     * Excepcion lanzada para el cierre de FileWriter.
     */

    try {
      fileWriter.close();
    } catch (IOException e) {
      // mostrar mensaje en caso de que haya un error al cerrar FileWriter
      System.out.println("*** Error al cerrar FileWriter ***");
    }
  }

  /**
   * Metodo para agregar , con sus respectivos atributos
   */
  public void addNewProveedor() {

    /**
     * Declaracion de variables para el metodo
     */

    int id = 0;
    String razonSocial = " ";
    String direccion = " ";
    String telefono = "";
    String confirm = " ";
    String rfc = " ";

    /**
     * Declaracion de estructura de control que le pedirá al usuario que ingrese
     * datos de
     */

    do {

      /**
       * Lanzamos excepcion para atrapar errores del usuario
       */
      try {

        // flag
        boolean flag = false;

        /**
         * Bucle que validará el nombre del proveedor y comprobará si ya existe, si es
         * asi lanzara mensaje al usuario
         */
        do {

          System.out.println("Ingresa ID del proveedor, solo numeros \n");

          id = Integer.parseInt(bufferedReader.readLine());
          flag = ValidarMetodosProveedores.checkID(id, list);

          // condición si bandera == verdadero mostrar ID de mensaje ya existe
          if (flag == true) {

            System.out.println("\n***** El ID ya fue registrado, ingresa un ID nuevo *****\n");
          }

        } while (flag == true);// el bucle se ejecuta mientras la bandera == verdadero

        /**
         * El bucle que solicita la entrada del usuario, comprueba si la entrada son
         * letras y si el el campo no está en blanco
         */
        do {
          razonSocial = ValidarMetodosProveedores.getOnlyLetters("Ingrese Razon Social (solo letras): ");
          ValidarMetodosProveedores.emptyField(razonSocial);

          // Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
        } while (razonSocial.isEmpty());

        /**
         * bucle que solicita la entrada del usuario, comprueba si la entrada son letras
         * y si el campo no está vacio
         */
        do {
          direccion = ValidarMetodosProveedores.getOnlyLettersSpaceNumber("Ingresa la direccion del Proveedor: ");
          ValidarMetodosProveedores.emptyField(direccion);

          // Mientras el campo está vacío, solicite a la usuario que ingrese nuevamente
        } while (direccion.isEmpty());

        /**
         * bucle que solicita la entrada del usuario, comprueba si la entrada es un
         * número válido y si el campo no esta vacio
         */
        do {
          // Se le pide al usuario ingrasar el numero de productos
          telefono = ValidarMetodosProveedores.getPhone("Ingresa el numero de productos (solo numeros): ");
          ValidarMetodosProveedores.emptyField(telefono);

          // Mientras el campo está vacío, solicite al usuario que ingrese nuevamente
        } while (telefono.isEmpty());
        do {
          try {
            // Mostrar mensaje pidiendo al usuario que confirme la entrada para las
            //
            System.out.println("Confirmas que es correcta la informacion de este proveedor? Y/N");
            // confirmar recibir la entrada del usuario
            confirm = bufferedReader.readLine();
            // captura la excepción y muestra el mensaje en caso de que haya un error
          } catch (IOException e) {
            System.out.println("*** Algo salio mal *** ");
          }
          // condición en caso de que la entrada del usuario sea Y, elimine las
          // de la lista
          if (confirm.equalsIgnoreCase("Y")) {

            // Crea un objeto y establece el valor de los atributos
            Proveedores s = new Proveedores(id, razonSocial, telefono, direccion, rfc);
            // Agregar a ArrayList (lista)
            list.add(s); // mostrar mensaje de que Provedor se eliminó con éxito y una línea vacía
            System.out.println("****** Proveedor Agregada exitosamente !!! ******");
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
  }

  /*
   * Metodo para buscar El programa debe buscar por Razon Social buscar debe
   * mostrar todos las que cumplen con la búsqueda
   */
  public void searchProveedor() {

    // declarando variables
    String razonSocial = " ";
    String input = " ";

    /**
     * Intente obtener información del usuario para refinar la búsqueda por Id de
     * Proveedor.
     */
    try {
      System.out.println(" Buscar  por nombre ");
      System.out.println("***********************************");
      System.out.println("\n Para buscar por Razon Social ingresa: 1 \n");
      System.out.println("***********************************");
      input = bufferedReader.readLine();
      // flag
      boolean found = false;

      // caso de interruptor de condición para agregar la entrada de caso de
      //
      // es 'a'
      switch (input) {

        case "1":
          do {
            razonSocial = ValidarMetodosProveedores.getOnlyLetters("Ingresa el nombre de Proveedor : ");
            ValidarMetodosProveedores.emptyField(razonSocial);
            // Si el campo está vacío, solicite al usuario que ingrese nuevamente
          } while (razonSocial.isEmpty());
          found = false;
          // bucle que ejecuta la lista
          for (Proveedores s : list) {

            /**
             * si encuentra las que coinciden con el nombre lo muestra en la pantalla y
             * cambiar la bandera a verdadero
             */
            if (s.getRazonSocial().contains(razonSocial)) {
              System.out.println(s);
              found = true;
            }
          }

          /**
           * si no se encuentra la ID muestra el mensaje "nombre no encontrado" y una
           * línea vacía
           */
          if (found == false) {

            System.out.println("***** Proveedor no encontrada :( *****\n");

          }

          break;

        // Caso que mostrará un mensaje de error en caso de que la entrada del usuario
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
  }

  // Método que mostrará un Proveedor
  public void displayProveedor() {
    // declarar variables y darles valores
    int input = 0;
    boolean file = false;
    do {
      file = false;
      // mostrar direccion de proveedor por id de proveedor
      System.out.println("Ingresa el ID del proveedor: ");
      try {
        // la entrada recibe la ID del usuario
        input = Integer.parseInt(bufferedReader.readLine());
        // flag
        boolean found = false;
        // bucle que ejecuta la lista
        for (Proveedores s : list) {
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

        System.out.println("***** Oops! you did it again, intenta otra vez *****\n");

        file = true;
      }
    } while (file);
  }

  // Metodo modify
  public void modifyProveedor() {
    /*
     * El programa debe cambiar los detalles (Rason Social, direccion y telefono por
     * proveedor estos deben guardarse en la lista y el archivo
     */
    // declarar variables y darles valores
    int input = 0;
    String data = " ";
    String razonSocial = " ";
    String direccion = " ";
    String telefono = " ";
    String rfc = " ";
    String confirm = "";

    // mostrar detalles de Proveedor por id
    System.out.println("Ingresa el ID del Proveedor: ");
    // try para obtener el ID del usuario
    try {
      // La entrada recibe el id del usuario
      input = Integer.parseInt(bufferedReader.readLine());
      // flag
      boolean found = false;
      // crea un objeto proveedor llamado pro como nulo
      Proveedores pro = null;
      // bucle que ejecuta la lista
      for (Proveedores s : list) {
        // si el ID está en la lista, muestra los detalles de Proveedor y
        // cambia la bandera a verdadera
        if (String.valueOf(s.getId()).contains(String.valueOf(input))) {
          // System.out.println(s);
          pro = s;
          found = true;
        }
      }
      // si el ID no está en la lista, muestre el mensaje "ID no encontrado" y una
      // línea vacía
      if (found == false) {
        System.out.println("***** ID no encontrado*****");

        // si ID está en la lista
      } else {
        /**
         * Bucle que le pedirá al usuario que actualice la información del Proveedor
         */

        razonSocial = pro.getRazonSocial();
        direccion = pro.getDireccion();
        telefono = pro.getTelefono();

        do {

          System.out.println("ID de la Proveedor: " + pro.getId() + "\n" + "Razon Social: " + razonSocial + "\n"
              + "Direccion de Proveedor: " + direccion + "\n" + "Telefono: " + telefono + "\n" + "RFC: " + rfc);
          System.out.println("*****************************************");
          System.out.println("Selecciona la opcion que desea editar de los proveedores:    ");
          System.out.println("| 1 - Razon Social                              |");
          System.out.println("| 2 - Direccion                                 |");
          System.out.println("| 3 - Telefono                                  |");
          System.out.println("| 3 - RFC                                       |");
          System.out.println("| 4 - Guardar cambios y volver a Menu principal |");
          System.out.println("| 0 - Regresar al menu principal                |");
          System.out.println("*****************************************");
          data = bufferedReader.readLine();
          found = false;

          // caso de switch de condición para agregar la entrada de caso de es
          // 'a'
          switch (data) {
            // Pídale al usuario que ingrese la Razon Social si la opción es 1
            case "1":
              do {
                razonSocial = ValidarMetodosProveedores.getOnlyLetters("Ingresa la nueva Razon Social (solo letras): ");
                ValidarMetodosProveedores.emptyField(razonSocial);
                // Si el campo está vacío, solicite al usuario que ingrese nuevamente
              } while (razonSocial.isEmpty());
              System.out.println();
              break;

            // si el usuario quiere ingresar direccion de proveedor

            case "2":
              do {
                direccion = ValidarMetodosProveedores
                    .getOnlyLettersSpaceNumber("Ingresa los nuevos detalles de la direccion: ");
                ValidarMetodosProveedores.emptyField(direccion);
                // Si el campo está vacío, solicite al usuario que ingrese nuevamente
              } while (direccion.isEmpty());
              System.out.println();
              break;

            // Pedirle al usuario que ingrese el telefono si la opcion es 3

            case "3":
              do {
                telefono = ValidarMetodosProveedores.getPhone("Ingresa la nueva descripcion del proveedor ");
                ValidarMetodosProveedores.emptyField(telefono);
                // Si el campo está vacío, solicite al usuario que ingrese nuevamente
              } while (telefono.isEmpty());
              System.out.println();
              break;

            case "4":
              do {
                System.out.println("Confirmas los cambios realizados? Y/N");
                try {
                  // confirmar recibir la entrada del usuario
                  confirm = bufferedReader.readLine();
                  // captura la excepción y muestra el mensaje en caso de que haya un error
                } catch (IOException e) {
                  System.out.println("***** Algo salio mal :( ..! ***** ");
                }
                // condición en caso de que la entrada del usuario sea Y, elimine las
                // de la lista
                if (confirm.equalsIgnoreCase("Y")) {
                  /* si guarda (Y) */
                  pro.setRazonSocial(razonSocial);
                  pro.setDireccion(direccion);
                  pro.setTelefono(telefono);
                  // muestra el mensaje de que proveedor se eliminó correctamente y una línea
                  // vacía
                  System.out.println("Proveedor actualizado correctamente !!!");
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
        } while (!data.equals("0") && !data.equals("4"));
      }
      // catch exception and show message in case there's an error
    } catch (IOException | NumberFormatException nfe) {
      System.out.println("***** Entrada invalida..! Vuelve a intentarlo *****");
      System.out.println();
    }
  }

  // Metodo delete Proveedor
  public void deleteProveedor() {
    /*
     * El programa debe eliminar Proveedor por id
     */
    // declarar variables y darles valores
    int input = 0;
    String confirm = " ";

    // mostrar direccion de la proveedor por número de la proveedor
    System.out.println("Ingresa el ID del Proveedor ");
    // tratar de obtener la ID de Proveedor
    try {
      // La entrada recibe el id del usuario
      input = Integer.parseInt(bufferedReader.readLine());
      // captura la excepción y muestra el mensaje en caso de que haya un error
    } catch (IOException | NumberFormatException nfe) {
      System.out.println("***** Algo salio mal..! Intentalo otra vez*****");
    }
    // flag
    boolean found = false;
    Proveedores pro = null;
    // bucle que ejecutará la lista. Si la ID coincide, muestra las y
    // cambia
    // flag a true
    for (Proveedores s : list) {
      if (s.getId() == input) {
        System.out.println(s);
        pro = s;
        found = true;
      }
    }
    // si no se encuentra la ID, muestre el mensaje "No se encontró la
    // ID" y una línea vacía
    if (found == false) {
      System.out.println("***** ID no encontrado *****");
      System.out.println();
      // si encontró, mostrar un mensaje pidiendo al usuario que confirme y
      // elimine al proveedor
    } else {
      do {
        System.out.println("Deseas eliminar este Proveedor? Y/N");
        try {
          // confirmar recibir la entrada del usuario
          confirm = bufferedReader.readLine();
          // captura la excepción y muestra el mensaje en caso de que haya un error
        } catch (IOException e) {
          System.out.println("***** Algo salio mal :( ..! *****");
        }
        // condición en caso de que la entrada del usuario sea Y, elimine las
        // de la lista
        if (confirm.equalsIgnoreCase("Y")) {
          list.remove(pro);
          // mostrar mensaje de que se eliminó con éxito y una línea vacía
          System.out.println("***** Proveedor eliminada exitosamente !!! *****");
          System.out.println();
        }
        // El bucle se ejecuta mientras que la confirmación no es Y o N
      } while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));
    }
    // método de llamada pressEnter
    pressEnter();
  }// fin del metodo deleteProveedor

  // Metodo pressEnter
  public void pressEnter() {
    // intente presionar enter para continuar
    try {
      System.out.print("Presiona <Enter> para continuar ... ");
      bufferedReader.readLine();
      System.out.println();
      // captura la excepción si hay un error
    } catch (IOException ioe) {
    }
  }// fin del método presione Entrar

}