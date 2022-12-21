package vo;

public class Pergunta{
	private int idPergunta;
	private String titulo = null;
	private String conteudoPergunta = null;
	private Usuario usuario = null;
	
	public Pergunta() {
		
	}
	
	public Pergunta(String conteudoPergunta, Usuario usuarioPergunta) {
		this.setConteudoPergunta(conteudoPergunta);
	}

	public Pergunta setIdPergunta(int idPergunta) {
		this.idPergunta = idPergunta;

		return this;
	}
	
	public int getIdPergunta() {
		return idPergunta;
	}

	public Pergunta setTitulo(String titulo){
		this.titulo = titulo;

		return this;
	}

	public String getTitulo(){
		return this.titulo;
	}
	
	public Pergunta setConteudoPergunta(String conteudoPergunta) {
		this.conteudoPergunta = conteudoPergunta;

		return this;
	}
	
	public String getConteudoPergunta() {
		return conteudoPergunta;
	}
	
	public Pergunta setUsuario(Usuario usuario) {
		this.usuario = usuario;

		return this;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
}
