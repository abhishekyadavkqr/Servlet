package com.ab.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class StudentSearchApp extends HttpServlet {
	private static final String GET_STUDENT_DETAILS_BY_USING_ROLL_NO= "SELECT NAME,ADDRESS,FEE,DOB FROM STUDENT WHERE 	ROLL_NO = ? ";
	@Override
	public void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		PrintWriter pw = rs.getWriter();
		rs.setContentType("text/html");
		ServletConfig cg = getServletConfig();
		String url = cg.getInitParameter("dbUrl");
		String dbUser = cg.getInitParameter("dbUser");
		String dbPassword = cg.getInitParameter("dbPassword");
		String className = cg.getInitParameter("dbClass");
		String roll = rq.getParameter("rollNo");
		System.out.println("url :: " + url);
		System.out.println("dbUser :: " + dbUser);
		System.out.println("dbPassword :: " + dbPassword);
		System.out.println("dbClassName :: " + className);
		System.out.println("Roll :: " + roll);
		
		int rNo=0;
		if(!roll.equals(null)||!roll.contains("")||roll.length()!=0 )
			try {
			rNo = Integer.parseInt(roll);
			}catch(Exception e) {
				pw.println("<h3 style = 'color:red; text-align:center;'> Please! Enter the Roll Number in numberic format(for Eg. 1001, 1002...).</h3>");
				pw.println("<h4 style='text-align:center;color:pink;'><a href=Homepage.html>Home</a>");
				return;
			}
		else {
			pw.println("<h3 style = 'color:red; text-align:center;'> Please! Enter the Roll Number.</h3>");
		pw.println("<h4 style='text-align:center;color:pink;'><a href=Homepage.html>Home</a>");
		return;
		}
		
//		----------------------- Class Loading -------------------------------
		
		try {
		 Class c = 	Class.forName(className);
			System.out.println("Step 1 Passed...\n"+c+" is loaded...");
	}catch (ClassNotFoundException cnfe) {
		pw.println("<h4 style='text-align:center;color:pink;'><a href=Homepage.html>Home</a>");
			System.out.println(cnfe.getMessage()+" Class Not Found ");
		}// try closed
	catch (Exception cnfe) {
		System.out.println(cnfe.getMessage()+" Class Not Found ");
	}// try closed
		
		
//		System.exit(1);
		try(Connection con = DriverManager.getConnection(url,dbUser,dbPassword);
				PreparedStatement ps  = con.prepareStatement(GET_STUDENT_DETAILS_BY_USING_ROLL_NO);){
			System.out.println("Step 2 Passed...");
			if(ps!=null)
				ps.setInt(1, rNo);
			System.out.println("Step 3 Passed...");
			if(ps!=null)
				try(ResultSet res = ps.executeQuery();){
					System.out.println("Step 4 Passed...");
					if(res.next()) {
						pw.println("<h3 style = 'color:lime; text-align:center;'> "+"Student Name :: <p style='color:black'>"
					        +res.getString(1)+"</p><br>"+"Student Address :: <p style='color:black'>"
							+res.getString(2)+"</p><br>"+"Student Fee :: <p style='color:black'>"
							+res.getString(3)+"</p><br>"+"Student Date of Birth :: <p style='color:black'>"
							+res.getString(4)+"</p><br>"+ "</h3>");
						pw.println("<h4 style='text-align:center;color:pink;'><a href=Homepage.html>Home</a>");
					}
					else {
						pw.println("<h3 style='text-align:center;color:pink;'>Record Not Found... </h3>");
						
						pw.println("<h4 style='text-align:center;color:pink;'><a href=Homepage.html>Home</a>");
					}
				}
			pw.close();
			
		}catch (SQLException e) {
			pw.println("<h3 style = 'color:lime; text-align:center;'> "
			        +e.getMessage()+"</h3>");
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
