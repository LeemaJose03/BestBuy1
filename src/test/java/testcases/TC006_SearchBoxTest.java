
package testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.CountrySelectionPage;

public class TC006_SearchBoxTest extends ProjectSpecification {

	@Parameters({ "emailID", "password", "product" })
	@Test
	public void SearchBox(String emailID, String password, String product) throws IOException {
		CountrySelectionPage countryPage = new CountrySelectionPage(driver);

		try {

			countryPage.UnitedStatesSelect().checkRedirectedToHomePage().clickOnAccountLink().clickOnSigninLink().checkRedirectedToSignInPage()
					.enterEmailID(emailID).enterPassword(password).clickOnSignInButton().clickOnReturnToPreviousPage()
					.clickOnSearchBox(product).clickOnTheProduct().clickOnAddToCart().checkProductIsAddedToCart()
					.clickOnContinueShopping();

		} catch (Exception e) {
			String savedPath = getScreenShot("Screen_SearchBoxTest");
			System.out.println("SearchBoxTest is failed :Screenshot is captured and saved in " + savedPath);
			e.printStackTrace();
		}
	}
}
