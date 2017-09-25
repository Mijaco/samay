package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ReporteAnalisisHidroDetalle  extends BaseBean implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	private static final Integer VALUE_DEFAULT= 0;
	
	//DATOS DE MAESTRO
	private Integer correlativo;
	private String fechaReporte;
	private String fechaMuestreo;
	private Date fechaMuestreoDate;
	private Integer personaMuestra;
	private Integer analista;
	
	
	private Integer codsub;
	private Integer algas = VALUE_DEFAULT;
	private Integer cianobacterias = VALUE_DEFAULT;
	private Integer nematodes = VALUE_DEFAULT;
	private Integer otros = VALUE_DEFAULT;
	private Integer total = VALUE_DEFAULT;
	private Integer minam = VALUE_DEFAULT;
	private String  descripcion;
	private String  horaMuestreo;
	
	private Integer valueSelectPunto;
	
	/**
	 * @return the fechaMuestreoDate
	 */
	public Date getFechaMuestreoDate() {
		return fechaMuestreoDate;
	}
	/**
	 * @param fechaMuestreoDate the fechaMuestreoDate to set
	 */
	public void setFechaMuestreoDate(Date fechaMuestreoDate) {
		this.fechaMuestreoDate = fechaMuestreoDate;
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		this.fechaMuestreo = df.format(fechaMuestreoDate);
	}
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
	 * @return the valueSelectPunto
	 */
	public Integer getValueSelectPunto() {
		return valueSelectPunto;
	}
	/**
	 * @param valueSelectPunto the valueSelectPunto to set
	 */
	public void setValueSelectPunto(Integer valueSelectPunto) {
		this.valueSelectPunto = valueSelectPunto;
	}
	/**
	 * @return the codsub
	 */
	public Integer getCodsub() {
		return codsub;
	}
	/**
	 * @param codsub the codsub to set
	 */
	public void setCodsub(Integer codsub) {
		this.codsub = codsub;
	}
	/**
	 * @return the algas
	 */
	public Integer getAlgas() {
		return algas;
	}
	/**
	 * @param algas the algas to set
	 */
	public void setAlgas(Integer algas) {
		this.algas = algas;
	}
	/**
	 * @return the cianobacterias
	 */
	public Integer getCianobacterias() {
		return cianobacterias;
	}
	/**
	 * @param cianobacterias the cianobacterias to set
	 */
	public void setCianobacterias(Integer cianobacterias) {
		this.cianobacterias = cianobacterias;
	}
	/**
	 * @return the nematodes
	 */
	public Integer getNematodes() {
		return nematodes;
	}
	/**
	 * @param nematodes the nematodes to set
	 */
	public void setNematodes(Integer nematodes) {
		this.nematodes = nematodes;
	}
	/**
	 * @return the otros
	 */
	public Integer getOtros() {
		return otros;
	}
	/**
	 * @param otros the otros to set
	 */
	public void setOtros(Integer otros) {
		this.otros = otros;
	}
	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}
	/**
	 * @return the minam
	 */
	public Integer getMinam() {
		return minam;
	}
	/**
	 * @param minam the minam to set
	 */
	public void setMinam(Integer minam) {
		this.minam = minam;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the horaMuestreo
	 */
	public String getHoraMuestreo() {
		return horaMuestreo;
	}
	/**
	 * @param horaMuestreo the horaMuestreo to set
	 */
	public void setHoraMuestreo(String horaMuestreo) {
		this.horaMuestreo = horaMuestreo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReporteAnalisisHidro [codsub=" + codsub + ", algas=" + algas + ", cianobacterias=" + cianobacterias
				+ ", nematodes=" + nematodes + ", otros=" + otros + ", total=" + total + ", minam=" + minam
				+ ", descripcion=" + descripcion + ", horaMuestreo=" + horaMuestreo + "]";
	}
}
