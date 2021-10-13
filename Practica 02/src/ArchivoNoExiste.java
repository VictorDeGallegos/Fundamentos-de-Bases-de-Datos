package src;

/**
 * Clase que permite escribir y leer a Operadores sobre un archivo CSV
 * 
 * @author JAVATAR
 * @version 11/10/2021
 */
public class ArchivoNoExiste extends Exception {
  public ArchivoNoExiste(String message) {
    super(message);
  }
}
