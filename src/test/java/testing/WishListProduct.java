package testing;


import addons.LogForTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SearchPage;

/**
 * Created by valik on 3/2/15.
 */
public class WishListProduct extends BasicTest{

    @DataProvider
    public static Object[][] dp(){
        Object[][] dataArray = {{"INTEL Core i3-3250 LGA1155", "INTEL Core i5-4690K LGA1150"}};
        return dataArray;
    }

    @Test(dataProvider = "dp")
    public void addProductToWishList(String product1, String product2){
        SearchPage page1 = new SearchPage(driver);
        loginUser();
        page1.searchProduct(product1);
        page1.addToWishList();
        page1.searchProduct(product2);
        page1.addToWishList();
        page1.whishList();
        Assert.assertTrue(page1.itemsPresence(), LogForTest.info("Adding products are present in the wishlist "));

    }



}
