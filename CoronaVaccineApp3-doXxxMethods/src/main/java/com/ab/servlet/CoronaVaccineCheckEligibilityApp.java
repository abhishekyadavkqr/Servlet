package com.ab.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CoronaVaccineCheckEligibilityApp extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String pName = req.getParameter("personName");
		String pAge = req.getParameter("personAge");
		String pAdd = req.getParameter("personAdd");
		int perAge =0;
		try {
		 perAge = Integer.parseInt(pAge);
		}catch(Exception e) {
			pw.println("<h1 style='color:red;text-align;center;'>Age can not be \"Null\" or \"Zero\"</h1>");

			}
		
		if (perAge >= 18) 
			pw.println("<h1 style='color:red;text-align:center;'>Mr/Mrs/Miss. "+pName+" You are eligible for corona  vaccination</h1>");
		else
			pw.println("<h1 style='color:green;text-align;center;'>Mr/Mrs/Miss. "+pName+" You are not eligible for corona  vaccination</h1>");
		
// Absolute URL :: 		http://localhost:2020/CoronaVaccineApp/index.html
//		pw.println("<br> <a href=''> <img src='images/home.jpg' width='25px'height ='25px' > </a>");
//Relative URL ::     index.html	
// Relative URL support the WODA behaviour
//			WODA => Write Once Deployment Anywhere	
//		pw.println("<br> <a href='index.html'> <img src='images/home.jpg' width='25px'height ='25px' > </a>");
		pw.close();
	}

}
