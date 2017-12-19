package pe.com.sedapal.scr.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.sedapal.scr.core.beans.ActividadArea;
import pe.com.sedapal.scr.core.beans.SelectItemBean;

@Repository
public interface IActividadXAreaDao {

	public void actualizarActividadXArea(ActividadArea actividadArea);
	
	public void insertarActividad(ActividadArea actividadArea);
	
	public boolean existeActividad(Integer idArea,Integer idACtividad);
	
	public List<SelectItemBean> listarActividades(Integer idArea);
}
