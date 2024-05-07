package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class BottomLinksValidationPage extends ProjectSpecification {

	// Page factory to inspect element inside constructor
	@FindBy(xpath = "//a[contains(text(),'Terms & Conditions')]")
	private WebElement termsAndConditionsLink;

	@FindBy(xpath = "//a[text()='Privacy']")
	private WebElement privacyLink;

	@FindBy(xpath = "//a[contains(text(),'Interest-Based Ads')]")
	private WebElement interestBasedAdsLink;

	@FindBy(xpath = "//a[contains(text(),'State Privacy Rights')]")
	private WebElement statePrivacyRightsLink;

	@FindBy(xpath = "//a[contains(text(),'Health Data Privacy')]")
	private WebElement healthDataPrivacyLink;

	// Constructor
	public BottomLinksValidationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Method to click Terms and Conditions link
	public BottomLinksValidationPage navigateToTermsAndConditions() {
		clickabilityOfWebElement(termsAndConditionsLink, 5);
		clickOnElement(termsAndConditionsLink);
		titleValidation("BestBuy.com Terms and Conditions");
		return this;
	}

	// Method to click Privacy link
	public BottomLinksValidationPage navigateToPrivacy() {
		clickabilityOfWebElement(privacyLink, 5);
		clickOnElement(privacyLink);
		titleValidation("Privacy Policy Hub - Best Buy");
		return this;
	}

	// Method to click Interest Based Ads link
	public BottomLinksValidationPage navigateToInterestBasedAds() {
		clickabilityOfWebElement(interestBasedAdsLink, 10);
		clickOnElement(interestBasedAdsLink);
		titleValidation("Interest-Based Ads - Best Buy");
		return this;
	}

	// Method to click State Privacy Rights link
	public BottomLinksValidationPage navigateToStatePrivacyRights() {
		clickabilityOfWebElement(statePrivacyRightsLink, 10);
		clickOnElement(statePrivacyRightsLink);
		titleValidation("State Privacy Rights - Best Buy");
		return this;
	}

	// Method to click Health Data Privacy link
	public BottomLinksValidationPage navigateToHealthDataPrivacy() {
		clickabilityOfWebElement(healthDataPrivacyLink, 10);
		clickOnElement(healthDataPrivacyLink);
		titleValidation("Health Data Privacy Information - Best Buy");
		return this;
	}

}
