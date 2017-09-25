package pe.com.sedapal.scr.web.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import pe.com.sedapal.scr.correo.job.ETLMensajesCorreoJob;
import pe.com.sedapal.scr.correo.job.ETLReportesResumenJob;

@Service
public class Scheduller {
	
	@Autowired
	private ETLMensajesCorreoJob etlMensajeCorreoJob;
	
	@Autowired
	private ETLReportesResumenJob etlReportesResumenJob;
	
	/**
	 * Método que permite ejecutar la tarea programada de extracción de correo
	 * @Return No hay objeto de retorno 
	 * @throws Exception Excepción que puede ser lanzada
	 */
	@Scheduled(fixedRate=3600000) // 1h ==== 3600000 ms
	public void executeExtraccion() throws Exception {
		System.out.println("INICIANDO PROCESO AUTOMATICO (EXTRACCION DE CORREO)");
		System.out.println(etlMensajeCorreoJob);
		this.etlMensajeCorreoJob.execute();
		System.out.println("FINALIZANDO PROCESO AUTOMATICO (EXTRACCION DE CORREO)");
	}
	
	/**
	 * Método que permite ejecutar la tarea programada de envío de correo
	 * @Return No hay objeto de retorno 
	 * @throws Exception Excepción que puede ser lanzada
	 */
	@Scheduled(fixedRate=86400000) // 24h ==== 86400000 ms
	public void executeResumen() throws Exception {
		System.out.println("INICIANDO PROCESO DE ENVIO DE CORREO RESUMEN DESDE SCRWEB");
		System.out.println(etlReportesResumenJob);
		this.etlReportesResumenJob.execute();
		System.out.println("FINALIZANDO PROCESO DE ENVIO DE CORREO RESUMEN DESDE SCRWEB");
	}
	
}
