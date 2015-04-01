package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import selenium.EventFiringWebDriverWrapper;

import java.util.concurrent.TimeUnit;

/**
 * Created by valik on 3/2/15.
 */
public class SearchPage extends BasePage {

        //add to wishlist
        private static final By SEARCH_LOCATOR = By.id("head_search_input");
        private static final By ADD_TO_WISHLIST_LOCATOR = By.xpath("//td[@class='price_block']/ul/li[2]/a");
        private static final By ENTER_SAVE_BUTTON = By.xpath("//div[@class='auth_submit']/input[@class='btn']");

        //go to wishlist
        private static final By MOVE_TO_TEST = By.xpath("//div[@class='user_block']/a");
        private static final By GO_TO_WISHLIST = By.xpath("//div[@class='user_block']/div[@class='links_list']/ul/li[4]/a");

        //find item
        private static final By PRESENCE_OF_ITEM_LOCATOR = By.xpath("//ul[@class='ul lk_wishlist_products']/li");

        public SearchPage(EventFiringWebDriverWrapper driver){
            super(driver);
            URL = "http://fotos.ua";
            driver.get(URL);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }

        public void searchProduct(String search){
            driver.findElement(SEARCH_LOCATOR).click();
            driver.findElement(SEARCH_LOCATOR).sendKeys(search + Keys.ENTER);
        }

        public void addToWishList(){
            driver.findElement(ADD_TO_WISHLIST_LOCATOR).click();
            driver.findElement(ENTER_SAVE_BUTTON).click();
        }


        public void whishList(){
            WebElement element = driver.findElement(MOVE_TO_TEST);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            driver.findElement(GO_TO_WISHLIST).click();
        }

        public boolean itemsPresence() {
            return driver.findElements(PRESENCE_OF_ITEM_LOCATOR).size()>=2;
        }

}
