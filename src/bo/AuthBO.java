package bo;

import vo.Usuario;
import vo.interfaces.UsuarioInterface;
import dao.UsuarioDAO;
import errors.ValidationException;
import dao.ConexaoMySQL;
import java.sql.Connection;
import java.util.List;
import vo.interfaces.UsuarioInterface;

public class AuthBO {
    public Boolean login(UsuarioInterface usuario)
    {
        try{
            ConexaoMySQL conector = new ConexaoMySQL();

            Connection con = conector.getCon();
            UsuarioDAO usuarioDAO = new UsuarioDAO(con);

            List<Usuario> usuarios =  usuarioDAO.listAll();

            conector.fechar();

            for (Usuario user : usuarios) {
                if (user.getUsername() == usuario.getUsername() && user.getSenha() == usuario.getSenha()){
                    System.out.println("Login efetuado com sucesso.");

                    return true;
                }
            }

            throw new ValidationException("Login ou senha incorretos.");

        }catch(Exception e){
            System.out.println("Exception in file UsuarioBO: " + e.getMessage());

            return false;
        }
    }

    public Boolean logout(Usuario usuario)
    {
        try{
            System.out.println("Logout realizado com sucesso.");

            System.exit(0);

            return true;
        }catch(Exception e){
            System.out.println("Exception in file UsuarioBO: " + e.getMessage());

            return false;
        }
    }
}
