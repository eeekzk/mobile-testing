package eeetests;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToMyList extends BaseTest {
    @Test(dataProvider = "getData")
    public void checkAddProductToMyList(String nameBuyList, String productName, String price, String amount, String comment) {
        this.driver.findElement(By.id("com.slava.buylist:id/button1")).click();
        this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView")).click();
        this.addProductToBuyList();
        String productNameInMyList = this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView[1]")).getText();
        Assert.assertEquals(productNameInMyList,productName);
    }
}
