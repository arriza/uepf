package helper.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLdb {
	private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root"; 
    private String passwd = "6KXoN6yuo58";
	private String driver = "com.mysql.jdbc.Driver";
	
    private Connection conn;
	
	public MySQLdb() {
		try {
        	Class.forName(this.driver).newInstance();
        	this.conn = DriverManager.getConnection(this.url,this.user,this.passwd);
    	} catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}

	public void setUserInfo(String izena, String abizena1, String abizena2, String nan, String helbidea, String postaKodea, String telefonoa, String jaioData, String email, String password, String username) {
		String query = "INSERT INTO uepf.users VALUES ('" + izena + "','" + abizena1 + "','" + abizena2 + "', '" + nan + "','" + helbidea + "','" + postaKodea + "','" + telefonoa + "','" + jaioData + "','" + email + "', '" + password + "', '" + username + "');";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = this.conn.createStatement();
	    	st.executeUpdate(query);  	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}
	
	public String getUserParameter(String nan, String password, String mota){
		String query = "SELECT "+mota+" FROM uepf.users WHERE NAN='" + nan + "' AND password='" + password + "';";
		System.out.println("     DB query: " + query);
		String erantzuna = null;
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	while(res.next()) {
	    		erantzuna = res.getString(mota);
        	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return erantzuna;
	}
	public void updateUserParameter(String nan, String password, String mota, String value){
		String query = "UPDATE uepf.users SET  "+mota+"='" + value + "' WHERE NAN='" + nan + "' AND password='" + password + "';";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = this.conn.createStatement();
	    	st.executeUpdate(query);  	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}
	public void updateUserPassword(String nan, String password, String newPassword){
		String query = "UPDATE uepf.users SET  password='" + newPassword + "' WHERE NAN='" + nan + "' AND password='" + password + "';";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = this.conn.createStatement();
	    	st.executeUpdate(query);  	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}
	
	public void updateUserInfo(String izena, String abizena, String abizena2, String nan, String helbidea, String postaKodea, String telefonoa, String jaioData, String email, String password, String username){
		String query = "UPDATE uepf.users SET izena='" + izena + "', abizena='" + abizena + "', abizena2='" + abizena2 + "', helbidea='" + helbidea + "', postaKodea='" + postaKodea + "', telefonoa='" + telefonoa + "', jaioData'" + jaioData + "', email='" + email + "', password='" + password + "', username='" + username + "' WHERE NAN='" + nan + "' AND password='" + password + "';";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = this.conn.createStatement();
	    	st.executeUpdate(query);  	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}
	public boolean erabiltzaileaOndoEguneratuDa(String mota, String value, String nan, String password){
		Boolean badago=false;
		String query = "SELECT username FROM uepf.users WHERE NAN='" + nan + "' AND password='" + password + "'AND '"+mota+"'='" + value + "';";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	if(res!=null){
	    		badago=true;
	    	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return badago;
	}
	
	public ResultSet getLizentziDatuak(String agindua ){
		//"SELECT izena,abizena,abizena2,helbidea,postakodea,nan, lizentzia FROM uepf.users WHERE NAN='"+nan+"'";
			System.out.println(agindua);
			ResultSet emaitza = null;
			try {
				Statement st = conn.createStatement();
				emaitza = st.executeQuery(agindua);
			} catch (Exception e) {
				 e.printStackTrace();
			}
			return emaitza;
		}
		
	
	public String getErabiltzaileIzena(String nan, String password) {
		String query = "SELECT username FROM uepf.users WHERE NAN='" + nan + "' AND password='" + password + "';";
		System.out.println("     DB query: " + query);
		String username = null;
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	while(res.next()) {
	    		username = res.getString("username");
        	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return username;
	}
	public void setLicenseCode(String nan) {
		String query = "UPDATE uepf.users SET  lizentzia='" + nan + "' WHERE NAN='" + nan + "' ;";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = this.conn.createStatement();
	    	st.executeUpdate(query);  	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}
	public String getIzena(String nan, String password) {
		String query = "SELECT izena FROM uepf.users WHERE NAN='" + nan + "' AND password='" + password + "';";
		System.out.println("     DB query: " + query);
		String izena = null;
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	while(res.next()) {
	    		izena = res.getString("izena");
        	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return izena;
	}
	public String getAbizena1(String nan, String password) {
		String query = "SELECT abizena1 FROM uepf.users WHERE NAN='" + nan + "' AND password='" + password + "';";
		System.out.println("     DB query: " + query);
		String abizena1 = null;
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	while(res.next()) {
	    		abizena1 = res.getString("abizena1");
        	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return abizena1;
	}
	public String getAbizena2(String nan, String password) {
		String query = "SELECT  abizena2 FROM uepf.users WHERE NAN='" + nan + "' AND password='" + password + "';";
		System.out.println("     DB query: " + query);
		String abizena2 = null;
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	while(res.next()) {
	    		abizena2 = res.getString("abizena2");
        	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return abizena2;
	}
	public String getHelbidea(String nan, String password) {
		String query = "SELECT helbidea FROM uepf.users WHERE NAN='" + nan + "' AND password='" + password + "';";
		System.out.println("     DB query: " + query);
		String helbidea = null;
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	while(res.next()) {
	    		helbidea = res.getString("helbidea");
        	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return helbidea;
	}
	public String getPostaKodea(String nan, String password) {
		String query = "SELECT postaKodea FROM uepf.users WHERE NAN='" + nan + "' AND password='" + password + "';";
		System.out.println("     DB query: " + query);
		String postaKodea = null;
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	while(res.next()) {
	    		postaKodea = res.getString("postaKodea");
        	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return postaKodea;
	}
	public String getNan(String nan, String password) {
		String query = "SELECT NAN FROM uepf.users WHERE NAN='" + nan + "' AND password='" + password + "';";
		System.out.println("     DB query: " + query);
		String nana = null;
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	while(res.next()) {
	    		nana = res.getString("NAN");
        	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return nana;
	}
	
	public String getJaioData(String nan, String password) {
		String query = "SELECT jaioData FROM uepf.users WHERE NAN='" + nan + "' AND password='" + password + "';";
		System.out.println("     DB query: " + query);
		String jaioData = null;
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	while(res.next()) {
	    		jaioData = res.getString("jaioData");
        	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return jaioData;
	}
	public String getLizentziaZBK(String nan, String password) {
		String query = "SELECT lizentzia FROM uepf.users WHERE NAN='" + nan + "' AND password='" + password + "';";
		System.out.println("     DB query: " + query);
		String lizentzia = null;
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	while(res.next()) {
	    		lizentzia = res.getString("lizentzia");
        	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return lizentzia;
	}

}
