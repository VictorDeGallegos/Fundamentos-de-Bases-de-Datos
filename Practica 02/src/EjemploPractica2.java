package src;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Main que sirve de ejemplo para lo que van a entregar en la practica 2
 * 
 * @author JAVATAR
 * @version 11/10/2021
 */
public class EjemploPractica2 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    boolean bandera;
    int opcion = 0;
    Scanner input = new Scanner(System.in);
    Operador[] operadores = new Operador[5];
    OperadorArchivo archivo = new OperadorArchivo();
    do {
      bandera = true;
      System.out.println("Ingresa la opción deseada\n" + "1-Agregar Operador\n" + "2-Ver Operadores\n"
          + "3-Editar Operador\n" + "4-Borrar Operador\n" + "5-Salir\n");
      try {
        opcion = input.nextInt();
      } catch (InputMismatchException e) {
        input.next();
        System.out.println("Ingresa un número como opción");
      }
      if (opcion > 0 && opcion < 6) {
        switch (opcion) {
          case 1:
            Operador operador = new Operador();
            operadores[0] = operador;
            System.out.println("Se agrego el Operador");

            break;
          case 2:
            System.out.println(operadores[0].toString());
            break;
          case 3:
            break;
          case 4:
            break;

          case 5:
            System.out.println("Guardando datos de operadores...");
            archivo.escribeOpeador(operadores);
            bandera = false;
            System.out.println("Datos guardados");
            System.out.println("Saliendo del sistema...\nHasta pronto.");
            break;
          default:
            break;
        }
      }
    } while (bandera);

  }
}
