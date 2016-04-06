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

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private MySQLdb mySQLdb;
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() SignUpServlet");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() SignUpServlet");
	}

	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	            System.out.println("---> Entering doGet() SignUpServlet");
	        		
	            doPost(request, response);
	            	
	            System.out.println("---> Exiting doGet() SignUpServlet");
	        }

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("---> Entering doPost() SignUpServlet");
	    	
			String izena = request.getParameter("izena");
			String abizena1 = request.getParameter("abizena1");
			String abizena2 = request.getParameter("abizena2");
			String nan = request.getParameter("nan");
			String helbidea = request.getParameter("helbidea");
			String postaKodea = request.getParameter("postaKodea");
			String telefonoa = request.getParameter("telefonoa");
			String jaioData = request.getParameter("jaioData");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String username = request.getParameter("username");
			System.out.println("     Extracting request parameters: " +izena+ " " +abizena1+" " +abizena2+ " " +nan+ " " +helbidea+ " " +postaKodea+ " " +telefonoa+ " " +jaioData+ " " + email + " " + password + " " + username);
			
			mySQLdb.setUserInfo(izena, abizena1, abizena2, nan, helbidea, postaKodea, telefonoa, jaioData, email, password, username);
			System.out.println("     Updating users table in the database");
			
			System.out.println("     Redirecting the user to Login.html");
			RequestDispatcher rd = request.getRequestDispatcher("/html/Login.html");
			rd.forward(request, response);
	        System.out.println("---> Exiting doPost() SignUpServlet");
		}
}
