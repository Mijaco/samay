package pe.com.sedapal.scr.core.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
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
import pe.com.sedapal.common.core.utils.ConstantsCommon;
import pe.com.sedapal.scr.core.beans.DetalleCatalogoBean;
import pe.com.sedapal.scr.core.beans.SelectItemBean;
import pe.com.sedapal.scr.core.common.Constants;
import pe.com.sedapal.scr.core.common.ConstantsLaboratorio;
import pe.com.sedapal.scr.core.dao.ICatalogoDao;

@Repository
public class CatalogoDaoImpl implements ICatalogoDao {

	@Autowired
	private Environment environment;
	
	@Autowired
	private JdbcTemplate template;
	
	private static final Logger LOG = LoggerFactory.getLogger(CatalogoDaoImpl.class);
	
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleCatalogoBean> obtenerDetalleCatalogo(String strAbreviatura) throws Exception {
		List<DetalleCatalogoBean> lstRetorno = null; 
    	SimpleJdbcCall caller = new SimpleJdbcCall(template.getDataSource());
    	try {
    		caller.withCatalogName(Constants.PACKAGE_CATALOGO).withProcedureName(Constants.SP_GET_DETAIL).declareParameters(	
    				new SqlParameter(Constants.PAR_CAT_ABREVIATURA, Types.VARCHAR),
					new SqlParameter(Constants.PAR_CAT_ESTADO, Types.INTEGER),
						new SqlOutParameter(ConstantsCommon.PAR_OUT_CURSOR, OracleTypes.CURSOR, new RowMapper<DetalleCatalogoBean>() {
							@Override
							public DetalleCatalogoBean mapRow(ResultSet rs, int rowNum) throws SQLException {
								DetalleCatalogoBean record = new DetalleCatalogoBean();
								record.setStrAbreviatura(rs.getString(1));
								record.setStrValor1(rs.getString(2));
								record.setStrValor2(rs.getString(3));
								return record;
							}
						} )						
    			).withSchemaName(environment.getRequiredProperty(ConstantsCommon.ORACLE_PROCEDURES_SCHEMA));
    	
			MapSqlParameterSource params = new MapSqlParameterSource();		
			params.addValue(Constants.PAR_CAT_ABREVIATURA, strAbreviatura);
			params.addValue(Constants.PAR_CAT_ESTADO, Constants.ATTRIBUTE_POSITIVE);
			
			Map<String,Object>  results = caller.execute(params);
			lstRetorno =  (List<DetalleCatalogoBean>) results.get(ConstantsCommon.PAR_OUT_CURSOR);   
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
        return lstRetorno;	
	}
	
	
	//catalogo para laboratorio

	@SuppressWarnings("unchecked")
	@Override
	public List<SelectItemBean> obtenerCatalogo(Integer idTabla) throws Exception {
		List<SelectItemBean> lstRetorno = null; 
		try {
    	SimpleJdbcCall caller = new SimpleJdbcCall(template.getDataSource());
    	caller.withCatalogName(ConstantsLaboratorio.PACKAGE_CATALOGO).withProcedureName(ConstantsLaboratorio.PRC_BUSCA_CATALOGO).declareParameters(
						new SqlOutParameter(ConstantsCommon.PAR_OUT_CURSOR, OracleTypes.CURSOR, new RowMapper<SelectItemBean>() {
							@Override
							public SelectItemBean mapRow(ResultSet rs, int rowNum) throws SQLException {
								SelectItemBean record = new SelectItemBean();
								record.setId(String.valueOf(rs.getLong(1)));
								record.setValue(rs.getString(2));
								record.setLabel(rs.getString(3));
								record.setDefecto(rs.getString(4));//descripcion fijo para los combos
								return record;
							}
						} )
    			).withSchemaName(environment.getRequiredProperty(ConstantsCommon.ORACLE_PROCEDURES_SCHEMA));
    	
		MapSqlParameterSource params = new MapSqlParameterSource();	
		params.addValue(ConstantsLaboratorio.PAR_COD_TABLE, idTabla);
		
		Map<String,Object>  results = caller.execute(params);
		lstRetorno =  (List<SelectItemBean>) results.get(ConstantsCommon.PAR_OUT_CURSOR);
		} catch (Exception e) {
			LOG.error("",e);
		}
        return lstRetorno;	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SelectItemBean> obtenerCatalogoTodosNinguno(Integer idTabla, Integer flag) throws Exception {
		List<SelectItemBean> lstRetornoTmp = new ArrayList<>(); 
		List<SelectItemBean> lstRetorno = new ArrayList<>(); 
		try {
    	SimpleJdbcCall caller = new SimpleJdbcCall(template.getDataSource());
    	caller.withCatalogName(ConstantsLaboratorio.PACKAGE_CATALOGO).withProcedureName(ConstantsLaboratorio.PRC_BUSCA_CATALOGO).declareParameters(
						new SqlOutParameter(ConstantsCommon.PAR_OUT_CURSOR, OracleTypes.CURSOR, new RowMapper<SelectItemBean>() {
							@Override
							public SelectItemBean mapRow(ResultSet rs, int rowNum) throws SQLException {
								SelectItemBean record = new SelectItemBean();
								record.setValue(String.valueOf(rs.getLong(2)));
								record.setLabel(String.valueOf(rs.getString(3)));
								return record;
							}
						} )
    			).withSchemaName(environment.getRequiredProperty(ConstantsCommon.ORACLE_PROCEDURES_SCHEMA));
    	
		MapSqlParameterSource params = new MapSqlParameterSource();	
		params.addValue(ConstantsLaboratorio.PAR_COD_TABLE, idTabla);
		
		Map<String,Object>  results = caller.execute(params);
		
				
		lstRetornoTmp =  (List<SelectItemBean>) results.get(ConstantsCommon.PAR_OUT_CURSOR);
				
		if(flag==1){
			SelectItemBean d = new SelectItemBean();
			d.setLabel("TODOS");
			d.setValue("0");
			lstRetorno.add(d);
			
		}else if(flag==2){
			SelectItemBean d = new SelectItemBean();
			d.setLabel("NINGUNO");
			d.setValue("");
			lstRetorno.add(d);
		}else if(flag==3){
			SelectItemBean d = new SelectItemBean();
			d.setLabel("SELECCIONE");
			d.setValue("");
			lstRetorno.add(d);
		}
		
		for (SelectItemBean selectItemBean : lstRetornoTmp) {
			lstRetorno.add(selectItemBean);
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
        return lstRetorno;	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SelectItemBean> obtenerCatalogoSeleccionar(Integer idTabla, Integer flag) throws Exception {
		List<SelectItemBean> lstRetornoTmp = new ArrayList<>(); 
		List<SelectItemBean> lstRetorno = new ArrayList<>(); 
		try {
    	SimpleJdbcCall caller = new SimpleJdbcCall(template.getDataSource());
    	caller.withCatalogName(ConstantsLaboratorio.PACKAGE_CATALOGO).withProcedureName(ConstantsLaboratorio.PRC_BUSCA_CATALOGO).declareParameters(
						new SqlOutParameter(ConstantsCommon.PAR_OUT_CURSOR, OracleTypes.CURSOR, new RowMapper<SelectItemBean>() {
							@Override
							public SelectItemBean mapRow(ResultSet rs, int rowNum) throws SQLException {
								SelectItemBean record = new SelectItemBean();
								record.setValue(String.valueOf(rs.getLong(2)));
								record.setLabel(String.valueOf(rs.getString(3)));
								return record;
							}
						} )
    			).withSchemaName(environment.getRequiredProperty(ConstantsCommon.ORACLE_PROCEDURES_SCHEMA));
    	
		MapSqlParameterSource params = new MapSqlParameterSource();	
		params.addValue(ConstantsLaboratorio.PAR_COD_TABLE, idTabla);
		
		Map<String,Object>  results = caller.execute(params);
		
				
		lstRetornoTmp =  (List<SelectItemBean>) results.get(ConstantsCommon.PAR_OUT_CURSOR);
				
		if(flag==1){
			SelectItemBean d = new SelectItemBean();
			d.setLabel("TODOS");
			d.setValue("0");
			lstRetorno.add(d);
			
		}else if(flag==2){
			SelectItemBean d = new SelectItemBean();
			d.setLabel("Seleccionar");
			d.setValue("0");
			lstRetorno.add(d);
		}
		
		for (SelectItemBean selectItemBean : lstRetornoTmp) {
			lstRetorno.add(selectItemBean);
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
        return lstRetorno;	
	}



}
