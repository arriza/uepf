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
 * Servlet implementation class LizentziaEskatu
 */
@WebServlet("/LizentziaEskatu")
public class LizentziaEskatuServlet extends HttpServlet {
	private MySQLdb mySQLdb;
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() LizentziaEskatuServlet");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() LizentziaEskatuServlet");
	}

	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	            System.out.println("---> Entering doGet() LizentziaEskatuServlet");
	        		
	            doPost(request, response);
	            	
	            System.out.println("---> Exiting doGet() LizentziaEskatuServlet");
	        }

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("---> Entering doPost() LizentziaEskatuServlet");
	    	
			
			String nan = request.getParameter("nan");			
			String mota="lizentzia";
			String value=nan;
			String password=request.getParameter("password");
			System.out.println("     Extracting request parameters: "+nan);
			
			mySQLdb.setLicenseCode(nan);;
			System.out.println("     Updating users table in the database");
			
			
			if(mySQLdb.erabiltzaileaOndoEguneratuDa(mota, value, nan, password)!=false){
				System.out.println("     Updating users table in the database");
				
				System.out.println("     Redirecting the user to Aukerak.jsp");
				request.setAttribute("mota", mota);
				request.setAttribute("nan", nan);
				request.setAttribute("password", password);
				request.getRequestDispatcher("/jsp/Aukerak.jsp").forward(request, response);
				
				}else{
					
					request.getRequestDispatcher("/html/Login.html").forward(request, response);
					
				}
			
	        System.out.println("---> Exiting doPost() LizentziaEskatuServlet");
		}
}
