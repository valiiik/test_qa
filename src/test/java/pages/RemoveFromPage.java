package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import selenium.EventFiringWebDriverWrapper;

import java.util.concurrent.TimeUnit;

/**
 * Created by valik on 3/25/15.
 */
public class RemoveFromPage extends BasePage {

    private static final By MOVE_TO_CART = By.xpath("//div[@class='block_title']/a");

    private static final By DELETE_FIRST_PRODUCT = By.xpath("//tr[@id='i_3544108']/td[@class='bordertd valigntd alignrighttd']/a");
    private static final By DELETE_SECOND_PRODUCT = By.xpath("//tr[@id='i_3894451']/td[@class='bordertd valigntd alignrighttd']/a");

    private static final By MOVE_TO_TEST = By.xpath("//div[@class='user_block']/a");
    private static final By GO_TO_WISHLIST = By.xpath("//div[@class='user_block']/div[@class='links_list']/ul/li[4]/a");

    //delete
    private static final By DELETE_WISHLIST1 = By.xpath("//li[@id='item_3544108']/div[@class='controls']/ul/li[3]/a");
    private static final By DELETE_WISHLIST1_CONFIRM = By.xpath("//div[@id='popup_content']/div[@class='callback_form']/div[2]/a");
    private static final By DELETE_WISHLIST2 = By.xpath("//li[@id='item_3894451']/div[@class='controls']/ul/li[3]/a");

    private static final By MOVE_TO_COMPARE = By.xpath("//div[@class='head_toolbar']/div[@class='width']/div[@class='right_block']/div[@class='compare_block']");
    private static final By DELETE_COMPARE = By.xpath("//div[@class='head_toolbar']/div[@class='width']/div[@class='right_block']/div[@class='compare_block']/div[@class='compare_list']/ul/li/a");

    public  RemoveFromPage(EventFiringWebDriverWrapper driver){
        super(driver);
        URL = "http://fotos.ua";
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void clearProductCart() throws InterruptedException {
        driver.findElement(MOVE_TO_CART).click();
        driver.findElement(DELETE_FIRST_PRODUCT).click();
        Thread.sleep(100);
        driver.findElement(DELETE_SECOND_PRODUCT).click();

    }

    public void clearWishList() throws InterruptedException {

        WebElement element = driver.findElement(MOVE_TO_TEST);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        driver.findElement(GO_TO_WISHLIST).click();
        driver.findElement(DELETE_WISHLIST1).click();
        driver.findElement(DELETE_WISHLIST1_CONFIRM).click();
        Thread.sleep(300);
        driver.findElement(DELETE_WISHLIST2).click();
        driver.findElement(DELETE_WISHLIST1_CONFIRM).click();
    }

    public void clearComparePage(){
        WebElement element1 = driver.findElement(MOVE_TO_COMPARE);
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(element1).build().perform();
        driver.findElement(DELETE_COMPARE).click();


    }

}
