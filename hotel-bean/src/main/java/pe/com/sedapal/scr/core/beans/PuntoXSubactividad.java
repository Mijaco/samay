package pe.com.sedapal.scr.core.beans;

public class PuntoXSubactividad extends BaseBean{

	private Long idSubactividad;
	private Long idPunto;
	private Long estado;
	private String descripcion;
	
	public Long getIdSubactividad() {
		return idSubactividad;
	}
	public void setIdSubactividad(Long idSubactividad) {
		this.idSubactividad = idSubactividad;
	}
	public Long getIdPunto() {
		return idPunto;
	}
	public void setIdPunto(Long idPunto) {
		this.idPunto = idPunto;
	}
	public Long getEstado() {
		return estado;
	}
	public void setEstado(Long estado) {
		this.estado = estado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
