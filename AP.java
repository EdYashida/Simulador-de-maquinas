import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AP extends Leitor{
    
    String estadoInicialP;
    String[] estadosFinaisP;
    String estadoAtualP;
    List<String[]> transicaoP;
    List<String[]> input = new ArrayList<String[]>();
    String output;
    List<String> resultado = new ArrayList<String>();
    Pilha pilha=new Pilha();
    
    //le input
    public void leInput(String path) throws IOException{
        Path arq = Paths.get(path);
        List<String> linha = Files.readAllLines(arq);
        
        for(int i=0; i<linha.size();i++){
            
            input.add(linha.get(i).split(""));
            //System.out.println(linha);  
        }
        
    }
    
    //inicializa a maquina de acorod com oque foi lido e passado na main

    
    
    public AP(String estadoInicialP,String[] estadosFinaisP,List<String[]> transicaoP) throws IOException{
    this.estadoInicialP = estadoInicialP;
    this.estadosFinaisP=estadosFinaisP;
    this.estadoAtualP=estadoInicialP;  //a maquina comeca no estado inicial, entao atual=inicial
    this.transicaoP=transicaoP;
    }
    
    
    //usado pra checar se estava funcionando a utilizacao de pilha como lista duplamente encadeada
   /*public void checarPilha(String entrada) throws IOException{
    
        for(String input2:input.get(0)){
            int compativel=0;   
                
                for(String[]posicao:input){ //caractere a caractere da transicao
                    
                   pilha.empilha(new No(posicao[0]));
                   pilha.empilha(new No(posicao[1]));
                   pilha.empilha(new No(posicao[2]));
                   
                   System.out.println(pilha.topo());

                }            
            }    
    }
    */
    
    public void check(String entrada, String saida) throws IOException{
        Path arq = Paths.get(entrada);
        List<String> printado = Files.readAllLines(arq); //input presente em cada linha no output
        
        
        for(int i=0; i<this.input.size();i++){ //linha a linha do input.txt
        int t=0;
        pilha.reiniciar(); //reinicia a pilha a cada linha do input
        
            for(String inputComp:input.get(i)){
            int compativel=0;   //usado pra checar se ha transicao compativel com a entrada
                if(t==0){
                    
                    estadoAtualP=estadoInicialP;
                
                }         
        /*verifica se o primeiro caractere de um input eh o mesmo
        do primeiro caractere em uma condicao, pois essa posicao na cond
        corresponde ao estado corrente.
        Se houver, o estadoatual eh alterado para o estado do caractere de
        posicao [4] na cond, pois esse eh o estado atingido tendo lido [1]
        */
        
                for(String[]posicao:transicaoP){ //caractere a caractere da transicao
                    
                    if(estadoAtualP.equals(posicao[0])){
                        if(inputComp.equals(posicao[1])){
                                                        
                            
                            //Agora serao lido [2] onde ha o que sera lido da pilha e
                            // [3] onde ha o que deve ser empilhado                          
                            
                            //se nao tiver oque ler da pilha
                            if(posicao[2].equals("_")){
                                System.out.print("");
                            }
                            // se tiver o que ler da pilha
                            else if(pilha.topo().equals(posicao[2])){
                                
                                pilha.desempilha();
                            }
                            
                            //atribuicao do proximo estado feita quando for empilhar para ocorrer apenas 1 vez por loop
                            
                            //se não tiver o que colocar na pilha
                            if(posicao[3].equals("_")){
                                estadoAtualP= posicao[4];
                                compativel++;
                                break;
                            }
                            
                            //se tiver o que colocar na pilha
                            else {
                                pilha.empilha(new No(posicao[3]));
                                estadoAtualP= posicao[4];
                                compativel++;
                                break;
                            }
      
                        }
                    }
                    
                }
                
                if(compativel==0){ //se nao tiver transicao pra entrada
                    estadoAtualP="Entrada_Rejeitada";
                    break;
                }
                t++;
            }
            
            for(String posicao:this.estadosFinaisP){  //aceito ou rejeitado?
                //estado final atingido e pilha vazia pra ser aceito
                if(estadoAtualP.equals(posicao) && pilha.topo()=="_"){
                    output = "A";
                    break;
                }
                else{
                    output="R";
                }
            }
            resultado.add(output+";"+printado.get(i).replace("_","").replace(".","")); //retira _ que simboliza movimento vazio no input e
    }                                                                                  //. que simboliza o fim do input
        
   
        escrever(saida, resultado);
        System.out.println("Leitura Finalizada");
    }
       
}
