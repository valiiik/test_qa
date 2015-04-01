package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import selenium.EventFiringWebDriverWrapper;

import java.util.concurrent.TimeUnit;

/**
 * Created by valik on 3/27/15.
 */
public class NegativeLoginTest extends BasePage {

    //find create "new user" form
    private static final By ENTER_CABINET = By.xpath("//div[@class='user_block']/a");
    private static final By CREATE_NEW_USER = By.xpath("//form[@id='user_auth_form']/div[@class='auth_submit']/ul/li[2]/a");

    //all field
    private static final By USER_NAME_FIELD = By.xpath("//form[@id='register_form']/div[1]/div[@class='input inpt inpt-gray']/input"); //user name field
    private static final By USER_EMAIL_FIELD = By.xpath("//form[@id='register_form']/div[2]/div[@class='input inpt inpt-gray']/input");
    private static final By FIRST_PASS_FIELD = By.xpath("//form[@id='register_form']/div[3]/div[2]/div[@class='input inpt inpt-gray']/input");
    private static final By SECOND_PASS_FIELD = By.xpath("//form[@id='register_form']/div[3]/div[3]/div[@class='input inpt inpt-gray']/input");

    //all error
    private static final By ERROR_NAME_FIELD = By.xpath("//form[@id='register_form']/div[1]/div[@class='field_title']/span");
    private static final By ERROR_EMAIL_FIELD = By.xpath("//form[@id='register_form']/div[2]/div[@class='field_title']/span");
    private static final By ERROR_PASS_FIELD = By.xpath("//form[@id='register_form']/div[3]/div[@class='error_text']"); //gettext "pass"
    private static final By ERROR_PASS_FIELD2 = By.xpath("//form[@id='register_form']/div[3]/div[@class='error_text']"); //gettext "one more pass"
    private static final By ERROR_PASS_FIELD3 = By.xpath("//form[@id='register_form']/div[3]/div[@class='error_text']"); //gettext "pass"

    //some 'element' have field 'after error'.
    private static final By USER_NAME_FIELD_AFTER_NAME_ERROR = By.xpath("//form[@id='register_form']/div[1]/div[@class='input inpt inpt-gray inpt-error']/input");
    private static final By USER_EMAIL_FIELD_AFTER_EMAIL_ERROR = By.xpath("//form[@id='register_form']/div[2]/div[@class='input inpt inpt-gray inpt-error']/input");
    private static final By FIRST_PASS_FIELD_AFTER_PASS_ERROR = By.xpath("//form[@id='register_form']/div[3]/div[2]/div[@class='input inpt inpt-gray inpt-error']/input");
    private static final By SECOND_PASS_FIELD_AFTER_PASS_ERROR = By.xpath("//form[@id='register_form']/div[3]/div[3]/div[@class='input inpt inpt-gray inpt-error']/input");

    //sendKeys
    private String name = "Valentyn";
    private String email = "test_qa_valentyn@ukr.net";
    private String pass = "123456";

    //pass Error
    private String passError;
    private String secondPassFieldError;
    private String thirdPassFieldError;

    //emailError
    private String errorEmail1;
    private String errorEmail2;


    //nameError
    private String errorName1;
    private String errorName2;
    private String errorName3;
    private String errorName4;



    public NegativeLoginTest(EventFiringWebDriverWrapper driver){
        super(driver);
        URL = "http://fotos.ua";
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public String enterJustName(){
        driver.findElement(ENTER_CABINET).click();
        driver.findElement(CREATE_NEW_USER).click();
        driver.findElement(USER_NAME_FIELD).click();
        driver.findElement(USER_NAME_FIELD).sendKeys(name + Keys.ENTER);
        errorEmail1 = driver.findElement(ERROR_EMAIL_FIELD).getText();
        return errorEmail1;
    }

    public String enterNameAndEmail(){
        driver.findElement(USER_EMAIL_FIELD_AFTER_EMAIL_ERROR).sendKeys(email + Keys.ENTER);
        passError = driver.findElement(ERROR_PASS_FIELD).getText();
        return passError;
    }

    public String enterOnePassField(){
        driver.findElement(FIRST_PASS_FIELD_AFTER_PASS_ERROR).sendKeys(pass, Keys.ENTER);
        secondPassFieldError = driver.findElement(ERROR_PASS_FIELD2).getText();
        return secondPassFieldError;
    }

    public String enterSecondPassField(){
        driver.findElement(FIRST_PASS_FIELD).clear();
        driver.findElement(SECOND_PASS_FIELD_AFTER_PASS_ERROR).click();
        driver.findElement(SECOND_PASS_FIELD_AFTER_PASS_ERROR).sendKeys(pass, Keys.ENTER);
        thirdPassFieldError = driver.findElement(ERROR_PASS_FIELD3).getText();
        return thirdPassFieldError;

    }

    public String enterJustEmail(){
        driver.findElement(USER_NAME_FIELD).click();
        driver.findElement(USER_NAME_FIELD).clear();
        driver.findElement(SECOND_PASS_FIELD).click();
        driver.findElement(SECOND_PASS_FIELD).clear();
        driver.findElement(USER_EMAIL_FIELD).click(); //?
        driver.findElement(USER_EMAIL_FIELD).clear();
        driver.findElement(USER_EMAIL_FIELD).sendKeys(email, Keys.ENTER);//?
        errorName1 = driver.findElement(ERROR_NAME_FIELD).getText();
        return errorName1;
    }

    public String enterJustPass(){
        driver.findElement(USER_EMAIL_FIELD).clear();//?
        driver.findElement(FIRST_PASS_FIELD).click();
        driver.findElement(FIRST_PASS_FIELD).sendKeys(pass, Keys.ENTER);
        errorName2 = driver.findElement(ERROR_NAME_FIELD).getText();
        return errorName2;
    }

    public String enterEmailAndPass(){
        driver.findElement(USER_EMAIL_FIELD).click();
        driver.findElement(USER_EMAIL_FIELD).sendKeys(email, Keys.ENTER);
        errorName3 = driver.findElement(ERROR_NAME_FIELD).getText();
        return errorName3;
    }

    public String enterEmailAddTwoPass(){
        driver.findElement(SECOND_PASS_FIELD).click();
        driver.findElement(SECOND_PASS_FIELD).sendKeys(pass, Keys.ENTER);
        errorName4 = driver.findElement(ERROR_NAME_FIELD).getText();
        return errorName4;
    }

    public String enterNameAndTwoPass(){
        driver.findElement(USER_EMAIL_FIELD).click();
        driver.findElement(USER_EMAIL_FIELD).clear();
        driver.findElement(USER_NAME_FIELD_AFTER_NAME_ERROR).click();
        driver.findElement(USER_NAME_FIELD_AFTER_NAME_ERROR).sendKeys(name, Keys.ENTER);
        errorEmail2 = driver.findElement(ERROR_EMAIL_FIELD).getText();
        return errorEmail2;
    }
}

