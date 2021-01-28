package com.quinbay.qa.task.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BasePage {
    public static WebDriver driver;
    public  static JavascriptExecutor js;
    public static taskPage taskActions;



     static {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.get("http://cloud-control-app.infra-sg.cld/microTracker");
        js = (JavascriptExecutor)driver;
        taskActions=new taskPage(BasePage.driver);


    }
}
