package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReporteFitoplanctonDetalle extends BaseBean implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	private static final Double VALUE_DEFAULT= 0D;
	
	   //DATOS DE MAESTRO
		private Integer correlativo;
		private String fechaReporte;
		private String fechaMuestreo;
		private Date fechaMuestreoDate;
		private Integer personaMuestra;
		private Integer analista;
		
		
		private Integer codsub;// No es codigo de subactividad , es de punto muestreo
		private Double clorofila = VALUE_DEFAULT;
		private Double ficocianina = VALUE_DEFAULT;
		
		
		private Integer valueSelectPunto;
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
		 * @return the clorofila
		 */
		public Double getClorofila() {
			return clorofila;
		}
		/**
		 * @param clorofila the clorofila to set
		 */
		public void setClorofila(Double clorofila) {
			this.clorofila = clorofila;
		}
		/**
		 * @return the ficocianina
		 */
		public Double getFicocianina() {
			return ficocianina;
		}
		/**
		 * @param ficocianina the ficocianina to set
		 */
		public void setFicocianina(Double ficocianina) {
			this.ficocianina = ficocianina;
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
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "ReporteFitoplanctonDetalle [correlativo=" + correlativo + ", fechaReporte=" + fechaReporte
					+ ", fechaMuestreo=" + fechaMuestreo + ", fechaMuestreoDate=" + fechaMuestreoDate
					+ ", personaMuestra=" + personaMuestra + ", analista=" + analista + ", codsub=" + codsub
					+ ", clorofila=" + clorofila + ", ficocianina=" + ficocianina + ", valueSelectPunto="
					+ valueSelectPunto + "]";
		}
		
		
}
