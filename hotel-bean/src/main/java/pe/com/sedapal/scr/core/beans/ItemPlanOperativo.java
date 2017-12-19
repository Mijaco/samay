package pe.com.sedapal.scr.core.beans;

public class ItemPlanOperativo extends BaseBean {
	
	private Long idMaster;
	private Long idDetalle;
	private String value;
	private String label;
	private Long estado;
	
	
	public Long getIdMaster() {
		return idMaster;
	}
	public void setIdMaster(Long idMaster) {
		this.idMaster = idMaster;
	}
	public Long getIdDetalle() {
		return idDetalle;
	}
	public void setIdDetalle(Long idDetalle) {
		this.idDetalle = idDetalle;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Long getEstado() {
		return estado;
	}
	public void setEstado(Long estado) {
		this.estado = estado;
	}
	
}
