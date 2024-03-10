package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class Demo extends GenericServlet {
	
	@Override
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
					Date d = new Date();
					pw.println("<h1 style ='color:red;text-align:center;' >Date and time is :::"+d+"<h1>");
					pw.println("<h1 style ='color:blue;text-align:center;'> This is our first servlet Program <h1>");
					pw.println("<br> <b style = 'color:blue;'> current servletclass object hashcode :: "+this.hashCode()+"</b>");
					pw.println("<br> <b style = 'color:blue;'> request object hashcode :: "+req.hashCode()+"</b>");
					pw.println("<br> <b style = 'color:blue;'> response object hashcode :: "+res.hashCode()+"</b>");
					pw.println("<br> <b style = 'color:blue;'> current thread object hashcode :: "+Thread.currentThread().hashCode()+"<br> current thread name :: "+Thread.currentThread().getName() +"</b>");
					System.out.println("Service method is running");
	
					pw.close();
	}

	
		
}
