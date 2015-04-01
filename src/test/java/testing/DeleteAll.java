package testing;

import org.testng.annotations.Test;
import pages.RemoveFromPage;

/**
 * Created by valik on 3/25/15.
 */
public class DeleteAll extends BasicTest {

    @Test

    public void deleteAll() throws InterruptedException {
        RemoveFromPage remove = new RemoveFromPage(driver);

        remove.clearProductCart();
        remove.clearWishList();
        remove.clearComparePage();


    }
}
