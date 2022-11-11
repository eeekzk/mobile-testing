package eeetests.buyListTests;

import eeetests.BaseTest;
import data.TestData;
import org.testng.annotations.BeforeMethod;
import pageObjects.BuyPageObjects;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class AddProductToBuyListTest extends BaseTest {

    public BuyPageObjects objects;

    @BeforeMethod
    public void setUp() {
        objects = new BuyPageObjects(driver);
    }

    @Test(dataProvider = "getData", dataProviderClass = TestData.class)
    public void checkAddProductToBuyList(String nameBuyList, String productName, String price, String amount, String comment, String edit) {
        steps.addBuyList();
        steps.addProductToBuyList();
        assertEquals(objects.listName.getText(), nameBuyList);
        assertEquals(objects.productNameInBuyList.getText(),productName);
    }
}
