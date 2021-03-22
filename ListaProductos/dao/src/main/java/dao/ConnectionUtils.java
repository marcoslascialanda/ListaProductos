package dao;

public final class ConnectionUtils {

	private String db;
	private String usuario;
	private String password;
	
	public ConnectionUtils(String db, String usuario, String password) {
		this.setDb(db);
		this.setUsuario(usuario);
		this.setPassword(password);
	}
	
	public Connection getConnection() {
		return new Connection();
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
