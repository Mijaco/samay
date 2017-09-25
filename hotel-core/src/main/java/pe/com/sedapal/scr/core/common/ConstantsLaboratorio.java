package pe.com.sedapal.scr.core.common;

import javax.swing.text.Utilities;

public class ConstantsLaboratorio {

	// CONTANTES UTILES
	public static final String PACKAGE_CATALOGO = "PCK_CATALOGO";
	public static final String PRC_BUSCA_CATALOGO = "PRC_BUSCA_CATALOGO";
	public static final String PCK_ALC_ACTIVIDADXAREA = "PCK_ALC_ACTIVIDADXAREA";
	public static final String PAR_CDCATL = "PAR_CDCATL";

	public static final int ACTIVO = 1;
	public static final int INACTIVO = 0;

	// CONTANTES PARA MANTENIMIENTO LABORATORIO
	public static final String PAR_COD_TABLE = "PAR_COD_TABLE";

	// CONTANTES PARA MANTENIMIENTO ACTIVIDADES : BUSCAR
	public static final String PRC_BUSCA_ACTIVIDAD = "PRC_BUSCA_ACTIVIDAD";

	public static final String PRC_GET_ACTIVIDADXAREA = "PRC_GET_ACTIVIDADXAREA";

	// CONTANTES PARA MANTENIMIENTO ACTIVIDADES: CAMPOS AUDITORIA

	public static final String PAR_USUCRE = "PAR_USUCRE";
	public static final String PAR_USUMOD = "PAR_USUMOD";
	public static final String PAR_NOMPRG = "PAR_NOMPRG";

	// CONTANTES PARA MANTENIMIENTO ACTIVIDADES: ACTUALIZAR
	public static final String PRC_UPDATE_ACTIVIDAD = "PRC_UPDATE_ACTIVIDAD";
	public static final String PAR_DESPER = "PAR_DESPER";

	public static final String PAR_CODARE = "PAR_CODARE";
	public static final String PAR_CODACT = "PAR_CODACT";

	// CONTANTES PARA MANTENIMIENTO ACTIVIDADES: INSERT
	public static final String PRC_INSERT_ACTIVIDAD = "PRC_INSERT_ACTIVIDAD";
	public static final String PAR_ESTAXA = "PAR_ESTAXA";

	public static final String PAR_REQUEST_IDREA = "idArea";
	public static final String PAR_REQUEST_IDACTIVIDAD = "idActividad";

	public static final String PAR_REQUEST_DESCRIPCION = "descripcionAsignada";
	public static final String PAR_REQUEST_ESTADO = "estado";
	public static final String PAR_REQUEST_ACCION = "accion";
	public static final String PAR_REQUEST_INDICES = "indices";

	// CONTANTES PARA MANTENIMIENTO PUNTO MUESTREO

	public static final String PCK_ALC_PUNTOXSUBACTIVIDAD = "PCK_ALC_PUNTOXSUBACTIVIDAD";
	public static final String PRC_BUSCA_PUNTO = "PRC_BUSCA_PUNTO";
	public static final String PRC_GET_PUNTOXSUBACTIVIDAD = "PRC_GET_PUNTOXSUBACTIVIDAD";
	public static final String PRC_INSERT_PUNTOXSUBACTIVIDAD = "PRC_INSERT_PUNTOXSUBACTIVIDAD";
	public static final String PRC_UPDATE_PUNTOXSUBACTIVIDAD = "PRC_UPDATE_PUNTOXSUBACTIVIDAD";

	// CONTANTES PARA MANTENIMIENTO SUBACTIVIDADES POR GRUPO
	public static final String PCK_ALC_SUBACTIVIDADXGRUPO = "PCK_ALC_SUBACTIVIDADXGRUPO";
	public static final String PRC_BUSCA_SUBACTIVIDAD = "PRC_BUSCA_SUBACTIVIDAD";
	public static final String PRC_GET_SUBACTIVIDADXGRUPO = "PRC_GET_SUBACTIVIDADXGRUPO";
	public static final String PRC_INSERT_SUBACTIVIDADXGRUPO = "PRC_INSERT_SUBACTIVIDADXGRUPO";
	public static final String PRC_UPDATE_SUBACTIVIDADXGRUPO = "PRC_UPDATE_SUBACTIVIDADXGRUPO";

	public static final String PAR_CODSUB = "PAR_CODSUB";
	public static final String PAR_PUNMUE = "PAR_PUNMUE";
	public static final String PAR_ESTPXS = "PAR_ESTPXS";

	public static final String PAR_COAXAR = "PAR_COAXAR";
	public static final String PAR_ESTSXG = "PAR_ESTSXG";

	// CONTANTES PARA MANTENIMIENTO PUNTO POR SUBACTIVIDAD
	public static final String PAR_REQUEST_IDSUBACTIVIDAD = "idSubactividad";
	public static final String PAR_REQUEST_IDPUNTO = "idPunto";

	// CONTANTES PARA MANTENIMIENTO PUNTO POR SUBACTIVIDAD
	public static final String PAR_REQUEST_IDMASTER = "idMaster";
	public static final String PAR_REQUEST_IDDETALLE = "idDetalle";

	// CONTANTES PARA REGISTRO DE MUESTRAS
	public final static String ORACLE_PROCEDURES_SCHEMA = "oracle.schema.procedures";
	public static final String PKG_REG_MUESTRAS = "PKC_ALC_REGMUESTRA";
	public static final String SP_LISTADO_REG_MUESTRAS = "PRC_LISTADO_REG_MUESTRAS";
	public static final String PAR_FECHA_INICIO = "PAR_FECHA_INICIO";
	public static final String P_ID_REGISTRO = "P_ID_REGISTRO";
	public static final String P_U_MODIFICACION = "P_U_MODIFICACION";
	public static final String PAR_FECHA_REGISTRO = "PAR_FECHA_REGISTRO";
	public static final String PAR_HORA_REGISTRO = "PAR_HORA_REGISTRO";
	public static final String PAR_COD_FRASCO = "PAR_COD_FRASCO";
	public static final String PAR_MATRIZ = "PAR_MATRIZ";
	public static final String PAR_PERSONA_MUESTREA = "PAR_PERSONA_MUESTREA";
	public static final String PAR_TIPO_ANALISIS = "PAR_TIPO_ANALISIS";
	public static final String PAR_RECEP_ANALISTA = "PAR_RECEP_ANALISTA";
	public static final String PAR_PUNTO_MUESTREO = "PAR_PUNTO_MUESTREO";
	public static final String PAR_TIPO_FRASCO = "PAR_TIPO_FRASCO";
	public static final String PAR_MEDIDAS_SEGURIDAD = "PAR_MEDIDAS_SEGURIDAD";
	public static final String PAR_TEMP_PRESERVACION = "PAR_TEMP_PRESERVACION";
	public static final String PAR_TIPO_CUSTODIA = "PAR_TIPO_CUSTODIA";
	public static final String A_PAR_USUARIO_CREACION = "A_PAR_USUARIO_CREACION";
	public static final String A_PAR_USUARIO_MODIFICACION = "A_PAR_USUARIO_MODIFICACION";
	public static final String A_PAR_NOMBRE_PROGRAMA = "A_PAR_NOMBRE_PROGRAMA";

