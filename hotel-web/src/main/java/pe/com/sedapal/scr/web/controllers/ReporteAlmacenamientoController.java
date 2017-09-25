/**
 * 
 * Resumen.
 * Objeto : ReporteAlmacenamientoController
 * Descripción : Clase controladora para la generación de reporte gráfico de almacenamiento
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
import pe.com.sedapal.scr.core.services.IMantRepresaService;
import pe.com.sedapal.scr.core.services.IRepresasService;


@Controller
@PropertySources(value = { @PropertySource(name = "props", value = {
		"classpath:application.properties" }, ignoreResourceNotFound = true) })
public class ReporteAlmacenamientoController {

	@Autowired
	IMantRepresaService mantRepresaService;
	
	@Autowired
	IRepresasService represasService;

	/**
	 * Método que permite redirigir a la vista de Reporte Gráfico de Almacenamiento
	 * @param model permite la abstracción completa de la tecnología de vista
	 * @return Objeto de tipo String con el nombre de la página o vista a redireccionar
	 **/
	@RequestMapping(value = "/reporteAlmacenamiento", method = RequestMethod.GET)
	public String contratos(ModelMap model) throws Exception{
		
		List<SelectItemBean> represasSelect = mantRepresaService.obtenerRepresasActivas();
		model.addAttribute("represasActivas", represasSelect);
		
		return "reporteAlmacenamiento";
	}
	
	/**
	 * Método que envía la data y metadata para la visualización del reporte gráfico en la capa de presentación
	 * @param periodo Es el periodo (mes específico) para el cual se desea generar el reporte
	 * @param represasToGraph Es la colección de códigos de represas para los que se desea mostrar la información en el reporte
	 * @return Objeto de tipo ReporteWrapperBean que enmascara la data y metadata para la generación del reporte
	 **/
	@RequestMapping(value = "/reporteAlmacenamiento/obtenerData", method = RequestMethod.GET)
	public @ResponseBody ReporteWrapperBean obtenerData(
			@RequestParam(value="periodo") String periodo,
			@RequestParam(value="represasToGraph", required=false) String[] represasToGraph) throws Exception {
		
		ReporteWrapperBean wrapperReport = new ReporteWrapperBean();
		wrapperReport = represasService.generarReporteRepresaGrafico(periodo, represasToGraph, 
				pe.com.sedapal.scr.core.common.Constants.REPORT_TYPE_VOLUMEN);
		
		return wrapperReport;
	}
}
