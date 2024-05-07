package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.ProjectSpecification;

public class CheckOutPage extends ProjectSpecification {

	// Page Factory used to inspect element
	@FindBy(id = "user.emailAddress")
	private WebElement emailIDField;

	@FindBy(id = "user.phone")
	private WebElement phoneNumberField;

	@FindBy(xpath = "//span[text()='Continue to Payment Information']")
	private WebElement continueToPaymentInfoButton;

	@FindBy(xpath = "//span[text()='Request failed because of network connection']")
	private WebElement networkIssueErrorMessage;

	@FindBy(xpath = "//span[text()='Payment Information']")
	private WebElement paymentInfoCheckMessage;

	@FindBy(id = "number")
	private WebElement cardNumberField;

	@FindBy(id = "first-name")
	private WebElement firstNameField;

	@FindBy(id = "last-name")
	private WebElement lastNameField;

	@FindBy(id = "address-input")
	private WebElement addressField;

	@FindBy(id = "city")
	private WebElement cityField;

	@FindBy(id = "state")
	private WebElement stateField;

	@FindBy(id = "postalCode")
	private WebElement zipCodeField;

	@FindBy(xpath = "//button[contains(@class,'btn btn-lg')]")
	private WebElement placeYourOrderButton;

	@FindBy(xpath = "//div[contains(text(), 'Oops, that's not a valid credit card number. Please double-check it and try again.')]")
	private WebElement notValidCreditCardErrorMessage;

	// Constructor
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Method to check the title of CheckOut page
	public CheckOutPage checkRedirectedToContactInfo() throws InterruptedException {

		Thread.sleep(10000);
		titleValidation("Checkout – Best Buy");
		return this;
	}

	// Method to enter the Contact information on the CheckOut page
	public CheckOutPage enterContactInfo(String emailID, String phonenumber) {
		scrollThePage(1500);
		clickabilityOfWebElement(emailIDField, 10);
		emailIDField.sendKeys(emailID);
		phoneNumberField.sendKeys(phonenumber);
		System.out.println("Contact Information were entered Successfully");
		return this;
	}

	// Method to click Continue to payment button on the Checkout page
	public CheckOutPage clickOnContinueToPaymentInfo() {
		clickOnElement(continueToPaymentInfoButton);
		if (networkIssueErrorMessage.isDisplayed()) {
			Assert.assertTrue(
					networkIssueErrorMessage.getText().equals("Request failed because of network connection"));
			System.out.println("Please Try again Due to Network connection issue");
		} else {
			System.out.println("Re-directed to Payment Information in CheckOut Page");
		}
		return this;
	}

	// Payment Information Methods
	public CheckOutPage checkRedirectedToPaymentInfo() {
		Assert.assertTrue(paymentInfoCheckMessage.getText().contains("Payment Information"));
		System.out.println("Re-directed to Payment Information in CheckOut Page Successfully");
		return this;
	}

	public CheckOutPage enterPaymentInfo(String cardnumber, String firstname, String lastname, String address,
			String city, String state, String zipcode) {
		clickabilityOfWebElement(cardNumberField, 5);
		cardNumberField.sendKeys(cardnumber);
		clickabilityOfWebElement(firstNameField, 5);
		firstNameField.sendKeys(firstname);
		clickabilityOfWebElement(lastNameField, 5);
		lastNameField.sendKeys(lastname);
		clickabilityOfWebElement(addressField, 5);
		addressField.sendKeys(address);
		clickabilityOfWebElement(cityField, 5);
		cityField.sendKeys(city);
		clickabilityOfWebElement(stateField, 5);
		Select select = new Select(stateField);
		select.selectByValue(state);
		clickabilityOfWebElement(zipCodeField, 5);
		zipCodeField.sendKeys(zipcode);
		System.out.println("Payment Information were entered Successfully");

		return this;
	}

	public CheckOutPage clickOnPlaceYourOrderButton() {
		clickabilityOfWebElement(placeYourOrderButton, 5);
		clickOnElement(placeYourOrderButton);
		if (notValidCreditCardErrorMessage.isDisplayed()) {
			Assert.assertTrue(notValidCreditCardErrorMessage.getText()
					.equals("Oops, that's not a valid credit card number. Please double-check it and try again."));
			System.out.println("Entered Credit card details is not Valid.,Please Try again");
		} else {
			System.out.println("Re-directed to Payment Page");
		}
		return this;
	}
}
