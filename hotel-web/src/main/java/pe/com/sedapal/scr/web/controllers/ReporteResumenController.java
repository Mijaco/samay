/**
 * 
 * Resumen.
 * Objeto : ReporteResumenController
 * Descripción : Clase controladora para la generación de reporte resumen de caudales (PDF)
 * Fecha de Creación : 27/06/2017
 * Autor : grondo
 * -----------------------------------------------------------------
 * Modificaciones
 * Fecha             Nombre                  Descripción
 * -----------------------------------------------------------------
 * 
 *
 */
package pe.com.sedapal.scr.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.jasperreports.engine.JRParameter;
import pe.com.sedapal.common.core.utils.ReporteUtil;
import pe.com.sedapal.scr.core.beans.ReporteResumenBean;
import pe.com.sedapal.scr.core.services.ICaudalService;
import pe.com.sedapal.scr.web.common.Constants;

@Controller
@PropertySources(value = { @PropertySource(name = "props", value = {
		"classpath:application.properties" }, ignoreResourceNotFound = true) })
public class ReporteResumenController {

	private static final Logger LOG = LoggerFactory.getLogger(Constants.PACKAGE);
	
	@Autowired
	Environment env;

	@Autowired
	MessageSource messageSource;
	
	@Autowired
	ICaudalService caudalService;
	
	/**
	 * Método que permite redirigir a la vista de Reporte Resumen
	 * @param HttpServletRequest solicita la solicitud de envío a la vista
	 * @param HttpSession se utiliza para almacenar información entre diferentes peticiones HTTP
	 * @return Objeto de tipo String con el nombre de la página o vista a redireccionar
	 **/
	@RequestMapping(value = "/reportesResumen", method = RequestMethod.GET)
	public String contratos(HttpServletRequest request, HttpSession session){
		return "reportesResumen";
	}
	
	/**
	 * Método que permite saber la cantidad de registros que serán visualizados en el reporte resumen (PDF)
	 * @param allRequestParams Estructura de datos con todos los parámetros que llegan en el request
	 * @return entero con la cantidad de registros
	 **/
	@RequestMapping(value = "/reportesResumenPDF/cantidad", method = RequestMethod.GET)
	public @ResponseBody int findCount(@RequestParam Map<String, String> allRequestParams) throws Exception {
		
		int cantidad = 0;
		try {
			String strFecha="";
			if(allRequestParams.get("periodo")!=null && !"".equals(allRequestParams.get("periodo"))){
				strFecha = allRequestParams.get("periodo");
			}
			List<ReporteResumenBean> result = caudalService.generarReporteResumenCaudal(strFecha);
			cantidad = result.size();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return cantidad;
	}
	
	/**
	 * Método que compila y genera el reporte PDF para mostrar en la capa de presentación
	 * @param response Es el objeto que encapsula el contenido de respuesta a las peticiones
	 * @param allRequestParams Estructura de datos con todos los parámetros que llegan en el request
	 * @param nombreArchivo Es el nombre de descarga del resporte PDF
	 * @return entero con la cantidad de registros
	 **/
	@RequestMapping(value = "/reportesResumenPDF/{nombreArchivo}", method = RequestMethod.GET)
	public @ResponseBody void reporteCompletoPdf(HttpServletResponse response,
			@RequestParam Map<String, String> allRequestParams,
			@PathVariable String nombreArchivo) {
		try {

			String strFecha="";
			if(allRequestParams.get("periodo")!=null && !"".equals(allRequestParams.get("periodo"))){
				strFecha = allRequestParams.get("periodo");
			}
			
			List<ReporteResumenBean> result = caudalService.generarReporteResumenCaudal(strFecha);
			
			String nombreJasper = "/report_resumen.jasper";
			String pdf = nombreArchivo;
			
			Map<String,Object> params = new HashMap<>();
			params.put(JRParameter.REPORT_LOCALE, Locale.US);
			params.put("BASE_DIR", this.getClass().getResource("/reportes/").getPath());
			
			ReporteUtil.generarPDF(nombreJasper, params, result, pdf, response);
			
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}
	
}
