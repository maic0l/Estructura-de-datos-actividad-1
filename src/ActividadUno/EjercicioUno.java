package ActividadUno;

import javax.swing.JOptionPane;
import entidades.Cliente;

public class EjercicioUno {

    /**
     * Cree una clase para representar el perfil de un cliente, identificando lo siguiente:
     * a. Nombre.
     * b. Atributos (mínimo 5).
     * c. Funciones y métodos (mínimo 5)
     */

    public static void main(String[] args) {

        // Declaración de variables para almacenar los datos del cliente
        String nombre;
        short edad;
        int numeroDeId;
        long numeroDeCel;
        String correo;
        String direccion;

        // Instancia de la clase Cliente
        Cliente cliente;
        cliente = new Cliente();
        boolean verificacionDeDatos = false;

        do {
            try {     
                // Solicita el nombre del cliente
                nombre = JOptionPane.showInputDialog("Nombre del cliente:");
                if (nombre == null) {
                    break;
                }
                // Saludar al cliente (método 1)
                System.out.println(cliente.saludarAlCliente(nombre));

                // Solicita y verifica que la edad sea positiva
                do {
                    edad = Short.parseShort(JOptionPane.showInputDialog("Edad del cliente:"));
                } while (edad < 0);

                // Calcula y muestra el valor de la edad (método 2)
                System.out.println(cliente.calcularValorDeEdad(edad));

                // Solicita el número de identificación y el número de celular del cliente
                numeroDeId = Integer.parseInt(JOptionPane.showInputDialog("Número de identificación del cliente:"));
                numeroDeCel = Long.parseLong(JOptionPane.showInputDialog("Número de celular del cliente:"));  

                // Solicita y verifica que el correo tenga un formato válido
                do {
                    correo = JOptionPane.showInputDialog("Correo del cliente:"); 
                    if (correo == null) {
                        break;
                    }
                    if (!cliente.validarCorreo(correo)) {
                        System.out.println("Por favor ingrese un formato correcto");
                    }                    
                } while (!cliente.validarCorreo(correo)); // Validar correo (método 3)
                if (correo == null) {
                    break;
                }
                // Muestra el contacto del cliente (método 4)
                System.out.println("Contacto del cliente: " + cliente.mostrarContacto(numeroDeCel, correo));
                // Calcula y muestra el descuento (método 5)
                System.out.println("Aplica a descuento del: " + cliente.calcularDescuento(edad, correo) + "%");

                // Solicita la dirección del cliente
                direccion = JOptionPane.showInputDialog("Dirección del cliente:");
                if (direccion == null) {
                    break;
                }

                // Crea una nueva instancia de Cliente con los datos ingresados
                cliente = new Cliente(nombre, edad, numeroDeId, numeroDeCel, correo, direccion);

                // Muestra la información del cliente
                System.out.println(cliente.toString());

                verificacionDeDatos = true;

            } catch(Exception e) {
                System.out.println("Se ha generado un error: " + e.getMessage()); 
                if (e.getMessage().contains("For input string")) {
                    // Muestra un mensaje de error si hay un problema con el formato de entrada
                    JOptionPane.showMessageDialog(null, "Por favor ingrese correctamente los datos solicitados", "Error", JOptionPane.ERROR_MESSAGE);                
                }                   
                if (e.getMessage().contains("Cannot parse null")) {   
                    // Muestra un mensaje y sale del programa si no se puede analizar una entrada nula
                    System.out.println("Saliendo del programa");
                    break;               
                }
            }         
        } while (!verificacionDeDatos);
    }
}