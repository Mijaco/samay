package pe.com.sedapal.scr.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.scr.core.beans.ItemPlanOperativo;
import pe.com.sedapal.scr.core.beans.SelectItemBean;
import pe.com.sedapal.scr.core.dao.ISubactividadXGrupoDao;
import pe.com.sedapal.scr.core.services.ISubactividadXGrupoService;

@Service
public class SubactividadXGrupoServiceImpl implements ISubactividadXGrupoService{
	
	@Autowired
	private ISubactividadXGrupoDao subactividadXGrupoDao;

	@Override
	public void actualizarSubactividadXGrupo(ItemPlanOperativo subactividadXGrupo) {
		subactividadXGrupoDao.actualizarSubactividadXGrupo(subactividadXGrupo);
	}

	@Override
	public void insertarSubactividadXGrupo(ItemPlanOperativo subactividadXGrupo) {
		 subactividadXGrupoDao.insertarSubactividadXGrupo(subactividadXGrupo);
	}

	@Override
	public boolean existeSubactividadXGrupo(Integer idGrupo, Integer idSubactividad) {
		return subactividadXGrupoDao.existeSubactividadXGrupo(idGrupo, idSubactividad);
	}

	@Override
	public List<ItemPlanOperativo> listarActividades(Integer idArea) {
		return subactividadXGrupoDao.listarActividades(idArea);
	}
	
	@Override
	public List<SelectItemBean> listarSubactividades(Integer idMaster) {
		return subactividadXGrupoDao.listarSubactividades(idMaster);
	}
	
}
