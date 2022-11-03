package eeetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToMyListFromBuyList extends BaseTest {
    @Test(dataProvider = "getData")
    public void checkAddProductToMyListFromBuyList(String nameBuyList, String productName, String price, String amount, String comment) {
        this.addBuyList();
        this.addProductToBuyList();
        this.driver.findElement(By.id("com.slava.buylist:id/rr1")).click();
        WebElement ele = this.driver.findElement(By.id("com.slava.buylist:id/rr1"));
        this.longPressAction(ele);
        this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]")).click();
        this.driver.findElement(By.id("com.slava.buylist:id/button1")).click();
        this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]")).click();
        String productNameInMyList = this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView")).getText();
        Assert.assertEquals(productNameInMyList,productName);
    }
}