	public static final String PAR_FECHA = "PAR_FECHA";

	// ####
	public static final String PAR_ID_REGISTRO = "PAR_ID_REGISTRO";
	public static final String SP_UPDATE_FORMULARIO = "PRC_UPDATE_FORMULARIO";
	public static final String P_SEPARADOR = ".";

	public static final String SP_GET_REG_MUESTRAS = "PRC_GET_REGMUESTRA_PDF";

	// ####

	public static final String SP_INSERT_MUESTRA = "PRC_INSERT_MUESTRA";
	public static final String SP_PUNTO_MUESTREO = "PRC_LISTA_PUNTO_MUESTREO";
	public static final String SP_CBO_MATRIZ = "PRC_LISTA_MATRIZ";
	public static final String SP_CBO_TIPO_ANALISIS = "PRC_CBO_TIPO_ANALISIS";
	public static final String SP_CBO_TIPO_FRASCO = "PRC_CBO_TIPO_FRASCO";
	public static final String SP_CBO_PERSONA_MUESTREA = "PRC_CBO_PERSONA_MUESTREA";
	public static final String SP_CBO_RECEP_ANALISTA = "PRC_CBO_RECEP_ANALISTA";

	public static final String PRC_GET_FORMULARIO153 = "PRC_GET_FORMULARIO153";

	public static final String PRC_ELIMINA_FORMULARIO = "PRC_ELIMINA_FORMULARIO";
	// ####

	// CONTANTES PARA MANTENIMIENTO PARAMETRO POR SUABACTIVIDAD
	public static final String PCK_ALC_PARAMETROXSUBACT = "PCK_ALC_PARAMETROXSUBACT";
	public static final String PRC_BUSCA_PARAMETRO = "PRC_BUSCA_PARAMETRO";
	public static final String PRC_GET_PARAMETROXSUBACT = "PRC_GET_PARAMETROXSUBACT";
	public static final String PRC_INSERT_PARAMETROXSUBACT = "PRC_INSERT_PARAMETROXSUBACT";
	public static final String PRC_UPDATE_PARAMETROXSUBACT = "PRC_UPDATE_PARAMETROXSUBACT";
	public static final String PAR_STATUS = "PAR_STATUS";
	public static final String PAR_CSUBXA = "PAR_CSUBXA";
	public static final String PAR_CODPAR = "PAR_CODPAR";

	// CONTANTES PARA MANTENIMIENTO PARAMETRO POR SUABACTIVIDAD
	public static final String PCK_ALC_PLANOPERATIVO = "PCK_ALC_PLANOPERATIVO";
	public static final String PRC_BUSCA_PARAMETROPLAN = "PRC_BUSCA_PARAMETROPLAN";
	public static final String PRC_GET_PARAMETROPLAN = "PRC_GET_PARAMETROPLAN";

	public static final String PRC_INSERT_PARAMETROPLAN = "PRC_INSERT_PARAMETROPLAN";
	public static final String ALC_VALORESXPARA = "ALC_VALORESXPARA";
	public static final String PRC_UPDATE_PARAMETROPLAN = "PRC_UPDATE_PARAMETROPLAN";
	public static final String PAR_OUT_CURSOR = "PAR_OUT_CURSOR";

	public static final String PAR_CODVXP = "PAR_CODVXP";
	public static final String PAR_CODSXP = "PAR_CODSXP";
	public static final String PAR_CODPLA = "PAR_CODPLA";
	public static final String PAR_TIPOPA = "PAR_TIPOPA";
	public static final String PAR_CODESC = "PAR_CODESC";
	public static final String PAR_DESCRI = "PAR_DESCRI";
	public static final String PAR_UNIMED = "PAR_UNIMED";
	public static final String PAR_METAPR = "PAR_METAPR";
	public static final String PAR_CANM01 = "PAR_CANM01";
	public static final String PAR_CANM02 = "PAR_CANM02";
	public static final String PAR_CANM03 = "PAR_CANM03";
	public static final String PAR_CANM04 = "PAR_CANM04";
	public static final String PAR_CANM05 = "PAR_CANM05";
	public static final String PAR_CANM06 = "PAR_CANM06";
	public static final String PAR_CANM07 = "PAR_CANM07";
	public static final String PAR_CANM08 = "PAR_CANM08";
	public static final String PAR_CANM09 = "PAR_CANM09";
	public static final String PAR_CANM10 = "PAR_CANM10";
	public static final String PAR_CANM11 = "PAR_CANM11";
	public static final String PAR_CANM12 = "PAR_CANM12";

	// Mantenimiento TABLA POISSON
	public static final String PACKAGE_TABLA_POISSON = "PCK_ALC_MANTPOI";
	public static final String SP_SEARCH_TABLA_POISSON = "PRC_BUSCA_TABLA_POISSON";
	public static final String PRC_GET_TABLA_POISSON = "PRC_GET_TABLA_POISSON";
	public static final String SP_INSERT_TABLA_POISSON = "PRC_INSERT_TABLA_POISSON";
	public static final String SP_UPDATE_TABLA_POISSON = "PRC_UPDATE_TABLA_POISSON";
	public static final String SP_INACTIVA_TABLA_POISSON = "PRC_INACTIVA_TABLA_POISSON";
	public static final String SP_LISTA_TABLA_POISSON = "PRC_LISTA_TABLA_POISSON";
	// PARAMETROS INPUT TABLA POISSON
	public static final String PAR_NCODIGO_LAMBDA = "PAR_NCODIGO_LAMBDA";
	public static final String PAR_CCODIGO_X = "PAR_CCODIGO_X";
	public static final String PAR_NCODIGO_POISSON = "PAR_NCODIGO_POISSON";
	public static final String PAR_CVALOR = "PAR_CVALOR";

	// Mantenimiento TABLA FORMULA MUESTRA
	public static final String PACKAGE_FORMULA_MUESTRA = "PCK_ALC_FORMULA";
	public static final String SP_SEARCH_FORMULA_MUESTRA = "PRC_BUSCA_FORMULA_MUESTRA";
	public static final String PRC_GET_FORMULA_MUESTRA = "PRC_GET_FORMULA_MUESTRA";
	public static final String SP_INSERT_FORMULA_MUESTRA = "PRC_INSERT_FORMULA_MUESTRA";
	public static final String SP_UPDATE_FORMULA_MUESTRA = "PRC_UPDATE_FORMULA_MUESTRA";
	public static final String SP_INACTIVA_FORMULA_MUESTRA = "PRC_INACTIVA_FORMULA_MUESTRA";
	public static final String SP_LISTA_FORMULA_MUESTRA = "PRC_LISTA_FORMULA_MUESTRA";

	// PARAMETROS INPUT FORMULA MUESTRA
	public static final String PAR_NID_FORMULARIO = "PAR_NID_FORMU";
	public static final String PAR_NCODIGO_GRUPO = "PAR_NCODIGO_GRUPO";
	public static final String PAR_CFORMULARIO = "PAR_CFORMULARIO";
	public static final String PAR_CCODIGO_FORM = "PAR_CCODIGO_FORM";
	public static final String PAR_CNOMBRE_FORM = "PAR_CNOMBRE_FORM";
	public static final String PAR_CNOMBRE_FUNCION = "PAR_CNOMBRE_FUNC";

