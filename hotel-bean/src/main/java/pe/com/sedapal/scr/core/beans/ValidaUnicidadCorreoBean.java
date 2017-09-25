package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class ValidaUnicidadCorreoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private boolean bolExistReporteResumen;
	private boolean bolExistProcesoAutomatico;
	private boolean bolExistEnvios;
	private boolean bolExistReporteGerencia;
	
	public boolean isBolExistReporteResumen() {
		return bolExistReporteResumen;
	}
	public void setBolExistReporteResumen(boolean bolExistReporteResumen) {
		this.bolExistReporteResumen = bolExistReporteResumen;
	}
	public boolean isBolExistProcesoAutomatico() {
		return bolExistProcesoAutomatico;
	}
	public void setBolExistProcesoAutomatico(boolean bolExistProcesoAutomatico) {
		this.bolExistProcesoAutomatico = bolExistProcesoAutomatico;
	}
	public boolean isBolExistEnvios() {
		return bolExistEnvios;
	}
	public void setBolExistEnvios(boolean bolExistEnvios) {
		this.bolExistEnvios = bolExistEnvios;
	}
	public boolean isBolExistReporteGerencia() {
		return bolExistReporteGerencia;
	}
	public void setBolExistReporteGerencia(boolean bolExistReporteGerencia) {
		this.bolExistReporteGerencia = bolExistReporteGerencia;
	}
}
