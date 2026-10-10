public class Node {

    Paciente paciente;
    Node proximo;

    public Node(Paciente paciente) {
        this.paciente = paciente;
        this.proximo = null;
    }
}
