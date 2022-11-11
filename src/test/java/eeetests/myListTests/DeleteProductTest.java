package eeetests.myListTests;

import eeetests.BaseTest;
import org.testng.annotations.BeforeMethod;
import pageObjects.MyListPageObjects;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteProductTest extends BaseTest {

    public MyListPageObjects objects;

    @BeforeMethod
    public void setUp() {
        objects = new MyListPageObjects(driver);
    }

    @Test
    public void checkDeleteProduct() {
        steps.addBuyList();
        steps.addProductToBuyList();
        WebElement ele = objects.productMyList;
        elements.longPressAction(ele);
        objects.deleteProductButton.click();
        objects.okButton.click();
   }
}
