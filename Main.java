import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;


public class Della {

  
    public static void main(String[] args) throws IOException {
        String maq=new String();
        String eIn;
        String[] eFi;
        List<String[]> trans = new ArrayList<String[]>();
       
        
        maq=Leitor.leitor("specs path da maquina desejada",0);
        //System.out.println("tipo de maquina"+maq);
        eIn=Leitor.leitor("specs path da maquina desejada",1);
       // System.out.println("estado inicial:"+eIn);
        eFi=Leitor.leitorMaisDUm("specs path da maquina desejada",2);
        //for(int j=0;j<2;j++){
       // System.out.println("estado final:"+eFi[j]);
       // }
       // System.out.println("Condicoes");
        
        for(int i=3;trans!=null;i++){
        try{
        trans.add(Leitor.leitorMaisDUm("specs path da maquina desejada", i));
       // System.out.println(trans);
    }
       catch(IndexOutOfBoundsException exc){
            break;
        }
        }
        
        //oque fazer para ler as linhas de regra de transicao ate o fim do arquivo em cada maquina, precisa de try e catch
        /*
        for(int i=0;maq != null;i++){   
        try {
            maq=Leitor.leitor("C:\\Users\\eduar\\OneDrive\\Área de Trabalho\\Finito.txt",i);
            System.out.println(maq);
            
            
        }
        catch(IndexOutOfBoundsException exc){
            break;
        }
        }		
		
        */
        
       
       
       if("f".equals(maq)){
          System.out.println("Automato Finito Deterministico Selecionado"); 
          
          AF afd= new AF(eIn, eFi,trans);
          afd.leInput("input AF path");
          //System.out.println(afd.estadoAtualF);
          afd.check("input AF path","output AF path" );
       }
       
       else if("p".equals(maq)){
          
          /* 
           Pilha pilha=new Pilha();
           String a = "a";
           String b = "b";
           String c = "c";
           
           pilha.empilha(new No(a));
           pilha.empilha(new No(b));
           pilha.empilha(new No(c));

           System.out.println(pilha.topo());
           pilha.desempilha();
           System.out.println(pilha.topo());
           
           pilha.reiniciar();
           System.out.println("Reiniciando a pilha");
           System.out.println(pilha.topo());
           pilha.empilha(new No(a));
           pilha.empilha(new No(b));
           System.out.println(pilha.topo());
*/

           
           System.out.println("Automato de Pilha Selecionado"); 
           AP afp= new AP(eIn, eFi,trans);
           afp.leInput("input AP path");
           //afp.checarPilha("C:\\Users\\eduar\\OneDrive\\Área de Trabalho\\Códigos\\Della\\AP\\Input.txt");
           afp.check("input AP path", "output AP path");
           
       }
       
       else if("t".equals(maq)){
           System.out.println("Maquina de Turing selecionada");
           MT mt=new MT(eIn, eFi,trans);
           mt.leInput("input MT path");
           mt.check("output MT path");
       }
       
       else{
           System.out.println("Essa maquina nao existe");
       }
    }
    
        }
