package servlets;

import java.io.IOException;

import java.util.ArrayList;
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

@WebServlet("/CargarParaEditarProductoServlet")
public class CargarParaEditarProductoServlet extends HttpServlet {

	private ProductoService ps = new ProductoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String codigo  = req.getParameter("codigo");
		
		//validaciones!!!
		String target = "/jsp/listado.jsp";
		
		try {
			Producto productoAEditar = this.ps.obtenerProducto(codigo);
			
			//cargar en el request!
			req.setAttribute("producto", productoAEditar);
			
			target = "/jsp/editar.jsp";
		} catch (ServiceException e) {
			Collection<Producto> listado;
			try {
				listado = this.ps.obtenerProductos();
			} catch (ServiceException e1) {
				listado = new ArrayList<Producto>();
			}
			req.setAttribute(PantallasEnum.LISTADO.getPantalla(), listado);
		}
		
		//redireccionar!
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
		rd.forward(req, resp);
	}
}
