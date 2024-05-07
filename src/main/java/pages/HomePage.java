package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class HomePage extends ProjectSpecification {

	// Page factory to inspect element inside constructor
	@FindBy(id = "account-menu-account-button")
	private WebElement accountLink;

	@FindBy(xpath = "//a[text()='Create Account']")
	private WebElement createAccountLink;

	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
	private WebElement signInLink;

	@FindBy(linkText = "Top Deals")
	private WebElement topDealsLink;

	@FindBy(xpath = "//a[contains(text(),'Accessibility')]")
	private WebElement accessibilityLink;

	@FindBy(xpath = "//input[@placeholder='What can we help you find today?']")
	private WebElement searchBox;

	@FindBy(xpath = "//button[text()='Menu']")
	private WebElement menuButton;

	@FindBy(xpath = "//button[text()='Brands']")
	private WebElement brands;

	@FindBy(linkText = "Sony")
	private WebElement sony;

	@FindBy(xpath = "//button[text()='Cell Phones']")
	private WebElement cellPhones;

	@FindBy(xpath = "//button[text()='Samsung Galaxy']")
	private WebElement samsungGalaxy;

	@FindBy(xpath = "//a[contains(text(),'Samsung Galaxy A Series')]")
	private WebElement samsungGalaxyASeries;

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to click the Account link on the home screen
	public HomePage clickOnAccountLink() {
		clickabilityOfWebElement(accountLink, 20);
		clickOnElement(accountLink);
		return this;
	}

	// Method to click the CreateAccount link on the home screen
	public SignupPage clickOnCreateAccountLink() {
		clickabilityOfWebElement(createAccountLink, 10);
		clickOnElement(createAccountLink);
		return new SignupPage(driver);
	}

	// Method to click Signin link on the home screen
	public SigninPage clickOnSigninLink() {
		clickabilityOfWebElement(signInLink, 10);
		clickOnElement(signInLink);
		return new SigninPage(driver);
	}

	// Method to click Top deals menu on the home screen
	public MenuValidationPage clickOnTopDeals() {
		clickabilityOfWebElement(topDealsLink, 10);
		clickOnElement(topDealsLink);
		titleValidation("Top Deals and Featured Offers on Electronics - Best Buy");
		return new MenuValidationPage(driver);

	}

	// Method to click Bottom link on the home screen
	public BottomLinksValidationPage clickOnAccessibility() {
		clickabilityOfWebElement(accessibilityLink, 5);
		clickOnElement(accessibilityLink);
		titleValidation("Accessibility - Best Buy");
		return new BottomLinksValidationPage(driver);

	}

	// Method to click the Search box on the home screen
	public SearchBoxPage clickOnSearchBox(String product) {
		System.out.println("Search by Search box and Add an item to Shopping cart is validated below:");
		clickabilityOfWebElement(searchBox, 10);
		searchBox.sendKeys(product);
		searchBox.sendKeys(Keys.RETURN);
		return new SearchBoxPage(driver);
	}

	// Method to click Menu button on the home screen
	public HomePage clickOnMenuButton() {
		clickabilityOfWebElement(menuButton, 10);
		clickOnElement(menuButton);
		return this;
	}

	// Method to click Brands on the home screen
	public HomePage clickOnBrands() {
		System.out.println("Shop by Brands and Add an item to Shopping cart is validated below:");
		visibiltiyOfWebElement(brands, 5);
		clickOnElement(brands);
		return this;
	}

	// Method to click Sony on the home screen
	public ShopByBrandPage clickOnSony() {
		visibiltiyOfWebElement(sony, 5);
		clickOnElement(sony);
		titleValidation("Sony Store: Sony Electronics & Entertainment - Best Buy");
		return new ShopByBrandPage(driver);
	}

	// Method to click Cell phones on the home screen
	public HomePage clickOnCellPhones() {
		System.out.println("Shop by Department and Add an item to Shopping cart is validated below");
		visibiltiyOfWebElement(cellPhones, 5);
		clickOnElement(cellPhones);
		return this;
	}

	// Method to click Samsung galaxy on the home screen
	public HomePage clickOnSamsungGalaxy() {
		visibiltiyOfWebElement(samsungGalaxy, 5);
		clickOnElement(samsungGalaxy);
		return this;
	}

	// Method to click Samsung galaxy A Series on the home screen
	public ShopByDepartmentPage clickOnSamsungGalaxyASeries() {
		visibiltiyOfWebElement(samsungGalaxyASeries, 5);
		clickOnElement(samsungGalaxyASeries);
		return new ShopByDepartmentPage(driver);
	}

}
