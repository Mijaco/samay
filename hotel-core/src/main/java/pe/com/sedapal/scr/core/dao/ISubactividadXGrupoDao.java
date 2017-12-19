package pe.com.sedapal.scr.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.sedapal.scr.core.beans.ItemPlanOperativo;
import pe.com.sedapal.scr.core.beans.SelectItemBean;
import pe.com.sedapal.scr.core.beans.SelectItemRelational;

@Repository
public interface ISubactividadXGrupoDao {

	public void actualizarSubactividadXGrupo(ItemPlanOperativo subactividadXGrupo);
	
	public void insertarSubactividadXGrupo(ItemPlanOperativo subactividadXGrupo);
	
	public boolean existeSubactividadXGrupo(Integer idGrupo, Integer idSubactividad);
	
	public List<SelectItemBean> listarSubactividades(Integer idActividad);
	
	public List<ItemPlanOperativo> listarActividades(Integer idGrupo);
}
