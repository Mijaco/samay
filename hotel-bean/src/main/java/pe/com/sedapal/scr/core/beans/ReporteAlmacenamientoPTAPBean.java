package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class ReporteAlmacenamientoPTAPBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String strUsuarioCreacion;
	private String strFechaCreacion;
	private String strUsuarioModificacion;
	private String strFechaModificacion;
	private String strNomPrograma;
	
	private int intIdCabecera;
	private int intIdDetalle;
	private String strDesMuestra;
	private String strReservorioMenacho;
	private String strReservorioVicentelo;
	private String strReservorioVicenteloRS;
	private String strCamraRegulacion;
	private String strLimiteMaximo;
	private String strLimiteCalidad;
	
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
	public int getIntIdCabecera() {
		return intIdCabecera;
	}
	public void setIntIdCabecera(int intIdCabecera) {
		this.intIdCabecera = intIdCabecera;
	}
	public int getIntIdDetalle() {
		return intIdDetalle;
	}
	public void setIntIdDetalle(int intIdDetalle) {
		this.intIdDetalle = intIdDetalle;
	}
	public String getStrDesMuestra() {
		return strDesMuestra;
	}
	public void setStrDesMuestra(String strDesMuestra) {
		this.strDesMuestra = strDesMuestra;
	}
	public String getStrReservorioMenacho() {
		return strReservorioMenacho;
	}
	public void setStrReservorioMenacho(String strReservorioMenacho) {
		this.strReservorioMenacho = strReservorioMenacho;
	}
	public String getStrReservorioVicentelo() {
		return strReservorioVicentelo;
	}
	public void setStrReservorioVicentelo(String strReservorioVicentelo) {
		this.strReservorioVicentelo = strReservorioVicentelo;
	}
	public String getStrReservorioVicenteloRS() {
		return strReservorioVicenteloRS;
	}
	public void setStrReservorioVicenteloRS(String strReservorioVicenteloRS) {
		this.strReservorioVicenteloRS = strReservorioVicenteloRS;
	}
	public String getStrCamraRegulacion() {
		return strCamraRegulacion;
	}
	public void setStrCamraRegulacion(String strCamraRegulacion) {
		this.strCamraRegulacion = strCamraRegulacion;
	}
	public String getStrLimiteMaximo() {
		return strLimiteMaximo;
	}
	public void setStrLimiteMaximo(String strLimiteMaximo) {
		this.strLimiteMaximo = strLimiteMaximo;
	}
	public String getStrLimiteCalidad() {
		return strLimiteCalidad;
	}
	public void setStrLimiteCalidad(String strLimiteCalidad) {
		this.strLimiteCalidad = strLimiteCalidad;
	}

}
