
/**
 * Classe para criar um animal. 
 * 
 * @author Sérgio Peres
 * @version 1.0
 */
public class Animal
{
    // Nome do animal
    private String nome;
    // Espécie do animal
    private String especie;
    // Quantidade de patas
    private static int qtdPatas;
    // Som caracteristico/
    private String som;

    /**
     * Construtor para objetos da classe Animal
     */
    public Animal(String nome, String especie, int qtdPatas, String som)
    {
        this.nome = nome;
        this.especie = especie;
        this.qtdPatas = qtdPatas;
        this.som = som;        
    }
    
    /**
     *  Método para retornar o nome e especie do animal 
     */
    public String getDescricaoAnimal(){
        return nome + " eh um " + especie;
    }
    
    public String getDescricaoLonga(){
        return getDescricaoAnimal() + " que faz " + som;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getSom(){
        return som;
    }
    
    public boolean getConfirma(String umNome){
        if(nome.equals(umNome)){
            return true;
        }else{
            return false;
        }
    }

}
