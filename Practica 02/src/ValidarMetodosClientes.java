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
public class ValidarMetodosClientes {
	// Variable Global
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

	// Método que verifica si el correo electrónico es válido, muestra un mensaje de
	// error en caso de el formato sea incorrecto
	public static String getEmail(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que comprobará el formato del correo electrónico
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException e) {
				System.out.println("Error al recibir el email");
			}
			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 65) || ((int) letters.charAt(l) > 90)) && /* A - Z */
						(((int) letters.charAt(l) < 97) || ((int) letters.charAt(l) > 122)) && /* a - z */
						((int) letters.charAt(l) != 46) && /* . */
						((int) letters.charAt(l) != 64)) /* @ */
					check = false;
			}
			if (check == false)
				System.out.println("¡Entrada inválida! ¡Intentar otra vez!");
			else {
				if (!letters.contains("@")) {
					System.out.println("Formato no válido, ingrese correo electrónico valido");
					check = false;
				} else if (!letters.contains(".")) {
					System.out.println("Formato no válido, ingrese correo electrónico valido");
					check = false;
				} else if (letters.indexOf("@") > letters.indexOf(".")) {
					System.out.println("Formato no válido, ingrese correo electrónico valido");
				}
			}
			// El bucle se ejecuta mientras la verificación == falsa
		} while (check == false);
		return letters;
	}

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

	// Método que comprueba si la identificación está en la lista. Si devuelve
	// "verdadero"
	public static boolean checkID(int id, ArrayList<Clientes> list) {
		boolean check = false;

		// bucle que ejecuta la lista en busca de la identificación
		for (int x = 0; x < list.size(); x++) {
			if (list.get(x).getId() == id) {
				check = true;
			}
		}
		return check;
	}

	// Método que verifica el número de teléfono
	public static String getPhone(String lineMessage) {
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
				if (letters.length() != 10) {
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
				System.out.println("Numero invalido! Ingresa un numero de telefono valido (10 digitos - solo numeros).");
		}
		// condición que ejecutará el ciclo mientras la bandera sea falsa
		while (flag == false);
		return letters;
	}

}
