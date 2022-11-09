package eeetests.myListTests;

import eeetests.BaseTest;
import eeetests.data.TestData;
import eeetests.pageObjects.MyListPageObjects;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToMyListTest extends BaseTest {
    @Test(dataProvider = "getData", dataProviderClass = TestData.class)
    public void checkAddProductToMyList(String nameBuyList, String productName, String price, String amount, String comment, String edit) {
        MyListPageObjects objects = new MyListPageObjects(this.driver);
        objects.actionMenuButton.click();
        objects.productInput.click();
        this.steps.addProductToBuyList();
        Assert.assertEquals(objects.productNameInBuyList.getText(),productName);
    }
}
