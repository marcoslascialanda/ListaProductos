package service;

import java.util.Collection;

import dao.ProductoDAO;
import dao.ProductoDAOImpl;
import domain.Producto;
import exceptions.DuplicatedExceptions;
import exceptions.GenericException;
import exceptions.NonExistsExceptions;
import exceptions.ServiceException;

public class ProductoServiceImpl implements ProductoService {

	private ProductoDAO productoDao;
	
	
	public ProductoServiceImpl() {
		this.productoDao = new ProductoDAOImpl();
		//this.productoDao = new ProductoAWSImpl();
	}
	
	
	
	@Override
	public Producto crearProducto(Producto producto) throws ServiceException {
		try {
			return this.productoDao.insert(producto);
		} catch (DuplicatedExceptions | GenericException de) {
			throw new ServiceException("No se ha podido crear el producto", de);
		}
	}
	@Override
	public Collection<Producto> obtenerProductos() throws ServiceException {
		try {
			return this.productoDao.findAll();
		} catch (GenericException e) {
			throw new ServiceException("No se ha obtener el listado de productos", e);
		}
	}

	@Override
	public Producto deleteProducto(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto updateProducto(Producto producto) throws ServiceException {
		try {
			return this.productoDao.update(producto);
		} catch (DuplicatedExceptions | GenericException e) {
			throw new ServiceException("No se ha obtener el listado de productos", e);
		}
	}

	@Override
	public Producto obtenerProducto(String codigo) throws ServiceException {
		try {
			return this.productoDao.getByCodigo(codigo);
		} catch (NonExistsExceptions | GenericException e) {
			throw new ServiceException("No se ha obtener el listado de productos", e);
		}
	}

	@Override
	public Producto deleteProducto(String codigo) throws ServiceException {
		try {
			return productoDao.delete(codigo);
		} catch (NonExistsExceptions e) {
			throw new ServiceException("No existe el producto con codigo: "+ codigo, e);
		} catch (GenericException e) {
			throw new ServiceException("No se ha podido eliminar el producto codigo: "+codigo+", error inesperado", e);
		}
	}

	@Override
	public Collection<Producto> buscarProducto(String claveBusqueda) throws ServiceException {
		try {
			return this.productoDao.buscar(claveBusqueda);
		} catch (GenericException e) {
			throw new ServiceException("No se ha obtener el listado de productos", e);
		}
	
	}

	

}
