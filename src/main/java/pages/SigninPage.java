package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class SigninPage extends ProjectSpecification{

	//Page factory to inspect element inside constructor
	@FindBy(id="account-menu-account-button")
	private WebElement accountLink;
	
	@FindBy(xpath="//a[contains(text(),'Sign In')]")
	private WebElement signInLink;
	
	@FindBy(xpath="//h1[text()='Sign In to Best Buy']")
	private WebElement signinText;
	
	@FindBy(id="fld-e")
	private WebElement emailField;
	
	@FindBy(id="fld-p1")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signInButton;
	
	@FindBy(xpath="//p[text()='Please enter a valid email address.']")
	private WebElement errorEmailIDMessage;
	
	@FindBy(xpath="//p[text()='Please enter your password.']")
	private WebElement errorPasswordMessage;
	
	@FindBy(xpath="//div[text()='Oops! The email or password did not match our records. Please try again.']")
	private WebElement invalidCredentialErrorMessage;
	
	@FindBy(xpath="//div[text()='Sorry, something went wrong. Please try again.']")
	private WebElement ErrorMessage;
	
	@FindBy(linkText="Return to previous page")
	private WebElement returnToPreviousPageLink;
	
	//Constructor
	public SigninPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
 
	//Method to Validate the Title of Sign in page
	public SigninPage checkRedirectedToSignInPage() {
		titleValidation("Sign In to Best Buy");
		return this;
	}
	
	//Method to enter the Email Address
	public SigninPage enterEmailID(String EmailID) {
		clickabilityOfWebElement(emailField,10);
		emailField.sendKeys(EmailID);
		return this;
	}
	
	//Method to enter the Password
	public SigninPage enterPassword(String Password) {
		clickabilityOfWebElement(passwordField,10);
		passwordField.sendKeys(Password);
		return this;
	}
	
	//Method to Click SignIn Button 
	public SigninPage clickOnSignInButton() {
		clickabilityOfWebElement(signInButton,10);
		clickOnElement(signInButton);
		return this;
	 
	}
 
	//Method to Click on Return to previous page link
	public HomePage clickOnReturnToPreviousPage() {
		clickabilityOfWebElement(returnToPreviousPageLink,10);
		clickOnElement(returnToPreviousPageLink);
		return new HomePage(driver);
	}
	
	//Method to Validate different Invalid scenarios for Signin in the SignIn Page
	public SigninPage SigninCheck(String scenario) {
		
		System.out.println("Invalid scenarios for Signin are validated below");
		
		if(scenario.equals("InvalidPassword")) {
			System.out.println("Invalid scenarios for 'Signin' are validated below");
			checkErrorMessage(scenario,ErrorMessage,"Sorry, something went wrong. Please try again.");
			//checkErrorMessage(scenario,validCredentialErrorMessage,"Oops! The email or password did not match our records. Please try again.");
			System.out.println("Entered Signin Credentials is Valid");
		}else if(scenario.equals("InvalidEmail")|| scenario.equals("EmptyEmail")) {
			checkErrorMessage(scenario,errorEmailIDMessage,"Please enter a valid email address.");
		}else if(scenario.equals("EmptyPassword")){
			checkErrorMessage(scenario,errorPasswordMessage,"Please enter your password.");
		} 
		return this;
	}
}
