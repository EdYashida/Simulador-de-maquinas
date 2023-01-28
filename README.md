# Simulador-de-maquinas

O presente trabalho utiliza a linguagem Java para simular o funcionamento de 3 máquinas estudadas na Teoria da Computação.

As máquinas simuladas são as seguintes:

## Autômato Finito Determinístico(AF) 
Lê a entrada e avança para um determinado estado

## Autômato de Pilha(AP) 
Lê a entrada, lê algo da pilha(memória), escreve na pilha e avança para um determinado estado

## Máquina de Turing(MT) 
Lê a entrada, escreve na fita e determina a direção para qual a cabeço leitor irá e avança para um determinado estado


## Funcionamento :
Na main se é exigido primeiramente que seja inserido o path do specs, contendo informações sobre qual máquina será utilizada e suas características.
Há de ser posto 4 vezes esse path:
1º determina qual máquina será usada
2º determina o estado inicial
3º determina os estados finais
4º determina as regras de transição

Os 2 ultimos se utilzam de uma função semelhante para leitura, entretanto a diferença é que ela possui um split(";") pois diferente das 2 primeiras linhas de specs, essas possuem/podem possuir mais de 1 elemento na mesma linha, então esse split permite com que eles sejão lidos individualmente sem interferêncas do caractere que os separa uns dos outros.
Como no caso de " 1;a;2 ", os elementos a serem considerados são "1","a" e "2" e o ";" apenas o separa pra que sejam "vistos" separadamente.

De acordo com a máquina selecionada, será criado um objeto de sua classe na main com as informações obtidas anteriormente. 
Após isso, é chamada uma função para o ler input(que requer o path desse input), que desa vez possui um split("") para ler cada caractere separamente, considerando que diferente da linha de regra de transição do specs (que tem ";" separando os caracteres), no input todos os caracteres estão "colados".
E por último é chamada uma função para analisar o input, que requer o path do input que será analisado para escreve-lo junto com seu status(Aceito ou rejeitado) no output que teve seu path inserido. (A única excessão é na MT, pois é exigido o conteúdo da fita e não simplesmente o do input, então nele é necessário somente o path do output)
A análise se baseia em comparar se o estado inicial e o caractere lido do input em uma certa parte dessa são iguais aos 2 primeiros caracteres de alguma da regras de transicao(que contem o estado atual e o caractere lido quando naquele estado). Se houver uma regra de transição compativel são efetuadas as mudanças de acordo com a máquina(empilhar, escrever na fita, etc) e o estado da máquina é atualizado. Se não, o estado da máquina é atualizado para um estado inalcançável, assim rejeitando a entrada.
Ao terminar de ler o último caractere de uma linha do input( uma palavra completa), se é feita uma checagem para haver a conclusão se a palavra foi aceita ou rejeitada. Se no final o estado da máquina for um estado final, a palavra é aceita, se não ela é rejeitada. (no AP também é exigido que a pilha esteja vazia para haver a aceitação) 

## Exemplos

## AFD - Presença de subpalavra "aa" ou "bb"
###### Specs

```
f
1
4
1;a;2
1;b;3
2;a;4
2;b;3
3;a;2
3;b;4
4;a;4
4;b;4
```

###### Input

```
abba
bbb
bab
aabba
abbaab
abab
aaaa
abb
abababaaababab
ababababbba
```

###### Output

```
A;abba
A;bbb
R;bab
A;aabba
A;abbaab
R;abab
A;aaaa
A;abb
A;abababaaababab
A;ababababbba
```

## AP - Palavra e seu contrário considerando apenas aquelas formadas por "a" e "b"

###### Specs

```
p
0
2
0;a;_;A;0
0;b;_;B;0
0;_;_;_;1
1;a;A;_;1
1;b;B;_;1
1;.;_;_;2

```

###### Input

```
ab_ba.
aab_baa.
abb_bab.
abbb_bbba.
abba_abaa.
ab_aa_bb.aab_a
aa_a.
ababba_abbaba.
abc_cba.
aa_aa.
bb_bb.
cc_cc.
  
```
Nesse input os "_"  simbolziam movimento vazio  e os "." simbolizam o o final da entrada 

###### Output

```
A;abba
A;aabbaa
R;abbbab
A;abbbbbba
R;abbaabaa
R;abaabbaaba
R;aaa
A;ababbaabbaba
R;abccba
A;aaaa
A;bbbb
R;cccc
```

## MT - Mesma quantidade de "a" e "b" na palavra

###### Specs

```
t
0
4
0;a;A;D;1
0;B;B;D;3
1;a;a;D;1
1;B;B;D;1
1;b;B;E;2
2;a;a;E;2
2;B;B;E;2
2;A;A;D;0
3;B;B;D;3
3;_;_;D;4
0;_;_;D;4
```

###### Input

```
ab_
aab_
abbb_
aaaaabbb_
aaaabb_
aaabbb_
_
```
Nesse input os "_" simbolizam a celula em branco, ou seja, o final da palavra de entrada

###### Output

```
S;tape --  AB
S;tape --  AAB
S;tape --  ABbb
S;tape --  AAAAaBBB
S;tape --  AAAaBB
S;tape --  AAABBB
S;tape --  
```
