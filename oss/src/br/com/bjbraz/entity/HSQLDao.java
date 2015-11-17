package br.com.bjbraz.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * 
 * @author p-abraz
 *
 */
public class HSQLDao {
	
	/**
	 * 
	 */
	protected static final Logger LOGGER = Logger.getLogger(HSQLDao.class);
	
	/**
	 * 
	 */
	public Connection getConnection(){
		try {
			Class.forName("org.hsqldb.jdbcDriver" );
			Connection c = DriverManager.getConnection("jdbc:hsqldb:mem:demandas", "SA", "");
			criarTabela();
			return c;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 */
	public void criarTabela(){
		try {
			PreparedStatement stmt = getConnection().prepareStatement("CREATE TABLE DEMANDA(ID IDENTITY, DESCRICAO(500) VARCHAR, TITULO VARCHAR(500), ENDERECO VARCHAR(500), LATITUDE VARCHAR(500), LONGITUDE VARCHAR(500))");
			stmt.execute();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Demanda> listarRotas() {
		List<Demanda> demandas = new ArrayList<Demanda>();
		
		try {
			PreparedStatement stmt = getConnection().prepareStatement("select ID, DESCRICAO, TITULO, ENDERECO, LATITUDE, LONGITUDE from DEMANDA");
			ResultSet rs           = stmt.executeQuery();
			Demanda demanda        = null;
			
			while(rs.next()){
				demanda = new Demanda();
				demanda.setDescricao(rs.getString("DESCRICAO"));
				demanda.setEndereco(rs.getString("ENDERECO"));
				demanda.setId(rs.getInt("ID"));
				demanda.setLatitude(rs.getString("LATITUDE"));
				demanda.setLongitude(rs.getString("LONGITUDE"));
				demanda.setTitulo(rs.getString("TITULO"));
				demandas.add(demanda);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return demandas;
	}

	public void adicionaDemanda(Demanda d) {
		PreparedStatement stmt;
		try {
			stmt = getConnection().prepareStatement("INSERT INTO DEMANDA(DESCRICAO, TITULO, ENDERECO, LATITUDE, LONGITUDE) "
					+ "VALUES (?, ?, ?, ?, ?)");
			stmt.setString(1, d.getDescricao());
			stmt.setString(2, d.getTitulo());
			stmt.setString(3, d.getEndereco());
			stmt.setString(4, d.getLatitude());
			stmt.setString(4, d.getLongitude());
			stmt.execute();
			
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		
	}
	 

}
