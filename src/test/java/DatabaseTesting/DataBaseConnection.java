package DatabaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {

	public static void main(String[] args) throws SQLException{
		
		//Step1
	    String url = "jdbc:mysql://localhost:3306/databasetesting";
        String username = "root";// mysql data base username
        String password = "root"; // mysql data password name
		Connection con = DriverManager.getConnection(url,username,password);
		
		
		// Step2
		Statement stm = con.createStatement();
		
		// Step3
		String s = "Insert into users values('mngr508239','pebybam')";
		stm.executeUpdate(s);
		
		
		//Step4
		con.close();
		
		System.out.println("Program is exited");

	}
}
