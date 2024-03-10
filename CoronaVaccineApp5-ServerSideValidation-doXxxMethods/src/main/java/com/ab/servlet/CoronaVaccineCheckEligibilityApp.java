package com.ab.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
		List<String> errorList = new ArrayList<String>();
		
		if(pName == null || pName.length()==0 || pName.equalsIgnoreCase(""))
			errorList.add("Person Name is required ");
		if(pAdd == null || pAdd.length()==0 || pAdd.equalsIgnoreCase(""))
			errorList.add("Person address is required");
		else if(pAdd.length() < 10)
			errorList.add("Person address must have minimum 10 characters");
			
		try {
		 perAge = Integer.parseInt(pAge);
		 if(perAge <=0 || perAge > 125)
			 errorList.add("Person age must be in the range of 1 to 125");
		}catch(Exception e) {
			
				errorList.add("Person age must be numberic value");
			}
		
		if(errorList.size() >0)
		{
			pw.println("<ul style='color:red;'>");
			for(String err:errorList)
					pw.println("<li>"+err+"</li>");
			pw.println("</ul>");
			pw.println("<br> <a href='home.html'> <img src='images/home.jpg' width='25px'height ='25px' > </a>");
			pw.close();
			return ;
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
		pw.println("<br> <a href='home.html'> <img src='images/home.jpg' width='25px'height ='25px' > </a>");
		pw.close();
	}
@Override
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	doGet(req, res);
}
}
