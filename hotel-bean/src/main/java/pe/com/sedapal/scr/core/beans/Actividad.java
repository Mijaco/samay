package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Actividad  extends BaseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private String descripcion;
	private Integer estado;
	
	private List<SubactividadReporte> subactividades;
	
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
	public List<SubactividadReporte> getSubactividades() {
		return subactividades;
	}
	public void setSubactividades(List<SubactividadReporte> subactividades) {
		this.subactividades = subactividades;
	}
	public static void main(String[] args) {
		String a = "111#332";
//		obtenerMensajesActividad("111#332");
	}
//	ivate Integer codact;
//	private Integer codsubact;
//	private Integer codparam;map
	
	
	
	private static int  obtenerMensajesActividad(Map<Integer,Map<Integer,Map<Integer,Integer>>> dataForm20,Integer codact,Integer codsubact, Integer codparam){
		int result = 0;
		
		Map<Integer,Map<Integer,Integer>> subactividades = dataForm20.get(codact);
		Map<Integer,Integer> parametros = subactividades.get(codsubact);
		result = parametros.get(codparam);
		return result;
	}
}
