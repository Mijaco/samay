package pe.com.sedapal.scr.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.Formulario314;
import pe.com.sedapal.scr.core.dao.IFormulario314Dao;
import pe.com.sedapal.scr.core.services.IFormulario314Service;

@Service
public class Formulario314ServiceImpl implements IFormulario314Service {
	
	@Autowired
	private IFormulario314Dao iFormulario314Dao;

	@Override
	public Result getListadoFormulario314(Formulario314 formulario314, Paginacion paginacion) {
	
		return iFormulario314Dao.getListadoFormulario314(formulario314, paginacion);
	}

	@Override
	public void grabarFormulario314(Formulario314 formulario314) {
		
		iFormulario314Dao.grabarFormulario314(formulario314);
		
	}

	@Override
	public Formulario314 getFormulario314(Integer id) {
		
		return iFormulario314Dao.getFormulario314(id);
	}

	@Override
	public void updateFormulario314(Formulario314 formulario314) {
		
		iFormulario314Dao.updateFormulario314(formulario314);
		
	}

	@Override
	public void inactivarForm314(Formulario314 formulario314) {
		
		iFormulario314Dao.inactivarForm314(formulario314);
	}

}
