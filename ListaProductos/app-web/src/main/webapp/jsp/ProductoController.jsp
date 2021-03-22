<%--DIRECTIVAS--%>
<%@page import="exceptions.ServiceException"%>
<%@page import="domain.Producto"%>
<%@page import="service.ProductoServiceImpl"%>
<%@page import="service.ProductoService"%>

<%	
	String codigo = request.getParameter("codigo");
	String titulo = request.getParameter("titulo");
	Float precio = Float.parseFloat(request.getParameter("precio"));
	Long tipoProducto = Long.parseLong(request.getParameter("tipo"));
	
	ProductoService ps = new ProductoServiceImpl();
	Producto p = new Producto(titulo,precio,codigo,tipoProducto);
	
	try {
		Producto pcreado = ps.crearProducto(p);
		//guardo el dato a mostrar luego en "la otra jsp"
		request.setAttribute("pcreado",pcreado);
%>
	<%@include file="altaok.jsp" %>
<%
	}catch(ServiceException e) {
%>
	<%@include file="error.jsp" %>
<%
	}
	
%>