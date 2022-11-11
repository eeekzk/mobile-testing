package eeetests.myListTests;

import eeetests.BaseTest;
import data.TestData;
import org.testng.annotations.BeforeMethod;
import pageObjects.MyListPageObjects;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class TakeProductFromMyListTest extends BaseTest {

    public MyListPageObjects objects;

    @BeforeMethod
    public void setUp() {
        objects = new MyListPageObjects(driver);
    }

    @Test(dataProvider = "getData", dataProviderClass = TestData.class)
    public void checkTakeProductFromMyList(String nameBuyList, String productName, String price, String amount, String comment, String edit) {
        steps.addBuyList();
        steps.addProductToBuyList();
        WebElement ele = objects.productMyList;
        elements.longPressAction(ele);
        objects.addToMyListButton.click();
        elements.longPressAction(ele);
        objects.deleteProductButton.click();
        objects.okButton.click();
        objects.actionMenuButton.click();
        objects.addFromMyListButton.click();
        assertEquals(objects.productNameInMyList.getText(),productName);
        objects.pickProduct.click();
        objects.saveProductButton.click();
        assertEquals(objects.productNameInBuyList.getText(),productName);
    }
}
