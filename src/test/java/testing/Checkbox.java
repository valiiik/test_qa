package testing;

import addons.LogForTest;
import org.testng.annotations.Test;
import pages.TestCheckbox;

import java.util.ArrayList;

/**
 * Created by valik on 3/17/15.
 */
public class Checkbox extends BasicTest {
    @Test

    public void Checkbox() {
        ArrayList<String> arr = new ArrayList<String>();
        for (int i = 0; i <= 8; i++) {
            arr.add("");
        }

        TestCheckbox testCheck = new TestCheckbox(driver);
        testCheck.searchNotebook();
        testCheck.checkboxClick();

        ArrayList<String> arr2 = new ArrayList<String>(testCheck.checkboxStatus());

        for (int i = 0; i <= 8; i++) {
            if (arr2.get(i).equals(arr.get(i))) {
                LogForTest.info("checkbox №" + (i+1) + " Is UnChecked");
            }
            else {
                LogForTest.info("checkbox №" + (i+1) + " Is Checked");
            }
        }
    }
}
