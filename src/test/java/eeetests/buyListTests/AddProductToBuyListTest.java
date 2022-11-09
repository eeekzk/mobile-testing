package eeetests.buyListTests;

import eeetests.BaseTest;
import eeetests.data.TestData;
import eeetests.pageObjects.BuyPageObjects;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToBuyListTest extends BaseTest {
    @Test(dataProvider = "getData", dataProviderClass = TestData.class)
    public void checkAddProductToBuyList(String nameBuyList, String productName, String price, String amount, String comment, String edit) {
        BuyPageObjects objects = new BuyPageObjects(this.driver);
        this.steps.addBuyList();
        this.steps.addProductToBuyList();
        Assert.assertEquals(objects.listName.getText(), nameBuyList);
        Assert.assertEquals(objects.productNameInBuyList.getText(),productName);
    }
}
