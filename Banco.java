import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Essa classe é onde está o menu de opções.
 * 
 * @author Sérgio Luiz Camargo Peres
 * @version 1.0
 */
public class Banco
{
    
    private static Conta conta;
    private static ArrayList<Conta> contas;
    
    public static void main(String[] args)
    {
        System.out.println("Tela princial do Banco");
        
        contas = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();
        
        int opcao;
        do{
            opcao = exibirMenu();
            
            if(opcao == 1){
                System.out.println("Criar conta");
                System.out.print("\n");
                
                System.out.println("Conta 1");
                
                //Nome do usuário
                System.out.println("Digite seu nome:\n");
                String nome = entrada.next();
                
                //Cpf do usuário
                System.out.println("Digite seu cpf:\n");
                String cpf = entrada.next();
                    
                Cliente cliente = new Cliente(nome, cpf);
                
                int limite = -1500;
                
                int contador = avaliaSaldo();
                if(contador == 1){   
                    System.out.println("Digite seu saldo:\n");
                    int saldo = entrada.nextInt();             
                    
                    conta = new Conta(cliente, limite, saldo);
                    contas.add(conta);
                    System.out.println("Conta criada com sucesso.");
                    System.out.println("O número da sua conta é: "+ conta.getConta());
                    System.out.print("\n");
                }else if(contador == 2){
                    conta = new Conta(cliente,limite); 
                    contas.add(conta);
                    
                    System.out.println("Conta criada com sucesso.");
                    System.out.println("O número da sua conta é: "+ conta.getConta());
                    System.out.print("\n");
                }else{
                    System.out.println("Opção inválida");
                }                                 
                                            
            }else if(opcao == 2){
                System.out.println("Consultar saldo");
                int controle;
                System.out.println("Digite o número da conta: ");
                
                boolean contador = false;
    
                controle = entrada.nextInt();
                
                for(int i = 0; i < contas.size(); i++){
                    if(controle == contas.get(i).getConta()){
                        System.out.println(contas.get(i).nomeCliente() + ", seu saldo é: " + contas.get(i).getSaldo());
                        contador = true;
                    }
                }
                if(contador == false){
                    System.out.println("Conta não encontrada!!!");
                }
                
            }else if(opcao == 3){
                System.out.println("Depositar");
                System.out.println("Digite o número da conta que deseja depositar: ");
                int aux = entrada.nextInt();
                
                boolean controle = false;
                for(int i = 0; i < contas.size(); i++){
                    if(aux == contas.get(i).getConta()){
                        System.out.println("Digite o valor que deseja depositar: ");
                        double valor = entrada.nextDouble();
                        if(valor > 0){
                            contas.get(i).depositoConta(valor);
                            System.out.println("Depósito feito com sucesso.");
                            controle = true;
                        }else{
                            System.out.println("Não é permitido depositar valores negativos.");
                            controle = true;
                        }
                        
                    }
                }
                
                if(controle == false){
                    System.out.println("Conta inexistente!!");
                }                
                
            }else if(opcao == 4){
                System.out.println("Sacar");
                System.out.println("Digite o número da conta que deseja sacar: ");
                int aux1 = entrada.nextInt();
                
                boolean controle = false;
                
                for(int i = 0; i < contas.size(); i++){
                    if(aux1 == contas.get(i).getConta()){
                        System.out.println("Digite o valor que deseja sacar: ");
                        double valor = entrada.nextDouble();
                        if(contas.get(i).saqueConta(valor) == true){
                            contas.get(i).getSaldo();
                            System.out.println("Saque feito com sucesso.");
                        }else{
                            System.out.println("Você não possui saldo suficiente para um saque.");
                            System.out.println("Você possui " + contas.get(i).resultadoSaque() + " para sacar.");
                        }
                        controle = true;
                    }
                    
                }   
                
                if(controle == false){
                    System.out.println("Conta inexistente!!");
                }
                   
                
            }else if(opcao == 5){
                System.out.println("Transferência entra contas");
                System.out.print("Conta que vai enviar a transferência: \n");
                int aux = entrada.nextInt();
                
                System.out.print("Conta que irá receber a transferência: \n");
                int aux1 = entrada.nextInt();
                
                boolean controle = false;
                boolean controle1 = false;
                for(int i = 0; i < contas.size(); i++){
                    if(aux == contas.get(i).getConta()){
                        controle = true;
                    }
                    if(aux1 == contas.get(i).getConta()){
                        controle1 = true;
                    }
                }
                if(controle == false){
                    System.out.println("Conta "+ aux +" não encontrada!!!");
                }else if(controle1 == false){
                    System.out.println("Conta "+ aux1 +" não encontrada!!!");
                }else if(controle == false && controle1 == false){
                    System.out.println("Contas não encontradas!!!");
                }
                                
                System.out.print("O valor que deseja transferir: \n");
                double valor = entrada.nextDouble();
                
                if(controle == true && controle1 == true){
                    for(int i = 0; i < contas.size(); i++){
                        if(contas.get(i).getConta() == aux){
                            if(contas.get(i).transferenciaConta(valor) == true){                         
                                System.out.println("Transferência feita com sucesso.");
                                contas.get(i).saqueConta(valor);
                                for(int j = 0; j < contas.size(); j++){
                                    if(contas.get(j).getConta() == aux1){
                                        contas.get(j).depositoConta(valor);
                                    }
                                }
                            }
                            else{
                                System.out.println("Operação inválida (Seu limite é insuficiente).");
                                System.out.println("Você possui " + contas.get(i).resultadoSaque() + " para operações.");
                            }                           
                        }
                    }
                }
                
            }else if(opcao == 6){
                System.out.println("Listar contas");
                System.out.println("Escolha o tipo de listagem: ");
                System.out.println("1 - Número da conta.");
                System.out.println("2 - Nome do cliente.");
                
                int controle = entrada.nextInt();
                            
                if(controle == 1){
                    for(int i = 0; i < contas.size(); i++){
                        System.out.println(contas.get(i).getConta()+ " - " + contas.get(i).nomeCliente());
                    }
                }else if(controle == 2){
                    
                        Comparator <Conta> comparador = new Comparator<>(){
                            @Override
                            public int compare(Conta conta1, Conta conta2){
                            return conta1.nomeCliente().compareTo(conta2.nomeCliente());
                            }
                    };
                    
                    contas.sort(comparador);
                    
                    for(int i = 0; i < contas.size(); i++){
                        System.out.println(contas.get(i).getConta()+ " - " + contas.get(i).nomeCliente());
                    }

                    
                }else{
                    System.out.println("Listagem inexistente!!!!");
                }
                
            }else if(opcao == 7){
                System.out.println("Remover uma conta.");
                System.out.println("Número da conta que deseja remover: ");
                int numero = entrada.nextInt();
                
                boolean controle = false;
                for(int i = 0; i < contas.size(); i++){
                    if(numero == contas.get(i).getConta()){
                        if(contas.get(i).getSaldo() > 0){
                            System.out.println("Você não pode remover contas com saldo disponível.");
                        }else if(contas.get(i).getSaldo() < 0 && contas.get(i).getSaldo() > contas.get(i).getLimite()){
                            System.out.println("Você não pode remover contar com saldo em débito.");
                        }else{
                            System.out.println("Conta removida com sucesso.");
                            contas.remove(i);
                        }
                        controle = true;
                    }
                }
                if(controle == false){
                    System.out.println("Conta "+ numero + " não encontrada.");
                }
                
            }else if(opcao == 8 ){
                System.out.println("Filtar contas");
                System.out.println("Digite um nome ou uma parte do nome para encontrar uma conta.");
                String filtro = entrada.next();
                
                boolean controlador = false;
                
                for(int i = 0; i < contas.size(); i++){
                    if(contas.get(i).nomeCliente().toLowerCase().contains(filtro.toLowerCase())){
                        System.out.println(contas.get(i).getConta()+ " - " + contas.get(i).nomeCliente());
                        controlador = true;
                    }
                }
                if(controlador == false){
                    System.out.println("Não foram encontrados resultados para: " + filtro);        
                }
                
                
            }
            else if(opcao == 9){
                System.out.println("Sair");
                System.out.println("Até mais.");
            }else{
                System.out.println("Digite novamente!");
            }
        
            
        }while(opcao != 9);
        
    }
    
    /**
     *  Método para criar um menu de opções.
     */
    private static int exibirMenu()
    {
        System.out.println("\n");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Consultar saldo");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sacar");
        System.out.println("5 - Transfêrencia");
        System.out.println("6 - Listar contas");
        System.out.println("7 - Remover conta");
        System.out.println("8 - Filtrar contas");
        System.out.println("9 - Sair");
        
        System.out.println("\nDigite a opção desejada: ");
        
        //Objeto da classe Scanner para pedir a entrada do usuário
        Scanner entrada = new Scanner(System.in);
        //Pede entrada pro usuário
        int opcao = entrada.nextInt();
        //Retorna a entrada
        return opcao;
    }
    
    /**
     *  Médoto para utilizar o saldo
     */
    private static int avaliaSaldo()
    {
        System.out.println("Digite 1 para criar conta com saldo inicial: ");
        System.out.println("Digite 2 para criar conta SEM saldo inicial: ");
        Scanner s = new Scanner(System.in);       
        int aux = s.nextInt();
        
        if(aux == 1){
            return 1;
        }else if(aux == 2){
            return 2;
        }else{
            return 0;
        }
    }
    
}
