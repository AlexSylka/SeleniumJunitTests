package com.toyota.pages;

import com.toyota.sections.ContactInformationSection;
import com.toyota.sections.VehicleSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestQuotePage extends BasePage {

    private VehicleSection vehicleSection;

    private ContactInformationSection contactInformationSection;

    @FindBy(className = "raq-add-comments-btn")
    private WebElement addCommentBtn;

    @FindBy(className = "submit-button")
    private WebElement submitBtn;

    @FindBy(name = "comments")
    private WebElement commentsTextArea;

    public VehicleSection getVehicleSection() {
        return vehicleSection;
    }

    public ContactInformationSection getContactInformationSection() {
        return contactInformationSection;
    }

    public RequestQuotePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.vehicleSection = new VehicleSection(webDriver);
        this.contactInformationSection = new ContactInformationSection(webDriver);

        PageFactory.initElements(webDriver, this);
    }

    public void addComment(String comment){
        addCommentBtn.click();
        commentsTextArea.sendKeys(comment);
    }

    public void submitPage(){
        submitBtn.click();
    }




}
