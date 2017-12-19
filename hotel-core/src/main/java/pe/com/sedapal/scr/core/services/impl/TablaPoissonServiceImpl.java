package pe.com.sedapal.scr.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.TablaPoissonBean;
import pe.com.sedapal.scr.core.dao.ITablaPoissonDao;
import pe.com.sedapal.scr.core.services.ITablaPoissonService;


@Service
public class TablaPoissonServiceImpl implements ITablaPoissonService {

	@Autowired
	private ITablaPoissonDao iTablaPoissonDao;
	
	public void setiTablaPoissonDao(ITablaPoissonDao iTablaPoissonDao) {
		this.iTablaPoissonDao = iTablaPoissonDao;
	}



	@Override
	public Result obtenerDatosPoisson(TablaPoissonBean tablaPoissonBean, Paginacion paginacion) throws Exception {
		
		return iTablaPoissonDao.obtenerDatosPoisson(tablaPoissonBean, paginacion);
	}



	@Override
	public TablaPoissonBean obtenerTablaPoisson(Integer id) throws Exception {
		return iTablaPoissonDao.obtenerTablaPoisson(id);
	}



	@Override
	public int grabarTablaPoisson(TablaPoissonBean tablaPoissonBean) throws Exception {
		return iTablaPoissonDao.grabarTablaPoisson(tablaPoissonBean);		
	}



	@Override
	public void actualizarTablaPoisson(TablaPoissonBean tablaPoissonBean) throws Exception {
		iTablaPoissonDao.actualizarTablaPoisson(tablaPoissonBean);
		
	}



	@Override
	public void inactivarTablaPoisson(TablaPoissonBean tablaPoissonBean) throws Exception {
		iTablaPoissonDao.inactivarTablaPoisson(tablaPoissonBean);
		
	}

}
