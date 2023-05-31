
/**
 * Escreva uma descrição da classe Medalhas aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class MedalhasPais
{
    private int nroOuros;
    private int nroPratas;
    private int nroBronzes;

    public MedalhasPais()
    {
        nroOuros = 0;
        nroPratas = 0;
        nroBronzes = 0;        
    }
    
    public MedalhasPais(int ouro, int prata, int bronze)
    {  
        nroOuros = ouro;
        nroPratas = prata;
        nroBronzes = bronze;        
    }
    
    public int pontuação()
    {
        int pontuação = 0;
        pontuação = nroOuros * 10 + nroPratas * 5 + nroBronzes * 1;
        return pontuação;
    }
    
    public void medalhaOuro(int quantidade)
    {
        nroOuros = nroOuros + quantidade;
    }
    
    public void medalhaPrata(int quantidade)
    {
        nroPratas = nroPratas + quantidade;
    }
    
    public void medalhaBronze(int quantidade)
    {
        nroBronzes = nroBronzes + quantidade;
    }

   
}
