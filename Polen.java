
/**
 * Escreva uma descrição da classe Polen aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Polen
{
    private String nome;
    private int quantidade;    

    /**
     * Construtor para objetos da classe Polen
     */
    public Polen(String nome, int numero)
    {
        this.nome = nome;
        quantidade = numero;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getQtd(){
        return quantidade;
    }
    
}

    