	// Mantenimiento TABLA VERIFICACION EQUIPO
	public static final String PACKAGE_TURBIDI_DIGITAL = "PCK_ALC_TURBIDI";
	public static final String SP_SEARCH_TURBIDI_DIGITAL = "PRC_BUSCA_TURBIDI_DIGITAL";
	public static final String PRC_GET_TURBIDI_DIGITAL = "PRC_GET_TURBIDI_DIGITAL";
	public static final String SP_INSERT_TURBIDI_DIGITAL = "PRC_INSERT_TURBIDI_DIGITAL";
	public static final String SP_UPDATE_TURBIDI_DIGITAL = "PRC_UPDATE_TURBIDI_DIGITAL";
	public static final String SP_INACTIVA_TURBIDI_DIGITAL = "PRC_INACTIVA_TURBIDI_DIGITAL";
	public static final String SP_LISTA_TURBIDI_DIGITAL = "PRC_LISTA_TURBIDI_DIGITAL";
	public static final String SP_SEARCH_VERIFICA_TURBDIG = "PRC_BUSCA_VERIFICA_TURBDIG";
	public static final String SP_INSERT_VERIFICA_TURBDIG = "PRC_INSERT_VERIFICA_TURBDIG";
	public static final String SP_INACTIVA_VERIFICA_TURBDIG = "PRC_INACTIVA_VERIFICA_TURBDIG";

	// PARAMETROS INPUT VERIFICACION EQUIPO
	public static final String PAR_NCODIGO_EQUIPO = "PAR_NCODIGO_EQUIPO";
	public static final String PAR_NID_EQUIPO = "PAR_NID_EQUIPO";
	public static final String PAR_CNOMBRE_EQUIPO = "PAR_CNOMBRE_EQUIPO";
	public static final String PAR_CUBICACION = "PAR_CUBICACION";
	public static final String PAR_CMARCA = "PAR_CMARCA";
	public static final String PAR_CMODELO = "PAR_CMODELO";
	public static final String PAR_NMES_CALIBRACION = "PAR_NMES_CALIBRACION";
	public static final String PAR_NPROX_MES_CALIBRACION = "PAR_NPROX_MES_CALIBR";
	public static final String PAR_CRANGO1 = "PAR_CRANGO1";
	public static final String PAR_CRANGO_MAX1 = "PAR_CRANGO_MAX1";
	public static final String PAR_CRANGO_MIN1 = "PAR_CRANGO_MIN1";
	public static final String PAR_CRANGO2 = "PAR_CRANGO2";
	public static final String PAR_CRANGO_MAX2 = "PAR_CRANGO_MAX2";
	public static final String PAR_CRANGO_MIN2 = "PAR_CRANGO_MIN2";
	public static final String PAR_CRANGO3 = "PAR_CRANGO3";
	public static final String PAR_CRANGO_MAX3 = "PAR_CRANGO_MAX3";
	public static final String PAR_CRANGO_MIN3 = "PAR_CRANGO_MIN3";
	public static final String PAR_CRANGO4 = "PAR_CRANGO4";
	public static final String PAR_CRANGO_MAX4 = "PAR_CRANGO_MAX4";
	public static final String PAR_CRANGO_MIN4 = "PAR_CRANGO_MIN4";
	public static final String PAR_CRANGO5 = "PAR_CRANGO5";
	public static final String PAR_CRANGO_MAX5 = "PAR_CRANGO_MAX5";
	public static final String PAR_CRANGO_MIN5 = "PAR_CRANGO_MIN5";
	public static final String PAR_NID_VERIFICA = "PAR_NID_VERIFICA";

	public static final String PAR_CFECHA_VERIFI = "PAR_CFECHA_VERIFI";
	public static final String PAR_CVALOR1 = "PAR_CVALOR1";
	public static final String PAR_CVALOR2 = "PAR_CVALOR2";
	public static final String PAR_CVALOR3 = "PAR_CVALOR3";
	public static final String PAR_CVALOR4 = "PAR_CVALOR4";
	public static final String PAR_CVALOR5 = "PAR_CVALOR5";
	public static final String PAR_CRESPONSABLE = "PAR_CRESPONSABLE";
	public static final String PAR_COBSERVACION = "PAR_COBSERVACION";
	public static final String PAR_CCEPAS1      = "PAR_CCEPAS1";
	public static final String PAR_CCEPAS2      = "PAR_CCEPAS2";
	public static final String PAR_COBSINTERPEL = "PAR_COBSINTERPEL";
		

	// PHMETRO DIGITAL
	public static final String PACKAGE_PHMETRO_DIGITAL = "PKG_ALC_PHMETRO";
	public static final String SP_SEARCH_PHMETRO_DIGITAL = "PRC_BUSCA_PHMETRO_DIGITAL";
	public static final String PRC_GET_PHMETRO_DIGITAL = "PRC_GET_PHMETRO_DIGITAL";
	public static final String SP_INSERT_PHMETRO_DIGITAL = "PRC_INSERT_PHMETRO_DIGITAL";
	public static final String SP_UPDATE_PHMETRO_DIGITAL = "PRC_UPDATE_PHMETRO_DIGITAL";
	public static final String SP_INACTIVA_PHMETRO_DIGITAL = "PRC_INACTIVA_PHMETRO_DIGITAL";
	public static final String SP_DETALLE_PHMETRO_DIGITAL = "SP_DETALLE_PHMETRO_DIGITAL";
	public static final String SP_INSERT_DETALLE__PTRO_DIGITAL = "PRC_INS_DETALLE_PTRO_DIGITAL";
	public static final String PRC_INAC_DETALLE_PTRO_DIGITAL = "PRC_INAC_DETALLE_PTRO_DIGITAL";

	public static final String PAR_CNRO_SERIE = "PAR_CNRO_SERIE";

	public static final String PAR_CCALIF_NOMBRE1 = "PAR_CCALIF_NOMBRE1";
	public static final String PAR_CCALIF_NOMBRE2 = "PAR_CCALIF_NOMBRE2";
	public static final String PAR_CCALIF_NOMBRE3 = "PAR_CCALIF_NOMBRE3";
	public static final String PAR_CCALIF_LOTE1 = "PAR_CCALIF_LOTE1";
	public static final String PAR_CCALIF_LOTE2 = "PAR_CCALIF_LOTE2";
	public static final String PAR_CCALIF_LOTE3 = "PAR_CCALIF_LOTE3";
	public static final String PAR_CCALIF_CODIGO1 = "PAR_CCALIF_CODIGO1";
	public static final String PAR_CCALIF_CODIGO2 = "PAR_CCALIF_CODIGO2";
	public static final String PAR_CCALIF_CODIGO3 = "PAR_CCALIF_CODIGO3";
	public static final String PAR_CCALIF_CADUCIDAD1 = "PAR_CCALIF_CADUCIDAD1";
	public static final String PAR_CCALIF_CADUCIDAD2 = "PAR_CCALIF_CADUCIDAD2";
	public static final String PAR_CCALIF_CADUCIDAD3 = "PAR_CCALIF_CADUCIDAD3";
	public static final String PAR_CCALIF_MARCA1 = "PAR_CCALIF_MARCA1";
	public static final String PAR_CCALIF_MARCA2 = "PAR_CCALIF_MARCA2";
	public static final String PAR_CCALIF_MARCA3 = "PAR_CCALIF_MARCA3";
	public static final String PAR_CCALIF_ESPECIFICACION1 = "PAR_CCALIF_ESPECIFICACION1";
	public static final String PAR_CCALIF_ESPECIFICACION2 = "PAR_CCALIF_ESPECIFICACION2";
	public static final String PAR_CCALIF_ESPECIFICACION3 = "PAR_CCALIF_ESPECIFICACION3";

