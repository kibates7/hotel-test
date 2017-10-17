package com.hotel.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.bean.Guest;

/**
 * Servlet implementation class removeServlet
 */
@WebServlet("/removeServlet")
public class removeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			@SuppressWarnings("unused")
			int no = 0;
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelsystem", "root", "root");
	        String sql1 = "UPDATE reservation SET amm = null where guestid=(SELECT guestid from guest where email='"+Guest.getEmail()+"')";
	        String sql2 = "UPDATE reservation SET total_due = rate + amm where guestid=(SELECT guestid from guest where email='"+Guest.getEmail()+"')";
	        String sql3 = "DELETE FROM reservation where guestid=(SELECT guestid from guest where email='"+Guest.getEmail()+"')";
	        String sql4 = "UPDATE room SET available = 0 where guestid=(SELECT guestid from guest where email='"+Guest.getEmail()+"')";
			String sql5 = "UPDATE room SET guestid = null where guestid=(SELECT guestid from guest where email='"+Guest.getEmail()+"')";
			String sql6 = "UPDATE guest SET now = 0 where email='"+Guest.getEmail()+"'";
			String sql7 = "UPDATE guest SET roomid = null where email='"+Guest.getEmail()+"'";
			
			// Create a Prepared statement
			PreparedStatement ps1 = con.prepareStatement(sql1);
			PreparedStatement ps2 = con.prepareStatement(sql2);
			PreparedStatement ps3 = con.prepareStatement(sql3);
			PreparedStatement ps4 = con.prepareStatement(sql4);
			PreparedStatement ps5 = con.prepareStatement(sql5);
			PreparedStatement ps6 = con.prepareStatement(sql6);
			PreparedStatement ps7 = con.prepareStatement(sql7);
			
			no = ps1.executeUpdate();
			no = ps2.executeUpdate();
			no = ps3.executeUpdate();
			no = ps4.executeUpdate();
			no = ps5.executeUpdate();
			no = ps6.executeUpdate();
			no = ps7.executeUpdate();
			
			RequestDispatcher rd=request.getRequestDispatcher("removed.html");  
 		   	rd.forward(request,response);  
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
