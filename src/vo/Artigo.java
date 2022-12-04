package vo;

public class Artigo {
	private int idArtigo;
	private String tituloArtigo;
	private String conteudoArtigo;
	private Categoria categoriaArtigo;
	private Usuario usuarioArtigo;
	
	public Artigo() {
		
	}
	
	public Artigo(String tituloArtigo, String conteudoArtigo, Usuario usuarioArtigo){
		this.setTituloArtigo(tituloArtigo);
		this.setConteudoArtigo(conteudoArtigo);
		this.setUsuarioArtigo(usuarioArtigo);
	}
	
	public int getIdArtigo() {
		return idArtigo;
	}

	public void setIdArtigo(int idArtigo) {
		this.idArtigo = idArtigo;
	}

	public String getTituloArtigo() {
		return tituloArtigo;
	}

	public void setTituloArtigo(String tituloArtigo) {
		this.tituloArtigo = tituloArtigo;
	}

	public String getConteudoArtigo() {
		return conteudoArtigo;
	}

	public void setConteudoArtigo(String conteudoArtigo) {
		this.conteudoArtigo = conteudoArtigo;
	}
	

	public Categoria getCategoriaArtigo() {
		return categoriaArtigo;
	}

	public void setCategoriaArtigo(Categoria categoriaArtigo) {
		this.categoriaArtigo = categoriaArtigo;
	}

	
	public Usuario getUsuarioArtigo() {
		return usuarioArtigo;
	}
	

	public void setUsuarioArtigo(Usuario usuarioArtigo) {
		this.usuarioArtigo = usuarioArtigo;
	}	
}
