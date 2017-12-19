package pe.com.sedapal.scr.web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.common.core.utils.ConstantsCommon;
import pe.com.sedapal.scr.core.beans.ReporteFitoplancton;
import pe.com.sedapal.scr.core.beans.ReporteFitoplanctonDetalle;
import pe.com.sedapal.scr.core.common.ConstantsLaboratorio;
import pe.com.sedapal.scr.core.services.IAnalisisHibroBiologicoService;
import pe.com.sedapal.scr.core.services.ICatalogoService;
import pe.com.sedapal.scr.core.services.IReporteFitoplanctonService;
import pe.com.sedapal.scr.web.common.Constants;
import pe.com.sedapal.scr.web.common.Util;

@Controller
@PropertySources(value = { @PropertySource(name = "props", value = {
"classpath:application.properties" }, ignoreResourceNotFound = true) })
public class ReporteFitoplanctonController {

private static final Logger LOG = LoggerFactory.getLogger(ReporteFitoplanctonController.class);
	
	@Autowired
	Environment env;

	@Autowired
	MessageSource messageSource;

	@Autowired
	IAnalisisHibroBiologicoService analisisHibroBiologicoService;

	@Autowired
	IReporteFitoplanctonService reporteFitoplanctonService;
	
	@Autowired
	ICatalogoService catalogoService;
	
	
	@RequestMapping(value = "/reporteFitoplancton/pagination", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Map<String,Object>> obtenerDatos(@RequestParam Map<String,String> allRequestParams){
			
		
		String fechaReporte;
		try {
			
			Paginacion paginacion = new Paginacion();
			paginacion.setCantidadpag(Integer.parseInt(allRequestParams.get("length")));
			paginacion.setPagdesde(Integer.parseInt(allRequestParams.get("start")));
			paginacion.setColorderby( Integer.parseInt(allRequestParams.get(ConstantsLaboratorio.ORDER_COLUMN_TABLE))==0?Integer.parseInt(allRequestParams.get(ConstantsLaboratorio.ORDER_COLUMN_TABLE))+1:Integer.parseInt(allRequestParams.get(ConstantsLaboratorio.ORDER_COLUMN_TABLE)));
			paginacion.setColorderbydir(allRequestParams.get("order[0][dir]"));
			fechaReporte = allRequestParams.get("fechaReporte");
			
			StringBuilder log = new StringBuilder();
			log.append("fechaReporte: ").append(fechaReporte);
			String rastros = log.toString();
			LOG.info(rastros);

			Result result = reporteFitoplanctonService.datosReporteFitoplancton(fechaReporte, paginacion);
			
			Map<String,Object> dtResponse = new HashMap<String, Object>();
			dtResponse.put("draw", allRequestParams.get("draw"));
			dtResponse.put("recordsTotal", result.getRecords());
			dtResponse.put("recordsFiltered", result.getRecords());
			dtResponse.put("data", result.getData());
			
			return new ResponseEntity<>(dtResponse, HttpStatus.OK);
			
		} catch (Exception e) {			
			LOG.error(e.getMessage(), e);	
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/reporteFitoplancton", method = RequestMethod.GET)
	public String reporteAnalisisHidroBiologico(HttpServletRequest request, HttpSession session,
			Model model, @ModelAttribute("reporteAnalisisHidroMain") ReporteFitoplancton reporteFitoplancton) {
		ArrayList<ReporteFitoplanctonDetalle> listDetalle = new ArrayList<>();
		reporteFitoplancton.setDetalles(listDetalle);
		
		model.addAttribute("reporteAnalisisHidroMain", reporteFitoplancton);
		
		return "reporteFitoplancton/reporteFitoplancton";
		
	}
	
	
	@RequestMapping(value = "/reporteFitoplanctonSearch/{idCorrelativo}", method = RequestMethod.GET)
	public String reporteAnalisisHidroSearch(HttpServletRequest request, HttpSession session,
			Model model, @ModelAttribute("reporteAnalisisHidroMain") ReporteFitoplancton reporteFitoplanctonMain,@PathVariable int idCorrelativo) {

		ArrayList<ReporteFitoplanctonDetalle> listDetalle;
		
		try {
			
			listDetalle = reporteFitoplanctonService.obtenerDetallePorCorrelativo(idCorrelativo);
			
			reporteFitoplanctonMain.setFechaMuestreo(listDetalle.get(0).getFechaMuestreo());
			reporteFitoplanctonMain.setPersonaMuestra(listDetalle.get(0).getPersonaMuestra());
			reporteFitoplanctonMain.setAnalista(listDetalle.get(0).getAnalista());
			reporteFitoplanctonMain.setDetalles(listDetalle);
			
		} catch (Exception e) {
			reporteFitoplanctonMain.setDetalles(new ArrayList<ReporteFitoplanctonDetalle>());
			LOG.info(e.getMessage());
		}
		
		model.addAttribute("reporteAnalisisHidroMain", reporteFitoplanctonMain);
		return "reporteFitoplancton/reporteFitoplanctonTableDetalle :: resultsList";
		
	}
	
	
	// METODO PARA REF4ESCAR TABLA
	@RequestMapping(value = "/reporteFitoplanctonPorFecha", method = RequestMethod.GET)
	public String refrescarReportePorFecha(HttpServletRequest request, HttpSession session,
			Model model,@RequestParam Map<String,String> allRequestParams){
			return "reporteFitoplancton/reporteFitoplanctonTable :: resultsList";
	}
	
	
	@RequestMapping(value = "/reporteFitoplanctonSave", method = RequestMethod.POST)
	public String reporteFitoplanctonSave(ModelMap model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("reporteAnalisisHidroMain") ReporteFitoplancton reporteFitoplancton){

		String strMensajeTipo = "";
		String strMensajeError = "";
		String strMensajeMostrar = "";
		int cantidadRegistrosInsertados = 0;
		ArrayList<ReporteFitoplanctonDetalle> detalles;
		try {
				detalles = reporteFitoplancton.getDetalles();
				
				StringBuilder log = new StringBuilder();
				log.append("reporteFitoplancton: ").append(reporteFitoplancton);
				String rastros = log.toString();
				LOG.info(rastros);
				
				int correlativoReporte = reporteFitoplanctonService.obtenerCorrelativoDetalleReporte();
				correlativoReporte++;
				
				if(detalles==null || detalles.isEmpty()){
					
					model.addAttribute(Constants.MENSAJE_MOSTRAR,obtenerMensaje("reporte.hidrobiologico.registros.vacio"));
					
				} else {
				
				for (ReporteFitoplanctonDetalle reporteFitoplanctonDetalle : detalles) {
					try {
					
						if (reporteFitoplanctonDetalle.getCodsub() != null) {

							reporteFitoplanctonDetalle.setFechaMuestreo(reporteFitoplancton.getFechaMuestreo());
							reporteFitoplanctonDetalle.setPersonaMuestra(reporteFitoplancton.getPersonaMuestra());
							reporteFitoplanctonDetalle.setAnalista(reporteFitoplancton.getAnalista());
							reporteFitoplanctonDetalle.setCorrelativo(correlativoReporte);

							reporteFitoplanctonDetalle.setPrograma(ConstantsLaboratorio.PROGRAMA_INSERT_REPORTEFITO);
							reporteFitoplanctonDetalle.setUsuarioCreacion(Util.getUserLoged());
							reporteFitoplanctonDetalle.setUsuarioModificacion(Util.getUserLoged());

							LOG.info("FechaMuestreo: " + reporteFitoplancton.getFechaMuestreo());
							reporteFitoplanctonService.insertarReporteFitoplancton(reporteFitoplanctonDetalle);
							cantidadRegistrosInsertados++;
						}
						
						
						if(cantidadRegistrosInsertados == 0){
							strMensajeMostrar = obtenerMensaje("reporte.guardado.no.datos");
						}else{
							strMensajeMostrar = obtenerMensaje("analisis.hidrobiologico.guardado");
						}
						
					} catch (Exception e) {
						
						LOG.info(e.toString());
					}
				}
				
					
				}
				
				strMensajeTipo = ConstantsCommon.GRABADO_OK;
				model.addAttribute(Constants.MENSAJE_MOSTRAR,strMensajeMostrar);
				model.addAttribute("reporteAnalisisHidroMain",reporteFitoplancton);
				
		} catch (Exception e) {
		
			strMensajeTipo = ConstantsCommon.GRABADO_NO_OK;
			model.addAttribute(Constants.MENSAJE_MOSTRAR,obtenerMensaje("reporte.hidrobiologico.error"));
			strMensajeError = e.getMessage();
		}
		
		model.addAttribute(Constants.MENSAJE_TIPO, strMensajeTipo);
		model.addAttribute(Constants.MENSAJE_ERROR, strMensajeError);
		return "generic/genericSave :: genericSave";
		
	}
	
	@RequestMapping(value = "/cargarRegistroFitoplancton", method = RequestMethod.GET)
	public String cargarRegistro(HttpServletRequest request, HttpSession session,
			Model model,@RequestParam Map<String,String> allRequestParams){
		
		String fechaMuestreo = allRequestParams.get("fechaMuestreo");
		Integer indiceRow = Integer.parseInt(allRequestParams.get("indiceRow"));
		Integer puntoMuestra = Integer.parseInt(allRequestParams.get("puntoMuestra"));
		Integer valueSelectPunto = Integer.parseInt(allRequestParams.get("valueSelectPunto"));
		
		
		String idMuestrador = allRequestParams.get("idMuestrador");
		String idAnalista = allRequestParams.get("idAnalista");
		
		StringBuilder log = new StringBuilder();
		log.append("idMuestrador: ").append(idMuestrador).append("; idAnalista: ").append(idAnalista);
		String rastros = log.toString();
		LOG.info(rastros);
		
		ReporteFitoplanctonDetalle reporteFitoplanctonDetalle = reporteFitoplanctonService.datosDetalleReporteFitoplancton(fechaMuestreo, puntoMuestra);
		
		reporteFitoplanctonDetalle.setValueSelectPunto(valueSelectPunto);

		model.addAttribute("registroReporteDetalle",reporteFitoplanctonDetalle);
		model.addAttribute("indiceDetalle",indiceRow);
		
		return "reporteFitoplancton/reporteFitoplanctonTableDetalle :: registroDetalle";
	}
	
	@RequestMapping(value = "/eliminarReportePorCorrelativo/{idCorrelativo}", method = RequestMethod.POST)
	public String eliminarReportePorCorrelativo(HttpServletRequest request, HttpSession session,
			Model model,@RequestParam Map<String,String> allRequestParams,@PathVariable int idCorrelativo){
		
		String strMensajeTipo;
		String strMensajeError = ConstantsLaboratorio.EMPTY_VALUE;
		try{
			
			strMensajeTipo = ConstantsCommon.GRABADO_OK;
			model.addAttribute(Constants.MENSAJE_MOSTRAR,obtenerMensaje("reporte.eliminado.ok"));
			reporteFitoplanctonService.eliminarReportePorCorrelativo(idCorrelativo);
			
		} catch (Exception e) {
		LOG.error( ConstantsLaboratorio.EMPTY_VALUE,e);
		strMensajeTipo = ConstantsCommon.GRABADO_NO_OK;
		model.addAttribute(Constants.MENSAJE_MOSTRAR,obtenerMensaje("reporte.eliminado.error"));
		strMensajeError = e.getMessage();
		}

		model.addAttribute(Constants.MENSAJE_TIPO, strMensajeTipo);
		model.addAttribute(Constants.MENSAJE_ERROR, strMensajeError);
		return "generic/genericSave :: genericSave";
		
	}

	
	public String obtenerMensaje(String messageProp){
		return messageSource.getMessage(messageProp, new Object[] {}, Locale.US);
	}
	


}
