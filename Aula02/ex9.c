/*
 * Exercicio 9 - Struct Aluno
 *
 * Cadastra 5 alunos (nome, idade, nota1, nota2, nota3),
 * calcula a media de cada um e classifica:
 *   media >= 7.0 -> Aprovado
 *   media <  7.0 -> Reprovado
 *
 * Ao final informa a quantidade de aprovados, reprovados
 * e o aluno com maior media.
 */

#include <stdio.h>

#define NUM_ALUNOS 5
#define TAM_NOME 50

typedef struct {
    char nome[TAM_NOME];
    int idade;
    float nota1, nota2, nota3;
} Aluno;

int main(void) {
    Aluno alunos[NUM_ALUNOS];
    float medias[NUM_ALUNOS];
    int aprovados = 0, reprovados = 0;
    int indiceMaior = 0;

    printf("=== Exercicio 9 - Struct Aluno ===\n\n");

    for (int i = 0; i < NUM_ALUNOS; i++) {
        printf("--- Aluno %d ---\n", i + 1);

        printf("Nome: ");
        scanf(" %49[^\n]", alunos[i].nome);

        printf("Idade: ");
        scanf("%d", &alunos[i].idade);

        printf("Nota 1: ");
        scanf("%f", &alunos[i].nota1);

        printf("Nota 2: ");
        scanf("%f", &alunos[i].nota2);

        printf("Nota 3: ");
        scanf("%f", &alunos[i].nota3);

        printf("\n");
    }

    printf("=== Resultado da turma ===\n\n");
    printf("%-20s%8s%10s%12s\n", "Nome", "Idade", "Media", "Situacao");

    for (int i = 0; i < NUM_ALUNOS; i++) {
        medias[i] = (alunos[i].nota1 + alunos[i].nota2 + alunos[i].nota3) / 3.0f;

        const char *situacao = (medias[i] >= 7.0f) ? "Aprovado" : "Reprovado";
        if (medias[i] >= 7.0f) {
            aprovados++;
        } else {
            reprovados++;
        }

        if (medias[i] > medias[indiceMaior]) {
            indiceMaior = i;
        }

        printf("%-20s%8d%10.2f%12s\n",
               alunos[i].nome, alunos[i].idade, medias[i], situacao);
    }

    printf("\nQuantidade de aprovados: %d\n", aprovados);
    printf("Quantidade de reprovados: %d\n", reprovados);
    printf("Aluno com maior media: %s (%.2f)\n",
           alunos[indiceMaior].nome, medias[indiceMaior]);

    return 0;
}
