package pe.com.sedapal.scr.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.sedapal.scr.core.beans.ReporteForm312Bean;
import pe.com.sedapal.scr.core.services.IFormulario312Service;
import pe.com.sedapal.scr.web.common.Constants;



@Controller
@PropertySources(value = { @PropertySource(name = "props", value = {
		"classpath:application.properties" }, ignoreResourceNotFound = true) })
public class Formulario312Controller {

	private static final Logger LOG = LoggerFactory.getLogger(Constants.PACKAGE);
	
	@Autowired
	IFormulario312Service iformulario312Service;
	
	@RequestMapping(value = "/formulario312", method = RequestMethod.GET)
	public String goToFormulario312(ModelMap model) throws Exception{
		
		return "formulario312/formulario312";
	}
	
	
	@RequestMapping(value = "/reportesGrafico312/obtenerData", method = RequestMethod.GET)
	public @ResponseBody ReporteForm312Bean obtenerData(
			@RequestParam(value="periodo") String periodo,
			@RequestParam(value="tipoEnsayo", required=false) String[] tipoEnsayo) throws Exception {
		
		ReporteForm312Bean wrapperReport = new ReporteForm312Bean();
		wrapperReport = iformulario312Service.generarReporteResumenGrafico(periodo, tipoEnsayo);
		
		return wrapperReport;
	}	

	
}
