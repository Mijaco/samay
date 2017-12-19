package pe.com.sedapal.scr.core.beans;

public class SubactividadXGrupo extends BaseBean{
	
	private Long idSubactividadXGrupo ;
	private Long idSubActividad;
	private Long estado;
	
	
	public Long getIdSubActividad() {
		return idSubActividad;
	}
	public void setIdSubActividad(Long idSubActividad) {
		this.idSubActividad = idSubActividad;
	}
	public Long getEstado() {
		return estado;
	}
	public void setEstado(Long estado) {
		this.estado = estado;
	}
	public Long getIdSubactividadXGrupo() {
		return idSubactividadXGrupo;
	}
	public void setIdSubactividadXGrupo(Long idSubactividadXGrupo) {
		this.idSubactividadXGrupo = idSubactividadXGrupo;
	}
	
}
