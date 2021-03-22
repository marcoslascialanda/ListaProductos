package domain;

public class Estudiante implements Examen {

	private String nombre;
	
	private int dni;
	
	private int id;
	
	private int nota;
	
	
	
	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public int getDni() {
		return dni;
	}






	public void setDni(int dni) {
		this.dni = dni;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}

	


	public Estudiante(String nombre, int dni, int id) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.id = id;
	}



	
	
	public int getNota() {
		return nota;
	}




	public void setNota(int nota) {
		this.nota = nota;
	}




	@Override
	public void anotarse() {
		System.out.println("te anotaste amigo");
		
	}




	@Override
	public Nota rendir() {
		Nota a = new Nota(this.nota);
		return a;
	}




	}