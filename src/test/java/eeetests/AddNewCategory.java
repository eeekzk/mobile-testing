package eeetests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

public class AddNewCategory extends BaseTest {
    @Test
    public void checkAddCategory() {
        //use Drag&Drop
        this.driver.findElement(By.id("com.slava.buylist:id/button1")).click();
        this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]")).click();
        this.driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Categories List\"));")).click();
        this.driver.findElement(By.id("com.slava.buylist:id/button2")).click();
        this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.EditText")).sendKeys(new CharSequence[]{"New Category"});
        this.driver.findElement(By.id("android:id/button1")).click();
        this.driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"New Category\"));"));
        WebElement source = this.driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout[16]/android.widget.RelativeLayout/android.widget.ImageView[1]"));
        this.driver.executeScript("mobile: dragGesture", new Object[]{ImmutableMap.of("elementId", ((RemoteWebElement)source).getId(), "endX", 600, "endY", 1200)});
    }
}
