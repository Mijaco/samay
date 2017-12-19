package pe.com.sedapal.scr.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.EnsayoCloro;
import pe.com.sedapal.scr.core.beans.EnsayoCloroDetalle;
import pe.com.sedapal.scr.core.dao.IEnsayoCloroDao;
import pe.com.sedapal.scr.core.services.IEnsayoCloroService;

@Service
public class IEnsayoCloroServiceImpl implements IEnsayoCloroService{
	
	@Autowired
	IEnsayoCloroDao ensayoCloroDao;
	
	@Override
	public Result obtenerDatosEnsayoCloro(EnsayoCloro ensayoCloro, Paginacion paginacion) {
		return ensayoCloroDao.obtenerDatosEnsayoCloro(ensayoCloro, paginacion);
	}

	@Override
	public List<EnsayoCloroDetalle> obtenerListEnsayoCloro(Integer fechaMuestreo, String hora) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarEnsayoCloro(EnsayoCloro ensayoCloro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarEnsayoCloroDetalle(EnsayoCloroDetalle ensayoCloroDetalle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inactivarEnsayoCloro(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inactivarCloroDetalle(Integer id) {
		// TODO Auto-generated method stub
		
	}

	
}
