package pe.com.sedapal.scr.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.AlmacenamientoPTAPFirstBean;
import pe.com.sedapal.scr.core.beans.AnalisisBacteriologicoBean;
import pe.com.sedapal.scr.core.beans.MuestraFirstBean;
import pe.com.sedapal.scr.core.beans.MuestraSecondBean;
import pe.com.sedapal.scr.core.beans.ReporteAlmacenamientoPTAPBean;
import pe.com.sedapal.scr.core.beans.ResultMuestraBean;
import pe.com.sedapal.scr.core.common.ConstantsLaboratorio;
import pe.com.sedapal.scr.core.dao.IAlmacenamientoPTAPDao;
import pe.com.sedapal.scr.core.dao.IAnalisisBacteriologicoDao;
import pe.com.sedapal.scr.core.services.IAnalisisBacteriologicoService;

@Service
public class AnalisisBacteriologicoServiceImpl implements IAnalisisBacteriologicoService{

	@Autowired
	private IAnalisisBacteriologicoDao analisisBacteriologicDao;
	
	@Autowired
	private IAlmacenamientoPTAPDao almacenamientoPTAPDao;
	
	@Override
	public Result obtenerDatosEquipos(AnalisisBacteriologicoBean analisisBacteriologicoBean, Paginacion paginacion)	throws Exception {
		// TODO Auto-generated method stub
		return analisisBacteriologicDao.obtenerDatosEquipos(analisisBacteriologicoBean, paginacion);
	}

	@Override
	public AnalisisBacteriologicoBean obtenerAnalisisBacteriologico(Integer id) throws Exception {
		
		return analisisBacteriologicDao.obtenerAnalisisBacteriologico(id);
	}

