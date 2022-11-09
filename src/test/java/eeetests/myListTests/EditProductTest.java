package eeetests.myListTests;

import eeetests.BaseTest;
import eeetests.data.TestData;
import eeetests.pageObjects.MyListPageObjects;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditProductTest extends BaseTest {
    @Test(dataProvider = "getData", dataProviderClass = TestData.class)
    public void checkEditProduct(String nameBuyList, String productName, String price, String amount, String comment, String edit) {
        MyListPageObjects objects = new MyListPageObjects(this.driver);
        this.steps.addBuyList();
        this.steps.addProductToBuyList();
        objects.productMyList.click();
        WebElement ele = objects.productMyList;
        this.elements.longPressAction(ele);
        objects.editProductButton.click();
        objects.commentInput.sendKeys(edit);
        objects.saveProductButton.click();
        Assert.assertEquals(objects.productCommentText.getText(),edit);
    }
}
