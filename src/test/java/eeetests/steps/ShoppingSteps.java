package eeetests.steps;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ShoppingSteps {
    private final AndroidDriver driver;

    public ShoppingSteps(AndroidDriver driver) {
        this.driver = driver;
    }

    @Step("addBuyList step")
    public void addBuyList() {
        this.driver.findElement(By.id("com.slava.buylist:id/editText1")).sendKeys("IKEA");
        this.driver.findElement(By.id("com.slava.buylist:id/button2")).click();
    }

    @Step("addProductToBuyList step")
    public void addProductToBuyList() {
        this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.EditText")).sendKeys("Sofa");
        this.driver.findElement(By.id("com.slava.buylist:id/editText2")).sendKeys("123");
        this.driver.findElement(By.id("com.slava.buylist:id/editText3")).sendKeys("1");
        this.driver.findElement(By.id("com.slava.buylist:id/editText4")).sendKeys("Bedroom");
        this.driver.findElement(By.id("com.slava.buylist:id/spinner1")).click();
        this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[10]")).click();
        this.driver.findElement(By.id("com.slava.buylist:id/spinner2")).click();
        this.driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Confection\"));")).click();
        this.driver.findElement(By.id("com.slava.buylist:id/button2")).click();
    }
}
