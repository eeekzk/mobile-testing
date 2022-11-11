package eeetests.buyListTests;

import eeetests.BaseTest;
import data.TestData;
import pageObjects.BuyPageObjects;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class AddProductToBuyListTest extends BaseTest {

    @Test(dataProvider = "getData", dataProviderClass = TestData.class)
    public void checkAddProductToBuyList(String nameBuyList, String productName, String price, String amount, String comment, String edit) {
        BuyPageObjects objects = new BuyPageObjects(driver);
        steps.addBuyList();
        steps.addProductToBuyList();
        assertEquals(objects.listName.getText(), nameBuyList);
        assertEquals(objects.productNameInBuyList.getText(),productName);
    }
}
