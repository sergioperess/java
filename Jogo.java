/**
 *  Essa eh a classe principal da aplicacao "World of Zull".
 *  "World of Zuul" eh um jogo de aventura muito simples, baseado em texto.
 *  Usuarios podem caminhar em um cenario. E eh tudo! Ele realmente
 *  precisa ser estendido para fazer algo interessante!
 * 
 *  Para jogar esse jogo, crie uma instancia dessa classe e chame o metodo
 *  "jogar".
 * 
 *  Essa classe principal cria e inicializa todas as outras: ela cria os
 *  ambientes, cria o analisador e comeca o jogo. Ela tambeme avalia e 
 *  executa os comandos que o analisador retorna.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido por Julio Cesar Alves)
 * @version 2011.07.31 (2016.02.01)
 */

public class Jogo 
{
    private Analisador analisador;
    private Ambiente ambienteAtual;
    private Abelha abelha;
    
        
    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo() 
    {
        criarAmbientes();
        analisador = new Analisador();
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes()
    {
        Ambiente fora, colmeia, campodeflores, animais, rio, cachoeira;
      
        // cria os ambientes
        fora = new Ambiente("do lado de fora da colmeia");
        colmeia = new Ambiente("na colmeia. Conseguiu encontra-la.");
        campodeflores = new Ambiente("no campo cheio de flores lindas", new Polen("Polen",2));
        animais = new Ambiente("no sítio cheio de animais");
        rio = new Ambiente("no rio da fazenda próximo à colmeia");
        cachoeira = new Ambiente("na cachoeira do rio", new Polen("Folha", 1));
        
        // inicializa as saidas dos ambientes
        fora.ajustarSaida("leste", colmeia);
        fora.ajustarSaida("sul", campodeflores);
        fora.ajustarSaida("oeste", animais);
        
        colmeia.ajustarSaida("oeste", fora);
        
        animais.ajustarSaida("leste", fora);
        
        campodeflores.ajustarSaida("norte", fora);
        campodeflores.ajustarSaida("leste", rio);
        
        rio.ajustarSaida("oeste", campodeflores);
        rio.ajustarSaida("baixo", cachoeira);
        
        cachoeira.ajustarSaida("cima", rio);

        ambienteAtual = fora;  // o jogo comeca do lado de fora
    }

    /**
     *  Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar() 
    {            
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nos repetidamente lemos
        // comandos e os executamos ate o jogo terminar.
                
        boolean terminado = false;
        while (! terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Ate mais!");
    }
    
    // Esse método foi utilizado para resolver o problema de duplicação do código.
    
    /**
     *  Método para exibir onde estamos no jogo.
     */
    private void exibirLocalizacaoAtual(){
        System.out.println("Voce esta " + ambienteAtual.getDescricao());
    
        System.out.print("Saidas: " + ambienteAtual.getSaidas());

        System.out.println();
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas()
    {
        System.out.println();
        System.out.println("Bem-vindo a Abeeeelhemo!");
        System.out.println("Abeeeelhemo eh um novo jogo de aventura, onde você deve ajudar a abelhinha perdida encontrar a colmeia.");
        System.out.println("Digite 'ajuda' se voce precisar de ajuda.");
        System.out.println();
        
        exibirLocalizacaoAtual();
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando) 
    {
        boolean querSair = false;

        if(comando.ehDesconhecido()) {
            System.out.println("Eu nao entendi o que voce disse...");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        }
        else if (palavraDeComando.equals("ir")) {
            irParaAmbiente(comando);
        }
        else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        }else if (palavraDeComando.equals("observar")) {
            observar(comando);
        }else if (palavraDeComando.equals("pegar")) {
            pegarItem(comando);                
        }

        return querSair;
    }
    
    private void observar(Comando comando){
        exibirLocalizacaoAtual();
        System.out.println(ambienteAtual.getDescricaoItem());
    }

    // Implementacoes dos comandos do usuario
    private void pegarItem(Comando comando){
        if(!comando.temSegundaPalavra()) {
            // se nao ha segunda palavra, nao sabemos qual item pegar...
            System.out.println("Pegar o que?");
            return;           
            
        }
        
        String item = comando.getSegundaPalavra();
        
        if(ambienteAtual.getTesteItem() == false){
            System.out.println("Não há itens nesse local.");
        }
        else if(item.equals(ambienteAtual.consultaItem())){
            System.out.println("Você pegou o(a) " + ambienteAtual.consultaItem() + " do local.");
            ambienteAtual.removeItem();
        }else{
            System.out.println("Esse item não está no ambiente.");
        }
    }

    /**
     * Printe informacoes de ajuda.
     * Aqui nos imprimimos algo bobo e enigmatico e a lista de 
     * palavras de comando
     */
    private void imprimirAjuda() 
    {
        System.out.println("A abelhinha esta perdida na fazenda. Precisamos ajuda-la a encontrar a sua colmeia");
        System.out.println("Você não esta muito longe.");
        System.out.println();
        System.out.println("Suas palavras de comando sao:");
        System.out.println("   " + analisador.getComandos());
    }

    /** 
     * Tenta ir em uma direcao. Se existe uma saida entra no 
     * novo ambiente, caso contrario imprime mensagem de erro.
     */
    private void irParaAmbiente(Comando comando) 
    {
        if(!comando.temSegundaPalavra()) {
            // se nao ha segunda palavra, nao sabemos pra onde ir...
            System.out.println("Ir pra onde?");
            return;
        }

        String direcao = comando.getSegundaPalavra();

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = ambienteAtual.getSaida(direcao);

        if (proximoAmbiente == null) {
            System.out.println("Nao ha passagem!");
        }
        else {
            ambienteAtual = proximoAmbiente;
            
            exibirLocalizacaoAtual();
        }
    }

    /** 
     * "Sair" foi digitado. Verifica o resto do comando pra ver
     * se nos queremos realmente sair do jogo.
     * @return true, se este comando sai do jogo, false, caso contrario
     */
    private boolean sair(Comando comando) 
    {
        if(comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        }
        else {
            return true;  // sinaliza que nos queremos sair
        }
    }
}
