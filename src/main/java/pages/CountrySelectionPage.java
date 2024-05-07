
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class CountrySelectionPage extends ProjectSpecification {

	// Page factory to inspect element inside constructor
	@FindBy(xpath = "(//a[@class='canada-link'])[1]")
	WebElement canadaCountry;

	@FindBy(xpath = "(//a[@class='us-link'])[1]")
	WebElement unitedStatesCountry;

	// Constructor
	public CountrySelectionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void canadaSelect() {
		visibiltiyOfWebElement(canadaCountry, 5);
		clickOnElement(canadaCountry);
	}

	// Method to select the UnitedStates country
	public CountrySelectionPage UnitedStatesSelect() {
		visibiltiyOfWebElement(unitedStatesCountry, 5);
		clickOnElement(unitedStatesCountry);
		return this;

	}

	public HomePage checkRedirectedToHomePage() {
		titleValidation("Best Buy | Official Online Store | Shop Now & Save");
		System.out.println("United States Country was selected successfully");
		return new HomePage(driver);
	}

}