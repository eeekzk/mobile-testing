package eeetests.myListTests;

import com.google.common.collect.ImmutableMap;
import eeetests.BaseTest;
import eeetests.pageObjects.MyListPageObjects;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

public class AddNewCategoryTest extends BaseTest {
    @Test
    public void checkAddCategory() {
        //use Drag&Drop
        MyListPageObjects objects = new MyListPageObjects(this.driver);
        objects.actionMenuButton.click();
        objects.settingsButton.click();
        this.driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Categories List\"));")).click();
        objects.categoriesListButton.click();
        objects.editCategoryName.sendKeys("New Category");
        objects.okButton.click();
        this.driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"New Category\"));"));
        this.driver.executeScript("mobile: dragGesture", ImmutableMap.of("elementId", ((RemoteWebElement)objects.sourceNewCategory).getId(), "endX", 600, "endY", 1200));
    }
}