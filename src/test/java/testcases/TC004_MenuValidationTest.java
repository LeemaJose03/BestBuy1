
package testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.CountrySelectionPage;

public class TC004_MenuValidationTest extends ProjectSpecification {

	@Parameters({ "emailID", "password" })
	@Test
	public void MenuItemsValidation(String emailID, String password) throws IOException {
		CountrySelectionPage countryPage = new CountrySelectionPage(driver);

		try {

			countryPage.UnitedStatesSelect().checkRedirectedToHomePage().clickOnAccountLink().clickOnSigninLink().checkRedirectedToSignInPage()
					.enterEmailID(emailID).enterPassword(password).clickOnSignInButton().clickOnReturnToPreviousPage()
					.clickOnTopDeals().navigateToDealOfTheDay().navigateToBestBuySellsThat()
					.navigateToBestBuyMemberships().navigateToCreditCards().navigateToGiftCards().navigateToGiftIdeas();

		} catch (Exception e) {
			String savedPath = getScreenShot("Screen_MenuValidationTest");
			System.out.println("MenuValidationTest is failed :Screenshot is captured and saved in " + savedPath);
			e.printStackTrace();
		}
	}
}
