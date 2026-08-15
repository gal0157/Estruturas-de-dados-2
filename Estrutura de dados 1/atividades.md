#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
typedef struct {
char student_id[20];
char age[5];
char major[50];
char ai_tool[50];
char freq[5];
char usage[50];
char gpa_base[10];
char gpa_post[10];
char time_saved[10];
char ethics[20];
char confidence[5];
} Estudante;
/* --- ALGORITMOS DE ORDENAÇÃO --- */
// Bubble Sort
void bubbleSort(Estudante *arr, int n) {
for (int i = 0; i < n - 1; i++) {
for (int j = 0; j < n - i - 1; j++) {
if (atof(arr[j].gpa_base) > atof(arr[j+1].gpa_base)) {
Estudante temp = arr[j];
arr[j] = arr[j+1];
arr[j+1] = temp;
}
}
}
}
// Selection Sort
void selectionSort(Estudante *arr, int n) {
for (int i = 0; i < n - 1; i++) {
int min_idx = i;
for (int j = i + 1; j < n; j++) {
if (atof(arr[j].gpa_base) < atof(arr[min_idx].gpa_base)) {
min_idx = j;
}
}
Estudante temp = arr[min_idx];
arr[min_idx] = arr[i];
arr[i] = temp;
}
}
// Insertion Sort
void insertionSort(Estudante *arr, int n) {
for (int i = 1; i < n; i++) {
Estudante key = arr[i];
int j = i - 1;
while (j >= 0 && atof(arr[j].gpa_base) > atof(key.gpa_base)) {
arr[j + 1] = arr[j];
j = j - 1;
}
arr[j + 1] = key;
}
}
/* FUNÇÃO PRINCIPAL */
int main() {
FILE *file = fopen("document.csv", "r");
if (!file) {
printf("Erro ao abrir o arquivo!\n");
return 1;
}
// Alocação dinâmica inicial
int capacidade = 1000;
int n = 0;
Estudante *dados_originais = (Estudante *)malloc(capacidade * sizeof(Estudante));
if (dados_originais == NULL) {
printf("Erro de alocação de memória!\n");
return 1;
}
char linha[512];
// Ignorar o cabeçalho do CSV
fgets(linha, sizeof(linha), file);
// Lendo os dados do CSV
while (fgets(linha, sizeof(linha), file)) {

// Redimensionar vetor se necessário
if (n >= capacidade) {
capacidade *= 2;
dados_originais = realloc(dados_originais, capacidade * sizeof(Estudante));
}
// Separando os dados por vírgula
char *token = strtok(linha, ",");
if(token) strcpy(dados_originais[n].student_id, token);
token = strtok(NULL, ","); if(token) strcpy(dados_originais[n].age, token);
token = strtok(NULL, ","); if(token) strcpy(dados_originais[n].major, token);
token = strtok(NULL, ","); if(token) strcpy(dados_originais[n].ai_tool, token);
token = strtok(NULL, ","); if(token) strcpy(dados_originais[n].freq, token);
token = strtok(NULL, ","); if(token) strcpy(dados_originais[n].usage, token);
token = strtok(NULL, ","); if(token) strcpy(dados_originais[n].gpa_base, token);
token = strtok(NULL, ","); if(token) strcpy(dados_originais[n].gpa_post, token);
token = strtok(NULL, ","); if(token) strcpy(dados_originais[n].time_saved, token);
token = strtok(NULL, ","); if(token) strcpy(dados_originais[n].ethics, token);
token = strtok(NULL, "\n"); if(token) strcpy(dados_originais[n].confidence, token);
n++;
}
fclose(file);
printf("Total de registros carregados: %d\n\n", n);
//Criando um vetor temporário para testes
Estudante *dados_teste = (Estudante *)malloc(n * sizeof(Estudante));
clock_t t0, t1;
double tempo_gasto;
/* TESTE BUBBLE SORT */
memcpy(dados_teste, dados_originais, n * sizeof(Estudante));
t0 = clock();
bubbleSort(dados_teste, n);
t1 = clock();
tempo_gasto = (double)(t1 - t0) / CLOCKS_PER_SEC;
printf("\nTempo Bubble Sort: %f segundos\n", tempo_gasto);
// Imprimindo o resultado do Bubble Sort
printf(" (Bubble Sort) \n");
for (int i = 0; i < 10 && i < n; i++) {
printf("Posicao %d: ID: %s | GPA Base: %s\n", i+1, dados_teste[i].student_id, dados_teste[i].gpa_base);
}
/* TESTE SELECTION SORT */
memcpy(dados_teste, dados_originais, n * sizeof(Estudante));
t0 = clock();
selectionSort(dados_teste, n);
t1 = clock();
tempo_gasto = (double)(t1 - t0) / CLOCKS_PER_SEC;
printf("\nTempo Selection Sort: %f segundos\n", tempo_gasto);
// Imprimindo o resultado do Selection Sort
printf(" (Selection Sort) \n");
for (int i = 0; i < 10 && i < n; i++) {
printf("Posicao %d: ID: %s | GPA Base: %s\n", i+1, dados_teste[i].student_id, dados_teste[i].gpa_base);
}
/* TESTE INSERTION SORT */
memcpy(dados_teste, dados_originais, n * sizeof(Estudante));
t0 = clock();
insertionSort(dados_teste, n);
t1 = clock();
tempo_gasto = (double)(t1 - t0) / CLOCKS_PER_SEC;
printf("\nTempo Insertion Sort: %f segundos\n", tempo_gasto);
// Imprimindo o resultado do Insertion Sort
printf(" (Insertion Sort) \n");
for (int i = 0; i < 10 && i < n; i++) {
printf("Posicao %d: ID: %s | GPA Base: %s\n", i+1, dados_teste[i].student_id, dados_teste[i].gpa_base);
}
free(dados_originais);
free(dados_teste);
return 0;
}
