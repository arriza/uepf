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

public class EguneraketaServlet extends HttpServlet {
	private MySQLdb mySQLdb;
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() EguneraketServlet");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() EguneraketaServlet");
	}

	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	            System.out.println("---> Entering doGet() EguneraketaServlet");
	        		
	            doPost(request, response);
	            	
	            System.out.println("---> Exiting doGet() EguneraketaServlet");
	        }

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("---> Entering doPost() EguneraketaServlet");
	    	
			String nan = request.getParameter("nan");
			String password = request.getParameter("password");
			String mota = request.getParameter("mota");
			String value= request.getParameter("value");;
			
			
			System.out.println("     Extracting request parameters: "+nan+", "+password+", "+mota+", "+value  );
			
			mySQLdb.updateUserParameter(nan, password, mota, value);
			System.out.println("     Updating users table in the database");
			
			
			if(mySQLdb.erabiltzaileaOndoEguneratuDa(mota, value, nan, password)!=false){
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
			
	        System.out.println("---> Exiting doPost() EguneraketaServlet");
		}

}
