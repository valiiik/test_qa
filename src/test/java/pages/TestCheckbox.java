package pages;

import org.openqa.selenium.By;
import selenium.EventFiringWebDriverWrapper;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by valik on 3/16/15.
 */
public class TestCheckbox extends BasePage {

    private static final By SEARCH_NOTEBOOK_LOCATOR1 = By.xpath("//table[@class='main_menu']/tbody/tr/td[4]/div/a");
    private static final By NOTEBOOK_MENU = By.id("subcategory_379");
    private static final By SEARCH_NOTEBOOK_LOCATOR2 = By.xpath("//td[@class='sub_rubric_container']/div[@id='main_subrubrics_379']/ul/li/div/div[3]/div/ul/li/a");

    private static final By CLICK_CHECKBOX1 = By.xpath("//form [@id = 'catalog_filter_form']/div[@id='filters_main']/div[4]/ul/li[1]/input");
    private static final By CLICK_CHECKBOX2 = By.xpath("//form [@id = 'catalog_filter_form']/div[@id='filters_main']/div[4]/ul/li[4]/input");

    private static final By STATUS_CHECKBOX1 = By.xpath("//form [@id = 'catalog_filter_form']/div[@id='filters_main']/div[4]/ul/li[1]");
    private static final By STATUS_CHECKBOX2 = By.xpath("//form [@id = 'catalog_filter_form']/div[@id='filters_main']/div[4]/ul/li[2]");
    private static final By STATUS_CHECKBOX3 = By.xpath("//form [@id = 'catalog_filter_form']/div[@id='filters_main']/div[4]/ul/li[3]");
    private static final By STATUS_CHECKBOX4 = By.xpath("//form [@id = 'catalog_filter_form']/div[@id='filters_main']/div[4]/ul/li[4]");
    private static final By STATUS_CHECKBOX5 = By.xpath("//form [@id = 'catalog_filter_form']/div[@id='filters_main']/div[4]/ul/li[5]");
    private static final By STATUS_CHECKBOX6 = By.xpath("//form [@id = 'catalog_filter_form']/div[@id='filters_main']/div[4]/ul/li[6]");
    private static final By STATUS_CHECKBOX7 = By.xpath("//form [@id = 'catalog_filter_form']/div[@id='filters_main']/div[4]/ul/li[7]");
    private static final By STATUS_CHECKBOX8 = By.xpath("//form [@id = 'catalog_filter_form']/div[@id='filters_main']/div[4]/ul/li[8]");
    private static final By STATUS_CHECKBOX9 = By.xpath("//form [@id = 'catalog_filter_form']/div[@id='filters_main']/div[4]/ul/li[9]");

    private ArrayList<String> status = new ArrayList<String>();

    public TestCheckbox(EventFiringWebDriverWrapper driver){
        super(driver);
        URL = "http://fotos.ua";
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void searchNotebook(){
        driver.findElement(SEARCH_NOTEBOOK_LOCATOR1).click();
        driver.findElement(NOTEBOOK_MENU).click();
        driver.findElement(SEARCH_NOTEBOOK_LOCATOR2).click();
    }


    public void checkboxClick(){
        driver.findElement(CLICK_CHECKBOX1).click();
        driver.findElement(CLICK_CHECKBOX2).click();
    }


    public ArrayList<String> checkboxStatus(){
        status.add(driver.findElement(STATUS_CHECKBOX1).getAttribute("class"));
        status.add(driver.findElement(STATUS_CHECKBOX2).getAttribute("class"));
        status.add(driver.findElement(STATUS_CHECKBOX3).getAttribute("class"));
        status.add(driver.findElement(STATUS_CHECKBOX4).getAttribute("class"));
        status.add(driver.findElement(STATUS_CHECKBOX5).getAttribute("class"));
        status.add(driver.findElement(STATUS_CHECKBOX6).getAttribute("class"));
        status.add(driver.findElement(STATUS_CHECKBOX7).getAttribute("class"));
        status.add(driver.findElement(STATUS_CHECKBOX8).getAttribute("class"));
        status.add(driver.findElement(STATUS_CHECKBOX9).getAttribute("class"));
        return status;
    }
}
