package bo;

import vo.Usuario;
import dao.UsuarioDAO;
import dao.ConexaoMySQL;
import helpers.Crypt;
import java.sql.Connection;
import java.util.List;
import errors.*;
public class UsuarioBO {
    public Boolean mostrar() throws Exception
    {
        ConexaoMySQL conector = new ConexaoMySQL();

        Connection con = conector.getCon();
        UsuarioDAO usuarioDAO = new UsuarioDAO(con);

        List<Usuario> usuarios =  usuarioDAO.listAll();

        conector.fechar();

        int cont = 1;
        for (Usuario usuario : usuarios) {
            System.out.println("USUÁRIO " + cont + "\n");
            System.out.println("Login: " + usuario.getUsername());
            System.out.println("E-mail: " + usuario.getEmail());
            System.out.println("\n");

            cont+=1;
        }

        return true;
    }

    public Boolean salvar(Usuario usuario) throws Exception
    {
        if (usuario.getUsername() == null){
            throw new ValidationException("O username é obrigatório.");
        }else if(usuario.getSenha() == null){
            throw new ValidationException("A senha é obrigatória.");
        }else if (usuario.getEmail() == null){
            throw new ValidationException("O email é obrigatório.");
        }

        ConexaoMySQL connector = new ConexaoMySQL();

        Crypt crypt = new Crypt();
        String senhaHashed = crypt.codificar(usuario.getSenha());
        usuario.setSenha(senhaHashed);

        Connection con = connector.getCon(); // Abre a conexão
        UsuarioDAO usuarioDAO = new UsuarioDAO(con);

        connector.beginTransaction();

        Boolean wasInserted = usuarioDAO.insert(usuario);

        if (! wasInserted){
            connector.fechar();

            return false;
        }

        connector.commit();

        connector.fechar(); // Fecha a conexão

        return true;
    }

    public Boolean deletar(int id)
    {
        try{
            
            if (id <= 0){
                throw new InvalidArgumentException("Id fornecido inválido.");
            }

            ConexaoMySQL connector = new ConexaoMySQL();

            Connection con = connector.getCon(); // Abre a conexão
            UsuarioDAO usuarioDAO = new UsuarioDAO(con);

            Usuario usuario = usuarioDAO.findById(id);
            if (usuario == null){
                throw new InvalidArgumentException("Erro ao deletar usuário.");
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
