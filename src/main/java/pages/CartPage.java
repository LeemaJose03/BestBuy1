package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class CartPage extends ProjectSpecification {

	// Page factory to inspect element inside constructor
	@FindBy(xpath = "//a[@title='Cart']")
	private WebElement cartLink;

	@FindBy(xpath = "(//input[@type='radio'])[1]")
	private WebElement pickupRadioButton;

	@FindBy(xpath = "//button[text()='Checkout']")
	private WebElement checkOutButton;

	@FindBy(xpath = "//button[@class='c-close-icon c-modal-close-icon']")
	private WebElement closeMembershipAd;

	// Constructor
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to Click on Cart link
	public CartPage clickOnCart() {
		clickabilityOfWebElement(cartLink, 10);
		clickOnElement(cartLink);
		titleValidation("Cart - Best Buy");
		return this;
	}

	// Method to close the BestBuy Membership Ad
	public CartPage closeBestBuyMembership() {
		visibiltiyOfWebElement(closeMembershipAd, 20);
		clickOnElement(closeMembershipAd);
		System.out.println("Closed the Membership ad on the Cart page");
		return this;
	}

	// Method to Click on Check out button
	public ContinueAsGuestPage clickOnCheckOutButton() {
		clickabilityOfWebElement(checkOutButton, 10);
		clickOnElement(checkOutButton);
		System.out.println("Check out button clicked successfully");
		return new ContinueAsGuestPage(driver);
	}

}
