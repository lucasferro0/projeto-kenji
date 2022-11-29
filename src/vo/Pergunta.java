package vo;

public class Pergunta {
	private int idPergunta;
	private String conteudoPergunta;
	private Categoria categoriaPergunta;
	private Usuario usuarioPergunta;
	
	public Pergunta() {
		
	}
	
	public Pergunta(String conteudoPergunta, Usuario usuarioPergunta) {
		this.setConteudoPergunta(conteudoPergunta);
		this.setUsuarioPergunta(usuarioPergunta);
	}

	public void setIdPergunta(int idPergunta) {
		this.idPergunta = idPergunta;
	}
	
	public int getIdPergunta() {
		return idPergunta;
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
