package pe.com.sedapal.scr.core.services;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.Formulario314;

public interface IFormulario314Service {
	
	Result getListadoFormulario314(Formulario314 formulario314, Paginacion paginacion);
	
	void grabarFormulario314(Formulario314 formulario314);
	
	Formulario314 getFormulario314(Integer id);
	
	void updateFormulario314(Formulario314 formulario314);
	
	void inactivarForm314(Formulario314 formulario314);

}
