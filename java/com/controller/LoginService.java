package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Users;

import com.model.userManager;

public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginService() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
	Users U= new Users();
		U.setUsername(username);
		U.setPassword(password);

		userManager UM= new userManager();
		
		String ack="";
		try {
			ack=UM.ValidateCredentials(U);
		}catch(Exception e) {
			ack=e.getMessage();
		}
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println(ack);
		
		if(ack!="") {
			request.setAttribute("user", ack);
			RequestDispatcher rd= request.getRequestDispatcher("home.jsp");
			rd.forward(request,response);
		}
		else {
			RequestDispatcher rd= request.getRequestDispatcher("validationfailed.jsp");
			rd.forward(request,response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
