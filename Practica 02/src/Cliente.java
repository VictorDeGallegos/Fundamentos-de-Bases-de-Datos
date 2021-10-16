
/**
 * Clase que representa un cliente de Nixut.
 * 
 * @author JAVATAR
 * @version 13/10/2021
 */

public class Cliente {
    private String nombre;
    private String apellidos;
    private String curp;
    private String direccion;
    private String fecha_de_nacimiento;
    private int edad;
    private String email;
    private String password;
    private String metodo_de_pago;
    private int puntos_de_promociones;

    // Contructor de nuestro objeto cliente...
    public Cliente(String nombre, String apellidos, String curp, String direccion, String fecha_de_nacimiento, int edad,
            String email, String password, String metodo_de_pago, int puntos_de_promociones) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curp = curp;
        this.direccion = direccion;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.edad = edad;
        this.email = email;
        this.password = password;
        this.metodo_de_pago = metodo_de_pago;
        this.puntos_de_promociones = puntos_de_promociones;
    }

    // gets y sets de nuestros atributos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellido(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechadeNacimiento() {
        return fecha_de_nacimiento;
    }

    public void setFechadeNacimiento(String fecha_de_nacimiento) {
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMetododePago() {
        return metodo_de_pago;
    }

    public void setMetododePago(String metodo_de_pago) {
        this.metodo_de_pago = metodo_de_pago;
    }

    public int getPuntosdePromociones() {
        return puntos_de_promociones;
    }

    public void setPuntosdePromociones(int puntos_de_promociones) {
        this.puntos_de_promociones = puntos_de_promociones;
    }

    /**
     * Metodo ToString de Operador
     * 
     * @return
     */
    @Override
    public String toString() {
        return this.nombre + "," + this.apellidos + "," + this.curp + "," + this.direccion + ","
                + this.fecha_de_nacimiento + "," + this.edad + "," + this.email + "," + this.password + ","
                + this.metodo_de_pago + "," + this.puntos_de_promociones;
    }

}
