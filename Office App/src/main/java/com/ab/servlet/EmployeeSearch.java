package com.ab.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.driver.OracleDriver;


public class EmployeeSearch extends HttpServlet {
	private static final String FETCH_RECORD = "SELECT ENAME,JOB,SAL FROM EMP WHERE EMPNO =?";
@Override
public void doGet(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
		
	PrintWriter pw = rs.getWriter();
		rs.setContentType("text/html");
		System.out.println("Connecting to the database...");
		 int eNo =0;
		try {
			OracleDriver driver = new OracleDriver();
			//driver.re
			 String empNo = req.getParameter("EmpNo");
			 empNo = empNo.trim();
			 if(empNo!=null || !empNo.equals("")|| !empNo.contains(""))
			  eNo = Integer.parseInt(empNo);
			 System.out.println(empNo);
			//Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
			pw.println("<h2>"+e.getMessage()+"... </h2>");
			e.printStackTrace();
			
		}
		try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","TEST","Test1");
				PreparedStatement ps = con.prepareStatement(FETCH_RECORD);){
			ps.setInt(1, eNo);
			ResultSet res=ps.executeQuery();
			
			pw.println("<h3 style='text-align:center'>Employee Name"+"&nbsp&nbsp&nbsp"+"Designation"+"&nbsp&nbsp&nbsp"+"Salary</h3><br>");
			if(res.next())
				pw.println(res.getString(1)+"&nbsp&nbsp&nbsp"+res.getString(2)+"&nbsp&nbsp&nbsp"+res.getString(3));
			else
				pw.println("<h1> No Record Found!</h1>");
				
			
		} catch (SQLException e) {
			pw.println("<h2>Connection Not established</h2>");
			pw.println("<h2>"+e.getMessage()+"</h2>");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		pw.close();
}
@Override
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(req, resp);
}
}
