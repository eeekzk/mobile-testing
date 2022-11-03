package eeetests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditBuyList extends BaseTest{
    @Test(dataProvider = "getData")
    public void checkEditBuyList(String nameBuyList, String productName, String price, String amount, String comment) {
        this.addBuyList();
        String listName = this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView")).getText();
        Assert.assertEquals(listName,nameBuyList);
        this.driver.navigate().back();
        this.driver.navigate().back();
        String listTitle = this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1]")).getText();
        Assert.assertEquals(listTitle,nameBuyList);
        this.driver.findElement(By.id("com.slava.buylist:id/imageView2")).click();
        this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.EditText")).clear();
        this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.EditText")).sendKeys(new CharSequence[]{"Edit name"});
        this.driver.findElement(By.id("android:id/button1")).click();
        String editName = this.driver.findElement(By.id("com.slava.buylist:id/title")).getText();
        Assert.assertEquals(editName,"Edit name");
    }
}
