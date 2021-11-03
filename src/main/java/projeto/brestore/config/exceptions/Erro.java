package projeto.brestore.config.exceptions;

public class Erro extends Exception{
    
    private String informacao;
    
    public Erro(String informacao){
        super();
        this.informacao = informacao;
    }

    @Override
    public String toString(){

        return "Ops! Tem algo errado. " + informacao;
    }

}
