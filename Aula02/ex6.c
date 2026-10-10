/*
 * Exercicio 6 - Diagonal principal
 *
 * Le uma matriz 4x4, mostra os elementos da diagonal
 * principal e calcula a soma desses elementos.
 */

#include <stdio.h>

#define LIN 4
#define COL 4

int main(void) {
    int matriz[LIN][COL];
    int soma = 0;

    printf("=== Exercicio 6 - Diagonal principal ===\n\n");

    for (int i = 0; i < LIN; i++) {
        for (int j = 0; j < COL; j++) {
            printf("Digite o elemento [%d][%d]: ", i, j);
            scanf("%d", &matriz[i][j]);
        }
    }

    printf("\nMatriz:\n");
    for (int i = 0; i < LIN; i++) {
        for (int j = 0; j < COL; j++) {
            printf("%4d", matriz[i][j]);
        }
        printf("\n");
    }

    printf("\nDiagonal principal:\n");
    for (int i = 0; i < LIN; i++) {
        printf("%d ", matriz[i][i]);
        soma += matriz[i][i];
    }
    printf("\n");

    printf("\nSoma da diagonal principal: %d\n", soma);

    return 0;
}
