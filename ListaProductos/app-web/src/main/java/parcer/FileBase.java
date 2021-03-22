package parcer;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.Part;

import domain.Producto;

public abstract class FileBase {

	protected String nombreArchivo;
	protected String delimitador;
	
	protected Part filePart;
	protected String type;
	
	/**
	 * @param nombreArchivo
	 * @param delimitador
	 */
	public FileBase(String nombreArchivo, String delimitador) {
		this.nombreArchivo = nombreArchivo;
		this.delimitador = delimitador;
	}
	
	public FileBase(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	public FileBase(String type, Part filePart)  {
		this.type= type;
		this.filePart = filePart; 
				
	}

	public List<String> convert(Collection<Producto> producto) {
		// TODO Auto-generated method stub
		return null;
	}
}