	public static final String PAR_CVERIF_NOMBRE1 = "PAR_CVERIF_NOMBRE1";
	public static final String PAR_CVERIF_NOMBRE2 = "PAR_CVERIF_NOMBRE2";
	public static final String PAR_CVERIF_NOMBRE3 = "PAR_CVERIF_NOMBRE3";
	public static final String PAR_CVERIF_LOTE1 = "PAR_CVERIF_LOTE1";
	public static final String PAR_CVERIF_LOTE2 = "PAR_CVERIF_LOTE2";
	public static final String PAR_CVERIF_LOTE3 = "PAR_CVERIF_LOTE3";
	public static final String PAR_CVERIF_CODIGO1 = "PAR_CVERIF_CODIGO1";
	public static final String PAR_CVERIF_CODIGO2 = "PAR_CVERIF_CODIGO2";
	public static final String PAR_CVERIF_CODIGO3 = "PAR_CVERIF_CODIGO3";
	public static final String PAR_CVERIF_CADUCIDAD1 = "PAR_CVERIF_CADUCIDAD1";
	public static final String PAR_CVERIF_CADUCIDAD2 = "PAR_CVERIF_CADUCIDAD2";
	public static final String PAR_CVERIF_CADUCIDAD3 = "PAR_CVERIF_CADUCIDAD3";
	public static final String PAR_CVERIF_MARCA1 = "PAR_CVERIF_MARCA1";
	public static final String PAR_CVERIF_MARCA2 = "PAR_CVERIF_MARCA2";
	public static final String PAR_CVERIF_MARCA3 = "PAR_CVERIF_MARCA3";
	public static final String PAR_CVERIF_ESPECIFICACION1 = "PAR_CVERIF_ESPECIFICACION1";
	public static final String PAR_CVERIF_ESPECIFICACION2 = "PAR_CVERIF_ESPECIFICACION2";
	public static final String PAR_CVERIF_ESPECIFICACION3 = "PAR_CVERIF_ESPECIFICACION3";
	public static final String PAR_CCALIF_PENDIENTE1 = "PAR_CCALIF_PENDIENTE1";
	public static final String PAR_CCALIF_PENDIENTE2 = "PAR_CCALIF_PENDIENTE2";
	public static final String PAR_CCALIF_PENDIENTE3 = "PAR_CCALIF_PENDIENTE3";
	public static final String PAR_CCALIF_PENDIENTE4 = "PAR_CCALIF_PENDIENTE4";

	public static final String PAR_NID_DETALLE = "PAR_NID_DETALLE";
	public static final String PAR_DFECHA = "PAR_DFECHA";
	public static final String PAR_CRESPONSABLE_DET = "PAR_CRESPONSABLE";
	public static final String PAR_CCALIBRACION1 = "PAR_CCALIBRACION1";
	public static final String PAR_CCALIBRACION2 = "PAR_CCALIBRACION2";
	public static final String PAR_CCALIBRACION3 = "PAR_CCALIBRACION3";
	public static final String PAR_CCALIBRACION4 = "PAR_CCALIBRACION4";
	public static final String PAR_CVERIFICACION1 = "PAR_CVERIFICACION1";
	public static final String PAR_CVERIFICACION2 = "PAR_CVERIFICACION2";
	public static final String PAR_CVERIFICACION3 = "PAR_CVERIFICACION3";
	public static final String PAR_CCONFORMIDAD = "PAR_CCONFORMIDAD";
	public static final String PAR_CREVISADO = "PAR_CREVISADO";
	public static final String PAR_NID_DETALLE_DUP = "PAR_NID_DETALLE_DUP";

	public static final String PAR_NCODIGO = "PAR_NCODIGO";
	public static final String PAR_VESTADO = "PAR_VESTADO";

	// Mantenimiento TABLA CONDUCTIMETRO
	public static final String PACKAGE_CONDUCTIMETRO = "PCK_ALC_CONDUCT";
	public static final String SP_SEARCH_CONDUCTIMETRO = "PRC_BUSCA_CONDUCTIMETRO";
	public static final String PRC_GET_CONDUCTIMETRO = "PRC_GET_CONDUCTIMETRO";
	public static final String SP_INSERT_CONDUCTIMETRO = "PRC_INSERT_CONDUCTIMETRO";
	public static final String SP_UPDATE_CONDUCTIMETRO = "PRC_UPDATE_CONDUCTIMETRO";
	public static final String SP_INACTIVA_CONDUCTIMETRO = "PRC_INACTIVA_CONDUCTIMETRO";
	public static final String SP_LISTA_CONDUCTIMETRO = "PRC_LISTA_CONDUCTIMETRO";
	public static final String SP_DETALLE_CONDUCTIMETRO = "PRC_DETALLE_CONDUCTIMETRO";
	public static final String SP_DETALLE_CONDUCTIMETRO_EDIT = "PRC_INS_DETALLE_CONDUCTI";
	public static final String SP_INAC_DETALLE_CONDUCTI = "PRC_INAC_DETALLE_CONDUCTI";

	public static final String PAR_CCALIF_NOMBRE = "PAR_CCALIF_NOMBRE";
	public static final String PAR_CCALIF_LOTE = "PAR_CCALIF_LOTE";
	public static final String PAR_CCALIF_CODIGO = "PAR_CCALIF_CODIGO";
	public static final String PAR_CCALIF_CADUCIDAD = "PAR_CCALIF_CADUCIDAD";
	public static final String PAR_CCALIF_MARCA = "PAR_CCALIF_MARCA";
	public static final String PAR_CCALIF_ESPECIFICACION = "PAR_CCALIF_ESPECIFICACION";

	public static final String PAR_CVERIF_NOMBRE = "PAR_CVERIF_NOMBRE";
	public static final String PAR_CVERIF_LOTE = "PAR_CVERIF_LOTE";
	public static final String PAR_CVERIF_CODIGO = "PAR_CVERIF_CODIGO";
	public static final String PAR_CVERIF_CADUCIDAD = "PAR_CVERIF_CADUCIDAD";
	public static final String PAR_CVERIF_MARCA = "PAR_CVERIF_MARCA";
	public static final String PAR_CVERIF_ESPECIFICACION = "PAR_CVERIF_ESPECIFICACION";

