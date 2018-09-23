package com.valparaiso.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.valparaiso.beans.UtilisateurBean;
import com.valparaiso.dao.DAOFactory;
import com.valparaiso.metiers.AdminForm;

/**
 * Servlet implementation class CompetitionServlet
 */
@MultipartConfig
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String REDIRECT = "/connect";
	public static final String VUE = "/WEB-INF/admin.jsp";
	public static final String ATTR_SESSION_USERBEAN = "userBean";
	public static final String CONF_DAOFACTORY = "daofactory";

	private DAOFactory daoFactory;

	@Override
	public void init() throws ServletException {
		this.daoFactory = (DAOFactory) getServletContext().getAttribute(CONF_DAOFACTORY);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UtilisateurBean u = (UtilisateurBean) session.getAttribute(ATTR_SESSION_USERBEAN);
		AdminForm af = new AdminForm(daoFactory);

		if (u == null) {
			/* Redirection vers la page publique */
			resp.sendRedirect(req.getContextPath() + REDIRECT);
		} else {
			this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
		}
		
	}


}
