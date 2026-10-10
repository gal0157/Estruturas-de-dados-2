import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Exercícios de Fixação | 01 - A Pilha Matemática
 *
 * Missão: Criar uma pilha (LIFO) que armazene números inteiros. Escrever um
 * algoritmo que esvazie a pilha iterativamente, calculando e retornando a
 * soma total dos elementos removidos.
 */
public class PilhaMatematica {

    private final Deque<Integer> pilha = new ArrayDeque<>();

    /** Insere um valor no topo da pilha. */
    public void empilhar(int valor) {
        pilha.push(valor);
    }

    /** Esvazia a pilha removendo elemento a elemento e retorna a soma total. */
    public int esvaziarESomar() {
        int soma = 0;
        while (!pilha.isEmpty()) {
            int valor = pilha.pop();
            System.out.println("[removido] " + valor);
            soma += valor;
        }
        return soma;
    }

    public static void main(String[] args) {
        PilhaMatematica pilhaMatematica = new PilhaMatematica();

        int[] valores = {10, 25, 7, 3, 50};
        for (int v : valores) {
            pilhaMatematica.empilhar(v);
            System.out.println("[empilhado] " + v);
        }

        System.out.println();
        int total = pilhaMatematica.esvaziarESomar();
        System.out.println("\nSoma total dos elementos removidos: " + total);
    }
}
