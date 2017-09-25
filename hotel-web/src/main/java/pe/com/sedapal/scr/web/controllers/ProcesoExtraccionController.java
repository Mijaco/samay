package pe.com.sedapal.scr.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.sedapal.scr.core.beans.DatosExtraccionCorreoBean;
import pe.com.sedapal.scr.core.services.IProcesoService;
import pe.com.sedapal.scr.correo.job.ETLMensajesCorreoJob;

@Controller
@PropertySources(value = { @PropertySource(name = "props", value = {
		"classpath:application.properties" }, ignoreResourceNotFound = true) })
public class ProcesoExtraccionController {

	@Autowired
	IProcesoService procesoService;

	@Autowired
	ETLMensajesCorreoJob etlMensajesCorreoJob;
	
	/**
	 * Método que permite redirigir a la vista de Ejecución de proceso de extraccion de correo
	 * @param model permite la abstracción completa de la tecnología de vista
	 * @return Objeto de tipo String con el nombre de la página o vista a redireccionar
	 * @throws Exception Excepción que puede ser lanzada
	 **/
	@RequestMapping(value = "/procesoExtraccion", method = RequestMethod.GET)
	public String procesoExtraccionGo(ModelMap model) throws Exception {
		DatosExtraccionCorreoBean bean = procesoService.obtenerCorreoExtraccion();
		
		model.addAttribute("procesoExtraccionBean", bean);
		
		return "procesoExtraccion";
	}
	
	/**
	 * Método que permite ejecutar a demanda el proceso de envío de correo de reporte resumen de gerencia
	 * @return Objeto de tipo ResponseBody con el mensaje de finalización del proceso
	 **/
	@RequestMapping(value = "/procesoExtraccion/ejecutar", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> procesoExtraccion() throws Exception {
		try {
			etlMensajesCorreoJob.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("El proceso no puedo ser ejecutado", 
					HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		return new ResponseEntity<String>("El proceso ha finalizado. Ir a bandeja de caudales para mayor detalle", 
					HttpStatus.OK);
	}
}