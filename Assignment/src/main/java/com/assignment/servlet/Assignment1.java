// Write a java web application using HTML to servlet communication to display food eating
//messages like Breakfast, lunch time, dinner time, snack time etc...
package com.assignment.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Assignment1 extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) throws  ServletException, IOException {
		
				res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
			LocalDateTime ldt = LocalDateTime.now();
			int dinnerHour = ldt.getHour();
			pw.println("<h1 style = 'color:red; text-align:center;'> Current Time :: "+ldt+"</h1><br><br>");
			if(dinnerHour > 21 || dinnerHour < 5)
				pw.println("<h3 style = 'color:green; text-align:center;'>  Sleeping Time :: </h1>");
				
			else if(dinnerHour <=6)
				pw.println("<h3 style = 'color:green; text-align:center;'>  Breakfast :: </h1>");
			else if(dinnerHour <=9)
				pw.println("<h3 style = 'color:blue; text-align:center;'>  AM Snack :: </h1>");
			else if(dinnerHour <= 12)
				pw.println("<h3 style = 'color:red; text-align:center;'>  Lunch :: </h1>");
			else if(dinnerHour <= 15)
				pw.println("<h3 style = 'color:violet; text-align:center;'>  PM Snack :: </h1>");
			else if(dinnerHour <= 18)
				pw.println("<h3 style = 'color:black; text-align:center;'>  Dinner :: </h1>");
			else
				pw.println("<h3 style = 'color:orange; text-align:center;'>  Bedtime Snack :: </h1>");
			
			pw.println("<a href ='http://localhost:2020/Assignment/index.html'>Home </a>");
			pw.close();
			
			
				
	}
	
	
	
}
