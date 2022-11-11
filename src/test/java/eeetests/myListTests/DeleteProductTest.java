package eeetests.myListTests;

import eeetests.BaseTest;
import pageObjects.MyListPageObjects;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteProductTest extends BaseTest {

    @Test
    public void checkDeleteProduct() {
        MyListPageObjects objects = new MyListPageObjects(this.driver);
        this.steps.addBuyList();
        this.steps.addProductToBuyList();
        WebElement ele = objects.productMyList;
        this.elements.longPressAction(ele);
        objects.deleteProductButton.click();
        objects.okButton.click();
   }
}
