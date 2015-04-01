package testing;

import addons.LogForTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NegativeLoginTest;

/**
 * Created by valik on 3/27/15.
 */
public class NegativeRegistrationTest extends BasicTest {


    @Test
    public void negativeRegistrationTest() {
        //without email
        NegativeLoginTest negative = new NegativeLoginTest(driver);

        String email1 = negative.enterJustName();
        Assert.assertEquals(email1, "Заполните поле \"E-mail\"", LogForTest.info("Expected results of the empty field \"email\" - true (enter just name)" ));

        //without pass
        String pass = negative.enterNameAndEmail();
        Assert.assertEquals(pass, "Заполните поле \"Пароль\"", LogForTest.info("Expected results of the empty field \"pass\" - true (enter name and email)"));

        String pass2 = negative.enterOnePassField();
        Assert.assertEquals(pass2, "Заполните поле \"Пароль еще раз\"", LogForTest.info("Expected results of the empty field \"second field pass\" - true (enter name, email, pass)"));

        String pass3 = negative.enterSecondPassField();
        Assert.assertEquals(pass3, "Заполните поле \"Пароль\"", LogForTest.info("Expected results of the empty field \"first field pass\" - true (enter name, email, second field pass)"));

        //without name
        String name1 = negative.enterJustEmail();
        Assert.assertEquals(name1, "Заполните поле \"Имя\"", LogForTest.info("Expected results of the empty field \"name\" - true (enter just email)"));

        String name2 = negative.enterJustPass();
        Assert.assertEquals(name2, "Заполните поле \"Имя\"", LogForTest.info("Expected results of the empty field \"name\" - true (enter just pass)"));

        String name3 = negative.enterEmailAndPass();
        Assert.assertEquals(name3, "Заполните поле \"Имя\"", LogForTest.info("Expected results of the empty field \"name\" - true (enter email and pass)"));

        String name4 = negative.enterEmailAddTwoPass();
        Assert.assertEquals(name4, "Заполните поле \"Имя\"", LogForTest.info("Expected results of the empty field \"name\" - true (enter all field, without name)"));

        //without email2
        String email2 = negative.enterNameAndTwoPass();
        Assert.assertEquals(email2, "Заполните поле \"E-mail\"", LogForTest.info("Expected results of the empty field \"email\" - true (enter all field, without email)"));

        System.out.println("\n");
    }
}
