package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class ResultMuestraBean extends BaseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String strUsuarioCreacion;
	private String strFechaCreacion;
	private String strUsuarioModificacion;
	private String strFechaModificacion;
	private String strNomPrograma;
	
	private int intIdCabecera;
	private int intIdResultaMuestra;
	private String strColifor;
	private String strColter;
	private String strBachet;
	private int intTipo;
	private String strDesMuestra;
	private String strTurntu;
	private String strColaga;
	private int intEstado;
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
	public int getIntIdResultaMuestra() {
		return intIdResultaMuestra;
	}
	public void setIntIdResultaMuestra(int intIdResultaMuestra) {
		this.intIdResultaMuestra = intIdResultaMuestra;
	}
	public String getStrColifor() {
		return strColifor;
	}
	public void setStrColifor(String strColifor) {
		this.strColifor = strColifor;
	}
	public String getStrColter() {
		return strColter;
	}
	public void setStrColter(String strColter) {
		this.strColter = strColter;
	}
	public String getStrBachet() {
		return strBachet;
	}
	public void setStrBachet(String strBachet) {
		this.strBachet = strBachet;
	}
	
	public int getIntTipo() {
		return intTipo;
	}
	public void setIntTipo(int intTipo) {
		this.intTipo = intTipo;
	}
	public String getStrDesMuestra() {
		return strDesMuestra;
	}
	public void setStrDesMuestra(String strDesMuestra) {
		this.strDesMuestra = strDesMuestra;
	}
	public String getStrTurntu() {
		return strTurntu;
	}
	public void setStrTurntu(String strTurntu) {
		this.strTurntu = strTurntu;
	}
	public String getStrColaga() {
		return strColaga;
	}
	public void setStrColaga(String strColaga) {
		this.strColaga = strColaga;
	}
	public int getIntEstado() {
		return intEstado;
	}
	public void setIntEstado(int intEstado) {
		this.intEstado = intEstado;
	}
	
	

}
