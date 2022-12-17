package bo;

import vo.Usuario;
import dao.UsuarioDAO;
import errors.ValidationException;
import helpers.Crypt;
import dao.ConexaoMySQL;
import java.sql.Connection;
import java.util.List;

public class AuthBO {
    public Boolean login(Usuario usuario) throws Exception
    {
        ConexaoMySQL conector = new ConexaoMySQL();

        Connection con = conector.getCon();
        UsuarioDAO usuarioDAO = new UsuarioDAO(con);

        List<Usuario> usuarios =  usuarioDAO.listAll();

        conector.fechar();

        for (Usuario user : usuarios) {
            if (user.getUsername().equals(usuario.getUsername()) && user.getSenha().equals(this.encode(usuario.getSenha()))){
                return true;
            }
        }

        throw new ValidationException("Login ou senha incorretos.");
    }

    public Boolean logout(Usuario usuario)
    {
        try{
            System.out.println("Logout realizado com sucesso.");

            System.exit(0);

            return true;
        }catch(Exception e){
            System.out.println("Exception in file AuthBO: " + e.getMessage());

            return false;
        }
    }

    public String encode(String senha) throws Exception{
        Crypt crypt = new Crypt();

        return crypt.codificar(senha);
    }
}
