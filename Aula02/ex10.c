/*
 * Exercicio 10 - Sistema Integrado
 *
 * Pequeno sistema de cadastro de 10 funcionarios usando
 * uma struct (nome, idade, cargo, salario) e um menu com
 * as opcoes:
 *   1. Cadastrar os funcionarios
 *   2. Listar todos os funcionarios
 *   3. Mostrar o funcionario com maior salario
 *   4. Calcular a media salarial
 *   5. Mostrar os funcionarios com salario acima da media
 *   0. Sair
 */

#include <stdio.h>

#define NUM_FUNC 10
#define TAM_NOME 50
#define TAM_CARGO 30

typedef struct {
    char nome[TAM_NOME];
    int idade;
    char cargo[TAM_CARGO];
    float salario;
} Funcionario;

/* Protótipos */
void cadastrarFuncionarios(Funcionario func[], int n, int *cadastrados);
void listarFuncionarios(const Funcionario func[], int n);
void maiorSalario(const Funcionario func[], int n);
float mediaSalarial(const Funcionario func[], int n);
void acimaDaMedia(const Funcionario func[], int n, float media);
void limparBuffer(void);

int main(void) {
    Funcionario funcionarios[NUM_FUNC];
    int cadastrados = 0;
    int opcao;

    printf("=== Exercicio 10 - Sistema Integrado de Funcionarios ===\n");

    do {
        printf("\n----------------------------------------\n");
        printf("1 - Cadastrar os %d funcionarios\n", NUM_FUNC);
        printf("2 - Listar todos os funcionarios\n");
        printf("3 - Mostrar funcionario com maior salario\n");
        printf("4 - Calcular media salarial\n");
        printf("5 - Mostrar funcionarios acima da media\n");
        printf("0 - Sair\n");
        printf("----------------------------------------\n");
        printf("Escolha uma opcao: ");
        scanf("%d", &opcao);

        switch (opcao) {
            case 1:
                cadastrarFuncionarios(funcionarios, NUM_FUNC, &cadastrados);
                break;

            case 2:
                if (cadastrados < NUM_FUNC) {
                    printf("\nCadastre os %d funcionarios primeiro (opcao 1).\n", NUM_FUNC);
                } else {
                    listarFuncionarios(funcionarios, NUM_FUNC);
                }
                break;

            case 3:
                if (cadastrados < NUM_FUNC) {
                    printf("\nCadastre os %d funcionarios primeiro (opcao 1).\n", NUM_FUNC);
                } else {
                    maiorSalario(funcionarios, NUM_FUNC);
                }
                break;

            case 4:
                if (cadastrados < NUM_FUNC) {
                    printf("\nCadastre os %d funcionarios primeiro (opcao 1).\n", NUM_FUNC);
                } else {
                    float media = mediaSalarial(funcionarios, NUM_FUNC);
                    printf("\nMedia salarial: %.2f\n", media);
                }
                break;

            case 5:
                if (cadastrados < NUM_FUNC) {
                    printf("\nCadastre os %d funcionarios primeiro (opcao 1).\n", NUM_FUNC);
                } else {
                    float media = mediaSalarial(funcionarios, NUM_FUNC);
                    acimaDaMedia(funcionarios, NUM_FUNC, media);
                }
                break;

            case 0:
                printf("\nEncerrando o sistema...\n");
                break;

            default:
                printf("\nOpcao invalida!\n");
        }

    } while (opcao != 0);

    return 0;
}

/* Limpa o buffer de entrada apos o uso de scanf com %d/%f */
void limparBuffer(void) {
    int c;
    while ((c = getchar()) != '\n' && c != EOF) {
        /* descarta */
    }
}

void cadastrarFuncionarios(Funcionario func[], int n, int *cadastrados) {
    printf("\n=== Cadastro de funcionarios ===\n");

    for (int i = 0; i < n; i++) {
        printf("\n--- Funcionario %d ---\n", i + 1);

        printf("Nome: ");
        scanf(" %49[^\n]", func[i].nome);

        printf("Idade: ");
        scanf("%d", &func[i].idade);

        limparBuffer();
        printf("Cargo: ");
        scanf(" %29[^\n]", func[i].cargo);

        printf("Salario: ");
        scanf("%f", &func[i].salario);
    }

    *cadastrados = n;
    printf("\n%d funcionarios cadastrados com sucesso!\n", n);
}

void listarFuncionarios(const Funcionario func[], int n) {
    printf("\n=== Lista de funcionarios ===\n\n");
    printf("%-20s%8s%-20s%12s\n", "Nome", "Idade", "Cargo", "Salario");

    for (int i = 0; i < n; i++) {
        printf("%-20s%8d%-20s%12.2f\n",
               func[i].nome, func[i].idade, func[i].cargo, func[i].salario);
    }
}

void maiorSalario(const Funcionario func[], int n) {
    int indiceMaior = 0;

    for (int i = 1; i < n; i++) {
        if (func[i].salario > func[indiceMaior].salario) {
            indiceMaior = i;
        }
    }

    printf("\n=== Maior salario ===\n");
    printf("Nome: %s\n", func[indiceMaior].nome);
    printf("Cargo: %s\n", func[indiceMaior].cargo);
    printf("Salario: %.2f\n", func[indiceMaior].salario);
}

float mediaSalarial(const Funcionario func[], int n) {
    float soma = 0.0f;

    for (int i = 0; i < n; i++) {
        soma += func[i].salario;
    }

    return soma / n;
}

void acimaDaMedia(const Funcionario func[], int n, float media) {
    printf("\n=== Funcionarios com salario acima da media (%.2f) ===\n\n", media);

    int encontrou = 0;
    for (int i = 0; i < n; i++) {
        if (func[i].salario > media) {
            printf("%-20s%12.2f\n", func[i].nome, func[i].salario);
            encontrou = 1;
        }
    }

    if (!encontrou) {
        printf("Nenhum funcionario acima da media.\n");
    }
}
