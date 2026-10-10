import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Desafio Master | Triagem Hospitalar
 *
 * Cenário: Gerenciamento de uma fila de atendimento médico.
 * Regras de negócio:
 *  - Fluxo Padrão: pacientes normais entram no final da fila.
 *  - Fluxo de Exceção: pacientes prioritários (idosos, emergências) furam a fila
 *    e entram diretamente no início do atendimento.
 *
 * Dica de arquitetura seguida: Deque (fila de duas pontas) permite inserção
 * na esquerda (prioridade) sem reescrever a fila inteira.
 */
public class TriagemHospitalar {

    public record Paciente(String nome, boolean prioritario) {
        @Override
        public String toString() {
            return nome + (prioritario ? " [PRIORIDADE]" : "");
        }
    }

    private final Deque<Paciente> filaAtendimento = new ArrayDeque<>();

    /** Adiciona um paciente: prioritários vão para o início, normais para o final. */
    public void chegarPaciente(String nome, boolean prioritario) {
        Paciente paciente = new Paciente(nome, prioritario);
        if (prioritario) {
            filaAtendimento.addFirst(paciente);
        } else {
            filaAtendimento.addLast(paciente);
        }
        System.out.println("[chegou] " + paciente);
    }

    /** Chama o próximo paciente a ser atendido (início da fila). */
    public Paciente chamarProximo() {
        Paciente proximo = filaAtendimento.pollFirst();
        if (proximo == null) {
            System.out.println("[atendimento] Nenhum paciente na fila.");
            return null;
        }
        System.out.println("[atendendo] " + proximo);
        return proximo;
    }

    public void mostrarFila() {
        System.out.println("Fila atual: " + filaAtendimento);
    }

    public static void main(String[] args) {
        TriagemHospitalar triagem = new TriagemHospitalar();

        triagem.chegarPaciente("João", false);
        triagem.chegarPaciente("Maria", false);
        triagem.chegarPaciente("Sr. Antônio (idoso)", true);
        triagem.chegarPaciente("Carlos", false);
        triagem.chegarPaciente("Emergência - Ana", true);

        System.out.println();
        triagem.mostrarFila();

        System.out.println();
        while (!triagem.filaAtendimento.isEmpty()) {
            triagem.chamarProximo();
        }
    }
}
