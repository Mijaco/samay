package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class PlanOperativo extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	Integer codare;
	Integer codigoPlan;
	String  codigoDescripcionPlan;
	String  descripcion;
	Integer estadoPlan;
	Integer activo;
	
	public Integer getCodare() {
		return codare;
	}
	public void setCodare(Integer codare) {
		this.codare = codare;
	}
	public Integer getCodigoPlan() {
		return codigoPlan;
	}
	public void setCodigoPlan(Integer codigoPlan) {
		this.codigoPlan = codigoPlan;
	}
	public String getCodigoDescripcionPlan() {
		return codigoDescripcionPlan;
	}
	public void setCodigoDescripcionPlan(String codigoDescripcionPlan) {
		this.codigoDescripcionPlan = codigoDescripcionPlan;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getEstadoPlan() {
		return estadoPlan;
	}
	
	public void setEstadoPlan(Integer estadoPlan) {
		this.estadoPlan = estadoPlan;
	}
	
	public Integer getActivo() {
		return activo;
	}
	
	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	
	@Override
	public String toString() {
		return "PlanOperativo [codigoPlan=" + codigoPlan + ", codigoDescripcionPlan=" + codigoDescripcionPlan
				+ ", descripcion=" + descripcion + ", estadoPlan=" + estadoPlan + ", activo=" + activo + "]";
	}
	
}
