package vo;

public class Pergunta {
	private int idResposta;
	private String conteudoPergunta;
	private Categoria categoriaPergunta;
	private Usuario usuarioPergunta;
	
	public Pergunta() {
		
	}
	
	public Pergunta(String conteudoPergunta, Usuario usuarioPergunta) {
		this.setConteudoPergunta(conteudoPergunta);
		this.setUsuarioPergunta(usuarioPergunta);
	}

	public void setIdResposta(int idResposta) {
		this.idResposta = idResposta;
	}
	
	public int getIdResposta() {
		return idResposta;
	}
	
	public void setConteudoPergunta(String conteudoPergunta) {
		this.conteudoPergunta = conteudoPergunta;
	}
	
	public String getConteudoPergunta() {
		return conteudoPergunta;
	}
	
	public void setCategoriaPergunta(Categoria categoriaPergunta) {
		this.categoriaPergunta = categoriaPergunta;
	}
	
	public Categoria getCategoriaPergunta() {
		return categoriaPergunta;
	}
	
	public void setUsuarioPergunta(Usuario usuarioPergunta) {
		this.usuarioPergunta = usuarioPergunta;
	}
	
	public Usuario getUsuarioPergunta() {
		return usuarioPergunta;
	}
}
