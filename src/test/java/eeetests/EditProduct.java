package eeetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditProduct extends BaseTest {
    @Test
    public void checkEditProduct() {
        this.addBuyList();
        this.addProductToBuyList();
        this.driver.findElement(By.id("com.slava.buylist:id/rr1")).click();
        WebElement ele = this.driver.findElement(By.id("com.slava.buylist:id/rr1"));
        this.longPressAction(ele);
        this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]")).click();
        this.driver.findElement(By.id("com.slava.buylist:id/editText4")).sendKeys(new CharSequence[]{"Edit comment"});
        this.driver.findElement(By.id("com.slava.buylist:id/button2")).click();
        String commentText = this.driver.findElement(By.id("com.slava.buylist:id/str1")).getText();
        Assert.assertEquals(commentText,"Edit comment");
    }
}
