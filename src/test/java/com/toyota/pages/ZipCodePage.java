package com.toyota.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZipCodePage extends BasePage {

    @FindBy(css = "input[data-di-id=\"#tcom-zipcode-changer-input-sub-tablet\"]")
    private WebElement zipCodeInput;

    @FindBy(className = "tcom-submit")
    private WebElement submitZipButton;

    public ZipCodePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void enterZipCode(String zip){
        zipCodeInput.sendKeys(zip);
    }

    public void submitZipCode(){
        submitZipButton.click();
    }

    public boolean isVisible() {
        return zipCodeInput.isDisplayed();
    }

}
