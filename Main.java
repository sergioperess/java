import java.util.Scanner;

public class Main
{
    private static Ingresso ingresso;
    
    public static void main(String[] args)
    {   
        
        
        Scanner entrada = new Scanner(System.in);
        
        
        int aux;
            do{
             aux = exibirMenu();
                if(aux == 1){   
                System.out.println("Qual esporte gostaria de assistir");
                String esporte = entrada.next();
                ingresso = new Ingresso(esporte);
                
                System.out.println("Qual estadio deseja ir");
                String estadio = entrada.next();
                ingresso.definirEstadio(estadio);
            
                System.out.println("Definir data: ");
                System.out.print("Dia: ");
                int d = entrada.nextInt();
        
                System.out.print("Hora: ");
                int h = entrada.nextInt();
        
                ingresso.definirHorario(d, h);
        
                System.out.println("Definir o local que ficará no estádio: ");
                System.out.print("Setor: ");
                String local = entrada.next();
        
                System.out.print("Cadeira: ");
                int cadeira = entrada.nextInt();
        
                ingresso.definirLocal(local, cadeira);
            
                System.out.println("Ingresso comprado com sucesso");
                ingresso.confirmarCompra();
            }else if(aux == 2){
                System.out.println("Seu ingresso está: ");
                ingresso.getTextoIngresso();
            }else if(aux == 3){
                System.out.println("Até logo");
            }
        
        }while(aux != 3);             
        
    }
    
    private static int exibirMenu()
    {
        System.out.println("\n");
        System.out.println("1 - Comprar ingresso");
        System.out.println("2 - Informações do ingresso");
        System.out.println("3 - Sair");
        
        System.out.println("\nDigite a opção desejada: ");
        
        //Objeto da classe Scanner para pedir a entrada do usuário
        Scanner entrada = new Scanner(System.in);
        //Pede entrada pro usuário
        int opcao = entrada.nextInt();
        //Retorna a entrada
        return opcao;   

    
    }
}
