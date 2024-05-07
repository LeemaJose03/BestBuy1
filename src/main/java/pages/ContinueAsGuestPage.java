package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class ContinueAsGuestPage extends ProjectSpecification{

	// Page factory to inspect element inside constructor
	@FindBy(xpath="//button[text()='Continue as Guest']")
	private WebElement continueAsGuest;
	
	
	
	//Constructor
	public ContinueAsGuestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	//Method to click Continue as Guest button 
	public CheckOutPage clickOnContinueAsGuest() {
		clickabilityOfWebElement(continueAsGuest,10);
		titleValidation("Sign In to Best Buy");
		clickOnElement(continueAsGuest);
		System.out.println("Continue as Guest button clicked successfully");
		return new CheckOutPage(driver);
		
	}
	
}
