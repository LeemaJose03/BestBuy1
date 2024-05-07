package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecification;

public class ShopByBrandPage extends ProjectSpecification {

	// Page factory to inspect element inside constructor
	@FindBy(linkText = "Sony cameras")
	private WebElement sonyCameras;

	@FindBy(linkText = "Sony Alpha mirrorless cameras")
	private WebElement sonyAlphaMirrorlessCameras;

	@FindBy(linkText = "Sony - Alpha 7 IV Full-frame Mirrorless Interchangeable Lens Camera with SEL2870 Lens - Black")
	private WebElement sonyAlpha7;

	@FindBy(xpath = "(//button[@data-sku-id='6486185'])[1]")
	private WebElement addToCartButton;

	@FindBy(xpath = "//span[text()='Added to cart']")
	private WebElement addedToCartMessage;

	@FindBy(xpath = "//button[text()='Continue shopping']")
	private WebElement continueShopping;

	// Constructor
	public ShopByBrandPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to Click on Sony Cameras link and also validate the Title of the page
	public ShopByBrandPage clickOnSonyCameras() {
		clickabilityOfWebElement(sonyCameras, 10);
		sonyCameras.click();
		titleValidation("Sony Digital Cameras - Best Buy");
		return this;
	}

	// Method to Click on Sony Alpha MirrorLessCameras Link and also validate the
	// Title of the page
	public ShopByBrandPage clickOnSonyAlphaMirrorlessCameras() {
		clickabilityOfWebElement(sonyAlphaMirrorlessCameras, 10);
		clickOnElement(sonyAlphaMirrorlessCameras);
		titleValidation("Sony Mirrorless Cameras: Alpha Mirrorless - Best Buy");
		return this;
	}

	// Method to Click on Sony Alpha 7 Link and also validate the Title of the page
	public ShopByBrandPage clickOnSonyAlpha7() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		clickabilityOfWebElement(sonyAlpha7, 5);
		clickOnElement(sonyAlpha7);
		titleValidation(
				"Sony Alpha 7 IV Full-frame Mirrorless Interchangeable Lens Camera with SEL2870 Lens Black ILCE7M4K/B - Best Buy");
		return this;
	}

	// Method to Click on Add to Cart button
	public ShopByBrandPage clickOnAddToCart() {
		scrollThePage(1050);
		clickabilityOfWebElement(addToCartButton, 10);
		clickOnElement(addToCartButton);
		return this;

	}

	// Method to Validate the Product is added to cart
	public ShopByBrandPage checkProductIsAddedToCart() {
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
