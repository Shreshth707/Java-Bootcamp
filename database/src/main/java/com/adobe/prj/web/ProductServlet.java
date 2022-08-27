package com.adobe.prj.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adobe.prj.dao.DaoException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDao productDao = new ProductDaoJdbcImpl();
		try {
			List<Product> products = productDao.getProducts();
			request.setAttribute("products", products);
			request.getRequestDispatcher("print.jsp").forward(request, response);
		} catch (DaoException ex) {
			response.sendRedirect("error.jsp?msg = " + ex.getMessage());
		}
			
//		response.setContentType("text/html"); // MIME type
//		PrintWriter out = response.getWriter(); // character stream
//		// ServletOutputStream out = response.getOutputStream(); // byte stream
//		out.print("<html><body>");
//		out.print("<table border=\"1\">");
//		out.print("<tr><th>Name</th><th>Price</th></tr>");
//		ProductDao productDao = new ProductDaoJdbcImpl(); // better use Factory
//		try {
//			List<Product> products = productDao.getProducts();
//			for(Product p : products) {
//				out.print("<tr>");
//					out.print("<td>" + p.getName() + "</td>");
//					out.print("<td>" + p.getPrice() + "</td>");
//				out.print("</tr>");
//			}
//		} catch (DaoException e) {
//			response.sendRedirect("error.jsp?msg = " + e.getMessage());
//		}
//		out.print("</table>");
//		out.print("<a href=\"index.html\">Back</a>");
//		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDao productDao = new ProductDaoJdbcImpl();
		Product p = Product.builder()
				.name(request.getParameter("name"))
				.price(Double.parseDouble(request.getParameter("price")))
				.quantity(Integer.parseInt(request.getParameter("qty")))
				.build();
	   try {
			productDao.addProduct(p);
			response.sendRedirect("index.html");
		} catch (DaoException e) {
			e.printStackTrace(); // development state
			response.sendRedirect("error.jsp?msg = " + e.getMessage());
		}
	}

}
