package com.httpservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String token=req.getParameter("emailid");
		System.out.println("token"+token);
		//add user to Http Session
		if(!token.equals(""))
		{
		HttpSession session=req.getSession();
		session.setAttribute("key", token);
//		System.out.println(key);
		resp.sendRedirect("dashboard");
		}
		else {
			PrintWriter out=resp.getWriter();
			out.print("enter valid details");
			}
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}

