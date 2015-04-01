package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import addons.LogForTest;
import addons.PropertyLoader;

import java.io.File;

/**
 * Created by valik on 3/11/15.
 */

public class WebDriverFactory {
        public static final String CHROME = "chrome";
        public static final String FIREFOX = "firefox";
        public static EventFiringWebDriverWrapper initDriver(String browserName)
        {
            WebDriver driver = null;
            if (browserName.equals(FIREFOX))
            {
                driver = new FirefoxDriver();
            } else
            if (browserName.equals(CHROME))
            {
                File file = new File(PropertyLoader.loadProperty("selenium.chrome.driver.path"));
                System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
                driver = new ChromeDriver();
            } else
                Assert.fail(LogForTest.error("WebDriver not defined"));
            EventFiringWebDriverWrapper driver1 = new EventFiringWebDriverWrapper(driver);
            return driver1;
        }
    }