	@Override
	@Transactional
	public int grabarAnalisisBacteriologico(AnalisisBacteriologicoBean analisisBacteriologicoBean) throws Exception {
		
		int idCabecera = analisisBacteriologicDao.grabarAnalisisBacteriologico(analisisBacteriologicoBean);
		
		
		String dessMuestra = "";
		
		if(analisisBacteriologicoBean.getIntIdForm() == ConstantsLaboratorio.PAR_NID_FORM_ANALISIS_BACTERIOLOGICO_BOCATOMA){
			//INICIO PRIMERA MUESTRA RESULTADO
			ResultMuestraBean resultMuestraBean = new ResultMuestraBean();
			resultMuestraBean.setIntIdCabecera(idCabecera);			
			resultMuestraBean.setIntEstado(ConstantsLaboratorio.ACTIVO);
			
			dessMuestra = "BOCATOMA 1";		
			resultMuestraBean.setStrDesMuestra(dessMuestra);
			resultMuestraBean.setIntTipo(ConstantsLaboratorio.PRIMERA_MUESTRA);
			analisisBacteriologicDao.grabarAnalisisBacteriologicoResultado(resultMuestraBean);			
		
			dessMuestra = "BOCATOMA 2";
			resultMuestraBean.setStrDesMuestra(dessMuestra);
			resultMuestraBean.setIntTipo(ConstantsLaboratorio.PRIMERA_MUESTRA);
			analisisBacteriologicDao.grabarAnalisisBacteriologicoResultado(resultMuestraBean);			
		
			dessMuestra = "DUPLICADO";
			resultMuestraBean.setStrDesMuestra(dessMuestra);
			resultMuestraBean.setIntTipo(ConstantsLaboratorio.PRIMERA_MUESTRA);
			analisisBacteriologicDao.grabarAnalisisBacteriologicoResultado(resultMuestraBean);	
			//FIN SEGUNDA MUESTRA RESULTADO
			
			
			//INICIO SEGUNDA MUESTRA RESULTADO
			dessMuestra = "ENTRADA PLANTA 1";
			resultMuestraBean.setStrDesMuestra(dessMuestra);
			resultMuestraBean.setIntTipo(ConstantsLaboratorio.SEGUNDA_MUESTRA);
			analisisBacteriologicDao.grabarAnalisisBacteriologicoResultado(resultMuestraBean);
			
			dessMuestra = "ENTRADA PLANTA 2";
			resultMuestraBean.setStrDesMuestra(dessMuestra);
			resultMuestraBean.setIntTipo(ConstantsLaboratorio.SEGUNDA_MUESTRA);
			analisisBacteriologicDao.grabarAnalisisBacteriologicoResultado(resultMuestraBean);
			
			dessMuestra = "DEC. PLANTA 1";
			resultMuestraBean.setStrDesMuestra(dessMuestra);
			resultMuestraBean.setIntTipo(ConstantsLaboratorio.SEGUNDA_MUESTRA);
			analisisBacteriologicDao.grabarAnalisisBacteriologicoResultado(resultMuestraBean);
			
			dessMuestra = "DEC. PLANTA 2";
			resultMuestraBean.setStrDesMuestra(dessMuestra);
			resultMuestraBean.setIntTipo(ConstantsLaboratorio.SEGUNDA_MUESTRA);
			analisisBacteriologicDao.grabarAnalisisBacteriologicoResultado(resultMuestraBean);
			
			dessMuestra = "PLANTA CONVENCIONAL 1";
			resultMuestraBean.setStrDesMuestra(dessMuestra);
			resultMuestraBean.setIntTipo(ConstantsLaboratorio.SEGUNDA_MUESTRA);
			analisisBacteriologicDao.grabarAnalisisBacteriologicoResultado(resultMuestraBean);
			
			dessMuestra = "FILTRADA PLANTA 1";
			resultMuestraBean.setStrDesMuestra(dessMuestra);
			resultMuestraBean.setIntTipo(ConstantsLaboratorio.SEGUNDA_MUESTRA);
			analisisBacteriologicDao.grabarAnalisisBacteriologicoResultado(resultMuestraBean);
			
			dessMuestra = "FILTRADA PLANTA 2";
			resultMuestraBean.setStrDesMuestra(dessMuestra);
			resultMuestraBean.setIntTipo(ConstantsLaboratorio.SEGUNDA_MUESTRA);
			analisisBacteriologicDao.grabarAnalisisBacteriologicoResultado(resultMuestraBean);
			
			dessMuestra = "DUPLICADO";
			resultMuestraBean.setStrDesMuestra(dessMuestra);
			resultMuestraBean.setIntTipo(ConstantsLaboratorio.SEGUNDA_MUESTRA);
			analisisBacteriologicDao.grabarAnalisisBacteriologicoResultado(resultMuestraBean);
			
			dessMuestra = "BLANCO";
			resultMuestraBean.setStrDesMuestra(dessMuestra);
			resultMuestraBean.setIntTipo(ConstantsLaboratorio.SEGUNDA_MUESTRA);
			analisisBacteriologicDao.grabarAnalisisBacteriologicoResultado(resultMuestraBean);
			//FIN SEGUNDA MUESTRA RESULTADO
			
			
			/**INICIO PRIMERA MUESTRA**/
			for(int i=1; i<10;i++){
				MuestraFirstBean  muestraFirstBean  = new MuestraFirstBean();
				muestraFirstBean.setIntIdCabecera(idCabecera);		
				muestraFirstBean.setIntEstado(ConstantsLaboratorio.ACTIVO);
				if(i<4){
					dessMuestra = "BOCATOMA 1";
					muestraFirstBean.setStrDescMuestra(dessMuestra);			
				}else if(i>3 && i<7){
					dessMuestra = "BOCATOMA 2";
					muestraFirstBean.setStrDescMuestra(dessMuestra);
					
				}else if(i>6 && i<10){
					dessMuestra = "DUPLICADO";
					muestraFirstBean.setStrDescMuestra(dessMuestra);
				}		
				analisisBacteriologicDao.grabarAnalisisBacteriologicoFirst(muestraFirstBean);
			}
			/**FIN PRIMERA MUESTRA**/
	
			/**INICIO SEGUNDA MUESTRA**/
			MuestraSecondBean muestraSecondBean = new MuestraSecondBean();
			muestraSecondBean.setIntIdCabecera(idCabecera);
			muestraSecondBean.setIntEstado(ConstantsLaboratorio.ACTIVO);
			
			muestraSecondBean.setStrDescMuestra("ENTRADA PLANTA 1");
			analisisBacteriologicDao.grabarAnalisisBacteriologicoSecond(muestraSecondBean);
			
			muestraSecondBean.setStrDescMuestra("ENTRADA PLANTA 2");
			analisisBacteriologicDao.grabarAnalisisBacteriologicoSecond(muestraSecondBean);
			
			muestraSecondBean.setStrDescMuestra("DEC. PLANTA 1");
			analisisBacteriologicDao.grabarAnalisisBacteriologicoSecond(muestraSecondBean);
			
			muestraSecondBean.setStrDescMuestra("DEC. PLANTA 2");
			analisisBacteriologicDao.grabarAnalisisBacteriologicoSecond(muestraSecondBean);
			
			muestraSecondBean.setStrDescMuestra("PLANTA CONVENCIONAL 1");
			analisisBacteriologicDao.grabarAnalisisBacteriologicoSecond(muestraSecondBean);
			
			muestraSecondBean.setStrDescMuestra("FILTRADA PLANTA 1");
			analisisBacteriologicDao.grabarAnalisisBacteriologicoSecond(muestraSecondBean);
			
			muestraSecondBean.setStrDescMuestra("FILTRADA PLANTA 2");
			analisisBacteriologicDao.grabarAnalisisBacteriologicoSecond(muestraSecondBean);
			
			muestraSecondBean.setStrDescMuestra("DUPLICADO");
			analisisBacteriologicDao.grabarAnalisisBacteriologicoSecond(muestraSecondBean);
			
			muestraSecondBean.setStrDescMuestra("BLANCO");
			analisisBacteriologicDao.grabarAnalisisBacteriologicoSecond(muestraSecondBean);
			/**FIN SEGUNDA MUESTRA**/
		}else if(analisisBacteriologicoBean.getIntIdForm() == ConstantsLaboratorio.PAR_NID_FORM_ALMACENAMIENTO_LTAP){
			//UNO
			AlmacenamientoPTAPFirstBean first = new AlmacenamientoPTAPFirstBean();
			first.setIntIdCabecera(idCabecera);
			
			first.setStrDescMuestra("Salida de Menacho 1,2,3");
			almacenamientoPTAPDao.grabarMuestraForm21(first);

			first.setStrDescMuestra("Salida de Vicentelo 1,2,3,4");
			almacenamientoPTAPDao.grabarMuestraForm21(first);
			
			first.setStrDescMuestra("Salida de Reservorio Vicentelo N° 5");
			almacenamientoPTAPDao.grabarMuestraForm21(first);
			
			first.setStrDescMuestra("Salida P-2 Cámara de regulación y distribución");
			almacenamientoPTAPDao.grabarMuestraForm21(first);
			
			first.setStrDescMuestra("BLANCO");
			almacenamientoPTAPDao.grabarMuestraForm21(first);
			
			//DOS
			ReporteAlmacenamientoPTAPBean reporteAlmacenamientoPTAPBean = new ReporteAlmacenamientoPTAPBean();
			reporteAlmacenamientoPTAPBean.setIntIdCabecera(idCabecera);
			
			reporteAlmacenamientoPTAPBean.setStrDesMuestra("COLIFORMES TOTALES UFC/100mL");
			reporteAlmacenamientoPTAPBean.setStrLimiteMaximo("0 UFC/100mL");
			reporteAlmacenamientoPTAPBean.setStrLimiteCalidad("0 UFC/100mL");
			almacenamientoPTAPDao.grabarReporteAlmacenamientoPTAP(reporteAlmacenamientoPTAPBean);
			
			reporteAlmacenamientoPTAPBean.setStrDesMuestra("COLIFORMES TERMOTOLERANTES UFC/100mL");
			reporteAlmacenamientoPTAPBean.setStrLimiteMaximo("0 UFC/100mL");
			reporteAlmacenamientoPTAPBean.setStrLimiteCalidad("0 UFC/100mL");
			almacenamientoPTAPDao.grabarReporteAlmacenamientoPTAP(reporteAlmacenamientoPTAPBean);
			
			reporteAlmacenamientoPTAPBean.setStrDesMuestra("ESCHERICHIA coli UFC/100mL");
			reporteAlmacenamientoPTAPBean.setStrLimiteMaximo("0 UFC/100mL");
			reporteAlmacenamientoPTAPBean.setStrLimiteCalidad("-");
			almacenamientoPTAPDao.grabarReporteAlmacenamientoPTAP(reporteAlmacenamientoPTAPBean);
			
			reporteAlmacenamientoPTAPBean.setStrDesMuestra("BACTERIAS HETEROTROFICAS UFC/mL");
			reporteAlmacenamientoPTAPBean.setStrLimiteMaximo("500 UFC/mL");
			reporteAlmacenamientoPTAPBean.setStrLimiteCalidad("-50 UFC/100mL");
			almacenamientoPTAPDao.grabarReporteAlmacenamientoPTAP(reporteAlmacenamientoPTAPBean);
			
			reporteAlmacenamientoPTAPBean.setStrDesMuestra("PSEUDOMONAS EURUGINOSA UFC/100mL");
			reporteAlmacenamientoPTAPBean.setStrLimiteMaximo("-");
			reporteAlmacenamientoPTAPBean.setStrLimiteCalidad("<10 UFC/100mL");
			almacenamientoPTAPDao.grabarReporteAlmacenamientoPTAP(reporteAlmacenamientoPTAPBean);
			
			reporteAlmacenamientoPTAPBean.setStrDesMuestra("CODIGO DE LA MUESTRA");
			reporteAlmacenamientoPTAPBean.setStrLimiteMaximo(" ");
			reporteAlmacenamientoPTAPBean.setStrLimiteCalidad(" ");
			almacenamientoPTAPDao.grabarReporteAlmacenamientoPTAP(reporteAlmacenamientoPTAPBean);
		}
		
		return idCabecera;
	}

