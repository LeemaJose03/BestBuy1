
package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.CountrySelectionPage;
import pages.HomePage;

public class TC011_Signin_InvalidDetailsTest extends ProjectSpecification {

	@BeforeTest
	public void setup() {

		excelfile = "Signin_InvalidDetails";

	}

	@Test(priority = 1, dataProvider = "getData")

	public void Signin_InvalidDetails(String EmailID, String Password, String scenario) throws IOException {
		CountrySelectionPage countryPage = new CountrySelectionPage(driver);

		try {

			countryPage.UnitedStatesSelect().checkRedirectedToHomePage().clickOnAccountLink().clickOnSigninLink().checkRedirectedToSignInPage().enterEmailID(EmailID)
					.enterPassword(Password).clickOnSignInButton().SigninCheck(scenario).clickOnReturnToPreviousPage();

		} catch (Exception e) {
			String savedPath = getScreenShot("Screen_SigninTest_InvalidDetails");
			System.out.println("SigninTest_InvalidDetails is failed :Screenshot is captured and saved in " + savedPath);
			e.printStackTrace();
		}
	}
}
