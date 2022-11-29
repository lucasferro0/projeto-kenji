package vo;

public class Resposta {
	private int idResposta;
	private String conteudoResposta;
	private Pergunta perguntaResposta;
	private Usuario usuarioResposta;
	
	public Resposta() {
		
	}
	
	public Resposta(String conteudoResposta, Pergunta perguntaResposta, Usuario usuarioResposta) {
		this.setConteudoResposta(conteudoResposta);
		this.setPerguntaResposta(perguntaResposta);
		this.setUsuarioResposta(usuarioResposta);
	}

	public void setIdResposta(int idResposta) {
		this.idResposta = idResposta;
	}
	
	public int getIdResposta() {
		return idResposta;
	}
	
	public void setConteudoResposta(String conteudoResposta) {
		this.conteudoResposta = conteudoResposta;
	}
	
	public String getConteudoResposta() {
		return conteudoResposta;
	}
	
	public void setPerguntaResposta(Pergunta perguntaResposta) {
		this.perguntaResposta = perguntaResposta;
	}
	
	public Pergunta getPerguntaResposta() {
		return perguntaResposta;
	}
	
	public void setUsuarioResposta(Usuario usuarioResposta) {
		this.usuarioResposta = usuarioResposta;
	}
	
	public Usuario getUsuarioResposta() {
		return usuarioResposta;
	}

	
}
