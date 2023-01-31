import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class MT extends Leitor{
    String estadoInicialT;
    String[] estadosFinaisT;
    String estadoAtualT;
    List<String[]> transicaoT;
    List<String[]> input = new ArrayList<String[]>();
    String output;
    List<String> resultado = new ArrayList<String>();
    String direcao="D"; //inicializa movendo para a direita da fita
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
    public MT (String estadoInicialT,String[] estadosFinaisT,List<String[]> transicaoT) throws IOException{
    this.estadoInicialT = estadoInicialT;
    this.estadosFinaisT=estadosFinaisT;
    this.estadoAtualT=estadoInicialT;  //a maquina comeca no estado inicial, entao atual=inicial
    this.transicaoT=transicaoT;
    }

    public String toString(String [] input){    //usar fita.toString nao funciona da forma desejada
        String printado= Arrays.toString(input).replace("[","").replace(",","").replace(" ","").replace("]","").replace("_","");
        //retirar caracteres indesejados que aparecem no output
        return printado;
    }
public void check(String outputpath) throws IOException{
       

       /*
       Path arq = Paths.get(entrada);                      nao eh necessario pois precisar ter conteudo da fita no output
        List<String> printado = Files.readAllLines(arq);   e nao simplesmente o do input lido
       */
       for(int i=0;i<this.input.size();i++){ //linha a linha do input
       estadoAtualT=estadoInicialT;
       String[]fita= input.get(i); //cria a fita
       int t=-1;   //count da fita, comeca como -1 pq comeca com D, entao vai ter t++ deixando t=0
                   // Junto a isso, ao iniciar direcao como null,parado, etc e t=0, o processamento ocorre de forma não desejada, normalmente ignorando a primeira célula/caracere do input
       int compativel=0;

       while(true){
           if(direcao.equals("D")){ //move pra direita
               t++;
           }
           else if(direcao.equals("E")){ //move pra esquerda
               t--;
           }
           if(t==fita.length){  //se atinge fim da fita
               break;
       }


       for(String[]posicao:transicaoT){
           if(estadoAtualT.equals(posicao[0])){ //se primeira posicao da condicao for igual ao estado atual
               if(fita[t].equals(posicao[1])){  //se a celula lida da fita for igual a segunda posicao da transicao

                   fita[t]=posicao[2]; //eh escrito sobre a celula lida
                   direcao=posicao[3]; //eh determinada a diracao 
                   estadoAtualT=posicao[4]; //novo estado eh atribuido
                   compativel++; //foi encontrada transicao compativel
                   break; //sai
               }
           }
       }
        if(compativel==0){  //se nao tem transicao compativel pra seguir 
            estadoAtualT="Entrada_Rejeitada";
            break;
        }
       //  move e repete
    }

    resultado.add("S;tape --  "+toString(fita));
}
       escrever(outputpath,resultado);
       System.out.println("Leitura Finalizada");
}
}
