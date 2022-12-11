package vo;

import vo.interfaces.UsuarioInterface;

public class UsuarioAdmin implements UsuarioInterface{
    private int isAdmin = 1; // 0 ou 1
	private int idUsuario;
	private String username = null;
	private String email = null;
	private String senha = null;
	private String biografia = null;
	private String linkedin = null;
	private String github = null;

	public UsuarioAdmin(){

	}
	
	public UsuarioAdmin (String username, String email, String senha) {
		this.setUsername(username);
		this.setEmail(email);
		this.setSenha(senha);
	}
	
	public int getIsAdmin() {
		return this.isAdmin;
	}

	public UsuarioAdmin setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;

		return this;
	}
	
	public int getIdUsuario() {
		return this.idUsuario;
	}
	
	public UsuarioAdmin setUsername(String username) {
		this.username = username;

		return this;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public UsuarioAdmin setEmail(String email) {
		this.email = email;

		return this;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public UsuarioAdmin setSenha(String senha) {
		this.senha = senha;

		return this;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public UsuarioAdmin setBiografia(String biografia) {
		this.biografia = biografia;

		return this;
	}
	
	public String getBiografia() {
		return this.biografia;
	}
	
	public UsuarioAdmin setLinkedin(String linkedin) {
		this.linkedin = linkedin;

		return this;
	}
	
	public String getLinkedin() {
		return this.linkedin;
	}
	
	public UsuarioAdmin setGithub(String github) {
		this.github = github;

		return this;
	}
	
	public String getGithub() {
		return this.github;
	}
}
