package com.toyota;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomSelect {

    private WebDriver driver;
    private String selectName;

    public CustomSelect(WebDriver driver, String selectName){
        this.driver = driver;
        this.selectName = selectName;
    }

    public void selectByVisibleText(String optionText) {
        waitSeconds(2);
        WebElement element = driver.findElement(By.xpath("//select[@name='" + selectName + "']/parent::div[contains(@class, 'tcom-select')]"));
        element.click();
        WebElement optionToSelect = driver.findElement(By.xpath("//select[@name='" + selectName + "']/following-sibling::ul/li[contains(.,'" + optionText + "')]"));
        optionToSelect.click();
    }

    private void waitSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
