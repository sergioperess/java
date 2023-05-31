
/**
 * Escreva uma descrição da classe Pelos aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Pelos extends Animal
{
    private String cor;
    
    /**
     * Construtor para objetos da classe Pelos
     */
    public Pelos(String nome, String especie, int qtdPatas, String som, String umaCor)
    {
        super(nome,especie,qtdPatas,som);
        cor = umaCor;
    }

    /**
     *  Método para retornar a descrição do animal 
     */
    public String getDescricaoPelos(){
        String descricao = getDescricaoAnimal();
        return descricao;
    }
    
    public String getPelo(){
        return cor;
    }
    
    
}
