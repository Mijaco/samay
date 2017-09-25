package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class AlmacenamientoPTAPBean  extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String strUsuarioCreacion;
	private String strFechaCreacion;
	private String strUsuarioModificacion;
	private String strFechaModificacion;
	private String strNomPrograma;
	
	private int intId;
	private int intIdHide;
	private int intIdForm;
	private String strFechaMuestreo;
	private String strHoraMuestreo;
	private String strFechaRecepcionMuestra;
	private String strHoraRecepcionMuestra;
	private String strFechaInicioEnsayo;
	private String strHoraInicioEnsayo;
	private String strTurno;
	private String strMuestreador;
	private String strAnalista;
	private int intEstado;
	/*private int intMantConexiones;
	private int intCumplimientoLBD;*/
	private int intMantConexionesHide;
	private int intCumplimientoLBDHide;
	private boolean bolCumplimientoLBD;
	private boolean bolMantConexiones;
	private String strMuestreadorHide;
	private String strAnalistaHide;
	private String strObservacion;
	
	public String getStrUsuarioCreacion() {
		return strUsuarioCreacion;
	}
	public void setStrUsuarioCreacion(String strUsuarioCreacion) {
		this.strUsuarioCreacion = strUsuarioCreacion;
	}
	public String getStrFechaCreacion() {
		return strFechaCreacion;
	}
	public void setStrFechaCreacion(String strFechaCreacion) {
		this.strFechaCreacion = strFechaCreacion;
	}
	public String getStrUsuarioModificacion() {
		return strUsuarioModificacion;
	}
	public void setStrUsuarioModificacion(String strUsuarioModificacion) {
		this.strUsuarioModificacion = strUsuarioModificacion;
	}
	public String getStrFechaModificacion() {
		return strFechaModificacion;
	}
	public void setStrFechaModificacion(String strFechaModificacion) {
		this.strFechaModificacion = strFechaModificacion;
	}
	public String getStrNomPrograma() {
		return strNomPrograma;
	}
	public void setStrNomPrograma(String strNomPrograma) {
		this.strNomPrograma = strNomPrograma;
	}
	public int getIntId() {
		return intId;
	}
	public void setIntId(int intId) {
		this.intId = intId;
	}
	public int getIntIdHide() {
		return intIdHide;
	}
	public void setIntIdHide(int intIdHide) {
		this.intIdHide = intIdHide;
	}
	public String getStrFechaMuestreo() {
		return strFechaMuestreo;
	}
	public void setStrFechaMuestreo(String strFechaMuestreo) {
		this.strFechaMuestreo = strFechaMuestreo;
	}
	public String getStrHoraMuestreo() {
		return strHoraMuestreo;
	}
	public void setStrHoraMuestreo(String strHoraMuestreo) {
		this.strHoraMuestreo = strHoraMuestreo;
	}
	public String getStrFechaRecepcionMuestra() {
		return strFechaRecepcionMuestra;
	}
	public void setStrFechaRecepcionMuestra(String strFechaRecepcionMuestra) {
		this.strFechaRecepcionMuestra = strFechaRecepcionMuestra;
	}
	public String getStrHoraRecepcionMuestra() {
		return strHoraRecepcionMuestra;
	}
	public void setStrHoraRecepcionMuestra(String strHoraRecepcionMuestra) {
		this.strHoraRecepcionMuestra = strHoraRecepcionMuestra;
	}
	public String getStrFechaInicioEnsayo() {
		return strFechaInicioEnsayo;
	}
	public void setStrFechaInicioEnsayo(String strFechaInicioEnsayo) {
		this.strFechaInicioEnsayo = strFechaInicioEnsayo;
	}
	public String getStrHoraInicioEnsayo() {
		return strHoraInicioEnsayo;
	}
	public void setStrHoraInicioEnsayo(String strHoraInicioEnsayo) {
		this.strHoraInicioEnsayo = strHoraInicioEnsayo;
	}
	public String getStrTurno() {
		return strTurno;
	}
	public void setStrTurno(String strTurno) {
		this.strTurno = strTurno;
	}
	public String getStrMuestreador() {
		return strMuestreador;
	}
	public void setStrMuestreador(String strMuestreador) {
		this.strMuestreador = strMuestreador;
	}
	public String getStrAnalista() {
		return strAnalista;
	}
	public void setStrAnalista(String strAnalista) {
		this.strAnalista = strAnalista;
	}
	public int getIntEstado() {
		return intEstado;
	}
	public void setIntEstado(int intEstado) {
		this.intEstado = intEstado;
	}
	public int getIntMantConexionesHide() {
		return intMantConexionesHide;
	}
	public void setIntMantConexionesHide(int intMantConexionesHide) {
		this.intMantConexionesHide = intMantConexionesHide;
	}
	public int getIntCumplimientoLBDHide() {
		return intCumplimientoLBDHide;
	}
	public void setIntCumplimientoLBDHide(int intCumplimientoLBDHide) {
		this.intCumplimientoLBDHide = intCumplimientoLBDHide;
	}
	public boolean isBolCumplimientoLBD() {
		return bolCumplimientoLBD;
	}
	public void setBolCumplimientoLBD(boolean bolCumplimientoLBD) {
		this.bolCumplimientoLBD = bolCumplimientoLBD;
	}
	public boolean isBolMantConexiones() {
		return bolMantConexiones;
	}
	public void setBolMantConexiones(boolean bolMantConexiones) {
		this.bolMantConexiones = bolMantConexiones;
	}
	public String getStrMuestreadorHide() {
		return strMuestreadorHide;
	}
	public void setStrMuestreadorHide(String strMuestreadorHide) {
		this.strMuestreadorHide = strMuestreadorHide;
	}
	public String getStrAnalistaHide() {
		return strAnalistaHide;
	}
	public void setStrAnalistaHide(String strAnalistaHide) {
		this.strAnalistaHide = strAnalistaHide;
	}
	public int getIntIdForm() {
		return intIdForm;
	}
	public void setIntIdForm(int intIdForm) {
		this.intIdForm = intIdForm;
	}
	public String getStrObservacion() {
		return strObservacion;
	}
	public void setStrObservacion(String strObservacion) {
		this.strObservacion = strObservacion;
	}
	
	

}
