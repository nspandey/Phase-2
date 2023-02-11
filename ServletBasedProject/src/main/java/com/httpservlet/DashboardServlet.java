package com.httpservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		
		resp.setContentType("text/html");
		HttpSession session=req.getSession();
		
		if(session!=null) {
			String USERNAME=(String) session.getAttribute("key");
			
	//			System.out.println("user"+USERNAME);
			
			if(USERNAME!=null) {
				out.print("User Exist: "+ USERNAME);
				out.print("<br><a href='logout'>Logout</a>");
			}
			else {
				out.print("Enter user name and password");
				resp.sendRedirect("login");
			}
			
		}
		else
		{
			out.print("Kindly Login First");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
