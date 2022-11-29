package vo;

public class Comentario {
	private String conteudoComentario;
	private Artigo artigoComentario;
	private Usuario usuarioComentario;
	
	public Comentario() {
		
	}
	
	public Comentario(String comentario, Artigo artigoComentario, Usuario usuarioComentario) {
		this.setConteudoComentario(comentario);
		this.setArtigoComentario(artigoComentario);
		this.setUsuarioComentario(usuarioComentario);
	}

	public String getConteudoComentario() {
		return conteudoComentario;
	}

	public void setConteudoComentario(String conteudoComentario) {
		this.conteudoComentario = conteudoComentario;
	}

	public Artigo getArtigoComentario() {
		return artigoComentario;
	}

	public void setArtigoComentario(Artigo artigoComentario) {
		this.artigoComentario = artigoComentario;
	}

	public Usuario getUsuarioComentario() {
		return usuarioComentario;
	}

	public void setUsuarioComentario(Usuario usuarioComentario) {
		this.usuarioComentario = usuarioComentario;
	}
}
