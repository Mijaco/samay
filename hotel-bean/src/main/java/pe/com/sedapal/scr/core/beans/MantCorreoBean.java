package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class MantCorreoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String codigo;
	private String codTipoOperacion;
	private String estado;
	private String aUsuUpd;
	private String aPrograma;
	private Long lonCodArea;
	private Long lonCodSist;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodTipoOperacion() {
		return codTipoOperacion;
	}
	public void setCodTipoOperacion(String codTipoOperacion) {
		this.codTipoOperacion = codTipoOperacion;
	}
	public String getaUsuUpd() {
		return aUsuUpd;
	}
	public void setaUsuUpd(String aUsuUpd) {
		this.aUsuUpd = aUsuUpd;
	}
	public String getaPrograma() {
		return aPrograma;
	}
	public void setaPrograma(String aPrograma) {
		this.aPrograma = aPrograma;
	}
	public Long getLonCodSist() {
		return lonCodSist;
	}
	public void setLonCodSist(Long lonCodSist) {
		this.lonCodSist = lonCodSist;
	}
	public Long getLonCodArea() {
		return lonCodArea;
	}
	public void setLonCodArea(Long lonCodArea) {
		this.lonCodArea = lonCodArea;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
