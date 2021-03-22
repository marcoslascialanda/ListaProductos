package service;

import java.util.Collection;

import domain.Producto;
import exceptions.ServiceException;


public interface ProductoService {

	public Producto crearProducto(Producto producto) throws ServiceException;
	
	public Collection<Producto> obtenerProductos() throws ServiceException;
	
	public Producto deleteProducto(Long id) throws ServiceException;
	
	public Producto updateProducto(Producto producto) throws ServiceException;
	
	public Producto obtenerProducto(String codigo) throws ServiceException;
	
	public Collection<Producto> buscarProducto(String claveBusqueda) throws ServiceException;
	
	public Producto deleteProducto(String codigo) throws ServiceException;
	
}
