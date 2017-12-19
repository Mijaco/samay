package pe.com.sedapal.scr.core.beans;

public class BaseBean {
	
	
	// datos de auditoria
	
	
	private String usuarioCreacion;
	private String fechaCreacion;
	private String usuarioModificacion;
	private String fechaModificacion;
	private String programa;
	private Integer codigoArea;
	private Integer codigoSistema;
	
	
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
	public String getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	public Integer getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(Integer codigoArea) {
		this.codigoArea = codigoArea;
	}
	public Integer getCodigoSistema() {
		return codigoSistema;
	}
	public void setCodigoSistema(Integer codigoSistema) {
		this.codigoSistema = codigoSistema;
	}
	
	
	
}
