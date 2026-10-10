/*
 * Exercicio 3 - Numeros pares
 *
 * Le 20 numeros inteiros em um array e:
 *  - mostra somente os numeros pares
 *  - conta quantos numeros pares existem
 *  - calcula a soma dos numeros pares
 */

#include <stdio.h>

#define TAM 20

int main(void) {
    int vetor[TAM];
    int contPares = 0;
    int somaPares = 0;

    printf("=== Exercicio 3 - Numeros pares ===\n\n");

    for (int i = 0; i < TAM; i++) {
        printf("Digite o %2dº numero: ", i + 1);
        scanf("%d", &vetor[i]);
    }

    printf("\nNumeros pares digitados:\n");
    for (int i = 0; i < TAM; i++) {
        if (vetor[i] % 2 == 0) {
            printf("%d ", vetor[i]);
            contPares++;
            somaPares += vetor[i];
        }
    }
    printf("\n");

    printf("\nQuantidade de numeros pares: %d\n", contPares);
    printf("Soma dos numeros pares: %d\n", somaPares);

    return 0;
}
