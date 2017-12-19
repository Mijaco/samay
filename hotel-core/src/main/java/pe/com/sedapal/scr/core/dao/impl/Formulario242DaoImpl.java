package pe.com.sedapal.scr.core.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;
import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.common.core.utils.ConstantsCommon;
import pe.com.sedapal.common.core.utils.CoreUtils;
import pe.com.sedapal.scr.core.beans.Formulario153;
import pe.com.sedapal.scr.core.beans.FormularioDetalle242;
import pe.com.sedapal.scr.core.beans.FormularioHeader242;
import pe.com.sedapal.scr.core.common.Constants;
import pe.com.sedapal.scr.core.common.ConstantsLaboratorio;
import pe.com.sedapal.scr.core.dao.IFormulario242Dao;
import pe.com.sedapal.scr.core.util.ExecuteProcedure;

@Repository
public class Formulario242DaoImpl implements IFormulario242Dao {
	
	private static final Logger LOG = LoggerFactory.getLogger(Constants.PACKAGE);
	
	@Autowired
	private Environment environment;
	
	private JdbcTemplate template;
	private ExecuteProcedure execSp;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public Result getListadoFormularioHeader(FormularioHeader242 formularioHeader242, Paginacion paginacion) {
		
		List lstRetorno = null;

		SimpleJdbcCall caller = new SimpleJdbcCall(template.getDataSource());
		caller.withCatalogName(ConstantsLaboratorio.PKC_ALC_FORM242).withProcedureName(ConstantsLaboratorio.SP_LISTADO_HEADER242)
				.declareParameters(
						// parametros de búsquedaConstantsLaboratorio
						new SqlParameter(ConstantsLaboratorio.P_FECHA_MUESTREO, Types.VARCHAR),
						new SqlParameter(Constants.PAR_COLORDERBY, Types.INTEGER),
						new SqlParameter(Constants.PAR_COLORDERBYDIR, Types.VARCHAR),
						new SqlParameter(Constants.PAR_PAGDESDE, Types.INTEGER),
						new SqlParameter(Constants.PAR_CANTIDADPAG, Types.INTEGER),
						new SqlOutParameter(Constants.PAR_OUTQUANTITY, Types.INTEGER), new SqlOutParameter(
								ConstantsCommon.PAR_OUT_CURSOR, OracleTypes.CURSOR, new RowMapper<ArrayList>() {

									@SuppressWarnings("unchecked")
									@Override
									public ArrayList mapRow(ResultSet rs, int rowNum) throws SQLException {
										ArrayList record = new ArrayList();
										record.add("");
										record.add(rs.getString(1)); // "FEC_MUESTREO"
										record.add(rs.getString(2)); // "FEC_RECEPCION"
										record.add(rs.getString(3)); // "PERSONA_MUESTREO"
										record.add(rs.getString(4)); // "PERSONA_RECEPCION"
										record.add(rs.getString(5)); // "CODIGO"

										return record;
									}
								}))
				.withSchemaName(environment.getRequiredProperty(ConstantsCommon.ORACLE_PROCEDURES_SCHEMA));

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue(ConstantsLaboratorio.P_FECHA_MUESTREO, formularioHeader242.getStrFechaMuestreo());
		params.addValue(Constants.PAR_COLORDERBY, paginacion.getColorderby());
		params.addValue(Constants.PAR_COLORDERBYDIR, paginacion.getColorderbydir());
		params.addValue(Constants.PAR_PAGDESDE, paginacion.getPagdesde());
		params.addValue(Constants.PAR_CANTIDADPAG, paginacion.getCantidadpag());

		Map<String, Object> results = caller.execute(params);
		int quantity = (int) results.get(Constants.PAR_OUTQUANTITY);
		lstRetorno = (List) results.get(ConstantsCommon.PAR_OUT_CURSOR);

		Result result = new Result();
		result.setData(lstRetorno);
		result.setRecords((long) quantity);

		return result;
	}

