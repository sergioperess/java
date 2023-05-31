import java.util.ArrayList;
/**
 * Escreva uma descrição da classe Zoo aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Zoo
{
    private ArrayList<Animal> animais;
    

    /**
     * Construtor para objetos da classe Zoo
     */
    public Zoo()
    {
        animais = new ArrayList<Animal>();
        
    }
    
    public void adicionaAve(String nome, String especie, int qtdPatas, String som, String voo){
        Ave ave = new Ave(nome, especie, qtdPatas, som, voo);
        
        animais.add(ave);
    }
    
    public void adicionaPelos(String nome, String especie, int qtdPatas, String som, String cor){
        Pelos pelo = new Pelos(nome, especie, qtdPatas, som, cor);
        
        animais.add(pelo);
    }
    
    public String getListaAnimais() {
        String descricao = "Animais";
        for (Animal a: animais) {
            descricao += "\n" + a.getDescricaoAnimal();
        }
        return descricao;
    }
    
    public String getSom(String nome){
        String descricao = " ";
        
        for (Animal a: animais) {
            if(a.getNome().equals(nome)){
                descricao += a.getSom();
            }
        }
        return descricao;
    }
    
    
    public String getDescricao(String nomeAnimal){
        String descricao = " ";
        
        for (Animal a: animais) {
            if(a.getNome().equals(nomeAnimal)){
                descricao += a.getDescricaoLonga();
            }
        }
        return descricao;
    }
    
    
    public boolean consultaPelo(String nomeAnimal){
        Animal animais = getPelos(nomeAnimal);
        if(animais != null){
            return animais.getConfirma(nomeAnimal);
        }else{
            return false;
        }
    }
    
    
    private Animal getPelos(String nomeAnimal){
        
        for (Animal a: animais) {
            if(a.getNome().equals(nomeAnimal)){
                return a;
            }
        }
        return null;
    }

}
