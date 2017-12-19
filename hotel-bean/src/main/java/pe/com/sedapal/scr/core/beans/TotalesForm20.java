package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class TotalesForm20 extends BaseBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer tipo;
	private Integer coliTotales;
	private Integer coliTermoTolerantes;
	private Integer heterotroficas;
	private String mes;
	/**
	 * @return the tipo
	 */
	public Integer getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * @return the coliTotales
	 */
	public Integer getColiTotales() {
		return coliTotales;
	}
	/**
	 * @param coliTotales the coliTotales to set
	 */
	public void setColiTotales(Integer coliTotales) {
		this.coliTotales = coliTotales;
	}
	/**
	 * @return the coliTermoTolerantes
	 */
	public Integer getColiTermoTolerantes() {
		return coliTermoTolerantes;
	}
	/**
	 * @param coliTermoTolerantes the coliTermoTolerantes to set
	 */
	public void setColiTermoTolerantes(Integer coliTermoTolerantes) {
		this.coliTermoTolerantes = coliTermoTolerantes;
	}
	/**
	 * @return the heterotroficas
	 */
	public Integer getHeterotroficas() {
		return heterotroficas;
	}
	/**
	 * @param heterotroficas the heterotroficas to set
	 */
	public void setHeterotroficas(Integer heterotroficas) {
		this.heterotroficas = heterotroficas;
	}
	/**
	 * @return the mes
	 */
	public String getMes() {
		return mes;
	}
	/**
	 * @param mes the mes to set
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "TotalesForm20 [tipo=" + tipo + ", coliTotales=" + coliTotales + ", coliTermoTolerantes="
				+ coliTermoTolerantes + ", heterotroficas=" + heterotroficas + ", mes=" + mes + "]";
	}
	
}
