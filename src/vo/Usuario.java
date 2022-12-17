package vo;
public class Usuario{
	private int isAdmin = 0; // 0 ou 1
	private int idUsuario;
	private String username = null;
	private String email = null;
	private String senha = null;
	private String biografia = null;
	private String linkedin = null;
	private String github = null;

	public Usuario(){

	}
	
	public Usuario (String username, String email, String senha) {
		this.setUsername(username);
		this.setEmail(email);
		this.setSenha(senha);
	}

	public int getIsAdmin() {
		return this.isAdmin;
	}

	public int setIsAdmin(int isAdmin) {
		return this.isAdmin = isAdmin;
	}

	public Usuario setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;

		return this;
	}
	
	public int getIdUsuario() {
		return this.idUsuario;
	}
	
	public Usuario setUsername(String username) {
		this.username = username;

		return this;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public Usuario setEmail(String email) {
		this.email = email;

		return this;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public Usuario setSenha(String senha) {
		this.senha = senha;

		return this;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public Usuario setBiografia(String biografia) {
		this.biografia = biografia;

		return this;
	}
	
	public String getBiografia() {
		return this.biografia;
	}
	
	public Usuario setLinkedin(String linkedin) {
		this.linkedin = linkedin;

		return this;
	}
	
	public String getLinkedin() {
		return this.linkedin;
	}
	
	public Usuario setGithub(String github) {
		this.github = github;

		return this;
	}
	
	public String getGithub() {
		return this.github;
	}


}
