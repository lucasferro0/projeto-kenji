import models.ConexaoMySQL;

public class App {
    public static void main(String[] args) throws Exception {
        ConexaoMySQL conector = new ConexaoMySQL();

        System.out.println(conector.getConexaoMySQL());
    }
}
