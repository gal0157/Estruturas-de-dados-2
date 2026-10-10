/**
 * Nó genérico de uma lista encadeada simples.
 * O campo `proximo` é uma REFERÊNCIA para outro nó (ou null).
 */
public class Node<T> {

    T valor;
    Node<T> proximo;

    public Node(T valor) {
        this.valor = valor;
        this.proximo = null;
    }
}