	public static final String PAR_NAREA = "PAR_NAREA";
	public static final String PAR_CESPECIALISTA = "PAR_CESPECIALISTA";
	public static final String PAR_CEQUIPO_MEDIC = "PAR_CEQUIPO_MEDIC";
	public static final String PAR_CCALIF_KMAX = "PAR_CCALIF_KMAX";
	public static final String PAR_CCALIF_KMIN = "PAR_CCALIF_KMIN";
	public static final String PAR_CCALIF_VALOR1 = "PAR_CCALIF_VALOR1";
	public static final String PAR_CCALIF_VALOR2 = "PAR_CCALIF_VALOR2";
	public static final String PAR_CRESULT1 = "PAR_VRESULT1";
	public static final String PAR_CKCELDA = "PAR_CKCELDA";
	public static final String PAR_CRESULT2 = "PAR_VRESULT2";
	public static final String PAR_CFIRMA = "PAR_CFIRMA";
	public static final String PAR_COCURRENCIA = "PAR_COCURRENCIA";

	// CONTANTES PARA FORMULARIO 242
	public static final String ACTIVOS = "1";
	public static final String INACTIVOS = "0";
	public static final String PKC_ALC_FORM242 = "PKC_ALC_FORM242";
	public static final String PRC_GET_HEADER = "PRC_GET_HEADER";
	public static final String PRC_GET_DETALLE = "PRC_GET_DETALLE";
	public static final String SP_LISTADO_HEADER242 = "PRC_LISTADO_HEADER_FORM242";
	public static final String SP_LISTADO_DETALLE242 = "PRC_LISTADO_DETALLE";
	public static final String SP_INSERT_HEADER = "PRC_INSERT_HEADER";
	public static final String P_FECHA_MUESTREO = "P_FECHA_MUESTREO";
	public static final String P_FECHA_RECEPCION = "P_FECHA_RECEPCION";
	public static final String P_PERSONA_MUESTREA = "P_PERSONA_MUESTREA";
	public static final String P_PERSONA_RECEPCION = "P_PERSONA_RECEPCION";
	public static final String P_COD_HEADER = "P_COD_HEADER";

	public static final String SP_INSERT_DETALLE = "PRC_INSERT_DETALLE";
	public static final String SP_INACTIVA_DETALLE = "PRC_INACTIVA_DETALLE";
	public static final String SP_INACTIVA_HEADER = "PRC_INACTIVA_HEADER";
	public static final String SP_UPDATE_DETALLE = "PRC_UPDATE_DETALLE";
	public static final String SP_UPDATE_HEADER242 = "PRC_UPDATE_HEADER242";
	public static final String P_LOCALIDAD_MUESTREO = "P_LOCALIDAD_MUESTREO";
	public static final String P_PH = "P_PH";
	public static final String P_TEMPERATURA = "P_TEMPERATURA";
	public static final String P_CONDUCTIVIDAD = "P_CONDUCTIVIDAD";
	public static final String P_ESTACION_MUESTREO = "P_ESTACION_MUESTREO";
	public static final String P_TURBIEDAD = "P_TURBIEDAD";
	public static final String P_OXIGENO = "P_OXIGENO";
	public static final String P_CLOROFILA = "P_CLOROFILA";
	public static final String P_FICOCIANINA = "P_FICOCIANINA";
	public static final String P_COORD_W = "P_COORD_W";
	public static final String P_ALTURA = "P_ALTURA";
	public static final String P_FICO = "P_FICO";
	public static final String P_COORD_E = "P_COORD_E";
	public static final String P_HORA = "P_HORA";
	public static final String P_CODIGO_HEADER = "P_CODIGO_HEADER";
	public static final String P_OBSERVACION = "P_OBSERVACION";
	public static final String P_ID_DETALLE = "P_ID_DETALLE";
	public static final String P_IDDETALLE = "P_IDDETALLE";
	public static final String P_ESTADO = "P_ESTADO";

	// CONTANTES PARA FORMULARIO 222
	public static final String P_USUARIO_MODIF = "P_USUARIO_MODIF";
	public static final String P_NOMBRE_PROG = "P_NOMBRE_PROG";
	public static final String PKC_ALC_FORM222 = "PKC_ALC_FORM222";
	public static final String SP_LISTADO_HEADER222 = "PRC_LISTADO_HEADER_FORM222";
	public static final String PRC_GET_HEADER222 = "PRC_GET_HEADER222";
	public static final String PRC_GET_DETALLE222 = "PRC_GET_DETALLE222";
	public static final String P_ID_DETALLE222 = "P_ID_DETALLE222";
	public static final String SP_LISTADO_DETALLE222 = "PRC_LISTADO_DETALLE222";
	public static final String SP_INSERT_HEADER222 = "PRC_INSERT_HEADER222";
	public static final String SP_INSERT_DETALLE222 = "PRC_INSERT_DETALLE222";
	public static final String SP_UPDATE_HEADER222 = "PRC_UPDATE_HEADER222";
	public static final String SP_UPDATE_DETALLE222 = "PRC_UPDATE_DETALLE222";
	public static final String SP_INACTIVA_DETALLE222 = "PRC_INACTIVA_DETALLE222";
	public static final String SP_COUNT_DETALLE = "PRC_COUNT_DETALLE";
	public static final String P_ID_HEADER = "P_ID_HEADER";
	public static final String P_COD_HEADER222 = "P_COD_HEADER222";
	public static final String P_IDMUESTREA1 = "P_IDMUESTREA1";
	public static final String P_IDMUESTREA2 = "P_IDMUESTREA2";
	public static final String P_IDRECEPCIONA1 = "P_IDRECEPCIONA1";
	public static final String P_IDRECEPCIONA2 = "P_IDRECEPCIONA2";
	public static final String P_IDRECEPCIONA3 = "P_IDRECEPCIONA3";
	public static final String P_IDANALISTA = "P_IDANALISTA";
	public static final String P_OBSERV = "P_OBSERV";
	public static final String P_CODMUESTRA1 = "P_CODMUESTRA1";
	public static final String P_CODMUESTRA2 = "P_CODMUESTRA2";
	public static final String P_CODMUESTRA3 = "P_CODMUESTRA3";
	public static final String P_DUP1 = "P_DUP1";
	public static final String P_DUP2 = "P_DUP2";
	public static final String P_DUP3 = "P_DUP3";
	public static final String P_DUP4 = "P_DUP4";
	public static final String P_DUP5 = "P_DUP5";
	public static final String P_PRO1 = "P_PRO1";
	public static final String P_PRO2 = "P_PRO2";
	public static final String P_PRO3 = "P_PRO3";
	public static final String P_PRO4 = "P_PRO4";
	public static final String P_PRO5 = "P_PRO5";
	public static final String P_RDS1 = "P_RDS1";
	public static final String P_RDS2 = "P_RDS2";
	public static final String P_RDS3 = "P_RDS3";
	public static final String P_RDS4 = "P_RDS4";
	public static final String P_RDS5 = "P_RDS5";
	public static final String P_FEC_MUESTREO = "P_FEC_MUESTREO";
	public static final String P_HOR_MUESTREO = "P_HOR_MUESTREO";
	public static final String P_STATUS = "P_STATUS";

