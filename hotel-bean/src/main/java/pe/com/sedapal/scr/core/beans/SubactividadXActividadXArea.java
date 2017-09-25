package pe.com.sedapal.scr.core.beans;

import java.util.List;

public class SubactividadXActividadXArea {

	private Long idFormulario;
	private Long area;
	private Long actividad;
	private List<SubActividad> subActividades;
	
	public Long getIdFormulario() {
		return idFormulario;
	}
	public void setIdFormulario(Long idFormulario) {
		this.idFormulario = idFormulario;
	}
	public Long getArea() {
		return area;
	}
	public void setArea(Long area) {
		this.area = area;
	}
	public Long getActividad() {
		return actividad;
	}
	public void setActividad(Long actividad) {
		this.actividad = actividad;
	}
	public List<SubActividad> getSubActividades() {
		return subActividades;
	}
	public void setSubActividades(List<SubActividad> subActividades) {
		this.subActividades = subActividades;
	}
	
}
