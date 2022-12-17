package bo;

import dao.ConexaoMySQL;
import helpers.Crypt;
import vo.Pergunta;
import java.sql.Connection;
import java.util.List;
import errors.*;
import dao.PerguntaDAO;
public class PerguntaBO {
    public Boolean mostrar() throws Exception
    {
        ConexaoMySQL conector = new ConexaoMySQL();

        Connection con = conector.getCon();
        PerguntaDAO perguntaDAO = new PerguntaDAO(con);

        List<Pergunta> perguntas =  perguntaDAO.listAll();

        conector.fechar();

        int cont = 1;
        for (Pergunta pergunta : perguntas) {
            System.out.println("Artigo " + cont);
            System.out.println("Título: " + pergunta.getTitulo());
            System.out.println("Conteúdo: " + pergunta.getConteudoPergunta());
            System.out.println("Autor: " + pergunta.getUsuario().getUsername());
            System.out.println("\n");

            cont+=1;
        }

        return true;
    }

    public Boolean salvar(Pergunta pergunta) throws Exception
    {
        if (pergunta.getTitulo() == null){
            throw new ValidationException("O Titulo é obrigatório.");
        }else if(pergunta.getConteudoPergunta() == null){
            throw new ValidationException("O conteúdo é obrigatória.");
        }else if (pergunta.getUsuario() == null){
            throw new ValidationException("O autor é obrigatório.");
        }

        ConexaoMySQL connector = new ConexaoMySQL();

        Connection con = connector.getCon(); // Abre a conexão
        PerguntaDAO perguntaDAO = new PerguntaDAO(con);

        connector.beginTransaction();

        Boolean wasInserted = perguntaDAO.insert(pergunta);

        if (! wasInserted){
            connector.fechar();

            return false;
        }

        connector.commit();

        connector.fechar(); // Fecha a conexão

        return true;
    }
}
