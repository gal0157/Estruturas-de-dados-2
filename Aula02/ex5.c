/*
 * Exercicio 5 - Matriz 3 x 3
 *
 * Le uma matriz 3x3 de inteiros e:
 *  - mostra a matriz
 *  - calcula a soma de todos os elementos
 *  - mostra o maior valor
 */

#include <stdio.h>

#define LIN 3
#define COL 3

int main(void) {
    int matriz[LIN][COL];
    int soma = 0;
    int maior;

    printf("=== Exercicio 5 - Matriz 3 x 3 ===\n\n");

    for (int i = 0; i < LIN; i++) {
        for (int j = 0; j < COL; j++) {
            printf("Digite o elemento [%d][%d]: ", i, j);
            scanf("%d", &matriz[i][j]);
        }
    }

    maior = matriz[0][0];

    printf("\nMatriz:\n");
    for (int i = 0; i < LIN; i++) {
        for (int j = 0; j < COL; j++) {
            printf("%4d", matriz[i][j]);
            soma += matriz[i][j];
            if (matriz[i][j] > maior) {
                maior = matriz[i][j];
            }
        }
        printf("\n");
    }

    printf("\nSoma de todos os elementos: %d\n", soma);
    printf("Maior valor da matriz: %d\n", maior);

    return 0;
}
