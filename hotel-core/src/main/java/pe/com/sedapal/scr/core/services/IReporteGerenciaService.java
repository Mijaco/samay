package pe.com.sedapal.scr.core.services;

public interface IReporteGerenciaService {

	/**
	 * Método que permite generar el cuadro resumen del correo a gerencia
	 * @Return Objeto de tipo String con el HTML de correo
	 * @throws Exception Excepción que puede ser lanzada
	 */
	String generarCuadroResumenReporte() throws Exception;
}
