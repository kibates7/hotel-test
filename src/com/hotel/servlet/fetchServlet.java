package com.hotel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.bean.Guest;
import com.hotel.dao.GuestDAO;

/**
 * Servlet implementation class fetchServlet
 */
@WebServlet("/fetchServlet")
public class fetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fetchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inp=request.getParameter("email");
		GuestDAO dao = new GuestDAO();
		List<Guest> guestlist= dao.getGuest(inp);
		request.setAttribute("result",  guestlist);
		//getServletContext().getRequestDispatcher("/GuestInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inp = request.getParameter("phone");
		//int gno = Integer.parseInt(inp);
		GuestDAO dao = new GuestDAO();
		List<Guest> guestList = dao.getGuest1(inp);
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor = 'lavender'>");
		for(Guest g : guestList) {
			out.println(g + "<BR>");
		}
		out.println("</body></html>");
		// TODO Auto-generated method stub
	}

}