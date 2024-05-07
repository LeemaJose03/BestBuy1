
package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.CountrySelectionPage;

public class TC003_Signin_ValidDetailsTest extends ProjectSpecification {

	@BeforeTest
	public void setup() {

		excelfile = "Signin_ValidDetails";

	}

	@Test(dataProvider = "getData")

	public void SigninValidation(String EmailID, String Password) throws IOException {
		CountrySelectionPage countryPage = new CountrySelectionPage(driver);

		try {

			countryPage.UnitedStatesSelect().checkRedirectedToHomePage().clickOnAccountLink().clickOnSigninLink().checkRedirectedToSignInPage()
					.enterEmailID(EmailID).enterPassword(Password).clickOnSignInButton().clickOnReturnToPreviousPage();

		} catch (Exception e) {
			String savedPath = getScreenShot("Screen_Signin_ValidDetailsTest");
			System.out.println("Signin_ValidDetailsTest is failed :Screenshot is captured and saved in " + savedPath);
			e.printStackTrace();
		}
	}
}
