/**
 * Exercícios de Fixação (Trilha C - Baixo Nível, adaptado para Java) | 02 - Fila Circular
 *
 * Missão: Otimizar o uso de memória implementando uma fila sobre um array
 * circular. Desenvolver enqueue() e dequeue(), controlando independentemente
 * os ponteiros de início (front) e fim (rear).
 *
 * Observação: implementação com array puro e índices circulares, sem usar
 * Deque/Queue prontos, para reproduzir o exercício original em C.
 */
public class FilaCircular {

    private final int[] dados;
    private final int capacidade;
    private int front; // índice do primeiro elemento
    private int rear;  // índice da próxima posição livre para inserção
    private int tamanhoAtual;

    public FilaCircular(int capacidade) {
        this.capacidade = capacidade;
        this.dados = new int[capacidade];
        this.front = 0;
        this.rear = 0;
        this.tamanhoAtual = 0;
    }

    public boolean estaVazia() {
        return tamanhoAtual == 0;
    }

    public boolean estaCheia() {
        return tamanhoAtual == capacidade;
    }

    /** Insere um valor no final da fila (rear), avançando circularmente. */
    public void enqueue(int valor) {
        if (estaCheia()) {
            throw new IllegalStateException("Fila cheia: não é possível enfileirar " + valor);
        }
        dados[rear] = valor;
        rear = (rear + 1) % capacidade;
        tamanhoAtual++;
        System.out.println("[enqueue] " + valor + " (front=" + front + ", rear=" + rear + ")");
    }

    /** Remove e retorna o valor do início da fila (front), avançando circularmente. */
    public int dequeue() {
        if (estaVazia()) {
            throw new IllegalStateException("Fila vazia: não é possível desenfileirar.");
        }
        int valor = dados[front];
        front = (front + 1) % capacidade;
        tamanhoAtual--;
        System.out.println("[dequeue] " + valor + " (front=" + front + ", rear=" + rear + ")");
        return valor;
    }

    public static void main(String[] args) {
        FilaCircular fila = new FilaCircular(4);

        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);
        fila.enqueue(4);

        System.out.println();
        fila.dequeue(); // remove 1
        fila.dequeue(); // remove 2

        System.out.println();
        // Reaproveita o espaço liberado no início do array (comportamento circular)
        fila.enqueue(5);
        fila.enqueue(6);

        System.out.println();
        while (!fila.estaVazia()) {
            fila.dequeue();
        }

        try {
            fila.dequeue(); // fila vazia
        } catch (IllegalStateException e) {
            System.out.println("[erro] " + e.getMessage());
        }
    }
}
