/**
 * Representa um paciente da clínica.
 * Usamos um record (Java 16+, mantido em Java 25) por ser um objeto de dados
 * imutável — nome, idade e prioridade não mudam depois de criado o paciente.
 */
public record Paciente(String nome, int idade, String prioridade) {

    public boolean ehPrioritario() {
        return "Prioridade".equalsIgnoreCase(prioridade);
    }

    @Override
    public String toString() {
        return nome + " — " + idade + " anos — " + prioridade;
    }
}
