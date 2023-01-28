public class Pilha {

    No inicio;
    No fim;

    public void empilha(No p){
       if(inicio==null){
           inicio=p;
           fim=p;

       }
       else{
           fim.proximo=p;
           p.anterior=fim;
           fim=p;
       }
   }

    public void desempilha(){
        if(inicio==fim){
        fim=null;
        inicio=null;
        }
        else{
           fim=fim.anterior;
           fim.proximo=null;
        }
    }

    public String topo(){ //retorna elemento no topo da pilha

       if(inicio==null){
           return "_";
       }
       else{
       String aux=fim.s;
       return aux;
       }
    }

    public void reiniciar(){
        inicio=null;
        fim=inicio;

        }
    }
