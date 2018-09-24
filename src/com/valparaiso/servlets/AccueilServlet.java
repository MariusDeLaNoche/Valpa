package com.valparaiso.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.valparaiso.beans.FichierBean;
import com.valparaiso.beans.UtilisateurBean;
import com.valparaiso.dao.DAOFactory;
import com.valparaiso.dao.FichierDAO;
import com.valparaiso.metiers.AccueilForm;
/**
 * Servlet implementation class AccueilServlet
 */
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONF_DAOFACTORY = "daofactory";

	public static final String VUE = "/WEB-INF/accueil.jsp";
	public static final String REDIRECT = "/connect";
	public static final String NAME = "accueil";
	public static final String ATTR_SESSION_USERBEAN = "userBean";
	private FichierDAO fichierDAO;

	@Override
	public void init() throws ServletException {
        /* Récupération d'une instance de DAOUtilisateur */
        this.fichierDAO = ( (DAOFactory) getServletContext().getAttribute( CONF_DAOFACTORY ) ).getFichierDao();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		/*
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
		UtilisateurBean user = (UtilisateurBean) session.getAttribute( ATTR_SESSION_USERBEAN );
        if ( user == null ) {
            /* Redirection vers la page publique */
            response.sendRedirect( request.getContextPath() + REDIRECT );
        } else {
            /* Affichage de la page restreinte */
        	request.setAttribute("nomPrenomUser", user.getNom() + " " + user.getPrenom());
        	
        	String para = request.getParameter("para");
        	if(para != null && para.equals("tree")) {
        		// Génération du JSON correspondant à l'arbo fichier de l'utilisateur, à déplacer dans une classe métier
        		AccueilForm accueilForm = new AccueilForm(fichierDAO);
				FichierBean rootFile = accueilForm.getFichierRootByIdUtilisateur(user);
				String jsonToSend = accueilForm.generateJsonByRootFile(rootFile);
	        	response.setContentType("application/json");
	        	response.getWriter().write(jsonToSend);
	        	return;
        	}
        	
        	this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
        }
        
		
	}
}
