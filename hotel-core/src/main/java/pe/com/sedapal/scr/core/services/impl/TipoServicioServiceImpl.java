package pe.com.sedapal.scr.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.Parametro;
import pe.com.sedapal.scr.core.dao.ITipoServicioDao;
import pe.com.sedapal.scr.core.services.ITipoServicioService;

@Service
public class TipoServicioServiceImpl implements ITipoServicioService {

	private ITipoServicioDao tipoServicioDao;
	
	@Autowired
	public void setTipoServicioDao(ITipoServicioDao tipoServicioDao) {
		this.tipoServicioDao = tipoServicioDao;
	}

	@Override
	public Result obtenerTipoDeServicio(Parametro parametro, Paginacion paginacion) throws Exception {
		return tipoServicioDao.obtenerTipoDeServicio(parametro, paginacion);
	}

	@Override
	public Parametro obtenerTipoDeServicio(Integer nid) throws Exception {
		return tipoServicioDao.obtenerTipoDeServicio(nid);
	}

	@Override
	public void grabarTipoDeServicio(Parametro parametro) throws Exception {
		tipoServicioDao.grabarTipoDeServicio(parametro);
	}

	@Override
	public void actualizarPuntoDistribucion(Parametro parametroEditBean) throws Exception {
		tipoServicioDao.actualizarPuntoDistribucion(parametroEditBean);
	}
	
	@Override
	public void inactivarTipoDeServicio(Parametro parametro) throws Exception {
		tipoServicioDao.inactivarTipoDeServicio(parametro);
	}

	

}
