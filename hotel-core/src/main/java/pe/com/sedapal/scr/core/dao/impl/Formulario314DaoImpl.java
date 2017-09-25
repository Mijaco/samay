package pe.com.sedapal.scr.core.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
import pe.com.sedapal.scr.core.beans.Formulario314;
import pe.com.sedapal.scr.core.beans.FormularioDetalle222;
import pe.com.sedapal.scr.core.beans.FormularioDetalle242;
import pe.com.sedapal.scr.core.beans.FormularioHeader222;
import pe.com.sedapal.scr.core.beans.PhmetroDigitalBean;
import pe.com.sedapal.scr.core.common.Constants;
import pe.com.sedapal.scr.core.common.ConstantsLaboratorio;
import pe.com.sedapal.scr.core.dao.IFormulario222Dao;
import pe.com.sedapal.scr.core.dao.IFormulario314Dao;
import pe.com.sedapal.scr.core.util.ExecuteProcedure;
import pe.com.sedapal.scr.core.util.Utils;

@Repository
public class Formulario314DaoImpl implements IFormulario314Dao {
	
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
	public Result getListadoFormulario314(Formulario314 formulario314, Paginacion paginacion) {
		
		List lstRetorno = null;

		SimpleJdbcCall caller = new SimpleJdbcCall(template.getDataSource());
		caller.withCatalogName(ConstantsLaboratorio.PKC_ALC_FORM314).withProcedureName(ConstantsLaboratorio.SP_LISTADO_FORM314)
				.declareParameters(
						// parametros de búsquedaConstantsLaboratorio
						new SqlParameter(ConstantsLaboratorio.P_PERIODO, Types.VARCHAR),
						new SqlParameter(ConstantsLaboratorio.P_TIPO_ENSAYO, Types.INTEGER),
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
										record.add(rs.getString(1)); // FECHA
										record.add(rs.getString(2)); // ANALISTA
										record.add(rs.getString(3)); // CODMUESTRA	
										record.add(rs.getDouble(4)); // RESULTAD
										record.add(rs.getDouble(5)); // RESULT
										record.add(rs.getDouble(6)); // RSD
										record.add(rs.getString(7)); // TIPO ENSAYO
										record.add(rs.getString(8)); // OBS
										record.add(rs.getString(9)); // IDTABLA
								
										return record;
									}
								}))
				.withSchemaName(environment.getRequiredProperty(ConstantsCommon.ORACLE_PROCEDURES_SCHEMA));

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue(ConstantsLaboratorio.P_PERIODO, formulario314.getStrFecha());
		params.addValue(ConstantsLaboratorio.P_TIPO_ENSAYO, formulario314.getTipoEnsayo());
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
	public void grabarFormulario314(Formulario314 formulario314) {
		List<SqlParameter> lstParamsInput = null;
		List<SqlOutParameter> lstParamsOutput = null;

		Map<String, Object> inputs = null;
		try {
			lstParamsInput = new ArrayList<SqlParameter>();
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_FECHA, OracleTypes.VARCHAR));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_TIPO_ENSAYO, OracleTypes.NUMBER));	
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_ANALISTA, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_CODMUESTRA, OracleTypes.VARCHAR));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_RESULTADO1, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_RESULTADO2, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_RDS, OracleTypes.NUMBER));	
		
			lstParamsInput.add(new SqlParameter(Constants.A_PAR_USUARIO_CREACION, OracleTypes.VARCHAR));		
			lstParamsInput.add(new SqlParameter(Constants.A_PAR_USUARIO_MODIFICACION, OracleTypes.VARCHAR));		
			lstParamsInput.add(new SqlParameter(Constants.A_PAR_NOMBRE_PROGRAMA, OracleTypes.VARCHAR));	
	
			lstParamsOutput = new ArrayList<SqlOutParameter>();
			
	    
			this.execSp = new ExecuteProcedure(template.getDataSource(), 
					CoreUtils.concatenar(ConstantsLaboratorio.PKC_ALC_FORM314,ConstantsCommon.P_SEPARADOR,ConstantsLaboratorio.SP_INSERT_FORM314), lstParamsInput, lstParamsOutput);
			inputs = new HashMap<String, Object>();
		    inputs.put(ConstantsLaboratorio.P_FECHA, formulario314.getStrFecha());
			inputs.put(ConstantsLaboratorio.P_TIPO_ENSAYO, formulario314.getTipoEnsayo());
			inputs.put(ConstantsLaboratorio.P_ANALISTA, formulario314.getTipoAnalista());
			inputs.put(ConstantsLaboratorio.P_CODMUESTRA, formulario314.getCodMuestra());
			inputs.put(ConstantsLaboratorio.P_RESULTADO1, formulario314.getResultado1());
			inputs.put(ConstantsLaboratorio.P_RESULTADO2, formulario314.getResultado2());
			inputs.put(ConstantsLaboratorio.P_RDS, formulario314.getRsd());

			inputs.put(Constants.A_PAR_USUARIO_CREACION, formulario314.getUsuarioCreacion());		
			inputs.put(Constants.A_PAR_USUARIO_MODIFICACION,formulario314.getUsuarioModificacion());		
			inputs.put(Constants.A_PAR_NOMBRE_PROGRAMA, formulario314.getPrograma());	
			
			this.execSp.executeSp(inputs);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	

	@Override
	public Formulario314 getFormulario314(Integer id) {
		ArrayList ret = null;
		Formulario314 result = null;
		
		SimpleJdbcCall caller = new SimpleJdbcCall(template.getDataSource());
		caller.withCatalogName(ConstantsLaboratorio.PKC_ALC_FORM314).withProcedureName(ConstantsLaboratorio.PRC_GET_FORM314)
		.declareParameters(new SqlParameter(ConstantsLaboratorio.P_IDFORM314, Types.INTEGER), new SqlOutParameter(
				Constants.PAR_OUT_CURSOR, OracleTypes.CURSOR, new RowMapper<Formulario314>() {

					@Override
					public Formulario314 mapRow(ResultSet rs, int rowNum) throws SQLException {
						Formulario314 record = new Formulario314();
						
						record.setStrFecha(rs.getString(1));
						record.setTipoEnsayo(rs.getInt(2));
						record.setTipoAnalista(rs.getInt(3));
						record.setCodMuestra(rs.getString(4));
						record.setResultado1(rs.getDouble(5));
						record.setResultado2(rs.getDouble(6));
						record.setIdformulario314(rs.getInt(7));
						
						return record;
					}

				}))
		.withSchemaName(environment.getRequiredProperty(ConstantsLaboratorio.ORACLE_PROCEDURES_SCHEMA));

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue(ConstantsLaboratorio.P_IDFORM314, id);

		Map<String, Object> results = caller.execute(params);
		ret = (ArrayList) results.get(Constants.PAR_OUT_CURSOR);

		result = (Formulario314) ret.get(0);
		
		return result;
	}

	@Override
	public void updateFormulario314(Formulario314 formulario314) {
		List<SqlParameter> lstParamsInput = null;
		List<SqlOutParameter> lstParamsOutput = null;

		Map<String, Object> inputs = null;
		try {
			lstParamsInput = new ArrayList<SqlParameter>();
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_FECHA, OracleTypes.VARCHAR));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_TIPO_ENSAYO, OracleTypes.NUMBER));	
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_ANALISTA, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_CODMUESTRA, OracleTypes.VARCHAR));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_RESULTADO1, OracleTypes.NUMBER));
		    lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_RESULTADO2, OracleTypes.NUMBER));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.P_IDFORM314, OracleTypes.NUMBER));
			
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.A_PAR_USUARIO_MODIFICACION, OracleTypes.VARCHAR));
			lstParamsInput.add(new SqlParameter(ConstantsLaboratorio.A_PAR_NOMBRE_PROGRAMA, OracleTypes.VARCHAR));
			
			lstParamsOutput = new ArrayList<SqlOutParameter>();
			
			this.execSp = new ExecuteProcedure(template.getDataSource(), ConstantsLaboratorio.PKC_ALC_FORM314 + ConstantsLaboratorio.P_SEPARADOR + ConstantsLaboratorio.SP_UPDATE_FORM314, lstParamsInput, lstParamsOutput);
			inputs = new HashMap<String, Object>();
			inputs.put(ConstantsLaboratorio.P_FECHA, formulario314.getStrFecha());
			inputs.put(ConstantsLaboratorio.P_TIPO_ENSAYO, formulario314.getTipoEnsayo());
			inputs.put(ConstantsLaboratorio.P_ANALISTA, formulario314.getTipoAnalista());
			inputs.put(ConstantsLaboratorio.P_CODMUESTRA, formulario314.getCodMuestra());	
			inputs.put(ConstantsLaboratorio.P_RESULTADO1, formulario314.getResultado1());
			inputs.put(ConstantsLaboratorio.P_RESULTADO2, formulario314.getResultado2());
			inputs.put(ConstantsLaboratorio.P_IDFORM314, formulario314.getIdformulario314());
			
			inputs.put(ConstantsLaboratorio.A_PAR_USUARIO_MODIFICACION,formulario314.getUsuarioModificacion());	
			inputs.put(ConstantsLaboratorio.A_PAR_NOMBRE_PROGRAMA, formulario314.getPrograma());
			
			this.execSp.executeSp(inputs);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public void inactivarForm314(Formulario314 formulario314) {
		
		List<SqlParameter> paramsInput = null;
		List<SqlOutParameter> paramsOutput = null;
		Map<String, Object> inputs = null;
		
		paramsInput = new ArrayList<SqlParameter>();
		
		paramsInput.add(new SqlParameter(ConstantsLaboratorio.P_IDFORM314, OracleTypes.NUMBER));
		paramsInput.add(new SqlParameter(ConstantsLaboratorio.P_STATUS, OracleTypes.NUMBER));

		paramsOutput = new ArrayList<SqlOutParameter>();

		this.execSp = new ExecuteProcedure(template.getDataSource(), 
				CoreUtils.concatenar(ConstantsLaboratorio.PKC_ALC_FORM314,ConstantsLaboratorio.P_SEPARADOR,ConstantsLaboratorio.PRC_INACTIVA_FORM314), paramsInput, paramsOutput);
		inputs = new HashMap<String, Object>();
		
		inputs.put(ConstantsLaboratorio.P_IDFORM314, formulario314.getIdformulario314());
		inputs.put(ConstantsLaboratorio.P_STATUS, formulario314.getStatus());
		
		this.execSp.executeSp(inputs);
		
	}
	
	
}
