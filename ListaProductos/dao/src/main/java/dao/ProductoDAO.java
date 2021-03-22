package dao;

import java.util.ArrayList;
import java.util.Collection;

import domain.Producto;
import exceptions.DuplicatedExceptions;
import exceptions.GenericException;
import exceptions.NonExistsExceptions;

public interface ProductoDAO {

	//crud
	public Producto insert(Producto producto) throws DuplicatedExceptions, GenericException;
	
	public ArrayList<Producto> findAll() throws GenericException;

	public Producto update(Producto producto) throws DuplicatedExceptions, GenericException;

	public Producto getByCodigo(String codigo) throws NonExistsExceptions, GenericException;

	public Producto delete(String codigo) throws NonExistsExceptions, GenericException;

	public Collection<Producto> buscar(String claveBusqueda) throws GenericException;
}