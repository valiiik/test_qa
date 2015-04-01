package pages;

import org.openqa.selenium.By;
import selenium.EventFiringWebDriverWrapper;

import java.util.concurrent.TimeUnit;

/**
 * Created by valik on 3/3/15.
 */
public class AddToBuyFromWishList extends BasePage {

    private static final By ADD_TO_BUY_ALL = By.xpath("//td[@class='main_info_block_table_td']/div[@class='lk_wishlist_detail']/div[@class='add_all2cart']/a");
    private static final By PRESENCE_OF_ITEM_LOCATOR = By.xpath("//div[@class='items-box']/table/tbody");
    private static final By GO_TO_SHOPCART = By.xpath("//div[@class='block_title']/a");

    public AddToBuyFromWishList(EventFiringWebDriverWrapper driver)
    {
        super (driver);
        URL = "http://fotos.ua/user/wishlist/";
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void addToBuy(){

        driver.findElement(ADD_TO_BUY_ALL).click();
    }

    public void shopCart(){
        driver.findElement(GO_TO_SHOPCART).click();

    }

    public boolean itemsPresence()
    {
        return driver.findElements(PRESENCE_OF_ITEM_LOCATOR).size()>1;
    }


}
