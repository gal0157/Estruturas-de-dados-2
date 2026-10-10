public class Main {

    public static void main(String[] args) {
        System.out.println("=== Exemplo de utilização (item 22) ===");
        FilaAtendimento fila = new FilaAtendimento();

        fila.adicionar(new Paciente("Ana", 32, "Normal"));
        fila.adicionar(new Paciente("Bruno", 70, "Prioridade"));
        fila.adicionar(new Paciente("Carlos", 45, "Normal"));

        fila.listar();

        Paciente atendido = fila.atender();
        System.out.println("Atendendo: " + atendido.nome());

        System.out.println();
        System.out.println("Fila vazia? " + fila.esta_vazia());
        System.out.println("Tamanho atual: " + fila.tamanho());

        System.out.println();
        System.out.println("=== Desafio — Atendimento prioritário (item 23) ===");
        FilaAtendimento fila2 = new FilaAtendimento();

        fila2.adicionar(new Paciente("Ana", 32, "Normal"));
        fila2.adicionar(new Paciente("Bruno", 40, "Normal"));
        fila2.adicionar(new Paciente("Carlos", 60, "Prioridade"));

        System.out.println("Fila após inserções (ordem esperada: Carlos, Ana, Bruno):");
        fila2.listar();

        System.out.println();
        System.out.println("Ordem de atendimento:");
        int ordem = 1;
        while (!fila2.esta_vazia()) {
            Paciente p = fila2.atender();
            System.out.println(ordem + ". " + p.nome());
            ordem++;
        }
    }
}
