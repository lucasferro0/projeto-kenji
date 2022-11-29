package vo;

import java.util.List;

public class Grupo {
	private int idGrupo;
	private String nomeGrupo;
	private String descricaoGrupo;
	private boolean privado;
	private Usuario criadorGrupo;
	private List<Usuario> membrosGrupo;
	
	public Grupo() {
		
	}
	
	public Grupo(String nomeGrupo, String descricaoGrupo, boolean privado, Usuario criadorGrupo, List<Usuario> membrosGrupo) {
		this.setNomeGrupo(nomeGrupo);
		this.setDescricaoGrupo(descricaoGrupo);
		this.setPrivado(privado);
		this.setCriadorGrupo(criadorGrupo);
		this.setMembrosGrupo(membrosGrupo);
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

	public String getDescricaoGrupo() {
		return descricaoGrupo;
	}

	public void setDescricaoGrupo(String descricaoGrupo) {
		this.descricaoGrupo = descricaoGrupo;
	}

	public boolean isPrivado() {
		return privado;
	}

	public void setPrivado(boolean privado) {
		this.privado = privado;
	}

	public Usuario getCriadorGrupo() {
		return criadorGrupo;
	}

	public void setCriadorGrupo(Usuario criadorGrupo) {
		this.criadorGrupo = criadorGrupo;
	}

	public List<Usuario> getMembrosGrupo() {
		return membrosGrupo;
	}

	public void setMembrosGrupo(List<Usuario> membrosGrupo) {
		this.membrosGrupo = membrosGrupo;
	}
}
	
