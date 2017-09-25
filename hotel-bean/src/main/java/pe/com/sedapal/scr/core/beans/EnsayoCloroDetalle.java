package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class EnsayoCloroDetalle extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer puntoMuestreo;
	private String puntoMuestreoDesc;
	private String ph;
	private String temperatura;
	
	private String frasco;
	private String volumen;
	private String dosis;
	private String cl2Libre;
	private String cl2Comb;
	private String cl2Total;
	private String cloroLibre;
	private String cloroTotal;
	private String demandaCloro;
	/**
	 * @return the puntoMuestreo
	 */
	public Integer getPuntoMuestreo() {
		return puntoMuestreo;
	}
	/**
	 * @param puntoMuestreo the puntoMuestreo to set
	 */
	public void setPuntoMuestreo(Integer puntoMuestreo) {
		this.puntoMuestreo = puntoMuestreo;
	}
	/**
	 * @return the puntoMuestreoDesc
	 */
	public String getPuntoMuestreoDesc() {
		return puntoMuestreoDesc;
	}
	/**
	 * @param puntoMuestreoDesc the puntoMuestreoDesc to set
	 */
	public void setPuntoMuestreoDesc(String puntoMuestreoDesc) {
		this.puntoMuestreoDesc = puntoMuestreoDesc;
	}
	/**
	 * @return the ph
	 */
	public String getPh() {
		return ph;
	}
	/**
	 * @param ph the ph to set
	 */
	public void setPh(String ph) {
		this.ph = ph;
	}
	/**
	 * @return the temperatura
	 */
	public String getTemperatura() {
		return temperatura;
	}
	/**
	 * @param temperatura the temperatura to set
	 */
	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}
	/**
	 * @return the frasco
	 */
	public String getFrasco() {
		return frasco;
	}
	/**
	 * @param frasco the frasco to set
	 */
	public void setFrasco(String frasco) {
		this.frasco = frasco;
	}
	/**
	 * @return the volumen
	 */
	public String getVolumen() {
		return volumen;
	}
	/**
	 * @param volumen the volumen to set
	 */
	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}
	/**
	 * @return the dosis
	 */
	public String getDosis() {
		return dosis;
	}
	/**
	 * @param dosis the dosis to set
	 */
	public void setDosis(String dosis) {
		this.dosis = dosis;
	}
	/**
	 * @return the cl2Libre
	 */
	public String getCl2Libre() {
		return cl2Libre;
	}
	/**
	 * @param cl2Libre the cl2Libre to set
	 */
	public void setCl2Libre(String cl2Libre) {
		this.cl2Libre = cl2Libre;
	}
	/**
	 * @return the cl2Comb
	 */
	public String getCl2Comb() {
		return cl2Comb;
	}
	/**
	 * @param cl2Comb the cl2Comb to set
	 */
	public void setCl2Comb(String cl2Comb) {
		this.cl2Comb = cl2Comb;
	}
	/**
	 * @return the cl2Total
	 */
	public String getCl2Total() {
		return cl2Total;
	}
	/**
	 * @param cl2Total the cl2Total to set
	 */
	public void setCl2Total(String cl2Total) {
		this.cl2Total = cl2Total;
	}
	/**
	 * @return the cloroLibre
	 */
	public String getCloroLibre() {
		return cloroLibre;
	}
	/**
	 * @param cloroLibre the cloroLibre to set
	 */
	public void setCloroLibre(String cloroLibre) {
		this.cloroLibre = cloroLibre;
	}
	/**
	 * @return the cloroTotal
	 */
	public String getCloroTotal() {
		return cloroTotal;
	}
	/**
	 * @param cloroTotal the cloroTotal to set
	 */
	public void setCloroTotal(String cloroTotal) {
		this.cloroTotal = cloroTotal;
	}
	/**
	 * @return the demandaCloro
	 */
	public String getDemandaCloro() {
		return demandaCloro;
	}
	/**
	 * @param demandaCloro the demandaCloro to set
	 */
	public void setDemandaCloro(String demandaCloro) {
		this.demandaCloro = demandaCloro;
	}

	
}
