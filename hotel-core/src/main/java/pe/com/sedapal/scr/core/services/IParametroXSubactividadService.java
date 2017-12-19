package pe.com.sedapal.scr.core.services;

import java.util.List;

import pe.com.sedapal.scr.core.beans.ItemPlanOperativo;
import pe.com.sedapal.scr.core.beans.SelectItemBean;

public interface IParametroXSubactividadService {

	public void actualizarParametroXSubactividad(ItemPlanOperativo subactividadXGrupo);
	
	public void insertarParametroXSubactividad(ItemPlanOperativo subactividadXGrupo);
	
	public boolean existeParametroXSubactividad(Integer idSubactividadXActividad, Integer idParametro);
	
	public List<ItemPlanOperativo> listarSubActividades(Integer idActividad);
	
	public List<SelectItemBean> listarParametros(Integer idSubActividad);
}
