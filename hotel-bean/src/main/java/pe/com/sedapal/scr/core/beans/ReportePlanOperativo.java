package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class ReportePlanOperativo extends BaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer codigo;
	
	private String descripcion;
	private Integer estado;
	
	private Integer codplan;
	private Integer codare;
	private String codDescPlan;
	private String mes;
	
	public ReportePlanOperativo(){
	}
	
	public ReportePlanOperativo(ReportePlanOperativo repo){
		
		codigo = repo.getCodigo();
		descripcion = repo.getDescripcion();
		estado = repo.getEstado();
		codplan = repo.getCodplan();
		codare = repo.getCodare();
		codDescPlan = repo.getCodDescPlan();
		mes = repo.getMes();
		actividades = repo.getActividades();
				
	}
	
	private ArrayList<ActividadReporte> actividades;
	
	public Integer getCodare() {
		return codare;
	}

	public void setCodare(Integer codare) {
		this.codare = codare;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public ArrayList<ActividadReporte> getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList<ActividadReporte> actividades) {
		this.actividades = actividades;
	}
	
	public Integer getCodplan() {
		return codplan;
	}

	public void setCodplan(Integer codplan) {
		this.codplan = codplan;
	}

	public String getCodDescPlan() {
		return codDescPlan;
	}

	public void setCodDescPlan(String codDescPlan) {
		this.codDescPlan = codDescPlan;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	@Override
	public String toString() {
		return "ReportePlanOperativo [codigo=" + codigo + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", codplan=" + codplan + ", codDescPlan=" + codDescPlan + ", mes=" + mes + ", actividades="
				+ actividades + "]";
	}

}
