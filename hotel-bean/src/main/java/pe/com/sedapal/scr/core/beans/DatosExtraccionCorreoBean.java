package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class DatosExtraccionCorreoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strCorreoExtraer;
	private String strRemitente;
	private String strAsunto;
	private String strNombreAdjunto;
	private String strRutaArchivo;
	
	private boolean bolPuedeExtraer;
	
	public String getStrCorreoExtraer() {
		return strCorreoExtraer;
	}
	public void setStrCorreoExtraer(String strCorreoExtraer) {
		this.strCorreoExtraer = strCorreoExtraer;
	}
	public String getStrRemitente() {
		return strRemitente;
	}
	public void setStrRemitente(String strRemitente) {
		this.strRemitente = strRemitente;
	}
	public String getStrAsunto() {
		return strAsunto;
	}
	public void setStrAsunto(String strAsunto) {
		this.strAsunto = strAsunto;
	}
	public String getStrNombreAdjunto() {
		return strNombreAdjunto;
	}
	public void setStrNombreAdjunto(String strNombreAdjunto) {
		this.strNombreAdjunto = strNombreAdjunto;
	}
	public String getStrRutaArchivo() {
		return strRutaArchivo;
	}
	public void setStrRutaArchivo(String strRutaArchivo) {
		this.strRutaArchivo = strRutaArchivo;
	}
	public boolean getBolPuedeExtraer() {
		return bolPuedeExtraer;
	}
	public void setBolPuedeExtraer(boolean bolPuedeExtraer) {
		this.bolPuedeExtraer = bolPuedeExtraer;
	}
}
