package uepf;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import helper.db.MySQLdb;



public class PdfServlet extends HttpServlet {
	private MySQLdb mySQLdb;
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() PdfServlet");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() PdfServlet");
	}

	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	            System.out.println("---> Entering doGet() PdfServlet");
	        		
	            doPost(request, response);
	            	
	            System.out.println("---> Exiting doGet() PdfServlet");
	        }

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("---> Entering doPost() PdfServlet");
	    	
			String lizentziaIzena="Lizentzia";
			String nan = request.getParameter("nan");
			String password = request.getParameter("password");			
			ServletOutputStream out = response.getOutputStream();
			response.setContentType("application/pdf");
			try {
			Document document = new Document();
			PdfWriter.getInstance(document, out);
			document.open();
			document.add(new Paragraph("LIZENTZIAREN ZIURTAGIRIA"));
			document.add(new Paragraph("Izena: " + mySQLdb.getIzena(nan, password)));
			document.add(new Paragraph("Abizenak: " + mySQLdb.getAbizena1(nan, password)+" "+ mySQLdb.getAbizena2(nan, password)));
			document.add(new Paragraph("NAN: " + mySQLdb.getJaioData(nan, password)));
			document.add(new Paragraph("Helbidea: " + mySQLdb.getHelbidea(nan, password)));
			document.add(new Paragraph("PostaKodea: " + mySQLdb.getPostaKodea(nan, password)));
			document.add(new Paragraph("NAN: " + mySQLdb.getNan(nan, password)));
			document.add(new Paragraph("Lizentzia Zbk: " + mySQLdb.getLizentziaZBK(nan, password)));
			document.close();
			} catch (Exception e) {
			System.out.println(e);
			}
			out.flush();
			out.close();
//			pdf.GenerarPDFEmpleados(lizentziaIzena, nan);
//			request.setAttribute("nan", nan);
//			request.setAttribute("password", password);
//			request.getRequestDispatcher("/jsp/Aukerak.jsp").forward(request, response);
	        System.out.println("---> Exiting doPost() PdfServlet");
		}

}
