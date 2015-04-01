package testing;

import addons.LogForTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CompareProductCart;
import pages.CompareProductSearch;

/**
 * Created by valik on 3/5/15.
 */
public class ComparePrices extends BasicTest {

    @DataProvider
    public static Object[][] dp() {
        Object[][] dataArray = {{"INTEL Core i3-3250 LGA1155", "INTEL Core i5-4690K LGA1150"}};
        return dataArray;
    }

    @Test(dataProvider = "dp")
    public void comparePrices(String product1, String product2) {
        CompareProductSearch compare1 = new CompareProductSearch(driver);
        compare1.searchProduct(product1);
        String productSearch1 = compare1.searchProductPrice();
        compare1.searchProduct(product2);
        String productSearch2 = compare1.searchProductPrice();

        CompareProductCart compare2 = new CompareProductCart(driver);
        compare2.shopCart();
        String productCash1 = compare2.cashProductPrice1();
        String productCash2 = compare2.cashProductPrice2();

        Assert.assertTrue(compare2.ifEquals(productSearch1, productCash1), LogForTest.info("price of the first item converges. Test completed successful"));
        Assert.assertTrue(compare2.ifEquals(productSearch2, productCash2), LogForTest.info("price of the second item converges. Test completed successful"));


    }
}