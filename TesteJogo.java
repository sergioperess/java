
/**
 * Classe criada para facilitar a execucao do Jogo
 * 
 * @author Sérgio Luiz Camargo Peres 
 * @version 28/01/2022
 */
class TesteJogo
{    
    Nave nave;
    Inimigo inimigo;
    Placar placar;
    Cenario cenario;
    String nome = "Nave1";
    

    
    TesteJogo()
    {
        nave = new Nave();
        nave.alterarNome(nome);
        inimigo = new Inimigo();
        placar = new Placar();                
        cenario = new Cenario(nave, inimigo, placar);
        
    
        
        cenario.executarLoopDeJogo();
    }
}
