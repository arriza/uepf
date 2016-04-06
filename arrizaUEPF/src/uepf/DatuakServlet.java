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

@WebServlet("/DatuakServlet")
public class DatuakServlet extends HttpServlet {
	private MySQLdb mySQLdb;
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() DatuakServlet");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() DataukServlet");
	}

	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	            System.out.println("---> Entering doGet() DatuakServlet");
	        		
	            doPost(request, response);
	            	
	            System.out.println("---> Exiting doGet() DatuakServlet");
	        }

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("---> Entering doPost() DatuakServlet");
	    	
			
			String nan = request.getParameter("nan");
			String password = request.getParameter("password");
			
			String izena=mySQLdb.getIzena(nan, password);
			System.out.println("izen ondo hartu da");
			String abizenak=mySQLdb.getAbizena1(nan, password)+" "+mySQLdb.getAbizena2(nan, password);
			System.out.println("abizenak ondo hartu da");
			String helbidea=mySQLdb.getHelbidea(nan, password);
			System.out.println("helbidea ondo hartu da");
			String postaKodea=mySQLdb.getPostaKodea(nan, password);
			System.out.println("posta kodea ondo hartu da");
			String jaioData=mySQLdb.getJaioData(nan, password);
			System.out.println("jaioData ondo hartu da");
			String username=mySQLdb.getErabiltzaileIzena(nan, password);
			System.out.println("username ondo hartu da");
			String mail=mySQLdb.getUserParameter(nan, password, "email");
			System.out.println("mail ondo hartu da");
			
			
			System.out.println("     Extracting request parameters: "  );
				
				request.setAttribute("nan", nan);
				request.setAttribute("password", password);
				request.setAttribute("izena", izena);
				request.setAttribute("abizenak", abizenak);
				request.setAttribute("helbidea", helbidea);
				request.setAttribute("postaKodea", postaKodea);
				request.setAttribute("jaioData", jaioData);
				request.setAttribute("username", username);
				request.setAttribute("mail", mail);
				request.getRequestDispatcher("/jsp/Datuak.jsp").forward(request, response);;
				
	        System.out.println("---> Exiting doPost() DatuakServlet");
		}

}
