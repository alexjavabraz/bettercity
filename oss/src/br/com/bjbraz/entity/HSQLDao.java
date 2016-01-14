package br.com.bjbraz.entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import br.com.bjbraz.pojo.Ponto;

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
	public HSQLDao(){
//		criarTabela();
	}
	
	/**
	 * 
	 */
	public Connection getConnection(){
		try {
			
			Connection connection = null;
		    try {
		      InitialContext context = new InitialContext();
		      
		      Context envCtx = (Context) context.lookup("java:comp/env");
		      
		      DataSource dataSource = (DataSource) envCtx.lookup("jdbc/MySQLDB");
		      connection = dataSource.getConnection();
		      
		      
		    } catch (NamingException e) {
		      e.printStackTrace();
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return connection;
			
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 */
	private void criarTabela(){
		try {
			PreparedStatement stmt = getConnection().prepareStatement("CREATE TABLE DEMANDA(ID IDENTITY, DESCRICAO VARCHAR(500), TITULO VARCHAR(500), ENDERECO VARCHAR(500), LATITUDE VARCHAR(500), LONGITUDE VARCHAR(500), TIPO VARCHAR(500))");
			stmt.execute();
			
			stmt = getConnection().prepareStatement("CREATE TABLE CLIENTE(ID IDENTITY, NOME VARCHAR(500), EMAIL VARCHAR(500), DESCRICAO VARCHAR(500), LATITUDE VARCHAR(500), LONGITUDE VARCHAR(500))");
			stmt.execute();
			
			stmt = getConnection().prepareStatement("CREATE TABLE USUARIO(ID IDENTITY, NOME VARCHAR(500), EMAIL VARCHAR(500), ENDERECO VARCHAR(500), SENHA VARCHAR(500), TELEFONE VARCHAR(500), NASCIMENTO VARCHAR(10), SEXO VARCHAR(20), LOCAL VARCHAR(20), RELIGIAO VARCHAR(200), ID_SOCIAL VARCHAR(200))");
			stmt.execute();
			
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Ponto> listarDemandas() {
		List<Ponto> demandas = new ArrayList<Ponto>();
		
		try {
			PreparedStatement stmt = getConnection().prepareStatement("select ID_DEMANDA, DESCRICAO, TITULO, ENDERECO, LATITUDE, LONGITUDE from tb_demanda");
			ResultSet rs           = stmt.executeQuery();
			Demanda demanda        = null;
			
			while(rs.next()){
				demanda = new Demanda();
				demanda.setDescricao(rs.getString("DESCRICAO"));
				demanda.setEndereco(rs.getString("ENDERECO"));
				demanda.setId(rs.getInt("ID_DEMANDA"));
				demanda.setLatitude(rs.getString("LATITUDE"));
				demanda.setLongitude(rs.getString("LONGITUDE"));
				demanda.setTitulo(rs.getString("TITULO"));
				
				Ponto p = demanda.toPonto();
				if(p != null){
					demandas.add(p);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return demandas;
	}
	
	/**
	 * 
	 * @return
	 */
	public Demanda listarDemanda(String id) {
		Demanda ademanda = null;
		
		try {
			PreparedStatement stmt = getConnection().prepareStatement("select ID_DEMANDA, DESCRICAO, TITULO, ENDERECO, LATITUDE, LONGITUDE from TB_DEMANDA where ID_DEMANDA = ? ");
			stmt.setInt(1, Integer.parseInt(id));
			ResultSet rs           = stmt.executeQuery();
			
			while(rs.next()){
				ademanda = new Demanda();
				ademanda.setDescricao(rs.getString("DESCRICAO"));
				ademanda.setEndereco(rs.getString("ENDERECO"));
				ademanda.setId(rs.getInt("ID"));
				ademanda.setLatitude(rs.getString("LATITUDE"));
				ademanda.setLongitude(rs.getString("LONGITUDE"));
				ademanda.setTitulo(rs.getString("TITULO"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ademanda;
	}	

	public Integer adicionaDemanda(Demanda d) {
		Integer retorno = null;
		PreparedStatement stmt;
		Date hoje = new Date(new java.util.Date().getTime());

		try {
			stmt = getConnection().prepareStatement("INSERT INTO tb_demanda(DESCRICAO, TITULO, ENDERECO, LATITUDE, LONGITUDE, DH_INCLUSAO, DH_ALTERACAO, ID_STATUS) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, d.getDescricao());
			stmt.setString(2, d.getTitulo());
			stmt.setString(3, d.getEndereco());
			stmt.setString(4, d.getLatitude());
			stmt.setString(5, d.getLongitude());
			stmt.setDate(6, hoje);
			stmt.setDate(7, hoje);
			stmt.setInt(8, 0);
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			if(rs != null && rs.next()){
				retorno = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		
		return retorno;
	}
	
	public void adicionaCliente(ContatoCliente c) {
		PreparedStatement stmt;
		try {
			stmt = getConnection().prepareStatement("INSERT INTO tb_contato(email_user, txt_descricao) "
					+ "VALUES (?, ?)");
			stmt.setString(1, c.getNome() +  " " + c.getEmail() );
			stmt.setString(2, c.getDescricao());
			stmt.execute();
			
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		
	}

	public void adicionarUsuario(Usuario user) {
		PreparedStatement stmt;
		try {
			stmt = getConnection().prepareStatement("INSERT INTO tb_usuario(nm_usuario, email_usuario, data_nascimento, SEXO, LOCAL, RELIGIAO, ID_SOCIAL) "
					+ "VALUES (?, ?, ?, ?, ?, ?)");
			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getBirthday());
			stmt.setString(4, user.getGender());
			stmt.setString(5, user.getLocale());
			stmt.setString(6, user.getReligion());
			stmt.setString(7, user.getId());
			stmt.execute();
			
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}	
	 

}
