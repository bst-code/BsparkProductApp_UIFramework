package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.SeleniumGenerics;

public class ProductPage extends SeleniumGenerics {

	public ProductPage() {
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//button[text()='Add New Product']")
	WebElement addNewProductEle;
	
	public void clickAddNewProduct() 
	{
		clickElement(addNewProductEle);
	}
}
