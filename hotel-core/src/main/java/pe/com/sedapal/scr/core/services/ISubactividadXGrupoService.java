package pe.com.sedapal.scr.core.services;

import java.util.List;

import pe.com.sedapal.scr.core.beans.ItemPlanOperativo;
import pe.com.sedapal.scr.core.beans.SelectItemBean;

public interface ISubactividadXGrupoService {

public void actualizarSubactividadXGrupo(ItemPlanOperativo subactividadXGrupo);
	
	public void insertarSubactividadXGrupo(ItemPlanOperativo subactividadXGrupo);
	
	public boolean existeSubactividadXGrupo(Integer idGrupo, Integer idSubactividad);
	
	public List<SelectItemBean> listarSubactividades(Integer idGrupo);
	
	public List<ItemPlanOperativo> listarActividades(Integer idGrupo);
}
