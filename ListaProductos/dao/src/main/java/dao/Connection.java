package dao;

import exceptions.MISQLException;

public class Connection {

	public void abrir() throws MISQLException{
		
	}

	public void ejecutarSql(String sql) throws MISQLException{
		// throw new MISQLException("Sentencia mal escrita!!" + sql);		
	}

	public void cerrar() throws MISQLException{
		throw new MISQLException("error cerrando conexion");		
	}

}
