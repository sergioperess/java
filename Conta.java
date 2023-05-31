import java.util.ArrayList;
/**
 * Criação de uma conta bancária.
 * 
 * @author Sérgio Luiz Camargo Peres
 * @version 1.0
 */
public class Conta
{
    private int numero;
    private static int numeroDaConta = 1000;
    private double saldo;
    private double limite;
    private Cliente cliente;
    
    /**
     * Criando uma nova conta
     */
    public Conta(Cliente usuario, double umLimite)
    { 
        this(usuario, umLimite, 0);
    }    
    
    /**
     * Segundo construtor, com o saldo.
     */
    public Conta(Cliente cliente, double umLimite, double umSaldo)
    {
        numero = numeroDaConta;
        numeroDaConta++;
        saldo = umSaldo;
        limite = umLimite;
        this.cliente = cliente;
    }
    
    /**
     *  Método para retornar o nome do cliente
     */
    public String nomeCliente()
    {
        //Retorna o nome do cliente
        return cliente.getNome();
    }
   
     /**
     *  Mostra o saldo disponivel
     */
    public double getSaldo()
    {
        //Retorna o saldo disponivel.
        return saldo;
    } 
    
    /**
     *  Método para mostrar o limite máximo da conta.
     */
    public double getLimite(){
        //Retorna o limite máximo.
        return limite;
    }
    
    /**
     *  Método para retornar o número da conta.
     */
    public int getConta(){
        //retorna o número da conta
        return numero;
    }
    
    /**
     *  Método para sacar o dinheiro da conta
     */
    public boolean saqueConta(double dinheiro)
    {
        if((saldo - dinheiro) >= limite && dinheiro >=  0){
            saldo = saldo - dinheiro;
            return true;
        }else{            
            return false;
        }
        
    }
    
    /**
     *  Método para retornar o valor que ainda tenho disponivel no banco
     */
    public double resultadoSaque(){
        double aux = saldo - limite;
        return aux;
    }
    
    /**
     *  Método para depositar dinheiro na conta
     */
    public void depositoConta(double dinheiro)
    {
        saldo = saldo + dinheiro;
    }
    
    /**
     *  Método para transferencia entre as contas
     */
    public boolean transferenciaConta(double dinheiro)
    {
        //Essa operação permite a transferencia até o limite das contas, dessa forma, o "limite" é limite de cada conta.
        //A transferencia só é possivel ser feita até o saldo = limite.
        if((saldo - dinheiro) >= limite){
            return true;
        }else{
            return false;
        }
    }
    
}
