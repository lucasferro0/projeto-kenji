package vo;

public class Pergunta {
	private int idPergunta;
	private String titulo;
	private String conteudoPergunta;
	private Usuario usuarioPergunta;
	
	public Pergunta() {
		
	}
	
	public Pergunta(String conteudoPergunta, Usuario usuarioPergunta) {
		this.setConteudoPergunta(conteudoPergunta);
		this.setUsuarioPergunta(usuarioPergunta);
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
	
	public Pergunta setUsuarioPergunta(Usuario usuarioPergunta) {
		this.usuarioPergunta = usuarioPergunta;

		return this;
	}
	
	public Usuario getUsuarioPergunta() {
		return usuarioPergunta;
	}
}
