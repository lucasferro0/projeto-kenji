import dao.ConexaoMySQL;
import vo.Usuario;
import bo.UsuarioBO;

public class App {
    public static void main(String[] args) throws Exception {
        ConexaoMySQL conector = new ConexaoMySQL();

        conector.getCon();

        Usuario usuario = new Usuario();
        usuario
        .setUsername("teste")
        .setEmail("teste@gmail.com")
        .setSenha("sasdas");
        
        UsuarioBO usuarioBO = new UsuarioBO();
        Boolean wasRight = usuarioBO.salvar(usuario);

        System.out.println(wasRight);
    }
}
