package uepf;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.db.MySQLdb;

public class SignInServlet extends HttpServlet {
	private MySQLdb mySQLdb;
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() SignInServlet");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() SignInServlet");
	}

	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	            System.out.println("---> Entering doGet() SignInServlet");
	        		
	            doPost(request, response);
	            	
	            System.out.println("---> Exiting doGet() SignInServlet");
	        }

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("---> Entering doPost() SignInServlet");
	    	
			
			String nan = request.getParameter("nan");
			String password = request.getParameter("password");
			
			
			System.out.println("     Extracting request parameters: " +nan+", "+password   );
			
			if(mySQLdb.getErabiltzaileIzena(nan, password)!=null){
			System.out.println("     Updating users table in the database");
			
			System.out.println("     Redirecting the user to Aukerak.jsp");
			request.setAttribute("nan", nan);
			request.setAttribute("password", password);
			request.getRequestDispatcher("/jsp/Aukerak.jsp").forward(request, response);
			
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/html/Login.html");
				rd.forward(request, response);
			}
	        System.out.println("---> Exiting doPost() SignInServlet");
		}

}
