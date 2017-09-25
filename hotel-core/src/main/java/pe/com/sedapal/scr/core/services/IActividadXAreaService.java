package pe.com.sedapal.scr.core.services;

import java.util.List;

import pe.com.sedapal.scr.core.beans.ActividadArea;
import pe.com.sedapal.scr.core.beans.SelectItemBean;


public interface IActividadXAreaService {

	public void actualizarActividadXArea(ActividadArea actividadArea);
	
	public void insertarActividad(ActividadArea actividadArea);
	
	public List<SelectItemBean> listarActividades(Integer idArea);
	
	public boolean existeActividad(Integer idArea,Integer idACtividad);
}
