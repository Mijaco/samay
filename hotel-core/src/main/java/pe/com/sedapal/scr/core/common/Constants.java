/**
 * 
 * Resumen.
 * Objeto : Constants
 * Descripción : Clase de Constantes
 * Fecha de Creación : 27/06/2017
 * Autor : grondo
 * -----------------------------------------------------------------
 * Modificaciones
 * Fecha             Nombre                  Descripción
 * -----------------------------------------------------------------
 * 
 *
 */
package pe.com.sedapal.scr.core.common;

public class Constants {

	public static final String ACTIVE_STATE = "1";
	public static final String INACTIVE_STATE = "2";
	
	public static final Integer ATTRIBUTE_POSITIVE = 1;
	public static final Integer ATTRIBUTE_NEGATIVE = 0;

	public static final String PACKAGE = "com.sedapal.scr.core";

	public final static String ORACLE_PROCEDURES_SCHEMA = "oracle.schema.procedures";
	public static final String P_CURSOR = "sys_refcursor";
	public static final String P_SEPARADOR = ".";

	public static final String PAR_COL_ORDER_BY = "PAR_COL_ORDER_BY";
	public static final String PAR_COL_ORDER_BY_DIR = "PAR_COL_ORDER_BY_DIR";
	public static final String PAR_PAG_DESDE = "PAR_PAG_DESDE";
	public static final String PAR_CANTIDAD_PAG = "PAR_CANTIDAD_PAG";
	public static final String PAR_OUT_QUANTITY = "PAR_OUT_QUANTITY";

	public static final String PAR_OUT_CURSOR = "PAR_OUT_CURSOR";	

	/**
	 * Paquete Mant Rio
	 */
	public static final String PACKAGE_RIO = "PCK_RIO";

	public static final String SP_SEARCH_MANTRIO = "PRC_BUSCA_RIO";
	public static final String PRC_GET_RIO = "PRC_GET_RIO";
	public static final String SP_INSERT_RIO = "PRC_INSERT_RIO";
	public static final String SP_UPDATE_RIO = "PRC_UPDATE_RIO";
	public static final String SP_INACTIVA_MANTRIO = "PRC_INACTIVA_RIO";
	public static final String SP_LISTA_RIO = "PRC_LISTA_RIO";
	public static final String PRC_VALIDA_ABREV_RIO = "PRC_VALIDA_ABREV_RIO";
	public static final String PAR_VOMLARGO_VALIDA_RIO = "PAR_VNOMLARGO";
	public static final String PRC_SALIDA_VAL_ABREV_RIO = "PRC_SALIDA_VAL_ABREV_RIO";
	public static final String PRC_SALIDA_VAL_NOMLAR_RIO = "PRC_SALIDA_VAL_NOMLAR_RIO";

	// PARAMETERS INPUTS
	// MANT RIO
	public static final String PAR_VNOMBRE_RIO = "PAR_VNOMBRE_RIO";
	public static final String PAR_VNOMBRE_LARGO_RIO = "PAR_VNOMBRE_LARGO_RIO";

	public static final String PAR_VABREVIATURA = "PAR_VABREVIATURA";
	public static final String PAR_NPERTENECEAFORO = "PAR_NPERTENECEAFORO";
	public static final String PAR_VESTADO = "PAR_VESTADO";

	public static final String PAR_AUSUARIO_CREACION = "PAR_AUSUARIO_CREACION";
	public static final String PAR_AFECHA_CREACION = "PAR_AFECHA_CREACION ";
	public static final String PAR_AUSUARIO_MODIFICACION = "PAR_AUSUARIO_MODIFICACION";
	public static final String PAR_AFECHA_MODIFICACION = "PAR_AFECHA_MODIFICACION";
	public static final String PAR_APROGRAMA = "PAR_APROGRAMA";
	public static final String PAR_ACODIGO_AREA = "PAR_ACODIGO_AREA";
	public static final String PAR_ACODIGO_SISTEMA = "PAR_ACODIGO_SISTEMA";

	// LISTA RIO
	public static final String PAR_V_ESTADO = "PAR_V_ESTADO";

	// Inactivar Rio
	public static final String PAR_NCODIGO = "PAR_NCODIGO";

	// NOMBRAR ID DE BOTONES QUE REALIZAN LA BUSQUEDA DE GRILLAS
	public static final String BTN_BUSCAR_MANTRIOS = "idBtnFormBuscarRio";

	// Mantenimiento Clima

	public static final String PACKAGE_CLIMA = "PCK_CLIMA";

	public static final String SP_SEARCH_MANTCLIMA = "PRC_BUSCA_CLIMA";
	public static final String PRC_GET_CLIMA = "PRC_GET_CLIMA";
	public static final String SP_INSERT_CLIMA = "PRC_INSERT_CLIMA";
	public static final String SP_UPDATE_CLIMA = "PRC_UPDATE_CLIMA";
	public static final String SP_INACTIVA_MANTCLIMA = "PRC_INACTIVA_CLIMA";
	public static final String SP_LISTA_CLIMA = "PRC_LISTA_CLIMA";

	public static final String PRC_VALIDA_ABREV_CLIMA = "PRC_VALIDA_ABREV_CLIMA";
	public static final String PRC_SALIDA_VAL_ABREV_CLIMA = "PRC_SALIDA_VAL_ABREV_CLIMA";

	// LISTA CLIMA
	public static final String PAR_VESTADO_LCLIMA = "PAR_V_ESTADO";

	// PARAMETERS INPUTS

	public static final String PAR_VNOMBRE_CLIMA = "PAR_VNOMBRE_CLIMA";

	public static final String PAR_VABREVIATURA_CLIMA = "PAR_VABREVIATURA_CLIMA";
	public static final String PAR_VESTADO_CLIMA = "PAR_VESTADO_CLIMA";

	public static final String PAR_AUSUACLIMA_CREACION = "PAR_AUSUACLIMA_CREACION";
	public static final String PAR_AFECHA_CREACION_CLIMA = "PAR_AFECHA_CREACION_CLIMA ";
	public static final String PAR_AUSUACLIMA_MODIFICACION = "PAR_AUSUACLIMA_MODIFICACION";
	public static final String PAR_AFECHA_MODIFICACION_CLIMA = "PAR_AFECHA_MODIFICACION_CLIMA";
	public static final String PAR_APROGRAMA_CLIMA = "PAR_APROGRAMA_CLIMA";
	public static final String PAR_ACODIGO_AREA_CLIMA = "PAR_ACODIGO_AREA_CLIMA";
	public static final String PAR_ACODIGO_SISTEMA_CLIMA = "PAR_ACODIGO_SISTEMA_CLIMA";