	public static final String P_NRO_FRASCO = "P_NRO_FRASCO";
	public static final String P_PUNTO_MUESTREO = "P_PUNTO_MUESTREO";
	public static final String P_COD_MUESTRA = "P_COD_MUESTRA";
	public static final String P_NRO_ENVASE = "P_NRO_ENVASE";
	public static final String P_TIPO_MUESTRA = "P_TIPO_MUESTRA";
	public static final String P_TIPO_PRESERVACION = "P_TIPO_PRESERVACION";
	public static final String P_OD = "P_OD";
	public static final String P_TEMP = "P_TEMP";
	public static final String P_COND = "P_COND";
	public static final String P_TURB = "P_TURB";
	public static final String P_FE = "P_FE";
	public static final String P_MN = "P_MN";
	public static final String P_CR = "P_CR";
	public static final String P_PB = "P_PB";
	public static final String P_ZN = "P_ZN";
	public static final String P_AS = "P_AS";
	public static final String P_CD = "P_CD";
	public static final String P_BA = "P_BA";
	public static final String P_SE = "P_SE";
	public static final String P_AL = "P_AL";
	public static final String P_NA = "P_NA";
	public static final String P_SB = "P_SB";
	public static final String P_CU = "P_CU";
	public static final String P_K = "P_K";
	public static final String P_HG = "P_HG";
	public static final String P_T_ENVASE = "P_T_ENVASE";

	// PLAN OPERATIVO
	public static final String PAR_ESTPLA = "PAR_ESTPLA";
	public static final String PRC_INSERT_PLANOPERATIVO = "PRC_INSERT_PLANOPERATIVO";
	public static final String PRC_UPDATE_PLANOPERATIVO = "PRC_UPDATE_PLANOPERATIVO";
	public static final String PRC_GET_PLANOPERATIVO = "PRC_GET_PLANOPERATIVO";
	public static final String PRC_BUSCA_PLANOPERATIVO = "PRC_BUSCA_PLANOPERATIVO";
	public static final String PAR_DESPLA = "PAR_DESPLA";
	public static final String PAR_CODESP = "PAR_CODESP";
	public static final String PRG_INSERT_PLAN = "PCK_ALC_PLANOPERATIVO.PRC_INSERT_PLANOPERATIVO";

	public static final String PRC_INACTIVAR_PARAMETROPLAN = "PRC_INACTIVAR_PARAMETROPLAN";

	public static final String PAR_MES = "PAR_MES";
	public static final String PRC_BUSCA_REPORTE_PLAN = "PRC_BUSCA_REPORTE_PLAN";
	public static final String PAR_TOTEJE = "PAR_TOTEJE";

	public static final String PRC_UPDATE_REPORTEPLAN = "PRC_UPDATE_REPORTEPLAN";

	public static final String PRC_INSERT_REPORTEPLAN = "PRC_INSERT_REPORTEPLAN";

	public static final String TOTALES_PROGRAMADOS = "TOTALES";

	// Mantenimiento ANALISIS BACTERIOLOGICO
	public static final String PACKAGE_ANALISIS_BACTERIOLOGICO = "PCK_ALC_ANALBACT";
	public static final String SP_SEARCH_ANALBACT = "PRC_BUSCA_ANALBACT";
	public static final String SP_GET_ANALBACT = "PRC_GET_ANALBACT";
	public static final String SP_INSERT_ANALBACT = "PRC_INSERT_ANALBACT";
	public static final String SP_UPDATE_ANALBACT = "PRC_UPDATE_ANALBACT";
	public static final String SP_INACTIVA_ANALBACT = "PRC_INACTIVA_ANALBACT";
	public static final String SP_LISTA_ANALBACT = "PRC_LISTA_ANALBACT";
	public static final String SP_INSERT_RESULTMUES = "PRC_INSERT_RESULTMUES";
	public static final String SP_INSERT_MUESTRAFIRST = "PRC_INSERT_MUESTFIRST";
	public static final String SP_INSERT_MUESTRASECOND = "PRC_INSERT_MUESTSECOND";
	public static final String SP_SEARCH_MUESTFIRST = "PRC_BUSCA_MUESTFIRST";
	public static final String SP_GET_MUESTFIRST = "PRC_GET_MUESTFIRST";
	public static final String SP_UPDATE_MUESTFIRST = "PRC_UPDATE_MUESTFIRST";
	public static final String SP_SEARCH_MUESTSECOND = "PRC_BUSCA_MUESTSECOND";
	public static final String SP_GET_MUESTSECOND = "PRC_GET_MUESTSECOND";
	public static final String SP_UPDATE_MUESTSECOND = "PRC_UPDATE_MUESTSECOND";
	public static final String SP_SEARCH_RESULTMUES = "PRC_BUSCA_RESULTMUES";
	public static final String SP_CALCULO_MUESTSECOND = "PRC_CALCULO_MUESTSECOND";
	public static final String SP_CALCULO_MUESTFIRST = "PRC_CALCULO_MUESTFIRST";
	public static final String SP_DUPLICADO_MUESTFIRST = "PRC_DUPLICADO_MUESTFIRST";
	public static final String SP_DEL_DUPLIC_MUESTFIRST = "PRC_DEL_DUPLIC_MUESTFIRST";
	public static final String SP_DUPLICADO_MUESTSECOND = "PRC_DUPLICADO_MUESTSECOND";
	public static final String SP_DEL_DUPLIC_MUESTSECOND = "PRC_DEL_DUPLIC_MUESTSECOND";
	public static final String SP_CALC_ENSAYO_BACTERIO = "PRC_CALC_ENSAYO_BACTERIO";
	public static final String SP_BUSCA_PLANTA = "PRC_BUSCA_PLANTA";
	public static final String SP_BUSCA_EFICIENCIA = "PRC_BUSCA_EFICIENCIA";
	public static final String SP_UPD_ANALBACTRESUL = "PRC_UPD_ANALBACTRESUL";
	public static final String SP_UPD_ANALBACTRESUL2= "PRC_UPD_ANALBACTRESUL2";

	public static final String PAR_NID_CABECERA = "PAR_NID_CABECERA";
	public static final String PAR_DFECHA_MUESTREO = "PAR_DFECHA_MUESTREO";
	public static final String PAR_DFECHA_RECEPCION = "PAR_DFECHA_RECEPCION";
	public static final String PAR_DFECHA_INI_ENSAYO = "PAR_DFECHA_INI_ENSAYO";
	public static final String PAR_CHORA_MUESTREO = "PAR_CHORA_MUESTREO";
	public static final String PAR_CHORA_RECEPCION = "PAR_CHORA_RECEPCION";
	public static final String PAR_CHORA_INI_ENSAYO = "PAR_CHORA_INI_ENSAYO";
	public static final String PAR_CTURNO = "PAR_CTURNO";
	public static final String PAR_CMUESTREADOR = "PAR_CMUESTREADOR";
	public static final String PAR_CANALISTA = "PAR_CANALISTA";
	public static final String PAR_CCUMPLIMIENTO = "PAR_CCUMPLIMIENTO";
	public static final String PAR_CMANTENIMIENTO = "PAR_CMANTENIMIENTO";
	public static final String PAR_C_INTERPELACI = "PAR_C_INTERPELACI";

