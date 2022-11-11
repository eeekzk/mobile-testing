package eeetests.steps;

import eeetests.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageObjects.StepsPageObjects;

public class ShoppingSteps extends BaseTest {

    private final AndroidDriver driver;

    public ShoppingSteps(AndroidDriver driver) {
        this.driver = driver;
    }

    @Step()
    public void addBuyList() {
        StepsPageObjects objects = new StepsPageObjects(driver);
        objects.editNameBuyList.sendKeys("IKEA");
        objects.addBuyListButton.click();
    }

    @Step("addProductToBuyList step")
    public void addProductToBuyList() {
        StepsPageObjects objects = new StepsPageObjects(driver);
        objects.productName.sendKeys("Sofa");
        objects.productPrice.sendKeys("123");
        objects.productAmount.sendKeys("1");
        objects.productComment.sendKeys("Bedroom");
        objects.productValue.click();
        objects.productUnit.click();
        objects.productCategory.click();
        this.driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Confection\"));")).click();
        objects.addBuyListButton.click();
    }
}
