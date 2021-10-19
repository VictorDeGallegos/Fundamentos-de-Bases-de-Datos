/*
 * @author JAVATAR
 *
 * Clase que contiene los datos de los CLientes junto con sus getters y setters
 */
// Clase proveedores

public class Proveedores {

  // Datos de los proovedores

  // Declaracion de variables
  private int id;
  private String rfc;
  private String direccion;
  private String razonSocial;
  private String telefono;

  public Proveedores(int id, String rfc, String razonSocial, String direccion, String telefono) {
    this.rfc = rfc;
    this.direccion = direccion;
    this.razonSocial = razonSocial;
    this.telefono = telefono;
    this.id = id;
  }

  // setters y getters
  public void setRfc(String rfc) {
    this.rfc = rfc;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public void setRazonSocial(String razonSocial) {
    this.razonSocial = razonSocial;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getRfc() {
    return this.rfc;
  }

  public String getDireccion() {
    return this.direccion;
  }

  public String getRazonSocial() {
    return this.razonSocial;
  }

  public String getTelefono() {
    return this.telefono;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return this.id;
  }

  // clase toString
  public String toString() {

    String m = "ID: " + this.id + "\n" + "Razon Social: " + this.razonSocial + "\n" + "RFC: " + this.rfc + "\n"
        + "Direccion: " + this.direccion + "\n" + " Multiples telefonos de contacto: " + this.telefono + "\n";
    return m;
  }

}