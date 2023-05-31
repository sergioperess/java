/**
 * Classe Ambiente - um ambiente em um jogo adventure.
 *
 * Esta classe eh parte da aplicacao "World of Zuul".
 * "World of Zuul" eh um jogo de aventura muito simples, baseado em texto.  
 *
 * Um "Ambiente" representa uma localizacao no cenario do jogo. Ele eh
 * conectado aos outros ambientes atraves de saidas. As saidas sao
 * nomeadas como norte, sul, leste e oeste. Para cada direcao, o ambiente
 * guarda uma referencia para o ambiente vizinho, ou null se nao ha
 * saida naquela direcao.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido por Julio Cesar Alves)
 * @version 2011.07.31 (2016.02.01)
 */
import java.util.HashMap;
import java.util.ArrayList;

public class Ambiente 
{
    private String descricao;
    
    private HashMap<String, Ambiente> saidas;
    
    private Polen polen;

        
    public Ambiente getSaida(String direcao){
        return saidas.get(direcao);
    }   
    

    /**
     * Cria um ambiente com a "descricao" passada. Inicialmente, ele
     * nao tem saidas. "descricao" eh algo como "uma cozinha" ou
     * "
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "um jardim aberto".
     * @param descricao A descricao do ambiente.
     */
    public Ambiente(String descricao) 
    {
        this.descricao = descricao;
        saidas = new HashMap<String, Ambiente> ();
    }
    
    public Ambiente(String descricao, Polen polen){
        this(descricao);
        this.polen = polen;
    }

    /**
     * Define as saidas do ambiente. Cada direcao ou leva a um
     * outro ambiente ou eh null (nenhuma saida para la).
     * @param norte A saida norte.
     * @param leste A saida leste.
     * @param sul A saida sul.
     * @param oeste A saida oeste.
     */
    public void ajustarSaida(String direcao, Ambiente ambiente) 
    {
        saidas.put(direcao, ambiente);
    }

    /**
     * @return A descricao do ambiente.
     */
    public String getDescricao()
    {
        return descricao;
    }
    
    public boolean getTesteItem(){
        boolean aux = false;
        if(polen != null){
            aux = true;
        }
        return aux;
    }
    
    public String getDescricaoItem(){
        String desc;
        if(polen != null){
            desc = "Há um item " + polen.getNome();
        }else{
            desc = "Não há nada aqui.";
        }
        return desc;
    }
    
    public String consultaItem(){
        if(polen != null){
            return polen.getNome();
        }
        return null;
    }
    
    public Polen removeItem(){
        Polen aux = null;
    
        if(polen != null){ 
             aux = polen;
             polen = null;
        }

        return aux;        
    }
    
    public String getSaidas(){
        String saida = "";
        for(String direcao : saidas.keySet()){
            saida = saida + direcao + " ";
        }
        
        return saida;
    }

}
