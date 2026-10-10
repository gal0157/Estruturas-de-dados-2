/**
 * Exercícios de Fixação (Trilha C - Baixo Nível, adaptado para Java) | 01 - Pilha via Array Estático
 *
 * Missão: Implementar uma pilha alocando um array de tamanho fixo.
 * Desenvolver push() e pop(), com uma variável de controle manual para
 * rastrear o índice exato do topo (topo).
 *
 * Observação: aqui não usamos Deque/List propositalmente, para reproduzir
 * o controle manual de índices exigido no exercício original em C.
 */
public class PilhaArrayEstatico {

    private final int[] dados;
    private int topo; // índice do elemento no topo; -1 significa pilha vazia

    public PilhaArrayEstatico(int capacidade) {
        this.dados = new int[capacidade];
        this.topo = -1;
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public boolean estaCheia() {
        return topo == dados.length - 1;
    }

    /** Insere um valor no topo da pilha. */
    public void push(int valor) {
        if (estaCheia()) {
            throw new IllegalStateException("Pilha cheia: não é possível empilhar " + valor);
        }
        topo++;
        dados[topo] = valor;
        System.out.println("[push] " + valor + " (topo agora no índice " + topo + ")");
    }

    /** Remove e retorna o valor do topo da pilha. */
    public int pop() {
        if (estaVazia()) {
            throw new IllegalStateException("Pilha vazia: não é possível desempilhar.");
        }
        int valor = dados[topo];
        topo--;
        System.out.println("[pop] " + valor + " (topo agora no índice " + topo + ")");
        return valor;
    }

    public static void main(String[] args) {
        PilhaArrayEstatico pilha = new PilhaArrayEstatico(5);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.println();
        pilha.pop();
        pilha.pop();

        System.out.println();
        pilha.push(99);
        pilha.push(100);
        pilha.push(101);
        pilha.push(102);

        try {
            pilha.push(999); // deve estourar (pilha cheia, capacidade 5)
        } catch (IllegalStateException e) {
            System.out.println("[erro] " + e.getMessage());
        }
    }
}
