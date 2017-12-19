package pe.com.sedapal.scr.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.ConductimetroDigitalBean;
import pe.com.sedapal.scr.core.beans.ConductimetroDigitalDetalleBean;
import pe.com.sedapal.scr.core.beans.PhmetroDigitalBean;
import pe.com.sedapal.scr.core.dao.IConductimetroDigitalDao;
import pe.com.sedapal.scr.core.services.IConductimetroDigitalService;

@Service
public class ConductimetroDigitalServiceImpl implements IConductimetroDigitalService {
	
	@Autowired
	IConductimetroDigitalDao conductimetroDigitalDao;
	
	@Override
	public Result obtenerDatosEquipos(ConductimetroDigitalBean conductimetroDigitalBean, Paginacion paginacion)
			throws Exception {
		return conductimetroDigitalDao.obtenerDatosEquipos(conductimetroDigitalBean, paginacion);
	}

	@Override
	public ConductimetroDigitalBean obtenerConductimetroDigital(Integer id) throws Exception {
		return conductimetroDigitalDao.obtenerConductimetroDigital(id);
	}

	@Override
	public int grabarConductimetroDigital(ConductimetroDigitalBean conductimetroDigitalBean) throws Exception {
		return conductimetroDigitalDao.grabarConductimetroDigital(conductimetroDigitalBean);
	}

	@Override
	public void actualizarConductimetroDigital(ConductimetroDigitalBean conductimetroDigitalBean) throws Exception {
		conductimetroDigitalDao.actualizarConductimetroDigital(conductimetroDigitalBean);
		
	}

	@Override
	public void inactivarConductimetroDigital(ConductimetroDigitalBean conductimetroDigitalBean) throws Exception {
		conductimetroDigitalDao.inactivarConductimetroDigital(conductimetroDigitalBean);
		
	}

	@Override
	public Result obtenerDatosEquiposDetalle(ConductimetroDigitalDetalleBean conductimetroDigitalDetalleBean, Paginacion paginacion) throws Exception {
		
		return conductimetroDigitalDao.obtenerDatosEquiposDetalle(conductimetroDigitalDetalleBean, paginacion);
	}

	@Override
	public int grabarConductimetroDigitalDetalle(ConductimetroDigitalDetalleBean conductimetroDigitalDetalleBean) throws Exception {
		return conductimetroDigitalDao.grabarConductimetroDigitalDetalle(conductimetroDigitalDetalleBean);
	}

	@Override
	public void inactivarConductimetroDigitalDetalle(ConductimetroDigitalDetalleBean conductimetroDigitalDetalleBean) throws Exception {
		conductimetroDigitalDao.inactivarConductimetroDigitalDetalle(conductimetroDigitalDetalleBean);
		
	}

}
