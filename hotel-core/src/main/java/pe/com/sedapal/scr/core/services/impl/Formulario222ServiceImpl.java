package pe.com.sedapal.scr.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.FormularioDetalle222;
import pe.com.sedapal.scr.core.beans.FormularioHeader222;
import pe.com.sedapal.scr.core.dao.IFormulario222Dao;
import pe.com.sedapal.scr.core.services.IFormulario222Service;


@Service
public class Formulario222ServiceImpl implements IFormulario222Service {
	
	@Autowired
	private IFormulario222Dao iFormulario222Dao;

	@Override
	public Result getListadoFormularioHeader(FormularioHeader222 formularioHeader222, Paginacion paginacion) {
		
		return iFormulario222Dao.getListadoFormularioHeader(formularioHeader222, paginacion);
	}

	@Override
	public FormularioHeader222 getFormularioHeader(Integer id) {
		
		return iFormulario222Dao.getFormularioHeader(id);
	}

	@Override
	public void grabarFormularioHeader(FormularioHeader222 formularioHeader222) {
		
		iFormulario222Dao.grabarFormularioHeader(formularioHeader222);
	}

	@Override
	public void grabarFormularioDetalle(FormularioDetalle222 formularioDetalle222) {
		
		iFormulario222Dao.grabarFormularioDetalle(formularioDetalle222);
	}

	@Override
	public Result getListadoFormularioDetalle(FormularioDetalle222 formularioDetalle222, Paginacion paginacion) {

		return iFormulario222Dao.getListadoFormularioDetalle(formularioDetalle222, paginacion);
	}

	@Override
	public void updateFormularioHeader(FormularioHeader222 formularioHeader222) {
		
		iFormulario222Dao.updateFormularioHeader(formularioHeader222);
		
	}

	@Override
	public FormularioDetalle222 getFormularioDetalle(Integer id) {
		
		return iFormulario222Dao.getFormularioDetalle(id);
	}

	@Override
	public void updateFormularioDetalle(FormularioDetalle222 formularioDetalle222) {
		
		iFormulario222Dao.updateFormularioDetalle(formularioDetalle222);
		
	}

	@Override
	public void inactivarFormularioDetalle(FormularioDetalle222 formularioDetalle222) {
		
		iFormulario222Dao.inactivarFormularioDetalle(formularioDetalle222);
		
	}

	@Override
	public int registrosPorHeader(int header) {

		return iFormulario222Dao.registrosPorHeader(header);
	}	
	
}
