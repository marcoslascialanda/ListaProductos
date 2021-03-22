package servlets;


import java.io.IOException;

import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Producto;
import enums.PantallasEnum;
import exceptions.ServiceException;
import service.ProductoService;
import service.ProductoServiceImpl;

@WebServlet("/NuevoProductoServlet")
public class NuevoProductoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductoService ps = new ProductoServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		String titulo = request.getParameter("titulo");
		Float precio = Float.parseFloat(request.getParameter("precio"));
		Long tipoProducto = Long.parseLong(request.getParameter("tipoProducto"));
		
		Producto p = new Producto(titulo,precio,codigo,tipoProducto);
		
		String target;
		
		try {
			Producto pcreado = ps.crearProducto(p);
			
			//obtengo todos los productos y lo cargo en una lista para mostrarlos en
			// un listado
			
			Collection<Producto> productos = ps.obtenerProductos();
			
			request.setAttribute(PantallasEnum.LISTADO.getPantalla() ,productos);
			
			request.setAttribute("exito", "Se ha dado de alta el producto id: "+ pcreado.getId());
			
			target = "/jsp/listado.jsp";		
		}catch(ServiceException e) {
			
			String error = e.getCause().getMessage();
			
			request.setAttribute("error", error);
			
			target = "/jsp/nuevo.jsp";
		}	
		
		//redireccion
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
		
		rd.forward(request, response);
	}
}
