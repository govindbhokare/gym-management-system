package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GymServlet
 */
public class GymServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GymServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pw.println("connection done......!");
		ServletContext sc=getServletContext();
        Connection con = (Connection)sc.getAttribute("oracle");
        PrintWriter pw=response.getWriter();
        pw.println("connection done......!");
        try {
        	String s1=request.getParameter("uname");
        	String s2=request.getParameter("email");
        	String s3=request.getParameter("contact");
        	String s4=request.getParameter("plan");
        	String s5=request.getParameter("address");
        	String s6=request.getParameter("age");
        	String s7=request.getParameter("gender");
        	String s8=request.getParameter("dates");
        	String s9=request.getParameter("datej");
			PreparedStatement pstmt=con.prepareStatement("insert into gym values(?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, s1);
			pstmt.setString(2, s2);
			pstmt.setString(3, s3);
			pstmt.setString(4, s4);
			pstmt.setString(5, s5);
			pstmt.setString(6, s6);
			pstmt.setString(7, s7);
			pstmt.setString(8, s8);
			pstmt.setString(9, s9);
			pstmt.executeUpdate();
			response.sendRedirect("/gym_management_system/index.html");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
