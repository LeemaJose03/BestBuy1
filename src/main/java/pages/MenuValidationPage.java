package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class MenuValidationPage extends ProjectSpecification {

	// Page factory to inspect element inside constructor
	@FindBy(linkText = "Deal of the Day")
	private WebElement dealOfTheDayLink;

	@FindBy(linkText = "Yes, Best Buy Sells That")
	private WebElement yesBestBuySellsThatLink;

	@FindBy(linkText = "My Best Buy Memberships")
	private WebElement myBestBuyMembershipsLink;

	@FindBy(linkText = "Credit Cards")
	private WebElement creditCardsLink;

	@FindBy(linkText = "Gift Cards")
	private WebElement giftCardsLink;

	@FindBy(linkText = "Gift Ideas")
	private WebElement giftIdeasLink;

	// Constructor
	public MenuValidationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Method to Click on Deal of the Day Link
	public MenuValidationPage navigateToDealOfTheDay() {
		clickabilityOfWebElement(dealOfTheDayLink, 10);
		clickOnElement(dealOfTheDayLink);
		titleValidation("Deal of the Day: Electronics Deals - Best Buy");
		return this;
	}

	// Method to click on BestBuySellsThat Link
	public MenuValidationPage navigateToBestBuySellsThat() {
		clickabilityOfWebElement(yesBestBuySellsThatLink, 10);
		clickOnElement(yesBestBuySellsThatLink);
		titleValidation("Yes, Best Buy Sells That – Best Buy");
		return this;
	}

	// Method to Click on BestBuyMemeberships Link
	public MenuValidationPage navigateToBestBuyMemberships() {
		clickabilityOfWebElement(myBestBuyMembershipsLink, 10);
		clickOnElement(myBestBuyMembershipsLink);
		titleValidation("My Best Buy Memberships");
		return this;
	}

	// Method to Click on Credit Cards Link
	public MenuValidationPage navigateToCreditCards() {
		clickabilityOfWebElement(creditCardsLink, 10);
		clickOnElement(creditCardsLink);
		titleValidation("Best Buy Credit Card: Rewards & Financing");
		return this;
	}

	// Method to Click on Gift Cards Link
	public MenuValidationPage navigateToGiftCards() {
		clickabilityOfWebElement(giftCardsLink, 10);
		giftCardsLink.click();
		titleValidation("Gifts Cards and E-Gift Cards - Best Buy");
		return this;
	}

	// Method to Click on Gift Ideas Link
	public MenuValidationPage navigateToGiftIdeas() {
		clickabilityOfWebElement(giftIdeasLink, 10);
		clickOnElement(giftIdeasLink);
		titleValidation("Gift Ideas 2024: Best Gifts to Give This Year - Best Buy");
		return this;
	}

}