	// Inactivar Rio
	public static final String PAR_NCODIGO_CLIMA = "PAR_NCODIGO_CLIMA";

	// NOMBRAR ID DE BOTONES QUE REALIZAN LA BUSQUEDA DE GRILLAS
	public static final String BTN_BUSCAR_MANTCLIMA = "idBtnFormBuscarClima";

	// Mantenimiento Represa

	public static final String PACKAGE_REPRESA = "PCK_REPRESA";

	public static final String SP_SEARCH_MANTREPRESA = "PRC_BUSCA_REPRESA";
	public static final String PRC_GET_REPRESA = "PRC_GET_REPRESA";
	public static final String SP_INSERT_REPRESA = "PRC_INSERT_REPRESA";
	public static final String SP_UPDATE_REPRESA = "PRC_UPDATE_REPRESA";
	public static final String SP_INACTIVA_MANTREPRESA = "PRC_INACTIVA_REPRESA";
	public static final String SP_LISTA_REPRESA = "PRC_LISTA_REPRESA";

	public static final String PRC_VALIDA_ABREV_REPRESA = "PRC_VALIDA_ABREV_REPRESA";
	public static final String PRC_SALIDA_VAL_ABREV_REPRESA = "PRC_SALIDA_VAL_ABREV_REPRESA";

	// PARAMETERS INPUTS

	// LISTAR
	public static final String LR_PAR_V_ESTADO = "PAR_V_ESTADO";

	public static final String PAR_VNOMBRE_REPRESA = "PAR_VNOMBRE_REPRESA";
	public static final String PAR_VNOMBRE_REPRESA_COLABORAD = "PAR_VNOMBRE_REPRESA_COLABORAD";
	public static final String PAR_VABREVIATURA_REPRESA = "PAR_VABREVIATURA_REPRESA";
	public static final String PAR_NTOPE_MAXIMO = "PAR_NTOPE_MAXIMO";
	public static final String PAR_VESTADO_REPRESA = "PAR_VESTADO_REPRESA";
	public static final String PAR_VTIPO_TRABAJADOR = "PAR_VTIPO_TRABAJADOR";
	public static final String PAR_NPERTENECEALMACENAMIENTO = "PAR_NPERTENECEALMACENAMIENTO";

	// ALMACENAMIENTO
	public static final String PACKAGE_ALMACENAMIENTO = "PCK_ALMACENAMIENTO";
	
	public static final String SP_GET_ALMACENAMIENTO_PERIODO = "PRC_GET_ALMAC_PERIODO";
	public static final String SP_GET_ALMACENAMIENTO_FECHA = "PRC_GET_ALMAC_FECHA";
	public static final String SP_UPDATE_ALMACENAMIENTO = "PRC_UPDATE_ALMACENAMIENTO";
	public static final String SP_NOMBRE_REPRESAS_EXCLUIDAS = "PRC_GET_REPRESAS_EXCL";
	
	public static final String PAR_ALM_PERIODO = "PAR_PERIODO";
	public static final String PAR_ALM_FECHA_GER = "PAR_FECHA";
	public static final String PAR_ALM_OUT_REPRESAS = "PAR_OUT_REPRESAS";
	
	public static final String PAR_ALM_FECHA = "PAR_D_FECREP";
	public static final String PAR_ALM_FOREMBALSE = "PAR_C_FOREMBALSE";
	public static final String PAR_ALM_FORMANDESCARGA = "PAR_C_FORMANDES";
	public static final String PAR_ALM_FORMULAUNO = "PAR_C_FORUNO";
	public static final String PAR_ALM_FORMULADOS = "PAR_C_FORDOS";
	public static final String PAR_ALM_USUMODIFICACION = "PAR_A_USUMOD";
	public static final String PAR_ALM_CODIGOAREA = "PAR_N_CODARE";
	public static final String PAR_ALM_CODIGOSISTEMA = "PAR_N_CODSIS";
	
	/*
	 * ------------------------------------ Represas
	 * ------------------------------------
	 */
	public static final String PACKAGE_REPRESAS = "PCK_REPRESAS";
	
	public static final String SP_BUSCA_REPRESAS = "PRC_BUSCA_REPRESAS";
	public static final String SP_GET_REPRESAS = "PRC_GET_REPRESAS";
	public static final String SP_INSERT_REPRESAS = "PRC_INSERT_REPRESAS";
	public static final String SP_UPDATE_REPRESAS = "PRC_UPDATE_REPRESAS";
	public static final String SP_UPDATE_FACTOR_REPRESAS = "PRC_UPDATE_FACTOR_REPRESAS";
	public static final String SP_UPDATE_FORMULAS_REPRESAS = "PRC_UPDATE_FORM_REPRESAS";
	public static final String SP_INACTIVA_REPRESAS = "PRC_INACTIVA_REPRESAS";
	public static final String SP_REPORTE_REPRESA = "PRC_REPORTE_REPRESAS";
	public static final String SP_REPORTE_REPRESA_MANIOBRA = "PRC_REPORTE_REPRESAS_CAUDAL";
	public static final String SP_GET_AFORO_RIO_RIMAC = "PRC_GET_AFORO_RIO_RIMAC";
	public static final String SP_GET_REPORTE_RESUMEN_REPRESAS = "PRC_GET_REP_RES_REPRESAS";
	public static final String SP_GET_REPORTE_GERENCIA = "PRC_GET_REPORTE_GERENCIA";
	public static final String SP_GET_CANTIDAD_REPRESAS_FECHA = "PRC_GET_CANT_REPRESAS_FECHA";

	public static final String PAR_CFECHA = "PAR_FECHA";
	
	public static final String PAR_CNOMBRE_REPRESA = "PAR_CNOMBRE_REPRESA";
	public static final String PAR_CNUMERO_PRECIPITACION = "PAR_CNUMERO_PRECIPITACION";

