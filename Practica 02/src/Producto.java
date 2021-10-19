
/**
 * Clase que representa un producto.
 * 
 * @author JAVATAR
 * @version 13/10/2021
 */
public class Producto {

    private int noDeSerie;
    private String nombre;
    private String precio;
    private String stock;
    private String descripcion;
    private String descuento;

    // Constructor del producto
    public Producto(int noDeSerie, String nombre, String precio, String stock, String descripcion, String descuento) {
        this.noDeSerie = noDeSerie;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.descuento = descuento;
    }

    /**
     * @return int
     */
    // Metodos get y set del producto

    public int getNoDeSerie() {
        return noDeSerie;
    }

    /**
     * @param noDeSerie
     */
    public void setNoDeSerie(int noDeSerie) {
        this.noDeSerie = noDeSerie;
    }

    /**
     * @return String
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * @return String
     */
    public String getStock() {
        return stock;
    }

    /**
     * @param stock
     */
    public void setStock(String stock) {
        this.stock = stock;
    }

    /**
     * @return String
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String
     */
    public String getDescuento() {
        return descuento;
    }

    /**
     * @param descuento
     */
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
        String s = "Numero de Serie: " + this.noDeSerie + "\n" + "Nombre del producto: " + this.nombre + "\n"
                + "Precio: " + "$" + this.precio + "\n" + "Descripcion: " + this.descripcion + "\n" + "Descuento: "
                + this.descuento + "%";
        return s;
    }

}