	@Override
	public void actualizarAnalisisBacteriologico(AnalisisBacteriologicoBean analisisBacteriologicoBean) throws Exception {
		analisisBacteriologicDao.actualizarAnalisisBacteriologico(analisisBacteriologicoBean);
		
	}

	@Override
	public void inactivarAnalisisBacteriologico(AnalisisBacteriologicoBean analisisBacteriologicoBean) throws Exception {
		 analisisBacteriologicDao.inactivarAnalisisBacteriologico(analisisBacteriologicoBean);		
	}

	@Override
	public Result obtenerDatosMuestraFirst(MuestraFirstBean muestraFirstBean, Paginacion paginacion) throws Exception {
		return analisisBacteriologicDao.obtenerDatosMuestraFirst(muestraFirstBean, paginacion);
	}

	@Override
	public MuestraFirstBean obtenerMuestraFirst(MuestraFirstBean muestraFirstBean) throws Exception {
		return analisisBacteriologicDao.obtenerMuestraFirst(muestraFirstBean);
	}

	@Override
	public void actualizarMuestraFirst(MuestraFirstBean muestraFirstBean) throws Exception {
		analisisBacteriologicDao.actualizarMuestraFirst(muestraFirstBean);
		
	}

	@Override
	public Result obtenerDatosMuestraSecond(MuestraSecondBean muestraSecondBean, Paginacion paginacion)	throws Exception {
		return analisisBacteriologicDao.obtenerDatosMuestraSecond(muestraSecondBean, paginacion);
	}

