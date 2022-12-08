package br.com.devti.abs.core.entity;

import java.util.Objects;

public class ReservaEntity {
	
	private String codigoReserva;
	private AssentoEntity asssento;
	private AviaoEntity aviao;
	private PassageiroEntity passageiro;
	private VooEntity voo;
	
	
	public String getCodigoReserva() {
		return codigoReserva;
	}
	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}
	public AssentoEntity getAsssento() {
		return asssento;
	}
	public void setAsssento(AssentoEntity asssento) {
		this.asssento = asssento;
	}
	public AviaoEntity getAviao() {
		return aviao;
	}
	public void setAviao(AviaoEntity aviao) {
		this.aviao = aviao;
	}
	public PassageiroEntity getPassageiro() {
		return passageiro;
	}
	public void setPassageiro(PassageiroEntity passageiro) {
		this.passageiro = passageiro;
	}
	public VooEntity getVoo() {
		return voo;
	}
	public void setVoo(VooEntity voo) {
		this.voo = voo;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(codigoReserva);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservaEntity other = (ReservaEntity) obj;
		return Objects.equals(codigoReserva, other.codigoReserva);
	}
	
	
	
}
