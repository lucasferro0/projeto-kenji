package bo;

import vo.Usuario;
import dao.UsuarioDAO;
import dao.ConexaoMySQL;
import helpers.Crypt;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import errors.*;
public class UsuarioBO {
    private Usuario usuario;

    public UsuarioBO() {
        this.usuario = new Usuario();
	}

    public Boolean mostrar()
    {
        try{
            ConexaoMySQL conMySQL = new ConexaoMySQL();

            Connection con = conMySQL.getCon();
            UsuarioDAO usuarioDAO = new UsuarioDAO(con);

            List<Usuario> usuarios =  usuarioDAO.listAll();

            con.close();

            int cont = 1;
            for (Usuario usuario : usuarios) {
                System.out.println("USUÁRIO " + cont + "\n");
                System.out.println("Login: " + usuario.getUsername());
                System.out.println("Senha: " + usuario.getSenha());
                System.out.println("E-mail: " + usuario.getEmail());
                System.out.println("\n");

                cont+=1;
            }

            return true;
        }catch(Exception e){
            System.out.println("Exception in file UsuarioBO: " + e.getMessage());

            return false;
        }
    }

    public Boolean salvar(String username, String senha, String email)
    {
        try{
            if (username == null){
                throw new Required("O username é obrigatório.");
            }else if(senha == null){
                throw new Required("A senha é obrigatória.");
            }else if (email == null){
                throw new Required("O email é obrigatório.");
            }

            ConexaoMySQL connector = new ConexaoMySQL();

            Crypt crypt = new Crypt();
		    String senhaHashed = crypt.codificar(senha);

            this.usuario
            .setUsername(username)
            .setSenha(senhaHashed)
            .setEmail(email);

            Connection con = connector.getCon(); // Abre a conexão
            UsuarioDAO usuarioDAO = new UsuarioDAO(con);

            connector.beginTransaction();

            Boolean wasInserted = usuarioDAO.insert(this.usuario);

            if (! wasInserted){
                connector.fechar();

                return false;
            }

            connector.commit();

            connector.fechar(); // Fecha a conexão

            System.out.println("Usuário cadastrado com sucesso.");

            return true;
        }catch(Exception e){
            System.out.println("Exception in file UsuarioBO, function store() - " + e.getMessage());

            return false;
        }
    }

    public Boolean deletar(int id)
    {
        try{
            
            if (id <= 0){
                throw new InvalidArgument("Id fornecido inválido.");
            }

            ConexaoMySQL connector = new ConexaoMySQL();

            Connection con = connector.getCon(); // Abre a conexão
            UsuarioDAO usuarioDAO = new UsuarioDAO(con);

            usuario = usuarioDAO.findById(id);
            if (usuario == null){
                throw new InvalidArgument("Erro ao deletar usuário.");
            }

            connector.beginTransaction();

            usuarioDAO.delete(id);

            connector.commit();

            connector.fechar(); // Fecha a conexão

            System.out.println("Usuário deletado com sucesso.");

            return true;
        }catch(Exception e){
            System.out.println("Exception in file UsuarioBO, function destroy() - " + e.getMessage());

            return false;
        }
    }
}