	@Override
	public MuestraSecondBean obtenerMuestraSecond(MuestraSecondBean muestraSecondBean) throws Exception {
		return analisisBacteriologicDao.obtenerMuestraSecond(muestraSecondBean);
	}

	@Override
	public void actualizarMuestraSecond(MuestraSecondBean muestraSecondBean) throws Exception {
		analisisBacteriologicDao.actualizarMuestraSecond(muestraSecondBean);		
	}

	@Override
	public Result obtenerDatosResultMuestra(ResultMuestraBean resultMuestraBean, Paginacion paginacion)	throws Exception {
		return analisisBacteriologicDao.obtenerDatosResultMuestra(resultMuestraBean, paginacion);
	}

	@Override
	@Transactional
	public int calculaResultadoMuestraFirst(MuestraFirstBean muestraFirstBean) throws Exception {
		String dessMuestra="";
		int result = -1;
		
		dessMuestra = "BOCATOMA 1";
		muestraFirstBean.setStrDescMuestra(dessMuestra);
		result = analisisBacteriologicDao.calculaResultadoMuestraFirst(muestraFirstBean);
		
		if(result == 0){
		
			dessMuestra = "BOCATOMA 2";
			muestraFirstBean.setStrDescMuestra(dessMuestra);
			result = analisisBacteriologicDao.calculaResultadoMuestraFirst(muestraFirstBean);
		}
			
		return result;
	}

