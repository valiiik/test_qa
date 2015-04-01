package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import selenium.EventFiringWebDriverWrapper;

import java.util.concurrent.TimeUnit;

/**
 * Created by valik on 3/5/15.
 */
public class CompareProductSearch extends BasePage {

    private String productSearch;
    private String productCode;

    private static final By SEARCH_LOCATOR = By.id("head_search_input");
    private static final By PRICE_IN_SEARCH_PRODUCT = By.xpath("//td[@class='price_block']/div/div/span");

    private static final By SEARCH_CODE_FIRST_PRODUCT = By.xpath("//div[@class = 'product_code']");

    public CompareProductSearch(EventFiringWebDriverWrapper driver){
        super(driver);
        URL = "http://fotos.ua";
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void searchProduct(String search) {
        driver.findElement(SEARCH_LOCATOR).click();
        driver.findElement(SEARCH_LOCATOR).sendKeys(search + Keys.ENTER);
    }

    public String searchProductPrice(){
        productSearch = driver.findElement(PRICE_IN_SEARCH_PRODUCT).getAttribute("content");
        return productSearch;
    }

    public String searchCodeProduct() {
        productCode = driver.findElement(SEARCH_CODE_FIRST_PRODUCT).getText();
        return productCode;
    }
}
