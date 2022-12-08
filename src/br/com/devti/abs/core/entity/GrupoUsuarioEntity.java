package br.com.devti.abs.core.entity;

import java.util.Objects;

public class GrupoUsuarioEntity {
	
	private Long codigo;
	private String nomeGrupo;
	private String acesso;
	
	
	public String getAcesso() {
		return acesso;
	}
	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNomeGrupo() {
		return nomeGrupo;
	}
	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoUsuarioEntity other = (GrupoUsuarioEntity) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	

}
