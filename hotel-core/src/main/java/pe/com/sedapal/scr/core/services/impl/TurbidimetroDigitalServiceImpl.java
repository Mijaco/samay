package pe.com.sedapal.scr.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.TurbidimetroDigitalBean;
import pe.com.sedapal.scr.core.beans.TurbidimetroDigitalVerificacionBean;
import pe.com.sedapal.scr.core.dao.ITurbidimetroDigitalDao;
import pe.com.sedapal.scr.core.services.ITurbidimetroDigitalService;



@Service
public class TurbidimetroDigitalServiceImpl implements ITurbidimetroDigitalService{

	@Autowired
	private ITurbidimetroDigitalDao verificacionEquipoDao;
	
	@Override
	public Result obtenerDatosEquipos(TurbidimetroDigitalBean verificacionEquipoBean, Paginacion paginacion)
			throws Exception {
		// TODO Auto-generated method stub
		return verificacionEquipoDao.obtenerDatosEquipos(verificacionEquipoBean, paginacion);
	}

	@Override
	public TurbidimetroDigitalBean obtenerVerificacionEquipo(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return verificacionEquipoDao.obtenerVerificacionEquipo(id);
	}

	@Override
	public int grabarVerificacionEquipo(TurbidimetroDigitalBean verificacionEquipoBean) throws Exception {
		// TODO Auto-generated method stub
		return verificacionEquipoDao.grabarVerificacionEquipo(verificacionEquipoBean);
	}

	@Override
	public void actualizarVerificacionEquipo(TurbidimetroDigitalBean verificacionEquipoBean) throws Exception {
		verificacionEquipoDao.actualizarVerificacionEquipo(verificacionEquipoBean);
		
	}

	@Override
	public void inactivarVerificacionEquipo(TurbidimetroDigitalBean verificacionEquipoBean) throws Exception {
		verificacionEquipoDao.inactivarVerificacionEquipo(verificacionEquipoBean);
		
	}

	@Override
	public Result obtenerDatosEquiposVerificacion(TurbidimetroDigitalVerificacionBean turbidimetroDigitalVerificacionBean, Paginacion paginacion)
			throws Exception {
		return verificacionEquipoDao.obtenerDatosEquiposVerificacion(turbidimetroDigitalVerificacionBean, paginacion);
		
	}

	@Override
	public int grabarVerificacionEquipoForm(TurbidimetroDigitalVerificacionBean turbidimetroDigitalVerificacionBean)
			throws Exception {
		return verificacionEquipoDao.grabarVerificacionEquipoForm(turbidimetroDigitalVerificacionBean);
	}

	@Override
	public void inactivarVerificacionEquipoForm(TurbidimetroDigitalVerificacionBean turbidimetroDigitalVerificacionBean)
			throws Exception {
		verificacionEquipoDao.inactivarVerificacionEquipoForm(turbidimetroDigitalVerificacionBean);
		
	}
	

}
