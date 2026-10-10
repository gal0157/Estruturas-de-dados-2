/**
 * Fila de atendimento da clínica, implementada como lista encadeada simples
 * com referências para início e fim.
 *
 * Desafio (item 23): pacientes com prioridade devem ser atendidos antes dos
 * pacientes normais. A estratégia escolhida foi inserir o novo nó logo após
 * o último nó prioritário já presente na fila (ou no início, se não houver
 * nenhum prioritário ainda) quando o paciente é prioritário; pacientes
 * normais continuam sendo inseridos no fim, como em uma fila comum.
 * Isso preserva a ordem de chegada dentro de cada grupo (prioritários entre
 * si, normais entre si) — só a prioridade entre grupos muda a posição.
 */
public class FilaAtendimento {

    private Node inicio;
    private Node fim;
    private int tamanho;

    public void adicionar(Paciente paciente) {
        Node novo = new Node(paciente);

        if (esta_vazia()) {
            inicio = novo;
            fim = novo;
            tamanho++;
            return;
        }

        if (paciente.ehPrioritario()) {
            // Encontra o último nó prioritário consecutivo a partir do início.
            Node atual = inicio;
            Node ultimoPrioritario = null;

            while (atual != null && atual.paciente.ehPrioritario()) {
                ultimoPrioritario = atual;
                atual = atual.proximo;
            }

            if (ultimoPrioritario == null) {
                // Nenhum prioritário ainda: novo nó vira o início da fila.
                novo.proximo = inicio;
                inicio = novo;
            } else {
                // Insere logo depois do último prioritário.
                novo.proximo = ultimoPrioritario.proximo;
                ultimoPrioritario.proximo = novo;
                if (novo.proximo == null) {
                    fim = novo;
                }
            }
        } else {
            // Paciente normal: vai para o fim da fila, como em uma fila comum.
            fim.proximo = novo;
            fim = novo;
        }

        tamanho++;
    }

    public Paciente atender() {
        if (esta_vazia()) {
            throw new IllegalStateException("Não há pacientes na fila.");
        }

        Paciente paciente = inicio.paciente;
        inicio = inicio.proximo;

        if (inicio == null) {
            fim = null;
        }

        tamanho--;
        return paciente;
    }

    public void listar() {
        if (esta_vazia()) {
            System.out.println("Fila vazia.");
            return;
        }

        Node atual = inicio;
        int posicao = 1;

        while (atual != null) {
            System.out.println(posicao + ". " + atual.paciente);
            atual = atual.proximo;
            posicao++;
        }
    }

    public boolean esta_vazia() {
        return inicio == null;
    }

    public int tamanho() {
        return tamanho;
    }
}
