package com.ab.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksApp extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String pIn = req.getParameter("p1");
		Locale local[] = Locale.getAvailableLocales();
		
		
		
		if(pIn.equalsIgnoreCase("link1")) {
			pw.println("<h1 style ='color:green; text-align center;'>All Language </h1>");
			for (Locale locale : local) {
				pw.println(locale.getDisplayLanguage());
			}
			
		}
		else if(pIn.equalsIgnoreCase("link2")) {
			pw.println("<h1 style ='color:green; text-align center;'>All Country </h1>");
			for (Locale locale : local) {
				pw.println(locale.getDisplayCountry());
			}
		}
		
		else {
			pw.println("<h1 style ='color:green; text-align center;'>System Date & Time ::: "+LocalDateTime.now()+" </h1>");
		}
		
		pw.println(" <a href = Links.html >HomePage</a>");
		
	}
}
