import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Exercício 2 | O Sistema de Impressão
 *
 * Objetivo: Implementar uma Fila (FIFO) para gerenciar um spooler de impressora.
 * Requisitos:
 *  - Cada novo documento é enfileirado.
 *  - O documento impresso deve ser sempre o mais antigo aguardando na fila.
 */
public class SistemaImpressao {

    public record Documento(String nome) {
    }

    // Deque usado como Fila: addLast (enfileirar) / removeFirst (imprimir o mais antigo)
    private final Deque<Documento> filaImpressao = new ArrayDeque<>();

    /** Adiciona um novo documento ao final da fila. */
    public void enfileirarDocumento(String nome) {
        Documento doc = new Documento(nome);
        filaImpressao.addLast(doc);
        System.out.println("[enfileirado] " + nome + " (fila: " + filaImpressao.size() + ")");
    }

    /** Remove e "imprime" o documento mais antigo da fila. */
    public Documento imprimirProximo() {
        Documento proximo = filaImpressao.pollFirst();
        if (proximo == null) {
            System.out.println("[imprimir] Fila vazia, nada a imprimir.");
            return null;
        }
        System.out.println("[imprimindo] " + proximo.nome());
        return proximo;
    }

    public boolean haDocumentosPendentes() {
        return !filaImpressao.isEmpty();
    }

    public static void main(String[] args) {
        SistemaImpressao spooler = new SistemaImpressao();

        spooler.enfileirarDocumento("Relatorio_Vendas.pdf");
        spooler.enfileirarDocumento("Contrato_Cliente.docx");
        spooler.enfileirarDocumento("Boletos_Setembro.pdf");

        System.out.println();
        while (spooler.haDocumentosPendentes()) {
            spooler.imprimirProximo();
        }
        spooler.imprimirProximo(); // fila vazia
    }
}
