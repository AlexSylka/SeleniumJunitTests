package com.toyota.tests;

import com.toyota.entities.ContactInformation;
import com.toyota.entities.VehicleDetails;
import com.toyota.pages.RequestQuotePage;
import com.toyota.pages.ShoppingToolsPage;
import com.toyota.pages.ZipCodePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestQuoteTest extends BaseTest {

    private ShoppingToolsPage shoppingToolsPage;
    private RequestQuotePage requestQuotePage;
    private ZipCodePage zipCodePage;

    @Before
    public void init() {
        this.shoppingToolsPage = new ShoppingToolsPage(driver);
        this.requestQuotePage = new RequestQuotePage(driver);
        this.zipCodePage = new ZipCodePage(driver);
    }

    @Test
    public void testRequestQuote() throws InterruptedException {
        driver.get(siteUrl);
        shoppingToolsPage.clickShoppingToolsLink();
        shoppingToolsPage.clickRequestQuoteLink();
        if(zipCodePage.isVisible()) {
            zipCodePage.enterZipCode("73301");
            zipCodePage.submitZipCode();
        }

        VehicleDetails vehicleDetails = new VehicleDetails("2019 AVALON",
                "HYBRID XLE 2.5-LITER 4-CYLINDER ECVT HYBRID");
        requestQuotePage.getVehicleSection().selectVehicle(vehicleDetails);
        requestQuotePage.getContactInformationSection().fillContactInformation(buildContactInformationModel());
        requestQuotePage.addComment("test for Alex");
        requestQuotePage.submitPage();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".raq-confirmation")));
        Assert.assertTrue(driver.getPageSource().contains("Request Sent"));

    }

    private ContactInformation buildContactInformationModel() {
        ContactInformation contactInformation = new ContactInformation();
        contactInformation.setAddress("444 colin rd");
        contactInformation.setCity("houston");
        contactInformation.setEmail("qaguruonline@gmail.com");
        contactInformation.setFirstName("qa");
        contactInformation.setLastName("guru");
        contactInformation.setPhone("2142424242");
        return contactInformation;
    }

}
