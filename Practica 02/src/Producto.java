
/**
 * Clase que representa un producto.
 * 
 * @author JAVATAR
 * @version 13/10/2021
 */
public class Producto {
    private String nombre;
    private int precio;
    private String stock;
    private String descripcion;
    private String descuento;

    // Constructor del producto
    public Producto(String nombre, int precio, String stock, String descripcion, String descuento) {
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.descuento = descuento;
    }

    // Metodos get y set del producto

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    /**
     * Metodo ToString de Operador
     * 
     * @return
     */
    @Override
    public String toString() {
        String s = "Precio " + this.precio + "\n" + "Disponibles: " + this.stock + "\n" + "Descripcion: "
                + this.descripcion + "\n" + "Nombre archivo img: " + this.nombre + "\n" + "Descuento: " + this.descuento
                + "%";
        return s;
    }

}
