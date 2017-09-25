package pe.com.sedapal.scr.core.services;

import pe.com.sedapal.scr.core.beans.FormularioDetalle222;
import pe.com.sedapal.scr.core.beans.FormularioHeader222;
import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;


public interface IFormulario222Service {
	
	Result getListadoFormularioHeader(FormularioHeader222 formularioHeader222, Paginacion paginacion);
	
	FormularioHeader222 getFormularioHeader(Integer id);
	
	void grabarFormularioHeader(FormularioHeader222 formularioHeader222);
	
	void grabarFormularioDetalle(FormularioDetalle222 formularioDetalle222);
	
	Result getListadoFormularioDetalle(FormularioDetalle222 formularioDetalle222, Paginacion paginacion);
	
	void updateFormularioHeader(FormularioHeader222 formularioHeader222);
	
	FormularioDetalle222 getFormularioDetalle(Integer id);
	
	void updateFormularioDetalle(FormularioDetalle222 formularioDetalle222);
	
	void inactivarFormularioDetalle(FormularioDetalle222 formularioDetalle222);
	
	int registrosPorHeader(int header);

}
