package pages;

import org.openqa.selenium.By;
import selenium.EventFiringWebDriverWrapper;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by valik on 3/11/15.
 */
public class CompareProductCart extends BasePage {


    private String productCash1;
    private String productCash2;
    private String productName1;
    private String productName2;

    private static final By GO_TO_SHOPCART = By.xpath("//div[@class='block_title']/a");
    private static final By FIRST_CASH_PRICE = By.id("request_price_3544108");
    private static final By SECOND_CASH_PRICE = By.id("request_price_3894451");

    private static final By FIRST_NAME_PRODUCT = By.xpath("//tr[@id='i_3544108']/td[3]/a");
    private static final By SECOND_NAME_PRODUCT = By.xpath("//tr[@id='i_3894451']/td[@class='bordertd valigntd']/a");

    public CompareProductCart(EventFiringWebDriverWrapper driver){
        super(driver);
        URL = "http://fotos.ua";
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void shopCart(){
        driver.findElement(GO_TO_SHOPCART).click();
    }

    public String cashProductPrice1(){
        productCash1=driver.findElement(FIRST_CASH_PRICE).getText();
        productCash1 = productCash1.replaceAll("[^0-9]+", "");
        return productCash1;
    }

    public String cashProductPrice2(){
        productCash2=driver.findElement(SECOND_CASH_PRICE).getText();
        productCash2 = productCash2.replaceAll("[^0-9]+", "");
        return productCash2;
    }

    public boolean ifEquals(String a, String b){
        if (a.equals(b)) {
            return true;
        }
        return true;
    }

    public boolean ifEquals(ArrayList<String> a, ArrayList<String> b){
        if (a.equals(b)) {
            return true;
        }
        return true;
    }

    public String firstNameProduct1(){
        productName1 = driver.findElement(FIRST_NAME_PRODUCT).getText();
        return productName1;
    }

    public String secondNameProduct2(){
        productName2 = driver.findElement(SECOND_NAME_PRODUCT).getText();
        return productName2;
    }

}
