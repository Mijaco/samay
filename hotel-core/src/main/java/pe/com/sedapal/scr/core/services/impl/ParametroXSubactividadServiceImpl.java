package pe.com.sedapal.scr.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.scr.core.beans.ItemPlanOperativo;
import pe.com.sedapal.scr.core.beans.SelectItemBean;
import pe.com.sedapal.scr.core.dao.IParametroXSubactividadDao;
import pe.com.sedapal.scr.core.services.IParametroXSubactividadService;

@Service
public class ParametroXSubactividadServiceImpl implements IParametroXSubactividadService{

	@Autowired
	IParametroXSubactividadDao parametroXSubactividadDao;
	
	@Override
	public void actualizarParametroXSubactividad(ItemPlanOperativo subactividadXGrupo) {
		parametroXSubactividadDao.actualizarParametroXSubactividad(subactividadXGrupo);
	}

	@Override
	public void insertarParametroXSubactividad(ItemPlanOperativo subactividadXGrupo) {
		parametroXSubactividadDao.insertarParametroXSubactividad(subactividadXGrupo);
	}

	@Override
	public boolean existeParametroXSubactividad(Integer idSubactividadXActividad, Integer idParametro) {
		return parametroXSubactividadDao.existeParametroXSubactividad(idSubactividadXActividad, idParametro);
	}

	@Override
	public List<ItemPlanOperativo> listarSubActividades(Integer idActividad) {
		return parametroXSubactividadDao.listarSubActividades(idActividad);
	}

	@Override
	public List<SelectItemBean> listarParametros(Integer idSubActividad) {
		return parametroXSubactividadDao.listarParametros(idSubActividad);
	}

}