	@Override
	public void grabarFormularioHeader(FormularioHeader242 formularioHeader242)  {
		
		List<SqlParameter> lstParamsInput = null;
		List<SqlOutParameter> lstParamsOutput = null;
		System.out.println("DAO_IMPLEMENTACION: " +formularioHeader242.getStrFechaMuestreo());

		Map<String, Object> inputs = null;
		try {
			lstParamsInput = new ArrayList<SqlParameter>();
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_FECHA_MUESTREO, OracleTypes.VARCHAR));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_FECHA_RECEPCION, OracleTypes.VARCHAR));	
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_PERSONA_MUESTREA, OracleTypes.VARCHAR));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_PERSONA_RECEPCION, OracleTypes.VARCHAR));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_OBSERVACION, OracleTypes.VARCHAR));
			lstParamsInput.add(new SqlParameter(Constants.A_PAR_USUARIO_CREACION, OracleTypes.VARCHAR));		
			lstParamsInput.add(new SqlParameter(Constants.A_PAR_USUARIO_MODIFICACION, OracleTypes.VARCHAR));		
			lstParamsInput.add(new SqlParameter(Constants.A_PAR_NOMBRE_PROGRAMA, OracleTypes.VARCHAR));	
	
			lstParamsOutput = new ArrayList<SqlOutParameter>();
			
	    
			this.execSp = new ExecuteProcedure(template.getDataSource(), 
					CoreUtils.concatenar(ConstantsLaboratorio.PKC_ALC_FORM242,ConstantsCommon.P_SEPARADOR,ConstantsLaboratorio.SP_INSERT_HEADER), lstParamsInput, lstParamsOutput);
			inputs = new HashMap<String, Object>();
		    inputs.put(ConstantsLaboratorio.P_FECHA_MUESTREO, formularioHeader242.getStrFechaMuestreo());
			inputs.put(ConstantsLaboratorio.P_FECHA_RECEPCION, formularioHeader242.getStrFechaRecepcion());
			inputs.put(ConstantsLaboratorio.P_PERSONA_MUESTREA, formularioHeader242.getPersonaMuestrea());
			inputs.put(ConstantsLaboratorio.P_PERSONA_RECEPCION, formularioHeader242.getPersonaRecepcion());
			inputs.put(ConstantsLaboratorio.P_OBSERVACION, formularioHeader242.getObservacion());
			inputs.put(Constants.A_PAR_USUARIO_CREACION, formularioHeader242.getUsuarioCreacion());		
			inputs.put(Constants.A_PAR_USUARIO_MODIFICACION,formularioHeader242.getUsuarioModificacion());		
			inputs.put(Constants.A_PAR_NOMBRE_PROGRAMA, formularioHeader242.getPrograma());	
			
			this.execSp.executeSp(inputs);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@Override
	public void grabarFormularioDetalle(FormularioDetalle242 formularioDetalle242) {
		List<SqlParameter> lstParamsInput = null;
		List<SqlOutParameter> lstParamsOutput = null;

		Map<String, Object> inputs = null;
		try {
			lstParamsInput = new ArrayList<SqlParameter>();
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_LOCALIDAD_MUESTREO, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_ESTACION_MUESTREO, OracleTypes.NUMBER));	
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_ALTURA, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_HORA, OracleTypes.VARCHAR));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_COORD_W, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_COORD_E, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_PH, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_TEMPERATURA, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_CONDUCTIVIDAD, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_TURBIEDAD, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_OXIGENO, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_CLOROFILA, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_FICOCIANINA, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_OBSERVACION, OracleTypes.VARCHAR));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_CODIGO_HEADER, OracleTypes.NUMBER));
			
			lstParamsInput.add(new SqlParameter(Constants.A_PAR_USUARIO_CREACION, OracleTypes.VARCHAR));		
			lstParamsInput.add(new SqlParameter(Constants.A_PAR_USUARIO_MODIFICACION, OracleTypes.VARCHAR));		
			lstParamsInput.add(new SqlParameter(Constants.A_PAR_NOMBRE_PROGRAMA, OracleTypes.VARCHAR));	
	
			lstParamsOutput = new ArrayList<SqlOutParameter>();
			
	    
			this.execSp = new ExecuteProcedure(template.getDataSource(), 
					CoreUtils.concatenar(ConstantsLaboratorio.PKC_ALC_FORM242,ConstantsCommon.P_SEPARADOR,ConstantsLaboratorio.SP_INSERT_DETALLE), lstParamsInput, lstParamsOutput);
			inputs = new HashMap<String, Object>();
			inputs.put(ConstantsLaboratorio.P_LOCALIDAD_MUESTREO, formularioDetalle242.getLocalMuestreo());
			inputs.put(ConstantsLaboratorio.P_ESTACION_MUESTREO, formularioDetalle242.getEstacionMuestreo());
			inputs.put(ConstantsLaboratorio.P_ALTURA, formularioDetalle242.getAltura());
			inputs.put(ConstantsLaboratorio.P_HORA, formularioDetalle242.getHora());
			inputs.put(ConstantsLaboratorio.P_COORD_W, formularioDetalle242.getCoordenadaW());
			inputs.put(ConstantsLaboratorio.P_COORD_E, formularioDetalle242.getCoordenadaE());
			inputs.put(ConstantsLaboratorio.P_PH, formularioDetalle242.getPh());
			inputs.put(ConstantsLaboratorio.P_TEMPERATURA, formularioDetalle242.getTemperatura());
			inputs.put(ConstantsLaboratorio.P_CONDUCTIVIDAD, formularioDetalle242.getConductividad());
			inputs.put(ConstantsLaboratorio.P_TURBIEDAD, formularioDetalle242.getTurbiedad());
			inputs.put(ConstantsLaboratorio.P_OXIGENO, formularioDetalle242.getOxigeno());
			inputs.put(ConstantsLaboratorio.P_CLOROFILA, formularioDetalle242.getClorofila());
			inputs.put(ConstantsLaboratorio.P_FICOCIANINA, formularioDetalle242.getFicocianina());
			inputs.put(ConstantsLaboratorio.P_OBSERVACION, formularioDetalle242.getObservaciones());
			inputs.put(ConstantsLaboratorio.P_CODIGO_HEADER, formularioDetalle242.getCodigoHeader());
		
			inputs.put(Constants.A_PAR_USUARIO_CREACION, formularioDetalle242.getUsuarioCreacion());		
			inputs.put(Constants.A_PAR_USUARIO_MODIFICACION,formularioDetalle242.getUsuarioModificacion());		
			inputs.put(Constants.A_PAR_NOMBRE_PROGRAMA, formularioDetalle242.getPrograma());	
			
			this.execSp.executeSp(inputs);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public FormularioHeader242 getFormularioHeader(Integer id) {
		ArrayList ret = null;
		FormularioHeader242 result = null;
		
		SimpleJdbcCall caller = new SimpleJdbcCall(template.getDataSource());
		caller.withCatalogName(ConstantsLaboratorio.PKC_ALC_FORM242).withProcedureName(ConstantsLaboratorio.PRC_GET_HEADER)
		.declareParameters(new SqlParameter(ConstantsLaboratorio.P_ID_REGISTRO, Types.INTEGER), new SqlOutParameter(
				Constants.PAR_OUT_CURSOR, OracleTypes.CURSOR, new RowMapper<FormularioHeader242>() {

					@Override
					public FormularioHeader242 mapRow(ResultSet rs, int rowNum) throws SQLException {
						FormularioHeader242 record = new FormularioHeader242();
						
						record.setStrFechaMuestreo(rs.getString(1));
						record.setStrFechaRecepcion(rs.getString(2));
						record.setPersonaMuestrea(rs.getString(3));
						record.setPersonaRecepcion(rs.getString(4));
						record.setObservacion(rs.getString(5));
						record.setIdHeader(rs.getInt(6));
						
						return record;
					}

				}))
		.withSchemaName(environment.getRequiredProperty(ConstantsLaboratorio.ORACLE_PROCEDURES_SCHEMA));

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue(ConstantsLaboratorio.P_ID_REGISTRO, id);

		Map<String, Object> results = caller.execute(params);
		ret = (ArrayList) results.get(Constants.PAR_OUT_CURSOR);

		result = (FormularioHeader242) ret.get(0);
		
		return result;
	}

	

	@Override
	public Result getListadoFormularioDetalle(FormularioDetalle242 formularioDetalle242, Paginacion paginacion) {
		List lstRetorno = null;

		SimpleJdbcCall caller = new SimpleJdbcCall(template.getDataSource());
		caller.withCatalogName(ConstantsLaboratorio.PKC_ALC_FORM242).withProcedureName(ConstantsLaboratorio.SP_LISTADO_DETALLE242)
				.declareParameters(
						// parametros de búsquedaConstantsLaboratorio
						new SqlParameter(ConstantsLaboratorio.P_COD_HEADER, Types.VARCHAR),
						new SqlParameter(Constants.PAR_COLORDERBY, Types.INTEGER),
						new SqlParameter(Constants.PAR_COLORDERBYDIR, Types.VARCHAR),
						new SqlParameter(Constants.PAR_PAGDESDE, Types.INTEGER),
						new SqlParameter(Constants.PAR_CANTIDADPAG, Types.INTEGER),
						new SqlOutParameter(Constants.PAR_OUTQUANTITY, Types.INTEGER), new SqlOutParameter(
								ConstantsCommon.PAR_OUT_CURSOR, OracleTypes.CURSOR, new RowMapper<ArrayList>() {

									@SuppressWarnings("unchecked")
									@Override
									public ArrayList mapRow(ResultSet rs, int rowNum) throws SQLException {
										ArrayList record = new ArrayList();
										record.add("");
										record.add(rs.getString(1)); // LOCALIDAD
										record.add(rs.getString(2)); // ESTACION DE MUESTREO
										record.add(rs.getDouble(3)); // COORDEN W
										record.add(rs.getDouble(4)); // COORDEN E
										record.add(rs.getDouble(5)); // ALTURA
										record.add(rs.getString(6)); // HORA
										record.add(rs.getDouble(7)); // PH
										record.add(rs.getDouble(8)); // TEMP
										record.add(rs.getDouble(9)); // CONDUCTIV
										record.add(rs.getDouble(10)); // TURBIEDAD
										record.add(rs.getDouble(11)); // OXIGENO
										record.add(rs.getDouble(12)); // CLOROF
										record.add(rs.getString(13)); // OBSERV
										record.add(rs.getInt(14)); // COD_DETALLE(N_CODMUE)
										return record;
									}
								}))
				.withSchemaName(environment.getRequiredProperty(ConstantsCommon.ORACLE_PROCEDURES_SCHEMA));

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue(ConstantsLaboratorio.P_COD_HEADER, formularioDetalle242.getCodigoHeader());
		params.addValue(Constants.PAR_COLORDERBY, paginacion.getColorderby());
		params.addValue(Constants.PAR_COLORDERBYDIR, paginacion.getColorderbydir());
		params.addValue(Constants.PAR_PAGDESDE, paginacion.getPagdesde());
		params.addValue(Constants.PAR_CANTIDADPAG, paginacion.getCantidadpag());

		Map<String, Object> results = caller.execute(params);
		int quantity = (int) results.get(Constants.PAR_OUTQUANTITY);
		lstRetorno = (List) results.get(ConstantsCommon.PAR_OUT_CURSOR);

		Result result = new Result();
		result.setData(lstRetorno);
		result.setRecords((long) quantity);

		return result;
		
		
	}

	@Override
	public void inactivarFormularioDetalle(FormularioDetalle242 formularioDetalle242) {
		List<SqlParameter> lstParamsInput = null;
		List<SqlOutParameter> lstParamsOutput = null;

		Map<String, Object> inputs = null;
		try {
			lstParamsInput = new ArrayList<SqlParameter>();
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_IDDETALLE, OracleTypes.VARCHAR));	
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_ESTADO, OracleTypes.VARCHAR));	
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.A_PAR_USUARIO_MODIFICACION, OracleTypes.VARCHAR));		
			
			lstParamsOutput = new ArrayList<SqlOutParameter>();
			
			this.execSp = new ExecuteProcedure(template.getDataSource(), ConstantsLaboratorio.PKC_ALC_FORM242 + ConstantsLaboratorio.P_SEPARADOR + ConstantsLaboratorio.SP_INACTIVA_DETALLE, lstParamsInput, lstParamsOutput);
			inputs = new HashMap<String, Object>();
			inputs.put(ConstantsLaboratorio.P_IDDETALLE, formularioDetalle242.getIdDetalle());
			inputs.put(ConstantsLaboratorio.P_ESTADO, formularioDetalle242.getEstado());
			inputs.put(ConstantsLaboratorio.A_PAR_USUARIO_MODIFICACION,formularioDetalle242.getUsuarioModificacion());		
			
			this.execSp.executeSp(inputs);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public FormularioDetalle242 getFormularioDetalle(Integer id) {
		ArrayList ret = null;
		FormularioDetalle242 result = null;
		
		SimpleJdbcCall caller = new SimpleJdbcCall(template.getDataSource());
		caller.withCatalogName(ConstantsLaboratorio.PKC_ALC_FORM242).withProcedureName(ConstantsLaboratorio.PRC_GET_DETALLE)
		.declareParameters(new SqlParameter(ConstantsLaboratorio.P_ID_DETALLE, Types.INTEGER), new SqlOutParameter(
				Constants.PAR_OUT_CURSOR, OracleTypes.CURSOR, new RowMapper<FormularioDetalle242>() {

					@Override
					public FormularioDetalle242 mapRow(ResultSet rs, int rowNum) throws SQLException {
						FormularioDetalle242 record = new FormularioDetalle242();
						
						record.setLocalMuestreo(rs.getInt(1));
						record.setEstacionMuestreo(rs.getInt(2));
						record.setCoordenadaW(rs.getDouble(3));
						record.setCoordenadaE(rs.getDouble(4));
						record.setAltura(rs.getDouble(5));
						record.setHora(rs.getString(6));
						record.setPh(rs.getDouble(7));
						record.setTemperatura(rs.getDouble(8));
						record.setConductividad(rs.getDouble(9));
						record.setTurbiedad(rs.getDouble(10));
						record.setOxigeno(rs.getDouble(11));
						record.setClorofila(rs.getDouble(12));
						record.setObservaciones(rs.getString(13));
						record.setIdDetalle(rs.getInt(14));
						
						return record;
					}

				}))
		.withSchemaName(environment.getRequiredProperty(ConstantsLaboratorio.ORACLE_PROCEDURES_SCHEMA));

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue(ConstantsLaboratorio.P_ID_DETALLE, id);

		Map<String, Object> results = caller.execute(params);
		ret = (ArrayList) results.get(Constants.PAR_OUT_CURSOR);

		result = (FormularioDetalle242) ret.get(0);
		
		return result;
	}

	@Override
	public void updateFormularioDetalle(FormularioDetalle242 formularioDetalle242) {
		List<SqlParameter> lstParamsInput = null;
		List<SqlOutParameter> lstParamsOutput = null;

		Map<String, Object> inputs = null;
		try {
			lstParamsInput = new ArrayList<SqlParameter>();
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_LOCALIDAD_MUESTREO, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_ESTACION_MUESTREO, OracleTypes.NUMBER));	
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_ALTURA, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_HORA, OracleTypes.VARCHAR));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_COORD_W, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_COORD_E, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_PH, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_TEMPERATURA, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_CONDUCTIVIDAD, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_TURBIEDAD, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_OXIGENO, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_CLOROFILA, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_FICOCIANINA, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_OBSERVACION, OracleTypes.VARCHAR));
//			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_CODIGO_HEADER, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_IDDETALLE, OracleTypes.NUMBER));	
//			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_ESTADO, OracleTypes.VARCHAR));	
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.A_PAR_USUARIO_MODIFICACION, OracleTypes.VARCHAR));		
			
			lstParamsOutput = new ArrayList<SqlOutParameter>();
			
			this.execSp = new ExecuteProcedure(template.getDataSource(), ConstantsLaboratorio.PKC_ALC_FORM242 + ConstantsLaboratorio.P_SEPARADOR + ConstantsLaboratorio.SP_UPDATE_DETALLE, lstParamsInput, lstParamsOutput);
			inputs = new HashMap<String, Object>();
			inputs.put(ConstantsLaboratorio.P_LOCALIDAD_MUESTREO, formularioDetalle242.getLocalMuestreo());
			inputs.put(ConstantsLaboratorio.P_ESTACION_MUESTREO, formularioDetalle242.getEstacionMuestreo());
			inputs.put(ConstantsLaboratorio.P_ALTURA, formularioDetalle242.getAltura());
			inputs.put(ConstantsLaboratorio.P_HORA, formularioDetalle242.getHora());
			inputs.put(ConstantsLaboratorio.P_COORD_W, formularioDetalle242.getCoordenadaW());
			inputs.put(ConstantsLaboratorio.P_COORD_E, formularioDetalle242.getCoordenadaE());
			inputs.put(ConstantsLaboratorio.P_PH, formularioDetalle242.getPh());
			inputs.put(ConstantsLaboratorio.P_TEMPERATURA, formularioDetalle242.getTemperatura());
			inputs.put(ConstantsLaboratorio.P_CONDUCTIVIDAD, formularioDetalle242.getConductividad());
			inputs.put(ConstantsLaboratorio.P_TURBIEDAD, formularioDetalle242.getTurbiedad());
			inputs.put(ConstantsLaboratorio.P_OXIGENO, formularioDetalle242.getOxigeno());
			inputs.put(ConstantsLaboratorio.P_CLOROFILA, formularioDetalle242.getClorofila());
			inputs.put(ConstantsLaboratorio.P_FICOCIANINA, formularioDetalle242.getFicocianina());
			inputs.put(ConstantsLaboratorio.P_OBSERVACION, formularioDetalle242.getObservaciones());
