package br.com.devti.abs.core.entity;

import java.util.Objects;

public class AviaoEntity {
	
	private String marca;
	private String base;
	private String numeroIdentificador;
	private String AnoFabricacao;
	
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNumeroIdentificador() {
		return numeroIdentificador;
	}
	public void setNumeroIdentificador(String numeroIdentificador) {
		this.numeroIdentificador = numeroIdentificador;
	}
	public String getAnoFabricacao() {
		return AnoFabricacao;
	}
	public void setAnoFabricacao(String anoFabricacao) {
		AnoFabricacao = anoFabricacao;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(numeroIdentificador);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AviaoEntity other = (AviaoEntity) obj;
		return Objects.equals(numeroIdentificador, other.numeroIdentificador);
	}
	
	

}