	public static final String PAR_NVOLUMEN_TOTAL = "PAR_NVOLUMEN_TOTAL";
	public static final String PAR_NCODIGO_REPRESAS = "PAR_NCODIGO_REPRESAS";	
	public static final String PAR_DFECHA_REGISTRO = "PAR_DFECHA_REGISTRO";
	public static final String PAR_NCOD_COL_REP = "PAR_NCOD_COL_REP";
	public static final String PAR_NCOTA = "PAR_NCOTA";
	public static final String PAR_NTEMPERATURA_MAXIMA = "PAR_NTEMPERATURA_MAXIMA";
	public static final String PAR_NVOLUMEN = "PAR_NVOLUMEN";
	public static final String PAR_NVOLUMEN_TRASVASADO = "PAR_NVOLUMEN_TRASVASADO";
	public static final String PAR_NCAUDAL_TRASVASADO = "PAR_NCAUDAL_TRASVASADO";
	public static final String PAR_NDESCARGA = "PAR_NDESCARGA";
	public static final String PAR_NTEMPERATURA_MINIMA = "PAR_NTEMPERATURA_MINIMA";
	public static final String PAR_NLLUVIA = "PAR_NLLUVIA";
	public static final String PAR_NDIFERENCIA_NIVEL = "PAR_NDIFERENCIA_NIVEL";
	public static final String PAR_NDIFERENCIA_VOLUMEN = "PAR_NDIFERENCIA_VOLUMEN";
	public static final String PAR_NEVAPORACION = "PAR_NEVAPORACION";
	public static final String PAR_NHUMEDAD_RELATIVA = "PAR_NHUMEDAD_RELATIVA";
	public static final String PAR_NAFORO_RIO_RIMAC = "PAR_NAFORO_RIO_RIMAC";
	public static final String PAR_NHY = "PAR_NHY";
	public static final String PAR_USEFACTOR = "PAR_NUSEFACTOR";
	public static final String PAR_FACTORDESCARGA = "PAR_CFACTORDES";
	public static final String PAR_FACTORDESCARGAVAL = "PAR_NFACTORVAL";
	public static final String PAR_FORMULA_VOL_TRASV = "PAR_CFORMVOLTRAS";
	public static final String PAR_NCAUDAL = "PAR_NCAUDAL";
	public static final String PAR_NCODIGO_MANIOBRA = "PAR_NCODIGO_MANIOBRA";
	
	public static final String PAR_CPERIODO = "PAR_PERIODO";
	public static final String PAR_CDIA = "PAR_DIA";
	public static final String PAR_OUT_AFORO = "PAR_OUT_AFORORIORIMAC";

	public static final String PAR_AUSUAREPRESAS_CREACION = "PAR_AUSUAREPRESAS_CREACION";
	public static final String PAR_AUSUAREPRESAS_MODIFICACION = "PAR_AUSUAREPRESAS_MODIFICACION";
	public static final String PAR_APROGRAMA_REPRESAS = "PAR_APROGRAMA_REPRESAS";
	public static final String PAR_ACODIGO_AREA_REPRESAS = "PAR_ACODIGO_AREA_REPRESAS";
	public static final String PAR_ACODIGO_SISTEMA_REPRESAS = "PAR_ACODIGO_SISTEMA_REPRESAS";
	
	public static final String PAR_OUT_COD_REP = "PAR_OUT_COD_REP";
	public static final String PAR_OUT_NUM_PRE = "PAR_OUT_NUM_PRECIPITACION";
	
	// --> PARAMETROS PARA PROCEDURE DE VALIDACION DE CANTIDAD DE REPRESAS
	public static final String PAR_FECHA_REGISTRO = "PAR_FECHA_REGISTRO";
	public static final String PAR_CODIGO_MANT_REPRESA = "PAR_CODIGO_REPRESA";
	public static final String PAR_OUT_CANTIDAD_REPRESAS = "PAR_OUT_CANTIDAD";

	public static final String BTN_BUSCAR_REPRESAS = "idBtnFormBuscarRepresas";
	
	// ACTUALIZACION DE FORMULA
	public static final String PAR_N_CODREPRESAS = "PAR_NCODIGO_REPRESAS";
	public static final String PAR_C_FORMULAVOLTRAS = "PAR_CFORMVOLTRASV";
	public static final String PAR_N_VALVOLTRAS = "PAR_NVALVOLTRASV";
	public static final String PAR_A_USUMOD = "PAR_AUSUAREPRESAS_MODIFICACION";
	public static final String PAR_A_AREA = "PAR_ACODIGO_AREA_REPRESAS";
	public static final String PAR_A_SISTEMA = "PAR_ACODIGO_SISTEMA_REPRESAS";

	// REPORTE
	public static final String PAR_PERIODO_REP_GRAF = "PAR_PERIODO";
	// REPORTE MANIOBRA
	public static final String PAR_PERIODO_REP_GRAF2 = "PAR_PERIODO";
	/*
	 * ------------------------------------ Represas
	 * ------------------------------------
	 */

	/*
	 * ------------------------------------ Maniobra
	 * ------------------------------------
	 */
	public static final String PACKAGE_MANIOBRAS = "PCK_MANIOBRAS";
	public static final String SP_BUSCA_MANIOBRAS = "PRC_BUSCA_MANIOBRAS";
	public static final String SP_INSERT_MANIOBRAS = "PRC_INSERT_MANIOBRAS";
	public static final String SP_UPDATE_MANIOBRAS = "PRC_UPDATE_MANIOBRAS";
	public static final String SP_INACTIVA_MANIOBRAS = "PRC_INACTIVA_MANIOBRAS";
	public static final String SP_GET_MANIOBRAS_ACTIVAS = "PRC_GET_MANIOBRAS_ACTIVAS";

	public static final String PAR_NCODIGO_MANIOBRAS = "PAR_NCODIGO_MANIOBRAS";
	public static final String PAR_NTIPO_MANIOBRA = "PAR_NTIPO_MANIOBRA";
	public static final String PAR_CHORA = "PAR_CHORA";
	public static final String PAR_NAPERTURA_INICIAL = "PAR_NAPERTURA_INICIAL";
	public static final String PAR_NAPERTURA_FINAL = "PAR_NAPERTURA_FINAL";
	public static final String PAR_CESTADO = "PAR_CESTADO";
	public static final String PAR_NCODREPRESAS = "PAR_NCODIGO_REPRESAS";

	public static final String PAR_AUSUAMANIOBRAS_CREACION = "PAR_AUSUAREPRESAS_CREACION";
	public static final String PAR_AUSUMANIOBRAS_MODIFICACION = "PAR_AUSUMANIOBRAS_MODIFICACION";
	public static final String PAR_APROGRAMA_MANIOBRAS = "PAR_APROGRAMA_MANIOBRAS";
	public static final String PAR_ACODIGO_AREA_MANIOBRAS = "PAR_ACODIGO_AREA_MANIOBRAS";
	public static final String PAR_ACODIGO_SISTEMA_MANIOBRAS = "PAR_ACODIGO_SISTEMA_MANIOBRAS";

