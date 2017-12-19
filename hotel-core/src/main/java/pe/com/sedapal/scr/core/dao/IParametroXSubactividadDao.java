package pe.com.sedapal.scr.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.sedapal.scr.core.beans.ItemPlanOperativo;
import pe.com.sedapal.scr.core.beans.SelectItemBean;

@Repository
public interface IParametroXSubactividadDao {

	public void actualizarParametroXSubactividad(ItemPlanOperativo subactividadXGrupo);
	
	public void insertarParametroXSubactividad(ItemPlanOperativo subactividadXGrupo);
	
	public boolean existeParametroXSubactividad(Integer idSubactividadXActividad, Integer idParametro);
	
	public List<ItemPlanOperativo> listarSubActividades(Integer idActividad);
	
	public List<SelectItemBean> listarParametros(Integer idActividad);
	
}
