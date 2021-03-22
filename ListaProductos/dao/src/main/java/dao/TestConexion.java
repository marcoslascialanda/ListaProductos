package dao;

import java.util.ArrayList;

import domain.Producto;
import exceptions.GenericException;

public class TestConexion {

	public static void main(String[] args) throws GenericException{

		ProductoDAO pdao = new ProductoDAOImpl();

		ArrayList<Producto> productos = pdao.findAll();
		
		for(Producto p : productos) {
			System.out.println(p.toString());
		}
	}

}
