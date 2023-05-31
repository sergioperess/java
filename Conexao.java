public class Conexao {
    public static void main(String[] args) {
        // Caminho até o banco de dados
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver do bando de dados não localizado");
        }
    }
}