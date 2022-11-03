package eeetests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToBuyList extends BaseTest {
    @Test(dataProvider = "getData")
    public void checkAddProductToBuyList(String nameBuyList, String productName, String price, String amount, String comment) {
        this.addBuyList();
        this.addProductToBuyList();
        String listName = this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView")).getText();
        Assert.assertEquals(listName,nameBuyList);
        String productNameInBuyList = this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView[1]")).getText();
        Assert.assertEquals(productNameInBuyList,productName);
    }
}