	public static final String PAR_CCOLIFOR = "PAR_CCOLIFOR";
	public static final String PAR_CCOLTER = "PAR_CCOLTER";
	public static final String PAR_CBACHET = "PAR_CBACHET";
	public static final String PAR_NTIPO = "PAR_NTIPO";
	public static final String PAR_CDESCMUESTRA = "PAR_CDESCMUESTRA";
	public static final String PAR_CTURNTU = "PAR_CTURNTU";
	public static final String PAR_CCOLAGA = "PAR_CCOLAGA";
	public static final String PAR_CLIMITEMAX = "PAR_CLIMITEMAX";
	public static final String PAR_CLIMITECAL = "PAR_CLIMITECAL";
		

	public static final String PAR_CDIL = "PAR_CDIL";
	public static final String PAR_CTCLT24 = "PAR_CTCLT24";
	public static final String PAR_CTCLT48 = "PAR_CTCLT48";
	public static final String PAR_CTCLV24 = "PAR_CTCLV24";
	public static final String PAR_CTCLV48 = "PAR_CTCLV48";
	public static final String PAR_CTUEC24 = "PAR_CTUEC24";
	public static final String PAR_CTUEC48 = "PAR_CTUEC48";
	public static final String PAR_CAGARML = "PAR_CAGARML";
	public static final String PAR_CAGARDL = "PAR_CAGARDL";

	public static final String PAR_CCL2RES = "PAR_CCL2RES";
	public static final String PAR_CAGAREL = "PAR_CAGAREL";
	public static final String PAR_CAGELE = "PAR_CAGELE";
	public static final String PAR_CGAMFC = "PAR_CGAMFC";
	public static final String PAR_CAGMFC = "PAR_CAGMFC";
	public static final String PAR_CCOAGAR = "PAR_CCOAGAR";

	public static final int PRIMERA_MUESTRA = 1;
	public static final int SEGUNDA_MUESTRA = 2;

	public static final int PLANTA1 = 1;
	public static final int PLANTA2 = 2;
	public static final String MES_PLAN_OPERATIVO_DEFAULT = "01";

	// CONTANTES PARA FORMULARIO 314
	public static final String PKC_ALC_FORM314 = "PKC_ALC_FORM314";
	public static final String SP_LISTADO_FORM314 = "PRC_LISTADO_FORM314";
	public static final String SP_INSERT_FORM314 = "PRC_INSERT_FORM314";
	public static final String SP_UPDATE_FORM314 = "PRC_UPDATE_FORM314";
	public static final String PRC_INACTIVA_FORM314 = "PRC_INACTIVA_FORM314";
	public static final String PRC_GET_FORM314 = "PRC_GET_FORM314";
	public static final String PRC_DATA_GRAFICO = "PRC_DATA_GRAFICO";
	public static final String P_IDFORM314 = "P_IDFORM314";
	public static final String P_PERIODO = "P_PERIODO";
	public static final String P_TIPO_ENSAYO = "P_TIPO_ENSAYO";
	public static final String P_FECHA = "P_FECHA";
	public static final String P_ANALISTA = "P_ANALISTA";
	public static final String P_CODMUESTRA = "P_CODMUESTRA";
	public static final String P_RESULTADO1 = "P_RESULTADO1";
	public static final String P_RESULTADO2 = "P_RESULTADO2";
	public static final String P_RDS = "P_RDS";

	// CONTANTES PARA FORMULARIO 312
	public static final String REP_GRAF1_X_TITULO = "PERIODO {param1} {param2} (dias)";
	public static final String PARAM1 = "{param1}";
	public static final String PARAM2 = "{param2}";

	public static final String REP_GRAF1_X_TITULO_UNDEFINED = "PERIODO NO ESPECIFICADO O INVALIDO";
	public static final Integer REP_GRAF1_DIAS_DEFAULT = 31;
	// TITULO DE LOS EJES
	public static final String REP_GRAF1_Y_TITULO = "% RPD";

	public static final String PRC_BUSCA_TOTALES_FORM20 = "PRC_BUSCA_TOTALES_FORM20";
	public static final String PAR_TIPRES = "PAR_TIPRES";

	// ANALISIS HIDROBIOLOGICO
	public static final String PCK_ALC_ANALISISHIDROBIO = "PCK_ALC_ANALISISHIDROBIO";
	public static final String PRC_INSERT_ANALISISHIDROBIO = "PRC_INSERT_ANALISISHIDROBIO";
	
	public static final String PAR_CODOXS = "PAR_CODOXS";
	public static final String PAR_FECANA = "PAR_FECANA";
	public static final String PAR_TIPORG = "PAR_TIPORG";
	public static final String PAR_CANTID = "PAR_CANTID";
	public static final String PAR_CODORG = "PAR_CODORG";
	public static final String PAR_FECREP = "PAR_FECREP";
	
	public static final String PRC_BUSCA_REPORTEHIDRO = "PRC_BUSCA_REPORTEHIDRO";
	
	public static final String PRC_BUSCA_REPORHIDRODETALLE = "PRC_BUSCA_REPORHIDRODETALLE";
	
	public static final String PAR_PUNTO = "PAR_PUNTO";
	
	public static final String IDENTIFICADOR_ALGAS = "reporte.hidrobiologico.catalogo.algas";
	public static final String IDENTIFICADOR_CIANOBACTERIAS = "reporte.hidrobiologico.catalogo.cianobacterias";
	public static final String IDENTIFICADOR_NEMATODES = "reporte.hidrobiologico.catalogo.nematodes";
	public static final String IDENTIFICADOR_OTROS = "reporte.hidrobiologico.catalogo.otros";
	public static final Integer VALUE_DEFAULT = 0;
	
	public static final String PRC_INSERT_REPORTEHIDROBIO = "PRC_INSERT_REPORTEHIDROBIO";
	public static final String PAR_CODREP = "PAR_CODREP";
	public static final String PAR_FECMUE = "PAR_FECMUE";
	
	
	public static final String PAR_PERMUE = "PAR_PERMUE";
	public static final String PAR_PERANA = "PAR_PERANA";
	public static final String PAR_CORDET = "PAR_CORDET";
	public static final String PAR_CODIGO = "PAR_CODIGO";
	
	public static final String PAR_CANALG = "PAR_CANALG";
	public static final String PAR_CIANOB = "PAR_CIANOB";
	public static final String PAR_NEMATO = "PAR_NEMATO";
	public static final String PAR_ZOTROS = "PAR_ZOTROS";
	public static final String PAR_TOTORG = "PAR_TOTORG";
	public static final String PAR_ECAMIN = "PAR_ECAMIN";
	public static final String PRC_CORREDET_REPORTEHIDRO = "PRC_CORREDET_REPORTEHIDRO";
	
	public static final String PROGRAMA_INSERT_REPORTEHIDROBIO = "PCK_ALC_ANALISISHIDROBIO.PRC_INSERT_REPORTEHIDROBIO";
	
