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
# Specs

'''
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
'''

# Input

# Output

## AP - Palavra e seu contrário

# Specs

# Input

# Output

## AP - Mesma quantidade de "a" e "b" na palavra

# Specs

# Input

# Output
