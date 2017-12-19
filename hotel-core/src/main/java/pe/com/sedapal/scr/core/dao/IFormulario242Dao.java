package pe.com.sedapal.scr.core.dao;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.Formulario153;
import pe.com.sedapal.scr.core.beans.FormularioDetalle242;
import pe.com.sedapal.scr.core.beans.FormularioHeader242;

public interface IFormulario242Dao {
	
	Result getListadoFormularioHeader(FormularioHeader242 formularioHeader242, Paginacion paginacion);
	
	void grabarFormularioHeader(FormularioHeader242 formularioHeader242);
	
	FormularioHeader242 getFormularioHeader(Integer id);
	
	FormularioDetalle242 getFormularioDetalle(Integer id);
	
	void grabarFormularioDetalle(FormularioDetalle242 formularioDetalle242);
	
	void inactivarFormularioDetalle(FormularioDetalle242 formularioDetalle242);
	
	Result getListadoFormularioDetalle(FormularioDetalle242 formularioDetalle242, Paginacion paginacion);
	
	void updateFormularioDetalle(FormularioDetalle242 formularioDetalle242);
	
	void updateFormularioHeader(FormularioHeader242 formularioHeader242);
	
	void inactivarFormularioHeader(FormularioHeader242 formularioHeader242);

}
