package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import errors.*;
import vo.Pergunta;

public class PerguntaDAO {
	private Connection connection;
	
	public PerguntaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public boolean insert(Pergunta pergunta) throws Exception {
		String sql = "INSERT INTO tbl_pergunta(titulo, conteudo, cod_usuario) VALUES(?,?,?)";

		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, pergunta.getTitulo());
		stmt.setString(2, pergunta.getConteudoPergunta());
		stmt.setInt(3, pergunta.getUsuario().getIdUsuario());
		stmt.execute();

		return true;
		
	}
	
	public boolean update(Pergunta pergunta) {
		String sql = "UPDATE tbl_pergunta SET titulo=?, conteudo=?, cod_usuario=? WHERE cod_pergunta=?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, pergunta.getTitulo());
			stmt.setString(2, pergunta.getConteudoPergunta());
			stmt.setInt(3, pergunta.getUsuario().getIdUsuario());
            stmt.setInt(4, pergunta.getIdPergunta());
			stmt.execute();

			return true;
		}catch(SQLException e){
            System.out.println("SQLException in file PerguntaDAO, function update() - " + e.getMessage());

            return false;
        }catch(Exception e){
            System.out.println("Exception in file PerguntaDAO, function update() - " + e.getMessage());

            return false;
        }
	}
	
	public boolean delete(Integer id) {
		String sql = "DELETE FROM tbl_pergunta WHERE cod_pergunta=?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			return true;
		}catch(SQLException e){
            System.out.println("SQLException in file PerguntaDAO, function delete() - " + e.getMessage());

            return false;
        }catch(Exception e){
            System.out.println("Exception in file PerguntaDAO, function delete() - " + e.getMessage());

            return false;
        }
	}
	
	public Pergunta findById(Integer id) {
		String sql = "SELECT * FROM tbl_pergunta WHERE cod_pergunta=?";
		Pergunta pergunta = new Pergunta();
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			
			if (!resultado.next()){ // Quando não achar o registro
				throw new NotFoundException("Registro não encontrado.");
			}

			pergunta.setIdPergunta(resultado.getInt("cod_pergunta"));
			pergunta.setTitulo(resultado.getString("titulo"));
			pergunta.setConteudoPergunta(resultado.getString("conteudo"));
			pergunta.setUsuario((new UsuarioDAO(this.connection)).findById(resultado.getInt("cod_usuario")));

			return pergunta;
		}catch(SQLException e){
            System.out.println("SQLException in file PerguntaDAO, function findById() - " + e.getMessage());

            return null;
        }catch(Exception e){
            System.out.println("Exception in file PerguntaDAO, functin findById() - " + e.getMessage());

            return null;
        }
	}
	
	public List<Pergunta> findFilter(String str){
		String sql = "SELECT * FROM tbl_pergunta WHERE titulo LIKE '%?%' OR conteudo LIKE '%?%'";
		List<Pergunta> retorno = new ArrayList<>();
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, str);
			stmt.setString(2, str);
			stmt.setString(3, str);
			stmt.setString(4, str);
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				Pergunta pergunta = new Pergunta();
				pergunta.setIdPergunta(resultado.getInt("cod_pergunta"));
				pergunta.setTitulo(resultado.getString("titulo"));
				pergunta.setConteudoPergunta(resultado.getString("conteudo"));
				pergunta.setUsuario((new UsuarioDAO(this.connection)).findById(resultado.getInt("cod_usuario")));
				retorno.add(pergunta);
			}
			
		}catch(SQLException e){
            System.out.println("SQLException in file PerguntaDAO, function findFilter() - " + e.getMessage());

        }catch(Exception e){
            System.out.println("Exception in file PerguntaDAO, function findFilter() - " + e.getMessage());

        }

		return retorno;
	}
	
	public List<Pergunta> listAll() throws Exception {
		String sql = "SELECT * FROM tbl_pergunta";
		List<Pergunta> retorno = new ArrayList<>();
		
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		ResultSet resultado = stmt.executeQuery();
		while(resultado.next()) {
			Pergunta pergunta = new Pergunta();
			pergunta.setIdPergunta(resultado.getInt("cod_pergunta"));
			pergunta.setTitulo(resultado.getString("titulo"));
			pergunta.setConteudoPergunta(resultado.getString("conteudo"));
			pergunta.setUsuario((new UsuarioDAO(this.connection)).findById(resultado.getInt("cod_usuario")));
			retorno.add(pergunta);
		}

		return retorno;
	}
}

