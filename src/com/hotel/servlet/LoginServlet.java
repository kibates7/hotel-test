package com.hotel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.bean.Employee;
import com.hotel.bean.Guest;
import com.hotel.dao.EmpLoginDAO;
import com.hotel.dao.EmployeeDAO;
import com.hotel.dao.GuestDAO;
import com.hotel.dao.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("email");  
	    String p=request.getParameter("pass");  
	      
	    HttpSession session = request.getSession(false);
	    if(session!=null)
	    	session.setAttribute("name", n);
	    if(LoginDAO.validate(n, p) == true){   
	    	String inp=request.getParameter("email");
			GuestDAO dao = new GuestDAO();
			List<Guest> guestlist= dao.getGuest(inp);
			request.setAttribute("result",  guestlist);
			//getServletContext().getRequestDispatcher("/test.html").forward(request, response);
	    }  
	    else if(EmpLoginDAO.validate(n, p) == true){   
	    	String inp=request.getParameter("email");
			EmployeeDAO emp = new EmployeeDAO();
			List<Employee> emplist= emp.getEmp(inp);
			//String job = "select job_type from employee where email=?";
			request.setAttribute("result",  emplist);
			/**if (job == "Manager") {
				//set to go to manager page w/ more permissions
				getServletContext().getRequestDispatcher("/EmpInfo.jsp").forward(request, response);
			}
			else {
				//set to go to regular employee page
				getServletContext().getRequestDispatcher("/EmpInfo.jsp").forward(request, response);
			} **/
			getServletContext().getRequestDispatcher("/EmpInfo.jsp").forward(request, response);
	    }  
	    else{  
	    	out.print("<p style=\"color:red\">Sorry username or password error</p>"); 
	    }  
	          
	    out.close();  
	    }  
	}