	@Override
	@Transactional
	public int calculaResultadoMuestraSecond(MuestraSecondBean muestraSecondBean) throws Exception {
		String dessMuestra="";
		int result = -1;
		
		dessMuestra = "ENTRADA PLANTA 1";
		muestraSecondBean.setStrDescMuestra(dessMuestra);
		result = analisisBacteriologicDao.calculaResultadoMuestraSecond(muestraSecondBean);
		
		dessMuestra = "ENTRADA PLANTA 2";
		muestraSecondBean.setStrDescMuestra(dessMuestra);
		result = analisisBacteriologicDao.calculaResultadoMuestraSecond(muestraSecondBean);
		
		dessMuestra = "DEC. PLANTA 1";
		muestraSecondBean.setStrDescMuestra(dessMuestra);
		result = analisisBacteriologicDao.calculaResultadoMuestraSecond(muestraSecondBean);
		
		dessMuestra = "DEC. PLANTA 2";		
		muestraSecondBean.setStrDescMuestra(dessMuestra);
		result = analisisBacteriologicDao.calculaResultadoMuestraSecond(muestraSecondBean);
		
		dessMuestra = "PLANTA CONVENCIONAL 1";
		muestraSecondBean.setStrDescMuestra(dessMuestra);
		result = analisisBacteriologicDao.calculaResultadoMuestraSecond(muestraSecondBean);
		
		dessMuestra = "FILTRADA PLANTA 1";
		muestraSecondBean.setStrDescMuestra(dessMuestra);
		result = analisisBacteriologicDao.calculaResultadoMuestraSecond(muestraSecondBean);
		
		dessMuestra = "FILTRADA PLANTA 2";
		muestraSecondBean.setStrDescMuestra(dessMuestra);
		result = analisisBacteriologicDao.calculaResultadoMuestraSecond(muestraSecondBean);
		
		dessMuestra = "DUPLICADO";
		muestraSecondBean.setStrDescMuestra(dessMuestra);
		result = analisisBacteriologicDao.calculaResultadoMuestraSecond(muestraSecondBean);
		
		return result;
	}

	@Override
	public int addDuplicadoMuestraFirst(MuestraFirstBean muestraFirstBean) throws Exception {
		return analisisBacteriologicDao.addDuplicadoMuestraFirst(muestraFirstBean);
	}

	@Override
	public int deleteDuplicadoMuestraFirst(MuestraFirstBean muestraFirstBean) throws Exception {
		return analisisBacteriologicDao.deleteDuplicadoMuestraFirst(muestraFirstBean);
	}

	@Override
	public int addDuplicadoMuestraSecond(MuestraSecondBean muestraSecondBean) throws Exception {
		return analisisBacteriologicDao.addDuplicadoMuestraSecond(muestraSecondBean);
	}

	@Override
	public int deleteDuplicadoMuestraSecond(MuestraSecondBean muestraSecondBean) throws Exception {
		return analisisBacteriologicDao.deleteDuplicadoMuestraSecond(muestraSecondBean);
	}

}
