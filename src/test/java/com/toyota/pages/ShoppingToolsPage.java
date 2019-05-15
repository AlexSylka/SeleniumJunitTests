package com.toyota.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingToolsPage extends BasePage {

    @FindBy(xpath = "//li[@class='shopping-tools-li']//button")
    private WebElement shoppingToolsLink;

    @FindBy(css = "a[data-di-id=\"#/request-a-quote/\"]")
    private WebElement requestQuoteLink;

    public ShoppingToolsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickShoppingToolsLink() {
        shoppingToolsLink.click();
    }

    public void clickRequestQuoteLink() {
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.elementToBeClickable(requestQuoteLink));
        requestQuoteLink.click();
    }

}
