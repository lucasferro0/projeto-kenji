package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Usuario;

public class UsuarioDAO {
	private Connection connection;
	
	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	public boolean insert(Usuario usuario) {
		String sql = "INSERT INTO tbl_usuario(username, email, senha, linkedin, github, biografia) VALUES(?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getUsername());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.setString(4, usuario.getLinkedin());
			stmt.setString(5, usuario.getGithub());
			stmt.setString(6, usuario.getBiografia());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
			//tratar exceção
			return false;		
		}
		
	}
	
	public boolean update(Usuario usuario) {
		String sql = "UPDATE tbl_usuario SET username=?, email=?, senha=?, linkedin=?, github=?, biografia=? WHERE cod_usuario=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getUsername());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.setString(4, usuario.getLinkedin());
			stmt.setString(5, usuario.getGithub());
			stmt.setString(6, usuario.getBiografia());
			stmt.setInt(7, usuario.getIdUsuario());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
			//tratar exceção
			return false;
		}
	}
	
	public boolean delete(Integer id) {
		String sql = "DELETE FROM tbl_usuario WHERE cod_usuario=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			return true;
		} catch (SQLException ex) {
			//tratar exceção
			return false;
		}
	}
	
	public Usuario findById(Integer id) {
		String sql = "SELECT * FROM tbl_usuario WHERE cod_usuario=?";
		Usuario usuario = new Usuario();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			
			usuario.setIdUsuario(resultado.getInt("cod_usuario"));
			usuario.setUsername(resultado.getString("username"));
			usuario.setEmail(resultado.getString("email"));
			usuario.setSenha(resultado.getString("senha"));
			usuario.setLinkedin(resultado.getString("linkedin"));
			usuario.setGithub(resultado.getString("github"));	
			usuario.setBiografia(resultado.getString("biografia"));
		} catch(Exception ex) {
			//tratar exceção
		}
		return usuario;
	}
	
	public List<Usuario> findFilter(String str){
		String sql = "SELECT * FROM tbl_usuario WHERE username LIKE '%?%' OR email LIKE '%?%' OR linkedin LIKE '%?%' OR github LIKE '%?%'";
		List<Usuario> retorno = new ArrayList<>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, str);
			stmt.setString(2,str);
			stmt.setString(3,str);
			stmt.setString(4,str);
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(resultado.getInt("cod_usuario"));
				usuario.setUsername(resultado.getString("username"));
				usuario.setEmail(resultado.getString("email"));
				usuario.setSenha(resultado.getString("senha"));
				usuario.setLinkedin(resultado.getString("linkedin"));
				usuario.setGithub(resultado.getString("github"));
				usuario.setBiografia(resultado.getString("biografia"));
				retorno.add(usuario);
			}
			
		} catch (SQLException ex) {
			//tratar exceção
		}
		return retorno;
	}
	
	public List<Usuario> listAll() {
		String sql = "SELECT * FROM tbl_usuario";
		List<Usuario> retorno = new ArrayList<>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(resultado.getInt("cod_usuario"));
				usuario.setUsername(resultado.getString("username"));
				usuario.setEmail(resultado.getString("email"));
				usuario.setSenha(resultado.getString("senha"));
				usuario.setLinkedin(resultado.getString("linkedin"));
				usuario.setGithub(resultado.getString("github"));
				usuario.setBiografia(resultado.getString("biografia"));
				retorno.add(usuario);
			}
			
		} catch (SQLException ex) {
			// tratar exceção
		}
		return retorno;
	}
}
