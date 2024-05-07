
package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.CountrySelectionPage;

public class TC002_CountrySelectionTest extends ProjectSpecification {

	@Test
	public void UnitedStatesCountrySelection() throws IOException {
		CountrySelectionPage countryPage = new CountrySelectionPage(driver);

		try {

			countryPage.UnitedStatesSelect().checkRedirectedToHomePage();

		} catch (Exception e) {
			String savedPath = getScreenShot("Screen_UnitedStatesCountrypage");
			System.out.println(
					"UnitedStatesCountry page test is failed :Screenshot is captured and saved in " + savedPath);
			e.printStackTrace();
		}
	}
}
