/*
 * Exercicio 2 - Maior e menor
 *
 * Le 10 numeros inteiros em um array e determina:
 *  - o maior valor
 *  - o menor valor
 *  - as posicoes em que eles aparecem
 */

#include <stdio.h>

#define TAM 10

int main(void) {
    int vetor[TAM];
    int maior, menor;
    int posMaior = 0, posMenor = 0;

    printf("=== Exercicio 2 - Maior e menor ===\n\n");

    for (int i = 0; i < TAM; i++) {
        printf("Digite o %2dº numero: ", i + 1);
        scanf("%d", &vetor[i]);
    }

    maior = menor = vetor[0];

    for (int i = 1; i < TAM; i++) {
        if (vetor[i] > maior) {
            maior = vetor[i];
            posMaior = i;
        }
        if (vetor[i] < menor) {
            menor = vetor[i];
            posMenor = i;
        }
    }

    printf("\nMaior valor: %d (posicao %d)\n", maior, posMaior + 1);
    printf("Menor valor: %d (posicao %d)\n", menor, posMenor + 1);

    return 0;
}
