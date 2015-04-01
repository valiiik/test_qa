package pages;

import org.openqa.selenium.By;
import selenium.EventFiringWebDriverWrapper;

import java.util.concurrent.TimeUnit;

/**
 * Created by valik on 3/9/15.
 */
public class TopMenuBuyProduct extends BasePage {

    private static final By TOP_MENU = By.xpath ("//table[@class='main_menu']/tbody/tr/td[6]/div/a");
    private static final By AUTO_ELECTRONICS_MENU = By.id("subcategory_916");
    private static final By GPS_MENU = By.xpath("//td[@class='sub_rubric_container']/div[@id='main_subrubrics_916']/ul/li[2]/div/div[2]/a");

    private static final By LIST_VIEW = By.xpath("//div[@class='list_filters_links']/ul/li[2]");

    private static final By SORT_GPS_BY = By.xpath("//div[@class='list_filters_links']/ul[2]/li[2]/a");

    private static final By ADD_FIRST_GPS_TO_COMPARE = By.xpath("//div[@class='catalog_product_list view_list']/div[@id='item_3637111']/div[@class='info']/div[@class='price_block']/ul/li/a");
    private static final By ADD_SECOND_GPS_TO_COMPARE = By.xpath("//div[@class='catalog_product_list view_list']/div[@id='item_3855203']/div[@class='info']/div[@class='price_block']/ul/li/a");
    private static final By GO_TO_COMPARE_PAGE = By.xpath("//div[@class='catalog_product_list view_list']/div[@id='item_3855203']/div[@class='info']/div[@class='price_block']/ul/li/a");

    private static final By PRESENCE_OF_ITEM_LOCATOR = By.xpath("//table[@class='compare']/tbody/tr[2]");

    public TopMenuBuyProduct(EventFiringWebDriverWrapper driver){
        super(driver);
        URL = "http://fotos.ua";
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void searchGpsMenu(){
        driver.findElement(TOP_MENU).click();
        driver.findElement(AUTO_ELECTRONICS_MENU).click();
        driver.findElement(GPS_MENU).click();

    }
    public void listView(){
        driver.findElement(LIST_VIEW).click();
    }

    public void sortBy(){
        driver.findElement(SORT_GPS_BY).click();
    }

    public void addToCompare(){
        driver.findElement(ADD_FIRST_GPS_TO_COMPARE).click();
        driver.findElement(ADD_SECOND_GPS_TO_COMPARE).click();
        driver.findElement(GO_TO_COMPARE_PAGE).click();
    }

    public boolean itemsPresence() {
        return driver.findElements(PRESENCE_OF_ITEM_LOCATOR).size()>=1;
    }

}
