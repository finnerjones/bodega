package com.finnerjones.bodega.web.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.finnerjones.bodega.core.exceptions.BodegaDatabaseException;
import com.finnerjones.bodega.persistence.entities.Product;
import com.finnerjones.bodega.persistence.jpa.ProductTypeJpaPersistence;

public class TestConnectionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private ProductTypeJpaPersistence productTypeManager;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Product product = (Product) productTypeManager.find(Product.class, 1L);
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("product", product);
			RequestDispatcher rd = req.getRequestDispatcher("test-dao.jsp");
			rd.forward(req, resp);

		} catch (BodegaDatabaseException bdbe) {
			bdbe.printStackTrace();
		}
	}
}
