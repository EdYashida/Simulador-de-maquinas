import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AF extends Leitor{

    String estadoInicialF;
    String[] estadosFinaisF;
    String estadoAtualF;
    List<String[]> transicaoF;
    List<String[]> input = new ArrayList<String[]>();
    String output;
    List<String> resultado = new ArrayList<String>();

    int tamanhoInput=0;
    
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
    public AF(String estadoInicialF,String[] estadosFinaisF,List<String[]> transicaoF) throws IOException{
    this.estadoInicialF = estadoInicialF;
    this.estadosFinaisF=estadosFinaisF;
    this.estadoAtualF=estadoInicialF;  //a maquina comeca no estado inicial, entao atual=inicial
    this.transicaoF=transicaoF;
    }
    
    //de fato verifica se a entrada eh aceita ou rejeitada
    
    public void check(String entrada, String saida) throws IOException{
        Path arq = Paths.get(entrada);
        List<String> printado = Files.readAllLines(arq); //input presente em cada linha no output
        
        
        for(int i=0; i<this.input.size();i++){ //linha a linha do input.txt
        int t=0;
            for(String inputComp:input.get(i)){
            int compativel=0;   
                if(t==0){
                    
                    estadoAtualF=estadoInicialF;
                
                }
                
                
        /*verifica se o primeiro caractere de uma condicao eh o mesmo do estado atual, pois essa posicao na cond
        corresponde ao estado corrente.
        Se for, o estadoatual eh alterado para o estado do caractere de
        posicao [2] na cond, pois esse eh o estado atingido tendo lido [1] da cond
        */
        
                for(String[]posicao:transicaoF){ //caractere a caractere da transicao
                    
                    if(estadoAtualF.equals(posicao[0])){  
                        if(inputComp.equals(posicao[1])){
                            compativel++; //foi encontrada condicao compativel com oque foi lido input e o estado atual
                            
                            estadoAtualF= posicao[2];  //nova posicao assumida
                            
                            break;
                        }
                    }
                    
                }
                
                if(compativel==0){  //se nao houver condicao que satisfaz
                    estadoAtualF="Entrada_Rejeitada";
                    break;
                }
                t++;
            }
            
            for(String posicao:this.estadosFinaisF){  //aceito ou rejeitado?
                if(estadoAtualF.equals(posicao)){ //se parou em estado final aceita
                    output = "A";
                    break;
                }
                else{                        //se nao rejeita
                    output="R";
                }
            }
            resultado.add(output+";"+printado.get(i));
    }
        
   
        escrever(saida, resultado);
        System.out.println("Leitura Finalizada");
    }  
}
