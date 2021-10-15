package src;

/**
 * Clase que representa un producto.
 * 
 * @author JAVATAR
 * @version 13/10/2021
 */
public class Producto {
    private int precio;
    private int stock;
    private String descripcion;
    private String nombre;
    private int descuento;

    //Constructor del producto
    public Producto(int precio, int stock, String descripcion, String nombre, int descuento){
        this.precio=precio;
        this.stock=stock;
        this.descripcion=descripcion;
        this.nombre=nombre;
        this.descuento=descuento;
    }

    //Metodos get y set del producto

    public int getPrecio(){
        return precio;
    }

    public void setPrecio(int precio){
        this.precio=precio;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock=stock;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public int getDescuento(){
        return descuento;
    }

    public void setDescuento(int descuento){
        this.descuento=descuento;
    }

     /**
   * Metodo ToString de Operador
   * 
   * @return
   */
  @Override
    public String toString(){
        return this.precio + "," + this.stock + "," + this.descripcion + "," + this.nombre + "," + this.descuento;
    }
    
}


