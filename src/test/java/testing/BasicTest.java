package testing;

import addons.ListenerThatHiglilightsElements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import selenium.EventFiringWebDriverWrapper;

import java.util.concurrent.TimeUnit;

/**
 * Created by valik on 3/2/15.
 */
public class BasicTest {
    public static EventFiringWebDriverWrapper driver;

    private static final By ENTER_CABINET = By.xpath("//div[@class='user_block']/a");
    private static final By ENTER_USER_NAME = By.xpath("//input[@type='email']");
    private static final By ENTER_USER_PASS = By.xpath("//input[@type='password']");
    private String email = "test_qa_valentyn@ukr.net";
    private String pass = "123456";


    @BeforeSuite
    public void initEnv(){
        WebDriver webDriver = new FirefoxDriver();
        driver = new EventFiringWebDriverWrapper(webDriver);
        driver.register(new ListenerThatHiglilightsElements("#FFFF00", 1, 200, TimeUnit.MILLISECONDS));

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterSuite(alwaysRun = true)
    public void envShut(){
        if(driver !=null)
            driver.quit();
    }

    public void loginUser(){
        driver.findElement(ENTER_CABINET).click();
        driver.findElement(ENTER_USER_NAME).click();
        driver.findElement(ENTER_USER_NAME).sendKeys(email + Keys.ENTER);
        driver.findElement(ENTER_USER_PASS).click();
        driver.findElement(ENTER_USER_PASS).sendKeys(pass + Keys.ENTER);

    }

}
