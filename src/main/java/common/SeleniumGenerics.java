package common;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class SeleniumGenerics {


	public static SoftAssert sa;
	public static HashMap<String, String> hmap = new HashMap<String, String>();

	public WebDriver openBrowser(String browserName, String url) 
	{
		WebDriver driver = null;

		if(browserName.equalsIgnoreCase("CHROME"))
		{
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("EDGE"))
		{
			driver = new EdgeDriver();
		}else 
		{
			System.out.println("Please enter only chrome and edge");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));

		driver.get(url);
		return driver;
	}


	public void closeBrowser(WebDriver driver) 
	{
		driver.close();
		PrintUtills.logMsg("Browser is Closed");

	}
	
	public void quitBrowser(WebDriver driver) 
	{
		driver.quit();
		PrintUtills.logMsg("Browser is quited");

	}

	public void refreshBrowser(WebDriver driver)
	{
		driver.navigate().refresh();
		PrintUtills.logMsg("Browser is refreshed");
	}

	public void backBrowser(WebDriver driver)
	{
		driver.navigate().back();
	}

	public void forwardBrowser(WebDriver driver)
	{
		driver.navigate().forward();
	}


	public String getBrowserTitle(WebDriver driver) {
		String actualTitle = driver.getTitle();
		PrintUtills.logMsg("Actual Title is " + actualTitle);
		return actualTitle;
	}

	public String getBrowserCurrentURL(WebDriver driver) {
		String actualURL = driver.getCurrentUrl();
		PrintUtills.logMsg("Actual current URL is " + actualURL);
		return actualURL;
	}

	//input - sendkeys, clear, getAttribute 

	public void enterText(WebElement ele, String dataToEnter) 
	{
		ele.sendKeys(dataToEnter);
		PrintUtills.logMsg("Value entered is :: " + dataToEnter);
	}

	public void clearText(WebElement ele) 
	{
		ele.clear();
		PrintUtills.logMsg("Text is cleared");
	}

	public String getDefaultInputText(WebElement ele) 
	{
		String actualValue = ele.getAttribute("value");
		PrintUtills.logMsg("Default Text from inputbox is :: "+ actualValue);
		return actualValue;
	}

	public void clickElement(WebElement ele) {

		ele.click();
		PrintUtills.logMsg("Element is clicked");
	}

	public String getElementText(WebElement ele) {

		String value = ele.getText();
		PrintUtills.logMsg("Actual Element text is  ::" +value);
		return value;
	}

	public void acceptAlert(WebDriver driver) 
	{
		Alert at = driver.switchTo().alert();
		at.accept();
		PrintUtills.logMsg("Alert is accepted");
	}

	public void selectDropdownByIndex(WebElement ele, int indexValue) 
	{
		Select st = new Select(ele);
		st.selectByIndex(indexValue);
		PrintUtills.logMsg("Dropdown value is selected by index :: "+ indexValue);
	}


	public void checkAssertAll() 
	{
		sa.assertAll();
	}
	
	

}
