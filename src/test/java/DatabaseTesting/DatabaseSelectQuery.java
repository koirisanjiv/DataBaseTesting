package DatabaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatabaseSelectQuery {
	
public static void main(String[] args) throws SQLException{
		
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver  = new ChromeDriver();
	Connection con = null;

	
	//========================== Data Base===============//
		try
		{
			//Step1
			// TODO Auto-generated method stub
		    String url = "jdbc:mysql://localhost:3306/databasetesting";
	        String username = "root";
	        String password = "root";
			con = DriverManager.getConnection(url,username,password);
			
			// check connection is done or not
			if(!con.isClosed())
			{
				System.out.println("Connection is successfull...");
			}
			else
			{
				System.out.println("Connection is failed!!!");
			}
			// Step2
			Statement stm = con.createStatement();
			
			// Step3
			String s = "select * from users";
			
			// Step4
			ResultSet rs = stm.executeQuery(s);
			
			while(rs.next())
			{
				String user_id = rs.getString("username");
				String user_pwd = rs.getString("userpassword");
				System.out.println("UserName: "+user_id+"     "+"UserPassword: "+user_pwd);

				
				driver.get("https://demo.guru99.com/test/newtours/index.php");
				
				driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(user_id);
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys(user_pwd);
				driver.findElement(By.xpath("//input[@name='submit']")).click();
				
				driver.getCurrentUrl();

				if(driver.getPageSource().contains("Login Successfully")) {
					System.out.println("Login done");
					
				}
				else
				{
					System.out.println("Login failed");
				}
			}
		}
		catch(Exception e)
		{
			e.getCause();
			//e.getMessage();
			//e.getStackTrace();
		}
		finally
		{
			//Step5
			con.close();
			if(con.isClosed())
			{
				System.out.println("Connection closed successfully...");
			}
			else
			{
				System.out.println("Connection not closed!!!");
			}
		}
		
		
		driver.close();
		System.out.println("Driver closed Successfully...");

	}

}