	public static final String BTN_BUSCAR_MANIOBRAS = "idBtnFormBuscarManiobras";
	/*
	 * ------------------------------------ Maniobra
	 * ------------------------------------
	 */

	public static final String PAR_AUSUAREPRESA_CREACION = "PAR_AUSUAREPRESA_CREACION";
	public static final String PAR_AFECHA_CREACION_REPRESA = "PAR_AFECHA_CREACION_REPRESA ";
	public static final String PAR_AUSUAREPRESA_MODIFICACION = "PAR_AUSUAREPRESA_MODIFICACION";
	public static final String PAR_AFECHA_MODIFICACION_REPRESA = "PAR_AFECHA_MODIFICACION_REPRESA";
	public static final String PAR_APROGRAMA_REPRESA = "PAR_APROGRAMA_REPRESA";
	public static final String PAR_ACODIGO_AREA_REPRESA = "PAR_ACODIGO_AREA_REPRESA";
	public static final String PAR_ACODIGO_SISTEMA_REPRESA = "PAR_ACODIGO_SISTEMA_REPRESA";

	// Inactivar Represa
	public static final String PAR_NCODIGO_REPRESA = "PAR_NCODIGO_REPRESA";

	// NOMBRAR ID DE BOTONES QUE REALIZAN LA BUSQUEDA DE GRILLAS
	public static final String BTN_BUSCAR_MANTREPRESA = "idBtnFormBuscarRepresa";

	// TABLA DE CATALOGOS
	public static final String PACKAGE_CATALOGO = "PCK_CATALOGO_VP";
	
	public static final String SP_GET_DETAIL = "PRC_GET_DETALLE";
	
	public static final String PAR_CAT_ABREVIATURA = "PAR_CABREVIATURA";
	public static final String PAR_CAT_ESTADO = "PAR_NESTADO";
	
	// MANT COLABORADOR

	public static final String PACKAGE_COLABORADOR = "PCK_COLABORADOR";

	public static final String SP_SEARCH_MANTCOLABORADOR = "PRC_BUSCA_COLABORADOR";
	public static final String PRC_GET_COLABORADOR = "PRC_GET_COLABORADOR";
	public static final String PRC_GET_TRABAJADOR = "PRC_GET_TRABAJADOR_BY_FICHA";
	public static final String SP_INSERT_COLABORADOR = "PRC_INSERT_COLABORADOR";
	public static final String SP_UPDATE_COLABORADOR = "PRC_UPDATE_COLABORADOR";
	public static final String SP_INACTIVA_MANTCOLABORADOR = "PRC_INACTIVA_COLABORADOR";
	public static final String SP_LISTA_COLABORADOR = "PRC_LISTA_COLABORADOR";

	public static final String PRC_VALIDA_ABREV_COLABORADOR = "PRC_VALIDA_ABREV_COLABORADOR";
	public static final String PRC_SALIDA_VAL_ABREV_COLABOR = "PRC_SALIDA_VAL_ABREV_COLABOR";

	// PARAMETERS INPUTS INSERT

	public static final String PAR_VNOMBRE_COLABORADOR = "PAR_VNOMBRE_COLABORADOR";
	public static final String PAR_VNOMBRE_EMPRESA = "PAR_VNOMBRE_EMPRESA";
	public static final String PAR_VNUMERO_DOCUMENTO = "PAR_VNUMERO_DOCUMENTO";

	public static final String PAR_VABREVIATURA_COLABORADOR = "PAR_VABREVIATURA_COLABORADOR";
	public static final String PAR_CCODIGO_FICHA = "PAR_CCODIGO_FICHA";
	public static final String PAR_VESTADO_COLABORADOR = "PAR_VESTADO_COLABORADOR";
	public static final String PAR_VTIPO_TRABAJADOR_COLABORA = "PAR_VTIPO_TRABAJADOR_COLABORA";
	
	public static final String TIPO_TRABAJADOR_INTERNO = "1";	
	
	// Lista Colaborador
	public static final String PAR_ESTADO_LCOLABORADOR = "PAR_V_ESTADO";

	// Inactivar Colaborador
	public static final String PAR_NCODIGO_COLABORADOR = "PAR_NCODIGO_COLABORADOR";

	// NOMBRAR ID DE BOTONES QUE REALIZAN LA BUSQUEDA DE GRILLAS
	public static final String BTN_BUSCAR_MANTCOLABORADOR = "idBtnFormBuscarColaborador";

	public static final String PAR_AUSUACOLABORADOR_CREACION = "PAR_AUSUACOLABORADOR_CREACION";
	public static final String PAR_AUSUACOLABORADOR_MODIFICA = "PAR_AUSUACOLABORADOR_MODIFICA";
	public static final String PAR_APROGRAMA_COLABORADOR = "PAR_APROGRAMA_COLABORADOR";
	public static final String PAR_ACODIGO_AREA_COLABORADOR = "PAR_ACODIGO_AREA_COLABORADOR";
	public static final String PAR_ACODIGO_SISTEMA_COLABORAD = "PAR_ACODIGO_SISTEMA_COLABORAD";

	
	//TRABAJADOR
	public static final String PACKAGE_TRABAJADOR = "PCK_TRABAJADOR";
	public static final String SP_SEARCH_TRABAJADOR = "PRC_BUSCA_TRABAJADOR";
	
	public static final String PAR_FICHA_TRABAJADOR = "PAR_FICHA";
	public static final String PAR_NOMBRE_TRABAJADOR = "PAR_NOMBRES";
	
	
	// MANT CORREO
	public static final String PACKAGE_CORREO = "PCK_CORREO";
	public static final String SP_SEARCH_MANTCORREO = "PRC_BUSCA_MANT_CORREO";
	public static final String SP_INACTIVA_MANTCORREO = "PRC_INACTIVA_CORREO";
	public static final String SP_INSERTA_MANTCORREO = "PRC_INSERT_MANT_CORREO";
	public static final String SP_UPDATE_MANTCORREO = "PRC_UPDATE_MANT_CORREO";
	public static final String SP_GET_MANT_CORREO = "PRC_GET_MANT_CORREO";
	public static final String SP_GET_VALIDATION_INFO = "PRC_GET_VALIDATION_INFO";

