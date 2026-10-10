/**
 * Exercício 2 — Construindo uma cadeia
 *
 * Cria os nós A, B, C, conecta-os (A -> B -> C -> null) e percorre a estrutura.
 */
public class CadeiaDemo {

    public static void main(String[] args) {
        Node<String> n1 = new Node<>("A");
        Node<String> n2 = new Node<>("B");
        Node<String> n3 = new Node<>("C");

        n1.proximo = n2;
        n2.proximo = n3;
        // n3.proximo já é null por padrão

        Node<String> atual = n1;

        while (atual != null) {
            System.out.println(atual.valor);
            atual = atual.proximo;
        }
    }
}
