package src;

/**
 * Clase que permite escribir y leer a Operadores sobre un archivo CSV
 * 
 * @author Ricardo Badillo Macias
 * @version 11/10/2021
 */
public class OperadorArchivo extends LeeryEscribir {
  /**
   * Constructor por omision que crea el archivo Operador.csv
   */
  public OperadorArchivo() {
    super("Operador.csv");
  }

  /**
   * Metodo que prepara el arreglo de Operadores para que puede ser guardado
   * 
   * @param operador -- El arreglo de operador
   */
  public void escribeOpeador(Operador operador[]) {
    String lineaOperador = "";
    for (Operador o : operador) {
      lineaOperador += o + "\n";
    }
    super.escribeArchivo(lineaOperador);
  }

  /**
   * Metodo que convierte un arreglo de String a un arreglo de Operadores
   * 
   * @return operadores -- El arreglo de operadores
   * @throws ArchivoNoExiste -- Se lanza la excepción cuando el archivo no existe
   */
  public Operador[] leeOperadores() throws ArchivoNoExiste {
    String lineas[] = super.leeArchivo();
    Operador operadores[] = new Operador[lineas.length];
    for (int i = 0; i < operadores.length; i++) {
      if (!lineas[i].equals("null")) {
        operadores[i] = this.parseaOperador(lineas[i]);
      }
    }
    return operadores;
  }

  /**
   * Metodo que recibe una cadena y parsea los datos para crear a un Operador
   * 
   * @param cadenaOperador -- La cadena parsear
   * @return el objeto con los datos de la cadena
   */
  private Operador parseaOperador(String cadenaOperador) {
    String linea[] = cadenaOperador.trim().split(",");
    String nombre = linea[0];
    String apellidoP = linea[1];
    String apellidoM = linea[2];
    String fecha = linea[3];
    String direccion = linea[4];
    char genero = linea[5].charAt(0);
    String gradoMaximo = linea[6];
    String telefono = linea[7];
    String horario = linea[8];
    String dias = linea[9];
    return new Operador(nombre, apellidoP, apellidoM, fecha, direccion, genero, gradoMaximo, telefono, horario, dias);
  }

}
