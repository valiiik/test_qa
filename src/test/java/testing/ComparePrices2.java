package testing;

import addons.LogForTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CompareProductCart;
import pages.CompareProductSearch;

import java.util.ArrayList;

/**
 * Created by valik on 3/12/15.
 */
public class ComparePrices2 extends BasicTest {

    @DataProvider
    public static Object[][] dp() {
        Object[][] dataArray = {{"INTEL Core i3-3250 LGA1155", "INTEL Core i5-4690K LGA1150"}};
        return dataArray;
    }

    @Test(dataProvider = "dp")
    public void comparePrices(String product1, String product2) {
        CompareProductSearch compare1 = new CompareProductSearch(driver);
        ArrayList<String> arr = new ArrayList<String>();
        ArrayList<String> arr2 = new ArrayList<String>();

        compare1.searchProduct(product1);
        arr.add(compare1.searchProductPrice());
        compare1.searchProduct(product2);
        arr.add(compare1.searchProductPrice());

        CompareProductCart compare2 = new CompareProductCart(driver);
        compare2.shopCart();
        arr2.add(compare2.cashProductPrice1());
        arr2.add(compare2.cashProductPrice2());

        Assert.assertTrue(compare2.ifEquals(arr, arr2), LogForTest.info("price of the first item converges. Test completed successful - ArrayList"));

    }
}
