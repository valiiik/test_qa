package testing;

import addons.LogForTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToBuyFromWishList;


/**
 * Created by valik on 3/3/15.
 */
public class BuyProduct extends BasicTest {
    @Test
    public void BuyItemsFromWishList(){
        AddToBuyFromWishList buy = new AddToBuyFromWishList(driver);
        buy.addToBuy();
        buy.shopCart();
        Assert.assertTrue(buy.itemsPresence(), LogForTest.info("Products being compared are present at comparison page "));
    }


}
