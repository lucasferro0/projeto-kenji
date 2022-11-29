package vo;

public class Usuario {
	private int idUsuario;
	private String username;
	private String email;
	private String senha;
	private String biografia;
	private String linkedin;
	private String github;
	
	public Usuario() {
		
	}
	
	public Usuario (String username, String email, String senha) {
		this.setUsername(username);
		this.setEmail(email);
		this.setSenha(senha);
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	
	public String getBiografia() {
		return biografia;
	}
	
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	
	public String getLinkedin() {
		return linkedin;
	}
	
	public void setGithub(String github) {
		this.github = github;
	}
	
	public String getGithub() {
		return github;
	}


}
