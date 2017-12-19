package pe.com.sedapal.scr.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.FormularioDetalle242;
import pe.com.sedapal.scr.core.beans.FormularioHeader242;
import pe.com.sedapal.scr.core.dao.IFormulario242Dao;
import pe.com.sedapal.scr.core.services.IFormulario242Service;


@Service
public class Formulario242ServiceImpl implements IFormulario242Service {
	
	@Autowired
	private IFormulario242Dao iFormulario242Dao;

	@Override
	public Result getListadoFormularioHeader(FormularioHeader242 formularioHeader242, Paginacion paginacion) {
		
		return iFormulario242Dao.getListadoFormularioHeader(formularioHeader242, paginacion);
	}

	@Override
	public void grabarFormularioHeader(FormularioHeader242 formularioHeader242) {
		
		iFormulario242Dao.grabarFormularioHeader(formularioHeader242);
		
	}

	@Override
	public FormularioHeader242 getFormularioHeader(Integer id) {

		return iFormulario242Dao.getFormularioHeader(id);
	}
	
	@Override
	public FormularioDetalle242 getFormularioDetalle(Integer id) {
		
		return iFormulario242Dao.getFormularioDetalle(id);
	}

	@Override
	public void grabarFormularioDetalle(FormularioDetalle242 formularioDetalle242) {
		
		iFormulario242Dao.grabarFormularioDetalle(formularioDetalle242);
		
	}

	@Override
	public Result getListadoFormularioDetalle(FormularioDetalle242 formularioDetalle242, Paginacion paginacion) {
		
		return iFormulario242Dao.getListadoFormularioDetalle(formularioDetalle242, paginacion);
	}

	@Override
	public void inactivarFormularioDetalle(FormularioDetalle242 formularioDetalle242) {
		
		iFormulario242Dao.inactivarFormularioDetalle(formularioDetalle242);
		
	}

	@Override
	public void updateFormularioDetalle(FormularioDetalle242 formularioDetalle242) {
		
		iFormulario242Dao.updateFormularioDetalle(formularioDetalle242);
		
	}

	@Override
	public void updateFormularioHeader(FormularioHeader242 formularioHeader242) {
		
		iFormulario242Dao.updateFormularioHeader(formularioHeader242);
		
	}

	@Override
	public void inactivarFormularioHeader(FormularioHeader242 formularioHeader242) {
		
		iFormulario242Dao.inactivarFormularioHeader(formularioHeader242);
		
	}

	
	
}
