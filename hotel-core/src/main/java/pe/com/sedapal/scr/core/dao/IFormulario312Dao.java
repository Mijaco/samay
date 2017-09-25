package pe.com.sedapal.scr.core.dao;

import java.util.List;

import pe.com.sedapal.scr.core.beans.Formulario312;

public interface IFormulario312Dao {
	
	List<Formulario312> generarReporte(String periodo) throws Exception;

}
