package ActividadUno;


import javax.swing.JOptionPane;



public class EjercicioDos {
    
    /**
     * Diseñe y codifique un programa, aplicando el concepto LIFO, que le 
     * permita recibir una cadena de caracteres e invierta el orden de ingreso 
     * de estos. Por ejemplo: Se ingresa la cadena “solucionando un problema” 
     * y debe retornar “amelborp unodnanoiculos”.
     */
    public static void main(String[] args) {
        // Declaración de variable para almacenar la cadena de texto ingresada
        String cadenaDeTexto;
        
        // Ciclo do-while para asegurarse de recibir una cadena de texto válida
        do {
            try {
                // Solicitar al usuario que ingrese una cadena de texto
                cadenaDeTexto = JOptionPane.showInputDialog(null, "Ingrese la cadena de texto:", "Entrada de texto", JOptionPane.QUESTION_MESSAGE);
                
                // Verificar si la cadena de texto es nula o vacía
                if (cadenaDeTexto == null || cadenaDeTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese una cadena de texto válida", "Aviso", JOptionPane.WARNING_MESSAGE);
                    continue;
                }
                
                // Invertir la cadena de texto usando StringBuilder
                cadenaDeTexto = new StringBuilder(cadenaDeTexto).reverse().toString();
                
                // Mostrar la cadena de texto invertida al usuario
                JOptionPane.showMessageDialog(null, cadenaDeTexto, "Cadena de texto al revés", JOptionPane.INFORMATION_MESSAGE);
                
                // Salir del ciclo
                break;
                
            } catch (Exception e) {
                // Manejar excepciones y mostrar mensajes de error
                System.out.println("Se ha generado un error: " + e.getMessage());
                
                if (e instanceof NullPointerException) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese una cadena de texto válida", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } while (true); // Continuar en el ciclo hasta recibir una cadena válida
    }
}
