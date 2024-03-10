//HtmlServlet
package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HtmlServlet extends HttpServlet
{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<table border = '1' align = 'center'>");
		pw.println("<tr><th>Name</th><th>Qualification</th><th>Address</th></tr>");
		pw.println("<tr><td>AbhiShek Yadav</td><td>MCA</td><td>Jhumari Telaiya</td></tr>");
		pw.println("<tr><td>Ashwani</td><td>MBA</td><td>Patna</td></tr>");
		pw.println("<tr><td>Abhay</td><td>MCA</td><td>Koderma</td></tr>");
		pw.println("<tr><td>Dheeraj</td><td>MCA</td><td>Mumbai</td></tr>");
		pw.println("</table>");
		res.setHeader("refresh","5");
		pw.println("<br><br><h1 style ='color:red;text-align:center;'>Date and Time :: "+ new java.util.Date());
		pw.close();

	}



//	public static void main(String[] args) 
//	{
//		System.out.println("Hello World!");
//	}
}
