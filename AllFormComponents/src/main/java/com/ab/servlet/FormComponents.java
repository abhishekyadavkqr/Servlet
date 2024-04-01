package com.ab.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormComponents extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				
				PrintWriter pw = res.getWriter();
				res.setContentType("text/html");
				try {
					String pName = req.getParameter("Name");
					pw.println(pName);
					
					pw.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
	}
}
