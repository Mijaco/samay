package pe.com.sedapal.scr.core.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import pe.com.sedapal.scr.core.beans.EnsayoCloro;
import pe.com.sedapal.scr.core.beans.EnsayoCloroDetalle;
import pe.com.sedapal.scr.core.common.Constants;
import pe.com.sedapal.scr.core.common.ConstantsLaboratorio;
import pe.com.sedapal.scr.core.dao.IEnsayoCloroDao;
import pe.com.sedapal.scr.core.util.ExecuteProcedure;

@Repository
public class EnsayoCloroDaoImpl  implements IEnsayoCloroDao{

	@Autowired
	private Environment environment;

	private JdbcTemplate template;

	private ExecuteProcedure execSp;

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public Result obtenerDatosEnsayoCloro(EnsayoCloro ensayoCloro, Paginacion paginacion) {
		List lstRetorno = null;

		SimpleJdbcCall caller = new SimpleJdbcCall(template.getDataSource());
		caller.withCatalogName(ConstantsLaboratorio.PCK_ALC_ENSAYOCLORO).withProcedureName(ConstantsLaboratorio.PRC_BUSCA_ENSAYOCLORO)
				.declareParameters(
						// parametros de bUsqueda
						// parametros de arquitectura
						new SqlParameter(ConstantsLaboratorio.PAR_FECMUE, Types.INTEGER),
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
										record.add(rs.getInt(1)); // "D_FECMUE"
										record.add(rs.getString(3)); // "C_HORMUE"
										record.add(rs.getString(2)); // "C_PLAMUE"
										record.add(rs.getInt(4)); // "C_METMUE"
										record.add(rs.getInt(5)); // "C_METMUE"
										record.add(rs.getInt(6)); // "N_PERANA"
										return record;
									}
								}))
				.withSchemaName(environment.getRequiredProperty(ConstantsCommon.ORACLE_PROCEDURES_SCHEMA));

		MapSqlParameterSource params = new MapSqlParameterSource();
		String fechaMuestreo = ensayoCloro.getFechaMuestreo();
		if(fechaMuestreo == null){
			fechaMuestreo = "";
		}
		
		params.addValue(ConstantsLaboratorio.PAR_FECMUE, fechaMuestreo);
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
	public List<EnsayoCloroDetalle> obtenerListEnsayoCloro(Integer fechaMuestreo, String hora) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarEnsayoCloro(EnsayoCloro ensayoCloro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarEnsayoCloroDetalle(EnsayoCloroDetalle ensayoCloroDetalle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inactivarEnsayoCloro(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inactivarCloroDetalle(Integer id) {
		// TODO Auto-generated method stub
		
	}


}
