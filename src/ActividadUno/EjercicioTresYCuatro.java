package ActividadUno;

import entidades.Cliente;
import entidades.Turno;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EjercicioTresYCuatro {

    /**
     * Tercer Ejercicio.
     * Juan ha querido implementar un digiturno en su supermercado. Para ello, 
     * diseñe y codifique un programa aplicando el concepto FIFO, que reciba el 
     * nombre del cliente, agregue cada cliente a la cola de atención, elimine
     * los clientes de la cola una vez son atendidos, obtenga el cliente al 
     * inicio de la cola, compruebe si está llena la cola y compruebe si está 
     * vacía la cola. Por ejemplo: Establecemos una cola de 4 clientes, 
     * después procedemos a ingresar los clientes {Carmen, Julián, Fabian, 
     * Carlos e Hilda}. Se espera como resultado, que, al ingresar a Hilda, el 
     * sistema informe que la cola está llena y, posteriormente, al atender los 
     * elementos de la cola, que se atienda primero a Carmen, luego a Julián, 
     * luego a Fabian, luego a Carlos y, por último, que informe que la cola 
     * está vacía
     */

    /**
     * Cuarto Ejercicio.
     * Pensando en optimizar el negocio de Juan, diseñe y codifique un programa, 
     * aplicando el concepto de listas enlazadas.
     */
    
    public static void main(String[] args) {
        // Crear una instancia de la clase Turno para gestionar la cola de clientes
        Turno turno = new Turno();
        String opcion;
        short opcionesDeNavegacion;

        try {
            // Ciclo principal del menú de opciones
            do {
                do{
                    opcionesDeNavegacion = Short.parseShort(JOptionPane.showInputDialog("""
                                                                                  1. Crear nuevo turno
                                                                                  2. Consultar cola
                                                                                  3. Consultar el primer cliente
                                                                                  4. Marcar como 'atendido'
                                                                                  0. Salir
                                                                                  Ingrese su opción: """));
                }while(opcionesDeNavegacion < 0 || opcionesDeNavegacion > 4);              
                switch (opcionesDeNavegacion) {
                    case 1:
                        // Opción para agregar nuevos clientes a la cola
                        do {
                            String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente:", "Nombre", JOptionPane.QUESTION_MESSAGE);
                            if (nombre == null || nombre.trim().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                Cliente cliente = new Cliente(nombre);
                                turno.agregarCliente(cliente);
                                System.out.println("Lista de turnos actualizada: ");
                                System.out.println(turno.getListaDeClientes());
                            }

                            opcion = JOptionPane.showInputDialog("""
                                                                 (ENTER) Otro turno.
                                                                 (CUALQUIER TECLA + ENTER) Salir """);
                        } while (opcion != null && opcion.equals(""));
                        break;
                    case 2:
                        // Opción para consultar la lista de clientes en cola
                        System.out.println("Lista de las personas en cola: ");
                        System.out.println(turno.getListaDeClientes());
                        break;
                    case 3:
                        // Opción para consultar el primer cliente en cola
                        Cliente primerCliente = turno.consultarPrimerCliente();
                        if (primerCliente != null) {
                            System.out.println("El primer cliente en cola es: ");
                            System.out.println(primerCliente.toString2());
                        } else {
                            System.out.println("No hay clientes en la cola.");
                        }
                        break;
                    case 4:
                        // Opción para marcar como atendido al primer cliente en cola
                        turno.marcarComoAtendido();
                        System.out.println("El primer cliente ha sido atendido y removido de la cola.");
                        System.out.println("Lista de turnos actualizada: ");
                        System.out.println(turno.getListaDeClientes());
                        break;
                    case 0:
                        // Opción para salir del programa
                        System.out.println("Saliendo del programa.");
                        break;
                    default:
                        // Manejo de opción no válida
                        JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } while (opcionesDeNavegacion != 0);

            // Mostrar la lista de clientes en cola al finalizar el programa
            System.out.println("Lista de las personas en cola: ");
            System.out.println(turno.getListaDeClientes());
        } catch (Exception e) {
            // Manejo de excepciones y mensajes de error
            System.out.println("Se ha generado un error: " + e.getMessage());
            System.out.println("Se ha generado un error: " + e.getCause());
        }
    }
}
