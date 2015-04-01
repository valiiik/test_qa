package testing;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CompareProductCart;
import pages.CompareProductSearch;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by valik on 3/13/15.
 */
public class ComparePricesWithDB extends BasicTest {


    @DataProvider
    public static Object[][] dp() {
        Object[][] dataArray = {{"INTEL Core i3-3250 LGA1155", "INTEL Core i5-4690K LGA1150"}};
        return dataArray;
    }

    @Test(dataProvider = "dp")
    public void comparePrices(String product1, String product2) {

        //imitation db
        Map<String, String> mapList = new HashMap<String, String>();

        mapList.put("Код: 82508-584885", "Intel Core i3-3250 LGA1155, 3.5GHz, Box (BX80637I33250SR0YX)");
        mapList.put("Код: 37362-917287", "Intel Core i5-4690K LGA1150, 3.5GHz, Box (BX80646I54690K)");

        CompareProductSearch compareSearch = new CompareProductSearch(driver);
        compareSearch.searchProduct(product1);
        String SearchName1 = compareSearch.searchCodeProduct();
        String productName1 = mapList.get(SearchName1);


        compareSearch.searchProduct(product2);
        String SearchName2 = compareSearch.searchCodeProduct();
        String productName2 = mapList.get(SearchName2);

        CompareProductCart compareCart = new CompareProductCart(driver);
        compareCart.shopCart();
        Assert.assertEquals(productName1, compareCart.firstNameProduct1(), "Product Corei3 is present in DB");
        Assert.assertEquals(productName2, compareCart.secondNameProduct2(), "Product Corei5 is present in DB");

      //  Assert.assertTrue(compareCart.ifEquals(productName1, compareCart.firstNameProduct1()), LogForTest.info("Product Corei3 is present in DB"));
    //    Assert.assertTrue(compareCart.ifEquals(productName2, compareCart.secondNameProduct2()), LogForTest.info("Product Corei5 is present in DB"));


    }
}
