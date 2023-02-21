package com.groupeisi.SecurityWeb.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groupeisi.SecurityWeb.dao.Comptesdao;
import com.groupeisi.SecurityWeb.dao.Droitsdao;
import com.groupeisi.SecurityWeb.dto.Comptesdto;
import com.groupeisi.SecurityWeb.entities.Droits;
import com.groupeisi.SecurityWeb.entities.Comptes;

/**
 * Servlet implementation class ComptesServlet
 */
@SuppressWarnings("unused")
@WebServlet(urlPatterns = {"/compte/list", "/compte/add"})
public class ComptesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Comptesdao comptesdao = new Comptesdao();
	private Droitsdao droitsdao = new Droitsdao();
       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
        if (session == null) {
        	resp.sendRedirect("../index.jsp");
        } 

        if (session.getAttribute("username") == null) {
        	resp.sendRedirect("../index.jsp");
        } else {
		String action = req.getServletPath();

			switch (action) {
			case "/compte/add":
				List<Droits> listdroit = droitsdao.getAll();
				req.setAttribute("listdroit", listdroit);
				req.getRequestDispatcher("../WEB-INF/view/comptes/add.jsp").forward(req, resp);
				break;
			case "/compte/logout":
				RequestDispatcher dispatcher = req.getRequestDispatcher("/LogoutServlet");
				dispatcher.forward(req, resp);
	
				break;
			default:
				List<Comptesdto> listCompte = comptesdao.ListCompteToListCompteDto(comptesdao.getAll());
				req.setAttribute("listCompte", listCompte);
	
				req.getRequestDispatcher("../WEB-INF/view/comptes/list.jsp").forward(req, resp);
				break;
			}
        }
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session = req.getSession(false);
	        if (session == null) {
	        	resp.sendRedirect("../index.jsp");
	        } 

	        if (session.getAttribute("username") == null) {
	        	resp.sendRedirect("../index.jsp");
	        } else {
				Comptes comptes = new Comptes();
				String[] idDroits = req.getParameterValues("droit");
				List<Droits> listDroit = new ArrayList<>();
			    for (String idDroit : idDroits) {
			    	listDroit.add(droitsdao.getOne(Integer.parseInt(idDroit)));
			      }
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				
				comptes.setUserName(username);
				comptes.setPassword(password);
				comptes.setDroits(listDroit);
				comptesdao.save(comptes);
				
				List<Comptesdto> listCompte = comptesdao.ListCompteToListCompteDto(comptesdao.getAll());
				req.setAttribute("listCompte", listCompte);
		
				req.getRequestDispatcher("../WEB-INF/view/comptes/list.jsp").forward(req, resp);
	        }
	}

}
