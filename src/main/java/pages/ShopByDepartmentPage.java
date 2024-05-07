package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecification;

public class ShopByDepartmentPage extends ProjectSpecification {

	// Page factory to inspect element inside constructor
	@FindBy(xpath = "(//a[text()='See Details'])[1]")
	private WebElement seeDetailsLink;

	@FindBy(xpath = "//button[@aria-label='Pickup Ready Today Selected']")
	private WebElement pickupReady;

	@FindBy(xpath = "(//button[text()='Add to Cart'])[4]")
	private WebElement addToCartButton;

	@FindBy(xpath = "//span[text()='Added to cart']")
	private WebElement addedToCartMessage;

	@FindBy(xpath = "//button[text()='Continue shopping']")
	private WebElement continueShopping;

	// Constructor
	public ShopByDepartmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to Validate the Title of the Product page
	public ShopByDepartmentPage checkRedirectedToProductPage() {
		titleValidation("Samsung Galaxy A Series - Best Buy");
		return this;
	}

	// Method to Click on See details button
	public ShopByDepartmentPage clickOnSeeDetails() {
		scrollThePage(350);
		clickabilityOfWebElement(seeDetailsLink, 10);
		clickOnElement(seeDetailsLink);
		return this;

	}

	// Method to Click on Add to Cart button
	public ShopByDepartmentPage clickOnAddToCart() {
		scrollThePage(950);
		clickabilityOfWebElement(addToCartButton, 10);
		addToCartButton.click();
		return this;

	}

	// Method to Validate the Product is added to cart
	public ShopByDepartmentPage checkProductIsAddedToCart() {
		visibiltiyOfWebElement(addedToCartMessage, 10);
		Assert.assertTrue(addedToCartMessage.getText().contains("Added to cart"));
		System.out.println("Product is added to Cart Successfully");
		return this;
	}

	// Method to Click on Continue Shopping Link
	public CartPage clickOnContinueShopping() {
		visibiltiyOfWebElement(continueShopping, 10);
		clickOnElement(continueShopping);
		System.out.println("Clicked on Continue Shopping Link");
		return new CartPage(driver);
	}

}
