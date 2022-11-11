package eeetests.myListTests;

import eeetests.BaseTest;
import data.TestData;
import org.testng.annotations.BeforeMethod;
import pageObjects.MyListPageObjects;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class EditProductTest extends BaseTest {

    public MyListPageObjects objects;

    @BeforeMethod
    public void setUp() {
        objects = new MyListPageObjects(driver);
    }

    @Test(dataProvider = "getData", dataProviderClass = TestData.class)
    public void checkEditProduct(String nameBuyList, String productName, String price, String amount, String comment, String edit) {
        steps.addBuyList();
        steps.addProductToBuyList();
        WebElement ele = objects.productMyList;
        elements.longPressAction(ele);
        objects.editProductButton.click();
        objects.commentInput.sendKeys(edit);
        objects.saveProductButton.click();
        assertEquals(objects.productCommentText.getText(),edit);
    }
}
