package pe.com.sedapal.scr.core.services;

import pe.com.sedapal.scr.core.beans.ReporteForm312Bean;

public interface IFormulario312Service {
	
	ReporteForm312Bean generarReporteResumenGrafico(String periodo, String[] ensayo) throws Exception;

}
