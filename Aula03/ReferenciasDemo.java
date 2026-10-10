import java.util.ArrayList;
import java.util.List;

/**
 * Exercício 1 — Referências
 *
 * Em Java, assim como em Python, variáveis do tipo objeto (aqui, List<Integer>)
 * armazenam uma REFERÊNCIA para o objeto, não o objeto em si.
 * O equivalente Java para id() é System.identityHashCode(obj), que identifica
 * a identidade do objeto na memória (não confundir com o hashCode() lógico).
 */
public class ReferenciasDemo {

    public static void main(String[] args) {
        System.out.println("=== Parte 1: b = a (mesma referência) ===");
        List<Integer> a = new ArrayList<>(List.of(10, 20, 30));
        List<Integer> b = a;

        b.add(40);

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("identityHashCode(a): " + System.identityHashCode(a));
        System.out.println("identityHashCode(b): " + System.identityHashCode(b));
        System.out.println("a == b ? " + (a == b));

        System.out.println();
        System.out.println("=== Parte 2: b = cópia de a (new ArrayList<>(a)) ===");
        List<Integer> a2 = new ArrayList<>(List.of(10, 20, 30));
        List<Integer> b2 = new ArrayList<>(a2); // equivalente a a.copy() do Python

        b2.add(40);

        System.out.println("a2: " + a2);
        System.out.println("b2: " + b2);
        System.out.println("identityHashCode(a2): " + System.identityHashCode(a2));
        System.out.println("identityHashCode(b2): " + System.identityHashCode(b2));
        System.out.println("a2 == b2 ? " + (a2 == b2));
    }
}
