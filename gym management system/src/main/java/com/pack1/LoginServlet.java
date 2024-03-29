package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String s1=request.getParameter("username");
		String s2=request.getParameter("pword");
		ServletContext sc=getServletContext();
		System.out.println(s1+s2);
        Connection con = (Connection)sc.getAttribute("oracle");
        try {
			PreparedStatement pstmt=con.prepareStatement("select * from admin where username=? and pword=?");
			pstmt.setString(1, s1);
			pstmt.setString(2, s2);
			ResultSet rs = pstmt.executeQuery();
			PrintWriter pw = response.getWriter();
			if(rs.next())
			{
				HttpSession s=request.getSession();
				s.setAttribute("username", s1);
				response.sendRedirect("dashbord.jsp");
			}
			else {
				pw.println("<html><body><h1>");
				pw.println("invalid userName/password</h1></body></html>");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private HttpSession setAttribute(String string, String s1) {
		// TODO Auto-generated method stub
		return null;
	}

}
