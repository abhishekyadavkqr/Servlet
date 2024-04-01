package com.ab.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishMessageServlet extends HttpServlet {
	
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	PrintWriter pw = res.getWriter();
	res.setContentType("text/html");
	
	pw.println("<h1 style ='color:red;text-align:center'> Communication Between HTML and Servlet </h1>");
	LocalDateTime ldt = LocalDateTime.now();
	pw.println("Current Time :: "+ldt);
	int hour = ldt.getHour();
	if(hour<12)
		pw.println("<h1 style='color:green;text-align:center;'> Good Morning</h>");
	else if(hour < 16)
		pw.println("<h1 style='color:red;text-align:center;'> Good Afternoon</h>");
	else if(hour <20)
		pw.println("<h1 style='color:orange;text-align:center;'> Good Evening</h>");
	else
		pw.println("<h1 style='color:grey;text-align:center;'> Good Night</h>");
	
	pw.println("<a href = 'http://localhost:2022/WishApp/Page.html'><br>Home</a> ");
	pw.close();
}

}
