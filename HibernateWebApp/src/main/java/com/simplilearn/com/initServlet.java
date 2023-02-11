package com.simplilearn.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebServlet("/init")
public class initServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out= resp.getWriter();
		
		//connection pool
		SessionFactory factory= HibernateUtil.getSessionFactory();
		
		//check the connection
		Session session=factory.openSession();
		
		//out.print("Hibernate Session Opened");
		
		 Details details=new Details();
		 details.setName("Saroj Pandey");
		 details.setAadharcard("3234-5678-9101-9987");
		 details.setPancard("ab23dfghh");
		 details.setAddress("xyz,123 streat,prq city,1234567 pincode,lmn state,qwerty country");
		 
		 Transaction tx=session.beginTransaction();
		 session.save(details);
		 tx.commit();
		
		session.close();
		
		out.print("Details Added Successfully");
	 
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	

}
