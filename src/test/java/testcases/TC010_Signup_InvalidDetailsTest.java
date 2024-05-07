
package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.CountrySelectionPage;
import pages.HomePage;

public class TC010_Signup_InvalidDetailsTest extends ProjectSpecification {

	@BeforeTest
	public void setup() {

		excelfile = "Signup_InvalidDetails";

	}

	@Test(priority = 1, dataProvider = "getData")

	public void Signup_InvalidDetails(String Firstname, String Lastname, String EmailID, String Password,
									String Confirmpassword, String Mobilenumber, String scenario) throws IOException {
		CountrySelectionPage countryPage = new CountrySelectionPage(driver);

		try {

			countryPage.UnitedStatesSelect().checkRedirectedToHomePage().clickOnAccountLink().clickOnCreateAccountLink().enterFirstName(Firstname).enterLastName(Lastname)
					.enterEmailID(EmailID).enterPassword(Password).enterConfirmPassword(Confirmpassword)
					.enterMobileNumber(Mobilenumber).clickOnCreateAccountButton().invalidSignUpCheck(scenario)
					.clickOnReturnToPreviousPage();

		} catch (Exception e) {
			String savedPath = getScreenShot("Screen_Signup_InvalidDetailsTest");
			System.out.println("Signup_InvalidDetailstest is failed :Screenshot is captured and saved in " + savedPath);
			e.printStackTrace();
		}
	}
}
