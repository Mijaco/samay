package pe.com.sedapal.scr.core.services;

import pe.com.sedapal.scr.core.beans.BaseBean;

public interface IAlmacenamientoService {

	/**
	 * Realiza la modificación de almacenamiento
	 * @param strFecha Es la fecha para la cual se realiza la modificación
	 * @param strFormulaEmbalse Formula a evaluar
	 * @param strFormulaManDescarga Formula a evaluar
	 * @param strFormulaUno Formula a evaluar
	 * @param strFormulaDos Formula a evaluar
	 * @param auditoria Es el objeto con los datos de auditoria
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	void actualizarAlmacenamiento(String strFecha, String strFormulaEmbalse, 
			String strFormulaManDescarga, String strForumlaUno, String strForumlaDos,
			BaseBean auditoria) throws Exception;
}
