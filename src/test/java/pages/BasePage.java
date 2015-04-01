package pages;

import selenium.EventFiringWebDriverWrapper;

/**
 * Created by valik on 3/2/15.
 */
public abstract class BasePage {
    protected String URL = "http://fotos.ua/";
    protected EventFiringWebDriverWrapper driver;

    public BasePage(EventFiringWebDriverWrapper driver){
        this.driver = driver;
    }
}
