package testing;

import addons.LogForTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TopMenuBuyProduct;

/**
 * Created by valik on 3/9/15.
 */
public class TopMenu extends BasicTest {

    @Test
    public void topMenu() {
        TopMenuBuyProduct buyGPS = new TopMenuBuyProduct(driver);
        buyGPS.searchGpsMenu();
        buyGPS.listView();
        buyGPS.sortBy();
        buyGPS.addToCompare();
        Assert.assertTrue(buyGPS.itemsPresence(), LogForTest.info("Adding product are present in compare page"));

    }
}