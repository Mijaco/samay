package pe.com.sedapal.scr.core.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
import pe.com.sedapal.scr.core.beans.Producto;
import pe.com.sedapal.scr.core.beans.SelectItemBean;
import pe.com.sedapal.scr.core.common.ConstantsLaboratorio;
import pe.com.sedapal.scr.core.dao.IActividadXAreaDao;
import pe.com.sedapal.scr.core.dao.IProductoDao;
import pe.com.sedapal.scr.core.util.ExecuteProcedure;
@Repository
public class ProductoDaoImpl implements IProductoDao{

		@Autowired
		private Environment environment;
		
		private JdbcTemplate template;
		private ExecuteProcedure execSp;
		
		private static final Logger LOG = LoggerFactory.getLogger(ActividadXAreaDaoImpl.class);
		
		@Autowired
		public void setTemplate(JdbcTemplate template) {
			this.template = template;
		}

		@Override
		public List<Producto> listarProductosFrecuentes() {
			
			List<Producto> lstRetorno = null; 
			
	    	SimpleJdbcCall caller = new SimpleJdbcCall(template.getDataSource());
	    	caller.withCatalogName(ConstantsLaboratorio.PCK_PRODUCTOS).withProcedureName(ConstantsLaboratorio.PRC_PRODUCTOS_FREQUENTES).declareParameters(
							new SqlOutParameter(ConstantsCommon.PAR_OUT_CURSOR, OracleTypes.CURSOR, new RowMapper<Producto>() {
								@Override
								public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
									Producto record = new Producto();
									record.setCodigo(rs.getString(1));
									record.setNombre(rs.getString(2));
									record.setPrecio(rs.getDouble(3));
									record.setMedida(rs.getString(4));
									record.setVolumen(rs.getDouble(5));
									return record;
								}
								
//								ODIGO,NOMBRE,PRECIO,MEDIDA,VOLUMEN,DESCRI
							} )
	    			).withSchemaName(environment.getRequiredProperty(ConstantsCommon.ORACLE_PROCEDURES_SCHEMA));
	    	
//			MapSqlParameterSource params = new MapSqlParameterSource();	
			
			Map<String,Object>  results = caller.execute();
			lstRetorno =  (List<Producto>) results.get(ConstantsCommon.PAR_OUT_CURSOR);

	        return lstRetorno;	
		}

		@Override
		public List<Producto> fitrarProductos(String nombre, String descripcion, String volumen) {
			List<Producto> lstRetorno = null; 
			
	    	SimpleJdbcCall caller = new SimpleJdbcCall(template.getDataSource());
	    	caller.withCatalogName(ConstantsLaboratorio.PCK_PRODUCTOS).withProcedureName(ConstantsLaboratorio.PRC_PRODUCTOS_FILTRADOS).declareParameters(
	    			new SqlParameter(ConstantsLaboratorio.PAR_NOMBRE, Types.VARCHAR),
					new SqlParameter(ConstantsLaboratorio.PAR_DESCRI, Types.VARCHAR),
					new SqlParameter(ConstantsLaboratorio.PAR_VOLUME, Types.VARCHAR),
							new SqlOutParameter(ConstantsCommon.PAR_OUT_CURSOR, OracleTypes.CURSOR, new RowMapper<Producto>() {
								@Override
								public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
									LOG.info(">>> BUSCANDO ");
									Producto record = new Producto();
									record.setCodigo(rs.getString(1));
									record.setNombre(rs.getString(2));
									record.setPrecio(rs.getDouble(3));
									record.setMedida(rs.getString(4));
									record.setVolumen(rs.getDouble(5));
									return record;
								}
								
//								ODIGO,NOMBRE,PRECIO,MEDIDA,VOLUMEN,DESCRI
							} )
	    			).withSchemaName(environment.getRequiredProperty(ConstantsCommon.ORACLE_PROCEDURES_SCHEMA));
	    	MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue(ConstantsLaboratorio.PAR_NOMBRE, nombre);
			params.addValue(ConstantsLaboratorio.PAR_DESCRI, descripcion);
			params.addValue(ConstantsLaboratorio.PAR_VOLUME, "1");

			Map<String,Object>  results = caller.execute(params);
			lstRetorno =  (List<Producto>) results.get(ConstantsCommon.PAR_OUT_CURSOR);

	        return lstRetorno;	
		
		}
}
