
package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.CountrySelectionPage;

public class TC009_CheckOutTest extends ProjectSpecification {

	@BeforeTest
	public void setup() {

		excelfile = "Checkout_Contact_And_PaymentInfo";

	}

	 
	@Test(dataProvider = "getData")
	public void CheckOutValidation(String emailID, String phonenumber, String password, String cardnumber,
			String firstname, String lastname, String address, String city, String state, String zipcode)
			throws IOException {
		CountrySelectionPage countryPage = new CountrySelectionPage(driver);

		try {

			countryPage.UnitedStatesSelect().checkRedirectedToHomePage().clickOnAccountLink().clickOnSigninLink()
					.checkRedirectedToSignInPage().enterEmailID(emailID).enterPassword(password).clickOnSignInButton()
					.clickOnReturnToPreviousPage().clickOnMenuButton().clickOnBrands().clickOnSony()
					.clickOnSonyCameras().clickOnSonyAlphaMirrorlessCameras().clickOnSonyAlpha7().clickOnAddToCart()
					.checkProductIsAddedToCart().clickOnContinueShopping().clickOnCart().clickOnCheckOutButton()
					.clickOnContinueAsGuest().checkRedirectedToContactInfo().enterContactInfo(emailID, phonenumber)
					.clickOnContinueToPaymentInfo();

//Below Methods are not called due to Webpage shows some Network issue Error Message
//			.checkRedirectedToPaymentInfo().enterPaymentInfo(cardnumber,firstname,lastname,address,city,state,zipcode)
//			.clickOnPlaceYourOrderButton();
		} catch (Exception e) {
			String savedPath = getScreenShot("Screen_CheckOutTest");
			System.out.println("CheckOutTest is failed :Screenshot is captured and saved in " + savedPath);
			e.printStackTrace();
			System.out.println("Error Message is" + e.getMessage());
		}
	}
}
