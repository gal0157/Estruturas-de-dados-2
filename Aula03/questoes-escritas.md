# Questões Escritas — Aula 03 (Ponteiros, Referências e Estruturas Dinâmicas)

> Respostas às perguntas teóricas dos exercícios e à reflexão final. As partes que pediam código estão implementadas separadamente em Java, nas pastas `exercicio1_referencias/`, `exercicio2_cadeia/`, `exercicio3_depuracao/` e `desafio_clinica/`.

## Exercício 1 — Referências

**Código-base (Java):**
```java
List<Integer> a = new ArrayList<>(List.of(10, 20, 30));
List<Integer> b = a;
b.add(40);
```

1. **Qual será a saída?**
   `a: [10, 20, 30, 40]` e `b: [10, 20, 30, 40]` — ambas as listas mostram o valor `40` adicionado, porque `a` e `b` apontam para o mesmo objeto em memória.

2. **`a` e `b` representam o mesmo objeto?**
   Sim. A atribuição `b = a` copia apenas a referência (o "endereço"), não o conteúdo da lista.

3. **Por quê?**
   Em Java, variáveis de tipos referência (como `List`) armazenam uma referência para o objeto alocado no heap, não o objeto propriamente dito. `b = a` faz `b` apontar para o mesmo objeto que `a`, então qualquer alteração feita através de `b` (como `add(40)`) é visível através de `a` também. É o mesmo comportamento observado em Python com `id(a) == id(b)`.

4. **O que aconteceria com uma cópia (`new ArrayList<>(a)` em vez de `b = a`)?**
   `a` e `b` passariam a apontar para objetos diferentes na memória (identidades diferentes). Alterar `b` (por exemplo, `b.add(40)`) não afetaria mais `a`: `a` permaneceria `[10, 20, 30]` enquanto `b` seria `[10, 20, 30, 40]`. Essa é uma cópia rasa (shallow copy) — no caso de uma lista de `Integer` (imutável), o resultado prático é equivalente a uma cópia independente.

## Exercício 3 — Depuração

**Código com erro:**
```java
Node atual = n1;
while (atual != null) {
    System.out.println(atual.valor);
}
```

1. **Qual é o problema?**
   A variável `atual` nunca é atualizada dentro do laço `while`. Ela é inicializada como `n1` e permanece apontando para `n1` para sempre.

2. **Por que o programa não termina?**
   A condição de parada do laço é `atual != null`. Como `atual` nunca muda de valor (nunca passa a referenciar `atual.proximo`), essa condição nunca se torna falsa, e o `while` imprime `10` infinitamente.

3. **Qual linha deve ser acrescentada?**
   `atual = atual.proximo;` deve ser adicionada ao final do corpo do laço, para que `atual` avance para o próximo nó a cada iteração.

4. **Qual será a saída depois da correção?**
   ```
   10
   20
   30
   ```
   Após imprimir o valor de `n3` (30), `atual` recebe `n3.proximo`, que é `null`, e o laço é encerrado.

## Reflexão Final

### O que é uma referência (em Java, análogo à referência em Python)?
Uma referência é o "caminho" pelo qual uma variável acessa um objeto alocado em memória. A variável não guarda o objeto em si — ela guarda um valor que aponta para onde o objeto está armazenado. Várias variáveis podem guardar a mesma referência e, portanto, apontar para o mesmo objeto, compartilhando qualquer alteração feita nele.

### Qual a diferença entre `b = a` e uma cópia como `new ArrayList<>(a)`?
`b = a` faz `b` apontar para o **mesmo objeto** que `a` — não existe um novo objeto na memória, apenas uma nova variável referenciando o existente; qualquer mudança via `b` reflete em `a`. Já `new ArrayList<>(a)` cria um **novo objeto**, com seu próprio espaço na memória, copiando os elementos de `a` para dentro dele; a partir daí, `a` e `b` evoluem de forma independente.

### Por que uma estrutura encadeada precisa de referências?
Uma estrutura encadeada (como uma lista ligada ou uma fila) é formada por nós conectados uns aos outros. Essa conexão só é possível porque cada nó guarda uma referência para o próximo nó (o campo `proximo`). Sem referências, não haveria como um objeto "apontar" para outro dinamicamente — a estrutura não poderia crescer, encolher ou ser percorrida em tempo de execução.

### Como referências ajudam a compreender estruturas dinâmicas?
Entender que `proximo` é uma referência (e não uma cópia do próximo nó) explica por que é possível inserir e remover elementos apenas reorganizando essas referências, sem precisar mover ou copiar os dados armazenados nos nós. Isso também explica erros comuns de depuração, como o do Exercício 3: se a referência usada para percorrer a estrutura nunca é atualizada, o programa fica "preso" sempre olhando para o mesmo objeto.

### Qual erro foi encontrado durante a depuração desta aula (e a correção)?
O erro foi a ausência da linha `atual = atual.proximo;` dentro do laço de percurso (Exercício 3 / item 14 do conteúdo), o que causava um loop infinito porque a variável de percurso nunca avançava para o próximo nó da estrutura encadeada. A correção consistiu em adicionar essa linha ao final do corpo do `while`, garantindo que a referência avance a cada iteração até alcançar `null`.
