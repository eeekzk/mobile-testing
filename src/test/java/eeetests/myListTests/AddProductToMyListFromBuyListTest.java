package eeetests.myListTests;

import eeetests.BaseTest;
import data.TestData;
import org.testng.annotations.BeforeMethod;
import pageObjects.MyListPageObjects;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class AddProductToMyListFromBuyListTest extends BaseTest {

    public MyListPageObjects objects;

    @BeforeMethod
    public void setUp() {
        objects = new MyListPageObjects(driver);
    }

    @Test(dataProvider = "getData", dataProviderClass = TestData.class)
    public void checkAddProductToMyListFromBuyList(String nameBuyList, String productName, String price, String amount, String comment, String edit) {
        steps.addBuyList();
        steps.addProductToBuyList();
        WebElement ele = objects.productMyList;
        elements.longPressAction(ele);
        objects.addToMyListButton.click();
        objects.actionMenuButton.click();
        objects.addFromMyListButton.click();
        assertEquals(objects.productNameInMyList.getText(),productName);
    }
}
