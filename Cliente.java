
/**
 * Classe criada para tratar os dados do titular da conta.
 * 
 * @author Sérgio Luiz Camargo Peres
 * @version 1.0
 */
public class Cliente
{
    private String nome;
    private String cpf;
       
    /**
     * Construtor da classe cliente
     */
    public Cliente(String umNome, String umCpf)
    {
        nome = umNome;
        cpf = umCpf;
    }
    
    /**
     *  Método para retornar o nome do cliente.
     */
    public String getNome()
    {
        //Retorna o nome do cliente
        return nome;
    }
    
     /**
     *  Método para retornar o cpf do cliente.
     */
    public String getCpf()
    {
        //Retorna o cpf do cliente
        return cpf;
    }
}
