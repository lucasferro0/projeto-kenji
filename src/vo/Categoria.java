package vo;

public class Categoria {
	private long idCategoria;
	private String categoria;
	
	public Categoria() {
		
	}
	
	public Categoria(String categoria) {
		this.setCategoria(categoria);
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public long getIdCategoria() {
		return idCategoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getCategoria() {
		return categoria;
	}
}
