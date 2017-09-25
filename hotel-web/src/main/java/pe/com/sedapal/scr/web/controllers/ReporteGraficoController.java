/**
 * 
 * Resumen.
 * Objeto : ReporteGraficoController
 * Descripción : Clase controladora para la generación de reporte grafico por represas
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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.sedapal.common.core.beans.SelectItemBean;
import pe.com.sedapal.scr.core.beans.ReporteWrapperBean;
import pe.com.sedapal.scr.core.services.ICaudalService;
import pe.com.sedapal.scr.core.services.IMantRioService;

@Controller
@PropertySources(value = { @PropertySource(name = "props", value = {
		"classpath:application.properties" }, ignoreResourceNotFound = true) })
public class ReporteGraficoController {

	@Autowired
	MessageSource messageSource;
	
	@Autowired
	ICaudalService caudalService;
	
	@Autowired
	IMantRioService mantRioService;
	
	/**
	 * Método que permite redirigir a la vista de Reporte Grafico por Represas
	 * @param model permite la abstracción completa de la tecnología de vista
	 * @return Objeto de tipo String con el nombre de la página o vista a redireccionar
	 **/
	@RequestMapping(value = "/reportesGrafico", method = RequestMethod.GET)
	public String goToReporteGrafico(ModelMap model) throws Exception{
		
		List<SelectItemBean> riosSelect = mantRioService.obtenerRiosActivos();
		model.addAttribute("riosActivos", riosSelect);
		
		return "reportesGrafico";
	}
	
	/**
	 * Método que envía la data y metadata para la visualización del reporte gráfica en la capa de presentación
	 * @param periodo Es el periodo (mes específico) para el cual se desea generar el reporte
	 * @param rioToGraph Es la colección de códigos de ríos para los que se desea mostrar la información en el reporte
	 * @return Objeto de tipo ReporteWrapperBean que enmascara la data y metadata para la generación del reporte
	 **/
	@RequestMapping(value = "/reportesGrafico/obtenerData", method = RequestMethod.GET)
	public @ResponseBody ReporteWrapperBean obtenerData(
			@RequestParam(value="periodo") String periodo,
			@RequestParam(value="riosToGraph", required=false) String[] riosToGraph) throws Exception {
		
		ReporteWrapperBean wrapperReport = new ReporteWrapperBean();
		wrapperReport = caudalService.generarReporteResumenCaudalGrafico(periodo, riosToGraph);
		
		return wrapperReport;
	}
	
}
