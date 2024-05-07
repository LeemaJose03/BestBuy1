package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecification;

public class SignupPage extends ProjectSpecification {

	// Page factory to inspect element inside constructor

	@FindBy(id = "account-menu-account-button")
	private WebElement accountLink;

	@FindBy(xpath = "//a[text()='Create Account']")
	private WebElement createAccountLink;

	@FindBy(id = "firstName")
	private WebElement firstNameField;

	@FindBy(id = "lastName")
	private WebElement lastNameField;

	@FindBy(id = "email")
	private WebElement emailIDField;

	@FindBy(id = "fld-p1")
	private WebElement passwordField;

	@FindBy(id = "reenterPassword")
	private WebElement confirmPasswordField;

	@FindBy(id = "phone")
	private WebElement mobileNumberField;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement createAccountButton;

	@FindBy(xpath = "//p[text()='Please enter a valid email address.']")
	private WebElement invalidEmailErrorMessage;

	@FindBy(xpath = "//p[text()='Please enter a strong password.']")
	private WebElement invalidPasswordErrorMessage;

	@FindBy(xpath = "//p[text()='Passwords do not match.']")
	private WebElement invalidConfirmpasswordErrorMessage;

	@FindBy(xpath = "//p[text()='Please enter a valid mobile phone number.']")
	private WebElement invalidMobilenumberErrorMessage;

//	@FindBy(xpath="//strong[text()='An account with this email already exists.']")
//	private WebElement alreadyExistEmailErrorMessage;

	@FindBy(xpath = "//strong[text()='Sorry, there was a problem creating your account.']")
	private WebElement alreadyExistEmailErrorMessage;

	@FindBy(xpath = "//p[text()='Please enter your first name.']")
	private WebElement emptyFirstnameErrorMessage;

	@FindBy(xpath = "//p[text()='Please enter your last name.']")
	private WebElement emptyLastnameErrorMessage;

	@FindBy(linkText = "Return to previous page")
	private WebElement returnToPreviousPageLink;

	// Constructor
	public SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Method to Validate the Title of Create an Account page
	public SignupPage checkRedirectedToSignupPage() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Best Buy: Create an Account";
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Redirected to Create an Account page");
		return this;
	}

	// Mehtod to enter the First name
	public SignupPage enterFirstName(String Firstname) {
		clickabilityOfWebElement(firstNameField, 10);
		firstNameField.sendKeys(Firstname);
		return this;
	}

	// Method to enter the Last name
	public SignupPage enterLastName(String Lastname) {
		clickabilityOfWebElement(lastNameField, 10);
		lastNameField.sendKeys(Lastname);
		return this;
	}

	// Method to enter the Email Address
	public SignupPage enterEmailID(String EmailID) {
		clickabilityOfWebElement(emailIDField, 10);
		emailIDField.sendKeys(EmailID);
		return this;
	}

	// Method to enter the password
	public SignupPage enterPassword(String Password) {
		clickabilityOfWebElement(passwordField, 10);
		passwordField.sendKeys(Password);
		return this;
	}

	// Method to enter the Confirm password
	public SignupPage enterConfirmPassword(String Confirmpassword) {
		clickabilityOfWebElement(confirmPasswordField, 10);
		confirmPasswordField.sendKeys(Confirmpassword);
		return this;
	}

	// Method to enter the Mobile number
	public SignupPage enterMobileNumber(String Mobilenumber) {
		clickabilityOfWebElement(mobileNumberField, 10);
		mobileNumberField.sendKeys(Mobilenumber);
		return this;
	}

	// Method to click on Create an Account button
	public SignupPage clickOnCreateAccountButton() {
		clickabilityOfWebElement(createAccountButton, 10);
		createAccountButton.submit();
		return this;
	}

	// Method to click on Return to previous page Link
	public SignupPage clickOnReturnToPreviousPage() {
		clickabilityOfWebElement(returnToPreviousPageLink, 10);
		clickOnElement(returnToPreviousPageLink);
		return this;
	}

	// Method to Validate different Invalid scenarios of Signup in the Create an
	// account page
	public SignupPage invalidSignUpCheck(String scenario) {

		if (scenario.equals("InvalidEmail")) {
			System.out.println("Invalid scenarios for 'Signup' are  validated below ");
			checkErrorMessage(scenario, invalidEmailErrorMessage, "Please enter a valid email address.");
		} else if (scenario.equals("InvalidPassword")) {
			checkErrorMessage(scenario, invalidPasswordErrorMessage, "Please enter a strong password.");
		} else if (scenario.equals("InvalidConfirmpassword")) {
			checkErrorMessage(scenario, invalidConfirmpasswordErrorMessage, "Passwords do not match.");
		} else if (scenario.equals("InvalidMobilenumber")) {
			checkErrorMessage(scenario, invalidMobilenumberErrorMessage, "Please enter a valid mobile phone number.");
		} else if (scenario.equals("ExisitingEmail")) {
			// checkErrorMessage(scenario,alreadyExistEmailErrorMessage,"An account with
			// this email already exists.");
			checkErrorMessage(scenario, alreadyExistEmailErrorMessage,
					"Sorry, there was a problem creating your account.");
		} else if (scenario.equals("EmptyFirstname")) {
			checkErrorMessage(scenario, emptyFirstnameErrorMessage, "Please enter your first name.");
		} else if (scenario.equals("EmptyLastname")) {
			checkErrorMessage(scenario, emptyLastnameErrorMessage, "Please enter your last name.");

		}
		return this;
	}

}