	//ALMACENAMIENTO PTAP
	public static final String PACKAGE_ALMACENA_PTAP = "PCK_ALC_PTAP";	
	public static final String SP_SEARCH_ALMACENA_PTAP = "PRC_BUSCA_ALMACENA_PTAP";
	public static final String SP_GET_ALMACENA_PTAP = "PRC_GET_ALMACENA_PTAP";
	public static final String SP_INSERT_ALMACENA_PTAP = "PRC_INSERT_ALMACENA_PTAP";
	public static final String SP_UPDATE_ALMACENA_PTAP = "PRC_UPDATE_ALMACENA_PTAP";
	public static final String SP_INACTIVA_ALMACENA_PTAP = "PRC_INACTIVA_ALMACENA_PTAP";
	public static final String SP_INSERT_MUESTRFORM21 = "PRC_INSERT_MUESTRFORM21";
	public static final String SP_SEARCH_MUESTRFORM21 = "PRC_BUSCA_MUESTRFORM21";
	public static final String SP_GET_MUESTRFORM21 = "PRC_GET_MUESTRFORM21";
	public static final String SP_UPDATE_MUESTRFORM21 = "PRC_UPDATE_MUESTRFORM21";
	public static final String SP_SEARCH_MUESTELEF21 = "PRC_BUSCA_MUESTELEF21"; 
	public static final String SP_SEARCH_MUESTEPAF21 = "PRC_BUSCA_MUESTEPAF21"; 
	public static final String SP_INSERT_MUESTELEF21 = "PRC_INSERT_MUESTELEF21"; 
	public static final String SP_INACTIVA_MUESTELEF21 = "PRC_INACTIVA_MUESTELEF21";
	public static final String SP_INSERT_MUESTEPAF21 = "PRC_INSERT_MUESTEPAF21"; 
	public static final String SP_INACTIVA_MUESTEPAF21 = "PRC_INACTIVA_MUESTEPAF21";
	public static final String SP_CALCULO_MUESTELEF21 = "PRC_CALCULO_MUESTELEF21";
	public static final String SP_INSERT_MUESTRFOR299 = "PRC_INSERT_MUESTRFOR299";
	public static final String SP_SEARCH_MUESTRFOR299 = "PRC_BUSCA_MUESTRFOR299";
	public static final String SP_GET_MUESTRFOR299    = "PRC_GET_MUESTRFOR299";
	public static final String SP_UPD_MUESTRFOR299    = "PRC_UPD_MUESTRFOR299";
	
	public static final String PAR_C_TURNTU = "PAR_C_TURNTU";
	public static final String PAR_C_CLRLIB = "PAR_C_CLRLIB";
	public static final String PAR_C_AGELFI = "PAR_C_AGELFI";
	public static final String PAR_C_COAGEL = "PAR_C_COAGEL";
	public static final String PAR_C_AGMFCV = "PAR_C_AGMFCV";
	public static final String PAR_C_COLAMF = "PAR_C_COLAMF";
	public static final String PAR_C_AG2AML = "PAR_C_AG2AML";
	public static final String PAR_C_AG2ADL = "PAR_C_AG2ADL";
	public static final String PAR_C_COLA2A = "PAR_C_COLA2A";
	public static final String PAR_C_AGMPVF = "PAR_C_AGMPVF";
	public static final String PAR_C_COLAPA = "PAR_C_COLAPA";
	
   public static final String PAR_CDESCRI = "PAR_CDESCRI";                 
   public static final String PAR_CCOLONI = "PAR_CCOLONI";                 
   public static final String PAR_CGASCLT = "PAR_CGASCLT";                 
   public static final String PAR_CGASCLV = "PAR_CGASCLV";                 
   public static final String PAR_CGSEC24 = "PAR_CGSEC24";                 
   public static final String PAR_CFECMUG = "PAR_CFECMUG";                 
   public static final String PAR_CCOLTOT = "PAR_CCOLTOT";                              
   public static final String PAR_CESCOLI = "PAR_CESCOLI";  
   public static final String PAR_CAGLECH = "PAR_CAGLECH";                              
   public static final String PAR_CPSEAE = "PAR_CPSEAE";
   
   public static final String PAR_CRESMEN = "PAR_CRESMEN";
   public static final String PAR_CRESVIC = "PAR_CRESVIC";
   public static final String PAR_CREVIRS = "PAR_CREVIRS";
   public static final String PAR_CRESRED = "PAR_CRESRED";
	
	public static final String PAR_NID_FORM = "PAR_NID_FORM";
	public static final int PAR_NID_FORM_ALMACENAMIENTO_LTAP = 21;
	public static final int PAR_NID_FORM_ANALISIS_BACTERIOLOGICO_BOCATOMA = 20;
		
	public static final String PRC_BUSCA_DETXCORREL = "PRC_BUSCA_DETXCORREL";
	
	public static final String PCK_ALC_REPORFITOPLANCTON = "PCK_ALC_REPORFITOPLANCTON";
	public static final String PRC_BUSCA_REPORFITODETALLE = "PRC_BUSCA_REPORFITODETALLE";
	public static final String PRC_INSERT_REPORTEFITO = "PRC_INSERT_REPORTEFITO";
	public static final String PROGRAMA_INSERT_REPORTEFITO = "PCK_ALC_REPORFITOPLANCTON.PRC_INSERT_REPORTEFITO";
	
	public static final String PAR_CANCLO = "PAR_CANCLO";
	public static final String PAR_CANFIC = "PAR_CANFIC";
	
	public static final String PRC_CORREDET_REPORTEFITO = "PRC_CORREDET_REPORTEFITO";
	public static final String PRC_BUSCA_REPORTEFITO = "PRC_BUSCA_REPORTEFITO";
	
	public static final String PRC_BUSCA_DETXCORRELFITO = "PRC_BUSCA_DETXCORRELFITO";
	public static final String PRC_DELETE_REPORTEFITO = "PRC_DELETE_REPORTEFITO";
	public static final String EMPTY_VALUE = "";
	public static final String PRC_DELETE_REPORTEHIDRO = "PRC_DELETE_REPORTEHIDRO";
	
	public static final String PRC_BUSCA_ANALISISHIDROPAR = "PRC_BUSCA_ANALISISHIDROPAR";
	public static final String PROGRAMA_INSERT_ANALISISHIDRO = "PCK_ALC_ANALISISHIDROBIO.PRC_INSERT_ANALISISHIDROBIO";
	public static final String PATH_RESULT_GENERICSAVE = "generic/genericSave :: genericSave";
	public static final String ORDER_COLUMN_TABLE = "order[0][column]";
	
	//CONSTANTES PARA ENSAYO CLORO
	public static final String PCK_ALC_ENSAYOCLORO = "PCK_ALC_ENSAYOCLORO";
	public static final String PRC_BUSCA_ENSAYOCLORO = "PRC_BUSCA_ENSAYOCLORO";
	
	
	
//	public static final String PRC_BUSCA_ENSAYOCLORO = "PRC_BUSCA_ENSAYOCLORO";
//	public static final String PRC_BUSCA_ENSAYOCLORO = "PRC_BUSCA_ENSAYOCLORO";
	
	
	
	
}
