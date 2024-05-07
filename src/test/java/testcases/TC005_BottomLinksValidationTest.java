
package testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.CountrySelectionPage;

public class TC005_BottomLinksValidationTest extends ProjectSpecification {

	@Parameters({ "emailID", "password" })
	@Test
	public void BottomLinksValidation(String emailID, String password) throws IOException {
		CountrySelectionPage countryPage = new CountrySelectionPage(driver);

		try {
			countryPage.UnitedStatesSelect().checkRedirectedToHomePage().clickOnAccountLink().clickOnSigninLink().checkRedirectedToSignInPage()
					.enterEmailID(emailID).enterPassword(password).clickOnSignInButton().clickOnReturnToPreviousPage()
					.clickOnAccessibility().navigateToTermsAndConditions().navigateToPrivacy()
					.navigateToInterestBasedAds().navigateToStatePrivacyRights().navigateToHealthDataPrivacy();

		} catch (Exception e) {
			String savedPath = getScreenShot("Screen_BottomLinksValidationTest");
			System.out.println("BottomLinksValidationTest is failed :Screenshot is captured and saved in " + savedPath);
			e.printStackTrace();
		}
	}
}
