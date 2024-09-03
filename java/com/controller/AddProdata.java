package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Addpro;
import com.model.AdminManager;

/**
 * Servlet implementation class AddProdata
 */
public class AddProdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String qty=request.getParameter("qty");
		String type=request.getParameter("type");
		String cost=request.getParameter("cost");
		
		
	Addpro U=new Addpro();
		U.setName(name);
		U.setQty(qty);
		U.setType(type);
		U.setCost(cost);

	   AdminManager UM= new AdminManager();
		
		String ack="";
		try {
			ack=UM.addpro(U);
		}catch(Exception e) {
			ack=e.getMessage();
		}
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println(ack);
		RequestDispatcher rd= request.getRequestDispatcher("addpro.jsp");
		rd.include(request,  response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
