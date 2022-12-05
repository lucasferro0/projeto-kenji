import dao.ConexaoMySQL;
import bo.UsuarioBO;

public class App {
    public static void main(String[] args) throws Exception {
        ConexaoMySQL conector = new ConexaoMySQL();

        conector.getCon();

        UsuarioBO usuarioBO = new UsuarioBO();

        Boolean wasRight = usuarioBO.deletar(5);

        System.out.println(wasRight);
    }
}
