package model;
import java.sql.*;
import java.util.ArrayList;

public class Connexion 
{
	public Connection conn;
    public Statement stmt;
    public Statement stmt1;
    public ResultSet rset;
    public ResultSet rset1;
    public PreparedStatement pstmt;
    
    public Connexion() throws SQLException, ClassNotFoundException {
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        String urlDatabase = "jdbc:mysql://localhost/ecole";

        //création d'une connexion JDBC à la base 
        conn = DriverManager.getConnection(urlDatabase,"root", "");

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
        stmt1 = conn.createStatement();
        
        
        System.out.println("Connexion �tablie");
    }

	public ResultSet prepareStatement(String string) 
	{
		// TODO Auto-generated method stub
		return rset;
	}

	
    
	



	
    
    
}
