import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Exercícios de Fixação | 02 - O Call Center
 *
 * Missão: Criar uma fila (FIFO) que armazene nomes de clientes. Simular um
 * ciclo contínuo de atendimento: adicionar novos clientes à espera e
 * "chamar" o próximo cliente da fila para atendimento.
 */
public class CallCenter {

    private final Queue<String> filaClientes = new ArrayDeque<>();

    /** Adiciona um novo cliente ao final da fila de espera. */
    public void adicionarCliente(String nome) {
        filaClientes.offer(nome);
        System.out.println("[fila] " + nome + " entrou na fila de espera.");
    }

    /** Remove e retorna o próximo cliente a ser atendido. */
    public String chamarProximo() {
        String cliente = filaClientes.poll();
        if (cliente == null) {
            System.out.println("[atendimento] Nenhum cliente aguardando.");
            return null;
        }
        System.out.println("[atendimento] Chamando: " + cliente);
        return cliente;
    }

    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter();

        // Ciclo contínuo simulado: chegadas e atendimentos intercalados
        callCenter.adicionarCliente("Ana");
        callCenter.adicionarCliente("Bruno");
        callCenter.chamarProximo(); // atende Ana

        callCenter.adicionarCliente("Carla");
        callCenter.chamarProximo(); // atende Bruno
        callCenter.chamarProximo(); // atende Carla

        callCenter.chamarProximo(); // fila vazia
    }
}
