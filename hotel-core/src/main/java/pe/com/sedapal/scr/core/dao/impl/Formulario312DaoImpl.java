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
import pe.com.sedapal.scr.core.beans.Formulario312;
import pe.com.sedapal.scr.core.beans.PhmetroDigitalBean;
import pe.com.sedapal.scr.core.beans.ReporteForm312Bean;
import pe.com.sedapal.scr.core.common.Constants;
import pe.com.sedapal.scr.core.common.ConstantsLaboratorio;
import pe.com.sedapal.scr.core.dao.IFormulario312Dao;
import pe.com.sedapal.scr.core.util.ExecuteProcedure;
import pe.com.sedapal.scr.core.util.Utils;

@Repository
public class Formulario312DaoImpl implements IFormulario312Dao {
	
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
	public List<Formulario312> generarReporte(String periodo) throws Exception {
		List<Formulario312> lstRetorno = null; 
		
		SimpleJdbcCall caller = new SimpleJdbcCall(template.getDataSource());
		caller.withCatalogName(ConstantsLaboratorio.PKC_ALC_FORM314).withProcedureName(ConstantsLaboratorio.PRC_DATA_GRAFICO).declareParameters(    					
					new SqlParameter(ConstantsLaboratorio.P_PERIODO, Types.VARCHAR),						
					new SqlOutParameter(ConstantsCommon.PAR_OUT_CURSOR, OracleTypes.CURSOR, new RowMapper<Formulario312>() {

						@Override
						public Formulario312 mapRow(ResultSet rs, int rowNum) throws SQLException {
							Formulario312 record = new Formulario312();								
							record.setPeriodo(rs.getString(1)); // PERIODO
							record.setStrTipoEnsayo(rs.getString(2)); // tipo_ensayo nombre
							record.setDia(rs.getString(3)); // V_DIA
							record.setStrFecha(rs.getString(4));
							record.setResultado1(rs.getInt(5));
							record.setResultado2(rs.getInt(6));
							record.setRsd(rs.getDouble(7));
							record.setObs(rs.getInt(8));
							record.setTipoEnsayo(rs.getInt(9)); //ID_METODO_ENSAYO
	
							return record;
						}
					} )						
			).withSchemaName(environment.getRequiredProperty(ConstantsCommon.ORACLE_PROCEDURES_SCHEMA));
	
	MapSqlParameterSource params = new MapSqlParameterSource();		
	params.addValue(ConstantsLaboratorio.P_PERIODO, periodo);		
	
	Map<String,Object>  results = caller.execute(params);		
	lstRetorno =  (List) results.get(ConstantsCommon.PAR_OUT_CURSOR);
	
    return lstRetorno;
    
	}


	
}
