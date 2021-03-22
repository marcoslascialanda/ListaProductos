package parcer;

public class CSV extends FileBase implements Parseable<CSV>{



	public CSV(String nombreArchivo) {
		super(nombreArchivo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CSV parsear() {
		
		CSV file = new CSV(delimitador);
		
		return file;
	}
}
