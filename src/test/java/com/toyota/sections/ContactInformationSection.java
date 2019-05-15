package com.toyota.sections;

import com.toyota.entities.ContactInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationSection extends BaseSection {

    @FindBy(className = "raq-name-fields")
    private WebElement nameFieldsContainer;

    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    @FindBy(name = "emailAddress")
    private WebElement emailInput;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    @FindBy(name = "address1")
    private WebElement addressInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    public ContactInformationSection(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void fillContactInformation(ContactInformation contactInformation) {
        Actions action = new Actions(webDriver);
        action.moveToElement(nameFieldsContainer).perform();
        nameFieldsContainer.click();
        firstNameInput.sendKeys(contactInformation.getFirstName());
        lastNameInput.sendKeys(contactInformation.getLastName());
        emailInput.sendKeys(contactInformation.getEmail());
        phoneInput.sendKeys(contactInformation.getPhone());
        addressInput.sendKeys(contactInformation.getAddress());
        cityInput.sendKeys(contactInformation.getCity());
    }
}
