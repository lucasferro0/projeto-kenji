package vo;

public class Categoria {
	private int idCategoria;
	private String categoria;
	
	public Categoria() {
		
	}
	
	public Categoria(String categoria) {
		this.setCategoria(categoria);
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public int getIdCategoria() {
		return idCategoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getCategoria() {
		return categoria;
	}
}
