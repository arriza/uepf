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


public class JspDeituServlet extends HttpServlet {
	private MySQLdb mySQLdb;
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() JspDeituServlet");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() JspDeituServlet");
	}

	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	            System.out.println("---> Entering doGet() JspDeituServlet");
	        		
	            doPost(request, response);
	            	
	            System.out.println("---> Exiting doGet() JspDeituServlet");
	        }

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("---> Entering doPost() JspDeituServlet");
	    	
			
			String nan = request.getParameter("nan");
			String password = request.getParameter("password");
			String mota = request.getParameter("eguneraketa");
			String value= request.getParameter("value");
			String izena=mySQLdb.getIzena(nan, password);
			String abizenak=mySQLdb.getAbizena1(nan, password)+" "+mySQLdb.getAbizena2(nan, password);
			String helbidea=mySQLdb.getHelbidea(nan, password);
			String postaKodea=mySQLdb.getPostaKodea(nan, password);
			String jaioData=mySQLdb.getJaioData(nan, password);
			String username=mySQLdb.getErabiltzaileIzena(nan, password);
			String mail=mySQLdb.getUserParameter(nan, password, "email");
			
			String valueZaharra=mySQLdb.getUserParameter(nan, password, mota);
			System.out.println("     Extracting request parameters: "+nan+", "+password+", "+mota  );
//			String aldagaia=null;
//			switch(mota){
//				case "izena":
//					aldagaia="Izen berria sartu";
//					break;
//				case "abizena":
//					aldagaia="Abizen berria sartu";
//					break;
//				case "abizena2":
//					aldagaia="Bigarren abizen berria sartu";
//					break;
//				case "helbidea":
//					aldagaia="Helbide berria sartu";
//					break;
//				case "postaKodea":
//					aldagaia="Posta kode berria sartu";
//					break;
//				case "jaioData":
//					aldagaia="Jaiotze data berria sartu";
//					break;
//				case "email":
//					aldagaia="Email berria sartu";
//					break;
//				case "Erabiltzaile izen berria sartu":
//					aldagaia="Erabiltzaile izen berria sartu";
//					break;
//			
//			}
				request.setAttribute("mota", mota);
				request.setAttribute("nan", nan);
				request.setAttribute("password", password);
				request.setAttribute("valueZaharra", valueZaharra);
				request.setAttribute("izena", izena);
				request.setAttribute("abizenak", abizenak);
				request.setAttribute("helbidea", helbidea);
				request.setAttribute("postaKodea", postaKodea);
				request.setAttribute("jaioData", jaioData);
				request.setAttribute("username", username);
				request.setAttribute("mail", mail);
				request.getRequestDispatcher("/jsp/Eguneraketak.jsp").forward(request, response);;
				
			
			
			
			if(mySQLdb.erabiltzaileaOndoEguneratuDa(mota, value, nan, password)!=false){
				System.out.println("     Updating users table in the database");
				
				System.out.println("     Redirecting the user to Aukerak.jsp");
				
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/Aukerak.jsp");
				rd.forward(request, response);
				}else{
					RequestDispatcher rd = request.getRequestDispatcher("/html/Login.html");
					rd.forward(request, response);
				}
			
	        System.out.println("---> Exiting doPost() JspDeituServlet");
		}

}
