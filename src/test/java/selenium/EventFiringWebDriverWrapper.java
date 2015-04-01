package selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.List;
import java.util.Set;

/**
 * Created by valik on 3/8/15.
 */
public class EventFiringWebDriverWrapper extends EventFiringWebDriver {
   // private WebDriver driver;
    public EventFiringWebDriverWrapper(WebDriver driver) {
        super(driver);
    }

    @Override
    public EventFiringWebDriver register(WebDriverEventListener eventListener) {
        return super.register(eventListener);
    }

    @Override
    public EventFiringWebDriver unregister(WebDriverEventListener eventListener) {
        return super.unregister(eventListener);
    }

    @Override
    public WebDriver getWrappedDriver() {
        return super.getWrappedDriver();
    }

    @Override
    public void get(String url) {
        super.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return super.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {

        return super.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return super.findElement(by);
    }

    @Override
    public String getPageSource() {
        return super.getPageSource();
    }

    @Override
    public void close() {
        super.close();
    }


    @Override
    public void quit() {
        super.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return super.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return super.getWindowHandle();
    }

    @Override
    public Object executeScript(String script, Object... args) {
        return super.executeScript(script, args);
    }

    @Override
    public Object executeAsyncScript(String script, Object... args) {
        return super.executeAsyncScript(script, args);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return super.getScreenshotAs(target);
    }

    @Override
    public TargetLocator switchTo() {
        return super.switchTo();
    }

    @Override
    public Navigation navigate() {
        return super.navigate();
    }

    @Override
    public Options manage() {
        return super.manage();
    }

    @Override
    public Keyboard getKeyboard() {
        return super.getKeyboard();
    }

    @Override
    public Mouse getMouse() {
        return super.getMouse();
    }

    @Override
    public TouchScreen getTouch() {
        return super.getTouch();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
