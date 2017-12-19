package pe.com.sedapal.scr.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.scr.core.beans.ActividadArea;
import pe.com.sedapal.scr.core.beans.SelectItemBean;
import pe.com.sedapal.scr.core.dao.IActividadXAreaDao;
import pe.com.sedapal.scr.core.services.IActividadXAreaService;

@Service
public class ActividadXAreaServiceImpl implements IActividadXAreaService {
	
	@Autowired
	private IActividadXAreaDao actividadXAreaDao;
	
	public void actualizarActividadXArea(ActividadArea actividadArea){
		actividadXAreaDao.actualizarActividadXArea(actividadArea);
	}
	
	public void insertarActividad(ActividadArea actividadArea) {
		actividadXAreaDao.insertarActividad(actividadArea);
	}
	
	public List<SelectItemBean> listarActividades(Integer idArea){
		return actividadXAreaDao.listarActividades(idArea);
	}

	public IActividadXAreaDao getActividadXAreaDao() {
		return actividadXAreaDao;
	}

	public void setActividadXAreaDao(IActividadXAreaDao actividadXAreaDao) {
		this.actividadXAreaDao = actividadXAreaDao;
	}

	public boolean existeActividad(Integer idArea, Integer idACtividad) {
		return actividadXAreaDao.existeActividad(idArea, idACtividad);
	}
	
	
	
}
