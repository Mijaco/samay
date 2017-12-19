package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.util.List;

public class EnsayoCloro extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private  String fechaMuestreo;
	private  String horaMuestreo;
	
	private  String fechaRecepcion;
	private  String horaRecepcion;
	
	private  String fechaInicioEnsayo;
	private  String horaInicioEnsayo;
	
	private  String planMuestreo;
	private  String metodoMuestreo;
	
	private  String analista;
	private  String turno;
	
	private  String muestreador;
	
	private  String volumenMuestra;
	private  String fechaReporte;
	private  String tiempoContacto;
	
	private List<ReporteEnsayoCloroResult> detalles;

	
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





	/**
	 * @return the fechaRecepcion
	 */
	public String getFechaRecepcion() {
		return fechaRecepcion;
	}





	/**
	 * @param fechaRecepcion the fechaRecepcion to set
	 */
	public void setFechaRecepcion(String fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}





	/**
	 * @return the horaRecepcion
	 */
	public String getHoraRecepcion() {
		return horaRecepcion;
	}





	/**
	 * @param horaRecepcion the horaRecepcion to set
	 */
	public void setHoraRecepcion(String horaRecepcion) {
		this.horaRecepcion = horaRecepcion;
	}





	/**
	 * @return the fechaInicioEnsayo
	 */
	public String getFechaInicioEnsayo() {
		return fechaInicioEnsayo;
	}





	/**
	 * @param fechaInicioEnsayo the fechaInicioEnsayo to set
	 */
	public void setFechaInicioEnsayo(String fechaInicioEnsayo) {
		this.fechaInicioEnsayo = fechaInicioEnsayo;
	}





	/**
	 * @return the horaInicioEnsayo
	 */
	public String getHoraInicioEnsayo() {
		return horaInicioEnsayo;
	}





	/**
	 * @param horaInicioEnsayo the horaInicioEnsayo to set
	 */
	public void setHoraInicioEnsayo(String horaInicioEnsayo) {
		this.horaInicioEnsayo = horaInicioEnsayo;
	}





	/**
	 * @return the planMuestreo
	 */
	public String getPlanMuestreo() {
		return planMuestreo;
	}





	/**
	 * @param planMuestreo the planMuestreo to set
	 */
	public void setPlanMuestreo(String planMuestreo) {
		this.planMuestreo = planMuestreo;
	}





	/**
	 * @return the metodoMuestreo
	 */
	public String getMetodoMuestreo() {
		return metodoMuestreo;
	}





	/**
	 * @param metodoMuestreo the metodoMuestreo to set
	 */
	public void setMetodoMuestreo(String metodoMuestreo) {
		this.metodoMuestreo = metodoMuestreo;
	}





	/**
	 * @return the analista
	 */
	public String getAnalista() {
		return analista;
	}





	/**
	 * @param analista the analista to set
	 */
	public void setAnalista(String analista) {
		this.analista = analista;
	}





	/**
	 * @return the turno
	 */
	public String getTurno() {
		return turno;
	}





	/**
	 * @param turno the turno to set
	 */
	public void setTurno(String turno) {
		this.turno = turno;
	}





	/**
	 * @return the muestreador
	 */
	public String getMuestreador() {
		return muestreador;
	}





	/**
	 * @param muestreador the muestreador to set
	 */
	public void setMuestreador(String muestreador) {
		this.muestreador = muestreador;
	}





	/**
	 * @return the volumenMuestra
	 */
	public String getVolumenMuestra() {
		return volumenMuestra;
	}





	/**
	 * @param volumenMuestra the volumenMuestra to set
	 */
	public void setVolumenMuestra(String volumenMuestra) {
		this.volumenMuestra = volumenMuestra;
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
	 * @return the tiempoContacto
	 */
	public String getTiempoContacto() {
		return tiempoContacto;
	}





	/**
	 * @param tiempoContacto the tiempoContacto to set
	 */
	public void setTiempoContacto(String tiempoContacto) {
		this.tiempoContacto = tiempoContacto;
	}





	/**
	 * @return the detalles
	 */
	public List<ReporteEnsayoCloroResult> getDetalles() {
		return detalles;
	}





	/**
	 * @param detalles the detalles to set
	 */
	public void setDetalles(List<ReporteEnsayoCloroResult> detalles) {
		this.detalles = detalles;
	}





	@Override
	public String toString() {
		return "ReporteEnsayo [fechaMuestreo=" + fechaMuestreo + ", horaMuestreo=" + horaMuestreo
				+ ", fechaRecepcion=" + fechaRecepcion + ", horaRecepcion=" + horaRecepcion + ", fechaInicioEnsayo="
				+ fechaInicioEnsayo + ", horaInicioEnsayo=" + horaInicioEnsayo + ", planMuestreo=" + planMuestreo
				+ ", metodoMuestreo=" + metodoMuestreo + ", analista=" + analista + ", turno=" + turno
				+ ", muestreador=" + muestreador + ", volumenMuestra=" + volumenMuestra + ", fechaReporte="
				+ fechaReporte + ", tiempoContacto=" + tiempoContacto + ", detalles=" + detalles + "]";
	}
	

}
