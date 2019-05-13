package com.toyota.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingToolsPage extends BasePage {

    @FindBy(xpath = "//li[@class='shopping-tools-li']//button")
    private WebElement shoppingToolsLink;

    @FindBy(css = "a[data-di-id=\"#/request-a-quote/\"]")
    private WebElement requestQuoteLink;

    public ShoppingToolsPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void clickShoppingToolsLinkLink() {
        shoppingToolsLink.click();
    }

    public void clickRequestQuoteLinkLink() {
        requestQuoteLink.click();
    }

}
