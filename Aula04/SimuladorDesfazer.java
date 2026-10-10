import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Exercício 1 | O Simulador "Desfazer"
 *
 * Objetivo: Implementar uma Pilha (LIFO) para gerenciar ações em um editor de texto.
 * Requisitos:
 *  - Armazenar cada ação (digitar, apagar, substituir).
 *  - Ao acionar "desfazer", remover e reverter estritamente o último comando inserido.
 */
public class SimuladorDesfazer {

    public enum TipoAcao {
        DIGITAR, APAGAR, SUBSTITUIR
    }

    public record Acao(TipoAcao tipo, String detalhe) {
        @Override
        public String toString() {
            return tipo + " -> \"" + detalhe + "\"";
        }
    }

    // Deque usado como Pilha: addLast/removeLast (equivalente a push/pop)
    private final Deque<Acao> pilhaAcoes = new ArrayDeque<>();

    /** Registra uma nova ação no topo da pilha (push). */
    public void executarAcao(TipoAcao tipo, String detalhe) {
        Acao acao = new Acao(tipo, detalhe);
        pilhaAcoes.push(acao);
        System.out.println("[executado] " + acao);
    }

    /** Remove e retorna a última ação executada (pop). Retorna null se não houver nada a desfazer. */
    public Acao desfazer() {
        if (pilhaAcoes.isEmpty()) {
            System.out.println("[desfazer] Nada para desfazer.");
            return null;
        }
        Acao desfeita = pilhaAcoes.pop();
        System.out.println("[desfazer] Revertido: " + desfeita);
        return desfeita;
    }

    public boolean temHistorico() {
        return !pilhaAcoes.isEmpty();
    }

    public static void main(String[] args) {
        SimuladorDesfazer editor = new SimuladorDesfazer();

        editor.executarAcao(TipoAcao.DIGITAR, "Olá mundo");
        editor.executarAcao(TipoAcao.APAGAR, "mundo");
        editor.executarAcao(TipoAcao.SUBSTITUIR, "Java 21");

        System.out.println();
        editor.desfazer(); // reverte SUBSTITUIR
        editor.desfazer(); // reverte APAGAR
        editor.desfazer(); // reverte DIGITAR
        editor.desfazer(); // pilha vazia
    }
}
