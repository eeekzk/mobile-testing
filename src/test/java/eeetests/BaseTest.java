package eeetests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {
        //Appium code -> Appium Server -> Mobile
        this.service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        this.service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("autoGrantPermissions", "true");
        options.setCapability("fullReset", "true");
        options.setDeviceName("TestEmulator");
        options.setApp("/Users/eeekzk/IdeaProjects/TestingApp/src/test/java/resources/ShoppingList-1.6.apk");
        this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
    }

    public void longPressAction(WebElement ele) {
        this.driver.executeScript("mobile: longClickGesture", new Object[]{ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(), "duration", 2000)});
    }

    public void scrollToEndAction() {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean)this.driver.executeScript("mobile: scrollGesture", new Object[]{ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0)});
        } while(canScrollMore);
    }

    public void addBuyList() {
        this.driver.findElement(By.id("com.slava.buylist:id/editText1")).sendKeys(new CharSequence[]{"IKEA"});
        this.driver.findElement(By.id("com.slava.buylist:id/button2")).click();
    }
    public void addProductToBuyList() {
        this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.EditText")).sendKeys(new CharSequence[]{"Sofa"});
        this.driver.findElement(By.id("com.slava.buylist:id/editText2")).sendKeys(new CharSequence[]{"123"});
        this.driver.findElement(By.id("com.slava.buylist:id/editText3")).sendKeys(new CharSequence[]{"1"});
        this.driver.findElement(By.id("com.slava.buylist:id/editText4")).sendKeys(new CharSequence[]{"Bedroom"});
        this.driver.findElement(By.id("com.slava.buylist:id/spinner1")).click();
        this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[10]")).click();
        this.driver.findElement(By.id("com.slava.buylist:id/spinner2")).click();
        this.driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Confection\"));")).click();
        this.driver.findElement(By.id("com.slava.buylist:id/button2")).click();
    }

    @DataProvider
    public Object[][] getData() {
        HashMap<String, String> data = new HashMap<>();
        data.put("nameBuyList","IKEA");
        data.put("productName","Sofa");
        data.put("price","123");
        data.put("amount","1");
        data.put("comment","Bedroom");
        return new Object[][] {{"IKEA", "Sofa", "123", "1", "Bedroom"}};
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
        this.service.stop();
    }
}
