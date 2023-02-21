package com.groupeisi.SecurityWeb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groupeisi.SecurityWeb.dao.Droitsdao;
import com.groupeisi.SecurityWeb.dto.Droitsdto;
import com.groupeisi.SecurityWeb.entities.Droits;

/**
 * Servlet implementation class DroitsServlet
 */
@WebServlet(urlPatterns = {"/droit/list", "/droit/add"})
public class DroitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
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
			case "/droit/add":
				req.getRequestDispatcher("../WEB-INF/view/droits/add.jsp").forward(req, resp);
				break;
			case "/droit/logout":
				RequestDispatcher dispatcher = req.getRequestDispatcher("/LogoutServlet");
				dispatcher.forward(req, resp);
	
				break;
			default:
				List<Droitsdto> listDroit  = droitsdao.ListDriotToListDriotDto(droitsdao.getAll());
				req.setAttribute("listDroit", listDroit);
	
				req.getRequestDispatcher("../WEB-INF/view/droits/list.jsp").forward(req, resp);
				break;
			}
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
        if (session == null) {
        	resp.sendRedirect("../index.jsp");
        } 

        if (session.getAttribute("username") == null) {
        	resp.sendRedirect("../index.jsp");
        } else {		 
			String name = req.getParameter("name");
			
			Droits droits = new Droits();
			droits.setName(name);
			droitsdao.save(droits);
			List<Droitsdto> listDroit  = droitsdao.ListDriotToListDriotDto(droitsdao.getAll());
			req.setAttribute("listDroit", listDroit);
	
			req.getRequestDispatcher("../WEB-INF/view/droits/list.jsp").forward(req, resp);
        }
	}

}
