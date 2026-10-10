/*
 * Exercicio 4 - Inversao de vetor
 *
 * Le 10 numeros e mostra o vetor original e o vetor invertido.
 * Desafio: a inversao e feita no proprio array (in-place),
 * trocando os elementos das extremidades para o centro,
 * sem usar um segundo array.
 */

#include <stdio.h>

#define TAM 10

int main(void) {
    int vetor[TAM];

    printf("=== Exercicio 4 - Inversao de vetor ===\n\n");

    for (int i = 0; i < TAM; i++) {
        printf("Digite o %2dº numero: ", i + 1);
        scanf("%d", &vetor[i]);
    }

    printf("\nVetor original:\n");
    for (int i = 0; i < TAM; i++) {
        printf("%d ", vetor[i]);
    }
    printf("\n");

    /* Inversao in-place: troca as pontas ate chegar ao meio */
    for (int i = 0, j = TAM - 1; i < j; i++, j--) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }

    printf("\nVetor invertido:\n");
    for (int i = 0; i < TAM; i++) {
        printf("%d ", vetor[i]);
    }
    printf("\n");

    return 0;
}
