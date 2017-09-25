package pe.com.sedapal.scr.core.beans;

public class ActividadArea extends BaseBean {

	private Long idFormulario;
	private Long idArea;
	private Long idActividad;
	private Long estado;
	private String descripcionAsignada;
	
	public Long getIdFormulario() {
		return idFormulario;
	}
	public void setIdFormulario(Long idFormulario) {
		this.idFormulario = idFormulario;
	}
	
	public Long getIdArea() {
		return idArea;
	}
	public void setIdArea(Long idArea) {
		this.idArea = idArea;
	}
	public Long getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}
	public String getDescripcionAsignada() {
		return descripcionAsignada;
	}
	public void setDescripcionAsignada(String descripcionAsignada) {
		this.descripcionAsignada = descripcionAsignada;
	}
	public Long getEstado() {
		return estado;
	}
	public void setEstado(Long estado) {
		this.estado = estado;
	}
	
}
