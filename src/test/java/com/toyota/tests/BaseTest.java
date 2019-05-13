package com.toyota.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private Properties prop;
    protected WebDriver driver;
    protected String siteUrl;

    public BaseTest(){
        loadProperties();
    }

    @Before
    public void setUp() {
       initDriver();
       initSiteUrl();
    }

    @After
    public void tearDown() {
    }

    private void initSiteUrl() {
        this.siteUrl = prop.getProperty("url");
    }

    private void initDriver() {
        String browser = prop.getProperty("browser");
        long implicitWait = Integer.parseInt(prop.getProperty("implicitWaitInSeconds"));
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", prop.getProperty("macChromeDriver"));
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new WebDriverException();
        }
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    private void  loadProperties() {
        prop = new Properties();
        try {
            prop.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
