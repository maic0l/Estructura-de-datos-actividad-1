package entidades;

public class Cliente {
    private String nombre;
    private short edad;
    private int numeroDeId;
    private long numeroDeCel;
    private String correo;
    private String direccion;

    public Cliente(String nombre, short edad, int numeroDeId, long numeroDeCel, String correo, String direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.numeroDeId = numeroDeId;
        this.numeroDeCel = numeroDeCel;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public Cliente() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public int getNumeroDeId() {
        return numeroDeId;
    }

    public void setNumeroDeId(int numeroDeId) {
        this.numeroDeId = numeroDeId;
    }

    public long getNumeroDeCel() {
        return numeroDeCel;
    }

    public void setNumeroDeCel(long numeroDeCel) {
        this.numeroDeCel = numeroDeCel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
      public boolean confirmarMayoriaDeEdad() {
        return this.edad >= 18;
    }
    
    public String saludarAlCliente(String nombre) {
        return "bienvenido: " + nombre;
    }

    public String calcularValorDeEdad(int edad){        
        if (edad >= 18){
            return "El usuario es mayor de edad: " + edad + " años";
        }else{
            return "El usuario es menor de edad: " + edad + " años";
        }

    }
    
    public boolean validarCorreo(String correo) {
        return correo.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }
    
    public double calcularDescuento(short edad, String correo) {
        if (edad > 60) {
            if(correo.contains("uniminuto.edu.co")){
                return 100;
            }
            return 20; 
        } else {
            if(correo.contains("uniminuto.edu.co")){
                return 100;
            }
            return 10;
        }
    }
    
    public String mostrarContacto(long numeroDeCel, String correo) {
        return "Telefono: " + numeroDeCel + ", " + "Correo: " + correo;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre +
                ", Edad: " + this.edad +
                ", Número de ID: " + this.numeroDeId +
                ", Número de Celular: " + this.numeroDeCel +
                ", Correo: " + this.correo +
                ", Dirección: " + this.direccion;
    }

    public String toString2() {
        return "nombre: " + this.nombre +
                ", numeroDeId: " + this.numeroDeId;
    }
}
