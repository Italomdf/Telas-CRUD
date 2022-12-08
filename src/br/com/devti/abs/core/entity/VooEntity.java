package br.com.devti.abs.core.entity;

import java.util.Objects;

public class VooEntity {
	
	private String data;
	private String destino;
	private String origem;
	private String numeroVoo;
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getNumeroVoo() {
		return numeroVoo;
	}
	public void setNumeroVoo(String numeroVoo) {
		this.numeroVoo = numeroVoo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(numeroVoo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VooEntity other = (VooEntity) obj;
		return Objects.equals(numeroVoo, other.numeroVoo);
	}
	

}
