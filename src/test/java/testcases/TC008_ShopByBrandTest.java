
package testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.CountrySelectionPage;

public class TC008_ShopByBrandTest extends ProjectSpecification {

	@Parameters({ "emailID", "password" })
	@Test
	public void ShopByBrand(String emailID, String password) throws IOException {
		CountrySelectionPage countryPage = new CountrySelectionPage(driver);

		try {
			countryPage.UnitedStatesSelect().checkRedirectedToHomePage().clickOnAccountLink().clickOnSigninLink().checkRedirectedToSignInPage()
					.enterEmailID(emailID).enterPassword(password).clickOnSignInButton().clickOnReturnToPreviousPage()
					.clickOnMenuButton().clickOnBrands().clickOnSony().clickOnSonyCameras()
					.clickOnSonyAlphaMirrorlessCameras().clickOnSonyAlpha7().clickOnAddToCart()
					.checkProductIsAddedToCart().clickOnContinueShopping();

		} catch (Exception e) {
			String savedPath = getScreenShot("Screen_ShopByBrandTest");
			System.out.println("ShopByBrandTest is failed :Screenshot is captured and saved in " + savedPath);
			e.printStackTrace();
		}
	}
}
