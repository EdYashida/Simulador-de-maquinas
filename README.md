# Simulador-de-maquinas

O presente trabalho utiliza a linguagem Java para simular o funcionamento de 3 máquinas estudadas na Teoria da Computação.

As máquinas simuladas são as seguintes:

## Autômato Finito Determinístico(AF) 
Lê a entrada e avança para um determinado estado

## Autômato de Pilha(AP) 
Lê a entrada, lê algo da pilha(memória), escreve na pilha e avança para um determinado estado

## Máquina de Turing(MT) 
Lê a entrada, escreve na fita e determina a direção para qual a cabeço leitor irá e avança para um determinado estado


## Utilização do simulador :
Na main se é exigido primeiramente que seja inserido o path do specs, contendo informações como qual máquina será utilizada e suas características.
Há de ser posto 4 vezes esse path:
1º determina qual máquina será usada
2º determina o estado inicial
3º determina os estados finais
4º determina as regras de transição

De acordo com a máquina selecionada, será criado um objeto de sua classe na main e serão exigidos os paths do input, a palavra a ser processada, e do output, o local onde o resultado será armazenado, onde será possível visualizar se a entrada foi aceita ou rejeitada.

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

## AP - Mesma quantidade de "a" e "b" na palavra

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
