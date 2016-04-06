package uepf;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	
	public void init(ServletConfig config) {
		System.out.println("---> Entering init() MainServlet");
		
		
		System.out.println("---> Exiting init() MainServlet");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            System.out.println("---> Entering doGet() MainServlet");
        		
            doPost(request, response);
            	
            System.out.println("---> Exiting doGet() MainServlet");
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---> Entering doPost() MainServlet");
    	
    	response.setHeader("Cache-Control", "no-cache");
    	System.out.println("------>   SarreraServleta deituko dugu");
    	if(request.getSession(false) == null) {
    		System.out.println("     User is not logged in");
    		
    		System.out.println("     Redirecting the user to sarrera.html");
			RequestDispatcher rd = request.getRequestDispatcher("/html/Sarrera.html");
			rd.forward(request, response);
		}
	}

}