	// VALIDATION
	public static final String PAR_OUT_CANT_RESUMEN = "PAR_OUT_QUANTITY_RESUMEN";
	public static final String PAR_OUT_CANT_AUTOMATICO = "PAR_OUT_QUANTITY_AUTOMATICO";
	public static final String PAR_OUT_CANT_ENVIOS = "PAR_OUT_QUANTITY_CORREO_ENVIO";
	public static final String PAR_OUT_CANT_GERENCIA = "PAR_OUT_QUANTITY_GERENCIA";

	//
	public static final String PAR_ACODAREA = "PAR_ACODAREA";
	public static final String PAR_ACODSIST = "PAR_ACODSIST";
	// BUSCAR
	public static final String PAR_TIPOOPERACION = "par_tipo_operacion";
	public static final String PAR_ESTADO = "PAR_ESTADO";
	public static final String PAR_COLORDERBY = "par_col_order_by";
	public static final String PAR_COLORDERBYDIR = "par_col_order_by_dir";
	public static final String PAR_PAGDESDE = "par_pag_desde";
	public static final String PAR_CANTIDADPAG = "par_cantidad_pag";
	public static final String PAR_OUTQUANTITY = "par_out_quantity";

	// INACTIVAR
	public static final String PAR_CODIGO = "par_codigo";

	// REGISTRAR Y EDITAR
	public static final String PAR_CU_USUINSERCION = "par_ausuins";
	public static final String PAR_CU_USUEDICION = "par_ausuupd";
	public static final String PAR_CU_PROGRAMA = "par_aprograma";
	public static final String PAR_CU_CODAREA = "par_acodarea";
	public static final String PAR_CU_CODSISTEMA = "par_acodsist";
	public static final String PAR_CU_CODIGO = "par_ncodigo";
	public static final String PAR_CU_TIPOOPERACION = "par_vtipooperacion";
	public static final String PAR_CU_ESTADO = "par_vestado";
	public static final String PAR_CU_PARA = "par_vpara";
	public static final String PAR_CU_CONCOPIA = "par_vcc";
	public static final String PAR_CU_ASUNTO = "par_vasunto";
	public static final String PAR_CU_CUERPO = "par_vcuerpo";
	public static final String PAR_CU_ORIGEN = "par_vorigen";
	public static final String PAR_CU_NOMADJUNTO = "par_vnomadj";
	public static final String PAR_CU_RUTASERVIDORCORREO = "par_vrutaservcorreo";
	public static final String PAR_CU_USUARIOCORREO = "par_vusucorreo";
	public static final String PAR_CU_PASSWORDCORREO = "par_vpasscorreo";
	public static final String PAR_CU_RUTASERVIDORARCHIVO = "par_vrutaservfile";
	public static final String PAR_CU_USUARIOARCHIVO = "par_vusufile";
	public static final String PAR_CU_PASSWORDARCHIVO = "par_vpassfile";
	public static final String PAR_CU_PUERTO = "par_npuerto";
	public static final String PAR_CU_RUTADEFAULT = "par_nrutadef";

	public static final String PAR_R_CODIGO = "PAR_CODIGO";

	// CARGA DE ARCHIVOS DE CORREO
	public static final String PACKAGE_CARGA = "PCK_CARGA";
	public static final String SP_FIND_LAST_LOAD = "PRC_BUSCA_ULTIMA_CARGA";
	public static final String SP_FIND_LOAD = "PRC_BUSCA_CARGA";
	// BUSCAR
	public static final String PAR_OUT_TODAY_CARGA = "PAR_OUT_TODAY";

	// CAUDALES
	public static final String PACKAGE_CAUDAL = "PCK_CAUDAL";
	public static final String SP_SEARCH_CAUDAL = "PRC_BUSCA_CAUDAL";
	public static final String SP_GET_CAUDET = "PRC_GET_CAU_DET_RES";
	public static final String SP_GET_CAUDAL2 = "PRC_GET_CAU_DET2";
	public static final String SP_UPDATE_CAUDAL = "PRC_UPDATE_CAUDAL";
	// BUSCAR
	public static final String PAR_NOMBRELARGO = "PAR_NOMBRE_LARGO";
	public static final String PAR_TIPOPROCESO = "PAR_TIPO_PROCESO";
	public static final String PAR_PERIODO = "PAR_PERIODO";
	// GET DET 2
	public static final String PAR_CODIGO_CAUDAL = "PAR_CAUDAL_CODIGO";

	// CONSTANTES DE CODIGOS DE APLICACION
	// TIPO DE MANIOBRA
	public static final String[] MANIOBRA_TYPE = { "Q. REGULADO", "Q. NATURAL", "Q. DESCARGA", "Q. RIO-RIMAC" }; // 0,1,2,3
	public static final String MANIOBRA_TYPE_REGULADO = "1";
	public static final String MANIOBRA_TYPE_NATURAL = "2";
	public static final String MANIOBRA_TYPE_DESCARGA = "3";
	public static final String MANIOBRA_TYPE_RIORIMAC = "4";

	// TIPO DE OPERACION
	public static final String[] MANTCORREO_TIPOOPERACION = { "CONFIGURACI&Oacute;N DE CORREO PARA CAUDAL DE R&Iacute;O R&Iacute;MAC", "PROCESO AUTOM&Aacute;TICO", 
			"CORREO FUENTE DE ENV&Iacute;OS", "REPORTE DE GERENCIA" }; // 0,1,2
	public static final String OPERATION_TYPE_REPORTE_RESUMEN = "1";
	public static final String OPERATION_TYPE_PROCESO_AUTOMATICO = "2";
	public static final String OPERATION_TYPE_CORREO_FUENTE_ENVIOS = "3";
	public static final String OPERATION_TYPE_REPORTE_GERENCIA = "4";
	// TIPO DE PROCESO
	public static final String[] CAUDAL_TIPOPROCESO = { "AUTOM&Aacute;TICO", "MANUAL" }; // 0,1
	public static final String PROCESS_TYPE_AUTOMATICO = "1";
	public static final String PROCESS_TYPE_MANUAL = "2";

	// TIPO DE REPORTE DE REPRESAS
	public static final String REPORT_TYPE_VOLUMEN = "1";
	public static final String REPORT_TYPE_PRECIPITACION = "2";

	// NOMBRAR ID DE BOTONES QUE REALIZAN LA BUSQUEDA DE GRILLAS
	public static final String BTN_BUSCAR_MANTCORREOS = "idBtnBuscarCorreo";

