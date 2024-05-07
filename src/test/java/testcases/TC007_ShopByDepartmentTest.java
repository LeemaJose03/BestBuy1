
package testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.CountrySelectionPage;

public class TC007_ShopByDepartmentTest extends ProjectSpecification {

	@Parameters({ "emailID", "password" })
	@Test
	public void ShopByDepartment(String emailID, String password) throws IOException {
		CountrySelectionPage countryPage = new CountrySelectionPage(driver);

		try {

			countryPage.UnitedStatesSelect().checkRedirectedToHomePage().clickOnAccountLink().clickOnSigninLink().checkRedirectedToSignInPage()
					.enterEmailID(emailID).enterPassword(password).clickOnSignInButton().clickOnReturnToPreviousPage()
					.clickOnMenuButton().clickOnCellPhones().clickOnSamsungGalaxy().clickOnSamsungGalaxyASeries()
					.clickOnSeeDetails().clickOnAddToCart().checkProductIsAddedToCart().clickOnContinueShopping();

		} catch (Exception e) {
			String savedPath = getScreenShot("Screen_ShopByDepartmentTest");
			System.out.println("ShopByDepartmentTest is failed :Screenshot is captured and saved in " + savedPath);
			e.printStackTrace();
		}
	}
}
