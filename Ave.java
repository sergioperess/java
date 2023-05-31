
/**
 * Escreva uma descrição da classe Ave aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Ave extends Animal
{
    private String voo;

    /**
     * Construtor para objetos da classe Ave
     */
    public Ave(String nome, String especie, int qtdPatas, String som, String voo)
    {
        super(nome,especie,qtdPatas,som);
        this.voo = voo;
    }

    /**
     *  Método para retornar a descrição do animal 
     */
    @Override
    public String getDescricaoLonga(){
        String descricao = super.getDescricaoLonga();
        return descricao + " e voa " + voo;
    }  
    
}