	// CLASS CSS PARA CELDAS DE MATRIZ DE DETALLE CAUDAL
	public static final String CLASS_CSS_DEFAULT = "celda-default";
	public static final String CLASS_CSS_SIN_DATO = "celda-sin-dato";
	public static final String CLASS_CSS_DATO_IGUAL = "celda-dato-igual";
	public static final String CLASS_CSS_DATO_DIFERENTE = "celda-dato-diferente";

	public static final String OBJECT_NAME_EXCEL_LIST = "lstExcelValues";
	public static final String OBJECT_NAME_DB_LIST = "lstDbValues";

	// ESTADOS DE LA CARGA DE CAUDALES
	public static final String CARGA_CAUDAL_EXITO = "1";
	public static final String CARGA_CAUDAL_FALLIDO = "2";

	// PARAMETROS DE DETALLES DE CAUDAL
	public static final Integer NUMERO_HORAS_CARGA = 24;
	public static final Integer PROMERDIO_POR_DIA = 1; // UNA COLUMNA
	public static final Integer TOTAL_COLUMNAS_DISPLAY = NUMERO_HORAS_CARGA + PROMERDIO_POR_DIA;
	public static final Double NO_HAY_DATO_CARGADO = -1.0;
	public static final Integer NUMERO_HOJA_DATA = 0;

	public static final String PARAM1 = "{param1}";
	public static final String PARAM2 = "{param2}";
	public static final String PARAM3 = "{param3}";

	// MENSAJES - ALERTAS
	public static final String CARGA_ERROR = "Carga ejecutada {param1} error";
	public static final String CARGA_EXITO = "Carga ejecutada {param1} \u00E9xito";

	// TITULO DE LOS EJES
	public static final String REP_GRAF1_Y_TITULO = "CAUDAL (m3/s)";
	public static final String REP_GRAF1_X_TITULO = "PERIODO {param1} {param2} (d&iacute;as)";
	public static final String REP_GRAF1_X_TITULO_UNDEFINED = "PERIODO NO ESPECIFICADO O INVALIDO";
	public static final Integer REP_GRAF1_DIAS_DEFAULT = 31;

	public static final String REP_GRAF2_VOL_Y_TITULO = "VOLUMEN (m3)";
	public static final String REP_GRAF2_PRE_Y_TITULO = "UNIDADES (mm)";
	public static final String REP_GRAF2_X_TITULO = "PERIODO {param1} {param2} (d&iacute;as)";
	public static final String REP_GRAF2_X_TITULO_UNDEFINED = "PERIODO NO ESPECIFICADO O INVALIDO";
	public static final Integer REP_GRAF2_DIAS_DEFAULT = 31;

	public static final String REP_GRAF3_Y_TITULO = "CAUDAL (m3/s)";
	public static final String REP_GRAF3_X_TITULO = "PERIODO {param2} {param3} (d&iacute;as)";
	public static final String REP_GRAF3_X_TITULO_UNDEFINED = "PERIODO NO ESPECIFICADO O INVALIDO";
	public static final Integer REP_GRAF3_DIAS_DEFAULT = 31;

	// VALIDACION DE CARGA MANUAL DE DETALLE DE CAUDAL
	public static final Integer LONG_MAX_INTEGER_CAUDAL = 10;
	public static final Integer LONG_MAX_DECIMAL_CAUDAL = 4;
	public static final String CARGA_MANUAL_PERIODO_NO_EXISTE = "El periodo es incorrecto";
	public static final String CARGA_MANUAL_PERIODO_FUTURO = "El periodo aun no ha acontecido";
	public static final String CARGA_MANUAL_NO_DATOS = "No hay datos para cargar";
	public static final String CARGA_MANUAL_EXC_DIAS_PERMITIDOS = "El archivo excede la cantidad de d&iacute;as permitidos";
	public static final String CARGA_MANUAL_EXC_HRS_PERMITIDAS = "Los datos del d&iacute;a {param1} deben ser 24";
	public static final String CARGA_MANUAL_DATOS_INCOMPLETOS = "Se deben ingresar todos los valores hasta el d&iacute;a y hora correspondiente";
	public static final String CARGA_MANUAL_DATOS_EXC = "No se permiten valores a futuro";
	public static final String CARGA_MANUAL_DATOS_NO_NUM = "El valor debe ser num&eacute;rico para el d&iacute;a {param1} a la hora {param2}";
	public static final String CARGA_MANUAL_DATOS_LON_INVALID = "El valor excede la longitud permitida ("+LONG_MAX_INTEGER_CAUDAL+" enteros y "+LONG_MAX_DECIMAL_CAUDAL+" decimales) "
			+ "para el d&iacute;a {param1} a la hora {param2}";
	public static final String CARGA_MANUAL_DATOS_ZERO_LESS = "El valor debe ser mayor a cero para el dia {param1} a la hora {param2}";

	public static final String CARGA_MANUAL_ERROR_GENERICO = "Ha sucedido un error. Volver a intentar";

	// VALIDACION DE IMPORTACION DE REPRESAS
	public static final Integer NRO_MAX_ROWS_TO_INSERT = 200;
	
	public static final String IMP_REPRESAS_NO_DATOS = "No hay datos para cargar";
	public static final String IMP_REPRESAS_EXCEED_MAX = "Cantidad de registros a importar supera la cantidad permitida ("+NRO_MAX_ROWS_TO_INSERT+")";

	public static final String IMP_REPRESAS_ERROR_GENERICO = "Ha sucedido un error. Volver a intentar";
	public static final String IMP_REPRESAS_CERO_DATOS_IMPORTADOS = "No se importaron represas. Ninguna cumple con validaciones";
	
	// REGEX DE VALIDACION
	public static final String REGEX_DECIMAL_NUMBERS = "^\\d{1,{param1}}(\\.\\d{1,{param2}})?$";
	
	// REPORTE EXCEL DE IMPORTACION DE REPRESAS
	public static final Integer COL_FECHA_REGISTRO = 1;
	public static final Integer COL_NOMBRE_REPRESA = 2;
	public static final Integer COL_DESC_CLIMA = 3;
	public static final Integer COL_COTA = 4;
	public static final Integer COL_COLABORADOR = 5;
	public static final Integer COL_TEMPERATURA_MAX = 6;
	public static final Integer COL_VOLUMEN = 7;
	public static final Integer COL_VOLUMEN_TOTAL = 8;
	public static final Integer COL_CAUDAL_TRASVASADO = 9;
	public static final Integer COL_TEMP_MIN = 10;
	public static final Integer COL_LLUVIAS = 11;
	public static final Integer COL_DIFERENCIAL_NIVEL = 12;
	public static final Integer COL_DIFERENCIA_VOLUMEN = 13;
	public static final Integer COL_HUMEDAD_RELATIVA = 14;
	public static final Integer COL_EVAPORACION = 15;
	public static final Integer COL_HY = 16;
	public static final Integer COL_CAUDAL = 17;

