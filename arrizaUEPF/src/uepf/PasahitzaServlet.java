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
 * Servlet implementation class EguneratuServlet
 */
@WebServlet("/EguneratuServlet")
public class PasahitzaServlet extends HttpServlet {
	private MySQLdb mySQLdb;
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() PasahitzaServlet");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() PasahitzaServlet");
	}

	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	            System.out.println("---> Entering doGet() PasahitzaServlet");
	        		
	            doPost(request, response);
	            	
	            System.out.println("---> Exiting doGet() PasahitzaServlet");
	        }

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("---> Entering doPost() PasahitzaServlet");
	    	
			String mota= "password";
			String nan = request.getParameter("nan");
			String password = request.getParameter("password");
			String password2 = request.getParameter("newPassword");
			
			
			System.out.println("     Extracting request parameters: " +nan+", "+password+","+password2   );
			
			mySQLdb.updateUserPassword(nan, password, password2);
			System.out.println("     Updating users table in the database");
			
			System.out.println("     Redirecting the user to Aukerak.jsp");
			if(mySQLdb.getErabiltzaileIzena(nan, password2)!=null){
				System.out.println("     Updating users table in the database");
				
				System.out.println("     Redirecting the user to Aukerak.jsp");
				
				request.setAttribute("mota", mota);
				request.setAttribute("nan", nan);
				request.setAttribute("password", password);
				request.getRequestDispatcher("/jsp/Aukerak.jsp").forward(request, response);
				
				}else{
					RequestDispatcher rd = request.getRequestDispatcher("/html/Login.html");
					rd.forward(request, response);
				}
			
	        System.out.println("---> Exiting doPost() PasahitzaServlet");
		}
}
