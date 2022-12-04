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

	public Resposta setIdResposta(int idResposta) {
		this.idResposta = idResposta;

		return this;
	}
	
	public int getIdResposta() {
		return idResposta;
	}
	
	public Resposta setConteudoResposta(String conteudoResposta) {
		this.conteudoResposta = conteudoResposta;

		return this;
	}
	
	public String getConteudoResposta() {
		return conteudoResposta;
	}
	
	public Resposta setPerguntaResposta(Pergunta perguntaResposta) {
		this.perguntaResposta = perguntaResposta;

		return this;
	}
	
	public Pergunta getPerguntaResposta() {
		return perguntaResposta;
	}
	
	public Resposta setUsuarioResposta(Usuario usuarioResposta) {
		this.usuarioResposta = usuarioResposta;

		return this;
	}
	
	public Usuario getUsuarioResposta() {
		return usuarioResposta;
	}

	
}
