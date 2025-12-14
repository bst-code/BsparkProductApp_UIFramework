package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginWithValidData {

	
	public void loginTest() {
		System.out.println("Login with valid data test executed.");
		WebDriver driver = new ChromeDriver();
		driver.get("https://example.com/login");
		driver.findElement(By.id("username")).sendKeys("validUser");
		driver.findElement(By.id("password")).sendKeys("validPassword");
		driver.findElement(By.id("loginButton")).click();
		driver.quit();
		
		
	}
}
