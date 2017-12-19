package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class ReporteEnsayoCloroResult extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer correlativo;
	private Integer puntoMuestra;
	private String puntoDescrip;
	
	private Double temperatura;
	private Double ph;
	private Double dosisClor;
	private Double cloroResidualLibre;
	private Double cloroResidualTotal;
	private Double demandaCloro;
	private Double descripcion;
	/**
	 * @return the correlativo
	 */
	public Integer getCorrelativo() {
		return correlativo;
	}
	/**
	 * @param correlativo the correlativo to set
	 */
	public void setCorrelativo(Integer correlativo) {
		this.correlativo = correlativo;
	}
	/**
	 * @return the puntoMuestra
	 */
	public Integer getPuntoMuestra() {
		return puntoMuestra;
	}
	/**
	 * @param puntoMuestra the puntoMuestra to set
	 */
	public void setPuntoMuestra(Integer puntoMuestra) {
		this.puntoMuestra = puntoMuestra;
	}
	/**
	 * @return the puntoDescrip
	 */
	public String getPuntoDescrip() {
		return puntoDescrip;
	}
	/**
	 * @param puntoDescrip the puntoDescrip to set
	 */
	public void setPuntoDescrip(String puntoDescrip) {
		this.puntoDescrip = puntoDescrip;
	}
	/**
	 * @return the temperatura
	 */
	public Double getTemperatura() {
		return temperatura;
	}
	/**
	 * @param temperatura the temperatura to set
	 */
	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	/**
	 * @return the ph
	 */
	public Double getPh() {
		return ph;
	}
	/**
	 * @param ph the ph to set
	 */
	public void setPh(Double ph) {
		this.ph = ph;
	}
	/**
	 * @return the dosisClor
	 */
	public Double getDosisClor() {
		return dosisClor;
	}
	/**
	 * @param dosisClor the dosisClor to set
	 */
	public void setDosisClor(Double dosisClor) {
		this.dosisClor = dosisClor;
	}
	/**
	 * @return the cloroResidualLibre
	 */
	public Double getCloroResidualLibre() {
		return cloroResidualLibre;
	}
	/**
	 * @param cloroResidualLibre the cloroResidualLibre to set
	 */
	public void setCloroResidualLibre(Double cloroResidualLibre) {
		this.cloroResidualLibre = cloroResidualLibre;
	}
	/**
	 * @return the cloroResidualTotal
	 */
	public Double getCloroResidualTotal() {
		return cloroResidualTotal;
	}
	/**
	 * @param cloroResidualTotal the cloroResidualTotal to set
	 */
	public void setCloroResidualTotal(Double cloroResidualTotal) {
		this.cloroResidualTotal = cloroResidualTotal;
	}
	/**
	 * @return the demandaCloro
	 */
	public Double getDemandaCloro() {
		return demandaCloro;
	}
	/**
	 * @param demandaCloro the demandaCloro to set
	 */
	public void setDemandaCloro(Double demandaCloro) {
		this.demandaCloro = demandaCloro;
	}
	/**
	 * @return the descripcion
	 */
	public Double getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(Double descripcion) {
		this.descripcion = descripcion;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReporteEnsayoCloroResult [correlativo=" + correlativo + ", puntoMuestra=" + puntoMuestra
				+ ", puntoDescrip=" + puntoDescrip + ", temperatura=" + temperatura + ", ph=" + ph + ", dosisClor="
				+ dosisClor + ", cloroResidualLibre=" + cloroResidualLibre + ", cloroResidualTotal="
				+ cloroResidualTotal + ", demandaCloro=" + demandaCloro + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
}
