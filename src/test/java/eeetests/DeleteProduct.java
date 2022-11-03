package eeetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteProduct extends BaseTest {
    @Test
    public void checkDeleteProduct() {
        this.addBuyList();
        this.addProductToBuyList();
        this.driver.findElement(By.id("com.slava.buylist:id/rr1")).click();
        WebElement ele = this.driver.findElement(By.id("com.slava.buylist:id/rr1"));
        this.longPressAction(ele);
        this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]")).click();
        this.driver.findElement(By.id("android:id/button1")).click();
   }
}
