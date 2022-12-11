package vo.interfaces;

public interface UsuarioInterface {
	public int getIsAdmin();

    public UsuarioInterface setIdUsuario(int idUsuario);
	
	public int getIdUsuario();
	
	public UsuarioInterface setUsername(String username);
	
	public String getUsername();
	
	public UsuarioInterface setEmail(String email);
	
	public String getEmail();
	
	public UsuarioInterface setSenha(String senha);
	
	public String getSenha();
	
	public UsuarioInterface setBiografia(String biografia);
	
	public String getBiografia();
	
	public UsuarioInterface setLinkedin(String linkedin);
	
	public String getLinkedin();
	
	public UsuarioInterface setGithub(String github);
	
	public String getGithub();
}
