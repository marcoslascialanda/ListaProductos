package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import exceptions.GenericException;



public class AdministradorDeConexiones {

	public static Connection obtenerConexion() throws GenericException {
		
		//driver
		String driver = "com.mysql.cj.jdbc.Driver";
		
		String dbConnectionString = "jdbc:mysql://127.0.1:3306/marcos?serverTimezone=UTC";
		
		//username
		String username = "marcos";
		
		//password
		String password = "root";
		
		//establer la conexion!
		
		try {
			Class.forName(driver).newInstance();
			
			//crear la conexion
			Connection connection = DriverManager.getConnection(dbConnectionString, username, password);
			
			return connection;
		}catch (Throwable e) {
			throw new GenericException("No se ha podido obtener conexion: "+ dbConnectionString + " username:" + username + ", passqword:"+ password, e);
		}
	}
}