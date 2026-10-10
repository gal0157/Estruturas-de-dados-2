/*
 * Exercicio 1 - Soma de um vetor
 *
 * Le 10 numeros inteiros, armazena em um array e apresenta:
 *  - todos os numeros
 *  - a soma dos elementos
 *  - a media dos valores
 */

#include <stdio.h>

#define TAM 10

int main(void) {
    int vetor[TAM];
    int soma = 0;
    double media;

    printf("=== Exercicio 1 - Soma de um vetor ===\n\n");

    for (int i = 0; i < TAM; i++) {
        printf("Digite o %2dº numero: ", i + 1);
        scanf("%d", &vetor[i]);
        soma += vetor[i];
    }

    media = (double) soma / TAM;

    printf("\nNumeros digitados:\n");
    for (int i = 0; i < TAM; i++) {
        printf("%d ", vetor[i]);
    }
    printf("\n");

    printf("\nSoma dos elementos: %d\n", soma);
    printf("Media dos valores: %.2f\n", media);

    return 0;
}
