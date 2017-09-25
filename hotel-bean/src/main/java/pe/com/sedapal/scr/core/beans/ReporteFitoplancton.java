package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class ReporteFitoplancton extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer correlativo;//asignado en store procedure
	private String fechaReporte;//asignado en store procedure
	private String fechaMuestreo;
	private Integer personaMuestra;
	private Integer analista;
	private ArrayList<ReporteFitoplanctonDetalle> detalles;
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
	 * @return the fechaReporte
	 */
	public String getFechaReporte() {
		return fechaReporte;
	}
	/**
	 * @param fechaReporte the fechaReporte to set
	 */
	public void setFechaReporte(String fechaReporte) {
		this.fechaReporte = fechaReporte;
	}
	/**
	 * @return the fechaMuestreo
	 */
	public String getFechaMuestreo() {
		return fechaMuestreo;
	}
	/**
	 * @param fechaMuestreo the fechaMuestreo to set
	 */
	public void setFechaMuestreo(String fechaMuestreo) {
		this.fechaMuestreo = fechaMuestreo;
	}
	/**
	 * @return the personaMuestra
	 */
	public Integer getPersonaMuestra() {
		return personaMuestra;
	}
	/**
	 * @param personaMuestra the personaMuestra to set
	 */
	public void setPersonaMuestra(Integer personaMuestra) {
		this.personaMuestra = personaMuestra;
	}
	/**
	 * @return the analista
	 */
	public Integer getAnalista() {
		return analista;
	}
	/**
	 * @param analista the analista to set
	 */
	public void setAnalista(Integer analista) {
		this.analista = analista;
	}
	/**
	 * @return the detalles
	 */
	public ArrayList<ReporteFitoplanctonDetalle> getDetalles() {
		return detalles;
	}
	/**
	 * @param detalles the detalles to set
	 */
	public void setDetalles(ArrayList<ReporteFitoplanctonDetalle> detalles) {
		this.detalles = detalles;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReporteFitoplancton [correlativo=" + correlativo + ", fechaReporte=" + fechaReporte + ", fechaMuestreo="
				+ fechaMuestreo + ", personaMuestra=" + personaMuestra + ", analista=" + analista + ", detalles="
				+ detalles + "]";
	}
	
	
	
}
