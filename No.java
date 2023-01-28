public class No {

    String s;
     No proximo;
     No anterior;

    public No(String input){
        this.s=input;
    }

 public String toString(){
        if(proximo!=null && anterior!=null ){
            return this.hashCode()+"  Pessoa-->"+s.toString()+"  |Proximo:"+proximo.hashCode()+"  |Anterior:"+anterior.hashCode();
        }
        else if(proximo !=null && anterior ==null){
            return this.hashCode()+"  Pessoa-->"+s.toString()+"  |Proximo:"+proximo.hashCode();
        }
        else if(proximo ==null && anterior!= null){
            return this.hashCode()+"  Pessoa-->"+s.toString()+"  |Anterior:"+anterior.hashCode();
        }
        else{
            return this.hashCode()+"  Pessoa-->"+s.toString()+"  |Proximo:Vazio  |Anterior: Vazio";
        }
    }

}
