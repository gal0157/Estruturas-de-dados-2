/**
 * Exercício 3 — Depuração
 *
 * O código original (comentado abaixo) entra em loop infinito porque a
 * variável `atual` nunca é atualizada dentro do laço — ela sempre aponta
 * para o mesmo nó (n1), então a condição `atual != null` nunca se torna falsa.
 *
 *   Node atual = n1;
 *   while (atual != null) {
 *       System.out.println(atual.valor);
 *       // faltou: atual = atual.proximo;
 *   }
 *
 * Correção: reatribuir `atual` para `atual.proximo` a cada iteração,
 * avançando a referência até chegar a null.
 */
public class DepuracaoDemo {

    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);

        n1.proximo = n2;
        n2.proximo = n3;

        Node atual = n1;

        while (atual != null) {
            System.out.println(atual.valor);
            atual = atual.proximo; // linha que faltava no código com bug
        }
    }
}
