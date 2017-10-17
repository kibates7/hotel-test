package com.hotel.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.bean.Guest;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		String zip =request.getParameter("zip");
		String room = request.getParameter("room_type");
		String in = request.getParameter("check_in");
		String out = request.getParameter("check_out");
		String pass = request.getParameter("password");
		int single = 0;
		int dbl = 0;
		int suite = 0;
		int studio = 0;
		int available = 0;
		
		        try{
		         Class.forName("com.mysql.jdbc.Driver");
		           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelsystem", "root", "Dallasplano@123");
		           Statement st = con.createStatement();
		           Statement st1 = con.createStatement();
		           Statement st2 = con.createStatement();
		           Statement st3 = con.createStatement();
		           Statement st4 = con.createStatement();
		           Statement st5 = con.createStatement();
		           Statement st6 = con.createStatement();
		           Statement st7 = con.createStatement();
		           Statement st8 = con.createStatement();
		           Statement st9 = con.createStatement();
		           Statement st10 = con.createStatement();
		           
		           if (room.equals("Single")) {
		        	   PreparedStatement ps = con.prepareStatement("select count(roomid) from room where available = 1 and room_type = '"+room+"';");
		        	   ResultSet rs = ps.executeQuery();
		        	   if(rs.next())
		        		   single = rs.getInt(1);
		        	   
		        	   PreparedStatement p = con.prepareStatement("select roomid from room where available = 0 and room_type = '"+room+"' limit 1");
		        	   ResultSet r = p.executeQuery();
		        	   if(r.next())
		        		   available = r.getInt(1);
		        	 
		        	   if (single < 10) {
		        		   st.executeUpdate("insert into guest (roomid, email, firstname, lastname, phone, address, city, state, zip, check_in, check_out, room_type) values ('"+available+"','"+email+"','"+firstname+"','"+lastname+"','"+phone+"','"+address+"','"+city+"','"+state+"','"+zip+"','"+in+"','"+out+"','"+room+"')");
		        		   st1.executeUpdate("insert into login (email, pass) values ('"+email+"','"+pass+"')");
		        		   st2.executeUpdate("update room set available = 1 where available = 0 AND  room_type = '"+room+"' limit 1;");
		        		   st3.executeUpdate("update login, guest set login.guestid = guest.guestid where guest.email = login.email");
		        		   //st4.executeUpdate("update room, guest set room.guestid = guest.guestid where guest.roomid = room.roomid");
		        		   st5.executeUpdate("insert into reservation (roomid) values ('"+available+"')");
		        		   st6.executeUpdate("update reservation, guest set reservation.guestid = guest.guestid where guest.roomid = reservation.roomid");
		        		   st7.executeUpdate("update reservation, room set reservation.rate = room.rate where room.roomid = reservation.roomid");
		        		   st8.executeUpdate("INSERT into archive (roomid, room_type, check_in, check_out) values ('"+available+"','"+room+"','"+in+"','"+out+"')");
		        		   st9.executeUpdate("update archive, guest set archive.guestid = guest.guestid where archive.roomid = guest.roomid");
		        		   st10.executeUpdate("update guest set now = 1 where email = '"+email+"'");
		        		   System.out.println("Data is successfully inserted!");
		        		   RequestDispatcher rd=request.getRequestDispatcher("registered.html");  
		        		   rd.forward(request,response);  
		        	   }
		        	   else {
		        		   RequestDispatcher rd=request.getRequestDispatcher("booked.html");  
		        		   rd.forward(request,response); 
		        	   }
						
		           }
		 

					else if (room.equals("Double")) {
						PreparedStatement ps1 = con.prepareStatement("select count(roomid) from room where available = 1 and room_type = '"+room+"';");
			        	ResultSet rs1 = ps1.executeQuery();
			        	if(rs1.next())
			        		dbl = rs1.getInt(1);
			        	
			        	PreparedStatement p = con.prepareStatement("select roomid from room where available = 0 and room_type = '"+room+"' limit 1");
			        	ResultSet r = p.executeQuery();
			        	if(r.next())
			        		available = r.getInt(1);
			        	 
						if(dbl < 15) {
							st.executeUpdate("insert into guest (roomid, email, firstname, lastname, phone, address, city, state, zip, check_in, check_out, room_type) values ('"+available+"','"+email+"','"+firstname+"','"+lastname+"','"+phone+"','"+address+"','"+city+"','"+state+"','"+zip+"','"+in+"','"+out+"','"+room+"')");
			        		   st1.executeUpdate("insert into login (email, pass) values ('"+email+"','"+pass+"')");
			        		   st2.executeUpdate("update room set available = 1 where available = 0 AND  room_type = '"+room+"' limit 1;");
			        		   st3.executeUpdate("update login, guest set login.guestid = guest.guestid where guest.email = login.email");
			        		   //st4.executeUpdate("update room, guest set room.guestid = guest.guestid where guest.roomid = room.roomid");
			        		   st5.executeUpdate("insert into reservation (roomid) values ('"+available+"')");
			        		   st6.executeUpdate("update reservation, guest set reservation.guestid = guest.guestid where guest.roomid = reservation.roomid");
			        		   st7.executeUpdate("update reservation, room set reservation.rate = room.rate where room.roomid = reservation.roomid");
			        		   st8.executeUpdate("INSERT into archive (roomid, room_type, check_in, check_out) values ('"+available+"','"+room+"','"+in+"','"+out+"')");
			        		   st9.executeUpdate("update archive, guest set archive.guestid = guest.guestid where archive.roomid = guest.roomid");
			        		   st10.executeUpdate("update guest set now = 1 where email = '"+email+"'");
							System.out.println("Data is successfully inserted!");
							RequestDispatcher rd=request.getRequestDispatcher("registered.html");  
							rd.forward(request,response);  
						}
						else {
							RequestDispatcher rd=request.getRequestDispatcher("booked.html");  
							rd.forward(request,response); 
						}
					}
					
					else if (room.equals("Suite")) {
						PreparedStatement ps2 = con.prepareStatement("select count(roomid) from room where available = 1 and room_type = '"+room+"';");
			        	ResultSet rs2 = ps2.executeQuery();
			        	if(rs2.next())
			        		suite = rs2.getInt(1);
			        	
			        	PreparedStatement p = con.prepareStatement("select roomid from room where available = 0 and room_type = '"+room+"' limit 1");
			        	ResultSet r = p.executeQuery();
			        	   if(r.next())
			        		   available = r.getInt(1);
			        	 
						if(suite < 15) {
							st.executeUpdate("insert into guest (roomid, email, firstname, lastname, phone, address, city, state, zip, check_in, check_out, room_type) values ('"+available+"','"+email+"','"+firstname+"','"+lastname+"','"+phone+"','"+address+"','"+city+"','"+state+"','"+zip+"','"+in+"','"+out+"','"+room+"')");
			        		   st1.executeUpdate("insert into login (email, pass) values ('"+email+"','"+pass+"')");
			        		   st2.executeUpdate("update room set available = 1 where available = 0 AND  room_type = '"+room+"' limit 1;");
			        		   st3.executeUpdate("update login, guest set login.guestid = guest.guestid where guest.email = login.email");
			        		   //st4.executeUpdate("update room, guest set room.guestid = guest.guestid where guest.roomid = room.roomid");
			        		   st5.executeUpdate("insert into reservation (roomid) values ('"+available+"')");
			        		   st6.executeUpdate("update reservation, guest set reservation.guestid = guest.guestid where guest.roomid = reservation.roomid");
			        		   st7.executeUpdate("update reservation, room set reservation.rate = room.rate where room.roomid = reservation.roomid");
			        		   st8.executeUpdate("INSERT into archive (roomid, room_type, check_in, check_out) values ('"+available+"','"+room+"','"+in+"','"+out+"')");
			        		   st9.executeUpdate("update archive, guest set archive.guestid = guest.guestid where archive.roomid = guest.roomid");
			        		   st10.executeUpdate("update guest set now = 1 where email = '"+email+"'");
							System.out.println("Data is successfully inserted!");
							RequestDispatcher rd=request.getRequestDispatcher("registered.html");  
			        		rd.forward(request,response);  
			        	   }
						else {
							RequestDispatcher rd=request.getRequestDispatcher("booked.html");  
							rd.forward(request,response); 
						}
					}
					
					else if (room.equals("Studio")) {
						PreparedStatement ps3 = con.prepareStatement("select count(roomid) from room where available = 1 and room_type = '"+room+"';");
			        	ResultSet rs3 = ps3.executeQuery();
			        	if(rs3.next())
			        		studio = rs3.getInt(1);
			        	
			        	PreparedStatement p = con.prepareStatement("select roomid from room where available = 0 and room_type = '"+room+"' limit 1");
			        	ResultSet r = p.executeQuery();
			        	if(r.next())
			        		available = r.getInt(1);
			        	 
						if (studio < 10) {
							st.executeUpdate("insert into guest (roomid, email, firstname, lastname, phone, address, city, state, zip, check_in, check_out, room_type) values ('"+available+"','"+email+"','"+firstname+"','"+lastname+"','"+phone+"','"+address+"','"+city+"','"+state+"','"+zip+"','"+in+"','"+out+"','"+room+"')");
			        		   st1.executeUpdate("insert into login (email, pass) values ('"+email+"','"+pass+"')");
			        		   st2.executeUpdate("update room set available = 1 where available = 0 AND  room_type = '"+room+"' limit 1;");
			        		   st3.executeUpdate("update login, guest set login.guestid = guest.guestid where guest.email = login.email");
			        		  // st4.executeUpdate("update room, guest set room.guestid = guest.guestid where guest.roomid = room.roomid");
			        		   st5.executeUpdate("insert into reservation (roomid) values ('"+available+"')");
			        		   st6.executeUpdate("update reservation, guest set reservation.guestid = guest.guestid where guest.roomid = reservation.roomid");
			        		   st7.executeUpdate("update reservation, room set reservation.rate = room.rate where room.roomid = reservation.roomid");
			        		   st8.executeUpdate("INSERT into archive (roomid, room_type, check_in, check_out) values ('"+available+"','"+room+"','"+in+"','"+out+"')");
			        		   st9.executeUpdate("update archive, guest set archive.guestid = guest.guestid where archive.roomid = guest.roomid");
			        		   st10.executeUpdate("update guest set now = 1 where email = '"+email+"'");
			        		   System.out.println("Data is successfully inserted!");
							RequestDispatcher rd=request.getRequestDispatcher("registered.html");  
							rd.forward(request,response);  
						}
						else {
							RequestDispatcher rd=request.getRequestDispatcher("booked.html");  
							rd.forward(request,response); 
						}
					}
		           
		        }
				catch (Exception e) {
					System.out.print(e);
					e.printStackTrace();
				}
	}
}
