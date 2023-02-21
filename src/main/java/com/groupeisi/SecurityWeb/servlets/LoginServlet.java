package com.groupeisi.SecurityWeb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groupeisi.SecurityWeb.dao.Comptesdao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	 /**
     * Default constructor. 
     */
    public LoginServlet() {
    	
    }
    private Comptesdao loginDao;

	
    @Override
	public void init() {
		loginDao = new Comptesdao();
		//super.init(config);
	}

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	req.setAttribute("error", "email ou mot de passe incorrect !!!");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	String username = req.getParameter("username").toString();
		String password = req.getParameter("password").toString();
		
		if (loginDao.login(username, password)) {
	        HttpSession session = req.getSession();
	        session.setAttribute("username", username);
			resp.sendRedirect("comptes/list");
			
		}else {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}

}
