package br.com.devti.abs.core.entity;

import java.util.Objects;

public class RecursoEntity {
	
	private Long codigo;
	private String nomeRecurso;
	private String Caminhotela;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNomeRecurso() {
		return nomeRecurso;
	}
	public void setNomeRecurso(String nomeRecurso) {
		this.nomeRecurso = nomeRecurso;
	}
	public String getCaminhotela() {
		return Caminhotela;
	}
	public void setCaminhotela(String caminhotela) {
		Caminhotela = caminhotela;
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
		RecursoEntity other = (RecursoEntity) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
	
	

}