	public static final String NOM_COL_FECHA_REGISTRO = "Fecha de Registro";
	public static final String NOM_COL_NOMBRE_REPRESA = "Abreviatura Represa";
	public static final String NOM_COL_DESC_CLIMA = "Abreviatura Clima";
	public static final String NOM_COL_COTA = "Cota";
	public static final String NOM_COL_COLABORADOR = "Abreviatura Colaborador";
	public static final String NOM_COL_TEMPERATURA_MAX = "Temperatura M&aacute;xima";
	public static final String NOM_COL_VOLUMEN = "Volumen";
	public static final String NOM_COL_VOLUMEN_TOTAL = "Volumen Total";
	public static final String NOM_COL_CAUDAL_TRASVASADO = "Caudal Trasvasado";
	public static final String NOM_COL_TEMP_MIN = "Temperatura M&iacute;nima";
	public static final String NOM_COL_LLUVIAS = "Lluvias";
	public static final String NOM_COL_DIFERENCIAL_NIVEL = "Diferencial Nivel";
	public static final String NOM_COL_DIFERENCIA_VOLUMEN = "Diferencia Volumen";
	public static final String NOM_COL_HUMEDAD_RELATIVA = "Humedad Relativa";
	public static final String NOM_COL_EVAPORACION = "Evaporaci&oacute;n";
	public static final String NOM_COL_HY = "Canal HY";
	public static final String NOM_COL_CAUDAL = "Canal Caudal";

	public static final String IMP_MENSAJE_VALIDA_VACIO = "{param1} no admite valores vac&iacute;os";
	public static final String IMP_MENSAJE_VALIDA_NUMERICO = "{param1} solo admite valores num&eacute;ricos";
	public static final String IMP_MENSAJE_VALIDA_ENTERO = "{param1} solo admite valores num&eacute;ricos enteros";
	public static final String IMP_MENSAJE_VALIDA_LONGITUD_TEXTO = "{param1} debe tener longitud m&aacute;xima de {param2}";
	public static final String IMP_MENSAJE_VALIDA_LONGITUD_ENTERO = "{param1} debe tener longitud m&aacute;xima de {param2}";
	public static final String IMP_MENSAJE_VALIDA_LONGITUD_DECIMAL = "{param1} debe tener longitud m&aacute;xima de {param2} enteros y {param3} decimales";
	public static final String IMP_MENSAJE_VALIDA_FECHA = "{param1} no es v&aacute;lida";
	public static final String IMP_MENSAJE_VALIDA_FUTURO = "{param1} no puede ser para fecha mayor a hoy";
	public static final String IMP_MENSAJE_EXIST_REGISTRO = "{param1} no se encuentra registrado(a) o se encuentra inactivo(a)";
	public static final String IMP_MENSAJE_VALIDA_POSITIVOS = "{param1} no admite valores negativos";
	public static final String IMP_MENSAJE_VALIDA_TEMPERATURAS = "{param1} debe tener valor menor o igual a {param2}";
	public static final String IMP_MENSAJE_DUPLICATED = "Ya existe registro para esta fecha con la misma represa";

	public static final Integer LONG_MAX_NRO_PRECIPITACION = 14;
	public static final Integer LONG_MAX_NUMBER = 30;
	public static final Integer LONG_MAX_VARCHAR = 100;
	public static final Integer MAX_DIGITS_ALLOW_2 = 2;
	public static final Integer MAX_DIGITS_ALLOW_3 = 3;
	public static final Integer MAX_DIGITS_ALLOW_4 = 4;
	public static final Integer MAX_DIGITS_ALLOW_5 = 5;
	public static final Integer MAX_DIGITS_ALLOW_6 = 6;
	public static final Integer MAX_DIGITS_ALLOW_8 = 8;
	public static final Integer MAX_DIGITS_ALLOW_9 = 9;
	public static final Integer MAX_DIGITS_ALLOW_10 = 10;
	public static final Integer MAX_DIGITS_ALLOW_12 = 12;

	public static final String VALIDACION_ABREVIATURA = "La abreviatura ya se encuentra registrada";
	public static final String VALIDACION_NOMBRE_LARGO = "El nombre largo ya se encuentra registrado";
	
	// CONSTANTE PARA DATOS DE REPORTE CUANDO NO HAY DATOS
	public static final Integer TYPE_COLUMN_REPRESA = 1;
	public static final Integer TYPE_COLUMN_ALMACENAMIENTO = 2;
	public static final Integer TYPE_COLUMN_VOLUMENTOTAL = 3;
	public static final Integer TYPE_COLUMN_AFORORIO = 4;
	public static final Integer TYPE_COLUMN_MANIOBRAS = 5;
	public static final Integer TYPE_COLUMN_AGREGADOS = 6;
	public static final String CELL_WITHOUT_VALUE = "0";
	public static final String CELL_TEXT_WITHOUT_VALUE = "-";
	public static final String NAME_CODIGO_FROMDB = "N_CODIGO";
	public static final String NAME_IDREPRESAS_FROMDB = "ID_REPRESAS";
	public static final String NAME_COTA_FROMDB = "COTA";
	public static final String NAME_VOLUMEN_FROMDB = "VOLUMEN";
	public static final String NAME_VOLUMENTOTAL_FROMDB = "VOLUMEN_TOTAL";
	public static final String NAME_DESCARGA_FROMDB = "DESCARGA";
	public static final String NAME_CAUDALTRASVASADO_FROMDB = "CAUDAL_TRASV";
	public static final String NAME_FORMULAVOLUMENTRASVASADO_FROMDB = "FORM_VOL_TRASV";
	public static final String NAME_VOLUMENTRASVASADO_FROMDB = "VOLUMEN_TRASV";
	public static final String NAME_PRECIPITACION_FROMDB = "PRECIPITACION";
	public static final String NAME_TIEMPO_FROMDB = "TIEMPO";
	public static final String NAME_AFORO_FROMDB = "AFORO";
	
	// RUTA ARCHIVOS EN EL RESOURCES
	public static final String DOWNLOADS_PATH = "downloads/";
	public static final String TEMPLATE_CAUDAL_FILE = "template_caudales.xls";
	public static final int CAUDAL_DOWNLOAD_BUFFERSIZE = 4096;
	
