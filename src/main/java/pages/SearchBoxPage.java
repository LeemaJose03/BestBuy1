package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecification;

public class SearchBoxPage extends ProjectSpecification {

	// Page factory to inspect element inside constructor
	@FindBy(xpath = "//a[text()='TCL - 75\" Class S4 S-Class 4K UHD HDR LED Smart TV with Google TV']")
	private WebElement productToClick;

	@FindBy(xpath = "//button[@aria-label='Pickup Ready Today Selected']")
	private WebElement pickupReadyButton;

	@FindBy(xpath = "(//button[@data-sku-id='6538122'])[1]")
	private WebElement addToCartButton;

	@FindBy(xpath = "//span[text()='Added to cart']")
	private WebElement addedToCartMessage;

	@FindBy(xpath = "//button[text()='Continue shopping']")
	private WebElement continueShopping;

	// Constructor
	public SearchBoxPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to Validate the Title of the Product page
	public SearchBoxPage checkRedirectedToProductPage() {
		titleValidation("TCL 75\" Class Q6 Q-Class 4K QLED HDR Smart TV with Google TV 75Q650G - Best Buy");
		System.out.println("Entered Product is Searched Correctly");
		return this;
	}

	// Method to Click on the product link
	public SearchBoxPage clickOnTheProduct() {
		clickabilityOfWebElement(productToClick, 10);
		clickOnElement(productToClick);
		Assert.assertTrue(driver.getTitle()
				.contains("TCL 75\" Class S4 S-Class 4K UHD HDR LED Smart TV with Google TV 75S450G - Best Buy"));
		System.out.println("Clicked on Given Product Link");
		return this;
	}

	// Method to Click on Add to Cart button
	public SearchBoxPage clickOnAddToCart() {
		scrollThePage(950);
		clickabilityOfWebElement(addToCartButton, 10);
		addToCartButton.click();
		return this;

	}

	// Method to Validate the Product is added to cart
	public SearchBoxPage checkProductIsAddedToCart() {
		visibiltiyOfWebElement(addedToCartMessage, 30);
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