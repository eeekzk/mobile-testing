package elements;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class ElementsUtils {

    private final AndroidDriver driver;

    public ElementsUtils(AndroidDriver driver) {
        this.driver = driver;
    }

    public void longPressAction(WebElement ele) {
        this.driver.executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(), "duration", 2000));
    }

    public void dragDrop(WebElement ele) {
        this.driver.executeScript("mobile: dragGesture", ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(), "endX", 600, "endY", 1200));
    }

    public void back() {
        this.driver.navigate().back();
    }
}
