/*
 * Exercicio 8 - Struct Produto
 *
 * Cadastra 5 produtos (nome, codigo, preco, quantidade),
 * mostra todos os produtos, calcula o valor em estoque de
 * cada um e informa o produto com maior valor em estoque.
 *
 * valor em estoque = preco * quantidade
 */

#include <stdio.h>

#define NUM_PRODUTOS 5
#define TAM_NOME 50

typedef struct {
    char nome[TAM_NOME];
    int codigo;
    float preco;
    int quantidade;
} Produto;

int main(void) {
    Produto produtos[NUM_PRODUTOS];
    float valorEstoque[NUM_PRODUTOS];
    int indiceMaior = 0;

    printf("=== Exercicio 8 - Struct Produto ===\n\n");

    for (int i = 0; i < NUM_PRODUTOS; i++) {
        printf("--- Produto %d ---\n", i + 1);

        printf("Nome: ");
        scanf(" %49[^\n]", produtos[i].nome);

        printf("Codigo: ");
        scanf("%d", &produtos[i].codigo);

        printf("Preco: ");
        scanf("%f", &produtos[i].preco);

        printf("Quantidade: ");
        scanf("%d", &produtos[i].quantidade);

        printf("\n");
    }

    printf("=== Lista de produtos ===\n\n");
    printf("%-20s%10s%12s%12s%16s\n",
           "Nome", "Codigo", "Preco", "Qtde", "Vlr. Estoque");

    for (int i = 0; i < NUM_PRODUTOS; i++) {
        valorEstoque[i] = produtos[i].preco * produtos[i].quantidade;

        printf("%-20s%10d%12.2f%12d%16.2f\n",
               produtos[i].nome,
               produtos[i].codigo,
               produtos[i].preco,
               produtos[i].quantidade,
               valorEstoque[i]);

        if (valorEstoque[i] > valorEstoque[indiceMaior]) {
            indiceMaior = i;
        }
    }

    printf("\nProduto com maior valor em estoque: %s (R$ %.2f)\n",
           produtos[indiceMaior].nome, valorEstoque[indiceMaior]);

    return 0;
}
