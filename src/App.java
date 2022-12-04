import dao.ConexaoMySQL;

public class App {
    public static void main(String[] args) throws Exception {
        ConexaoMySQL conector = new ConexaoMySQL();

        conector.getCon();

        System.out.println(conector.fechar());

        System.out.println(conector.connection == null);
    }
}
