package entidades;

import java.util.LinkedList;

public class Turno {
    private LinkedList<Cliente> listaDeClientes;

    public Turno() {
        listaDeClientes = new LinkedList<>();
    }
    
    
    public void agregarCliente(Cliente cliente) {
        listaDeClientes.add(cliente);
    }

    public String getListaDeClientes() {
        int numeroDeTurnos = 0;
        StringBuilder listaDeClientesConTurnos = new StringBuilder();
        if (listaDeClientes.isEmpty()) {
            return null;
        }else{
            for (Cliente c : listaDeClientes) {
                numeroDeTurnos++;
                listaDeClientesConTurnos.append("Turno N° ").append(numeroDeTurnos).append(". ").append(c.toString2()).append("\n");         
            }
        return listaDeClientesConTurnos.toString();
        }     
    }

    public Cliente consultarPrimerCliente() {
        if (listaDeClientes.isEmpty()) {
            return null;
        }
        return listaDeClientes.getFirst();
    }

    public void marcarComoAtendido() {
        if (!listaDeClientes.isEmpty()) {
            listaDeClientes.removeFirst();
        }
    }
}
