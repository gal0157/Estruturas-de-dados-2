# Design de Jogos de ED II

Disciplina: Estruturas de Dados II • Ciência da Computação

Tema: Design de Jogos Educativos sobre Árvores Avançadas por meio da Engenharia Reversa

e Reuso de Modelos

# 1\. Identificação do Grupo

Integrantes do Grupo:

Guilherme Galvão 

Henrique Kirch

Data: 11/09/2026 Turma: Ciência da Computação



# 3\. Estrutura e Roteiro do Workshop (80 min)

● Fase 1 — Mapeamento e Engenharia Reversa (15 min): Escolha do jogo/ferramenta

base e análise de limitações.

● Fase 2 — Elaboração do Game Design Document Briefing (35 min): Preenchimento

do template de especificação e tradução dos conceitos de ED II para o gameplay.

● Fase 3 — Preparação e Pitch de Apresentação (30 min): Apresentação de um Pitch

de 3 minutos para a turma com defesa do modelo.

4\. Template de Especificação: Game Design

Document Briefing.



# 4.1 Diagnóstico do Modelo Reutilizado

Nome do Jogo/Ferramenta Base Identificado:

\-  Conway’s Game of Life / Automato Celular



Limitação Didática ou Técnica Identificada no Modelo Original:

(Exemplo: O jogo base aceitava inserções arbitrárias sem custo ou restrição; o jogador

permanecia passivo sem executar operações ativas de rebalanceamento; ausência de

feedback quando a árvore atingia o pior caso.)

\- A limitação tem como a performance na implementação da ingênua do jogo

&#x20;

# 4.2 Seleção da Estrutura de ED II para o Upgrade

Selecione a estrutura avançada que fundamentará a nova mecânica do jogo:	

* Melhorar a performance comparado na implementação ingênua 



# 4.4 Regras do Core Loop e Condições do Jogo

Core Loop (O que o jogador faz repetidamente durante a partida?):

\- O jogador cria células, que vão estar colocadas em um grid.

Condição de Vitória:

\- O jogo não tem condição de vitória

Condição de Derrota (Descreva a falha associada à degradação algorítmica):

(Exemplo: O cenário desmorona se a estrutura se degenerar em uma lista encadeada,

atingindo a complexidade O(n).)

\- O jogo não tem condição de derrota



# 5\. Checklist de Autoavaliação do Grupo

● \[ ok] Identificamos e citamos o jogo/modelo base existente na literatura ou na web.

● \[ ok] O upgrade proposto exige a aplicação prática de conceitos de ED II (AVL, Rubro-

Negra ou Árvore B).

● \[ ok] As propriedades algorítmicas (ex.: Fator de Balanceamento) estão diretamente

traduzidas em mecânicas ativas de jogo.

● \[ ok] A condição de derrota está associada ao pior caso de complexidade ou quebra das

regras da estrutura.

● \[ ] O grupo está preparado para realizar a defesa do projeto em um Pitch de 3 minutos

