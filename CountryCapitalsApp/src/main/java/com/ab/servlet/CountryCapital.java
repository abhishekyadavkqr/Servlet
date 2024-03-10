package com.ab.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryCapital extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		 int countryCode =  Integer.parseInt(req.getParameter("country"));
		 	String countryName [] = new String[] {"INDIA","BHUTAN","NEPAL","USA","SRI LANKA"};
		 	String capital[] = new String[] {"NEW DELHI","THIMPHU", "KATHMANDU", "WASHINGTON D.C.", "KOLAMBO"};
		 	pw.println("<h1 style='color:blue;text-align:center;'> Capital of the "+countryName[countryCode]+" is "+ capital[countryCode]+ "</h1>");
		 	pw.println("<a href= 'page.html'>Home</a>");
		 	pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			 doGet(req, res);
	}
}
