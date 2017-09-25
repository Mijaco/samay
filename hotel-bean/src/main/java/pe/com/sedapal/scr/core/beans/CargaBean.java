package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class CargaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String strUsuIns;
	private String strUsuUpd;
	private String strPrograma;
	private Long lonCodArea;
	private Long lonCodSist;
	private Long lonCodigo;
	private String strNombre;
	private String strNombreArchivo;
	private String strRutaArchivo;
	private String strFechaRegistro;
	private String strEstado;
	private String strDescError;
	
	private String strMensajeAlerta;
	
	public String getStrUsuIns() {
		return strUsuIns;
	}
	public void setStrUsuIns(String strUsuIns) {
		this.strUsuIns = strUsuIns;
	}
	public String getStrUsuUpd() {
		return strUsuUpd;
	}
	public void setStrUsuUpd(String strUsuUpd) {
		this.strUsuUpd = strUsuUpd;
	}
	public String getStrPrograma() {
		return strPrograma;
	}
	public void setStrPrograma(String strPrograma) {
		this.strPrograma = strPrograma;
	}
	public Long getLonCodArea() {
		return lonCodArea;
	}
	public void setLonCodArea(Long lonCodArea) {
		this.lonCodArea = lonCodArea;
	}
	public Long getLonCodSist() {
		return lonCodSist;
	}
	public void setLonCodSist(Long lonCodSist) {
		this.lonCodSist = lonCodSist;
	}
	public Long getLonCodigo() {
		return lonCodigo;
	}
	public void setLonCodigo(Long lonCodigo) {
		this.lonCodigo = lonCodigo;
	}
	public String getStrNombre() {
		return strNombre;
	}
	public void setStrNombre(String strNombre) {
		this.strNombre = strNombre;
	}
	public String getStrNombreArchivo() {
		return strNombreArchivo;
	}
	public void setStrNombreArchivo(String strNombreArchivo) {
		this.strNombreArchivo = strNombreArchivo;
	}
	public String getStrRutaArchivo() {
		return strRutaArchivo;
	}
	public void setStrRutaArchivo(String strRutaArchivo) {
		this.strRutaArchivo = strRutaArchivo;
	}
	public String getStrFechaRegistro() {
		return strFechaRegistro;
	}
	public void setStrFechaRegistro(String strFechaRegistro) {
		this.strFechaRegistro = strFechaRegistro;
	}
	public String getStrEstado() {
		return strEstado;
	}
	public void setStrEstado(String strEstado) {
		this.strEstado = strEstado;
	}
	public String getStrDescError() {
		return strDescError;
	}
	public void setStrDescError(String strDescError) {
		this.strDescError = strDescError;
	}
	public String getStrMensajeAlerta() {
		return strMensajeAlerta;
	}
	public void setStrMensajeAlerta(String strMensajeAlerta) {
		this.strMensajeAlerta = strMensajeAlerta;
	}
}