	public static final String TEMPLATE_REPRESAS_FILE = "template_represas.xls";
	public static final int REPRESAS_DOWNLOAD_BUFFERSIZE = 4096;
	
	public static final String TEMP_FILENAME_CAUDALES = "fileCaudalesTemp";
	public static final String TEMP_CAUDAL_EXTENSION = ".xls";
	
	// FACTOR POR DEFECTO 
	public static final String REPRESAS_FACTOR_DESCARGA = "(0.2*24)/24";
	public static final Double REPRESAS_FACTOR_DESCARGA_VALUE = (0.2*24)/24;
	public static final String REPRESAS_DESCARGA_DEFAULT = "0";
	
	// VALOR DEFECTO PARA ALMACENAMIENTO 
	public static final Double REPRESAS_FACTOR_ALMACENAMIENTO_VALUE = 100/244.3;
	public static final String REPRESAS_ALMACANEMIENTO_TITULO = "ALMACENAMIENTO";
	public static final String REPRESAS_VOLUMENTOTAL_TITULO = "VOLUMEN TOTAL<br />(INCLUYE DISP. <br />BOMBEO HUASC)";
	public static final String REPRESAS_MANIOBRAS_TITULO = "SHEQUE-TAMBORAQUE";
	public static final String REPRESAS_AFORORIO_TITULO = "AFORO RIO<br />RIMAC";
	public static final String REPRESAS_AGREGADOS_TITULO = "VALORES CALCULADOS";
	
	// REPORTE DE GERENCIA
	public static final String REPORTE_GERENCIA_DATO_NO_CONFIGURADO = "NO CONFIGURADO";
	public static final String CATALOGO_ABREVIATURA_FORM_TRASVASADO = "VOL_TRASVASADO";
	public static final String CATALOGO_ABREVIATURA_FORM_AGREGADOS = "COLUMNAS_AGREGADAS";
	public static final String CATALOGO_ABREVIATURA_FORMULA = "FORMULA_CALCULO";
	
	// VALORES DEFAULT BD
	public static final String DEFAULT_VARCHAR = " ";
	public static final Integer DEFAULT_NUMBER_INT = 0;
	public static final Double DEFAULT_NUMBER_DOUBLE = 0.0;
	public static final Double DEFAULT_CAUDET_NUMBER_DOUBLE = -1.0;
	public static final Long DEFAULT_NOMBER_LONG = 0L;
	
	
	//laboratorio
	
		public static final Integer COL_COD_COLABORADOR 		= 6;
		public static final Integer COL_VOLUMEN_TRASVASADO 		= 9;
		public static final Integer COL_DESCARGA_TEMP_MIN 		= 11;
		public static final Integer COL_AFORO_RIO				= 15;
		
		public static final String NOM_COL_NRO_PRECIPITACION    = "Nro de Preipitacion";
		public static final String NOM_COL_COD_COLABORADOR 		= "Colaborador";
		public static final String NOM_COL_VOLUMEN_TRASVASADO 	= "Volumen Trasvasado";
		public static final String NOM_COL_DESCARGA_TEMP_MIN 	= "Descarga Temperatura Minima";
		public static final String NOM_COL_AFORO_RIO			= "Aforo de Rio";
		
		public static final String IMP_MENSAJE_VALIDA_LONGITUD	= "{param1} debe tener longitud maxima de {param2}";
		
		
		//DATOS PARA TODAS LAS TABLAS
		public static final String PAR_CUSUARIO_CREACION = "PAR_CUSUARIO_CREACION";
		public static final String PAR_CUSUARIO_MODI = "PAR_CUSUARIO_MODI";
		public static final String PAR_CPROGRAMA = "PAR_CPROGRAMA";
		public static final String PAR_OUT_RETURN = "PAR_OUT_RETURN";
		
		
		
		//REGISTRO DE MUESTRAS
		public static final String PKG_REG_MUESTRAS = "PKC_ALC_REGMUESTRA";
		public static final String SP_LISTADO_REG_MUESTRAS = "PRC_LISTADO_REG_MUESTRAS";
		public static final String PAR_FECHA_INICIO = "PAR_FECHA_INICIO";

		public static final String PAR_COD_FRASCO = "PAR_COD_FRASCO";
		public static final String PAR_MATRIZ = "PAR_MATRIZ";
		public static final String PAR_PERSONA_MUESTREA = "PAR_PERSONA_MUESTREA";
		public static final String PAR_TIPO_ANALISIS = "PAR_TIPO_ANALISIS";
		public static final String PAR_RECEP_ANALISTA = "PAR_RECEP_ANALISTA";
		public static final String PAR_PUNTO_MUESTREO = "PAR_PUNTO_MUESTREO";
		public static final String PAR_TIPO_FRASCO = "PAR_TIPO_FRASCO";
		public static final String PAR_MEDIDAS_SEGURIDAD = "PAR_MEDIDAS_SEGURIDAD";
		public static final String PAR_TEMP_PRESERVACION = "PAR_TEMP_PRESERVACION";
		public static final String PAR_HORA = "PAR_HORA";
		public static final String PAR_TIPO_CUSTODIA = "PAR_TIPO_CUSTODIA";
		public static final String A_PAR_USUARIO_CREACION = "A_PAR_USUARIO_CREACION";
		public static final String A_PAR_USUARIO_MODIFICACION = "A_PAR_USUARIO_MODIFICACION";
		public static final String A_PAR_NOMBRE_PROGRAMA = "A_PAR_NOMBRE_PROGRAMA";
		
		public static final String SP_INSERT_MUESTRA = "PRC_INSERT_MUESTRA";
		
		public static final String SP_PUNTO_MUESTREO = "PRC_LISTA_PUNTO_MUESTREO";
		public static final String SP_CBO_MATRIZ = "PRC_LISTA_MATRIZ";
		public static final String SP_CBO_TIPO_ANALISIS = "PRC_CBO_TIPO_ANALISIS";
		public static final String SP_CBO_TIPO_FRASCO = "PRC_CBO_TIPO_FRASCO";
		public static final String SP_CBO_PERSONA_MUESTREA = "PRC_CBO_PERSONA_MUESTREA";
		public static final String SP_CBO_RECEP_ANALISTA = "PRC_CBO_RECEP_ANALISTA";
		
		public static final String PAR_NAME = "PAR_NAME";
		public static final String PAR_APE = "PAR_APE";
			
		
		
		
	

}