
/**
 * Escreva uma descrição da classe Abelha aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
import java.util.ArrayList;

public class Abelha
{
    private String nome;
    private ArrayList<Polen> lista = new ArrayList<>();
    private Polen polen;

    /**
     * Construtor para objetos da classe Abelha
     */
    public Abelha(String umNome, ArrayList<Polen> lista)
    {
        nome = umNome;
        lista = null;
    }
    
    /**
     *  Método para retornar o nome do jogador, ou melhor, o nome da abelha.
     */
    public String getNomeAbelha(){
        return nome;
    }
    
    public void adicionaItem(){
        lista.add(polen);
    }
    
    public Polen removeItem(String nomeItem){
        for(int i = 0; i < lista.size(); i++){
            if(nomeItem == lista.get(i).getNome()){
                lista.remove(i);
            }
        }
        return polen;
    }
    
    public String mostraItem(){
        String saida = "";
        for(int i = 0; i < lista.size(); i++){
            saida = saida + i + " ";
        }
        return saida;
    }
    

   
}
