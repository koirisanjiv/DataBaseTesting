package DatabaseTesting;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatabaseTestingPage {

	public WebDriver driver;
	public Faker faker = new Faker();
	
	@Test(priority =1)
	public void test_DataBase() throws InterruptedException {
		// TODO Auto-generated method 
		
		WebDriverManager.chromedriver().setup();
		driver  = new ChromeDriver();
		
		String  fname = faker.name().firstName();
		String  lname = faker.name().lastName();
		String 	email = faker.internet().emailAddress();
		String  phonenumber = faker.phoneNumber().cellPhone();
		String  password = faker.internet().password(8, 9, true);
		String  conpassword = password;
		
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
	
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(phonenumber);
	
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(conpassword);
		
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.getCurrentUrl();
		
			if(driver.getPageSource().contains("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
				System.out.println("Login successfull...");
			}
			else
			{
				Assert.assertTrue(false);
				System.out.println("Login Failed!!!");
			}
	
	driver.close();
	
	}
}
