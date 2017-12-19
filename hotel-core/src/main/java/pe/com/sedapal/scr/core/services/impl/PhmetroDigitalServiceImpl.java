package pe.com.sedapal.scr.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.PhmetroDigitalBean;
import pe.com.sedapal.scr.core.beans.PhmetroDigitalDetalleBean;
import pe.com.sedapal.scr.core.dao.IPhmetroDigitalDao;
import pe.com.sedapal.scr.core.services.IPhmetroDigitalService;

@Service
public class PhmetroDigitalServiceImpl implements IPhmetroDigitalService{

	@Autowired
	private IPhmetroDigitalDao phmetroDigitalDao;
	
	@Override
	public Result obtenerDatosEquipos(PhmetroDigitalBean phmetroDigitalBean, Paginacion paginacion) throws Exception {
		return phmetroDigitalDao.obtenerDatosEquipos(phmetroDigitalBean, paginacion);
	}

	@Override
	public PhmetroDigitalBean obtenerPhmetroDigital(Integer id) throws Exception {
		return phmetroDigitalDao.obtenerPhmetroDigital(id);
	}

	@Override
	public int grabarPhmetroDigital(PhmetroDigitalBean phmetroDigitalBean) throws Exception {
		return phmetroDigitalDao.grabarPhmetroDigital(phmetroDigitalBean);
	}

	@Override
	public void actualizarPhmetroDigital(PhmetroDigitalBean phmetroDigitalBean) throws Exception {
		phmetroDigitalDao.actualizarPhmetroDigital(phmetroDigitalBean);
		
	}

	@Override
	public void inactivarPhmetroDigital(PhmetroDigitalBean phmetroDigitalBean) throws Exception {
		phmetroDigitalDao.inactivarPhmetroDigital(phmetroDigitalBean);
		
	}

	@Override
	public Result obtenerDatosEquiposDetalle(PhmetroDigitalDetalleBean phmetroDigitalDetalleBean, Paginacion paginacion)
			throws Exception {
		return phmetroDigitalDao.obtenerDatosEquiposDetalle(phmetroDigitalDetalleBean, paginacion);
	}

	@Override
	public int grabarPhmetroDigitalDetalle(PhmetroDigitalDetalleBean phmetroDigitalDetalleBean) throws Exception {
		return phmetroDigitalDao.grabarPhmetroDigitalDetalle(phmetroDigitalDetalleBean);
	}

	@Override
	public void inactivarPhmetroDigitalDetalle(PhmetroDigitalDetalleBean phmetroDigitalDetalleBean) throws Exception {
		phmetroDigitalDao.inactivarPhmetroDigitalDetalle(phmetroDigitalDetalleBean);
		
	}

}
