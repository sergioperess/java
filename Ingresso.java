public class Ingresso {

   private int dia;

   private int hora;

   private String estadio;

   private String setor;

   private int cadeira;
   
   private String esporte;


   public Ingresso(String esporte) {

      this.esporte = esporte;

   }
   
   public void definirEstadio(String campo){
       estadio = campo;       
   }

   public void definirHorario(int d, int h) {

      dia = d;

      hora = h;

   }

   public void definirLocal(String setor, int cadeira) {

      this.setor = setor;

      this.cadeira = cadeira;

   }
   
   public void getTextoIngresso(){
       System.out.println("Esporte: " + esporte);
       System.out.println("Local: " + estadio);
       System.out.println("Dia: " + dia);
       System.out.println("Hora: " + hora + " h");
       System.out.println("Setor: " + setor);
       System.out.println("Cadeira: " + cadeira);
       
   }

   public void confirmarCompra() {
       System.out.println("Compra confirmada com sucesso");
   }

}