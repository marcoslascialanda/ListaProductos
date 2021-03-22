package parcer;

public class FileCSV extends FileBase implements Parseable<CSV> {

	public FileCSV(String nombreArchivo) {
		super(nombreArchivo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CSV parsear() {
		
		CSV file = new CSV(delimitador);
		//logica!
		return file;
	}

}