//			inputs.put(ConstantsLaboratorio.P_CODIGO_HEADER, formularioDetalle242.getCodigoHeader());
			inputs.put(ConstantsLaboratorio.P_IDDETALLE, formularioDetalle242.getIdDetalle());
//			inputs.put(ConstantsLaboratorio.P_ESTADO, formularioDetalle242.getEstado());
			inputs.put(ConstantsLaboratorio.A_PAR_USUARIO_MODIFICACION,formularioDetalle242.getUsuarioModificacion());		
			
			this.execSp.executeSp(inputs);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public void updateFormularioHeader(FormularioHeader242 formularioHeader242) {
		List<SqlParameter> lstParamsInput = null;
		List<SqlOutParameter> lstParamsOutput = null;

		Map<String, Object> inputs = null;
		try {
			lstParamsInput = new ArrayList<SqlParameter>();
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_ID_HEADER, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_FECHA_MUESTREO, OracleTypes.VARCHAR));	
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_FECHA_RECEPCION, OracleTypes.VARCHAR));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_PERSONA_MUESTREA, OracleTypes.VARCHAR));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_PERSONA_RECEPCION, OracleTypes.VARCHAR));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_OBSERVACION, OracleTypes.VARCHAR));
		
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_USUARIO_MODIF, OracleTypes.VARCHAR));	
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_NOMBRE_PROG, OracleTypes.VARCHAR));
			
			lstParamsOutput = new ArrayList<SqlOutParameter>();
			
			this.execSp = new ExecuteProcedure(template.getDataSource(), ConstantsLaboratorio.PKC_ALC_FORM242 + ConstantsLaboratorio.P_SEPARADOR + ConstantsLaboratorio.SP_UPDATE_HEADER242, lstParamsInput, lstParamsOutput);
			inputs = new HashMap<String, Object>();
			inputs.put(ConstantsLaboratorio.P_ID_HEADER, formularioHeader242.getIdHeader());
			inputs.put(ConstantsLaboratorio.P_FECHA_MUESTREO, formularioHeader242.getStrFechaMuestreo());
			inputs.put(ConstantsLaboratorio.P_FECHA_RECEPCION, formularioHeader242.getStrFechaRecepcion());
			inputs.put(ConstantsLaboratorio.P_PERSONA_MUESTREA, formularioHeader242.getPersonaMuestrea());
			inputs.put(ConstantsLaboratorio.P_PERSONA_RECEPCION, formularioHeader242.getPersonaRecepcion());
			inputs.put(ConstantsLaboratorio.P_OBSERVACION, formularioHeader242.getObservacion());
	
			inputs.put(ConstantsLaboratorio.P_USUARIO_MODIF,formularioHeader242.getUsuarioModificacion());
			inputs.put(ConstantsLaboratorio.P_NOMBRE_PROG,formularioHeader242.getPrograma());
			
			this.execSp.executeSp(inputs);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public void inactivarFormularioHeader(FormularioHeader242 formularioHeader242) {
		List<SqlParameter> lstParamsInput = null;
		List<SqlOutParameter> lstParamsOutput = null;

		Map<String, Object> inputs = null;
		try {
			lstParamsInput = new ArrayList<SqlParameter>();
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_ID_HEADER, OracleTypes.NUMBER));	
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_ESTADO, OracleTypes.NUMBER));	
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.A_PAR_USUARIO_MODIFICACION, OracleTypes.VARCHAR));		
			
			lstParamsOutput = new ArrayList<SqlOutParameter>();
			
			this.execSp = new ExecuteProcedure(template.getDataSource(), ConstantsLaboratorio.PKC_ALC_FORM242 + ConstantsLaboratorio.P_SEPARADOR + ConstantsLaboratorio.SP_INACTIVA_HEADER, lstParamsInput, lstParamsOutput);
			inputs = new HashMap<String, Object>();
			inputs.put(ConstantsLaboratorio.P_ID_HEADER, formularioHeader242.getIdHeader());
			inputs.put(ConstantsLaboratorio.P_ESTADO, formularioHeader242.getEstado());
			inputs.put(ConstantsLaboratorio.A_PAR_USUARIO_MODIFICACION,formularioHeader242.getUsuarioModificacion());		
			
			this.execSp.executeSp(inputs);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	
}
