/*
 * author JAVATAR
 * 
 * Class that contains all the validation methods for the program
 */

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Clase ValidarMetodos
public class ValidarMetodosProducto {
	// Variable Global
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * @param lineMessage
	 * @return String
	 */
	// Método que verifica si la entrada del usuario es solo letras y muestra
	// mensajes de error
	// en caso de que la entrada sea otra cosa (por ejemplo: números)
	public static String getOnlyLetters(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que verificará si la entrada del usuario son letras
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException | StringIndexOutOfBoundsException e) {
				System.out.println("Error al recibir letras");
			}
			// condición que atraviesa el tamaño de las letras y cambia el valor a false

			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 65) || ((int) letters.charAt(l) > 90))
						&& (((int) letters.charAt(l) < 97) || ((int) letters.charAt(l) > 122)))
					check = false;
			}
			if (check == false)
				System.out.println("¡Entrada inválida! ¡Intentar otra vez!");
			// El bucle se ejecuta mientras la verificación == falsa
		} while (check == false);
		return letters;
	}

	/**
	 * @param lineMessage
	 * @return String
	 */
	// Método que verifica si la entrada del usuario es solo letras y espacios y
	// muestra
	// mensajes de error
	// en caso de que la entrada sea otra cosa (por ejemplo: números)
	public static String getOnlyLettersSpace(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que verificará si la entrada del usuario son letras
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException | StringIndexOutOfBoundsException e) {
				System.out.println("Error al recibir letras");
			}
			// condición que atraviesa el tamaño de las letras y cambia el valor a false

			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 65) || ((int) letters.charAt(l) > 90))
						&& (((int) letters.charAt(l) < 97) || ((int) letters.charAt(l) > 122))
						&& ((int) letters.charAt(l) != 32)) /* SPACE */

					check = false;
			}
			if (check == false)
				System.out.println("¡Entrada inválida! ¡Intentar otra vez!");
			// El bucle se ejecuta mientras la verificación == falsa
		} while (check == false);
		return letters;
	}

	/**
	 * @param lineMessage
	 * @return String
	 */
	// Método que verifica si la entrada del usuario es solo numeros
	// numeros
	// muestra
	// mensajes de error
	// en caso de que la entrada sea otra cosa (por ejemplo: números)
	public static String getOnlyNumber(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que verificará si la entrada del usuario son letras
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException | StringIndexOutOfBoundsException e) {
				System.out.println("Error al recibir letras");
			}
			// condición que atraviesa el tamaño de las letras y cambia el valor a false

			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 48) || ((int) letters.charAt(l) > 57)))/* 0 - 9 */

					check = false;
			}
			if (check == false)
				System.out.println("¡Entrada inválida! ¡Intentar otra vez!");
			// El bucle se ejecuta mientras la verificación == falsa
		} while (check == false);
		return letters;
	}

	/**
	 * @param lineMessage
	 * @return String
	 */
	// Método que verifica si la entrada del usuario es solo letras, espacios y
	// numeros
	// muestra
	// mensajes de error
	// en caso de que la entrada sea otra cosa (por ejemplo: números)
	public static String getOnlyLettersSpaceNumber(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que verificará si la entrada del usuario son letras
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException | StringIndexOutOfBoundsException e) {
				System.out.println("Error al recibir letras");
			}
			// condición que atraviesa el tamaño de las letras y cambia el valor a false

			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 65) || ((int) letters.charAt(l) > 90))
						&& (((int) letters.charAt(l) < 97) || ((int) letters.charAt(l) > 122))
						&& (((int) letters.charAt(l) < 48) || ((int) letters.charAt(l) > 57)) /* 0 - 9 */
						&& ((int) letters.charAt(l) != 32)) /* SPACE */

					check = false;
			}
			if (check == false)
				System.out.println("¡Entrada inválida! ¡Intentar otra vez!");
			// El bucle se ejecuta mientras la verificación == falsa
		} while (check == false);
		return letters;
	}

	/**
	 * @param fieldValue
	 * @return boolean
	 */
	// Método que comprueba si el campo está vacío, muestra un mensaje de error en
	// caso de que sea falso
	public static boolean emptyField(String fieldValue) {
		boolean check = false;

		// Cadena [] vacía = nueva Cadena [x];
		// recorremos los estudiantes de la lista
		if (fieldValue.isEmpty()) {
			check = true;
			System.out.println();
			System.out.println("El campo está vacío, ingrese la entrada.");
			System.out.println();
		}

		return check;
	}

	/**
	 * @param nombre
	 * @param list
	 * @return boolean
	 */
	// Método que comprueba si un articulo esta en está en la lista. Si devuelve
	// "verdadero"
	public static boolean checkNombre(String nombre, ArrayList<Clientes> list) {
		boolean check = false;

		// bucle que ejecuta la lista en busca de la identificación
		for (int x = 0; x < list.size(); x++) {
			if (list.get(x).getNombre() == nombre) {
				check = true;
			}
		}
		return check;
	}

	/**
	 * @param lineMessage
	 * @return String
	 */
	// Método que verifica el descuento
	public static String getDescuento(String lineMessage) {
		boolean flag = true;
		String letters = "";
		// bucle que ejecutará el programa para verificar el número de teléfono y tratar
		// las excepciones si
		// hay algun error
		do {
			flag = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
				if (letters.length() != 2) {
					flag = false;
				}
				for (int l = 0; l < letters.length(); l++) {
					Integer.parseInt(String.valueOf(letters.charAt(l)));
				}
			} catch (IOException e) {
			} catch (NumberFormatException nfe) {
				flag = false;
			}
			// condición que muestra un mensaje en caso de que la entrada del usuario esté
			// en el formato incorrecto
			if (flag == false)
				System.out.println("Numero invalido! Ingresa una cantidad valida (2  digitos - solo numeros).");
		}
		// condición que ejecutará el ciclo mientras la bandera sea falsa
		while (flag == false);
		return letters;
	}

	/**
	 * @param noDeSerie
	 * @param list
	 * @return boolean
	 */
	public static boolean checknoDeSerie(int noDeSerie, ArrayList<Producto> list) {
		boolean check = false;

		// bucle que ejecuta la lista en busca del precio
		for (int x = 0; x < list.size(); x++) {
			if (list.get(x).getNoDeSerie() == noDeSerie) {
				check = true;
			}
		}
		return check;
	}

	/**
	 * @param lineMessage
	 * @return String
	 */
	public static String getDiscount(String lineMessage) {
		boolean flag = true;
		String letters = "";
		// bucle que ejecutará el programa para verificar el descuento y tratar
		// las excepciones si
		// hay algun error
		do {
			flag = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
				if (letters.length() != 2) {
					flag = false;
				}
				for (int l = 0; l < letters.length(); l++) {
					Integer.parseInt(String.valueOf(letters.charAt(l)));
				}
			} catch (IOException e) {
			} catch (NumberFormatException nfe) {
				flag = false;
			}
			// condición que muestra un mensaje en caso de que la entrada del usuario esté
			// en el formato incorrecto
			if (flag == false)
				System.out.println("Numero invalido! Ingresa un descuento valido (2 digitos - solo numeros).");
		}
		// condición que ejecutará el ciclo mientras la bandera sea falsa
		while (flag == false);
		return letters;
	}

	/**
	 * @param lineMessage
	 * @return String
	 */
	// Método que verifica el precio
	public static String getPrice(String lineMessage) {
		boolean flag = true;
		String letters = "";
		// bucle que ejecutará el programa para verificar el número de teléfono y tratar
		// las excepciones si
		// hay algun error
		do {
			flag = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
				if (letters.length() < 1) {
					flag = false;
				}
				for (int l = 0; l < letters.length(); l++) {
					Integer.parseInt(String.valueOf(letters.charAt(l)));
				}
			} catch (IOException e) {
			} catch (NumberFormatException nfe) {
				flag = false;
			}
			// condición que muestra un mensaje en caso de que la entrada del usuario esté
			// en el formato incorrecto
			if (flag == false)
				System.out.println("Numero invalido! Ingresa una cantidad");
		}
		// condición que ejecutará el ciclo mientras la bandera sea falsa
		while (flag == false);
		return letters;

	}
}