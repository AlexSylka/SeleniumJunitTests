package com.toyota.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestQuotePage extends BasePage {

    @FindBy(xpath = "//li[@class='shopping-tools-li']//button")
    private WebElement shoppingToolsLink;

    public RequestQuotePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


}
