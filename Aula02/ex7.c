/*
 * Exercicio 7 - Matriz de notas
 *
 * Uma turma possui 4 alunos e 3 avaliacoes (P1, P2, P3).
 * O programa le as notas em uma matriz e calcula a media
 * de cada aluno.
 */

#include <stdio.h>

#define ALUNOS 4
#define PROVAS 3

int main(void) {
    float notas[ALUNOS][PROVAS];
    float media;

    printf("=== Exercicio 7 - Matriz de notas ===\n\n");

    for (int i = 0; i < ALUNOS; i++) {
        printf("--- Aluno %d ---\n", i + 1);
        for (int j = 0; j < PROVAS; j++) {
            printf("Nota da P%d: ", j + 1);
            scanf("%f", &notas[i][j]);
        }
    }

    printf("\n%-10s%8s%8s%8s%10s\n", "", "P1", "P2", "P3", "Media");
    for (int i = 0; i < ALUNOS; i++) {
        float soma = 0.0f;

        for (int j = 0; j < PROVAS; j++) {
            soma += notas[i][j];
        }
        media = soma / PROVAS;

        printf("Aluno %-4d", i + 1);
        for (int j = 0; j < PROVAS; j++) {
            printf("%8.2f", notas[i][j]);
        }
        printf("%10.2f\n", media);
    }

    return 0;
}
