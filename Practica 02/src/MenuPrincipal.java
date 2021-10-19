import java.util.Scanner;

public class MenuPrincipal {

  /**
   * @param args
   */
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    boolean salir = false;
    int opcion; // Guardaremos la opcion del usuario

    while (!salir) {
      System.out.println("::::    ::: ::::::::::: :::    ::: :::    ::: ::::::::::: ");
      System.out.println(":+:+:   :+:     :+:     :+:    :+: :+:    :+:     :+:     ");
      System.out.println(":+:+:+  +:+     +:+      +:+  +:+  +:+    +:+     +:+     ");
      System.out.println("+#+ +:+ +#+     +#+       +#++:+   +#+    +:+     +#+     ");
      System.out.println("+#+  +#+#+#     +#+      +#+  +#+  +#+    +#+     +#+     ");
      System.out.println("#+#   #+#+#     #+#     #+#    #+# #+#    #+#     #+#     ");
      System.out.println("###    #### ########### ###    ###  ########      ###     ");
      System.out.println(" .oPYo.  o                                   o      8        ");
      System.out.println(" 8   `8                                             8        ");
      System.out.println("o8YooP' o8 .oPYo. odYo. o    o .oPYo. odYo. o8 .oPYo8 .oPYo. ");
      System.out.println(" 8   `b  8 8oooo8 8' `8 Y.  .P 8oooo8 8' `8  8 8    8 8    8 ");
      System.out.println(" 8    8  8 8.     8   8 `b..d' 8.     8   8  8 8    8 8    8 ");
      System.out.println(" 8oooP'  8 `Yooo' 8   8  `YP'  `Yooo' 8   8  8 `YooP' `YooP' ");
      System.out.println(":......::..:.....:..::..::...:::.....:..::..:..:.....::.....:");
      System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
      System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

      System.out.println("\n" + "\n");
      System.out.println("          Elije el numero de la opcion que se adapte a tus necesidades    ");
      System.out.println("\n");
      System.out.println("          1  -- GESTIONAR CLIENTES");
      System.out.println("          2  -- GESTIONAR PRODUCTOS");
      System.out.println("          3  -- GESTIONAR CATEGORIAS");
      System.out.println("          4  -- GESTIONAR PROVEEDORES");
      System.out.println("\n");
      System.out.println("          OPRIME 5 PARA SALIR");

      System.out.println("Escribe una de las opciones");
      opcion = sc.nextInt();

      switch (opcion) {
        case 1:
          System.out.println("Has seleccionado la opcion 1 Gestion de Clientes");
          ClientesMain ClientesMain = new ClientesMain();
          ClientesMain.showMenuClientes();
          break;
        case 2:
          System.out.println("Has seleccionado la opcion 2 Gestion de Productos");
          ProductosMain ProductosMain = new ProductosMain();
          ProductosMain.showMenu();
          break;
        case 3:
          System.out.println("Has seleccionado la opcion 3 Gestion de Categorias");
          CategoriasMain CategoriasMain = new CategoriasMain();
          CategoriasMain.showMenu();
          break;
        case 4:
          System.out.println("Has seleccionado la opcion 3 Gestion de Proovedores");
          ProveedoresMain ProveedoresMain = new ProveedoresMain();
          ProveedoresMain.showMenu();
          break;
        case 5:
          salir = true;
          break;
        default:
          System.out.println("Solo números entre 1 y 5");
      }

    }

  }

}