package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class DatosEnvioCorreoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String strRemitente;
	private String strDestinatarios;
	private String strCopiados;
	private String strAsunto;
	private String strCuerpo;
	private boolean bolPuedeEnviar;
	
	public String getStrRemitente() {
		return strRemitente;
	}
	public void setStrRemitente(String strRemitente) {
		this.strRemitente = strRemitente;
	}
	public String getStrDestinatarios() {
		return strDestinatarios;
	}
	public void setStrDestinatarios(String strDestinatarios) {
		this.strDestinatarios = strDestinatarios;
	}
	public String getStrCopiados() {
		return strCopiados;
	}
	public void setStrCopiados(String strCopiados) {
		this.strCopiados = strCopiados;
	}
	public String getStrAsunto() {
		return strAsunto;
	}
	public void setStrAsunto(String strAsunto) {
		this.strAsunto = strAsunto;
	}
	public String getStrCuerpo() {
		return strCuerpo;
	}
	public void setStrCuerpo(String strCuerpo) {
		this.strCuerpo = strCuerpo;
	}
	public boolean isBolPuedeEnviar() {
		return bolPuedeEnviar;
	}
	public void setBolPuedeEnviar(boolean bolPuedeEnviar) {
		this.bolPuedeEnviar = bolPuedeEnviar;
	}
}
