package com.assignment2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Assignment2 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				
				res.setContentType("text/html");
				String perName = req.getParameter("personName");
				String perAge = req.getParameter("personAge");
				String gender = req.getParameter("gender");
				PrintWriter pw = res.getWriter();
				pw.println("<h1 style='color:rgb(0, 77, 153); text-align:center'>Marriage eligibility result</h>");
				int age = 0;
				try {
				age=Integer.parseInt(perAge);
				}catch(Exception e) {
					pw.println("<h1 style='color:red; text-align:center'>invalid! age.</h>");
					
				}
				try {
					if(gender == null)
						throw new Exception();
				}catch(Exception e) {
					pw.println("<h1 style='color:red; text-align:center'>Please select the gender.</h>");
					
				}
				
				if((age >= 18 && gender.equalsIgnoreCase("Female"))||(age >=21 && gender.equalsIgnoreCase("Male")))
					pw.println("<h1 style='color:green; text-align:center'>Mr/Mrs/Miss. "+perName+" You are eligible for marriage</h>");
				else
					pw.println("<h1 style='color:red; text-align:center'>Mr/Mrs/Miss. "+perName+" You are not eligible for marriage</h>");
	
				pw.println("<br><br><a href = 'HomePage.asp'><b>Check another<b></a>");
				
	}
}
